-- Oracle
create table usertable(
  name varchar2(30) not null,  -- 사용자 이름을 저장하는 필드, 최대 30자까지 허용, null 값을 허용하지 않음
  id varchar2(30) primary key,  -- 사용자의 고유 ID를 저장하는 필드, 기본 키로 설정되어 중복을 허용하지 않으며, null 값을 허용하지 않음
  pwd varchar2(100) not null  -- 사용자의 비밀번호를 저장하는 필드, 최대 100자까지 허용, null 값을 허용하지 않음
);

select * from usertable;

-- 내림차순
SELECT * FROM usertable
ORDER BY NAME DESC; -- 오름차순은 asc


--commit;
