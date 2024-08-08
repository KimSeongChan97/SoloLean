
-- 사원테이블에서 급여의 평균을 구하시오 
-- 조건) 소수 이하는 절삭, 세 자리마다 콤마(,) 표시
-- 사원급여평균 
-- ---------------
-- 6,461
select to_char(trunc(avg(salary), 0), '99,999') as 사원급여평균 from employees;

-- ex2) 부서별 급여평균을 구하시오
-- 조건1) 소수 이하는 반올림
-- 조건2) 세자리 마다 콤마, 화폐 단위(￦)로 표시 
-- 조건3) 부서별로 오름차순 정렬하시오 
-- 조건4) 평균급여가 5000이상인 부서만 표시하시오 
-- 부서코드            평균급여
-- -------------------------- 
-- 10                     ￦8,600
SELECT 
    department_id AS 부서코드, -- 부서코드를 선택하여 결과에 표시합니다.
    -- 급여의 평균을 구하고, 이를 반올림(소수점 없이)한 후, 'L99,999,999' 형식으로 변환하여 통화 형식으로 보여줍니다.
    -- 'L'은 로컬 통화 기호를 의미합니다.
    TO_CHAR(ROUND(AVG(salary), 0), 'L99,999,999') AS 평균급여 
FROM employees -- employees 테이블에서 데이터를 가져옵니다. 이 테이블은 직원들의 정보를 포함하고 있습니다.
GROUP BY department_id -- department_id 컬럼을 기준으로 데이터를 그룹화합니다. 즉, 같은 부서의 직원들끼리 묶습니다.
HAVING AVG(salary) >= 5000 -- 그룹화된 각 부서의 평균 급여가 5000 이상인 경우에만 결과에 포함시킵니다.
ORDER BY department_id ASC; -- 결과를 부서코드(department_id) 순으로 오름차순 정렬합니다.

-- ex3) 부서별 급여평균을 구해서 사원명(last_name), 부서별 급여평균을 출력하시오 - X 
-- select last_name, avg(salary)
select last_name, avg(salary)
from employees
group by department_id;
-- ★ last_name 때문에 error - group by절에 없는 것을 select에 조회하면 error

-- [문제1] job_id별 급여의 합계를 구해서 job_id, 급여합계를 출력하시오
select job_id, sum(salary) as 급여합계
from employees
GROUP by job_id; -- job_id 컬럼을 기준으로 데이터를 그룹화

-- ex4) 비효율적인 having절
-- 10과 20부서에서 최대급여를 받는 사람의 최대급여를 구하여 정렬하시오
SELECT 
    department_id, -- 부서코드를 선택하여 결과에 표시합니다.
    -- 각 부서에서 급여가 가장 높은 값을 선택하고, 이를 max_salary라는 이름으로 표시합니다.
    MAX(salary) AS max_salary 
FROM employees -- employees 테이블에서 데이터를 가져옵니다. 이 테이블은 직원들의 정보를 포함하고 있습니다.
GROUP BY department_id -- department_id 컬럼을 기준으로 데이터를 그룹화합니다. 즉, 같은 부서의 직원들끼리 묶습니다.
HAVING department_id IN (10, 20) -- department_id가 10 또는 20인 부서만 결과에 포함시킵니다. HAVING 절은 GROUP BY 이후에 적용됩니다.
ORDER BY department_id; -- 결과를 department_id 기준으로 오름차순 정렬합니다.
-- 전체 부서에 대해 그룹을 잡아서 최대급여를 구한 후에 부서가 10과 20인 것을 추려내기 때문인 것

SELECT 
    department_id, MAX(salary) AS max_salary 
    -- 부서코드를 선택하여 결과에 표시합니다.
    -- 각 부서에서 급여가 가장 높은 값을 선택하고, 이를 max_salary라는 이름으로 표시합니다.
FROM employees -- employees 테이블에서 데이터를 가져옵니다. 이 테이블은 직원들의 정보를 포함하고 있습니다.
WHERE department_id IN (10, 20) -- department_id가 10 또는 20인 부서의 데이터만 선택합니다. WHERE 절은 데이터를 필터링하는 데 사용됩니다.
GROUP BY department_id -- department_id 컬럼을 기준으로 데이터를 그룹화합니다. 즉, 같은 부서의 직원들끼리 묶습니다.
ORDER BY department_id; -- 결과를 department_id 기준으로 오름차순 정렬합니다. 기본적으로 ASC는 생략 가능하며 오름차순 정렬을 의미합니다.
-- 부서번호가 10과 20인 것만 골라내서 그룹잡기 때문에 속도가 좀 빠르다

