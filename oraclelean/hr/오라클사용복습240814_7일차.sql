--[ VIEW ]
--뷰(View)는 다른 테이블이나 뷰에 포함된 맞춤표현(virtual table)입니다.
--뷰는 실제로 데이터를 저장하지 않으며, 주로 복잡한 질의문을 간단하게 작성하거나 특정 데이터에 대한 접근을 제한할 때 유용합니다.
--뷰는 베이스 테이블(Base table)에서 데이터를 가져오며, 특정 컬럼이나 행을 필터링하여 보여줄 수 있습니다. 
--즉, 뷰는 베이스 테이블을 가공한 가상의 테이블로 볼 수 있습니다.
--
--뷰와 테이블의 차이점은 뷰는 실제로 데이터를 저장하지 않는다는 점입니다.
--베이스테이블(Base table): 뷰를 통해 보여지는 실제 테이블입니다.
--뷰는 선택적인 정보만 제공할 수 있습니다.
----[형식]
---- create [or replace] [force|noforce] view 뷰이름 [(alias [,alias,.....])] as 서브쿼리
---- [with check option [constraint 제약조건이름]]
---- [with read only [constraint 제약조건이름]]

---- create or replace: 뷰가 이미 존재하면 해당 뷰를 수정(replace)하고, 없으면 새로 생성합니다.
---- force: 베이스 테이블이 존재하지 않더라도 뷰를 생성할 수 있도록 강제로 생성합니다.
---- noforce: 베이스 테이블이 존재하는 경우에만 뷰를 생성합니다.
---- alias: 서브쿼리에서 선택한 컬럼에 대해 별칭(alias)을 지정할 수 있습니다. 서브쿼리의 컬럼 개수와 alias 개수는 일치해야 합니다.
---- with check option: 뷰에서 정의된 조건에 맞는 데이터만 삽입하거나 수정할 수 있도록 제한합니다.
---- with read only: 뷰를 읽기 전용으로 설정하여, 데이터 수정이 불가능하도록 합니다.

---- 뷰와 테이블의 차이점은 뷰는 실제로 데이터를 저장하지 않는다는 점입니다.
---- 즉, 뷰는 원본 테이블의 데이터를 기반으로 하며, 실시간으로 데이터를 조회할 때만 결과를 보여줍니다.
---- 뷰를 통해 선택적인 정보만 제공할 수 있습니다.

--[뷰 - 인라인(inline)개념]
--뷰에서 사용하는 서브쿼리(일반적으로 from 절에서 사용)는 인라인 뷰라고 불리며, 별칭을 사용하는 서브쿼리입니다. 인라인 뷰는 복잡한 쿼리문을 간단하게 만드는 데 유용합니다.
--
--[뷰 - Top N분석]
--Top N 분석은 조건에 맞는 최상위(또는 최하위) 레코드를 N개 식별해야 할 때 사용합니다. 예를 들어, 최상위 소득자 3명, 최근 6개월 동안 가장 많이 팔린 제품 3가지, 실적이 가장 좋은 영업사원 5명 등을 분석할 때 사용합니다.
--
--오라클에서 Top N 분석의 원리는 다음과 같습니다:
--
--원하는 순서대로 정렬합니다.
--rownum이라는 가상의 컬럼을 이용하여 순서대로 순번을 부여합니다.
--부여된 순번을 이용하여 필요한 수만큼 식별합니다.
--rownum값으로 특정 행을 선택할 수 없습니다 (단, Result Set의 첫 번째 행(rownum=1)은 선택 가능합니다).

----[문제1] 사원 테이블에서 부서가 90인 사원들의 정보를 v_view1이라는 이름의 뷰로 만드시오.
---- (사원ID, 사원이름, 급여, 부서ID를 포함합니다.)
create or replace view v_view1
as select employee_id, last_name, salary, department_id 
from employees
where department_id = 90;

---- 위에서 생성한 뷰 v_view1의 내용을 확인하는 쿼리입니다.
select * from v_view1;

---- 아래 DELETE 명령어는 뷰에서 데이터를 삭제하려는 시도입니다. 하지만,
---- 원본 테이블의 무결성 제약 조건에 의해 오류가 발생할 수 있습니다.
--delete from v_view1;
--ORA-02292: 무결성 제약조건(HR.DEPT_MGR_FK)이 위배되었습니다 - 자식 레코드가 발견되었습니다

----[문제2] 사원 테이블에서 급여가 5000 이상 10000 이하인 사원들의 정보를 v_view2라는 이름의 뷰로 만드시오.
---- (사원ID, 사원이름, 급여, 부서ID를 포함합니다.)
create or replace view v_view2
as select employee_id, last_name, salary, department_id 
from employees
where salary >= 5000 and salary <= 10000;

