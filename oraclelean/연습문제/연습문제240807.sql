-- 1. 유공과와 생물과, 식영과 학생을 검색하고 오름차순으로 정렬하시오
-- 테이블 : STUDENT
select * from student where major in ('유공', '생물', '식영')
order by major asc;

-- 2. 평점이 2.0에서 3.0사이인 학생을 검색하시오 (BETWEEN ~ AND 사용)
-- 테이블 : STUDENT
select * from student where avr between 2.0 and 3.0;

-- 3. 성과 이름이 각각 1글자인 교수를 검색하라
-- 테이블 : PROFESSOR
select * from professor where pname like '__';
