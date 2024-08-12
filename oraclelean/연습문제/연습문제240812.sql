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
-- [문제] 기말고사 평균이 60점 이상인 학생의 정보를 검색하시오
--        평균은 반올림하여 소수이하 둘째자리까지 출력하시오
-- 테이블 : STUDENT, SCORE
-- 컬럼 : SNO, SNAME, RESULT

-- [문제] 기말고사 평균 성적이 핵 화학과목보다 우수한 과목의 과목명과 담당 교수명을 검색하시오
-- 테이블 : STUDENT, SCORE, COURSE, PROFESSOR
-- 컬럼 : CNO, CNAME, RESULT, PNO, PNAME

