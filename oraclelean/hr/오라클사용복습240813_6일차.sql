--[테이블생성]
-- 테이블을 생성하는 구문입니다.
--create table 테이블명(컬럼명1 컬럼타입   [제약조건],
--컬럼명2 컬럼타입   [제약조건],.....);
--   테이블 이름은 문자로 시작해야 하며, 최대 30자까지 가능합니다.
--   허용되는 문자는 영문 대소문자, 숫자, 특수문자( _ , $ , # ), 한글입니다.
--   중복되는 이름을 사용할 수 없으며, 예약어(create, table, column 등)는 테이블 이름으로 사용할 수 없습니다.
--   데이터 타입과 컬럼의 특성을 정의하여 테이블을 생성할 수 있습니다.

---   데이터 타입 설명
--number : number(전체자리, 소수이하), 숫자형 데이터 타입입니다. 전체 자리수와 소수 이하 자리수를 지정할 수 있습니다.
--int : 정수형 숫자 데이터 타입으로, 소수점 없이 고정된 숫자를 저장합니다.
--varchar/varchar2 : 가변 길이의 문자형 데이터 타입입니다. 최대 4000바이트까지 저장 가능합니다.
--char : 고정 길이의 문자형 데이터 타입으로, 최대 2000바이트까지 저장 가능합니다.
--date : 날짜형 데이터 타입으로, 날짜와 시간을 저장할 수 있습니다.
--clob : 대용량 문자형 데이터 타입으로, 최대 4GB까지 저장할 수 있습니다.
--blob : 바이너리형 데이터 타입으로, 이미지, 음악, 동영상 등의 데이터를 저장할 수 있으며, 최대 4GB까지 저장 가능합니다.

--- 제약조건 설명
--not null : 컬럼에 NULL 값이 저장되지 않도록 강제하는 제약 조건입니다. (컬럼 수준)
--unique  : 해당 컬럼이나 컬럼 조합이 유일한 값을 가져야 함을 보장하는 제약 조건입니다. (컬럼, 테이블 수준)
--primary key : 테이블의 각 행을 유일하게 식별하는 기본 키를 설정하는 제약 조건입니다. (컬럼, 테이블 수준)
--references table(column) : 해당 컬럼이 참조하는 부모 테이블의 특정 컬럼과 일치하거나 NULL이어야 함을 보장합니다. 외래 키 제약 조건입니다. (컬럼, 테이블 수준)
--check : 특정 조건을 만족해야만 값이 유효한 것으로 간주되는 제약 조건입니다. (컬럼, 테이블 수준)
--[참고] primary key는 unique와 not null 제약 조건이 결합된 형태입니다.
--
--- 제약조건 확인 관련 구문
--constraint_name: 제약 조건의 이름을 나타냅니다.
--constraint_type: 제약 조건의 유형을 나타냅니다.
--P : primary key (기본 키 제약 조건)
--U : unique (고유 제약 조건)
--R : reference (외래 키 제약 조건)
--C : check, not null (체크 제약 조건, NOT NULL 제약 조건)
--search_condition : check 제약 조건에 지정된 조건식을 나타냅니다.
--r_constraint_name : 참조 테이블의 primary key 이름을 나타냅니다.
--delete_rule : 참조 테이블의 primary key 컬럼이 삭제될 때 적용되는 규칙을 나타냅니다.
--(no action, set null, cascade 등)

--- 삭제 RULE
--on delete cascade
--: 참조 테이블에서 삭제된 데이터를 참조하는 데이터도 함께 삭제됩니다.
--on delete set null
--: 참조 테이블의 데이터를 삭제한 후, 해당 데이터를 참조하는 컬럼의 값은 NULL로 변경됩니다.
--on delete restricted
--: 참조 테이블의 데이터를 삭제할 수 없도록 제한합니다. 기본값으로 설정됩니다.
--- 수정 RULE
--on update cascade
--: 참조 테이블의 데이터를 수정할 때, 참조 관계에 있는 테이블의 데이터도 함께 수정됩니다.

--[테이블수정]
--- 테이블을 수정하는 구문입니다.
--alter table 테이블명 
--add 컬럼명 데이터타입 [제약조건] : 테이블에 새로운 컬럼을 추가합니다.
--add constraint 제약조건명 제약조건타입(컬럼명) : 기존 컬럼에 제약 조건을 추가합니다.
--modify 컬럼명 데이터타입 : 기존 컬럼의 데이터 타입을 변경합니다.
--drop column 컬럼명 [cascade constraints] : 테이블에서 컬럼을 삭제합니다.
--drop primary key [cascade] | union (컬럼명,.....) [cascade] .... | constraint 제약조건명 [cascade] : 테이블의 기본 키나 제약 조건을 삭제합니다.
--- 테이블 및 컬럼, 제약 조건 이름을 변경하는 구문
--alter table 기존테이블명 rename to 새테이블명 : 테이블 이름을 변경합니다.
--alter table 테이블명 rename column 기존컬럼명 to 새컬럼명 : 컬럼 이름을 변경합니다.
--alter table 테이블명 rename constraint 기존제약조건명 to 새제약조건명 : 제약 조건 이름을 변경합니다.

--[테이블복사]
--- 서브쿼리를 이용하여 테이블을 생성하고, 데이터를 복사하는 방법입니다.
--- 서브쿼리를 이용해 테이블을 복사하면, not null을 제외한 다른 제약 조건은 복사되지 않습니다. (not null 제약 조건도 sys_*****라는 시스템이 생성한 이름으로 복사됩니다.)
--- 테이블 구조만 복사하는 구문 -
--create table 테이블명1 as select * from 테이블명2 where 1=0 : 기존 테이블의 구조만을 복사하고 데이터는 복사하지 않습니다.

--[시퀀스]
-- 시퀀스는 순차적으로 증가하거나 감소하는 정수 값을 자동으로 생성하는 객체입니다.
--create sequence 시퀀스명 [increment by 증가값] [start with 시작값] [maxvalue 최대값 | minvalue 최소값] [cycle | nocycle] [cache | nocache]
--- increment by : 시퀀스 값이 증가/감소하는 간격을 지정합니다. 기본값은 1입니다.
--- start with : 시퀀스의 시작값을 지정합니다. 기본값은 1입니다.
--- maxvalue / minvalue : 시퀀스의 최대값 및 최소값을 지정합니다.
--- cycle/nocycle : 시퀀스가 최대값/최소값에 도달했을 때 다시 시작할지 여부를 지정합니다.
--- cache / nocache : 시퀀스 값을 메모리에 캐시할지 여부를 지정합니다. 캐시 크기의 최소값은 2이며, 기본값은 20입니다.

--[ insert ]
-- 테이블에 새로운 데이터를 추가하는 구문입니다.
--insert into 테이블명 [ (column1, column2, .....)] values (value1,value2,.....)
--- column과 values의 순서가 일치해야 합니다.
--- column과 values의 개수도 일치해야 합니다.

--[ update ]
-- 테이블에 저장된 기존 데이터를 수정하는 구문입니다.
-- 전체 데이터의 건수(행 수)는 달라지지 않으며, 조건에 맞는 행의 컬럼 값을 갱신할 수 있습니다.
--update 테이블명 set 컬럼명1=value1, 컬럼명2=value2 ..... [where 조건절] 
--- where 절이 생략되면 전체 행이 갱신됩니다.
--- set 절에서는 서브쿼리를 사용하거나 기본값(default) 옵션을 사용할 수 있습니다.

--[ delete ]
-- 테이블에 저장된 기존 데이터를 삭제하는 구문입니다.
-- 행 단위로 삭제되므로 전체 행 수가 달라집니다.
--delete [from] 테이블명 [where 조건절];
--- where 절을 생략하면 모든 행이 삭제됩니다.
--- 데이터는 삭제되지만 테이블의 구조는 유지됩니다.

--[ truncate ]
-- 테이블의 데이터를 전부 삭제하고, 사용 중이던 공간을 반납하는 구문입니다.
-- 해당 테이블의 모든 데이터가 삭제되지만 테이블 자체가 삭제되는 것은 아닙니다.
-- 해당 테이블에 생성되어 있던 인덱스도 함께 삭제됩니다.
--TRUNCATE TABLE 테이블명;
--DELETE 구문은 데이터만 삭제되며, 사용 중이던 디스크 공간은 그대로 유지됩니다. 반면, TRUNCATE 구문은 최초 테이블이 만들어졌던 상태로 돌아가 데이터와 관련된 모든 정보를 삭제합니다.
-- TRUNCATE 작업은 인덱스 등도 모두 삭제하므로 용량이 줄어들게 됩니다. 하지만, WHERE 절을 사용할 수 없으므로 DELETE 구문과는 차이가 있습니다.
--DROP 명령어는 데이터와 테이블 전체를 삭제하고, 사용 중이던 공간도 반납합니다. 또한 인덱스나 제약 조건 등도 함께 삭제됩니다.

--[ transaction처리 ]
-- 트랜잭션 처리 구문으로, 작업이 시작되면 commit을 통해 완벽하게 마무리됩니다.
-- 처리 도중 장애가 발생하면 rollback을 통해 트랜잭션 이전 상태로 되돌아갑니다.

-- ex1) 테이블 : test 
create table test(
    id number(5),             -- id 컬럼은 숫자 데이터 타입으로, 최대 5자리의 숫자를 저장할 수 있습니다.
    name char(10),            -- name 컬럼은 고정 길이의 문자형 데이터로, 최대 10자를 저장합니다.
    address varchar2(50)      -- address 컬럼은 가변 길이의 문자형 데이터로, 최대 50자를 저장할 수 있습니다.
);

