create table member(
name varchar2(15) not null, -- 중복 가능
id varchar2(30) primary key, -- 중복 허용X(무결성 제약조건이라는 에러), not null
pwd varchar2(50) not null,
phone varchar2(20) unique); -- 중복 불가

drop table member purge; -- 휴지통 까지 삭제
select * from tab; 
select * from member;
delete from member;

delete member where id=?;
DELETE FROM member WHERE id = ?;


select * from member where id='hong'; --=> rs.next() => true => 사용 불가능
select * from member where id='hong2'; --=> rs.next() => false => 사용 가능

select * from member where id='hong' and pwd='111';

select * from member order by id;
select * from member order by id desc;
SELECT * FROM member ORDER BY name;
SELECT * FROM member ORDER BY name DESC;

update member set name=?, pwd=?, phone=? where id=?;


