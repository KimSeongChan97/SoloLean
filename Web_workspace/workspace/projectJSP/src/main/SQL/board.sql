-- [테이블] Oracle
CREATE TABLE board(
 seq NUMBER NOT NULL, -- 글번호 (시퀀스 객체 이용)
                      -- 글번호는 게시글이 저장될 때마다 자동으로 증가하는 값을 설정하여,
                      -- 각 게시글을 구분하는 고유한 번호로 사용됩니다. 이 번호는 시퀀스를 통해 관리됩니다.
 id VARCHAR2(20) NOT NULL, -- 아이디
                          -- 작성자의 아이디를 저장하는 필드입니다. 최대 20자의 문자열을 저장할 수 있으며, NULL 값은 허용되지 않습니다.
 name VARCHAR2(40) NOT NULL, -- 이름
                           -- 작성자의 이름을 저장하는 필드입니다. 최대 40자의 문자열을 저장할 수 있으며, 마찬가지로 NULL 값은 허용되지 않습니다.
 email VARCHAR2(40), -- 이메일
                    -- 작성자의 이메일 주소를 저장하는 필드입니다. 최대 40자의 문자열을 저장할 수 있으며, 
                    -- 이 필드는 NULL을 허용하므로, 이메일 정보를 반드시 입력하지 않아도 됩니다.
 subject VARCHAR2(255) NOT NULL, -- 제목
                               -- 게시글의 제목을 저장하는 필드입니다. 최대 255자의 문자열을 저장할 수 있으며, 
                               -- NULL 값은 허용되지 않으므로 제목을 반드시 입력해야 합니다.
 content VARCHAR2(4000) NOT NULL, -- 내용 
                                 -- 게시글의 본문 내용을 저장하는 필드입니다. 최대 4000자의 긴 문자열을 저장할 수 있으며, 
                                 -- NULL 값은 허용되지 않기 때문에 본문 내용은 필수 입력 사항입니다.
 ref NUMBER NOT NULL, -- 그룹번호
                    -- 그룹 번호는 같은 주제나 같은 원글에 대한 답글(댓글)들이 동일한 그룹으로 묶이도록 관리하는 번호입니다.
                    -- 답글이 아닌 원글의 경우, 자신의 글번호(seq)와 동일하게 설정됩니다.
 lev NUMBER DEFAULT 0 NOT NULL, -- 단계
                               -- 글의 단계(level)를 나타내는 필드로, 기본값은 0입니다. 
                               -- 답글의 경우, 몇 번째 단계에 있는 답글인지 나타냅니다.
 step NUMBER DEFAULT 0 NOT NULL, -- 글순서
                                -- 글의 순서를 나타내는 필드로, 동일한 그룹(ref) 내에서의 글들의 순서를 관리합니다.
 pseq NUMBER DEFAULT 0 NOT NULL, -- 원글번호
                                -- 답글의 경우, 해당 답글이 어떤 원글에 대한 것인지 그 원글의 번호를 가리키는 필드입니다.
 reply NUMBER DEFAULT 0 NOT NULL, -- 답변수
                                 -- 답글의 수를 저장하는 필드입니다. 원글에 몇 개의 답글이 달렸는지를 저장하며, 기본값은 0입니다.
 hit NUMBER DEFAULT 0, -- 조회수
                      -- 게시글이 몇 번 조회되었는지를 기록하는 필드입니다. 기본값은 0이며, 조회 시마다 값이 증가합니다.
 logtime DATE DEFAULT SYSDATE -- 작성된 시간을 기록하는 필드로, 기본값은 현재 시간(SYSDATE)입니다.
);
-- 위 테이블 구조는 게시판에서 사용될 기본적인 정보를 포함합니다.
-- 이 테이블은 각 게시글의 고유한 번호(seq), 작성자의 정보(id, name, email), 게시글의 제목과 내용(subject, content)을 저장합니다.
-- 추가로, 답글이 달리는 경우를 대비하여 그룹번호(ref), 답글의 단계(lev), 순서(step) 및 답글의 수(reply)도 기록할 수 있습니다.
-- 조회수(hit)는 게시글이 몇 번 열렸는지 기록하며, 글이 작성된 시간(logtime)은 SYSDATE를 통해 자동으로 입력됩니다.