--join
-- ex5) inner join : 같은 것끼리만 조인
-- 사원테이블과 부서테이블에서 부서가 같을 경우 사원번호, 부서번호, 부서이름을 출력하시오 
select employee_id, department_id, department_name
from employees
join departments using(department_id);
-- 방법1(오라클 전용 구문)
select employee_id, employees.department_id, department_name
from employees, departments
where employees.department_id = departments.department_id; 
-- 방법2(오라클 전용 구문)
select employee_id, e.department_id, department_name
from employees e, departments d 
where e.department_id = d.department_id;
-- 방법3(Ansi 표준)
select employee_id, department_id, department_name 
from employees 
join departments using(department_id);

-- [문제2] 부서테이블(DEPARTMENTS d)과 위치테이블(LOCATIONS l)을 연결하여 부서가 위치한 도시를 알아내시오
select departments.department_id, l.city
from departments
join locations l using(location_id);

-- ex6) outer join(left) : 왼쪽 테이블은 모두 포함하여 조인
-- 사원테이블과 부서테이블에서 부서번호가 같은 사원을 조인하시오 → 107레코드
-- 방법1(오라클 전용 구문)
select e.last_name, d.department_id, d.department_name 
from employees e, departments d
where e.department_id = d.department_id(+); 
-- 방법2(Ansi 표준)
select last_name, department_id, department_name 
from employees 
left join departments using(department_id);

-- ex7) outer join(right) : 오른쪽 테이블은 모두 포함하여 조인
-- 사원테이블과 부서테이블에서 부서번호가 같은 사원을 조인하시오 → 122 레코드 
-- 방법1(오라클 전용 구문)
select e.last_name, d.department_id, d.department_name 
from employees e, departments d
where e.department_id(+) = d.department_id; 
-- 방법2(Ansi 표준)
select last_name, department_id, department_name 
from employees 
right join departments using(department_id);

-- ex8) full join : 왼쪽, 오른쪽 테이블을 모두 포함하여 조인
-- 사원테이블과 부서테이블에서 부서번호가 같은 사원을 조인하시오 → 123레코드 
--방법1(오라클 전용 구문) : 없다
--방법2(Ansi표준)
select last_name, department_id, department_name 
from employees
full join departments using(department_id);

-- ex9) inner join : 두 개의 컬럼이 일치 하는 경우
-- 부서ID와 매니저ID가 같은 사원을 연결 하시오 → 32 레코드 
-- (관련 테이블 : departments, employees)
-- last_name     department_id   manager_id 
-- 방법1(오라클 전용 구문)
select e.last_name, d.department_id, d.manager_id 
from employees e, departments d
where e.department_id=d.department_id and e.manager_id=d.manager_id; 
-- 방법2(Ansi표준)
select last_name, department_id, manager_id 
from employees
inner join departments using(department_id, manager_id);
-- -----------------------------------------------------------
-- ex10) 내용은 같은데 컬럼명이 다른 경우에 조인으로 연결하기 
-- departments(location_id), locations2(loc_id)
-- 테이블 복사
create table locations2 as select * from locations; 
select * from locations;
select * from locations2;
alter table locations2 rename column location_id to loc_id; 
select * from locations2; -- 컬럼명이 바뀌었다
-- 방법1(오라클 전용 구문)
select d.department_id, l.city 
from departments d, locations2 l 
where d.location_id = l.loc_id;
-- 방법2(Ansi 표준)
select department_id, city 
from departments
join locations2 on(location_id = loc_id); 
-- 방법3(Ansi 표준)
select department_id, city 
from departments d
join locations2 l on(d.location_id = l.loc_id);

-- ex11) self 조인 : 자기 자신의 테이블과 조인하는 경우 사원과 관리자를 연결하시오
select employee_id, manager_id, last_name from employees; --→ e 
select employee_id, last_name from employees; -- → m
--  방법1
select e.employee_id as 사원번호,
e.last_name as 사원이름,
m.last_name as 관리자 
from employees e, employees m 
where m.employee_id = e.manager_id;
-- 방법2
select e.employee_id as 사원번호, 
e.last_name as 사원이름,
m.last_name as 관리자 
from employees e
join employees m on(m.employee_id = e.manager_id);

-- ex12) cross join : 모든 행에 대해 가능한 모든 조합을 생성하는 조인 
select * from countries, locations; → -- 575레코드
select * from countries cross join locations; 

-- ex13) Non Equijoin (넌 이큐조인)
-- 컬럼값이 같은 경우가 아닌 범위에 속하는지 여부를 확인 할 때 
-- on ( 컬럼명 between 컬럼명1 and 컬럼명2)
create table salgrade( 
salvel varchar2(2), 
lowst number,
highst number);
insert into salgrade values('A', 20000, 29999);
insert into salgrade values('B', 10000, 19999);
insert into salgrade values('C', 0, 9999);
commit;

select * from salgrade; 
select last_name, salary, salvel
from employees
join salgrade on(salary between lowst and highst) 
order by salary desc;

