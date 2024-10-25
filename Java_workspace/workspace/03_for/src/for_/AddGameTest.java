package for_;

import java.util.Scanner;

public class AddGameTest {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int a, b;  // 덧셈에 사용할 변수들
        int dab;   // 정답을 저장할 변수
        int count; // 맞춘 문제 수를 세는 변수
        String yn; // 게임을 계속할지 여부를 저장하는 변수

        while (true) {
            count = 0; // 맞춘 문제 수 초기화

            // 5문제 출제
            for (int i = 1; i <= 5; i++) {
                // 10부터 99까지의 난수를 생성하여 a, b에 할당
                a = (int) (Math.random() * 90 + 10); 
                b = (int) (Math.random() * 90 + 10);

                // 최대 2번의 기회 제공
                for (int j = 1; j <= 2; j++) {
                    System.out.print("[" + i + "] " + a + " + " + b + " = ");
                    dab = scan.nextInt();

                    if (dab == a + b) {
                        System.out.println("정답입니다.");
                        count++;
                        break; // 정답 맞추면 다음 문제로
                    } else {
                        if (j == 2) 
                            System.out.println("오답입니다. 정답은 " + (a + b));
                        else 
                            System.out.println("오답입니다.");
                    }
                }
                System.out.println();
            }

            // 게임 결과 출력
            System.out.println("당신은 총 " + count + " 문제를 맞추어서 점수 " + count * 20 + " 점 입니다.");

            // 게임 재시작 여부 확인
            do {
                System.out.print("또 할래(Y/N) : ");
                yn = scan.next();
            } while (!yn.equalsIgnoreCase("Y") && !yn.equalsIgnoreCase("N"));
            
            // "N"을 입력하면 게임 종료
            if (yn.equalsIgnoreCase("N")) break;
        }
        System.out.println("프로그램을 종료합니다.");
        scan.close();
    }
}


/*
[문제] 덧셈 계산 (for, while, 다중 for 사용조건)
- 10 ~ 99 사이의 난수를 2개 발생하여 합을 구하는 프로그램
- 5문제를 제공한다.
- 1문제당 점수 20점씩 처리한다.
- 틀리면 1번 더 기회를 주고, 2번 다 틀리면 답을 알려준다.
- y 또는 n 은 대소문자 상관없이 작성하시오.
- y 또는 Y 또는 n 또는 N 이 입력이 안되면 계속 반복한다.

*변수명 조건
		int a, b;
		int dab; // 답은 'dab'이다.
		int count=0;
		String yn;


[실행결과]
[1] 25 + 36 = 50
틀렸다
[1] 25 + 36 = 59
틀렸다 정답은 xx

[2] 10 + 25 = 35
딩동뎅

[5] 78 + 95 = 89
틀렸다
[5] 78 + 95 = 173
딩동뎅

당신은 총 x 문제를 맞추어서 점수 xx점 입니다.

또 할래(Y/N) : A
또 할래(Y/N) : w
또 할래(Y/N) : n (N)

프로그램을 종료합니다.

*/