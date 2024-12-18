-- 사원명, 부서ID, 입사일을 부서별로 내림차순 정렬
select last_name, department_id, hire_date
from employees 
order by 2 desc;  -- 부서ID(department_id)를 기준으로 내림차순 정렬

-- 사원명, 부서ID, 입사일을 부서별로 내림차순 정렬하시오
-- 같은 부서가 있을 때는 입사일순으로 정렬하시오
select last_name, department_id, hire_date 
from employees
order by 2 desc, 3 asc;  -- 부서ID(department_id)를 기준으로 내림차순 정렬한 후, 같은 부서 내에서 입사일(hire_date) 기준으로 오름차순 정렬

-- 사원들의 연봉을 구한 후 연봉 순으로 내림차순 정렬
-- 사원들의 연봉을 계산하고, 연봉 순으로 내림차순 정렬하여 출력
SELECT 
    employee_id AS 사원번호,  -- 사원번호를 출력
    first_name || ' ' || last_name AS 이름,  -- first_name과 last_name을 공백으로 연결하여 이름을 출력
    salary * 12 AS 연봉  -- salary를 12개월로 계산하여 연봉을 출력
FROM employees
ORDER BY 2 DESC, 1;  -- 연봉을 기준으로 내림차순 정렬

-- 이름을 소문자로 바꾼 후 검색
-- 'Higgins'사원의 사원번호, 이름, 부서번호를 검색하시오
select employee_id, last_name, department_id 
from employees
where lower(last_name)='higgins';  -- last_name을 소문자로 변환하여 'higgins'와 일치하는 사원 검색

-- 10을 3으로 나눈 나머지 구하시오(mod)
select mod(10, 3) from dual;  -- mod 함수로 10을 3으로 나눈 나머지 구하기, dual은 가상의 테이블

-- 35765.357을 반올림(round)
-- 위치가 n일 때 n이 양수이면 (n+1)에서 반올림이 되고
-- n이 음수이면 n의 위치에서 반올림 된다
select round(35765.357, 2) from dual;  -- 소수점 둘째 자리에서 반올림, 결과는 35765.36
select round(35765.357, 0) from dual;  -- 소수점 없이 반올림, 결과는 35765
select round(35765.357, -3) from dual;  -- 천의 자리에서 반올림, 결과는 36000

-- 35765.357을 내림(trunc)
-- 위치가 n일 때 n이 양수이면 (n+1)에서 내림이 되고
-- n이 음수이면 n의 위치에서 내림이 된다
select trunc(35765.357, 2) from dual;  -- 소수점 둘째 자리에서 내림, 결과는 35765.35
select trunc(35765.357, 0) from dual;  -- 소수점 없이 내림, 결과는 35765
select trunc(35765.357, -3) from dual;  -- 천의 자리에서 내림, 결과는 35000

