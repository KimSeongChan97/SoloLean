-- 모든 테이블 목록 확인
select * from tab; 

-- 시퀀스 목록 확인
select * from user_sequences; 

-- employees 테이블 구조 확인
desc employees;

-- employees 테이블의 모든 사원의 번호, 이름, 급여 검색
select employee_id, last_name, salary from employees; 

-- 컬럼에 별명 붙이기 (as 는 생략가능)
select employee_id as 사원번호,  -- 사원번호 컬럼에 "사원번호"라는 별명 붙이기
last_name as "이 름",  -- last_name 컬럼에 "이 름"이라는 별명 붙이기
salary as "급 여" from employees;  -- salary 컬럼에 "급 여"라는 별명 붙이기

-- 연봉 = 급여 * 12, 사원번호와 이름 계산하여 출력
select employee_id 사원번호,  -- 사원번호 출력
last_name "이 름",  -- 이름 출력
salary * 12 "급여"  -- 연봉 계산하여 출력
from employees;

-- 연결연산자 || 사용하여 컬럼을 연결해서 출력, first_name과 last_name을 연결하여 출력
select first_name || ' ' || last_name as "이 름" from employees;  -- first_name과 last_name을 공백으로 연결하여 "이 름" 컬럼으로 출력

-- 2번째까지의 이름과 연봉을 표시 (연봉에 '달러' 추가)
select employee_id as 사원번호,  -- 사원번호 출력
first_name || ' ' || last_name as "이 름",  -- 이름 연결하여 출력
salary * 12 || '달러' as "연 봉"  -- 연봉 계산 후 '달러' 추가하여 출력
from employees
where rownum <= 2;  -- 결과를 2번째까지 제한

-- last_name과 job_id를 ' is a '로 연결하여 출력
select LAST_name || ' is a ' || job_id as "Employee Detail" from employees;  -- last_name과 job_id를 ' is a '로 연결하여 "Employee Detail" 컬럼으로 출력

-- 중복제거 distinct, employee 테이블에서 부서 ID를 출력
select DISTINCT department_id from employees;  -- department_id의 중복을 제거하고 출력

-- 10번 부서 또는 90번 부서 사원들의 이름, 입사일, 부서 ID를 출력
select last_name, hire_date, department_id
from employees
where department_id = 10 or department_id = 90;  -- department_id가 10 또는 90인 사원 출력

-- 급여가 2500 이상 3500 미만인 사원의 이름(last_name), 입사일, 급여를 검색
select last_name, hire_date, salary
from employees
where salary >= 2500 and salary < 3500;  -- salary가 2500 이상 3500 미만인 사원 출력

-- 급여가 2500 이하이거나 3000 이상이면서 90번 부서인 사원의 이름, 급여, 부서 ID를 출력
-- 조건1) 제목은 사원명, 월급, 부서코드
-- 조건2) 급여 앞에 $를 붙임
-- 조건3) 사원명은 first_name과 last_name을 연결하여 출력
select first_name || ' ' || last_name as "사원명",  -- 이름 연결하여 출력
'$' || salary as "월 급",  -- 급여 앞에 '$' 추가하여 출력
department_id as "부서 코드"  -- 부서 ID 출력
from employees
where (salary <= 2500 or salary >= 3000) and department_id = 90;  -- 조건에 맞는 사원 출력

-- 'King' 사원의 모든 컬럼을 표시
select * from employees where last_name = 'King';  -- last_name이 'King'인 사원 출력
select * from employees where lower(last_name) = 'king';  -- 대소문자 무시하고 'king'인 사원 출력

-- 업무 ID에 'MAN'이 포함되어 있는 사원들의 이름, 업무 ID, 부서 ID를 출력
select last_name, job_id, department_id
from employees
where job_id like '%MAN%';  -- job_id에 'MAN'이 포함된 사원 출력

-- 업무 ID가 'IT'로 시작하는 사원들의 이름, 업무 ID, 부서 ID를 출력
select last_name, job_id, department_id
from employees
where job_id like 'IT%';  -- job_id가 'IT'로 시작하는 사원 출력

-- is null / is not null 사용
-- 커미션을 받는 사원들의 이름과 급여, 커미션을 출력
select last_name, salary, commission_pct
from employees
where commission_pct is not null;  -- commission_pct가 null이 아닌 사원 출력

-- 커미션을 받지 않는 사원들의 이름과 급여, 커미션을 출력
select last_name, salary, commission_pct
from employees
where commission_pct is null;  -- commission_pct가 null인 사원 출력

-- in 연산자 (or 연산자의 다른 표현)
-- 업무 ID가 'FI_MGR'이거나 'FI_ACCOUNT'인 사원들의 사원번호, 이름, 직무를 출력
select employee_id, last_name, job_id
from employees
where job_id = 'FI_MGR' or job_id = 'FI_ACCOUNT';  -- job_id가 'FI_MGR' 또는 'FI_ACCOUNT'인 사원 출력

select employee_id, last_name, job_id
from employees
where job_id in ('FI_MGR', 'FI_ACCOUNT');  -- job_id가 'FI_MGR' 또는 'FI_ACCOUNT'인 사원 출력

-- between 연산자 (and의 다른 표현): 초과, 미만에서는 사용할 수 없다.
-- 급여가 10000 이상 20000 이하인 사원의 사원번호, 이름, 급여를 출력
select employee_id, last_name, salary
from employees
where salary >= 10000 and salary <= 20000;  -- salary가 10000 이상 20000 이하인 사원 출력

select employee_id, last_name, salary
from employees
where salary between 10000 and 20000;  -- salary가 10000 이상 20000 이하인 사원 출력

-- 업무 ID가 'SA_REP'이거나 'AD_PRES'이면서 급여가 10000을 초과하는 사원들의 이름, 업무, 급여를 출력
select first_name || ' ' || last_name as " 이 름 ",  -- 이름 연결하여 출력
job_id as "업 무",  -- 업무 ID 출력
salary || '원' as "급 여"  -- 급여 출력
from employees
where (job_id = 'SA_REP' or job_id = 'AD_PRES') and salary > 10000;  -- 조건에 맞는 사원 출력

select first_name || ' ' || last_name as " 이 름 ",  -- 이름 연결하여 출력
job_id as "업 무",  -- 업무 ID 출력
salary || '원' as "급 여"  -- 급여 출력
from employees
where job_id in('SA_REP', 'AD_PRES') and salary > 10000;  -- 조건에 맞는 사원 출력

-- Employees 테이블에서 업무 ID가 중복되지 않게 표기하는 질의를 작성
select DISTINCT job_id as "업 무"
from employees;  -- job_id의 중복을 제거하고 출력

-- 입사일이 2005년인 사원들의 사원번호, 이름, 입사일을 표시
select employee_id as "사원번호",  -- 사원번호 출력
first_name || ' ' || last_name as "이름",  -- 이름 연결하여 출력
hire_date as "입사일"  -- 입사일 출력
from employees
where to_char(hire_date, 'YYYY') = '2005';  -- hire_date의 연도가 2005년인 사원 출력

select employee_id as 사원번호,  -- 사원번호 출력
first_name || ' ' || last_name as 이름,  -- first_name과 last_name을 공백으로 연결하여 "이름" 컬럼으로 출력
hire_date as 입사일  -- 입사일 출력
from employees
where hire_date like '05%';  -- hire_date의 연도가 2005년인 사원 출력 (like 연산자를 사용하여 '05'로 시작하는 모든 hire_date 값 검색)
