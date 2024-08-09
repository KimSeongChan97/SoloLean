-- 테이블 구조만 복사
-- 기존 employees 테이블의 구조를 그대로 복사하되 데이터는 복사하지 않습니다.
create table employees_role as select * from employees where 1=0;

-- employees 테이블의 전체 레코드 수를 조회합니다.
-- 이 쿼리는 employees 테이블의 총 레코드 수를 반환합니다.
select count(*) from employees;

-- 새로 생성한 employees_role 테이블의 데이터를 조회합니다.
-- 현재 employees_role 테이블은 데이터를 포함하지 않으므로 결과는 빈 테이블이 됩니다.
select * from employees_role;

-- employees_role 테이블에 데이터를 삽입합니다.
-- 이 문장은 첫 번째 사원 정보를 employees_role 테이블에 삽입합니다.
insert into employees_role values(101, 'Neena', 'Kochhar', 'NKOCHHAR', '515.123.4568', 
'1989-09-21', 'AD_VP', 17000.00, NULL, 100, 90);

-- 동일한 데이터를 다시 한 번 삽입합니다.
-- 만약 employees_role 테이블에 primary key 제약 조건이 없다면 중복된 레코드가 삽입됩니다.
insert into employees_role values(101, 'Neena', 'Kochhar', 'NKOCHHAR', '515.123.4568', 
'1989-09-21', 'AD_VP', 17000.00, NULL, 100, 90);

-- 일부 필드만 다른 데이터를 삽입합니다.
-- 여기서는 first_name과 last_name이 일부 다르게 입력되었습니다.
insert into employees_role values(101, 'Nee', 'Ko', 'NKOCHHAR', '515.123.4568', 
'1989-09-21', 'AD_VP', 17000.00, NULL, 100, 90);

-- 새로운 employee_id(200)로 데이터를 삽입합니다.
-- 이 사원은 동일한 first_name과 last_name을 가지지만 employee_id가 다릅니다.
insert into employees_role values(200, 'Neena', 'Kochhar', 'NKOCHHAR', '515.123.4568', 
'1989-09-21', 'AD_VP', 17000.00, NULL, 100, 90);

-- 또 다른 데이터를 삽입합니다.
-- 이 경우 employee_id는 200이고, first_name은 'Nee'입니다.
insert into employees_role values(200, 'Nee', 'Kochhar', 'NKOCHHAR', '515.123.4568', 
'1989-09-21', 'AD_VP', 17000.00, NULL, 100, 90);

-- 새로운 employee_id(300)로 데이터를 삽입합니다.
-- 이 레코드는 새로운 사원의 정보를 포함하고 있습니다.
insert into employees_role values(300, 'GilDong', 'Hong', 'NKOCHHAR', '010-123-4567', 
'2009-03-01', 'IT_PROG', 23000.00, NULL, 100, 90);

-- 현재까지의 모든 작업을 데이터베이스에 확정(커밋)합니다.
-- 이 커밋 명령은 이전에 실행된 모든 변경 사항을 영구적으로 저장합니다.
commit;

-- 기본 설정

-- ex1) UNION
-- employee_id, last_name이 같을 경우 중복 제거 하시오 → 110 레코드 
-- UNION 연산자는 두 개의 SELECT 문에서 중복되는 레코드를 제거합니다.
-- 두 테이블에서 employee_id와 last_name을 선택하고 중복을 제거한 결과를 반환합니다.
select employee_id, last_name from employees
union
select employee_id, last_name from employees_role; 

-- ex2) UNION ALL
-- employee_id, last_name이 같을 경우 중복을 허용 하시오 → 113 레코드 
-- UNION ALL 연산자는 두 개의 SELECT 문에서 중복을 제거하지 않고 모든 레코드를 포함합니다.
-- 두 테이블에서 employee_id와 last_name을 선택하고 모든 결과를 반환합니다.
select employee_id, last_name from employees
union all
select employee_id, last_name from employees_role; 

-- 부서 ID가 10인 사원의 salary와 부서 ID가 30인 사원의 salary를 모두 조회하여 출력합니다.
-- 여기서는 UNION ALL을 사용하여 중복을 허용하고, 마지막에 order by로 결과를 정렬합니다.
-- UNION ALL로 모든 salary를 결합한 후 salary 값을 기준으로 정렬합니다.
select salary  from employees where department_id=10
union all
select salary  from employees where department_id=30 order by 1;

-- ex3) MINUS
-- employees_role과 중복되는 레코드는 제거하고 employees에만 있는 사원명단을 구하시오 
-- (단, employee_id, last_name만 표시) → 106 레코드
-- MINUS 연산자는 첫 번째 SELECT 문에 있는 레코드 중 두 번째 SELECT 문에 없는 레코드를 반환합니다.
-- 결과적으로 employees에만 존재하는 employee_id와 last_name을 반환합니다.
select employee_id, last_name from employees 
minus
select employee_id, last_name from employees_role;

-- ex4) INTERSECT
-- employees와 employees_role에서 중복되는 레코드의 사원명단을 구하시오 
-- (단, employee_id, last_name만 표시) → 1 레코드
-- INTERSECT 연산자는 두 SELECT 문에서 공통으로 포함된 레코드를 반환합니다.
-- 두 테이블 모두에 존재하는 employee_id와 last_name을 반환합니다.
select employee_id, last_name from employees 
intersect
select employee_id, last_name from employees_role;