-- ex14) n(여러)개의 테이블은 조인
-- 업무ID 같은 사원들의 사원이름, 업무내용, 부서이름을 출력하시오 
-- (EMPLOYEES, JOBS, DEPARTMENTS 테이블을 조인)
select last_name, job_title, department_name 
from employees
join departments using(department_id) 
join jobs using(job_id);

-- [문제3] 위치ID, 부서ID을 연결해서 사원이름, 도시, 부서이름을 출력하시오 
-- (관련 테이블 : EMPLOYEES, LOCATIONS2, DEPARTMENTS)
-- 조건1 : 사원이름, 도시, 부서이름으로 제목을 표시하시오 
-- 조건2 : Seattle 또는 Oxford 에서 근무하는 사원 
-- 조건3 : 도시 순으로 오름차순 정렬하시오 
-- 사원이름        도   시        부서이름 
-- ---------------------------------------------
-- Hall               Oxford         Sales
SELECT 
    LAST_NAME AS 사원이름, -- EMPLOYEES 테이블에서 직원의 성을 가져와 '사원이름'으로 칭함
    CITY AS 도시,          -- LOCATIONS2 테이블에서 도시 이름을 가져와 '도시'로 칭함
    DEPARTMENT_NAME AS 부서이름 -- DEPARTMENTS 테이블에서 부서 이름을 가져와 '부서이름'으로 칭함
FROM EMPLOYEES -- EMPLOYEES 테이블과 DEPARTMENTS 테이블을 DEPARTMENT_ID를 기준으로 조인
JOIN DEPARTMENTS USING(DEPARTMENT_ID) -- LOCATIONS2 테이블과 EMPLOYEES, DEPARTMENTS의 조인된 결과를 LOCATION_ID와 LOC_ID가 일치하는 레코드로 조인
JOIN LOCATIONS2 ON(LOCATION_ID = LOC_ID) -- 조건에 맞는 도시 ('Seattle', 'Oxford')에 있는 직원들만 조회
WHERE CITY IN('Seattle', 'Oxford') -- 조회된 결과를 '도시' 열을 기준으로 오름차순 정렬
ORDER BY 2; -- 두번째 열(CITY) 기준으로 오름차순 정렬

-- [문제4] 부서ID, 위치ID, 국가ID를 연결해서 다음과 같이 완성하시오
-- (관련 테이블 : EMPLOYEES, LOCATIONS2, DEPARTMENTS, COUNTRIES) 
-- 조건1 : 사원번호, 사원이름, 부서이름, 도시, 도시주소, 나라이름으로 제목을 표시하시오
-- 조건2 : 도시주소에 Ch 또는 Sh 또는 Rd가 포함되어 있는 데이터만 표시하시오 
-- 조건3 : 나라이름, 도시별로 오름차순 정렬하시오
-- 조건4 : 모든 사원을 포함한다.
SELECT 
    EMPLOYEE_ID AS 사원번호,         -- EMPLOYEES 테이블에서 직원 ID를 가져와 '사원번호'로 칭함
    LAST_NAME AS 사원이름,           -- EMPLOYEES 테이블에서 직원의 성을 가져와 '사원이름'으로 칭함
    DEPARTMENT_NAME AS 부서이름,     -- DEPARTMENTS 테이블에서 부서 이름을 가져와 '부서이름'으로 칭함
    CITY AS 도시,                    -- LOCATIONS2 테이블에서 도시 이름을 가져와 '도시'로 칭함
    STREET_ADDRESS AS 도시주소,      -- LOCATIONS2 테이블에서 도로 주소를 가져와 '도시주소'로 칭함
    COUNTRY_NAME AS 나라이름         -- COUNTRIES 테이블에서 나라 이름을 가져와 '나라이름'으로 칭함
FROM EMPLOYEES -- EMPLOYEES 테이블과 DEPARTMENTS 테이블을 DEPARTMENT_ID를 기준으로 조인 (왼쪽 조인, 왼쪽 테이블 EMPLOYEES의 모든 레코드 포함)
LEFT JOIN DEPARTMENTS USING(DEPARTMENT_ID) -- EMPLOYEES와 DEPARTMENTS의 조인 결과를 LOC_ID와 LOCATION_ID가 일치하는 레코드로 LOCATIONS2 테이블과 조인
JOIN LOCATIONS2 ON(LOCATION_ID = LOC_ID) -- LOCATIONS2 테이블과 COUNTRIES 테이블을 COUNTRY_ID를 기준으로 조인
JOIN COUNTRIES USING(COUNTRY_ID) -- 도로 주소가 'Ch', 'Sh', 'Rd' 패턴을 포함하는 레코드만 선택
WHERE STREET_ADDRESS LIKE '%Ch%' OR STREET_ADDRESS LIKE '%Sh%' OR STREET_ADDRESS LIKE '%Rd%'
-- 결과를 나라이름, 도시, 부서이름 순으로 정렬
ORDER BY 6, 4, 3;
