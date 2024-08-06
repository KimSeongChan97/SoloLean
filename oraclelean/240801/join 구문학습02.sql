-- 문제1) 송강 교수가 강의하는 과목을 검색하시오.
-- 테이블 : PROFESSOR P, COURSE C
-- 컬럼 : PNO, PNAME, CNO, CNAME
select * from professor;
select * from course;

-- 송강 교수가 강의하는 과목을 조회하는 쿼리
SELECT p.pno,        -- PROFESSOR 테이블의 교수 번호(PNO)를 선택합니다.
       p.pname,      -- PROFESSOR 테이블의 교수 이름(PNAME)을 선택합니다.
       c.cno,        -- COURSE 테이블의 과목 번호(CNO)를 선택합니다.
       c.cname       -- COURSE 테이블의 과목 이름(CNAME)을 선택합니다.
FROM PROFESSOR P,    -- PROFESSOR 테이블을 P라는 별칭으로 사용합니다.
     COURSE C       -- COURSE 테이블을 C라는 별칭으로 사용합니다.
WHERE p.pno = c.pno  -- PROFESSOR 테이블과 COURSE 테이블의 PNO 컬럼을 기준으로 조인합니다.
  AND pname = '송강'; -- 교수 이름이 '송강'인 행만 조회합니다.

-- 송강 교수가 강의하는 과목을 조회하는 쿼리 (ANSI)
SELECT pno,          -- PROFESSOR 테이블의 교수 번호(PNO)를 선택합니다.
       pname,        -- PROFESSOR 테이블의 교수 이름(PNAME)을 선택합니다.
       cno,          -- COURSE 테이블의 과목 번호(CNO)를 선택합니다.
       cname         -- COURSE 테이블의 과목 이름(CNAME)을 선택합니다.
FROM PROFESSOR       -- PROFESSOR 테이블을 기본으로 사용합니다.
JOIN COURSE          -- COURSE 테이블을 조인합니다.
USING(pno)           -- PROFESSOR 테이블과 COURSE 테이블의 PNO 컬럼을 기준으로 조인합니다.
WHERE pname = '송강'; -- 교수 이름이 '송강'인 행만 조회합니다.

-- 문제2) 화학 관련 과목을 강의하는 교수의 명단을 검색하시오
-- 테이블 : PROFESSOR P, COURSE C
-- 컬럼 : PNO, PNAME, CNO, CNAME
select * from professor;
select * from course;

-- 화학 관련 과목을 강의하는 교수의 명단을 검색하는 쿼리
SELECT P.pno,        -- PROFESSOR 테이블의 교수 번호(PNO)를 선택합니다.
       P.pname,      -- PROFESSOR 테이블의 교수 이름(PNAME)을 선택합니다.
       C.cno,        -- COURSE 테이블의 과목 번호(CNO)를 선택합니다.
       C.cname       -- COURSE 테이블의 과목 이름(CNAME)을 선택합니다.
FROM PROFESSOR P,    -- PROFESSOR 테이블을 P라는 별칭으로 사용합니다.
     COURSE C       -- COURSE 테이블을 C라는 별칭으로 사용합니다.
WHERE P.pno = C.pno  -- PROFESSOR 테이블과 COURSE 테이블의 PNO 컬럼을 기준으로 조인합니다.
  AND C.cname LIKE '%화학%'; -- 과목 이름(CNAME)에 '화학'이 포함된 과목만 조회합니다.
  
  -- 화학 관련 과목을 강의하는 교수의 명단을 검색하는 쿼리 (ANSI 표준 구문)
SELECT P.pno,        -- PROFESSOR 테이블의 교수 번호(PNO)를 선택합니다.
       P.pname,      -- PROFESSOR 테이블의 교수 이름(PNAME)을 선택합니다.
       C.cno,        -- COURSE 테이블의 과목 번호(CNO)를 선택합니다.
       C.cname       -- COURSE 테이블의 과목 이름(CNAME)을 선택합니다.
FROM PROFESSOR P     -- PROFESSOR 테이블을 P라는 별칭으로 사용합니다.
JOIN COURSE C        -- COURSE 테이블을 C라는 별칭으로 사용하여 조인합니다.
ON P.pno = C.pno     -- PROFESSOR 테이블과 COURSE 테이블의 PNO 컬럼을 기준으로 조인합니다.
WHERE C.cname LIKE '%화학%'; -- 과목 이름(CNAME)에 '화학'이 포함된 과목만 조회합니다.

-- 교수 번호(PNO), 교수 이름(PNAME), 과목 번호(CNO), 과목 이름(CNAME)을 조회합니다.
SELECT pno,         -- 교수 번호(PNO)를 선택합니다.
       pname,       -- 교수 이름(PNAME)을 선택합니다.
       cno,         -- 과목 번호(CNO)를 선택합니다.
       cname        -- 과목 이름(CNAME)을 선택합니다.
FROM professor      -- professor 테이블을 선택합니다.
JOIN course         -- course 테이블을 professor 테이블과 조인합니다.
USING (pno)         -- professor와 course 테이블 간의 PNO 컬럼을 기준으로 조인합니다. 두 테이블에 동일한 이름을 가진 컬럼이 있을 때 사용합니다.
WHERE cname LIKE '%화학%';  -- 과목 이름(CNAME)에 '화학'이라는 단어가 포함된 과목만 조회합니다.





