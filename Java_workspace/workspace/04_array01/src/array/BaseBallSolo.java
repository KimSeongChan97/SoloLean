package array;

import java.util.Random;
import java.util.Scanner;

public class BaseBallSolo {

    public static void main(String[] args) {
        int[] com = new int[3]; // 컴퓨터의 숫자를 저장할 배열
        int[] user = new int[3]; // 사용자의 숫자를 저장할 배열

        Scanner scan = new Scanner(System.in); // 사용자 입력을 위한 Scanner 객체 생성
        Random random = new Random(); // 난수 생성을 위한 Random 객체 생성
        boolean gameOn = false; // 게임 실행 여부를 저장하는 변수

        // 게임 시작 여부 확인
        while (true) {
            System.out.print("게임을 실행하시겠습니까(Y/N) : ");
            char start = scan.next().charAt(0); // 사용자로부터 Y/N 입력받기

            if (start == 'Y' || start == 'y') {
                gameOn = true;
                break;
            } else if (start == 'N' || start == 'n') {
                gameOn = false;
                break;
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }

        // 게임을 시작하는 경우
        if (gameOn) {
            System.out.println("게임을 시작합니다.");

            // 컴퓨터의 난수 생성 (중복 제거)
            for (int i = 0; i < com.length; i++) {
                com[i] = random.nextInt(9) + 1; // 1~9 사이의 난수 생성
                for (int j = 0; j < i; j++) {
                    if (com[i] == com[j]) {
                        i--; // 중복된 경우 다시 난수 생성
                        break;
                    }
                }
            }

            // 게임 진행
            while (true) {
                System.out.print("숫자 입력 : ");
                String input = scan.next(); // 사용자가 입력한 숫자를 문자열로 받음

                // 입력한 문자열을 숫자 배열로 변환
                for (int i = 0; i < user.length; i++) {
                    user[i] = input.charAt(i) - '0'; // 각 문자를 숫자로 변환하여 배열에 저장
                }

                int strike = 0; // 스트라이크 개수
                int ball = 0; // 볼 개수

                // 스트라이크와 볼 개수 계산
                for (int i = 0; i < user.length; i++) {
                    for (int j = 0; j < com.length; j++) {
                        if (user[i] == com[j]) {
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

                // 게임 종료 조건 확인
                if (strike == 3) {
                    System.out.println("3스트라이크 0볼");
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }
            }
        } else {
            // 게임을 시작하지 않는 경우
            System.out.println("프로그램을 종료합니다.");
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