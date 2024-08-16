
-- 연습문제
--[문제 1] 기말고사 과목별 평균이 높은 3과목을 검색하시오
--테이블 : COURSE, SCORE
--컬럼 : ROWNUM, CNO, CNAME, RESULT
SELECT cname, 평균  -- 'cname'은 과목명, '평균'은 과목별 평균 점수를 의미
FROM (
    SELECT cname, AVG(result) AS 평균  -- 각 과목의 평균 점수를 계산하여 '평균'이라는 별칭으로 부여
    FROM course
    JOIN score USING (cno)  -- 과목 번호(CNO)를 기준으로 COURSE와 SCORE 테이블을 조인하여 각 과목의 성적을 연결
    GROUP BY cname  -- 과목명(CNAME)별로 그룹화하여 과목별로 평균 성적을 계산
    ORDER BY AVG(result) DESC)  -- 계산된 평균 성적을 내림차순으로 정렬하여 높은 점수 순으로 정렬
WHERE ROWNUM <= 3;  -- 상위 3개의 과목만 선택. ROWNUM은 정렬 후의 결과에서 순서를 매기고 상위 3개의 결과만 필터링
-- 다른 답안 1 ------------------------
SELECT ROWNUM, tt.*  -- ROWNUM과 tt.*로 서브쿼리에서 선택된 모든 컬럼을 가져옴
FROM (
    SELECT cno, cname, AVG(result)  -- 과목 번호(cno), 과목명(cname), 그리고 평균 점수를 계산하여 선택
    FROM course
    JOIN score USING (cno)  -- 과목 번호(cno)를 기준으로 COURSE와 SCORE 테이블을 조인
    GROUP BY cno, cname  -- 과목 번호와 과목명으로 그룹화하여 과목별로 평균 성적을 계산
    ORDER BY 3 DESC  -- 세 번째 컬럼인 평균 점수를 기준으로 내림차순 정렬
) tt  -- 서브쿼리에서 계산된 결과를 'tt'라는 별칭으로 저장
WHERE ROWNUM <= 3;  -- 상위 3개의 과목만 선택. ROWNUM을 사용해 정렬된 결과에서 상위 3개의 결과만 필터링
-- 다른 답안 2 ------------------------
SELECT cno, cname, result  -- 과목 번호(cno), 과목명(cname), 과목의 평균 성적(result)을 선택
FROM course
JOIN (
    SELECT cno, ROUND(AVG(result), 2) AS result  -- 각 과목의 평균 성적을 소수 둘째 자리에서 반올림하여 'result'로 선택
    FROM score
    GROUP BY cno  -- 과목 번호(cno)별로 그룹화하여 과목별 평균 성적을 계산
    ORDER BY result DESC  -- 평균 성적을 내림차순으로 정렬
)USING(cno)  -- COURSE와 SCORE 테이블을 과목 번호(cno)를 기준으로 조인
WHERE ROWNUM <= 3;  -- 상위 3개의 과목만 선택. ROWNUM을 사용해 상위 3개의 결과만 필터링

--[문제 2] 4.5 환산 평점이 높은 순위로 정렬했을 때 5,6,7 순위의 학생을 검색하시오.
--테이블 : STUDENT
--컬럼 : RN, SNO, SNAME, AVR
SELECT rn, sname, avr AS 환산평점  -- 'rn'은 순위, 'sname'은 학생 이름, 'avr'은 환산 평점으로 출력.
FROM (
    SELECT sname, avr, 
           ROW_NUMBER() OVER (ORDER BY avr DESC) AS rn  -- ROW_NUMBER() 함수로 각 학생에게 순위를 부여. 환산 평점(avr)을 내림차순(DESC)으로 정렬하여 높은 점수에 높은 순위를 부여함. 이 순위는 'rn' 컬럼에 저장됨
    FROM student)  -- student 테이블에서 학생 정보 및 평점 데이터를 조회
WHERE rn BETWEEN 5 AND 7;  -- 매겨진 순위(rn) 중에서 5, 6, 7번째 순위에 해당하는 학생만 선택하여 출력
-- 다른 답안 1 ------------------------
SELECT * 
FROM (
    SELECT ROWNUM rn, sno AS 번호, sname AS 이름, avr AS 평균  -- 'ROWNUM'으로 순번을 부여하고, 'sno'를 '번호', 'sname'을 '이름', 'avr'을 '평균'이라는 별칭으로 부여하여 출력
    FROM (
        SELECT sno, sname, ROUND(avr*4.5/4.0, 2) AS avr  -- 학생의 환산 평점을 4.5 만점 기준으로 변환한 후, 소수 둘째 자리까지 반올림하여 'avr' 컬럼으로 출력
        FROM student  -- student 테이블에서 학생 정보 및 평점 데이터를 조회
        ORDER BY avr DESC )  -- 변환된 평점을 기준으로 내림차순으로 정렬. 높은 점수부터 낮은 점수 순으로 정렬됨
    ) WHERE rn >= 5 AND rn <= 7;  -- 상위 5번째에서 7번째 순번에 해당하는 학생만 선택하여 출력
