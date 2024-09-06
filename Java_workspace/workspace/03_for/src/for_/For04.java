package for_;

public class For04 {

	public static void main(String[] args) {
		int aCount = 0; // 'A'의 개수를 세기 위한 변수
        int lineCount = 0; // 한 줄에 10개씩 출력하기 위한 변수

        // 난수 100개 발생 및 출력
        for (int i = 0; i < 100; i++) {
            // A(65) ~ Z(90) 사이의 난수 발생
            char randomChar = (char) ('A' + Math.random() * 26);

            // 발생한 난수를 출력
            System.out.print(randomChar + "  ");

            // 'A'의 개수 세기
            if (randomChar == 'A') {
                aCount++;
            }

            // 한 줄에 10개씩 출력
            lineCount++;
            if (lineCount % 10 == 0) {
                System.out.println();
            }
        }

        // 'A'의 개수 출력
        System.out.println("\nA의 개수 = " + aCount);
    }
}

/*
[문제]
대문자(A~Z)에 까지 난수를 100개 발생하여 출력하시오
- 1줄에 10개씩 출력
- 100개중에서 A가 몇개 나왔는지 개수를 출력

[실행결과]
H  D  D  R  A  Y  A  K  T  H
C  X  F  Z  B  S  L  Y  Q  D
H  K  O  H  O  B  Z  N  J  T
U  P  A  P  K  Q  G  W  F  A
S  U  D  Z  I  V  J  U  O  G
L  M  Z  L  H  U  Y  D  Q  R
F  T  I  Z  A  W  E  O  F  Z
A  Y  C  I  U  Z  O  B  C  G
H  G  Y  Z  V  P  I  R  L  G
Y  H  R  R  M  H  Y  S  B  P

A의 개수 = 6


*/