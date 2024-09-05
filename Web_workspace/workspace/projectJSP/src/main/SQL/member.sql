-- 회원가입과 로그인(Oracle)
create table member(
    name varchar2(30) not null,  -- 회원의 이름을 저장하는 필드, 최대 30자까지 입력 가능하며 null 값을 허용하지 않음 (이름은 반드시 입력해야 함)
    id varchar2(30) primary key, -- 기본키, unique, not null, 무결성 제약 조건
                                -- 'id'는 각 회원을 고유하게 식별하는 필드로, 중복될 수 없음 (unique 제약 조건) 
                                -- 또한, 기본키(primary key)로 지정되어 있어 테이블 내에서 중복을 허용하지 않으며 null 값이 들어갈 수 없음
    pwd varchar2(80) not null,   -- 회원의 비밀번호를 저장하는 필드, 최대 80자까지 입력 가능하며 null 값을 허용하지 않음 (비밀번호는 반드시 입력해야 함)
    gender varchar2(3),          -- 성별 정보를 저장하는 필드, 최대 3자까지 입력 가능 (예: '남', '여', 혹은 'M', 'F'와 같은 값을 사용할 수 있음) 
                                 -- null 값을 허용하므로 성별을 선택하지 않아도 됨
    email1 varchar2(20),         -- 이메일 주소의 앞부분을 저장하는 필드, 최대 20자까지 입력 가능 (예: example@ 에서 'example' 부분)
                                 -- null 값을 허용하므로 이메일을 입력하지 않아도 됨
    email2 varchar2(20),         -- 이메일 주소의 뒷부분을 저장하는 필드, 최대 20자까지 입력 가능 (예: example@naver.com 에서 'naver.com' 부분)
                                 -- null 값을 허용하므로 이메일을 입력하지 않아도 됨
    tel1 varchar2(10),           -- 전화번호의 앞자리를 저장하는 필드, 최대 10자까지 입력 가능 (예: 010, 011 등의 번호 앞자리)
                                 -- null 값을 허용하므로 전화번호를 입력하지 않아도 됨
    tel2 varchar2(10),           -- 전화번호의 중간 자리를 저장하는 필드, 최대 10자까지 입력 가능 (예: 1234-5678에서 '1234' 부분)
                                 -- null 값을 허용하므로 전화번호를 입력하지 않아도 됨
    tel3 varchar2(10),           -- 전화번호의 뒷자리를 저장하는 필드, 최대 10자까지 입력 가능 (예: 1234-5678에서 '5678' 부분)
                                 -- null 값을 허용하므로 전화번호를 입력하지 않아도 됨
    zipcode varchar2(10),        -- 우편번호를 저장하는 필드, 최대 10자까지 입력 가능 (예: 12345 형태의 우편번호)
                                 -- null 값을 허용하므로 우편번호를 입력하지 않아도 됨
    addr1 varchar2(100),         -- 주소의 기본 정보를 저장하는 필드, 최대 100자까지 입력 가능 (예: 서울특별시 강남구)
                                 -- null 값을 허용하므로 주소를 입력하지 않아도 됨
    addr2 varchar2(100),         -- 주소의 상세 정보를 저장하는 필드, 최대 100자까지 입력 가능 (예: OO아파트 101동 101호)
                                 -- null 값을 허용하므로 상세 주소를 입력하지 않아도 됨
    logtime date                 -- 회원 정보가 입력된 시간을 저장하는 필드, 날짜 형식으로 저장됨 (회원 가입이나 정보가 수정된 시간을 기록할 때 사용)
);

select * from member;
-- SELECT * FROM all_tables WHERE table_name = 'MEMBER';

-- -------------------------
--insert into member(name, id, pwd) values('홍길동', 'hong', '111');
commit;
-- ------------------------------------
-- PURGE RECYCLEBIN;
-- drop table 테이블명 purge; 아예 지운다.
-- drop table member purge;
-- SELECT username, account_status FROM dba_users;