-- 다른 답안 2 ------------------------
SELECT *
FROM (
    SELECT ROWNUM AS rn, tt.*  -- ROWNUM으로 각 행에 순번을 부여하고, 서브쿼리에서 가져온 모든 컬럼을 선택하여 'tt'의 결과에 순번(rn)을 포함
    FROM (
        SELECT sno, sname, ROUND(avr * 4.5 / 4.0, 2) AS avr  -- 학생 번호(sno), 학생 이름(sname), 환산된 평점(avr)을 선택. 평점은 4.5 만점 기준으로 환산하고 소수 둘째 자리까지 반올림
        FROM student  -- student 테이블에서 학생 정보를 가져옴
        ORDER BY avr DESC, sno  -- 환산된 평점을 기준으로 내림차순 정렬. 만약 평점이 같을 경우, 학생 번호(sno)를 기준으로 오름차순 정렬
    ) tt )  -- 서브쿼리의 결과를 'tt'라는 별칭으로 저장
WHERE rn >= 5 AND rn <= 7;  -- 상위 5번째에서 7번째 순위의 학생만 선택하여 출력

--[문제 3] 기말고사 평균이 60점 이상인 학생의 정보를 검색하시오
--         평균은 반올림하여 소수이하 둘째자리까지 출력하시오
--테이블 : STUDENT, SCORE
--컬럼 : SNO, SNAME, RESULT
SELECT sno, sname, ROUND(AVG(result), 2) AS 평균  -- 'sno'는 학생 번호, 'sname'은 학생 이름, '평균'은 평균 성적을 소수점 둘째 자리까지 반올림한 값
FROM student
JOIN score USING (sno)  -- 학생 번호(SNO)를 기준으로 STUDENT와 SCORE 테이블을 조인하여 학생별 성적을 연결
GROUP BY sno, sname  -- 학생 번호(SNO)와 학생 이름(SNAME)으로 그룹화하여 각 학생의 평균 성적을 계산
HAVING AVG(result) >= 60;  -- 평균 성적이 60점 이상인 학생만 선택. HAVING 절은 GROUP BY로 그룹화된 결과에 대한 조건을 적용하는 데 사용됨
-- 다른 답안 ------------------------
SELECT sno, sname, ROUND(result, 2) AS result  -- 학생 번호(sno), 학생 이름(sname), 반올림된 평균 성적(avg_result)을 'result'로 출력
FROM (
    SELECT sno, sname, ROUND(AVG(result), 2) AS result  -- 각 학생의 평균 성적을 소수 둘째 자리에서 반올림하여 'avg_result'로 별칭 부여
    FROM student
    JOIN score USING (sno)  -- 학생 번호(sno)를 기준으로 'student' 테이블과 'score' 테이블을 조인하여 학생의 성적 데이터를 연결
    GROUP BY sno, sname)  -- 학생 번호(sno)와 이름(sname)별로 그룹화하여 각 학생의 평균 성적을 계산
WHERE result >= 60  -- 평균 성적이 60점 이상인 학생들만 필터링
ORDER BY result;  -- 평균 성적을 오름차순으로 정렬하여 출력

-- 다른 답안 ------------------------
SELECT sno, sname, result  -- 학생 번호(sno), 학생 이름(sname), 필터링된 평균 성적(result)을 출력
FROM student
JOIN (
    SELECT sno, ROUND(AVG(result), 2) AS result  -- 각 학생의 평균 성적을 소수 둘째 자리에서 반올림하여 'result'로 별칭 부여
    FROM score
    GROUP BY sno  -- 학생 번호(sno)별로 그룹화하여 각 학생의 평균 성적을 계산
    HAVING ROUND(AVG(result), 2) >= 60)  -- 평균 성적이 60점 이상인 학생만 필터링. 'HAVING'은 그룹화된 데이터에 조건을 적용
USING (sno);  -- 학생 번호(sno)를 기준으로 서브쿼리와 'student' 테이블을 조인

