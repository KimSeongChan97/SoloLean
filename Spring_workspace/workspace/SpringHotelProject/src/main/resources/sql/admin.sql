create table admin(
	seq int AUTO_INCREMENT PRIMARY KEY, -- PK
	adminid varchar(30) not null UNIQUE, -- 아이디
	pwd varchar(70) not null, -- 비밀번호
	name varchar(30) not null -- 이름
);