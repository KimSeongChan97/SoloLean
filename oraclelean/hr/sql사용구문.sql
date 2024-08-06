-- 데이터베이스 생성
CREATE DATABASE database_name;

-- 테이블 생성
CREATE TABLE table_name (
    column1 datatype,
    column2 datatype,
    ...
);

-- 예제
CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    age INT
);

-- 테이블에 새로운 열 추가
ALTER TABLE table_name ADD column_name datatype;

-- 열의 데이터 타입 변경
ALTER TABLE table_name MODIFY column_name new_datatype;

-- 예제
ALTER TABLE students ADD address VARCHAR(100);
ALTER TABLE students MODIFY name VARCHAR(100);

-- 테이블 삭제
DROP TABLE table_name;

-- 데이터베이스 삭제
DROP DATABASE database_name;

-- 예제
DROP TABLE students;

-- 테이블의 모든 데이터 조회
SELECT * FROM table_name;

-- 특정 열만 조회
SELECT column1, column2 FROM table_name;

-- 조건에 맞는 데이터 조회
SELECT * FROM table_name WHERE condition;

-- 예제
SELECT * FROM students;
SELECT name, age FROM students WHERE age > 20;

-- 전체 열에 데이터 삽입
INSERT INTO table_name VALUES (value1, value2, ...);

-- 특정 열에 데이터 삽입
INSERT INTO table_name (column1, column2, ...) VALUES (value1, value2, ...);

-- 예제
INSERT INTO students VALUES (1, 'John Doe', 22);
INSERT INTO students (name, age) VALUES ('Jane Doe', 20);

-- 특정 조건에 맞는 데이터 수정
UPDATE table_name SET column1 = value1, column2 = value2 WHERE condition;

-- 예제
UPDATE students SET age = 23 WHERE id = 1;

-- 특정 조건에 맞는 데이터 삭제
DELETE FROM table_name WHERE condition;

-- 테이블의 모든 데이터 삭제
DELETE FROM table_name;

-- 예제
DELETE FROM students WHERE id = 1;

-- 사용자에게 특정 권한 부여
GRANT privilege ON object TO user;

-- 예제
GRANT SELECT ON students TO 'user1';

select * from departments;
select * from employees;


-- inner join : 같은 것끼리만 조인
-- 사원테이블과 부서테이블에서 부서가 같을 경우 사원번호, 부서번호, 부서이름을 출력하시오
select   employee_id,
employees.department_id, 
department_name
from employees, departments
where employees.department_id = departments.department_id; -- oracle

select   employee_id,
e.department_id, 
department_name
from employees e, departments d 
where e.department_id = d.department_id; --축약

select employee_id, department_id, department_name 
from employees 
join departments using(department_id); -- ansi 표준

-- 부서테이블(DEPARTMENTS d)과 위치테이블(LOCATIONS l)을 연결하여 부서가 
-- 위치한 도시를 알아내시오
select * from departments;
select * from locations;
select d.department_id, -- department의 부서 id
        l.city -- locations 의 도시이름
from departments d -- departments 의 별칭
join locations l -- locations 의 별칭
-- DEPARTMENTS 테이블과 LOCATIONS 테이블의 location_id를 기준으로 조인
on d.location_id = l.location_id;

select department_id, city
from departments
join locations using(location_id);

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