--[문제 4] 기말고사 평균 성적이 핵 화학과목보다 우수한 과목의 과목명과 담당 교수명을 검색하시오
--테이블 : COURSE, SCORE, PROFESSOR
--컬럼 : CNO, CNAME, RESULT, PNO, PNAME
SELECT PNO AS 교수번호, PNAME AS 교수명, CNO AS 과목번호, CNAME AS 과목명, RESULT AS 기말평균  -- 교수번호, 교수명, 과목번호, 과목명, 기말고사 평균 성적을 출력
FROM (
    SELECT CNO, ROUND(AVG(RESULT), 2) AS RESULT  -- 각 과목(CNO)의 평균 성적을 소수 둘째 자리까지 반올림하여 'RESULT'라는 별칭으로 부여
    FROM SCORE  -- SCORE 테이블에서 성적 데이터를 가져옴
    GROUP BY CNO  -- 과목 번호(CNO)를 기준으로 그룹화하여 각 과목별 평균 성적을 계산
    HAVING ROUND(AVG(RESULT), 2) > (
        SELECT ROUND(AVG(RESULT), 2) AS RESULT  -- 핵화학 과목의 평균 성적을 계산하여 소수 둘째 자리까지 반올림
        FROM SCORE
        GROUP BY CNO
        HAVING CNO = (
            SELECT CNO  -- 핵화학 과목의 과목 번호(CNO)를 가져옴
            FROM COURSE
            WHERE CNAME = '핵화학'  -- 과목명이 '핵화학'인 과목을 찾음
        )
    )
) 
JOIN COURSE USING (CNO)  -- 과목 번호(CNO)를 기준으로 COURSE 테이블과 조인하여 과목 정보(CNAME)를 가져옴
JOIN PROFESSOR USING (PNO)  -- 교수 번호(PNO)를 기준으로 PROFESSOR 테이블과 조인하여 교수 정보(PNAME)를 가져옴
ORDER BY RESULT DESC;  -- 기말 평균 성적(RESULT)을 내림차순으로 정렬하여 높은 성적부터 출력
-- 다른 답안 01 --------------------------------
SELECT PNO, PNAME, CNO, CNAME, RESULT  -- 과목 번호(CNO), 과목명(CNAME), 기말고사 평균 성적(RESULT), 교수 번호(PNO), 교수명(PNAME)을 출력
FROM (
    SELECT CNO, CNAME, PNO, ROUND(AVG(RESULT), 2) AS RESULT  -- 각 과목의 평균 성적을 소수 둘째 자리까지 반올림하여 'RESULT'로 출력
    FROM COURSE
    JOIN SCORE USING (CNO)  -- 과목 번호(CNO)를 기준으로 COURSE와 SCORE 테이블을 조인하여 성적 데이터를 가져옴
    GROUP BY CNO, CNAME, PNO  -- 과목 번호(CNO), 과목명(CNAME), 교수 번호(PNO)를 기준으로 그룹화하여 각 과목의 평균 성적을 계산
)
JOIN PROFESSOR USING (PNO)  -- 교수 번호(PNO)를 기준으로 PROFESSOR 테이블과 조인하여 교수 정보(PNAME)를 가져옴
WHERE RESULT > (
    SELECT ROUND(AVG(RESULT), 2)  -- 핵화학 과목의 평균 성적을 계산하여 소수 둘째 자리까지 반올림
    FROM SCORE
    GROUP BY CNO
    HAVING CNO = (
        SELECT CNO  -- 핵화학 과목의 과목 번호(CNO)를 찾음
        FROM COURSE
        WHERE CNAME = '핵화학'
    )
);
-- --------------------------------
--HAVING 절에 대한 자세한 설명
--HAVING 절은 GROUP BY와 함께 사용하는 조건문으로, 그룹화된 데이터에 대한 조건을 적용하는 데 사용됩니다. 
-- HAVING 절을 사용하여 각 그룹에 대한 조건을 적용할 수 있습니다. HAVING 절은 주로 GROUP BY로 그룹화된 결과를 필터링할 때 사용되며
-- , WHERE 절과는 다르게 집계 함수(예: SUM, AVG, COUNT 등)를 사용할 수 있다는 점이 특징입니다.
--
--HAVING 절의 작동 방식
--GROUP BY 절이 먼저 실행됩니다: 데이터를 특정 컬럼으로 그룹화합니다. 이 예제에서는 CNO, CNAME, PNAME으로 그룹화되었습니다.
--그룹별로 집계 함수가 계산됩니다: GROUP BY로 그룹화된 각 그룹에 대해 AVG(RESULT)가 계산됩니다. 각 과목의 평균 점수를 구하는 단계입니다.
--HAVING 절이 필터링합니다: 이제 계산된 평균 점수 중에서 특정 조건을 만족하는 그룹만 필터링합니다. 이 예제에서는 해당 과목의 평균 점수가 '핵 화학' 과목의 평균 점수보다 높은 과목만 선택합니다.

--예제에서 HAVING 절의 역할
--HAVING AVG(RESULT) > (...)는 그룹화된 각 과목의 평균 점수를 구한 후, 해당 점수가 '핵 화학' 과목의 평균 점수보다 높은 경우에만 그 과목을 결과로 반환합니다.
--즉, HAVING 절은 그룹화된 결과에 조건을 적용하여 과목별 평균 점수가 특정 기준을 넘는 과목만을 필터링하는 데 사용됩니다.
--결론
--HAVING 절은 그룹화된 데이터에 대한 조건을 필터링하는 데 유용하며, 집계 함수와 함께 사용되어 각 그룹별로 특정 조건을 적용하는 데 적합합니다. 이 예제에서는 과목별 평균 점수를 기준으로 필터링하는 역할을 합니다.