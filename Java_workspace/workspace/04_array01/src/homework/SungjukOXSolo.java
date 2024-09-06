package homework;

import java.util.Scanner;

public class SungjukOXSolo {
    static final String JUNG = "11111"; // 정답을 나타내는 상수

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성

        // 인원수 입력
        System.out.print("인원수 입력 : ");
        int num = scan.nextInt(); // 사용자로부터 인원수를 입력받음
        scan.nextLine(); // 버퍼 비우기 (다음 입력을 위해)

        // 배열 초기화
        String[] name = new String[num]; // 학생 이름을 저장할 배열
        String[] dap = new String[num]; // 학생 답안을 저장할 배열
        char[][] ox = new char[num][5]; // 각 문제의 OX 결과를 저장할 2차원 배열
        int[] score = new int[num]; // 각 학생의 점수를 저장할 배열

        // 데이터 입력
        for (int i = 0; i < num; i++) {
            System.out.print("이름 입력 : ");
            name[i] = scan.nextLine(); // 각 학생의 이름을 입력받아 저장

            System.out.print("답안지 입력 : ");
            dap[i] = scan.nextLine(); // 각 학생의 답안을 입력받아 저장
        }

        // 성적 처리
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 5; j++) {
                // 학생의 답안과 정답을 비교하여 OX 결과와 점수를 계산
                if (dap[i].charAt(j) == JUNG.charAt(j)) {
                    ox[i][j] = 'O'; // 정답인 경우 'O' 저장
                    score[i] += 20; // 정답인 경우 20점 추가
                } else {
                    ox[i][j] = 'X'; // 오답인 경우 'X' 저장
                }
            }
        }

        // 결과 출력
        System.out.println("\n*** 성적표 ***");
        System.out.println("이름      1 2 3 4 5   점수");
        for (int i = 0; i < num; i++) {
            System.out.print(name[i] + " "); // 학생 이름 출력
            for (int j = 0; j < 5; j++) {
                System.out.print(" " + ox[i][j]); // 각 문제의 OX 결과 출력
            }
            System.out.println("   " + score[i]); // 학생의 점수 출력
        }

        scan.close(); // Scanner 객체 닫기
    }
}


/*

[문제] 성적처리 프로그램
- 5문제는 사지선다형 문제이다
- 정답은 "11111"
  static final String jung = "11111"; //상수화
- 1문제당 20점씩 한다.
  
   배열기준
String[] name = new String[2];
String dap;
char[][] ox = new char[2][5];
int score = new int[2];

[실행결과]
인원수 입력 : 2

이름 입력 : 홍길동
답안지 입력 : 12311

이름 입력 : 코난
답안지 입력 : 11311

      *** 성적표 ***
이름      1 2 3 4 5   점수
홍길동     O X X O O   60
코난      O O X O O   80


*/