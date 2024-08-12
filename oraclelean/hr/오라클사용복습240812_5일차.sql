-- employees 테이블에서 모든 사원의 정보를 조회합니다.
-- 이 쿼리는 모든 사원의 모든 열(column)을 반환합니다.
select * from employees;

-- departments 테이블에서 모든 부서의 정보를 조회합니다.
-- 이 쿼리는 모든 부서의 모든 열(column)을 반환합니다.
select * from departments;

-- ex1) Neena 사원의 부서명을 알아내시오
-- 1. Neena라는 이름을 가진 사원의 department_id를 조회합니다.
-- employees 테이블에서 first_name이 'Neena'인 사원의 department_id를 반환합니다.
select department_id from employees where first_name='Neena';
-- 위 쿼리는 'employees' 테이블에서 'Neena'라는 이름을 가진 사원을 검색한 뒤, 해당 사원의 부서 ID를 반환합니다.
-- 이 부서 ID는 이후의 쿼리에서 사용될 것입니다.

-- 2. 조회한 department_id를 이용하여 해당 부서명을 departments 테이블에서 조회합니다.
-- 위에서 조회한 department_id를 바탕으로 departments 테이블에서 해당 부서의 이름을 반환합니다.
-- 예시에서 Neena 사원의 department_id가 90이라고 가정하고, 해당 부서명을 조회합니다.
select department_name from departments where department_id=90;
-- 이 쿼리는 특정 부서 ID(이 경우 90)를 기준으로 'departments' 테이블에서 해당 부서의 이름을 조회합니다.
-- 실제 쿼리에서는 부서 ID를 하드코딩하지 않고, 첫 번째 쿼리에서 얻은 값을 사용할 것입니다.

-- 3. 서브쿼리를 이용하여 Neena 사원의 부서명을 직접적으로 조회합니다.
-- 먼저 서브쿼리에서 Neena 사원의 department_id를 조회하고, 
-- 그 department_id를 이용하여 departments 테이블에서 해당 부서명을 조회합니다.
select department_name from departments
where department_id = (select department_id from employees where first_name='Neena');
-- 서브쿼리를 사용하여, Neena 사원의 부서 ID를 먼저 조회한 후, 
-- 그 ID를 이용해 'departments' 테이블에서 해당 부서명을 찾습니다.
-- 서브쿼리는 메인 쿼리 내에서 실행되며, 메인 쿼리는 서브쿼리 결과를 이용해 최종 결과를 반환합니다.

-- ex2) Neena 사원의 부서에서 Neena 사원보다 급여를 많이 받는 사원들의 last_name, department_id, salary를 구하시오 (90, 17000)
-- 1. Neena 사원이 속한 부서(department_id)를 조회합니다.
-- 2. Neena 사원보다 급여가 높은 사원들을 같은 부서에서 조회합니다.
-- 서브쿼리를 이용하여 Neena 사원의 부서(department_id)와 급여(salary)를 각각 조회하고,
-- 해당 부서에서 Neena 사원보다 급여가 높은 사원들의 last_name, department_id, salary를 반환합니다.
select last_name, department_id, salary 
from employees
where department_id = (select department_id from employees where first_name='Neena') -- Neena 사원이 속한 부서의 department_id를 조회하여 필터링
and salary > (select salary from employees where first_name='Neena'); -- Neena 사원의 salary를 조회하여 필터링
-- 이 쿼리는 두 개의 서브쿼리를 사용하여 Neena 사원의 부서와 급여를 조회한 후, 
-- 해당 부서 내에서 Neena 사원보다 더 높은 급여를 받는 사원들의 정보를 반환합니다.
-- 서브쿼리를 이용해 필요한 정보를 추출하고, 메인 쿼리에서 그 조건에 맞는 사원을 필터링합니다.