-- concat('문자열1', '문자열2) : 문자열의 결합(문자열1 + 문자열2)
select concat('Hello', ' World') from dual;  -- 'Hello'와 ' World'를 결합하여 'Hello World' 출력
-- length('문자열') : 문자열의 길이
-- lengthb('문자열') : 문자열의 바이트 길이

-- char : 고정문자길이
-- varchar2 : 가변문자길이
create table text ( 
    str1 char(20),  -- 고정 길이 문자 데이터
    str2 varchar2(20)  -- 가변 길이 문자 데이터
);

insert into text(str1, str2) values('angel', 'angel');  -- 'angel' 문자열을 str1과 str2에 삽입
insert into text(str1, str2) values('사천사', '사천사');  -- '사천사' 문자열을 str1과 str2에 삽입
-- text 테이블의 각 컬럼의 바이트 길이와 문자 길이 조회
select lengthb(str1), lengthb(str2) from text;  -- 각 컬럼의 바이트 길이 조회
select length(str1), length(str2) from text;  -- 각 컬럼의 문자 길이 조회

-- 문자열의 길이와 바이트 길이 예시
select length('korea') from dual; -- 'korea' 문자열의 길이, 결과는 5
select length('코리아') from dual; -- '코리아' 문자열의 길이, 결과는 3 (한글 한 글자당 1로 계산)
select lengthb('korea') from dual; -- 'korea' 문자열의 바이트 길이, 결과는 5
select lengthb('코리아') from dual; -- '코리아' 문자열의 바이트 길이, 결과는 9 (한글 한 글자당 3바이트)

-- 문자열에서 지정한 문자의 위치 찾기 : : instr(표현식, 찾는 문자, [위치]) 양수: 앞(생략가능), 음수: 뒤
select instr('HelloWorld', 'W') from dual;  -- 'HelloWorld'에서 'W'의 위치, 결과는 6
select instr('HelloWorld', 'o', -5) from dual;  -- 'HelloWorld'에서 뒤에서 5번째부터 'o'의 위치, 결과는 5
select instr('HelloWorld', 'o', -1) from dual;  -- 'HelloWorld'에서 뒤에서부터 첫 번째 'o'의 위치, 결과는 7

-- 지정한 길이의 문자열을 추출 : substr(표현식, 시작, [개수])
select substr('I am very happy', 6, 4) from dual; -- 'I am very happy'에서 6번째 위치부터 4글자 추출, 결과는 'very'
select substr('I am very happy', 6) from dual; -- 'I am very happy'에서 6번째 위치부터 끝까지 추출, 결과는 'very happy'

-- 사원의 레코드를 검색하시오 (concat, length)
--조건1) 성과 이름을 연결하시오 (concat)
--조건2) 구해진 이름의 길이를 구하시오 (length)
--조건3) 이름이 n으로 끝나는 사원 (substr)
select employee_id,
concat(first_name, ' ' || last_name) as full_name, -- first_name과 last_name을 공백으로 연결하여 full_name으로 표시
length(concat(first_name, ' ' || last_name)) as name_length -- 연결된 이름의 길이를 name_length로 표시
from employees
where substr(last_name, -1, 1) = 'n'; -- last_name의 마지막 글자가 'n'인 사원 검색

-- 사원의 레코드를 검색하시오 (|| 연산자, length)
-- 조건1) 성과 이름을 연결하시오 (|| 연산자)
-- 조건2) 구해진 이름의 길이를 구하시오 (length)
-- 조건3) 이름이 n으로 끝나는 사원 (substr)
select employee_id,
first_name || ' ' || last_name as full_name,  -- first_name과 last_name을 공백으로 연결하여 full_name으로 표시
length(first_name || ' ' || last_name) as name_length -- 연결된 이름의 길이를 name_length로 표시
from employees
where substr(last_name, -1) = 'n'; -- last_name의 마지막 글자가 'n'인 사원 검색

-- 임의의 값이 지정된 범위 내에 어느 위치에 있는지를 찾는다
-- width_bucket(표현식, 최소값, 최대값, 구간)
-- 0-100까지의 구간을 나눈 후 74가 포함되어 있는 구간을 표시하시오
select width_bucket(74, 0, 100, 10) from dual;  -- 0에서 100까지를 10개의 구간으로 나누고 74가 속한 구간을 찾기, 결과는 8

-- 공백제거 : ltrim(왼), rtrim(오른), trim(양쪽)
select rtrim('test   ') || 'exam' from dual;  -- 오른쪽 공백 제거 후 'exam'과 결합, 결과는 'testexam'
select rtrim('test ') || 'exam' from dual;

-- sysdate : 시스템에 설정된 시간 표시
select sysdate from dual;  -- 현재 날짜와 시간 조회
select to_char(sysdate, 'YYYY"년" MM"월" DD"일"') as 오늘날짜 from dual;  -- 현재 날짜를 '년 월 일' 형식으로 표시
select to_char(sysdate, 'HH"시" MI"분" SS"초"') as 오늘날짜 from dual;  -- 현재 시간을 '시 분 초' 형식으로 표시
select to_char(sysdate, 'HH24"시" MI"분" SS"초"') as 오늘날짜 from dual;  -- 현재 시간을 24시간 형식으로 '시 분 초' 형식으로 표시