-- ex2) 테이블 : user1 
create table user1(
    idx       number primary key,                           -- idx 컬럼은 기본키로 설정되어 중복되지 않는 유일한 값을 가져야 합니다.
    id        varchar2(10) unique,                          -- id 컬럼은 고유 제약 조건을 가지며, 중복된 값을 허용하지 않습니다.
    name      varchar2(10) not null,                        -- name 컬럼은 NULL 값을 허용하지 않도록 설정되어 있습니다.
    phone     varchar2(15),                                 -- phone 컬럼은 최대 15자의 가변 길이 문자열을 저장할 수 있습니다.
    address   varchar2(50),                                 -- address 컬럼은 최대 50자의 가변 길이 문자열을 저장할 수 있습니다.
    score     number(6,2) check(score >= 0 and score <= 100), -- score 컬럼은 소수점 이하 2자리까지 최대 6자리의 숫자를 저장하며, 값은 0과 100 사이여야 합니다.
    subject_code number(5),                                 -- subject_code 컬럼은 최대 5자리의 숫자를 저장할 수 있습니다.
    hire_date date default sysdate,                         -- hire_date 컬럼은 날짜형이며 기본값으로 현재 날짜가 설정됩니다.
    marriage  char(1) default 'N' check(marriage in('Y', 'N')) -- marriage 컬럼은 기본값으로 'N'이 설정되며, 'Y' 또는 'N'만 허용됩니다.
); 

