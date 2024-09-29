create table user_tb(
	uid varchar(30) primary key, -- 아이디
	upwd varchar(70) not null, -- 비밀번호
	uname varchar(30) not null, -- 이름
	gender varchar(3) not null, -- 성별: F/M
	birth1 varchar(10) not null, -- 생년월일(년): YYYY 
	birth2 varchar(10) not null, -- 생년월일(월): MM
	birth3 varchar(10) not null, -- 생년월일(일): DD
	email1 varchar(20) not null, -- 이메일1
	email2 varchar(20) not null, -- 이메일2
	tel1 varchar(10), -- 휴대폰1
	tel2 varchar(10), -- 휴대폰2
	tel3 varchar(10) -- 휴대폰3
);