-- add_months(date, 달수) : 날짜에 달수 더하기
select add_months(sysdate, 5) from dual;  -- 현재 날짜에 7개월 더하기

-- last_day(date) : 해당 달의 마지막 날
select last_day(sysdate) from dual;  -- 현재 날짜의 해당 달의 마지막 날 조회
select last_day('2024-02-01') from dual; -- 2004년 2월의 마지막 날 조회, 결과는 2004-02-29 (윤년)
select last_day('2025-02-01') from dual; -- 2005년 2월의 마지막 날 조회, 결과는 2005-02-28

-- 오늘부터 이번 달 말까지 총 남은 날수를 구하시오
select last_day(sysdate) - sysdate as 남은날수 from dual;  -- 현재 날짜부터 해당 달의 마지막 날까지 남은 일 수 계산

-- months_between(date1, date2) : 두 날짜 사이의 달 수 (강제형변환)
select round(months_between('95-10-21', '94-10-20'), 0) from dual; -- 두 날짜 사이의 달 수를 반올림하여 계산, 결과는 12

-- 명시적인 변환(강제)
select last_name, to_char(salary, 'L99,999.00') -- 통화기준 L
from employees
where last_name = 'King';  -- last_name이 'King'인 사원의 급여를 통화 형식으로 변환하여 출력

-- 날짜 형식 변환 예시 :  년도의 앞의 2자리는 시스템의 날짜로부터 가져온다
select to_char(to_date('97/9/30', 'YY-MM-DD') , 'YYYY-MON-DD') from dual; -- 2097년 9월 30일로 변환
select to_char(to_date('97/9/30', 'RR-MM-DD') , 'RRRR-MON-DD') from dual; -- 1997년 9월 30일로 변환
select to_char(to_date('17/9/30', 'YY-MM-DD') , 'YYYY-MON-DD') from dual; -- 2017년 9월 30일로 변환
select to_char(to_date('17/9/30', 'RR-MM-DD') , 'RRRR-MON-DD') from dual; -- 2017년 9월 30일로 변환

-- 2005년 이전에 고용된 사원을 찾으시오
select last_name, to_char(hire_date, 'dd-mon-yyyy')
from employees
where hire_date < '2005-01-01'; -- 고용일이 2005년 1월 1일 이전인 사원 검색

-- fm 형식 : 형식과 데이터가 반드시 일치해야함(fm - fm 사이 값만 일치)
-- fm를 표시하면 숫자 앞의 0을 나타나지 않는다.
select last_name, hire_date from employees where hire_date = '05/09/30';
select last_name, hire_date from employees where hire_date = '05/9/30';
select last_name, hire_date from employees where hire_date = to_date('05/09/30', 'YY/MM/DD');

select to_char(sysdate, 'YYYY-MM-DD') from dual;  -- 현재 날짜를 'YYYY-MM-DD' 형식으로 출력
select to_char(sysdate, 'YYYY-fmMM-DD') from dual;  -- 현재 날짜를 'YYYY-fmMM-DD' 형식으로 출력, 월 앞의 0 제거
-- 날짜 형식 변환 예시
select to_char(to_date('2011-03-01', 'YYYY-MM-DD'), 'YYYY-MM-DD') from dual;  -- '2011-03-01'을 'YYYY-MM-DD' 형식으로 출력
select to_char(to_date('2011-03-01', 'YYYY-MM-DD'), 'YYYY-fmMM-DD') from dual;  -- '2011-03-01'을 'YYYY-fmMM-DD' 형식으로 출력, 월 앞의 0 제거
select to_char(to_date('2011-03-01', 'YYYY-MM-DD'), 'YYYY-fmMM-fmDD') from dual;  -- '2011-03-01'을 'YYYY-fmMM-fmDD' 형식으로 출력, 월과 일 앞의 0 제거

