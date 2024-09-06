package homework;

import java.io.IOException;
import java.util.Scanner;

public class GameTestAnswer {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int com, user;
		int money = 1000;
		int coin; // 베팅금액
		
		com = (int)(Math.random()*3+1);
		System.out.println("com = " + com); 
		
		System.out.print("가위(1), 바위(2), 보자기(3) 입력 : ");
		user = System.in.read() - '0';
		
		System.out.print("베팅 금액 :");
		coin = scan.nextInt();
		System.out.println();
		
		System.out.println("결과를 보시려면 Enter를 치세요");
		System.in.read();
		
		
		if(com == 1) { // com이 가위라면
			if(user == 1) {
				System.out.println("컴퓨터 : 가위, 나 : 가위 ");
				System.out.println("비겼다");
			}
			else if(user == 2) {
				System.out.println("컴퓨터 : 가위, 나 : 바위 ");
				System.out.println("이겼다");
				
				money += coin;//money = money + coin
			}
			else if(user == 3) {
				System.out.println("컴퓨터 : 가위, 나 : 보자기 ");
				System.out.println("졌다");
				
				money -= coin;
			}
		} else if(com == 2) { // com이 바위라면
			if(user == 1) {
				System.out.println("컴퓨터 : 바위, 나 : 가위 ");
				System.out.println("졌다");
				money -= coin;
			}
			else if(user == 2) {
				System.out.println("컴퓨터 : 바위, 나 : 바위 ");
				System.out.println("비겼다");
			}
			else if(user == 3) {
				System.out.println("컴퓨터 : 바위, 나 : 보자기 ");
				System.out.println("이겼다");
				money += coin;
			}
		} else if(com == 3) { // com이 보자기라면
			if(user == 1) {
				System.out.println("컴퓨터 : 보자기, 나 : 가위 ");
				System.out.println("이겼다");
				money += coin;
			}
			else if(user == 2) {
				System.out.println("컴퓨터 : 보자기, 나 : 바위 ");
				System.out.println("졌다");
				money -= coin;
			}
			else if(user == 3) {
				System.out.println("컴퓨터 : 보자기, 나 : 보자기 ");
				System.out.println("비겼다");
			}
		}
		System.out.println();
		System.out.println(money);
		
		scan.close();
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
