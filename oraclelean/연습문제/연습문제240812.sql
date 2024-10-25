-- [문제1] 각 과목의 과목명과 담당 교수의 교수명을 검색하고, 과목번호로 오름차순하시오
-- 테이블 : COURSE, PROFESSOR
-- 컬럼 : CNO(과목번호), CNAME(과목명), PNO(교수번호), PNAME(교수명)

-- COURSE 테이블과 PROFESSOR 테이블을 조인하여 과목명(CNAME)과 교수명(PNAME)을 가져옵니다.
-- 조인은 COURSE 테이블의 PNO와 PROFESSOR 테이블의 PNO를 기준으로 수행합니다.
-- 결과를 과목번호(CNO)를 기준으로 오름차순 정렬합니다.
SELECT C.CNAME, P.PNAME
FROM COURSE C
JOIN PROFESSOR P ON C.PNO = P.PNO
ORDER BY C.CNO ASC;

-- [문제2] 모든 교수의 명단과 담당 과목을 검색하시오
-- 테이블 : COURSE, PROFESSOR
-- 컬럼 : CNO(과목번호), CNAME(과목명), PNO(교수번호), PNAME(교수명), SECTION(분반)

-- PROFESSOR 테이블과 COURSE 테이블을 조인하여 교수명(PNAME)과 과목명(CNAME)을 검색합니다.
-- LEFT JOIN을 사용하여, 담당 과목이 없는 교수도 결과에 포함되도록 합니다.
SELECT P.PNAME, C.CNAME
FROM PROFESSOR P
LEFT JOIN COURSE C ON P.PNO = C.PNO;

-- [문제3] 모든 교수의 명단과 담당 과목을 검색한다(단 모든 과목도 같이 검색한다) => UNION 사용
-- 테이블 : COURSE, PROFESSOR
-- 컬럼 : CNO(과목번호), CNAME(과목명), PNO(교수번호), PNAME(교수명), SECTION(분반)

-- 첫 번째 SELECT 문에서는 교수명(PNAME)과 과목명(CNAME)을 검색합니다.
-- LEFT JOIN을 사용하여, 담당 과목이 없는 교수도 결과에 포함시킵니다.
-- 두 번째 SELECT 문에서는 PNAME이 없는 빈 문자열과 과목명을 검색하여, 담당 교수가 없는 과목도 결과에 포함시킵니다.
-- UNION을 사용하여 두 SELECT 문을 결합하여, 모든 교수와 모든 과목을 검색합니다.
SELECT P.PNAME, C.CNAME
FROM PROFESSOR P
LEFT JOIN COURSE C ON P.PNO = C.PNO
UNION
SELECT '', C.CNAME
FROM COURSE C
WHERE C.PNO IS NULL;

-- [문제4] 근무 중인 직원이 4명 이상인 부서를 검색하세요
-- 테이블 : DEPT, EMP
-- 컬럼 : DNO(부서번호), DNAME(부서명), 직원수

-- DEPT 테이블과 EMP 테이블을 조인하여 부서명(DNAME)과 해당 부서의 직원 수를 계산합니다.
-- 조인은 EMP 테이블의 DNO(부서번호)와 DEPT 테이블의 DNO를 기준으로 수행합니다.
-- 직원 수가 4명 이상인 부서만 검색하기 위해 HAVING 절을 사용하여 필터링합니다.
SELECT D.DNAME, COUNT(E.DNO) AS 직원수
FROM DEPT D
JOIN EMP E ON D.DNO = E.DNO
GROUP BY D.DNAME
HAVING COUNT(E.DNO) >= 4;

-- [문제5] 강의 학점이 3학점 이상인 교수의 정보를 검색하세요
-- 테이블 : PROFESSOR, COURSE 
-- 컬럼 : PNO(교수번호), PNAME(교수명), ST_NUM(강의 학점)

-- PROFESSOR 테이블과 COURSE 테이블을 조인하여 교수명(PNAME)과 총 학점(SUM(ST_NUM))을 계산합니다.
-- 조인은 COURSE 테이블의 PNO(교수번호)와 PROFESSOR 테이블의 PNO를 기준으로 수행합니다.
-- 강의 학점이 3학점 이상인 교수만 검색하기 위해 HAVING 절을 사용하여 필터링합니다.
SELECT P.PNAME, SUM(C.ST_NUM) AS 총학점
FROM PROFESSOR P
JOIN COURSE C ON P.PNO = C.PNO
GROUP BY P.PNAME
HAVING SUM(C.ST_NUM) >= 3;

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
-- 다른 답안 ------------------------


--[문제 2] 4.5 환산 평점이 가장 높은 3인의 학생을 검색하시오.
--테이블 : STUDENT
--컬럼 : RN, SNO, SNAME, AVR
SELECT sname, avr AS 환산평점  -- 'sname'은 학생 이름, 'avr'은 학생의 환산 평점으로 '환산평점'이라는 별칭 부여
FROM (
    SELECT sname, avr  -- 학생 이름과 환산 평점을 선택
    FROM student
    ORDER BY avr DESC)  -- 학생들의 환산 평점을 내림차순으로 정렬하여 높은 평점 순으로 정렬
WHERE ROWNUM <= 3;  -- 상위 3명의 학생만 선택. ROWNUM은 정렬된 결과에서 순서를 매겨 상위 3개의 결과만 필터링
-- 다른 답안 ------------------------    

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

--[문제 4] 기말고사 평균 성적이 핵 화학과목보다 우수한 과목의 과목명과 담당 교수명을 검색하시오
--테이블 : COURSE, SCORE, PROFESSOR
--컬럼 : CNO, CNAME, RESULT, PNO, PNAME
SELECT CNAME, PNAME
FROM COURSE  -- COURSE 테이블에서 과목 정보 선택
JOIN SCORE USING (CNO)  -- 과목 번호(CNO)를 기준으로 SCORE 테이블과 조인
JOIN PROFESSOR USING (PNO)  -- 교수 번호(PNO)를 기준으로 PROFESSOR 테이블과 조인
GROUP BY CNO, CNAME, PNAME  -- 과목 번호(CNO), 과목명(CNAME), 교수명(PNAME)으로 그룹화
HAVING AVG(RESULT) > (
    SELECT AVG(RESULT)  -- 서브쿼리: 핵 화학 과목의 평균 성적을 계산
    FROM COURSE
    JOIN SCORE USING (CNO)
    WHERE CNAME = '핵 화학');
    -- '핵 화학' 과목에 대한 성적만 계산
-- 다른 답안 ------------------------

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
