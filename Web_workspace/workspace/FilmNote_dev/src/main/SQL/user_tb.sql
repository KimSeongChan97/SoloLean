-- admin_tb
create table admin_tb (
id varchar(30) primary key,
pwd varchar(70) not null,
name varchar(30) not null
);

-- user_tb
create table user_tb (
id varchar(30) primary key,
pwd varchar(70) not null,
name varchar(30) not null,
gender char(1) not null,
birth1 varchar(4) not null,
birth2 varchar(2) not null,
birth3 varchar(2) not null,
email1 varchar(30) not null,
email2 varchar(30) not null,
tel1 varchar(3),
tel2 varchar(4),
tel3 varchar(4)
);

--
select * from admin_tb;
select * from user_tb;
