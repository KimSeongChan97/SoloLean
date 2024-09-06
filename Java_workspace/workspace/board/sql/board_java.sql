-- 테이블 생성
CREATE TABLE board_java (
    seq NUMBER PRIMARY KEY,
    id VARCHAR2(30),
    name VARCHAR2(15),
    subject VARCHAR2(100),
    content VARCHAR2(500),
    logtime DATE
);

-- 시퀀스 생성
CREATE SEQUENCE board_java_seq
START WITH 1
INCREMENT BY 1
NOCACHE;

