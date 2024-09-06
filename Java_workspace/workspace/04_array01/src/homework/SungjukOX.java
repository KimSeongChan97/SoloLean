package homework;

import java.util.Scanner;

public class SungjukOX {
	static final String JUNG = "11111"; //필드 - 상수화

	   public static void main(String[] args) {
		      Scanner scan = new Scanner(System.in);
		      int size;
		      
		      System.out.print("인원수 입력 : ");
		      size = scan.nextInt();
		      
		      String[] name = new String[size];
		      String dap;
		      char[][] ox = new char[size][5];
		      int[] score = new int[size];
		      
		      //입력, 비교
		      for(int i=0; i<size; i++) {
		         System.out.print("이름 입력 : ");
		         name[i] = scan.next();
		         
		         System.out.print("답안지 입력 : ");
		         dap = scan.next(); //"12311"
		         
		         //비교
		         for(int j=0; j<ox[i].length; j++) { //5문제
		            if(JUNG.charAt(j) == dap.charAt(j)) {
		               ox[i][j] = 'O';
		               score[i] += 20;
		            }
		            else 
		               ox[i][j] = 'X';
		         }
		         
		         System.out.println();
		      }//for i
		            
		      //출력
		      System.out.println("이름\t1  2  3  4  5  \t점수");
		      for(int i=0; i<size; i++) {
		         System.out.print(name[i] + "\t");
		         for(int j=0; j<ox[i].length; j++) {
		            System.out.print(ox[i][j] + "  ");
		         }
		         System.out.println("\t" + score[i]);
		      }//for i
		      
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