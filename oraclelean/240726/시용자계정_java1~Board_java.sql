CREATE TABLE users (
    user_id VARCHAR2(50) PRIMARY KEY,
    password VARCHAR2(50) NOT NULL,
    name VARCHAR2(50) NOT NULL,
    email VARCHAR2(100),
    join_date DATE DEFAULT SYSDATE
);
-- 회원 테이블 users

CREATE TABLE attendance (
    attendance_id NUMBER PRIMARY KEY,
    user_id VARCHAR2(50) REFERENCES users(user_id),
    check_in TIMESTAMP,
    check_out TIMESTAMP
);
-- 출퇴근 테이블 attendance

CREATE TABLE reasons (
    reason_id NUMBER PRIMARY KEY,
    user_id VARCHAR2(50) REFERENCES users(user_id),
    reason_type VARCHAR2(20),
    reason_desc VARCHAR2(255),
    reason_date DATE DEFAULT SYSDATE
);
-- 사유 작성 테이블