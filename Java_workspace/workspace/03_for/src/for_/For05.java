package for_;

import java.util.Scanner;

public class For05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Scanner 객체 생성

        while (true) { // 무한 루프 시작, 사용자가 x를 0으로 입력할 때까지 반복
            // x 입력 받기
            System.out.print("x : ");
            int x = scanner.nextInt();
            
            if (x == 0) { // x가 0이면 프로그램 종료
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            // y 입력 받기
            int y;
            while (true) { // y가 음수가 아닌 값이 입력될 때까지 반복
                System.out.print("y : ");
                y = scanner.nextInt();
                if (y >= 0) {
                    break;
                }
                System.out.println("y는 음수가 될 수 없습니다. 다시 입력하세요.");
            }

            // x의 y승 계산
            int result = 1;
            for (int i = 0; i < y; i++) {
                result *= x;
            }

            // 결과 출력
            System.out.println(x + "의 " + y + "승은 " + result + "\n");
        }

        scanner.close(); // Scanner 객체 닫기
    }

}

/*
[문제] x와 y의 제곱승을 구하시오
- y의 값은 음수가 들어오면 다시 입력한다.
- x의 값이 0이면 프로그램을 종료한다.
(for, while 사용)

[실행결과]
x : 2
y : 5
2의 5승은 32


x : 2
y : -2
y : 7
2의 7승 128

x : 0
프로그램을 종료합니다.


*/