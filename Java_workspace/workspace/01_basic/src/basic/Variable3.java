package basic;

import java.util.Random;

public class Variable3 {

    public static void main(String[] args) {
        // Math.max()를 사용하여 두 수 중 큰 값을 구합니다.
        int big = Math.max(25, 360);
        System.out.println("큰값 = " + big);
        
        // Math.min()를 사용하여 두 수 중 작은 값을 구합니다.
        double small = Math.min(12.7, 78.5);
        System.out.println("작은 값 = " + small);
        
        // Math.pow()를 사용하여 지수 연산을 수행합니다.
        double power = Math.pow(2.0, 5);
        System.out.println("2의 5승 = " + power);
        
        // Math.random()을 사용하여 0 이상 1 미만의 난수를 발생시킵니다.
        double a = Math.random();
        
        // Random 클래스를 사용하여 난수를 발생시킵니다.
        double b = new Random().nextDouble();
        
        // a * 100을 통해 0 이상 100 미만의 수를 얻고, int로 형변환하여 정수형 c에 저장합니다.
        int c = (int)(a * 100);
        
        // (int)(Math.random() * (y - x + 1) + x)를 사용하여 x 이상 y 이하의 난수를 발생시킵니다.
        int d = (int)(Math.random() * (26) + 65); // 65~90 사이의 난수를 발생시킵니다.
        
        // (char)(Math.random() * 26 + 65)를 사용하여 ASCII 코드로 변환한 랜덤 대문자를 발생시킵니다.
        char e = (char)(Math.random() * 26 + 65);
        
        // 결과 출력
        System.out.println(a); // 0 이상 1 미만의 난수 출력
        System.out.println(b); // 0 이상 1 미만의 난수 출력
        System.out.println(c); // 0 이상 99 이하의 정수 출력
        System.out.println(d); // 65 이상 90 이하의 정수 출력
        System.out.println(e); // 'A' 이상 'Z' 이하의 랜덤 대문자 출력
        System.out.println();
    }

}