-- ex3) 제약조건 확인
-- 테이블의 제약조건을 확인하는 SQL 문입니다.
select constraint_name, constraint_type 
from user_constraints
where table_name='USER1'; 

select *
from user_constraints 
where table_name='USER1';

-- ex4) 테이블 
-- user2 테이블을 생성하고, 각 컬럼에 대한 제약조건을 명명하여 관리합니다.
create table user2(
    idx       number            constraint PKIDX primary key, -- idx 컬럼을 기본키로 설정하고, 제약조건 이름을 PKIDX로 지정합니다.
    id        varchar2(10)      constraint UNID unique,        -- id 컬럼을 고유 제약조건으로 설정하고, 제약조건 이름을 UNID로 지정합니다.
    name      varchar2(10)      constraint NOTNAME not null,   -- name 컬럼에 NULL을 허용하지 않는 제약조건을 추가하고, 이름을 NOTNAME으로 지정합니다.
    phone     varchar2(15),                                    -- phone 컬럼에는 별도의 제약조건이 없습니다.
    address   varchar2(50),                                    -- address 컬럼에는 별도의 제약조건이 없습니다.
    score     number(6,2)       constraint CKSCORE check(score >= 0 and score <= 100), -- score 컬럼에 0에서 100 사이의 값만 허용하는 제약조건을 추가하고, 이름을 CKSCORE로 지정합니다.
    subject_code number(5),                                    -- subject_code 컬럼에는 별도의 제약조건이 없습니다.
    hire_date date default sysdate,                            -- hire_date 컬럼은 기본값으로 현재 날짜를 설정합니다.
    marriage  char(1) default 'N' constraint CKMARR check(marriage in('Y','N')) -- marriage 컬럼에 기본값으로 'N'을 설정하고, 'Y' 또는 'N'만 허용하는 제약조건을 추가합니다.
);

