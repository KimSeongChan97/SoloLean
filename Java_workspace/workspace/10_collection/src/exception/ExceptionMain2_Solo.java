package exception; // 패키지 선언: 현재 클래스가 속한 패키지를 정의합니다.

import java.io.BufferedReader; // BufferedReader 클래스를 가져옵니다. BufferedReader는 입력을 효율적으로 읽기 위해 사용됩니다.
import java.io.IOException; // IOException 클래스를 가져옵니다. 입출력 예외를 처리하기 위해 사용됩니다.
import java.io.InputStreamReader; // InputStreamReader 클래스를 가져옵니다. InputStreamReader는 바이트 스트림을 문자 스트림으로 변환합니다.

// 클래스 선언: ExceptionMain2_Solo라는 이름의 클래스를 정의합니다.
public class ExceptionMain2_Solo {

    // 인스턴스 변수 선언: x와 y를 선언합니다.
    // x와 y는 사용자가 입력하는 두 정수 값을 저장하는 변수입니다.
    private int x, y;

    // 사용자로부터 x와 y 값을 입력받는 메서드
    // IOException을 throws하여 입출력 예외가 발생할 수 있음을 명시합니다.
    public void input() throws IOException {
        // BufferedReader 객체를 생성하여 사용자 입력을 받을 준비를 합니다.
        // InputStreamReader를 사용하여 바이트 스트림을 문자 스트림으로 변환하고 BufferedReader로 감싸서 효율적으로 읽습니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사용자로부터 x 값을 입력받고, x 변수에 저장합니다.
        System.out.print("x 값 입력: "); // 사용자에게 x 값을 입력하라는 메시지를 출력합니다.
        x = Integer.parseInt(br.readLine()); // 사용자가 입력한 문자열을 정수로 변환하여 x에 저장합니다.

        // 사용자로부터 y 값을 입력받고, y 변수에 저장합니다.
        System.out.print("y 값 입력: "); // 사용자에게 y 값을 입력하라는 메시지를 출력합니다.
        y = Integer.parseInt(br.readLine()); // 사용자가 입력한 문자열을 정수로 변환하여 y에 저장합니다.
    }

    // x의 y승을 계산하고 결과를 출력하는 메서드
    public void output() {
        // 초기값을 1로 설정한 mul 변수를 선언합니다.
        // mul은 x의 y승을 계산하기 위해 사용됩니다.
        int mul = 1;

        if (y >= 0) { // y가 0보다 크거나 같은지 확인하는 조건문입니다.
            // y 횟수만큼 반복하면서 mul 변수에 x 값을 곱합니다.
            // for 루프는 1부터 y까지 반복합니다.
            for (int i = 1; i <= y; i++) { // i는 1부터 시작하여 y까지 증가합니다.
                mul *= x; // mul = mul * x; 각 반복마다 mul에 x를 곱합니다.
            } // for 루프 끝

            // 계산 결과를 출력합니다.
            // System.out.println()은 출력 후 줄 바꿈을 합니다.
            System.out.println(x + "의 " + y + "승은 " + mul);

        } else { // y가 0보다 작은 경우 예외를 발생시킵니다.
            try {
                // 강제로 MakeException을 발생시킵니다.
                throw new MakeException("y는 0보다 크거나 같아야 합니다.");
            } catch (Exception e) { // 예외가 발생하면 catch 블록이 실행됩니다.
                // 예외가 발생하면 예외의 스택 트레이스를 출력합니다.
                e.printStackTrace(); // 예외의 스택 트레이스를 출력합니다.
            }
        }
    }

    // main 메서드: 프로그램의 시작점입니다.
    // Java 프로그램이 실행되면 가장 먼저 main 메서드가 호출됩니다.
    public static void main(String[] args) throws IOException { // IOException을 throws하여 입출력 예외가 발생할 수 있음을 명시합니다.
        // ExceptionMain2_Solo 객체를 생성합니다.
        // 'em'은 ExceptionMain2_Solo 클래스의 인스턴스입니다.
        ExceptionMain2_Solo em = new ExceptionMain2_Solo();

        // input 메서드를 호출하여 사용자로부터 x와 y 값을 입력받습니다.
        // em 객체를 통해 input 메서드를 호출합니다.
        em.input();

        // output 메서드를 호출하여 x의 y승 결과를 출력합니다.
        // em 객체를 통해 output 메서드를 호출합니다.
        em.output();
    }
}

/*
// 사용자 정의 예외 클래스 MakeException을 정의합니다.
class MakeException extends Exception {
    // 생성자에서 예외 메시지를 받습니다.
    public MakeException(String message) {
        super(message); // 부모 클래스(Exception)의 생성자를 호출하여 예외 메시지를 설정합니다.
    }
}

*/




/*

 input() 사용
 x 값 입력 : 2
 y 값 입력 : 5
 --------------------------
 output() 사용
 2의 5승은 xx

 */
