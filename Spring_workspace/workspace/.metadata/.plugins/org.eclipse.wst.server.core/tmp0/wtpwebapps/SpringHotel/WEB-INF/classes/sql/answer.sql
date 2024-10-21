CREATE TABLE answer (
    answer_id INT AUTO_INCREMENT PRIMARY KEY,
    question_id INT NOT NULL,
    andmin_id INT NOT NULL,  -- 답변한 사람의 ID (관리자나 호텔 운영자일 수도 있음)
    user_id INT NOT NULL,
    comment TEXT NOT NULL,
    logdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_question FOREIGN KEY (question_id) REFERENCES questions(questions_id) ON DELETE CASCADE
);