---- 위에서 생성한 뷰 v_view2의 내용을 확인하는 쿼리입니다.
select * from v_view2;

---- 다음은 v_view2 뷰에서 특정 사원의 급여를 수정하는 예제입니다.
---- 이 경우 원본 테이블의 데이터도 변경되며, 조건에 맞지 않는 경우 뷰에서 해당 데이터가 사라집니다.
update v_view2 set salary = 12000 where employee_id = 103;
select * from v_view2; -- 사원 ID 103번이 급여 조건에 맞지 않아서 뷰에서 제외되었습니다.
select * from employees where employee_id = 103; -- 원본 테이블에서도 급여가 변경되었음을 확인할 수 있습니다.

---- 원본 테이블의 데이터를 다시 원래대로 변경하여, v_view2 뷰에 사원 ID 103번이 다시 포함되도록 합니다.
update employees set salary = 9000 where employee_id = 103;
select * from employees where employee_id = 103;
select * from v_view2; -- 사원 ID 103번이 다시 포함되었습니다.

----[문제3] 사원 테이블과 부서 테이블을 조인하여 부서가 10번 또는 90번인 사원들의 정보를 v_view3라는 뷰로 만드시오.
---- 조건1) 부서가 10, 90인 사원만 표시합니다.
---- 조건2) 타이틀은 사원번호, 사원명, 부서명으로 출력합니다.
---- 조건3) 사원번호로 오름차순 정렬합니다.
create or replace view v_view3(사원번호, 사원명, 부서명)
as select e.employee_id, e.last_name, d.department_name 
from employees e
join departments d on e.department_id = d.department_id
where e.department_id in (10, 90)
order by e.employee_id;

---- v_view3 뷰의 데이터를 확인하기 위한 쿼리입니다.
select * from v_view3;

----[문제4] 부서 ID가 10번 또는 90번인 모든 사원들의 부서 위치(city)를 표시하는 v_view4 뷰를 만드시오.
---- 조건1) 타이틀은 사원번호, 사원명, 급여, 입사일, 부서명, 부서위치(city)로 표시합니다.
---- 조건2) 사원번호 순으로 오름차순 정렬합니다.
---- 조건3) 급여는 백 단위 절삭하고, 3자리마다 콤마와 '원'을 표시합니다.
---- 조건4) 입사일은 '2004년 10월 02일' 형식으로 표시합니다.
create or replace view v_view4(사원번호, 사원명, 급여, 입사일, 부서명, 부서위치)
as select e.employee_id, 
       e.last_name, 
       to_char(trunc(e.salary, -2), '999,999,999') || '원' as 급여, -- 급여를 백 단위로 절삭하고 3자리마다 콤마를 넣음
       to_char(e.hire_date, 'YYYY"년" MM"월" DD"일"') as 입사일, -- 입사일을 'YYYY년 MM월 DD일' 형식으로 표시
       d.department_name, 
       l.city as 부서위치
from employees e
join departments d on e.department_id = d.department_id
join locations l on d.location_id = l.location_id
where e.department_id in (10, 90)
order by e.employee_id;

---- v_view4 뷰의 데이터를 확인하기 위한 쿼리입니다.
select * from v_view4;

---- 뷰에서 컬럼에 별칭(alias)을 붙이지 않으면 ORA-00998 오류가 발생합니다.
---- 이 오류는 그룹 함수나 계산식에 별칭을 지정하지 않은 경우 발생합니다. 
---- 이 문제를 해결하려면 별칭을 지정해야 합니다.
---- 예를 들어 아래와 같은 방식으로 별칭을 추가합니다:
-- create or replace view v_view4 
-- as select e.employee_id,
-- last_name,
-- to_char(trunc(e.salary, -2), '999,999,999') || '원' as 급여, -- 별칭 추가
-- to_char(e.hire_date, 'YYYY"년" MM"월" DD"일"') as 입사일, -- 별칭 추가
-- department_name,
-- city as 부서위치 -- 별칭 추가
-- from employees e
-- join departments d on e.department_id = d.department_id
-- join locations l on d.location_id = l.location_id
-- where e.department_id in (10, 90)
-- order by e.employee_id;

