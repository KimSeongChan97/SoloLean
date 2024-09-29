CREATE TABLE review_tb(
	 rcode INT NOT NULL AUTO_INCREMENT, -- 리뷰코드
	 movie_code INT NOT NULL, -- 영화코드
	 user_id VARCHAR(30), -- 작성자 아이디
	 content VARCHAR(100) NOT NULL, -- 리뷰 내용
	 logtime DATETIME default now(), -- 작성시간
	 score INT NOT NULL, -- 별점
	 primary Key(rcode),
	 FOREIGN KEY(movie_code)
	 	REFERENCES movie_tb(mcode) ON DELETE cascade
	 	-- movie_tb의 mcode가 삭제되면 관련 review_tb의 행도 삭제
);

-- review_tb의 user_id 초기화
CREATE TRIGGER set_deleteuser_tr
BEFORE DELETE ON user_tb
FOR EACH ROW
BEGIN
    -- user_tb 테이블에서 사용자가 삭제되기 전에 review_tb의 user_id를 '탈퇴한 사용자'로 업데이트
    UPDATE review_tb
    SET user_id = '알수없음'
    WHERE user_id = OLD.uid;  -- OLD.uid는 삭제되기 전의 user_tb의 uid 값
END ;