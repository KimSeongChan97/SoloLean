-- ORACLE
create table member(
name varchar2(15) not null, -- 중복 가능
id varchar2(30) primary key, -- 중복 허용X(무결성 제약조건이라는 에러), not null
pwd varchar2(50) not null,
phone varchar2(20) unique); -- 중복 불가