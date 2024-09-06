package switch_;

import java.io.IOException;
import java.util.Scanner;

public class Switch02answer {

public static void main(String[] args) throws IOException {
Scanner scan = new Scanner(System.in);

int a, b, op;
System.out.print("a의 값 : ");
a = scan.nextInt();
System.out.print("b의 값 : ");
b = scan.nextInt();
System.out.print("연산자(+,-,*,/)를 입력 : ");
op = System.in.read();

switch(op) {
case '+' : System.out.println(a + " + " + b + " = " + (a+b)); break;
case '-' : System.out.println(a + " - " + b + " = " + (a-b)); break;
case '*' : System.out.println(a + " * " + b + " = " + (a*b)); break;
case '/' : System.out.println(a + " / " + b + " = " + (double)a/b); break;
default : System.out.println("연산자 error");

}//switch

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