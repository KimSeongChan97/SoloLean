create table school (
name varchar2(15) not null, -- 이름
value varchar2(15), -- 학번 or 과목 or 부서
code number -- 1이면 학생, 2이면 교수, 3이면 관리자
);

select * from school;

SELECT * FROM school WHERE name LIKE ?;

DELETE FROM school WHERE name = ?;