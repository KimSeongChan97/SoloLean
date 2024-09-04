---- 기존 테이블 삭제
--DROP TABLE BOARD CASCADE CONSTRAINTS; 
-- 기존에 존재할 수 있는 BOARD 테이블을 삭제합니다. CASCADE CONSTRAINTS 옵션은 해당 테이블에 연결된 모든 제약 조건(예: 외래 키)을 함께 삭제합니다.
--DROP TABLE MEMBER CASCADE CONSTRAINTS;
-- 기존에 존재할 수 있는 MEMBER 테이블을 삭제합니다. CASCADE CONSTRAINTS 옵션은 해당 테이블에 연결된 모든 제약 조건을 함께 삭제합니다.
--DROP TABLE members CASCADE CONSTRAINTS;
-- 기존에 존재할 수 있는 members 테이블을 삭제합니다. 주의: 대소문자를 구분하는 환경에서는 이 테이블이 실제로 존재할 수 있습니다.
--DROP TABLE posts CASCADE CONSTRAINTS;
-- 기존에 존재할 수 있는 posts 테이블을 삭제합니다. 주의: BOARD와 유사한 다른 이름을 가진 테이블일 가능성이 있습니다.
--
---- 기존 시퀀스 삭제
--DROP SEQUENCE BOARD_SEQ;
-- 기존에 존재할 수 있는 BOARD_SEQ 시퀀스를 삭제합니다. 시퀀스는 주로 기본 키 값 생성을 위해 사용됩니다.

-- MEMBER 테이블 생성
CREATE TABLE MEMBER (
    MEMBER_ID VARCHAR2(50) PRIMARY KEY,  -- 회원 ID (고유)
    -- MEMBER_ID는 VARCHAR2(50) 타입이며, PRIMARY KEY로 설정되어 있어 테이블 내에서 고유한 값이어야 합니다.
    NAME VARCHAR2(100) NOT NULL,         -- 회원 이름
    -- NAME 필드는 VARCHAR2(100) 타입으로, NULL 값을 허용하지 않습니다. 즉, 이름은 반드시 입력되어야 합니다.
    EMAIL VARCHAR2(100) NOT NULL UNIQUE, -- 이메일 (고유)
    -- EMAIL 필드는 VARCHAR2(100) 타입으로, NULL 값을 허용하지 않으며, UNIQUE 제약 조건이 있어 중복된 값을 허용하지 않습니다.
    PASSWORD VARCHAR2(100) NOT NULL,     -- 비밀번호
    -- PASSWORD 필드는 VARCHAR2(100) 타입으로, NULL 값을 허용하지 않습니다.
    REGISTER_DATE DATE DEFAULT SYSDATE   -- 가입일 (기본값: 현재 날짜)
    -- REGISTER_DATE 필드는 DATE 타입으로, 기본값이 SYSDATE로 설정되어 있어 레코드가 생성될 때 자동으로 현재 날짜가 입력됩니다.
);

-- BOARD 테이블 생성
CREATE TABLE BOARD (
    SEQ NUMBER PRIMARY KEY,                  -- 게시글 번호 (고유)
    -- SEQ 필드는 NUMBER 타입으로, PRIMARY KEY로 설정되어 있어 게시글 번호가 고유해야 합니다.
    MEMBER_ID VARCHAR2(50) REFERENCES MEMBER(MEMBER_ID), -- 작성자 ID (외래 키)
    -- MEMBER_ID 필드는 VARCHAR2(50) 타입이며, MEMBER 테이블의 MEMBER_ID를 참조하는 외래 키입니다. 이는 게시글 작성자를 나타냅니다.
    SUBJECT VARCHAR2(200) NOT NULL,          -- 게시글 제목
    -- SUBJECT 필드는 VARCHAR2(200) 타입으로, NULL 값을 허용하지 않으며 게시글의 제목을 저장합니다.
    CONTENT CLOB NOT NULL,                   -- 게시글 내용
    -- CONTENT 필드는 CLOB(Character Large Object) 타입으로, 게시글의 긴 내용을 저장할 수 있습니다. NULL 값을 허용하지 않습니다.
    LOGTIME DATE DEFAULT SYSDATE             -- 작성일 (기본값: 현재 날짜)
    -- LOGTIME 필드는 DATE 타입으로, 기본값이 SYSDATE로 설정되어 있어 게시글 작성 시 자동으로 현재 날짜가 입력됩니다.
);

