package operator;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Salary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner 객체 생성
        DecimalFormat formatter = new DecimalFormat("#,###"); // 숫자 포맷을 지정하기 위한 DecimalFormat 객체 생성

        // 사용자 입력 받기
        System.out.print("이름 입력 : ");
        String name = scanner.nextLine(); // 사용자 이름 입력 받음

        System.out.print("직급 입력 : ");
        String position = scanner.nextLine(); // 사용자 직급 입력 받음

        System.out.print("기본급 입력 : ");
        int baseSalary = scanner.nextInt(); // 사용자 기본급 입력 받음

        System.out.print("수당 입력 : ");
        int allowance = scanner.nextInt(); // 사용자 수당 입력 받음

        // 합계 계산
        int total = baseSalary + allowance; // 기본급과 수당을 합하여 총 합계 계산

        // 세율 계산
        double taxRate = total >= 5000000 ? 0.03 : (total >= 3000000 ? 0.02 : 0.01); // 조건에 따라 세율 결정
        int tax = (int) (total * taxRate); // 세금 계산 (세율을 총 합계에 곱하여 계산)

        // 월급 계산
        int salary = total - tax; // 세금을 총 합계에서 빼서 실제 월급 계산

        // 결과 출력
        System.out.println("\n*** " + name + " " + position + " 월급 ***"); // 이름과 직급을 포함한 월급 제목 출력
        System.out.println("기본급 : " + formatter.format(baseSalary) + "원"); // 기본급 포맷에 맞추어 출력
        System.out.println("수당 : " + formatter.format(allowance) + "원"); // 수당 포맷에 맞추어 출력
        System.out.println("합계 : " + formatter.format(total) + "원"); // 총 합계 포맷에 맞추어 출력
        System.out.println("세금 : " + formatter.format(tax) + "원"); // 세금 포맷에 맞추어 출력
        System.out.println("월급 : " + formatter.format(salary) + "원"); // 월급 포맷에 맞추어 출력

        scanner.close(); // Scanner 객체 닫기 (리소스 해제)
    }
}




/*
[문제] 월급 계산 프로그램
이름, 직급, 기본급, 수당을 입력하여 합계, 세금, 월급을 출력하시오
       
합계 = 기본급 + 수당
세금 = 합계 * 세율
월급 = 합계 - 세금

[조건]
1. 세율은 조건 연산자 이용
합계가 5,000,000원 이상이면 3% (0.03)
     3,000,000원 이상이면 2% (0.02)
     아니면 1% (0.01)
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
