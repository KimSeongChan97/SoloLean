create table admin_tb(
	aid varchar(30) primary key, -- 아이디
	apwd varchar(70) not null, -- 비밀번호
	name varchar(30) not null -- 이름
);