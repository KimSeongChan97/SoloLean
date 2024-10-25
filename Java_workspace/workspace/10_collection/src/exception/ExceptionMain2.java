package exception;

import java.util.Scanner;

public class ExceptionMain2 {

    // 인스턴스 변수 선언: x와 y를 선언합니다.
    // x와 y는 사용자가 입력하는 두 정수 값을 저장하는 변수입니다.
    private int x, y;

    // 사용자로부터 x와 y 값을 입력받는 메서드
    public void input() {
        // Scanner 객체를 생성하여 사용자 입력을 받을 준비를 합니다.
        // Scanner는 Java의 표준 입력 장치(키보드)로부터 데이터를 읽기 위해 사용됩니다.
        Scanner scan = new Scanner(System.in);

        // 사용자로부터 x 값을 입력받고, x 변수에 저장합니다.
        // System.out.print()는 출력 후 줄 바꿈을 하지 않습니다.
        System.out.print("x 값 입력: ");
        x = scan.nextInt(); // 사용자가 입력한 정수 값을 x에 저장합니다.

        // 사용자로부터 y 값을 입력받고, y 변수에 저장합니다.
        System.out.print("y 값 입력: ");
        y = scan.nextInt(); // 사용자가 입력한 정수 값을 y에 저장합니다.
    }

    // x의 y승을 계산하고 결과를 출력하는 메서드
    public void output() {
        // Math.pow() 메서드를 사용하여 x의 y승을 계산합니다.
        // Math.pow(double a, double b)는 a의 b승을 계산하여 double 타입으로 반환합니다.
        double result = Math.pow(x, y);

        // 계산 결과를 출력합니다.
        // System.out.println()은 출력 후 줄 바꿈을 합니다.
        System.out.println(x + "의 " + y + "승은 " + result);
    }

    // main 메서드: 프로그램의 시작점입니다.
    // Java 프로그램이 실행되면 가장 먼저 main 메서드가 호출됩니다.
    public static void main(String[] args) {
        // ExceptionMain2 객체를 생성합니다.
        // 'square'는 ExceptionMain2 클래스의 인스턴스입니다.
        ExceptionMain2 square = new ExceptionMain2();

        // input 메서드를 호출하여 사용자로부터 x와 y 값을 입력받습니다.
        // square 객체를 통해 input 메서드를 호출합니다.
        square.input();

        // output 메서드를 호출하여 x의 y승 결과를 출력합니다.
        // square 객체를 통해 output 메서드를 호출합니다.
        square.output();
    }
}



/*
 
 input() 사용
 x 값 입력 : 2
 y 값 입력 : 5
 --------------------------
 output() 사용
 2의 5승은 xx
  
 */