-- ex5) 제약조건 확인
-- user2 테이블의 제약조건을 조회하는 SQL 문입니다.
select constraint_name, constraint_type 
from user_constraints
where table_name='USER2'; 

select *
from user_constraints 
where table_name='USER2';

-- ex6) 추가
-- user1 테이블에 데이터를 삽입하는 예제입니다. 각 행은 제약조건을 따릅니다.
insert into user1(idx,id,name,phone,address,score,subject_code,hire_date,marriage) 
values(1,'aaa','kim','010-000-0000','서울',75,100,'2010-08-01','Y');

insert into user1(idx,id,name,phone,address,score,subject_code,hire_date,marriage) 
values(1,'aaa','kim','010-000-0000','서울',75,100,'2010-08-01','Y'); 
-- → 무결성제약조건에 위배(이유: idx  1 중복)
insert into user1(idx,id,name,phone,address,score,subject_code,hire_date,marriage) 
values(2,'aaa','kim','010-000-0000','서울',75,100,'2010-08-01','Y'); 
-- → 무결성제약조건에 위배(이유: id   aaa 중복)
insert into user1(idx,id,name,phone,address,score,subject_code,hire_date,marriage) 
values(2,'bbb','','010-000-0000','서울',75,100,'2010-08-01','Y');
-- → NULL을 ("HR"."USER1"."NAME") 안에 삽입할 수 없습니다
insert into user1(idx,id,name,phone,address,score,subject_code,hire_date,marriage) 
values(2,'bbb','lee','010-000-0000','서울',120,100,'2010-08-01','Y');
-- → 체크 제약조건에 위배되었습니다(이유: score가 0~100사이의 수 이어야함) 
insert into user1(idx,id,name,phone,address,score,subject_code,hire_date,marriage)
values(2,'bbb','lee','010-000-0000','서울',75,100,'2010-08-01','K');
-- → 체크 제약조건에 위배되었습니다(이유 : marriage가 Y 또는 N 이어야함)
insert into user1(idx,id,name,phone,address,score,subject_code,hire_date,marriage) 
values(2,'bbb','lee','010-000-0000','서울',75,100,'2010-08-01','N');

-- ex7) 테이블 목록 확인 
-- 현재 데이터베이스에 있는 테이블 목록을 확인합니다.
select * from tab;

-- ex8) 테이블의 레코드(내용) 확인 
-- user1 및 user2 테이블의 모든 데이터를 조회합니다.
select * from user1;
select * from user2;

-- ex9) 테이블의 구조 확인
-- user1 테이블의 구조를 확인합니다. desc는 describe의 줄임말로 테이블의 컬럼 정보를 보여줍니다.
desc user1; 

