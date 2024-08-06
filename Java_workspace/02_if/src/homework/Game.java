package homework;

import java.io.IOException;

public class Game {

	public static void main(String[] args) throws IOException {
		int defaultAmount = 1000; // 기본 금액 설정
		int currentAmount = defaultAmount; // 현재 금액 변수
		
		System.out.println("가위(1), 바위(2), 보자기(3) 입력 : ");
		int userChoice = System.in.read() - '0'; // 사용자 입력 받기(ASCII코드 변환)
		
		System.out.println("배팅 금액 : ");
		int betAmount = System.in.read() - '0';
		System.in.read();
		
		int computerChoice = (int)(Math.random() * 3) + 1;
		
		String userChoiceStr = getHandType(userChoice);
        String computerChoiceStr = getHandType(computerChoice);
        
        System.out.println("\n컴퓨터 " + computerChoiceStr + ", 나는 " + userChoiceStr);
        
        if ((userChoice == 1 && computerChoice == 3) ||
                (userChoice == 2 && computerChoice == 1) ||
                (userChoice == 3 && computerChoice == 2)) {
        	System.out.println("이겼다");
            currentAmount += betAmount;
        } else if (userChoice == computerChoice) {
        	System.out.println("비겼다");
        } else {
        	System.out.println("졌다");
            currentAmount -= betAmount;
        }
        System.out.println("현재 금액은 " + currentAmount + "원");
    }

    // 숫자에 따른 가위 바위 보 문자열 반환 메서드
    public static String getHandType(int hand) {
        switch (hand) {
            case 1:
                return "가위";
            case 2:
                return "바위";
            case 3:
                return "보자기";
            default:
                return "";
        }
    }
}


/*
[문제] 가위 바위 보 게임
- 가위(1), 바위(2), 보자기(3)으로 설정한다.
- 컴퓨터는 난수 1 ~ 3 사이의 숫자를 발생한다.
- 기본 금액은 1000원을 기본으로 설정한다.
- 이기면 "이겼다", 비기면 "비겼다", 지면 "졌다"를 출력한다.
- 실행결과의 가위,바위,보자기를 입력하는 것은 System.in.read() 사용하여 입력 받는다.


[실행결과]
가위(1), 바위(2), 보자기(3) 입력 : 1  
배팅 금액 : 600

결과를 보시려면 Enter를 치세요

컴퓨터 바위, 나는 가위
졌다
현재 금액은 400윈

*/