----[문제5] 시퀀스를 사용하여 테이블을 생성하고 데이터를 삽입하는 방법에 대해 알아봅니다.
---- 다음의 조건에 맞게 테이블, 시퀀스, 뷰 객체를 작성하시오.
----
---- 1) bookshop 테이블을 작성한 후 데이터를 입력합니다.
---- ① 테이블명: bookshop
----    - isbn: varchar2(10), 기본키 (제약조건명: PISBN)
----    - title: varchar2(50), 책 제목, 널값 허용X (제약조건명: CTIT)
----    - author: varchar2(50), 저자
----    - price: number, 금액
----    - company: varchar2(30), 출판사
CREATE TABLE bookshop (
    isbn VARCHAR2(10) CONSTRAINT PISBN PRIMARY KEY, -- isbn 컬럼을 기본키로 설정, 제약조건명은 PISBN
    title VARCHAR2(50) CONSTRAINT CTIT NOT NULL, -- title 컬럼은 NULL 값을 허용하지 않음, 제약조건명은 CTIT
    author VARCHAR2(50), -- author 컬럼, NULL 값을 허용
    price NUMBER, -- price 컬럼, 책의 가격을 저장
    company VARCHAR2(30) -- company 컬럼, 출판사의 이름을 저장
);
---- ② 데이터 입력
---- 예시 데이터:
---- - is001, 자바3일완성, 김자바, 25000, 야메루출판사
---- - pa002, JSP달인되기, 이달인, 28000, 공갈닷컴
---- - or003, 오라클무작정따라하기, 박따라, 23500, 야메루출판사
INSERT INTO bookshop (isbn, title, author, price, company) 
VALUES ('is001', '자바3일완성', '김자바', 25000, '야메루출판사');
INSERT INTO bookshop (isbn, title, author, price, company) 
VALUES ('pa002', 'JSP달인되기', '이달인', 28000, '공갈닷컴');
INSERT INTO bookshop (isbn, title, author, price, company) 
VALUES ('or003', '오라클무작정따라하기', '박따라', 23500, '야메루출판사');
commit;
---- 입력된 데이터를 확인하기 위한 쿼리
select * from bookshop;
select constraint_name, constraint_type
from user_constraints
where table_name='BOOKSHOP';
---- 2) bookorder 테이블 작성
---- ① 테이블명: bookorder
----    - idx: number, 기본키, 일련번호
----    - isbn: varchar2(10), 외래키, bookshop 테이블의 isbn 컬럼을 참조 (제약조건명: FKISBN)
----    - qty: number, 수량
create table bookorder (
    idx number primary key, -- idx 컬럼을 기본키로 설정
    isbn varchar2(10) CONSTRAINT FKISBN REFERENCES bookshop(isbn), -- isbn 컬럼을 bookshop 테이블의 isbn 컬럼과 연결하는 외래키로 설정
    qty number -- qty 컬럼, 주문 수량을 저장
);
--
--create table bookorder (
--    idx number primary key, -- idx 컬럼을 기본키로 설정
--    isbn varchar2(10), -- isbn 컬럼, 도서의 ISBN을 저장
--    qty number, -- qty 컬럼, 주문 수량을 저장
--    constraint FKISBN foreign key(isbn) references bookshop(isbn) -- isbn 컬럼을 bookshop 테이블의 isbn 컬럼과 연결하는 외래키로 설정
--); -->> 위와 동일.

---- 제약조건을 확인하기 위한 쿼리
select * from bookorder;
select constraint_name, constraint_type
from user_constraints
where table_name='BOOKORDER';
---- 3) 시퀀스 객체 작성
---- 시퀀스명: idx_seq
---- 증가값: 1, 시작값: 1, NOCACHE, NOCYCLE
create SEQUENCE idx_seq
start with 1 -- 시퀀스 시작 값
INCREMENT by 1 -- 시퀀스 증가 값
nocache -- 캐시를 사용하지 않음
NOCYCLE; -- 시퀀스가 다시 초기값으로 돌아가지 않도록 설정
select * from seq; -- 시퀀스 확인 쿼리
-- sequence idx_seq nocycle nocahe;
---- 4) bookorder 테이블에 데이터를 입력하시오 (일련번호는 시퀀스 객체 이용)
---- 데이터 입력 예시:
---- - 1, is001, 2
---- - 2, or003, 3
---- - 3, pa002, 5
---- - 4, is001, 3
---- - 5, or003, 10
---- 시퀀스를 이용한 데이터 입력
INSERT INTO bookorder (idx, isbn, qty) VALUES (idx_seq.NEXTVAL, 'is001', 2);
INSERT INTO bookorder (idx, isbn, qty) VALUES (idx_seq.NEXTVAL, 'or003', 3);
INSERT INTO bookorder (idx, isbn, qty) VALUES (idx_seq.NEXTVAL, 'pa002', 5);
INSERT INTO bookorder (idx, isbn, qty) VALUES (idx_seq.NEXTVAL, 'is001', 3);
INSERT INTO bookorder (idx, isbn, qty) VALUES (idx_seq.NEXTVAL, 'or003', 10);
commit;
---- 5) 뷰 객체를 작성하시오
---- 뷰 명: bs_view
---- 조건1) 컬럼명 지정 (책제목, 저자, 총판매금액)
---- 조건2) 총판매금액은 qty * price로 하시오
---- 조건3) 수정불가의 제약조건을 추가하시오
---- 조건4) 책제목이 같은 것은 묶어서 출력하시오
---- 조건5) 총판매금액은 3자리마다 ,를 넣으시오
create or replace view bs_view (책제목, 저자, 총판매금액) -- 책제목, 저자, 총판매금액 컬럼을 포함하는 뷰를 생성 또는 대체합니다.
as select b.title as 책제목, -- bookshop 테이블에서 도서 제목을 가져와 '책제목'으로 별칭을 부여합니다.
             b.author as 저자, -- bookshop 테이블에서 저자 이름을 가져와 '저자'로 별칭을 부여합니다.
             to_char(sum(o.qty * b.price), '999,999,999') as 총판매금액 -- bookorder 테이블의 주문 수량과 bookshop 테이블의 도서 가격을 곱한 후, 이를 합산하여 총판매금액을 계산하고, 3자리마다 콤마를 넣어 문자열로 변환합니다.
