package switch_;

import java.util.Scanner;

public class Switch02solotest {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 사용자로부터 두 정수 입력받기
        System.out.print("a의 값 : ");
        int a = scanner.nextInt();
        System.out.print("b의 값 : ");
        int b = scanner.nextInt();

        // 사용자로부터 연산자 입력받기
        System.out.print("연산자(+,-,*,/)를 입력 : ");
        char operator;
        try {
            operator = (char) System.in.read(); // char 형태로 연산자 입력 받기
            scanner.nextLine(); // 입력 버퍼 비우기
        } catch (Exception e) {
            System.out.println("연산자 입력 오류");
            return;
        }

        // 계산 결과 변수 초기화
        double result = 0;
        boolean error = false; // 연산자 오류 여부를 판단하는 변수

        // 입력된 연산자에 따라 계산 수행
        switch (operator) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b != 0) {
                    result = (double) a / b; // 정수형 나눗셈을 실수형으로 변환하여 계산
                } else {
                    System.out.println("0으로 나눌 수 없습니다.");
                    error = true;
                }
                break;
            default:
                System.out.println("연산자 error");
                error = true;
        }

        // 연산자가 유효할 경우 결과 출력
        if (!error) {
            System.out.println(a + " " + operator + " " + b + " = " + result);
        }

        scanner.close(); // Scanner 객체 닫기
    }
}		

/*
 2개의 정수형 숫자와 연산자(+,-,*,/)를 입력하여 계산하시오
단, 정수형 숫자는 Scanner를 사용하고, 연산자는 System.in.read()를 사용하여 입력하시오

[실행결과]
a의 값 : 25
b의 값 : 36
연산자(+,-,*,/)를 입력 : +

25 + 36 = xx

a의 값 : 25
b의 값 : 36
연산자(+,-,*,/)를 입력 : /

25 / 36 = 0.6944444444444444

a의 값 : 25
b의 값 : 36
연산자(+,-,*,/)를 입력 : #

연산자 error
*/ // 연산자의 #은 error를 띄워라



