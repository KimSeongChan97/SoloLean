package homework;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 입력 받기
        System.out.print("이름 입력 : ");
        String name = scanner.nextLine();
        
        System.out.print("직급 입력 : ");
        String position = scanner.nextLine();
        
        System.out.print("기본급 입력 : ");
        int basicSalary = scanner.nextInt();
        
        System.out.print("수당 입력 : ");
        int allowance = scanner.nextInt();
        
        // 합계 계산
        int total = basicSalary + allowance;
        
        // 세금 계산
        double taxRate = 0.03;
        int tax = (int)(total * taxRate);
        
        // 월급 계산
        int salary = total - tax;
        
        // 숫자를 3자리마다 , 로 표시
        DecimalFormat df = new DecimalFormat("#,###");

        // 결과 출력
        System.out.printf("\n*** %s %s 월급 ***\n", name, position);
        System.out.printf("기본급 : %s원\n", df.format(basicSalary));
        System.out.printf("수당 : %s원\n", df.format(allowance));
        System.out.printf("합계 : %s원\n", df.format(total));
        System.out.printf("세금 : %s원\n", df.format(tax));
        System.out.printf("월급 : %s원\n", df.format(salary));
        
        scanner.close();
    }
}


/*
[문제] 월급 계산 프로그램
이름, 직급, 기본급, 수당을 입력하여 합계, 세금, 월급을 출력하시오
       
합계 = 기본급 + 수당
세금 = 합계 * 세율
월급 = 합계 - 세금

[조건]
1. 세율은 3%(0.03) 으로 한다.
2. 숫자는 3자리마다 , 표시 -> DecimalFormat 클래스 사용
3. 소수이하는 표시하지 않는다. (정수형)  
4. Scanner 클래스 사용한다.

[실행결과]
이름 입력 : 홍길동
직급 입력 : 부장
기본급 입력 : 4900000
수당 입력 : 200000

*** 홍길동 부장 월급 ***
기본급 : 4,900,000원
수당 : 200,000원
합계 : 5,100,000원
세금 : 153,000원
월급 : 4,947,000원

 */