from bookorder o -- bookorder 테이블을 o로 별칭 설정
join bookshop b on o.isbn = b.isbn -- bookorder 테이블의 isbn과 bookshop 테이블의 isbn을 기준으로 두 테이블을 조인합니다.
group by b.title, b.author -- 도서 제목과 저자를 기준으로 그룹화하여 각 도서 및 저자별 총판매금액을 계산합니다.
with read only; -- 생성된 뷰에 대해 읽기만 가능하도록 설정하여, 데이터를 수정할 수 없게 합니다.
--
--create or replace view bs_view (책제목, 저자, 총판매금액) -- 책제목, 저자, 총판매금액 컬럼을 포함하는 뷰를 생성 또는 대체합니다.
--as select title, -- bookshop 테이블에서 도서 제목을 가져옵니다.
--          author, -- bookshop 테이블에서 저자 이름을 가져옵니다.
--          to_char(sum(qty * price), '999,999,999') -- bookorder 테이블의 주문 수량과 bookshop 테이블의 도서 가격을 곱한 후, 이를 합산하여 총판매금액을 계산하고, 3자리마다 콤마를 넣어 문자열로 변환합니다.
--from bookshop -- bookshop 테이블에서 데이터를 조회합니다.
--join bookorder using(isbn) -- 두 테이블의 isbn 컬럼을 기준으로 조인합니다.
--group by (title, author) -- 도서 제목과 저자를 기준으로 그룹화하여 각 도서 및 저자별 총판매금액을 계산합니다.
--with read only; -- 생성된 뷰에 대해 읽기만 가능하도록 설정
--
---- 뷰의 데이터를 확인하기 위한 쿼리
select * from bs_view;
SELECT 책제목, 저자, 총판매금액 FROM bs_view; -- 컬럼명을 지정하여 데이터 확인
-- --------------------------------------------------------------------
-- sub Query ( select 안에 select )
-- 인라인은 select ~ from select 에서 from에 들어감. = select ~ from ( select ~ ) .
-- ex5) 뷰 - 인라인
-- 사원 테이블을 가지고 부서별 평균급여를 뷰(v_view7)로 작성하시오 
-- 조건1) 반올림해서 100단위까지 구하시오
-- 조건2) 타이틀은 부서ID, 부서평균
-- 조건3) 부서별로 오름차순 정렬 하시오
-- 조건4) 부서ID가 없는 경우 5000으로 표시하시오

-- 이 문제는 주어진 조건에 따라 부서별 평균 급여를 계산하고 이를 뷰로 만드는 작업입니다.
-- 각 조건을 만족시키기 위해 다음과 같은 SQL 쿼리를 작성할 수 있습니다.

create or replace view v_view7("부서ID", "부서평균") 
-- 뷰의 이름을 v_view7로 지정하고, 출력될 컬럼의 별칭을 "부서ID"와 "부서평균"으로 설정합니다.
as select nvl(department_id, 5000) as "부서ID",
-- department_id가 NULL인 경우 5000으로 표시하기 위해 NVL 함수(비어있는 값을 채움)를 사용합니다.
             round(avg(salary), -3) as "부서평균" 
-- 부서별 평균 급여를 계산한 후, 이를 100 단위로 반올림하여 출력합니다.
from employees
group by department_id 
-- 부서별로 그룹화하여 각 부서의 평균 급여를 계산합니다.
order by department_id asc;
-- 부서 ID를 기준으로 오름차순 정렬합니다.

-- 생성한 뷰의 내용을 확인하기 위해 다음과 같은 SELECT 문을 실행합니다:
select * from v_view7;