-- [문제1] 최저급여를 받는 사원들의 이름과 급여를 구하시오
-- 1. 모든 사원 중에서 최저급여를 찾습니다.
-- employees 테이블에서 모든 사원의 salary 열 중에서 가장 낮은 값을 반환합니다.
select min(salary) from employees;
-- 'employees' 테이블에서 가장 낮은 급여를 반환합니다.
-- 'min' 함수는 주어진 컬럼의 최소값을 반환하는 함수입니다.

-- 2. 최저급여를 받는 사원들의 last_name과 salary를 조회합니다.
-- 위에서 찾은 최저급여와 같은 급여를 받는 사원들의 last_name과 salary를 반환합니다.
-- 예시에서는 2100이 최저급여라고 가정하고 해당 급여를 받는 사원들을 조회합니다.
select last_name, salary from employees where salary=2100;
-- 위 쿼리는 특정 급여(예: 2100)를 받는 사원들의 이름과 급여를 조회합니다.
-- 실제로는 첫 번째 쿼리에서 얻은 최저 급여값을 사용할 것입니다.

-- 위의 과정을 하나의 쿼리로 결합하여 작성할 수 있습니다.
-- 서브쿼리를 이용하여 최저급여를 구하고, 그 급여를 받는 사원들의 last_name과 salary를 반환합니다.
select last_name, salary
from employees
where salary = (select min(salary) from employees);
-- 이 쿼리는 서브쿼리를 통해 'employees' 테이블에서 가장 낮은 급여를 조회한 후, 
-- 그 급여를 받는 사원들의 정보를 반환합니다.
-- 서브쿼리의 결과는 메인 쿼리에서 조건으로 사용됩니다.

-- [문제2] 부서별 급여 합계 중 최대급여를 받는 부서의 부서명과 급여합계를 구하시오
-- 1. 부서별 급여 합계를 계산하고, 그 중에서 최대 급여 합계를 찾습니다.
-- 각 부서별 급여의 합계를 계산한 뒤, 그 중 가장 큰 값을 반환합니다.
-- employees 테이블에서 부서별로 그룹화(group by)하여 각 부서의 총 급여를 계산한 후, 
-- 그 중 최대 값을 찾습니다.
select max(sum(salary)) from employees GROUP by department_id; -- 그룹별 급여의 합계들 중 최대값을 먼저 구함.
-- 이 쿼리는 부서별 급여 합계를 구하고, 그 중 최대 합계를 찾습니다.
-- 'group by' 절은 데이터를 부서 ID별로 그룹화하고, 'sum' 함수는 각 그룹의 급여 합계를 계산합니다.
-- 'max' 함수는 이 합계들 중 가장 큰 값을 반환합니다.

-- 2. 그 부서의 이름과 급여 합계를 조회합니다.
-- 먼저, 부서별로 급여 합계를 계산하고, 그 중 최대 급여 합계를 가진 부서를 조회합니다.
-- 그런 다음, 해당 부서의 부서명(department_name)과 급여 합계(sum(salary))를 반환합니다.
select department_name, sum(salary)
from employees
join departments using(department_id)
group by department_name -- 부서명으로 그룹화하여 각 부서의 급여 합계를 계산합니다.
having sum(salary) = (select max(sum(salary)) from employees GROUP by department_id); -- 최대 급여 합계를 가진 부서를 필터링하여 조회합니다.
-- 이 쿼리는 'employees' 테이블에서 각 부서의 총 급여를 계산하고, 
-- 최대 급여 합계를 가진 부서의 이름과 그 합계를 반환합니다.
-- 'having' 절을 사용하여 최대 급여 합계를 가진 부서만을 필터링합니다.

-- ex3) Austin과 같은 부서이면서 같은 급여를 받는 사원들의 이름, 부서명, 급여를 구하시오 (Austin은 60부서, 4800달러)
-- 1. Austin 사원이 속한 부서(department_id)와 급여(salary)를 조회합니다.
-- 2. 해당 부서에서 동일한 급여를 받는 사원들의 last_name, department_name, salary를 조회합니다.
select last_name, department_name, salary 
from employees
left join departments using(department_id) -- 부서 ID를 기준으로 부서명을 조인하여 가져옵니다.
where department_id = (select department_id from employees where last_name='Austin') -- Austin의 부서를 찾음
and salary = (select salary from employees where last_name='Austin'); -- Austin의 급여를 찾음
-- 이 쿼리는 'Austin' 사원이 속한 부서와 동일한 급여를 받는 사원들의 정보를 조회합니다.
-- 두 개의 서브쿼리를 사용하여 Austin 사원의 부서 ID와 급여를 조회하고, 
-- 메인 쿼리에서 그 조건에 맞는 사원들을 필터링합니다.

