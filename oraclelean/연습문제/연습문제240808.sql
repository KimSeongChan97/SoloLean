-- GROUP BY / HAVING
-- 문제1) 화학과를 제외하고 학과별로 학생들의 평점 평균을 검색하시오 (GROUP, HAVING)
--       평균을 소수이하 2째 자리에서 반올림
--       테이블 : STUDENT
select * from student; -- STUDENT 테이블의 모든 데이터를 조회하여 테이블 구조와 데이터를 확인

-- 화학과를 제외하고 학과별 평균 평점을 계산 (GROUP BY와 HAVING 사용)
select major, round(avg(avr), 2) as "평점 평균" -- 학과별 평균 평점을 소수점 둘째자리까지 반올림
from student
group by major -- 학과별로 그룹화
having major != '화학'; -- 화학과를 제외한 학과들만 선택

-- WHERE 절을 사용하여 화학과를 제외하고 학과별 평균 평점을 계산
select major, round(avg(avr), 2) as "평점 평균" -- 학과별 평균 평점을 소수점 둘째자리까지 반올림
from student
where major <> '화학' -- 화학과를 제외
group by major -- 학과별로 그룹화
having avg(avr) is not null; -- 평균 평점이 NULL이 아닌 그룹만 선택

-- 문제2) 화학과를 제외한 각 학과별 평균 평점 중에 평점이 2.0 미만인 정보를 검색하시오
--       테이블 : STUDENT
-- 학과별로 그룹화하여 평균 평점을 계산하고, 화학과를 제외하고, 평균 평점이 2.0 미만인 학과 선택
select major, round(avg(avr), 2) as "평점 평균" -- 학과별 평균 평점을 소수점 둘째자리까지 반올림
from student
group by major -- 학과별로 그룹화
having major != '화학' and round(avg(avr), 2) < 2.0; -- 화학과를 제외하고, 평균 평점이 2.0 미만인 학과 선택

-- WHERE 절을 사용하여 화학과를 제외하고 학과별 평균 평점을 계산, 평균 평점이 2.0 미만인 학과 선택
select major, round(avg(avr), 2) as "평점 평균"
from student
where major <> '화학' -- 화학과를 제외
group by major -- 학과별로 그룹화
having avg(avr) < 2.0; -- 평균 평점이 2.0 미만인 학과 선택

-- JOIN
-- 문제1) 화학과 1학년 학생의 기말고사 성적을 검색하시오
-- 테이블 : STUDENT ST, SCORE SC, COURSE CO
-- 컬럼 : SNO, SNAME, MAJOR, SYEAR, CNO, CNAME, RESULT

-- STUDENT, SCORE, COURSE 테이블의 모든 데이터를 조회하여 테이블 구조와 데이터를 확인
select * from STUDENT;
select * from SCORE;
select * from COURSE;

-- 화학과 1학년 학생의 기말고사 성적을 조회하는 쿼리 (옛날 방식)
select st.SNO, st.SNAME, MAJOR, SYEAR, sc.CNO, CNAME, RESULT
from STUDENT ST, SCORE SC, COURSE CO
where st.sno=sc.sno and sc.cno=co.cno and st.major='화학' and syear=1;

-- JOIN 절을 사용하여 화학과 1학년 학생의 기말고사 성적을 조회하는 쿼리
select SNO, SNAME, MAJOR, SYEAR, CNO, CNAME, RESULT
from STUDENT
join SCORE using(sno) -- 학생 번호로 STUDENT와 SCORE 테이블 조인
join COURSE using(cno) -- 코스 번호로 SCORE와 COURSE 테이블 조인
where major='화학' and syear=1; -- 화학과 1학년 학생 선택

-- JOIN 절과 명시적 조인 조건을 사용하여 화학과 1학년 학생의 기말고사 성적을 조회하는 쿼리
select 
    ST.SNO,       -- 학생 번호
    ST.SNAME,     -- 학생 이름
    ST.MAJOR,     -- 전공
    ST.SYEAR,     -- 학년
    CO.CNO,       -- 코스 번호
    CO.CNAME,     -- 코스 이름
    SC.RESULT     -- 성적
from student st
join score sc on st.sno = sc.sno -- 학생 번호로 STUDENT와 SCORE 테이블 조인
join course co on sc.cno = co.cno -- 코스 번호로 SCORE와 COURSE 테이블 조인
where
    st.major = '화학' -- 화학과 학생만 선택
    and st.syear = 1; -- 1학년 학생만 선택

-- 문제2) 화학과 1학년 학생의 일반화학 기말고사 점수를 검색하시오
-- 테이블 : STUDENT ST, SCORE SC, COURSE CO
-- 컬럼 : SNO, SNAME, MAJOR, SYEAR, CNO, CNAME, RESULT

-- 화학과 1학년 학생 중 일반화학 과목의 성적을 조회하는 쿼리 (옛날 방식)
select st.SNO, st.SNAME, MAJOR, SYEAR, sc.CNO, CNAME, RESULT
from STUDENT ST, SCORE SC, COURSE CO
where st.sno=sc.sno and sc.cno=co.cno and st.major='화학' and syear=1 and cname='일반화학';

-- JOIN 절을 사용하여 화학과 1학년 학생 중 일반화학 과목의 성적을 조회하는 쿼리
select SNO, SNAME, MAJOR, SYEAR, CNO, CNAME, RESULT
from STUDENT
join SCORE using(sno) -- 학생 번호로 STUDENT와 SCORE 테이블 조인
join COURSE using(cno) -- 코스 번호로 SCORE와 COURSE 테이블 조인
where major='화학' and syear=1 and cname='일반화학'; -- 화학과 1학년 학생 중 일반화학 과목만 선택

-- JOIN 절과 명시적 조인 조건을 사용하여 화학과 1학년 학생 중 일반화학 과목의 성적을 조회하는 쿼리
SELECT ST.SNO, ST.SNAME, ST.MAJOR, ST.SYEAR, CO.CNO, CO.CNAME, SC.RESULT   
FROM STUDENT ST
JOIN SCORE SC ON ST.SNO = SC.SNO -- 학생 번호로 STUDENT와 SCORE 테이블 조인
JOIN COURSE CO ON SC.CNO = CO.CNO -- 코스 번호로 SCORE와 COURSE 테이블 조인
WHERE 
    ST.MAJOR = '화학'        -- 화학과 학생만 선택
    AND ST.SYEAR = 1         -- 1학년 학생만 선택
    AND CO.CNAME = '일반화학'; -- 일반화학 코스만 선택

-- 아래의 문제는 나중에 푸니까 제외
-- 문제3) 학생중에 동명이인을 검색하여 이름으로 오름차순하고, 만약 같은 이름은 번호로 오름차순하시오
-- 테이블 : STUDENT
-- 컬럼 : SNO, SNAME
