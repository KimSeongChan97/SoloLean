package homework;

import java.util.Scanner;

public class Jinsu {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // 정수 입력
        System.out.print("정수를 입력 : ");
        int dec = scan.nextInt();
        
        // 정수를 각각의 진법으로 변환하여 문자열로 저장
        String bin = Integer.toBinaryString(dec); // 2진수 변환
        String oct = Integer.toOctalString(dec); // 8진수 변환
        String hex = Integer.toHexString(dec); // 16진수 변환
        
        // 10진수 출력
        System.out.println("10진수 = " + dec);
        // 2진수 변환 출력
        System.out.println("2진수 = " + bin);
        // 8진수 변환 출력
        System.out.println("8진수 = " + oct);
        // 16진수 변환 출력
        System.out.println("16진수 = " + hex);
    }
}


/*
[문제] 정수형 데이터를 입력하여 2진수, 8진수, 16진수로 변환한 값을 출력하시오
- Scanner 클래스 사용가능

[조건]
2진수, 8진수, 16진수로 변환시켜주는 메소드를 이용하시오 - Integer

[실행결과]
10진수 = 250 (dec)
2진수 = 1111 1010 (bin)
8진수 = 372 (oct)
16진수 = fa (hex)
 
 */