-- ex4) 'ST_MAN' 직급보다 급여가 많은 'IT_PROG' 직급의 last_name, job_id, salary 직원들을 조회하시오 
-- 1. 'ST_MAN' 직급의 모든 사원들의 급여를 조회합니다.
-- 2. 'IT_PROG' 직급을 가진 사원들 중에서 'ST_MAN' 직급의 사원들보다 급여가 더 많은 사원들을 조회합니다.
select salary from employees where job_id='ST_MAN'; -- 5800~8200
select salary from employees where job_id='IT_PROG'; -- 4200~9000

select last_name, job_id, salary
from employees
where job_id = 'IT_PROG' 
and salary > any (select salary from employees where job_id='ST_MAN');
-- 이 쿼리는 'IT_PROG' 직급을 가진 사원들 중에서 'ST_MAN' 직급을 가진 사원들의 급여보다 높은 급여를 받는 사원들을 조회합니다.
-- 'any' 연산자는 서브쿼리의 결과 집합 중 하나라도 조건을 만족하면 true를 반환합니다.

-- [문제3] 'IT_PROG' 직급 중 가장 많이 받는 사원의 급여보다 더 많은 급여를 받는 'FI_ACCOUNT' 또는 'SA_REP' 직급 직원들을 조회하시오
-- 조건1) 급여 순으로 내림차순 정렬하시오
-- 조건2) 급여는 세 자리마다 콤마(,) 찍고 화폐단위 '원’을 붙이시오 
-- 조건3) 타이틀은 사원명, 업무ID, 급여로 표시하시오
select salary from employees where job_id='IT_PROG'; -- max=9000
select last_name as 사원명, job_id as 업무ID, to_char(salary*1*1365, '999,999,999')||'원' as 급여
from employees
where salary >= all (select salary from employees where job_id='IT_PROG') 
     and job_id in ('FI_ACCOUNT', 'SA_REP')
order by 3 desc;
-- 이 쿼리는 'FI_ACCOUNT' 또는 'SA_REP' 직급을 가진 사원들 중에서 
-- 'IT_PROG' 직급의 최고 급여보다 더 높은 급여를 받는 사원들을 조회합니다.
-- 'to_char' 함수를 이용해 급여를 포맷팅하고, 'order by' 절을 통해 급여 순으로 내림차순 정렬합니다.

-- ex5) 'IT_PROG'와 같은 급여를 받는 사원들의 이름, 업무ID, 급여를 전부 구하시오 
-- 1. 'IT_PROG' 직급을 가진 사원들의 급여를 조회합니다.
-- 2. 해당 급여를 받는 모든 사원들의 last_name, job_id, salary를 조회합니다.
select salary from employees where job_id='IT_PROG'; -- 4200~9000

select last_name, job_id, salary
from employees
where salary in (select salary from employees where job_id='IT_PROG'); 
-- 이 쿼리는 'IT_PROG' 직급의 사원들과 동일한 급여를 받는 다른 사원들을 조회합니다.
-- 'in' 연산자를 사용하여 서브쿼리에서 반환된 급여 값들과 일치하는 사원들을 필터링합니다.

select last_name, job_id, salary
from employees
where salary = any (select salary from employees where job_id='IT_PROG'); 
-- 위 쿼리와 동일한 결과를 반환하는 다른 방법입니다.
-- 'any' 연산자는 서브쿼리의 결과 집합 중 하나라도 조건을 만족하면 true를 반환합니다.

