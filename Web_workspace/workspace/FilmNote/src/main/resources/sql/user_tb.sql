create table user_tb(
	uid varchar(30) primary key, -- 아이디를 저장하는 필드, 기본 키로 설정되어 있어 중복이 허용되지 않음
	upwd varchar(70) not null, -- 비밀번호를 저장하는 필드, 필수 입력 항목 (not null)
	uname varchar(30) not null, -- 사용자의 이름을 저장하는 필드, 필수 입력 항목 (not null)
	gender varchar(3) not null, -- 성별을 저장하는 필드, F(여성)/M(남성) 형식으로 저장됨, 필수 입력 항목
	birth1 varchar(10) not null, -- 생년월일의 '년' 부분을 저장, YYYY 형식으로 저장됨, 필수 입력 항목
	birth2 varchar(10) not null, -- 생년월일의 '월' 부분을 저장, MM 형식으로 저장됨, 필수 입력 항목
	birth3 varchar(10) not null, -- 생년월일의 '일' 부분을 저장, DD 형식으로 저장됨, 필수 입력 항목
	email1 varchar(20) not null, -- 이메일의 앞부분을 저장하는 필드, 필수 입력 항목
	email2 varchar(20) not null, -- 이메일의 도메인 부분을 저장하는 필드, 필수 입력 항목
	tel1 varchar(10), -- 전화번호의 첫 번째 부분(지역번호 또는 첫 번째 블록)을 저장, 선택 항목
	tel2 varchar(10), -- 전화번호의 두 번째 부분을 저장, 선택 항목
	tel3 varchar(10) -- 전화번호의 세 번째 부분을 저장, 선택 항목
);