-- count(컬럼명), max(컬럼명), min(컬럼명), avg(컬럼명), sum(컬럼명) 함수
-- employees 테이블에서 급여의 최대, 최소, 평균, 합을 구하시오
-- 조건) 평균은 소수이하 절삭, 합은 세 자리마다 콤마 찍고 ￦표시
select max(salary),  -- 급여의 최대값
min(salary),  -- 급여의 최소값
trunc(avg(salary), 0),  -- 급여의 평균값을 소수 이하 절삭
to_char(sum(salary), 'L9,999,999')  -- 급여의 합을 세 자리마다 콤마 찍고 통화 형식으로 표시
from employees;

select count(*) from employees; -- 전체 사원 수
-- 커미션(commission_pct)을 받지 않은 사원의 인원수를 구하시오
select count(*) from employees where commission_pct is null;  -- 커미션을 받지 않은 사원의 인원수 계산
select count(nvl(commission_pct, 0)) from employees where commission_pct is null;
-- 전체 직원 수에서 커미션을 받지 않는 직원 수를 뺀 결과를 구하는 쿼리
SELECT 
(SELECT COUNT(*) FROM employees) - 
(SELECT COUNT(*) FROM employees WHERE commission_pct IS NULL) AS "커미션 받은 직원 수"
FROM dual;

-- employees 테이블에서 없는 부서를 포함해서 총 부서의 수를 구하시오
select department_id from employees; -- 107
select count(department_id) from employees; -- 106
select count(*) from employees; -- 107
select count(distinct department_id) from employees; -- 11
select count(distinct nvl(department_id, 0)) from employees; -- 12
select distinct nvl(department_id, 0) from employees; -- nvl은 null값을 0으로 대치


-- ① decode(표현식, 검색1,결과1, 검색2,결과2....[default])
-- : 표현식과 검색을 비교하여 결과 값을 반환 다르면 default 
-- ② case  value  when  표현식  then  구문1
--                when  표현식  then  구문2 
--                else  구문3
--                end case

-- 업무 ID가 'SA_MAN' 또는 ‘SA_REP'이면 'Sales Dept' 그 외 부서이면 'Another'로 표시
-- 조건) 분류별로 오름차순 정렬
select job_id, decode(job_id,
                    'SA_MAN', 'Sales Dept', 
                    'SA_REP', 'Sales Dept', 
                    'Another') "분류"
from employees 
order by 2;  -- 분류별로 오름차순 정렬

-- case 문 사용
select job_id, case job_id
                when 'SA_MAN' then 'Sales Dept' 
                when 'SA_REP' then 'Sales Dept' 
                else 'Another'
                end "분류"
from employees 
order by 2;  -- 분류별로 오름차순 정렬

select job_id, case
                when job_id = 'SA_MAN' then 'Sales Dept' 
                when job_id = 'SA_REP' then 'Sales Dept' 
                else 'Another'
                end "분류"
from employees 
order by 2;  -- 분류별로 오름차순 정렬

-- 급여가 10000 미만이면 초급, 20000 미만이면 중급 그 외면 고급을 출력하시오
-- 제목은 사원번호, 사원명, 구분으로 표시하시오
-- 구분 컬럼으로 오름차순 정렬하고, 같으면 사원명 컬럼으로 오름차순 하시오
-- case 사용하시오
select employee_id as 사원번호, 
first_name || ' ' || last_name as 사원명, 
    case 
        when salary < 10000 then '초급' 
        when salary < 20000 then '중급' 
        else '고급' 
    end as "구분"
from employees
order by 구분 asc, 사원명 asc;  -- 구분을 기준으로 오름차순 정렬, 같으면 사원명을 기준으로 오름차순 정렬
-- order by 3 asc, 2 asc;
-- order by 3, 2;

