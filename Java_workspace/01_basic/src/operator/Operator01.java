package operator;

import java.util.Scanner;

public class Operator01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner 객체 생성

       System.out.print("현금 입력 : "); // 현금 입력
       int cash = scanner.nextInt();
       int thousandCount = cash / 1000; // 천원계산
       int hundredCount = (cash % 1000) / 100; // 백원계산
       int tenCount = ((cash % 1000) % 100) / 10; // 십원계산
       int oneCount = ((cash % 1000) % 100) % 10; // 일원 계산
       System.out.println("천원 : " + thousandCount + " 장 "); // 천원의 개수 출력
       System.out.println("백원 : " + hundredCount + " 개 "); // 백원의 개수 출력
       System.out.println("십원 : " + tenCount + " 개 "); // 십원의 개수 출력
       System.out.println("일원 : " + oneCount + " 개 "); // 일원의 개수 출력
              
    }

}


/*
[문제] 동전 교환
현금을 입력하여 천, 백, 십, 일의 개수를 구하시오
- Scanner 이용
- 연산자 / % 만 사용하시오


[실행결과]
현금 입력 : 5723
천원 : 5장
백원 : 7개
십원 : 2개
일원 : 3개
*/
