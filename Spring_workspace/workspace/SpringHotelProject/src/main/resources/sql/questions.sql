CREATE TABLE questions (
    questions_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL, -- 작성자 (user 테이블의 seq 참조)
    admin_id INT, -- 답변자 (user 테이블의 seq 참조)
    content TEXT NOT NULL, -- 질문 내용
    qtypes_id INT DEFAULT 0, -- 질문 유형 (qtypes 테이블 참조)
    is_answered BOOLEAN DEFAULT FALSE, -- 답변 여부
    logtime TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 질문 작성 날짜
    updatetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 질문 수정 시간
    CONSTRAINT fk_user_question FOREIGN KEY (user_id) REFERENCES user(seq) ON DELETE CASCADE, -- 작성자와 관계 설정
    CONSTRAINT fk_admin_question FOREIGN KEY (admin_id) REFERENCES admin(seq) ON DELETE SET NULL, -- 답변자와 관계 설정
    CONSTRAINT fk_qtypes FOREIGN KEY (qtypes_id) REFERENCES qtypes(qtypes_id) ON DELETE SET NULL -- 질문 유형과 관계 설정
);