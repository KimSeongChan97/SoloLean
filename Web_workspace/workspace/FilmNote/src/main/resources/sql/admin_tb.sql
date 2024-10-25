CREATE TABLE admin_tb (
    aid VARCHAR(30) PRIMARY KEY, -- 아이디: 관리자 계정의 고유 아이디. 문자열 최대 30자이며, 이 필드는 PRIMARY KEY로 설정되어 있어 각 관리자 계정이 고유하게 식별됩니다.
    apwd VARCHAR(70) NOT NULL, -- 비밀번호: 관리자의 비밀번호를 저장하는 필드. 비밀번호는 암호화된 형태로 저장되며, 최대 70자의 문자열로 관리됩니다. 필수 입력 항목입니다.
    name VARCHAR(30) NOT NULL -- 이름: 관리자의 이름을 저장하는 필드. 최대 30자의 문자열을 허용하며 필수 입력 항목입니다.
);
