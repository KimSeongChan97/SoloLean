package basic;

import java.util.Scanner;

public class Input {

    public static void main(String[] args) {
        // Scanner 클래스를 사용하여 키보드 입력을 받을 준비를 합니다.
        Scanner scan = new Scanner(System.in);
        
        // 정수형 데이터를 입력받습니다.
        System.out.print("정수형 데이터 입력 : ");
        int a = scan.nextInt();
        
        // 실수형 데이터를 입력받습니다.
        System.out.print("실수형 데이터 입력 : ");
        double b = scan.nextDouble();
        
        // 입력받은 정수형 데이터와 실수형 데이터를 더한 결과를 출력합니다.
        System.out.println(a + " + " + b + " = " + (a + b));
    }
}