select last_name, job_id, salary
from employees
where salary=4200 or salary=4800 or salary=6000 or salary=9000;
-- 이 쿼리는 특정 급여를 수동으로 필터링하는 예제입니다.
-- 실제로는 서브쿼리를 사용하는 것이 더 효율적입니다.

-- ex6) 전체직원에 대한 관리자와 직원을 구분하는 표시를 하시오
-- ★ 방법1 (in 연산자)
-- 1. 관리자의 employee_id를 조회하여, 해당하는 사원은 '관리자'로 표시하고, 그렇지 않으면 '직원'으로 표시합니다.
-- 2. '구분' 열을 기준으로 정렬하여 출력합니다.
select distinct manager_id from employees;
-- 이 쿼리는 'employees' 테이블에서 중복된 값을 제거한 고유한 'manager_id' 목록을 반환합니다.
-- 'distinct' 키워드는 결과 집합에서 중복된 행을 제거하는 역할을 합니다.

select employee_id, last_name, manager_id as 구분
from employees
where manager_id=100;
-- 이 쿼리는 특정 'manager_id'(이 경우 100)를 가진 사원들을 조회합니다.
-- '구분'이라는 별칭을 사용하여 결과를 좀 더 의미 있게 표현합니다.

select employee_id as 사원번호, 
last_name as 이름, 
case 
    when employee_id in (select manager_id from employees) then '관리자' 
    else '직원'
end as 구분 
from employees 
order by 3,1;
-- 이 쿼리는 'case' 문을 사용하여 사원을 '관리자'와 '직원'으로 구분합니다.
-- 'employee_id'가 'manager_id'에 포함되면 '관리자'로 표시되고, 그렇지 않으면 '직원'으로 표시됩니다.
-- 'order by' 절을 사용하여 '구분'과 '사원번호' 순으로 정렬합니다.

-- ★ 방법2 (union, in, not in 연산자)
-- 1. '관리자'와 '직원'을 각각 구분하여 두 개의 쿼리를 union으로 결합합니다.
-- 2. '구분' 열을 기준으로 정렬하여 출력합니다.
select employee_id as 사원번호, last_name as 이름, '관리자' as 구분 
from employees
where employee_id in (select manager_id from employees) -- 관리자
union -- 결과의 집합체로 결합
select employee_id as 사원번호, last_name as 이름, '직원' as 구분 
from employees
where employee_id not in (select manager_id from employees where manager_id is not null) -- 직원
order by 3,1;
-- 이 쿼리는 '관리자'와 '직원'을 각각 조회한 후, 그 결과를 'union'으로 결합합니다.
-- 'union' 연산자는 두 개 이상의 쿼리 결과를 하나로 결합할 때 사용됩니다.
-- 'order by' 절을 사용하여 결과를 정렬합니다.

-- ★ 방법3 (상관 쿼리 이용) : 관계가 있는지를 확인 ( True / False )
-- 1. 상관 서브쿼리를 이용하여 employee_id가 manager_id로 존재하는지를 확인합니다.
-- 2. '구분' 열을 기준으로 정렬하여 출력합니다.
select employee_id as 사원번호, last_name as 이름, '관리자' as 구분
from employees e
where exists (select null from employees where e.employee_id=manager_id) -- 관계가 있는지?(관리자)
union
select employee_id as 사원번호, last_name as 이름, '직원' as 구분 
from employees e
where not exists (select null from employees where e.employee_id=manager_id) -- 관계가 없는지?(직원)
order by 3, 1;
-- 이 쿼리는 상관 서브쿼리를 사용하여 'employee_id'가 'manager_id'로 존재하는지를 확인합니다.
-- 'exists' 연산자는 서브쿼리가 결과를 반환하면 true를 반환합니다.
-- 'union'으로 관리자와 직원을 구분한 후, 'order by'로 결과를 정렬합니다.