-- ex10) 시퀀스 목록 확인
-- 데이터베이스에 존재하는 시퀀스 객체를 확인합니다.
select * from user_sequences;

-- ex11) 테이블명 변경 : test → user3 
-- 테이블 이름을 변경합니다. 이 예제에서는 test 테이블의 이름을 user3으로 변경합니다.
alter table test rename to user3;

-- ex12) 컬럼 추가 :   user3  → phone  varchar2(15) 
-- user3 테이블에 phone이라는 컬럼을 추가합니다. 이 컬럼은 가변 길이 문자열로 최대 15자까지 저장할 수 있습니다.
alter table user3 add phone varchar2(15);
desc user3;

-- ex13) 제약조건 추가 : user3  →   id에 unique, 제약조건명 UID2 
-- user3 테이블의 id 컬럼에 고유 제약조건을 추가하며, 제약조건 이름을 UID2로 지정합니다.
alter table user3 add constraint UID2 unique(id);
select constraint_name, constraint_type 
from user_constraints
where table_name='USER3';

-- ex14) 제약조건 삭제 - alter table 테이블명 drop constraint 제약조건명; 
-- user3 테이블에서 UID2라는 제약조건을 삭제합니다.
alter table user3 drop constraint UID2;

-- 이 예제는 SYS_C007693이라는 시스템이 생성한 제약조건을 삭제하는 코드입니다.
alter table user3 DROP constraint SYS_C007693; 
select *
from user_constraints 
where table_name='USER3';

-- ex15)  컬럼 추가 : user3 → no   number  (PK 설정) 
-- user3 테이블에 no라는 컬럼을 추가하며, 이 컬럼을 기본키로 설정합니다.
alter table user3 add no number primary key; 
desc user3;

-- ex16) 구조 변경 : user3 → name char(10) 를 varchar2(10)로 바꿈 
-- user3 테이블의 name 컬럼의 데이터 타입을 char(10)에서 varchar2(10)로 변경합니다.
alter table user3 modify name varchar2(10);
desc user3;

-- ex17) 컬럼 삭제 : user3 → address 
-- user3 테이블에서 address 컬럼을 삭제합니다.
alter table user3 drop column address; 
desc user3;

-- ex18) 테이블삭제 / 휴지통비우기: user3 
-- user3 테이블을 삭제하고, 휴지통을 비웁니다.
drop table user3;
select * from tab;
purge recyclebin; -- 휴지통 비우기
drop table user1 purge; -- 휴지통에 넣지 않고 바로 삭제 
select * from tab;
drop table user2; 
select * from tab;
 -- 휴지통 보기
show recyclebin; 
flashback table user2 to before drop; -- 휴지통에서 테이블을 복원합니다.
flashback table "BIN$cEf2dC1fRhilpiULWNRf3A==$0" to before drop;
 -- 휴지통에 있는 테이블 정보 검색
select * from recyclebin; 

-- ex19) 시퀀스 생성 / 삭제
-- 새로운 시퀀스를 생성하고, 이 시퀀스를 사용하는 방법을 보여줍니다.
create sequence idx_sql increment by 2 start with 1 maxvalue 9 cycle nocache;
select idx_sql.nextval from dual; -- 시퀀스의 다음 값을 표시합니다.
select idx_sql.currval from dual; -- 시퀀스의 현재 값을 표시합니다.
select * from user_sequences;
drop sequence idx_sql;
select * from user_sequences; 

-- ex20) 테이블 생성과 시퀀스 적용
-- book이라는 테이블을 생성하고, 시퀀스를 사용하여 데이터 행을 추가합니다.
create   table   book( 
    no   number primary key, 
    subject  varchar2(50), 
    price number,
    year date);