-- rank 함수 : 전체 값을 대상으로 순위를 구함
-- rank(표현식) within group(order by 표현식)
-- rank() over(쿼리 파티션)   → 전체 순위를 표시

-- 급여가 3000인 사람의 상위 급여 순위를 구하시오
select rank(3000) within group(order by salary desc) as "rank" from employees;  -- 급여가 3000인 사람의 상위 급여 순위 계산

-- 전체 사원의 급여 순위를 구하시오
select employee_id, salary, rank() over(order by salary desc) as "rank" from employees;  -- 전체 사원의 급여 순위 계산

-- first_value 함수 : 정렬된 값 중에서 첫 번째 값 반환
-- first_value(표현식) over(쿼리 파티션)
-- 전체 사원의 급여와 함께 각 부서의 최고급여를 나타내고 비교하시오
select employee_id,
salary, 
department_id,
first_value(salary) over(partition by department_id order by salary desc) 
as "highsal_deptID" 
from employees;

-- ★ PARTITION BY 절은 GROUP BY 절과 동일한 역할을 진행합니다.
-- 단, GROUP BY 절을 사용하지 않고 필요한 집합으로 행들을 그룹화 시킴
-- Partition by 절을 사용함으로 GROUP BY 절 없이 다양한 GROUPING 집합의 집계
-- 결과들을 함께 출력할 수 있습니다.
-- ORDER BY 절은 Partition by로 정의된 WINDOW 내에서의 행들의 정렬 순서를 정의합니다.
select employee_id,
last_name, 
salary, 
department_id,
row_number() over (PARTITION BY department_id ORDER BY salary DESC) as "부서ID 기준 내림차순" 
from employees;
-- 부서별 급여를 내림차순으로 정렬 했을 경우 Row Number
-- 부서 번호가 바뀔 때 Row Number는 새로 시작되는 것을 확인할 수 있습니다.
-- NULL 값은 정렬 시 가장 큰 값으로 인식 (기본설정)

-- 사원 테이블에서 사원번호, 사원명, 급여, 커미션, 연봉을 출력하시오
-- 연봉은 $ 표시와 세 자리마다 콤마를 사용하시오
-- 연봉 = 급여 * 12 + (급여 * 12 * 커미션)
-- 커미션을 받지 않는 사원도 포함해서 출력하시오
select employee_id as 사원번호, 
last_name as 사원명, 
salary as 급여, 
nvl(commission_pct, 0) as 커미션,  -- 커미션이 NULL인 경우
to_char(salary * 12 + (salary * 12 * nvl(commission_pct, 0)), 'L9,999,999') as 연봉  -- 연봉 계산 후 $ 표시와 세 자리마다 콤마 추가
from employees; -- 9,999 할시 #### 으로 자릿수 부족이 나옴

-- 커미션이 있는 경우
SELECT employee_id AS 사원번호, 
last_name AS 사원명, 
salary AS 급여, 
commission_pct AS 커미션,  -- 커미션 값을 그대로 표시
TO_CHAR(salary * 12 + (salary * 12 * commission_pct), 'L9,999,999') AS 연봉  -- 연봉 계산 후 $ 표시와 세 자리마다 콤마 추가
FROM employees
WHERE commission_pct IS NOT NULL;  -- 커미션이 있는 경우만 선택

-- 매니저가 없는 사원의 MANAGER_ID를 1000번으로 표시
-- 제목은 사원번호, 이름, 매니저ID
-- 모든 사원을 표시하시오
select employee_id as 사원번호, 
last_name as 이름, 
nvl(manager_id, 1000) as 매니저ID  -- 매니저가 없는 경우 manager_id를 1000으로 표시
from employees;

-- ---------------------------------------------------문제풀이
select sum(price) as 판매액
from sellings
where created_at like '%11%';
-- ----------------------------------------------------