------------------------------------------ 
-- 이 부분은 인라인 뷰를 사용하는 예제입니다.
-- 인라인 뷰란, FROM 절에서 서브쿼리로 작성된 임시 테이블을 말합니다.
-- 주로 복잡한 쿼리를 간단하게 작성하거나 일시적인 가상 테이블을 생성하기 위해 사용됩니다.
-- 여기서는 인라인 뷰를 통해 부서별 평균 급여를 계산하고, 그 결과를 다시 외부 쿼리에서 사용합니다.

select 부서ID, 부서평균
-- 최종적으로 부서ID와 부서평균을 선택합니다.
from (
    select nvl(department_id, 5000) "부서ID",
           round(avg(salary), -3) "부서평균" 
    -- 내부 쿼리에서 부서별 평균 급여를 계산하고, 이를 100 단위로 반올림한 후, 부서ID가 NULL인 경우 5000으로 대체합니다.
    from employees
    group by department_id 
    order by department_id asc
);

-- [문제5] 
-- 5-1. 부서별 최대급여를 받는 사원의 부서명, 최대급여를 출력하시오 
-- 5-2. 5-1번 문제에 최대급여를 받는 사원의 이름도 구하시오

-- 문제 5-1:
-- 이 쿼리는 각 부서에서 가장 높은 급여를 받는 사원을 찾고, 그 사원의 부서명과 최대 급여를 출력합니다.
select d.department_name, -- 부서명 (부서 테이블의 department_name 컬럼을 선택합니다.)
       max(e.salary) as 최대급여 -- 해당 부서의 최대 급여 (사원 테이블의 salary 컬럼에서 각 부서의 최대값을 찾습니다.)
from employees e
-- employees 테이블의 별칭으로 e를 사용하여 사원 데이터를 참조합니다.
join departments d on e.department_id = d.department_id
-- employees 테이블과 departments 테이블을 부서 ID(department_id)로 조인하여 부서명과 사원의 데이터를 결합합니다.
group by d.department_name;
-- 부서명으로 그룹화하여 각 부서별 최대 급여를 계산합니다.
--JOIN: employees 테이블과 departments 테이블을 부서 ID를 기준으로 조인함으로써 각 사원이 속한 부서의 이름을 가져옵니다.
--GROUP BY: 부서명으로 그룹화하여, 각 부서에서 가장 높은 급여를 가진 사원을 찾습니다.
--MAX 함수: 그룹화된 부서별로 salary의 최대값을 계산합니다.

select department_name as 부서명, -- departments 테이블의 department_name 컬럼을 부서명으로 선택합니다.
       max(salary) as 최대급여 -- employees 테이블의 salary 컬럼에서 각 부서별 최대 급여를 구해 최대급여로 표시합니다.
from employees
-- employees 테이블을 참조합니다.
join departments using(department_id)
-- employees 테이블과 departments 테이블을 department_id를 기준으로 조인합니다.
group by department_name;
-- department_name으로 그룹화하여 각 부서별로 최대 급여를 계산합니다.

select 부서명, 최대급여 -- 서브쿼리에서 반환된 부서명과 최대급여를 선택합니다.
from (
    -- 서브쿼리 시작
    select department_name as 부서명, -- 부서명을 선택하고 부서명으로 표시합니다.
           max(salary) as 최대급여 -- 해당 부서의 최대 급여를 최대급여로 표시합니다.
    from employees
    -- employees 테이블을 참조합니다.
    join departments using(department_id)
    -- employees와 departments 테이블을 department_id로 조인합니다.
    group by department_name
    -- department_name으로 그룹화하여 각 부서별로 최대 급여를 계산합니다.
);
-- 서브쿼리의 결과에 대해 메인 쿼리에서 사용할 수 있도록 max_salaries라는 별칭을 부여합니다.


-- 문제 5-2:
-- 이 쿼리는 부서별 최대 급여를 받는 사원의 이름도 함께 출력합니다.
select d.department_name, -- 부서명 (부서 테이블에서 각 부서의 이름을 출력)
       e.last_name, -- 최대 급여를 받는 사원의 성 (사원 테이블에서 해당 사원의 last_name을 출력)
       e.salary as 최대급여 -- 최대 급여 (사원 테이블에서 해당 사원의 급여를 출력)
from employees e
-- employees 테이블의 별칭을 e로 설정하고 사원 데이터를 참조합니다.
join departments d on e.department_id = d.department_id
-- departments 테이블과 employees 테이블을 부서 ID로 조인하여 부서명과 사원의 데이터를 결합합니다.
where e.salary = (
    -- 이 서브쿼리는 각 부서에서 가장 높은 급여를 반환합니다.
    select max(salary) 
    from employees 
    where department_id = e.department_id
    -- 서브쿼리 내에서 department_id가 외부 쿼리의 department_id와 동일한 사원들의 급여 중 최대값을 구합니다.
)
order by d.department_name;
-- 결과를 부서명으로 정렬합니다.