-- BOARD 테이블용 시퀀스 생성
CREATE SEQUENCE BOARD_SEQ
START WITH 1
INCREMENT BY 1;
-- BOARD_SEQ 시퀀스는 숫자 값을 생성하는 데 사용되며, 1부터 시작하여 1씩 증가합니다. 이 시퀀스는 주로 BOARD 테이블의 SEQ 필드를 자동으로 증가시키는 데 사용됩니다.

-- COMMENTS 테이블 생성 (게시글에 대한 댓글을 저장)
CREATE TABLE COMMENTS (
    COMMENT_ID NUMBER PRIMARY KEY,                 -- 댓글 ID (고유)
    -- COMMENT_ID 필드는 NUMBER 타입으로, PRIMARY KEY로 설정되어 있어 댓글의 고유 식별자입니다.
    POST_ID NUMBER REFERENCES BOARD(SEQ),          -- 게시글 ID (BOARD 테이블과 외래 키 관계)
    -- POST_ID 필드는 NUMBER 타입으로, BOARD 테이블의 SEQ 필드를 참조하는 외래 키입니다. 이는 댓글이 속한 게시글을 나타냅니다.
    MEMBER_ID VARCHAR2(50) REFERENCES MEMBER(MEMBER_ID), -- 댓글 작성자 ID (MEMBER 테이블과 외래 키 관계)
    -- MEMBER_ID 필드는 VARCHAR2(50) 타입이며, MEMBER 테이블의 MEMBER_ID를 참조하는 외래 키입니다. 이는 댓글 작성자를 나타냅니다.
    CONTENT CLOB NOT NULL,                         -- 댓글 내용
    -- CONTENT 필드는 CLOB 타입으로, 댓글의 긴 내용을 저장할 수 있으며 NULL 값을 허용하지 않습니다.
    LOGTIME DATE DEFAULT SYSDATE                   -- 작성일 (기본값: 현재 날짜)
    -- LOGTIME 필드는 DATE 타입으로, 기본값이 SYSDATE로 설정되어 있어 댓글 작성 시 자동으로 현재 날짜가 입력됩니다.
);

-- COMMENTS 테이블용 시퀀스 생성
CREATE SEQUENCE COMMENTS_SEQ
START WITH 1
INCREMENT BY 1;
-- COMMENTS_SEQ 시퀀스는 숫자 값을 생성하는 데 사용되며, 1부터 시작하여 1씩 증가합니다. 이 시퀀스는 주로 COMMENTS 테이블의 COMMENT_ID 필드를 자동으로 증가시키는 데 사용됩니다.

-- 조회수 추가
ALTER TABLE BOARD ADD VIEWS NUMBER DEFAULT 0;
-- 조회수를 추적하기 위해 BOARD 테이블에 VIEWS 필드를 추가합니다. 기본값은 0으로 설정되어 있으며, 이는 게시글이 처음 생성될 때 조회수가 0임을 의미합니다.

-- 모든 댓글 조회 (게시글별로 조회)
SELECT * FROM COMMENTS WHERE POST_ID = ? ORDER BY COMMENT_ID ASC;
-- 특정 게시글의 모든 댓글을 조회하는 쿼리입니다. POST_ID가 특정 게시글 번호인 댓글들을 조회하며, COMMENT_ID를 기준으로 오름차순 정렬합니다.

-- 모든 회원 조회
SELECT * FROM MEMBER;
-- MEMBER 테이블의 모든 회원 정보를 조회하는 쿼리입니다.

-- 모든 게시글 조회
SELECT * FROM BOARD ORDER BY SEQ DESC;
-- BOARD 테이블의 모든 게시글을 조회하는 쿼리입니다. SEQ를 기준으로 내림차순 정렬하여 최근 게시글이 먼저 나오도록 합니다.
