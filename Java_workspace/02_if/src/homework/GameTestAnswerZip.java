
package homework;

import java.util.Scanner;

public class GameTestAnswerZip {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int com, user, money = 1000, coin; // 변수 선언과 초기화를 한 줄에 처리

        com = (int) (Math.random() * 3 + 1); // 컴퓨터의 선택
        System.out.println("com = " + com);

        System.out.print("가위(1), 바위(2), 보자기(3) 입력 : ");
        user = scan.nextInt(); // 사용자의 선택 입력 받기

        System.out.print("베팅 금액 : ");
        coin = scan.nextInt();
        System.out.println();

        System.out.println("결과를 보시려면 Enter를 치세요");
        scan.nextLine(); // 엔터 입력 대기
        scan.nextLine(); // 엔터 입력 대기 (실제 입력 받기 위해 두 번 사용)

        // 컴퓨터와 사용자의 선택에 따라 결과 출력
        if (com == user) {
            System.out.println("비겼다");
        } else if ((com == 1 && user == 2) || (com == 2 && user == 3) || (com == 3 && user == 1)) {
            System.out.println("이겼다");
            money += coin;
        } else {
            System.out.println("졌다");
            money -= coin;
        }

        // 최종 금액 출력
        System.out.println("현재 금액은 " + money + "원");

        scan.close(); // 스캐너 닫기
    }
}
