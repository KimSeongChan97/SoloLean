package class_;

public class SungJukMain {

    public static void main(String[] args) {
        // SungJuk 클래스의 객체 aa를 생성
        SungJuk aa = new SungJuk();
        
        // aa 객체의 데이터를 설정 (이름, 국어, 영어, 수학 점수)
        aa.setData("홍길동", 90, 96, 100);
        
        // 총점, 평균, 학점을 계산
        aa.calc();
        
        // aa 객체의 정보를 출력
        System.out.println(aa.getName() + "\t" // 이름 출력
                           + aa.getKor() + "\t" // 국어 점수 출력
                           + aa.getEng() + "\t" // 영어 점수 출력
                           + aa.getMath() + "\t" // 수학 점수 출력
                           + aa.getTot() + "\t" // 총점 출력
                           + String.format("%.2f", aa.getAvg()) + "\t" // 평균 출력 (소수점 둘째 자리까지)
                           + aa.getGrade()); // 학점 출력
    }
}

/*
[문제] 성적처리
- 총점, 평균, 학점을 구하시오. ( 학점은 90이상은 A, 80이상은 B, 70이상은 C, 60이상은 D, 그 외는 F로 한다.)
- 평균은 소수이하 2째자리까지 처리한다.

클래스명 : SungJuk
필드 : name, kor, eng, math, tot, avg, grade
메소드 : setData(이름, 국어, 영어, 수학)
       calc() - 총점, 평균, 학점 계산
   getName()
   getKor()
   getEng()
   getMath()
       getTot()
       getAvg()
       getGrade()

클래스명 : SungJukMain

[실행결과]
----------------------------------------------------
이름 국어 영어 수학 총점 평균 학점
----------------------------------------------------
홍길동 90 96 100


*/