package If;

public class SungJuk { 

    public static void main(String[] args) { 
        System.out.println(" *** L(name) 성적표 *** "); 
        
        String name = "L"; // 학생 이름 설정
        int kor = 85, eng = 90, math = 100; // 과목별 점수 설정
        
        // 총점 계산
        int tot = kor + eng + math; // 국어, 영어, 수학 점수를 합산하여 총점을 계산
        
        // 평균 계산
        double avg = (double) tot / 3; // 총점을 3으로 나누어 평균을 계산
        
        // 학점 계산
        String grade; // 학점 저장할 변수 선언
        if(avg >= 90) { // 평균이 90 이상이면
            grade = "A"; // 학점은 A
        } else if(avg >= 80) { // 평균이 80 이상이면
            grade = "B"; // 학점은 B
        } else if(avg >= 70) { // 평균이 70 이상이면
            grade = "C"; // 학점은 C
        } else if(avg >= 60) { // 평균이 60 이상이면
            grade = "D"; // 학점은 D
        } else { // 그 외의 경우
            grade = "F"; // 학점은 F
        }
                
        // 결과 출력
        System.out.println("\t *** " + name + " 성적표 ***"); // 성적표 헤더 출력
        System.out.println("국어\t영어\t수학\t총점\t평균\t학점"); // 각 항목 이름 출력
        System.out.println(kor + "\t" // 국어 점수 출력
                            + eng + "\t" // 영어 점수 출력
                            + math + "\t" // 수학 점수 출력
                            + tot + "\t" // 총점 출력
                            + String.format("%.3f", avg) + "\t" // 평균을 소수점 셋째 자리까지 포맷팅하여 출력
                            + grade); // 학점 출력
    }
}

/*
[문제] 성적 계산
이름이 L(name)이고 국어점수 85(kor), 영어점수 90(eng), 수학점수 100(math)일 때
총점(tot), 평균(avg), 학점(grade)을 구하시오.

[조건]
총점 = 국어 + 영어 + 수학
평균 = 총점 / 과목수
학점은 평균이 90이상이면 학점은 A
     평균이 80이상이면 학점은 B
     평균이 70이상이면 학점은 C
     평균이 60이상이면 학점은 D
     그 외는 학점은 F
    
평균의 소수 이하 3째 자리까지 출력

[실행결과]
 *** L 성적표 ***
국어 영어 수학 총점 평균    학점
85   90   100  275  91.667  A
*/