create sequence no_seq  increment by 1 start with 1 nocycle nocache;
select * from user_sequences;
-- 새로운 책 정보를 book 테이블에 삽입합니다.
insert into book(no, subject, price, year)
values(no_seq.nextval, '오라클 무작정 따라하기', 10000, sysdate); 
insert into book(no, subject, price, year)
values(no_seq.nextval, '자바 3일 완성', 15000, '2007-03-01');
insert into book values(no_seq.nextval, 'JSP 달인 되기', 18000, '2010-01-01'); 
select * from book;

-- ex21) 테이블 구조만 복사
-- user2 테이블의 구조를 user3 테이블로 복사하지만, 데이터는 복사되지 않습니다.
create table user3 as select * from user2 where 1=0; 
desc user3;

-- user2에는 제약조건이 5개가 보인다
select constraint_name, constraint_type, search_condition 
from user_constraints
where table_name='USER2';
select constraint_name, constraint_type, search_condition 
from user_constraints
where table_name='USER3';
-- ← not null을 제외하고는 제약조건이 복사 안됨
-- ← not null 제약조건도 sys_*****로 복사됨 (제약조건명 그대로 복사가 안된다)

-- ex22) 테이블(idx → bunho,  name → irum,  address → juso) 을 복사하고 id가   bbb인 
-- 레코드를 복사하시오
-- 원본테이블 : user1   / 사본테이블 : user4 
create table user4(bunho, irum, juso)
as select idx, name, address from user1 where id='bbb'; 
select * from user1;
select * from user4;

-- ex23) 테이블 생성 후 행 추가 
-- dept 테이블과 emp 테이블을 생성하고, emp 테이블에서 외래키 제약조건을 설정하여
-- 참조 무결성을 유지합니다.
--테이블명 : dept
--deptno    number  → 기본키, 제약조건명(DNO)
--dname    varcahr2(30) → 널 허용 안됨, 제약조건명(DNAME)
create table dept(
    deptno number constraint DNO primary key, 
    dname varchar2(30) constraint DNAME not null);
    
--테이블명 : emp
--empno   number  → 기본키, 제약조건명(ENO)
--ename   varchar2(30) → 널 허용 안됨, 제약조건명(ENAME)
--deptno  number  → 외래키, 제약조건명(FKNO),
--대상데이터를 삭제하고 참조하는 데이터는 NULL로 바꿈
create table emp(
    empno number constraint ENO primary key, 
    ename varchar2(30) constraint ENAME not null, 
    deptno number,
    constraint FKNO foreign key(deptno) references dept on delete set null);

-- 부서와 직원 정보를 삽입합니다.
insert into dept(deptno, dname) values(10, '개발부');
insert into dept(deptno, dname) values(20, '영업부');
insert into dept(deptno, dname) values(30, '관리부');
insert into dept(dname) values(40, '경리부'); 
-- → ORA-00913: 값의 수가 너무 많습니다.
insert into dept(deptno, dname) values(40, '경리부');

insert into emp(empno, ename, deptno) values(100, '홍길동', 10);
insert into emp(empno, ename, deptno) values(101, '라이언', 20);
insert into emp(empno, ename, deptno) values(102, '튜브', 50); 
-- → 50번부서 없음(무결성제약조건위배) - 부모키가 없습니다
insert into emp(empno, ename, deptno) values(103, '어피치', 40);
insert into emp(empno, ename) values(105, '프로도');
insert into emp(ename, deptno) values('콘', 10); 
-- → primary key는 NULL허용 안함
commit;

-- ex24) 삭제
-- 부서 정보를 삭제하고, 롤백으로 데이터를 복원한 후 특정 부서만 삭제합니다.
delete from dept; 
select * from dept; 
rollback;
select * from dept;
delete from dept where deptno=40; 
select * from dept; -- 40번 부서 삭제
select * from emp; -- 40번 부서 컬럼에 (null)이 들어간다.

-- ex25) 수정(update) - emp테이블   장동건 사원의 부서번호를 30으로 수정하시오 
-- emp 테이블에서 특정 직원의 부서 번호를 수정합니다.
update emp set deptno=30 where ename='프로도';
select * from emp; 
commit;
