create table user (
    seq INT AUTO_INCREMENT PRIMARY KEY, -- PK
	userid varchar(30) UNIQUE, -- 아이디
	pwd varchar(70), -- 비밀번호
	name varchar(30) not null, -- 이름
	gender varchar(3) not null, -- 성별: F/M
	birth1 INT not null, -- 생년월일(년): YYYY >> 미성년자 예약 불가
	birth2 INT not null, -- 생년월일(월): MM
	birth3 INT not null, -- 생년월일(일): DD 
	email varchar(20) not null, -- 이메일
	emailcheck BOOLEAN DEFAULT FALSE, -- 이메일 인증 여부
	tel1 varchar(10) not null, -- 휴대폰1
	tel2 varchar(10) not null, -- 휴대폰2
	tel3 varchar(10) not null, -- 휴대폰3
	grade VARCHAR(50) DEFAULT '일반', -- 회원 등급: VIP, GOLD, SILVER, 일반
	logintype varchar(10) DEFAULT 'SH' -- SH or NAVER
);

[ naver api ]
1. 회원이름
	name
2. 전화번호
	mobile: 010-1111-1111
3. 이메일
	email
4. 성별
	gender
5. 생일
	birthday
6. 출생연도
	birthyear