select department_name as 부서명,
       last_name as 사원명,
       salary as 최대급여
from employees
join departments using(department_id)
-- departments와 employees 테이블을 department_id로 조인합니다.
where salary = (
    -- 서브쿼리를 사용하여 해당 부서에서 가장 높은 급여를 찾습니다.
    select max(salary)
    from employees
    where department_id = department_id
)
-- 조건에 맞는 사원들만 선택합니다.
order by department_name;
-- 결과를 부서명 기준으로 정렬합니다.      

select 이름, 부서명, 최대급여
-- 외부 쿼리에서 '이름', '부서명', '최대급여'를 선택합니다.
from (
    -- 서브쿼리 시작: 각 부서별로 최대 급여를 받는 사원의 정보를 가져옵니다.
    select last_name as 이름, -- 사원의 성(last_name)을 '이름'으로 선택합니다.
           department_name as 부서명, -- 부서 이름(department_name)을 '부서명'으로 선택합니다.
           salary as 최대급여 -- 사원의 급여(salary)를 '최대급여'로 선택합니다.
    from employees
    -- employees 테이블을 참조합니다.
    join departments using(department_id)
    -- employees 테이블과 departments 테이블을 department_id로 조인하여 각 사원이 속한 부서명을 가져옵니다.
    where (department_id, salary) = any 
    -- 이 조건은 서브쿼리의 결과와 일치하는 department_id와 최대급여(salary)를 가진 레코드만 필터링합니다.
    (select department_id, max(salary)
    -- 각 부서(department_id)에서 가장 높은 급여(max(salary))를 찾는 서브쿼리입니다.
    from employees
    -- employees 테이블을 참조하여 각 부서의 사원 급여 정보를 분석합니다.
    group by department_id
    -- 부서별로 그룹화하여 각 부서에서 가장 높은 급여를 계산합니다.
    )
);
-- 외부 쿼리는 서브쿼리의 결과를 사용하여 각 부서에서 최대 급여를 받는 사원의 이름, 부서명, 급여를 출력합니다.

select last_name as 이름, -- 사원의 성(last_name)을 '이름'으로 선택합니다.
       department_name as 부서명, -- 부서명(department_name)을 '부서명'으로 선택합니다.
       max(salary) over(partition by department_id) as 최대급여 -- 각 부서별 최대 급여를 '최대급여'로 선택합니다.
from employees
-- employees 테이블을 참조합니다.
join departments using(department_id)
-- employees 테이블과 departments 테이블을 department_id로 조인하여 부서명과 사원의 데이터를 결합합니다.
where (department_id, salary) = any 
-- 조건: department_id와 salary가 서브쿼리의 결과와 일치하는 레코드를 필터링합니다.
    (select department_id, max(salary)
    -- 서브쿼리: 각 부서(department_id)에서 가장 높은 급여(max(salary))를 구합니다.
    from employees
    -- employees 테이블을 참조하여 각 부서의 사원 급여 정보를 가져옵니다.
    group by department_id
    -- 부서별로 그룹화하여 각 부서에서 가장 높은 급여를 계산합니다.
    );
-- 외부 쿼리는 서브쿼리의 결과와 일치하는 사원들의 이름, 부서명, 그리고 그들의 최대급여를 출력합니다.
               
-- --------------------------------------
-- ex6) Top N분석
-- hidden column : rownum
-- 급여를 가장 많이 받는 사원 3명의 이름, 급여를 표시 하시오 
-- Top N 분석은 상위 N개의 레코드를 추출할 때 사용됩니다.
-- 여기서는 급여가 가장 높은 사원 3명의 이름과 급여를 출력합니다.

select rownum, -- 각 결과에 순번을 매깁니다.
       last_name, -- 사원 이름
       salary -- 사원의 급여
from (
    select last_name, nvl(salary,0) as salary 
    -- 급여가 NULL인 경우 0으로 처리하여 계산합니다.
    from employees order by salary desc 
    -- 급여를 기준으로 내림차순 정렬하여 상위 3명을 선택합니다.
    ) where rownum <= 3; 
-- 상위 3개의 레코드만 선택합니다.

-- ex7) 최고급여를 받는 사원 1명을 구하시오
-- 이 쿼리는 급여가 가장 높은 사원 1명을 출력합니다.
-- 주의: ROWNUM을 사용할 때, 특정 순번의 행만 선택하는 것은 예상과 다를 수 있습니다. 예를 들어 ROWNUM = 2와 같은 조건은 올바르게 동작하지 않을 수 있습니다.

select rownum, -- 결과에 순번을 매깁니다.
       last_name, -- 사원의 이름
       salary -- 사원의 급여
