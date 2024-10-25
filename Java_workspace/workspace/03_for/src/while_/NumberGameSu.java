package while_;

import java.util.Scanner;

public class NumberGameSu {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int randomNumber = (int) (Math.random() * 100) + 1; // 1부터 100 사이의 난수 생성
        int attempts = 0;
        
        System.out.println("1~100 사이의 숫자가 발생했습니다.");
        
        while (true) {
            System.out.print("숫자 입력: ");
            int guess = scanner.nextInt();
            attempts++;
            
            if (guess > randomNumber)
                System.out.println(guess + "보다 작은 숫자입니다.");
            else if (guess < randomNumber)
                System.out.println(guess + "보다 큰 숫자입니다.");
            else {
                System.out.println("딩동뎅... " + attempts + "번만에 맞추셨습니다.");
                break;
            }
        }
        
        scanner.close();
    }
}


/*
 [문제] 숫자 맞추기 게임
 - 숫자의 범위는 1~100 사이로 한다.
 - 컴퓨터가 숫자를 발생하면 사용자가 맞추는 프로그램이다.
 
  
 [실행결과]
 1~100 사이의 숫자가 발생했습니다. (87)
 
 숫자 입력 : 50
 50보다 큰 숫자입니다.
 
 
  숫자 입력 : 95
 97보다 작은 숫자입니다.
 
 ...(반복)
 
 숫자입력 : 87
 딩동뎅... n번만에 맞추셨습니다.
 
 */
