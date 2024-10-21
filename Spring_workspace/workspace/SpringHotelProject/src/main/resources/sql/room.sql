CREATE TABLE room (
    room_id INT PRIMARY KEY AUTO_INCREMENT,   -- 고유 객실 ID
    type VARCHAR(20) NOT NULL,                -- 객실 형태 (예: 스위트, 디럭스 등)
    size INT NOT NULL,                        -- 객실 크기 (평수 또는 제곱미터)
    capacity INT NOT NULL,                    -- 객실 수용 인원
    price INT NOT NULL,                       -- 객실 1박 가격
    count INT NOT NULL,                       -- 객실 총 개수
    description TEXT NOT NULL,                -- 객실 설명
    form TEXT NOT NULL,                       -- 객실 구성 (침대, 욕실 등)
    view TEXT NOT NULL,                       -- 객실 전망
    bedtype TEXT NOT NULL                     -- 침대 타입 (예: 킹사이즈, 싱글 등)
);

-- 객실 정보를 삽입하는 SQL 문
INSERT INTO room (room_id, type, size, capacity, price, count, description, form, view, bedtype) 
VALUES 
(1, 'standard', 35, 3, 200000, 10, '기본 편의시설을 갖춘 스탠다드 룸입니다.', '1개의 침대, 1개의 욕실', '도시 전망', '퀸 사이즈 침대'), -- 스탠다드 룸
(2, 'deluxe', 62, 4, 250000, 3, '고급 시설을 갖춘 디럭스 룸입니다.', '2개의 침대, 1개의 욕실', '정원 전망', '킹 사이즈 침대'),   -- 디럭스 룸
(3, 'sweet', 102, 8, 400000, 3, '가족이 머물기 좋은 스위트 룸입니다.', '3개의 침대, 2개의 욕실', '바다 전망', '킹 + 트윈 침대'),  -- 스위트 룸
(4, 'royal', 210, 10, 620000, 5, '프리미엄 편의시설을 갖춘 로열 스위트입니다.', '4개의 침대, 3개의 욕실', '파노라마 전망', '슈퍼 킹 사이즈 침대'); -- 로열 스위트