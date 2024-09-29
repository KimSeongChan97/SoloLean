CREATE TABLE review_tb(
	 rcode INT NOT NULL AUTO_INCREMENT, -- 리뷰코드: 리뷰 테이블의 기본 키로, 자동 증가(AUTO_INCREMENT)를 통해 리뷰별 고유한 값이 부여됨
	 movie_code INT NOT NULL, -- 영화코드: 리뷰가 어떤 영화에 대한 것인지 식별하기 위해 사용되며, 반드시 입력되어야 함 (NOT NULL)
	 user_id VARCHAR(30), -- 작성자 아이디: 리뷰를 작성한 사용자의 아이디를 저장, 외래 키로 연결됨 (FOREIGN KEY)
	 content VARCHAR(100) NOT NULL, -- 리뷰 내용: 사용자가 작성한 리뷰의 내용을 저장하며, 최대 100글자까지 허용되고 필수 입력 항목임
	 logtime DATETIME DEFAULT NOW(), -- 작성시간: 리뷰가 작성된 시간으로, 기본 값은 현재 시각 (NOW)로 설정됨
	 score INT NOT NULL, -- 별점: 리뷰에서 사용자가 부여한 영화에 대한 평점을 저장하며, 반드시 입력되어야 함
	 PRIMARY KEY(rcode), -- 리뷰코드를 기본 키로 설정하여 테이블의 각 행이 고유하게 식별되도록 함
	 FOREIGN KEY(movie_code)
	 	REFERENCES movie_tb(mcode) ON DELETE CASCADE -- movie_tb 테이블의 mcode를 외래 키로 참조하며, 영화가 삭제될 때 관련 리뷰도 삭제됨
	 	-- movie_tb의 mcode가 삭제되면 관련 review_tb의 행도 삭제됨
);

-- review_tb의 user_id 초기화 트리거 설정
CREATE TRIGGER set_deleteuser_tr
BEFORE DELETE ON user_tb -- user_tb에서 삭제 작업이 발생하기 전 실행되는 트리거
FOR EACH ROW -- 삭제되는 각 행에 대해 트리거 실행
BEGIN
    -- user_tb 테이블에서 사용자가 삭제되기 전에 review_tb의 user_id를 '알수없음'으로 업데이트
    UPDATE review_tb
    SET user_id = '알수없음' -- 리뷰 테이블의 해당 사용자의 user_id 값을 '알수없음'으로 변경
    WHERE user_id = OLD.uid; -- OLD.uid는 삭제되기 전의 user_tb의 uid 값, 즉 삭제된 사용자의 아이디
END;