from (
    select last_name, 
           nvl(salary,0) as salary 
    from employees
    order by salary desc 
    -- 급여를 내림차순으로 정렬하여 가장 높은 급여를 받는 사원을 선택합니다.
) 
where rownum = 1; 
-- 급여가 가장 높은 사원 1명만 선택합니다.

-- ex8) 급여의 순위를 내림차순 정렬 했을 때, 3개씩 묶어서 2번째 그룹을 출력하시오 
-- 이 쿼리는 급여 순위에서 4, 5, 6위에 해당하는 사원들을 출력합니다.
-- 페이징 처리 기법을 사용하여, 순위를 3개씩 묶고 두 번째 페이지(그룹)를 선택합니다.
-- round / ceil 로 반올림. (페이지 번호 적용한다면...
select * from (
    select rownum, -- 결과에 순번을 매깁니다.
           ceil(rownum/3) as page, -- 순번을 3으로 나누어 페이지 번호를 매깁니다.
           tt.* 
    from (
        select last_name, nvl(salary, 0) as salary 
        -- 급여가 NULL인 경우 0으로 처리합니다.
        from employees order by salary desc 
        -- 급여를 내림차순으로 정렬합니다.
    ) tt ) where page = 2;
-- 두 번째 페이지(순위 4~6위)를 선택합니다.

-- 아래의 쿼리는 다른 방법으로 4, 5, 6위 사원들을 선택합니다.
select * 
from (
    select rownum rn, -- 결과에 순번을 매깁니다.
           tt.* 
    from (
        select last_name, 
               nvl(salary,0) as salary 
        from employees
        order by salary desc 
        -- 급여를 내림차순으로 정렬합니다.
    ) tt 
) 
where rn >= 4 and rn <= 6;
-- 순번이 4에서 6 사이에 있는 사원들을 선택합니다.

-- [문제6] 사원들의 연봉을 구한 후 최하위 연봉자 5명을 추출하시오 
-- 조건1) 연봉 = 급여*12+(급여*12*커미션)
-- 조건2) 타이틀은 사원이름, 부서명, 연봉 
-- 조건3) 연봉은 ￦25,000 형식으로 하시오
-- 이 문제는 사원의 연봉을 계산한 후, 연봉이 낮은 순서대로 5명의 사원을 추출하는 것입니다.
-- 연봉은 급여 * 12 + (급여 * 12 * 커미션)으로 계산됩니다.
-- 계산된 연봉은 '￦25,000' 형식으로 출력됩니다.
select * from(
    select rownum rn, tt.* 
    from (
        select last_name as 사원이름,
               department_name as 부서명,
               to_char((salary * 12) + (salary * 12 * nvl(commission_pct, 0)), 'L999,999') as 연봉
        from employees
        join departments using(department_id)
        order by 연봉 asc
    ) tt ) where rn <= 5; -- rownum으로 5명의 사원을 필터링.
-- 다른 답안 --------------------------
SELECT last_name AS 사원이름,  -- 'last_name' 컬럼을 '사원이름'이라는 별칭으로 선택
       department_name AS 부서명,  -- 'department_name' 컬럼을 '부서명'이라는 별칭으로 선택
       TO_CHAR(salary, 'L999,999,999') AS 연봉  -- 'salary' 값을 통화 형식으로 변환하여 '연봉'이라는 별칭으로 선택
FROM ( SELECT last_name,  -- 서브쿼리 내부에서 'last_name' 컬럼 선택
               department_name,  -- 서브쿼리 내부에서 'department_name' 컬럼 선택
               salary*1300* 12 + (salary*1300* 12 * nvl(commission_pct, 0)) AS salary  -- 연봉을 계산. 연봉은 기본 급여 * 12 + (커미션이 있는 경우 이를 포함하여 계산)
        FROM employees  -- 'employees' 테이블에서 데이터를 조회
        JOIN departments USING(department_id)  -- 'departments' 테이블과 'department_id' 컬럼을 기준으로 조인
        ORDER BY 3)  -- 계산된 연봉 기준으로 정렬 ('ORDER BY 3'는 세 번째 컬럼인 salary를 기준으로 정렬)
WHERE ROWNUM <= 5;  -- 서브쿼리의 결과 중에서 상위 5개의 행만 선택
--이 쿼리는 employees 테이블과 departments 테이블을 department_id를 기준으로 조인한 후, 각 사원의 연봉을 계산하여 상위 5명의 사원이름, 부서명, 연봉을 출력합니다.
--연봉 계산은 연간 기본 급여(salary * 12)에, 커미션 비율(commission_pct)이 있는 경우 이를 추가하여 계산합니다.
--TO_CHAR 함수를 사용해 연봉을 통화 형식으로 변환하고, ROWNUM을 사용해 상위 5명의 사원만 선택합니다.

