테이블 생성
create table 테이블명(필드명 필드타입, 필드명 필드타입,...); 
: 테이블명, 필드명 한글 가능
[ex]
create table 연산(
x int, -- 고정형, int는 소수이하 자른다(반올림 된다)
y number, -- 가변형, number는 소수이하 놔둔다
z number(10,3));
SQL> select * from tab;  -- 테이블 보기 
SQL> desc 연산;
create table dbtest(
name varchar2(15), -- char(고정형), varchar2(가변형) 
age number,  
height number(10, 2),  
logtime date);
Enterprise   한글 1자 = 2byte 
Express      한글 1자 = 3byte
레코드 추가
[형식]
① insert into 테이블명(필드명,...) values(값, ...);
② insert into 테이블명 values(값,...); ← 테이블의 필드순서가 일치하면 필드명은 생략가능
[ex]
insert into 연산(x, y, z) values(25, 36, 12.34567);
insert into 연산(x, y, z) values(25.34567, 36.34567, 12.34567);
insert into 연산(x, y) values(25.666, 36.88888);  -- 25.666 (반올림 되서 26 나온다)
insert into 연산(z, y, x) values(1, 2, 3); -- 순서가 바뀌어도 된다
insert into 연산 values(25, 36, 12.34567); 
-- 필드명 생략 가능하게 되면 필드를 빠짐없이 순서대로 입력해야한다 
insert into 연산 values(25, 36, 1234567.3456); -- 유효숫자는 최대7자리 
insert into 연산 values(25, 36, 12345678.3456); -- error 
---------------------------------------------
insert into dbtest(name, age, height, logtime) values('홍길동', 25, 185.567, sysdate);
insert into dbtest(name, age, height, logtime) values('Hong', 30, 175.56, sysdate);
insert into dbtest(name, age) values('희동이', 3);
insert into dbtest(name, height) values('홍당무', 168.89);
insert into dbtest values('분홍신', 5, 123.5, sysdate);
insert into dbtest(name) values('진분홍');

select * from 테이블명 where 조건;
select name, age, height, logtime from dbtest;
select name, age from dbtest;
select * from dbtest;
select * from dbtest where name='홍길동';
select * from dbtest where name like '홍%';
select * from dbtest where name like '_홍%';
select * from dbtest where name like '__홍%';
select * from dbtest where name='hong'; -- 데이터는 대소문자 가린다.
select * from dbtest where lower(name) = 'hong'; -- lower() 소문자
select * from dbtest where upper(name) = 'HONG'; -- upper() 대문자
select * from dbtest where name like '%동%' and age<20;
select * from dbtest where age is null;
select * from dbtest where age is not null;
select name, age+height from dbtest;
select name, age+height as "나이와 키의 합" from dbtest;
select * from dbtest order by name asc; -- asc는 생략가능
select * from dbtest order by name desc;

레코드 수정
[형식]
update 테이블명 set 수정할 내용 where 조건
update dbtest set age=0 where name='홍당무';
update dbtest set age=0, height=0 where name='진분홍';
update dbtest set age=age+1;
update dbtest set age=age+1 where name='홍길동';
레코드 삭제
[형식]
delete  테이블명; ← 모든 레코드 삭제 
delete  테이블명 where 조건;
테이블 삭제
drop table 테이블명;
drop table 테이블명 purge; ← 휴지통을 거치지 않고 바로 삭제 (영구 삭제) 
flashback table 테이블명 to before drop; ← 복원
purge recyclebin; ← 휴지통비우기
select * from recyclebin; → 휴지통에 테이블 정보 검색 
show recyclebin;

-- ------------------
create  sequence  시퀀스명
[increment by 증가값] 
[start with 시작값]
[maxvalue  최대값 | minvalue  최소값] 
[cycle | nocycle]
[cache | nocache]
- increment  by   증가값 : 증가/감소 간격(기본값 : 1) 
- start with : 시작번호(기본값 : 1)
- maxvalue/minvalue : 시퀀스의 최대/최소값 지정
- cycle/nocycle : 최대/최소값에 도달 시 반복여부 결정
- cache/nocache : 지정한 수량 만큼 메모리 생성여부 결정 
(최소값 : 2, 기본값 : 20)
SQL> create sequence test increment by 2 start with 1 maxvalue 9 cycle nocache; 
Sequence created.
SQL> select test.nextval from dual; -- dual 가상 테이블명
SQL> select test.currval from dual;
SQL> select * from user_sequences;
SQL> drop sequence test; 
Sequence dropped.
