package homework;

import java.util.Scanner;

public class Sungjuk {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // Scanner 객체 생성
        
        // 인원수 입력
        System.out.print("인원수 입력 : ");
        int cnt = scan.nextInt(); // 사용자로부터 인원수를 입력받음
              
        // 배열 초기화
        String[] name = new String[cnt];
        int subjectCnt;
        String[][] subject = new String[cnt][];
        int[][] jumsu = new int[cnt][];
        double[] avg = new double[cnt];
        
        //입력
        for(int i=0; i<cnt; i++) {
           System.out.print("이름 입력 : ");
           name[i] = scan.next();
           
           System.out.print("과목수 입력 : ");
           subjectCnt = scan.nextInt(); //2
           
           subject[i] = new String[subjectCnt]; //생성
           for(int j=0; j<subjectCnt; j++) {
              System.out.print("과목명 입력 : ");
              subject[i][j] = scan.next();
           }//for j
           
           jumsu[i] = new int[subjectCnt + 1]; //생성 - 과목수 + 총점
           for(int j=0; j<subjectCnt; j++) {
              System.out.print(subject[i][j] + " 점수 입력 : ");
              jumsu[i][j] = scan.nextInt();
              
              jumsu[i][subjectCnt] += jumsu[i][j]; //총점
           }//for j
           
           //평균
           avg[i] = (double)jumsu[i][subjectCnt] / subjectCnt;
           
           System.out.println("------------------");
           
        }//for i
        
        //출력
        System.out.println();
        for(int i=0; i<cnt; i++) {
           //제목
           System.out.print("이름\t");
           for(int j=0; j<subject[i].length; j++) {
              System.out.print(subject[i][j] + "\t");
           }//for j
           System.out.println("총점\t평균");
           
           //데이터
           System.out.print(name[i] + "\t");
           for(int j=0; j<jumsu[i].length; j++) {
              System.out.print(jumsu[i][j] + "\t");
           }//for j
           System.out.println(String.format("%.2f", avg[i]));
           
           System.out.println();
           
        }//for i

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