-- [ SYNONYM ]
-- Synonym은 오라클 객체(테이블, 뷰, 시퀀스, 프로시저)에 대한 대체이름(Alias)를 말한다 
-- Synonym은 Object가 아니라 Object에 대한 직접적인 참조이다
-- 데이터베이스의 투명성을 제공하기 위해서 사용 한다 
-- 다른 유저의 객체를 참조할 때 많이 사용 한다
-- 객체의 긴 이름을 짧게 만들어 SQL 코딩을 단순화 할 수 있다
-- 객체의 실제 이름, 소유자, 위치를 감추기 때문에 데이터베이스의 보안을 유지할 수 있다 

-- * 종류
-- Private Synonym
-- 전용 Synonym은 특정 사용자만 사용할 수 있다 
-- Public Synonym
-- 공용 Synonym은 사용자 그룹이 소유하면 그 데이터베이스에 있는 모든 사용자가 공유한다 

-- Synonym은 주로 객체의 긴 이름을 짧게 줄이거나, 다른 사용자의 객체에 접근할 때 사용됩니다.
-- Public Synonym은 모든 사용자가 사용할 수 있으며, Private Synonym은 특정 사용자만 사용할 수 있습니다.

-- [형식]
-- CREATE [PUBLIC] SYNONYM 시노님이름 FOR 객체이름 

-- 아래는 Synonym 생성의 예시입니다.

-- [실습]
-- 1. HR 계정으로 접속해서 C##JAVA 계정에게 EMPLOYEES 테이블을 조작할 수 있는 권한 부여

-- HR 계정에서 실습
-- grant all on employees to c##java;

-- 여기서 HR 계정은 C##JAVA 계정에게 EMPLOYEES 테이블에 대한 모든 권한을 부여합니다.

-- 2. C##JAVA 계정에 접속해서 Synonym(동의어)를 생성
-- hr계정의 employees 테이블을 java계정에서 hr_emp 동의어로 사용한다 

-- CREATE SYNONYM Synonym이름 FOR 다른 계정의 테이블명

-- C##JAVA 계정에서 실습
-- create synonym hr_emp for hr.employees; 
-- ORA-01031: 권한이 불충분합니다

-- 이 오류는 Synonym을 생성할 권한이 없을 때 발생합니다.
-- Synonym을 생성하기 위해서는 적절한 권한이 필요합니다.

-- SYSTEM 계정(관리자 계정)에서 권한을 부여한다
-- SYSTEM 계정에서 실습
-- grant create synonym to c##java; 

-- 관리자 계정인 SYSTEM에서 C##JAVA 계정에 Synonym을 생성할 수 있는 권한을 부여합니다.

-- 다시 C##JAVA 계정에서
-- create synonym hr_emp for hr.employees; 
-- select * from user_synonyms;

-- 이제 C##JAVA 계정에서 HR 계정의 EMPLOYEES 테이블에 대한 Synonym을 생성할 수 있습니다.
-- 생성된 Synonym은 hr_emp라는 이름으로 접근할 수 있습니다.

-- 3. 쿼리
-- select * from hr.employees;
-- 이런 식으로 사용하면 SQL문이 길어질 때 테이블명이 길어서 문제가 되고
-- 다른 스키마(계정)에 있는 객체의 위치를 알려주게 되어 보안상 안 좋다
-- select * from hr_emp; - Synonym 이용
-- Synonym 이름을 짧게 하여 SQL문 길이도 줄이고 보안유지도 되기 때문에 사용 한다

-- Synonym을 사용하면 긴 테이블 이름을 짧게 줄일 수 있으며, 다른 스키마의 객체에 대해 간편하게 접근할 수 있습니다.

-- 4. 삭제
-- DROP SYNONYM 시노님명 
-- drop synonym hr_emp;
-- select * from user_synonyms;
-- Synonym 동의어가 삭제된 것을 확인할 수 있다

-- Synonym을 더 이상 사용하지 않을 때는 DROP SYNONYM 명령어로 삭제할 수 있습니다.
-- 삭제 후, user_synonyms 테이블에서 Synonym이 제거되었는지 확인할 수 있습니다.

-- [문제] C##JAVA 계정에서 HR 계정의 DEPARTMENTS 테이블의 시노님(HR_DEP)을 생성하시오
-- 이 문제는 C##JAVA 계정에서 HR 계정의 DEPARTMENTS 테이블에 대한 Synonym을 생성하는 것입니다.

-- C##JAVA 계정에서 다음과 같이 Synonym을 생성할 수 있습니다:
-- create synonym HR_DEP for hr.departments;
-- 이 명령어는 HR 계정의 DEPARTMENTS 테이블에 대한 Synonym HR_DEP를 생성합니다.
