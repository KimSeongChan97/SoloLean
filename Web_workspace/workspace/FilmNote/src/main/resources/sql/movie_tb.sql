CREATE TABLE movie_tb(
	 mcode INT NOT NULL AUTO_INCREMENT, -- 영화코드
	 title VARCHAR(100) NOT NULL, -- 영화제목
	 director VARCHAR(100) NOT NULL, -- 영화감독
	 genre VARCHAR(100), -- 영화장르
	 release_date DATE NOT NULL, -- 개봉일
	 rating INT NOT NULL, -- 영화 등급 : 0, 15, 19
	 score FlOAT DEFAULT 0.00, -- 영화평점
	 synopsis VARCHAR(4000) NOT null, -- 줄거리
	 poster VARCHAR(500), -- 영화 포스터
	 primary Key(mcode)
);