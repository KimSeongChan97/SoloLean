package class_;

import java.text.DecimalFormat;

public class SalaryMain {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat(); // 숫자를 3자리마다 쉼표로 구분하는 역할을 하는 객체 생성
        
        SalaryDTO[] ar = new SalaryDTO[3]; // SalaryDTO 객체 배열을 생성
        ar[0] = new SalaryDTO(); // 첫 번째 배열 요소에 SalaryDTO 객체를 생성하여 할당
        ar[1] = new SalaryDTO(); // 두 번째 배열 요소에 SalaryDTO 객체를 생성하여 할당
        ar[2] = new SalaryDTO(); // 세 번째 배열 요소에 SalaryDTO 객체를 생성하여 할당
        
        // 각 객체에 데이터 설정
        ar[0].setData("홍길동", "이사", 4800000, 300000); // 첫 번째 객체의 데이터를 설정
        ar[1].setData("송중기", "사원", 2000000, 100000); // 두 번째 객체의 데이터를 설정
        ar[2].setData("아이유", "주임", 2900000, 150000); // 세 번째 객체의 데이터를 설정
        
        // 모든 객체에 대해 월급 계산
        for(SalaryDTO dto : ar) {
            dto.calc(); // 각 객체의 calc 메서드를 호출하여 합계, 세율, 세금, 월급을 계산
        }
        
        // 결과 출력
        System.out.println("이름\t직급\t기본급\t수당\t합계\t세율\t세금\t월급");
        System.out.println("----------------------------------------------------------");
        
        // 각 객체의 정보를 출력
        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i].getName() + "\t" // 이름 출력
                    + ar[i].getJob() + "\t" // 직급 출력
                    + df.format(ar[i].getBasic()) + "\t" // 기본급을 3자리마다 쉼표로 구분하여 출력
                    + df.format(ar[i].getExtra()) + "\t" // 수당을 3자리마다 쉼표로 구분하여 출력
                    + df.format(ar[i].getTot()) + "\t" // 합계를 3자리마다 쉼표로 구분하여 출력
                    + ar[i].getRate() + "\t" // 세율을 출력
                    + df.format(ar[i].getTax()) + "\t" // 세금을 3자리마다 쉼표로 구분하여 출력
                    + df.format(ar[i].getSalary()) + "\t"); // 월급을 3자리마다 쉼표로 구분하여 출력
        }
    }
}



/*

[문제] 월급 계산 프로그램
1. 세율
합계가 5,000,000원 이상이면 3% (0.03)
     3,000,000원 이상이면 2% (0.02)
     아니면 1% (0.01)
2. 숫자는 3자리마다 , 표시
3. 소수이하는 표시하지 않는다. (정수형)

클래스명 : SalaryDTO
필드 : name, job, basic, extra, total, rate, tax, salary
메소드 : setData(이름, 직급, 기본급, 수당)
       calc() - 합계, 세율, 세금, 월급 계산
   getName()
   getJob()
   getBasic()
   getExtra()
       getTotal()
       getRate()
       getTax()
       getSalary()

클래스명 : SalaryMain

[실행결과]
이름 직급 기본급 수당 합계 세율 세금 월급
------------------------------------------------------------------------
홍길동 이사 4,800,000 300,000
송중기 사원 2,000,000 100,000
아이유 주임 2,900,000 150,000

*/