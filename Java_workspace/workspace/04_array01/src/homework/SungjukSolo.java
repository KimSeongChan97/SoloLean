package homework;

import java.util.Scanner;

public class SungjukSolo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // Scanner 객체 생성
        
        // 인원수 입력
        System.out.print("인원수 입력 : ");
        int cnt = scan.nextInt(); // 사용자로부터 인원수를 입력받음
        scan.nextLine(); // 버퍼 비우기
        
        // 배열 초기화
        String[] names = new String[cnt]; // 이름 배열
        int[][] scores = new int[cnt][]; // 점수 배열
        String[][] subjects = new String[cnt][]; // 과목명 배열
        int[] totals = new int[cnt]; // 총점 배열
        double[] avgs = new double[cnt]; // 평균 배열

        // 학생별 데이터 입력
        for (int i = 0; i < cnt; i++) {
            System.out.print("이름 입력 : ");
            names[i] = scan.nextLine(); // 각 학생의 이름 입력받음
            
            System.out.print("과목수 입력 : ");
            int subjectCnt = scan.nextInt(); // 각 학생의 과목 수 입력받음
            scan.nextLine(); // 버퍼 비우기
            
            subjects[i] = new String[subjectCnt]; // 해당 학생의 과목명 배열 초기화
            scores[i] = new int[subjectCnt]; // 해당 학생의 점수 배열 초기화
            
            // 각 과목명 입력받기
            for (int j = 0; j < subjectCnt; j++) {
                System.out.print("과목명 입력 : ");
                subjects[i][j] = scan.nextLine(); // 각 과목명을 입력받아 배열에 저장
            }
            
            // 각 과목의 점수 입력받기
            for (int j = 0; j < subjectCnt; j++) {
                System.out.print(subjects[i][j] + " 점수 입력 : ");
                scores[i][j] = scan.nextInt(); // 해당 과목의 점수 입력받아 배열에 저장
                totals[i] += scores[i][j]; // 총점 계산
            }
            scan.nextLine(); // 버퍼 비우기 (다음 입력을 위해)
            avgs[i] = (double)totals[i] / subjectCnt; // 평균 계산
        }
        
        // 결과 출력
        for (int i = 0; i < cnt; i++) {
            System.out.println(" " + names[i] + "\"의 실행결과");
            System.out.print("이름\t");
            for (int j = 0; j < subjects[i].length; j++) {
                System.out.print(subjects[i][j] + "\t"); // 과목명 출력
            }
            System.out.println("총점\t평균");
            
            System.out.print(names[i] + "\t");
            for (int j = 0; j < subjects[i].length; j++) {
                System.out.print(scores[i][j] + "\t"); // 과목별 점수 출력
            }
            System.out.printf("%d\t%.2f\n", totals[i], avgs[i]); // 총점과 평균 출력
        }
        
        scan.close(); // Scanner 객체 닫기
    }
}


/*
[문제] 성적 계산
인원수를 입력하여 인원수만큼 데이터를 입력받고 총점과 평균을 구하시오
평균은 소수이하 2째자리까지 출력

[실행결과]
인원수 : 2 (cnt)

이름 입력 : 홍길동 (name)
과목수 입력 : 2   (subjectCnt)
과목명 입력 : 국어 (subject)
과목명 입력 : 영어
국어 점수 입력 : 95 (jumsu)
영어 점수 입력 : 100
---------------------
이름 입력 : 이기자
과목수 입력 : 3
과목명 입력 : 국어
과목명 입력 : 영어
과목명 입력 : 과학
국어 점수 입력 : 95
영어 점수 입력 : 100
과학 점수 입력 : 90
---------------------
"홍길동"의 실행결과
이름     국어     영어   총점     평균
홍길동    95     100   xxx     xx.xx

"이기자"의 실행결과
이름      국어  영어   과학    총점      평균
이기자      95   100   90    xxx      xx.xx
*/