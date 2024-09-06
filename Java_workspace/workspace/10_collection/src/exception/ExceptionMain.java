package exception; // exception 패키지에 속한 클래스

import java.util.Scanner; // Scanner 클래스를 사용하기 위해 import

public class ExceptionMain { // ExceptionMain 클래스 선언

    public static void main(String[] args) { // 프로그램의 시작점인 main 메서드
        // 프로그램 실행 시 인수로 전달된 값이 있을 경우 첫 번째 인수를 출력
        if (args.length != 0) System.out.println("args[0] = " + args[0]); // args 의 0번째 값, run as-> run configuration 에서 값 추가, error 방지
        System.out.println(); // 빈 줄 출력
        
        try { // try 블록 안에서 예외가 발생할 수 있는 코드를 작성
            // 프로그램 실행 시 인수로 전달된 첫 번째 값을 정수로 변환하여 num1에 저장
            // 전달된 인수가 없거나 숫자가 아닌 경우 NumberFormatException이 발생
            int num1 = Integer.parseInt(args[0]); // num1 에 args 의 0번째 값을 바꿔라 !, String "문자열" 이기 때문에 error, 정수형만 가능., error 메시지 변경 try-catch
            
            // 사용자로부터 숫자를 입력받기 위해 Scanner 객체 생성
            Scanner scan = new Scanner(System.in);
            System.out.print("숫자 입력 : ");
            int num2 = scan.nextInt(); // 입력받은 값을 정수로 변환하여 num2에 저장
            
            // num1을 num2로 나눈 결과를 출력
            // num2가 0일 경우 ArithmeticException이 발생
            System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
            
        } catch (NumberFormatException e) { // try 블록에서 NumberFormatException이 발생했을 때 처리
            System.out.println("error : 숫자 형식으로 넣으세요."); // 예외 메시지 출력
            e.printStackTrace(); // 예외의 전체 스택 트레이스를 출력
            
        } catch (ArithmeticException e) { // try 블록에서 ArithmeticException이 발생했을 때 처리
            System.out.println("0 으로 나눌 수 없습니다."); // 예외 메시지 출력
            e.printStackTrace(); // 예외의 전체 스택 트레이스를 출력
            
        } finally { // 예외 발생 여부와 상관없이 항상 실행되는 블록
            System.out.println("error가 있건 없건 무조건 실행 ! "); // finally 블록 메시지 출력
        }
    }
}
