-- 사원 테이블
CREATE TABLE company (
    name VARCHAR2(15) NOT NULL, -- 관리자 or 사원 이름
    id VARCHAR2(30) PRIMARY KEY, -- 관리자 or 사원 아이디
    pw VARCHAR2(30) NOT NULL, -- 관리자 or 사원 비밀번호
    phone VARCHAR2(30) NOT NULL, -- 관리자 or 사원 전화번호
    regist_day DATE NOT NULL, -- 관리자 or 사원 입사일
    rank varchar2(1) NOT NULL -- 관리자 or 사원 구분 (관리자 = 0 , 사원 = 1)
);

-- 출결 체크 테이블
CREATE TABLE company_status (
    id VARCHAR2(30) PRIMARY KEY, -- 사원 아이디
    name VARCHAR2(15) NOT NULL, -- 사원 이름
    checkin_time DATE, -- 사원 출근 시간
    checkout_time DATE, -- 사원 퇴근 시간
    status VARCHAR2(15) DEFAULT '결근', -- 출근, 퇴근, 결근, 지각
    reason VARCHAR2(15), -- 지각 이유, 결근 이유 등등
    late_count NUMBER DEFAULT 0, -- 지각 횟수
    early_leave_count NUMBER DEFAULT 0, -- 조퇴 횟수
    vacation_days NUMBER DEFAULT 0 -- 휴가 일수
);

-- 출결 로그 테이블
CREATE TABLE attendance_log (
    id VARCHAR2(30) NOT NULL, -- 사원 아이디
    action_type VARCHAR2(10) NOT NULL, -- '출근' 또는 '퇴근'
    action_time DATE NOT NULL, -- 출근 또는 퇴근 시간
    CONSTRAINT fk_attendance_log_id FOREIGN KEY (id) REFERENCES company(id) -- 외래 키 설정
);

-- 퇴사 사원 테이블
CREATE TABLE leaveperson (
    name VARCHAR2(15) NOT NULL, -- 퇴사 사원 이름
    id VARCHAR2(30) NOT NULL, -- 퇴사 사원 아이디
    regist_day DATE NOT NULL, -- 입사 날짜
    leave_day DATE NOT NULL -- 퇴사 날짜
);

-- 휴가 테이블
CREATE TABLE vacation (
    id VARCHAR2(30) NOT NULL, -- 사원 아이디
    start_date DATE NOT NULL, -- 휴가 시작 날짜
    end_date DATE NOT NULL, -- 휴가 종료 날짜
    days NUMBER NOT NULL, -- 휴가 일수
    CONSTRAINT fk_vacation_id FOREIGN KEY (id) REFERENCES company(id) -- 외래 키 설정
);