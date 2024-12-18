1. 모든 학생의 정보를 검색하시오 (STUDENT)
SELECT *  FROM STUDENT;

2. 모든 과목의 정보를 검색하시오 (COURSE)
SELECT *  FROM COURSE;

3. 기말고사 시험점수를 검색하시오 (SCORE)
SELECT *  FROM SCORE;

4. 학생들의 학과와 학년을 검색하시오  (STUDENT)
SELECT SNO 학번,
               SNAME 이름,
               MAJOR 학과,
               SYEAR 학년 
FROM STUDENT;

5. 각 과목의 이름과 학점을 검색하시오 (COURSE)
SELECT CNAME 과목명,
                ST_NUM 학점
FROM COURSE;

6. 모든 교수의 직위를 검색하시오 (PROFESSOR)
SELECT ORDERS 직위 FROM PROFESSOR;

7. 각 학생의 평점을 검색하시오(별명 사용) (STUDENT)
SELECT SNO AS 학번,
                SNAME AS 이름,
                AVR AS 평점
FROM STUDENT;

8. 각 과목의 학점수를 검색하시오(별명 사용) (COURSE)
SELECT CNO AS 과목코드,
                CNAME AS 과목 ,
                ST_NUM AS 학점수 
FROM COURSE;

9. 급여를 10%인상했을 때 연간 지급되는 급여를 검색하시오(별명 사용) (EMP)
SELECT ENO AS 사번,
               ENAME AS 이름,
               SAL * 1.1 AS 인상급여
FROM EMP;

10. 현재 학생의 평균 평점은 4.0만점이다. 
      이를 4.5만점으로 환산해서 검색하시오(별명 사용) (STUDENT)
SELECT SNAME AS 학생명,
                SNO AS 학번,
                AVR * (4.5 / 4.0) AS 환산점수
FROM STUDENT;

11. 성적순으로 학생의 이름을 검색하시오 (STUDENT)
SELECT SNO AS 학번, 
                SNAME AS 이름, 
                AVR AS 성적
FROM STUDENT
ORDER BY AVR DESC;

12. 화학과 학생을 검색하시오 (STUDENT)
SELECT * FROM STUDENT WHERE MAJOR = '화학';

13. 평점이 2.0 미만인 학생을 검색하시오 (STUDENT)
SELECT * FROM STUDENT WHERE AVR < 2.0 ORDER BY AVR DESC;

14. 관우 학생의 평점을 검색하시오 (STUDENT)
SELECT SNO AS 학번,
                SNAME AS 이름,
                AVR AS 평점
FROM STUDENT
WHERE SNAME = '관우';

15. 담당 교수가 없는 과목의 정보를 검색하시오 (COURSE)
SELECT * FROM COURSE  WHERE PNO IS NULL;

16. 화학과가 아닌 학생중에 1학년 학생을 검색하시오 (STUDENT)
SELECT * FROM STUDENT WHERE MAJOR != '화학'  AND SYEAR = 1;

17. 물리학과 3학년 학생을 검색하시오 (STUDENT)
SELECT * FROM STUDENT WHERE MAJOR = '물리' AND SYEAR = 3;

18. 교수가 지정되지 않은 과목중에 학점이 3학점인 과목을 검색하시오 (COURSE)
SELECT * FROM COURSE WHERE ST_NUM = 3 AND PNO IS NULL;

19. 화학과 관련된 과목중 평점이 2학점 이하인 과목을 검색하시오 (COURSE)
SELECT * FROM COURSE WHERE CNAME like '%화학%'  AND ST_NUM <= 2;

20. 화학과 정교수를 검색하시오 (PROFESSOR)
SELECT * FROM PROFESSOR  WHERE SECTION = '화학'  AND ORDERS = '정교수';

21. 물리학과 학생중에 성이 사마씨인 학생을 검색하시오 (STUDENT)
SELECT * FROM STUDENT  WHERE MAJOR = '물리'  AND SNAME LIKE '사마%';

22. 부임일이 1995년 이전인 정교수를 검색하시오 (PROFESSOR)
SELECT * FROM PROFESSOR  WHERE HIREDATE < '1995/01/01'  AND ORDERS ='정교수';

23. 성과 이름이 각각 1글자인 교수를 검색하시오 (PROFESSOR)
SELECT *  FROM PROFESSOR WHERE PNAME LIKE '__';