-- [시퀀스] Oracle
CREATE SEQUENCE seq_board NOCACHE NOCYCLE;
-- 시퀀스는 데이터베이스에서 자동으로 증가하는 숫자를 생성해주는 객체입니다.
-- 'NOCACHE' 옵션은 시퀀스 값을 미리 캐시하지 않음을 의미하여, 시퀀스 번호가 요청될 때마다 즉시 값을 생성합니다.
-- 'NOCYCLE' 옵션은 시퀀스가 최대값에 도달하더라도 다시 1부터 시작하지 않고, 더 이상 값이 증가하지 않게 설정합니다.
-- NOCACHE와 NOCYCLE은 시퀀스의 안정성과 일관성을 유지하기 위해 설정되었습니다.

select * from board;
-- board 테이블의 모든 데이터를 조회합니다.
-- 데이터베이스에 저장된 게시글 데이터를 확인할 수 있는 기본적인 쿼리입니다.
select count(*) from board;


select * from board_JSP;
-- board_JSP 테이블에서 모든 데이터를 조회합니다.
select count(*) from board_JSP;


--DELETE FROM board WHERE seq = 1;
-- 특정 게시글(seq = 1)을 삭제합니다. DELETE 문은 매우 강력하므로, 특정 게시글을 잘못 삭제하는 일이 없도록 주의해야 합니다.

select * from
(select rownum rn, tt.* from
(select * from board_JSP order by ref desc, step asc)tt
) where rn >=1 and rn <=5;
-- 이 쿼리는 페이징을 위해 ROWNUM을 사용하여 데이터를 1페이지당 5개의 게시글씩 가져오는 구조입니다.
-- 서브쿼리에서는 ref로 그룹화한 후 step 순서대로 정렬한 결과를 tt에 저장하고, 최종적으로 rn >= 1 and rn <= 5 조건을 통해 첫 5개의 게시글을 가져옵니다.

-- pg=1 -> rn>=1 and rn<=5 (startNum , endNum)
-- pg 변수에 따라 rn 값을 조정하여 페이지 범위 내의 게시글을 가져옵니다. 1페이지는 게시글 1번에서 5번까지 가져옵니다.

-- [댓글 테이블]
CREATE TABLE comments (
    comment_id NUMBER NOT NULL,        -- 댓글 ID (시퀀스 사용)
    boardSeq NUMBER NOT NULL,          -- 게시글 번호 (board 테이블의 seq와 연결)
    name VARCHAR2(40) NOT NULL,        -- 댓글 작성자 이름
    content VARCHAR2(1000) NOT NULL,   -- 댓글 내용 (최대 1000자)
    logtime DATE DEFAULT SYSDATE,      -- 댓글 작성 시간
    CONSTRAINT pk_comment_id PRIMARY KEY (comment_id), -- 댓글 ID를 기본키로 설정
    CONSTRAINT fk_board_seq FOREIGN KEY (boardSeq) REFERENCES board(seq) ON DELETE CASCADE
    -- board 테이블의 seq를 참조하는 외래키, 게시글 삭제 시 댓글도 삭제됨
);
-- comments 테이블은 게시글에 달린 댓글 정보를 저장합니다.
-- 각 댓글은 고유한 ID(comment_id)를 가지며, 해당 댓글이 달린 게시글(boardSeq)과 연결됩니다.
-- 댓글의 작성자 이름(name), 댓글 내용(content), 작성 시간(logtime)은 각각 기록되며, 댓글 ID는 기본키로 설정됩니다.
-- 외래키(fk_board_seq)를 통해 댓글이 달린 게시글이 삭제되면, 해당 댓글들도 자동으로 삭제됩니다 (ON DELETE CASCADE).

-- [댓글 ID 시퀀스]
CREATE SEQUENCE seq_comments NOCACHE NOCYCLE;
-- 시퀀스는 자동으로 댓글 ID를 생성하는 데 사용됩니다.
-- 댓글이 추가될 때마다 고유한 댓글 ID가 생성되며, 이 시퀀스는 중복된 ID가 생성되지 않도록 보장합니다.

select * from comments;
-- comments 테이블에 저장된 모든 댓글을 조회하는 쿼리입니다.

commit;
-- 트랜잭션을 커밋하여 변경 사항을 데이터베이스에 반영합니다.