-- [문제1] employees와 employees_role에서 레코드의 사원명단을 구하시오 
-- 조건1) 사원이름, 업무ID, 부서ID을 표시하시오
-- 조건2) employees에서는 부서ID가 10인 사원만 검색 
-- employees_role에서는 업무ID가 IT_PROG만 검색
-- 조건3) 중복되는 레코드는 제거
select last_name as 사원이름, job_id as 업무id, department_id as 부서id
from employees where department_id = 10
union
select last_name as 사원이름, job_id as 업무id, department_id as 부서id 
from employees_role where job_id = 'IT_PROG';

-- employees 테이블에서 부서 ID가 10인 사원의 last_name(사원이름), job_id(업무ID), department_id(부서ID)을 선택합니다.
-- employees_role 테이블에서는 job_id가 'IT_PROG'인 사원의 last_name(사원이름), job_id(업무ID), department_id(부서ID)을 선택합니다.
-- 이 두 쿼리를 UNION 연산자를 통해 결합합니다. UNION은 중복된 레코드를 제거하고 모든 결과를 반환합니다.
-- 각 필드는 출력 시에 별칭(alias)을 사용하여 한글로 표시됩니다. 
-- 예를 들어, last_name은 '사원이름', job_id는 '업무id', department_id는 '부서id'로 출력됩니다.

select last_name as 사원이름, job_id as 업무id, department_id as 부서id
-- 첫 번째 SELECT 문에서는 employees 테이블에서 부서 ID가 10인 사원을 선택합니다.
-- last_name을 '사원이름'으로, job_id를 '업무id'로, department_id를 '부서id'로 표시합니다.
from employees 
where department_id = 10
-- 부서 ID가 10인 레코드만 선택합니다.

union
-- UNION 연산자를 사용하여 두 개의 SELECT 문을 결합합니다.
-- 이 연산자는 중복된 레코드를 제거한 후 결과를 반환합니다.

select last_name as 사원이름, job_id as 업무id, department_id as 부서id 
-- 두 번째 SELECT 문에서는 employees_role 테이블에서 job_id가 'IT_PROG'인 사원을 선택합니다.
-- 마찬가지로 last_name을 '사원이름'으로, job_id를 '업무id'로, department_id를 '부서id'로 표시합니다.
from employees_role 
where job_id = 'IT_PROG';
-- job_id가 'IT_PROG'인 레코드만 선택합니다.

-- 전체 쿼리는 두 개의 서로 다른 테이블에서 특정 조건에 맞는 레코드를 선택한 후,
-- 중복을 제거하고 하나의 결과로 결합합니다.
-- 결과적으로, 부서 ID가 10인 사원과 IT_PROG 업무를 담당하는 사원들의 명단을 중복 없이 출력합니다.

-- ex5) SET operator과 IN operator관계
-- job_title이 'Stock Manager' 또는 'Programmer'인 사원들의 사원명과 job_title을 표시하시오
-- last_name       job_title 
-- -------------------------------- 
-- Kaufling         Stock Manager
-- Hunlod           Programmer
-- :

-- 방법1 (join, in 연산자 이용) 
-- employees 테이블과 jobs 테이블을 조인하여 사원의 last_name과 job_title을 검색합니다.
-- 조건은 job_title이 'Stock Manager' 또는 'Programmer'인 경우입니다.
-- IN 연산자는 여러 값을 동시에 비교할 때 사용되며, 이 경우 'Stock Manager'와 'Programmer'가 포함됩니다.
select last_name, job_title 
from employees
join jobs using(job_id)
where job_title in('Stock Manager', 'Programmer');

-- 방법2 (join, union 이용) 
-- employees 테이블과 jobs 테이블을 조인하여 job_title이 'Stock Manager'인 레코드와 
-- 'Programmer'인 레코드를 각각 조회한 후, UNION으로 결합합니다.
-- 이 방법은 개별적으로 두 쿼리를 실행한 후 UNION으로 결합하여 결과를 생성합니다.
select last_name, job_title 
from employees
join jobs using(job_id)
where job_title='Stock Manager' 
union
select last_name, job_title 
from employees
join jobs using(job_id) 
where job_title='Programmer' 
order by 2;

-- ex9) 컬럼명이 다른 경우의 SET operator
-- 쿼리1과 쿼리2의 select 목록은 반드시 동일(컬럼 개수, 데이터 타입)해야 하므로 이를 위해 
-- Dummy Column을 사용할 수 있습니다.
-- 첫 번째 SELECT 문에서는 last_name, employee_id, hire_date를 반환하고,
-- 두 번째 SELECT 문에서는 department_name, department_id, NULL을 반환하여 컬럼 수를 맞춥니다.
-- NULL은 빈 값을 의미하며, 컬럼의 개수를 맞추기 위해 사용되었습니다.
select last_name, employee_id, hire_date 
from employees
where department_id=20 
union
select department_name, department_id, NULL 
from departments
where department_id=20;
