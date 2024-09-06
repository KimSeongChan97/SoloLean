package array;

import java.io.IOException;
import java.util.Scanner;

public class BaseBall {

   public static void main(String[] args) throws IOException {
      Scanner scan = new Scanner(System.in); // Scanner 객체 생성
      
      int[] com = new int[3]; // 컴퓨터의 숫자를 저장할 배열
      int[] user = new int[3]; // 사용자의 숫자를 저장할 배열
      String yn; // 사용자가 게임 실행 여부를 입력할 변수
      int strike, ball; // 스트라이크와 볼 개수를 저장할 변수
      
      // 게임 실행 여부 확인
      do {
         System.out.print("게임을 실행하시겠습니까(Y/N) : ");
         yn = scan.next(); // 사용자로부터 Y/N 입력 받기
      } while (!yn.equals("Y") && !yn.equals("y") && !yn.equals("N") && !yn.equals("n")); // Y 또는 N이 입력될 때까지 반복
      
      if (yn.equals("Y") || yn.equals("y")) {
         System.out.println("\n게임을 시작합니다");

         // 컴퓨터의 난수 생성 (중복 제거)
         for (int i = 0; i < com.length; i++) {
            com[i] = (int) (Math.random() * 9 + 1); // 1부터 9 사이의 난수 생성
            
            // 중복 체크
            for (int j = 0; j < i; j++) {
               if (com[i] == com[j]) {
                  i--; // 중복된 숫자가 있으면 다시 난수 생성
                  break;
               }
            }
         }

         // 사용자 입력 받기
         while (true) {
            System.out.print("\n숫자 입력 : ");
            for (int i = 0; i < user.length; i++) {
               user[i] = System.in.read() - '0'; // 사용자가 입력한 숫자를 배열에 저장
            }
            System.in.read(); // Enter 키 입력 처리
            System.in.read(); // 버퍼 비우기

            // 스트라이크와 볼 계산
            strike = ball = 0;
            for (int i = 0; i < com.length; i++) {
               for (int j = 0; j < user.length; j++) {
                  if (com[i] == user[j]) {
                     if (i == j) {
                        strike++; // 위치와 숫자가 모두 일치하면 스트라이크
                     } else {
                        ball++; // 숫자만 일치하면 볼
                     }
                  }
               }
            }

            // 결과 출력
            System.out.println(strike + "스트라이크 " + ball + "볼");

            // 게임 종료 조건
            if (strike == 3) {
               System.out.println("3스트라이크 0볼");
               System.out.println("프로그램을 종료합니다.");
               break;
            }
         }
      } else {
         // 게임을 실행하지 않는 경우
         System.out.println("\n프로그램을 종료합니다.");
      }

      scan.close(); // Scanner 객체 닫기
   }

}


/*
[문제] 야구게임
- 크기가 3개인 정수형 배열을 잡고 1~9사이의 난수를 발생한다
- 발생한 난수를 맞추는 게임
- 난수는 중복을 제거한다

[실행결과]
게임을 실행하시겠습니까(Y/N) : w
게임을 실행하시겠습니까(Y/N) : u
게임을 실행하시겠습니까(Y/N) : y

게임을 시작합니다

숫자입력 : 123
0스트라이크 0볼

숫자입력 : 567
0스트라이크 2볼

숫자입력 : 758
1스트라이크 2볼
...

숫자입력 : 785
3스트라이크 0볼

프로그램을 종료합니다.

*/