-- [문제4] 자기 업무id(job_id)의 평균급여를 받는 직원들을 조회하시오
-- 조건1) 평균급여는 100단위 이하 절삭하고 급여는 세자리마다 콤마, $표시
-- 조건2) 사원이름(last_name), 업무id(job_id), 직무(job_title), 급여(salary) 로 표시하시오 
-- 조건3) 급여순으로 오름차순 정렬하시오
select job_id, trunc(avg(salary), -3) from employees group by job_id; -- 평균 구함(100단위 절삭)
-- 이 쿼리는 각 직무 ID별로 평균 급여를 계산합니다.
-- 'trunc' 함수는 소수점 이하를 절삭하며, '-3'을 사용하여 100단위 이하를 절삭합니다.

select last_name as 사원이름, job_id as 업무id, job_title as 직무, 
        to_char(salary, '$999,999') as 급여
from employees
join jobs using(job_id)
where (job_id, salary) in (select job_id, trunc(avg(salary), -3) from employees group by job_id)
order by 4;
-- 이 쿼리는 자기 직무 ID의 평균 급여를 받는 사원들을 조회합니다.
-- 'join'을 사용하여 직무 ID에 대한 자세한 정보를 가져오고, 
-- 'to_char' 함수를 사용하여 급여를 포맷팅합니다.
-- 'order by' 절을 사용하여 급여 순으로 오름차순 정렬합니다.

-- ex7) group by rollup : a, b별 집계(Subtotal 구하기)
-- 부서별, 직무ID별 급여평균구하기(동일부서에 대한 직무별 평균급여) 
-- 조건1) 반올림해서 소수 2째자리까지 구하시오
-- 조건2) 제목은 Job_title, Department_name, Avg_sal로 표시하시오 
-- 1. department_name과 job_title을 기준으로 group by rollup을 사용하여 각 조합의 평균 급여를 계산합니다.
-- 2. 소수점 2째자리까지 반올림하여 출력합니다.
select department_name, job_title, round(avg(salary), 2) as "Avg_sal" 
from employees
join departments using(department_id) 
join jobs using(job_id)
group by rollup(department_name, job_title); 
-- 이 쿼리는 'rollup'을 사용하여 부서별, 직무별, 그리고 전체 합계를 계산합니다.
-- 'round' 함수를 사용하여 평균 급여를 소수점 두 번째 자리까지 반올림합니다.
-- 'rollup'은 여러 수준의 그룹화된 데이터를 포함하는 집계 결과를 생성합니다.

-- ex8) group by cube :   a별 집계 또는 b별 집계
-- 부서별, 직무ID별 급여평균구하기(부서를 기준으로 나타내는 평균급여) 
-- 1. department_name과 job_title을 기준으로 group by cube를 사용하여 각 조합의 평균 급여를 계산합니다.
-- 2. 소수점 2째자리까지 반올림하여 출력합니다.
select department_name, job_title, round(avg(salary), 2) as "Avg_sal" 
from employees
join departments using(department_id) 
join jobs using(job_id)
group by cube(department_name, job_title);
-- 이 쿼리는 'cube'를 사용하여 부서와 직무의 모든 조합에 대한 평균 급여를 계산합니다.
-- 'cube'는 다차원 그룹화를 수행하여 가능한 모든 조합의 집계 결과를 생성합니다.
-- 'round' 함수를 사용하여 결과를 소수점 두 번째 자리까지 반올림합니다.

-- ex9) group by grouping sets
-- 직무별 평균급여와 전체사원의 평균급여를 함께 구하시오 
-- 1. grouping sets을 사용하여 직무별 평균 급여와 전체 평균 급여를 각각 계산하여 조회합니다.
select job_title, round(avg(salary), 2) as "Avg_sal" 
from employees
join departments using(department_id) 
join jobs using(job_id)
group by grouping sets((job_title), ( )); -- ← () All Rows의 역활
-- 이 쿼리는 'grouping sets'을 사용하여 직무별 평균 급여와 전체 평균 급여를 계산합니다.
-- 'grouping sets'은 특정 집합의 그룹화 결과를 생성하는데 사용됩니다.
-- 'round' 함수를 사용하여 평균 급여를 소수점 두 번째 자리까지 반올림합니다.
