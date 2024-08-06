package switch_;

import java.io.IOException;
import java.util.Scanner;

public class Switch02 {
    public static void main(String[] args) throws IOException {
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
            operator = (char) System.in.read(); 
            scanner.nextLine(); 
        } catch (Exception e) {
        	System.out.println("연산자 입력 오류");
        	return;
        }
        double result = 0;
        boolean error = false;
        switch (operator) {
        case '+' : result = a + b; break;
        case '-' : result = a - b; break;
        case '*' : result = a * b; break;
        case '/' : if (b !=0) {
        	result = (double) a / b;
        } 
        break;
        default : System.out.println("연산자 error");
        error = true;
        }
    if (!error) {
    	System.out.println(a + " " + operator + " " + b + " = " + result);
    }
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
*/
