CREATE TABLE movie_tb(
	 mcode INT NOT NULL AUTO_INCREMENT, -- 영화코드: 각 영화에 고유하게 부여되는 번호이며, 자동으로 증가 (AUTO_INCREMENT)됩니다.
	 title VARCHAR(100) NOT NULL, -- 영화제목: 영화의 제목을 저장하는 필드로, 최대 100글자까지 입력 가능하며 필수 입력 항목입니다.
	 director VARCHAR(100) NOT NULL, -- 영화감독: 영화를 감독한 감독의 이름을 저장하는 필드입니다. 최대 100글자까지 입력 가능하며 필수 입력 항목입니다.
	 genre VARCHAR(100), -- 영화장르: 영화의 장르(예: 액션, 드라마 등)를 저장하는 필드입니다. 선택 입력 항목으로 필수는 아닙니다.
	 release_date DATE NOT NULL, -- 개봉일: 영화의 개봉 날짜를 저장하는 필드로, 날짜 형식(YYYY-MM-DD)으로 입력되며 필수 항목입니다.
	 rating INT NOT NULL, -- 영화 등급: 영화 관람 등급을 저장하는 필드로, 정수값으로 저장됩니다. 일반적으로 0(전체관람가), 15, 19 등의 값이 들어갑니다.
	 score FLOAT DEFAULT 0.00, -- 영화평점: 영화의 평균 평점을 저장하는 필드로, 기본값은 0.00입니다. 소수점이 포함된 값을 저장합니다.
	 synopsis VARCHAR(4000) NOT NULL, -- 줄거리: 영화의 줄거리를 저장하는 필드로, 최대 4000글자까지 입력 가능하며 필수 항목입니다.
	 poster VARCHAR(500), -- 영화 포스터: 영화 포스터 이미지의 URL 또는 파일 경로를 저장하는 필드입니다. 최대 500글자까지 입력 가능하며 선택 사항입니다.
	 PRIMARY KEY(mcode) -- mcode를 기본 키로 설정하여 테이블의 각 행이 고유하게 식별되도록 합니다.
);
