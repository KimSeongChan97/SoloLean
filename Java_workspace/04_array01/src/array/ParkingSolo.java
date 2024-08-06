package array;

import java.util.Scanner;

public class ParkingSolo {

    public static void main(String[] args) {
    	boolean[] ar = new boolean[5]; // 주차 공간 배열 (true: 주차 중, false: 주차 가능)
        Scanner scan = new Scanner(System.in);

        while (true) {
            // 시작화면 출력
            System.out.println("주차장 관리 프로그램");
            System.out.println("**************");
            System.out.println(" 1. 입차");
            System.out.println(" 2. 출차");
            System.out.println(" 3. 리스트");
            System.out.println(" 4. 종료");
            System.out.println("**************");
            System.out.print("  메뉴 :  ");
            int menu = scan.nextInt(); // 사용자 입력으로 메뉴 선택

            // 입차 기능
            if (menu == 1) {
                System.out.print(" 위치 입력 (1~5) : ");
                int spot = scan.nextInt();
                if (spot >= 1 && spot <= ar.length) {
                    if (ar[spot - 1]) {
                        System.out.println(spot + "위치에 이미 주차되어 있습니다.");
                    } else {
                    	ar[spot - 1] = true;
                        System.out.println(spot + "위치에 입차");
                    }
                } else {
                    System.out.println("유효하지 않은 위치입니다.");
                }
            }

            // 출차 기능
            else if (menu == 2) {
                System.out.print(" 위치 입력 (1~5) : ");
                int spot = scan.nextInt();
                if (spot >= 1 && spot <= ar.length) {
                    if (ar[spot - 1]) {
                    	ar[spot - 1] = false;
                        System.out.println(spot + "위치에 출차");
                    } else {
                        System.out.println(spot + "위치에 주차되어 있지 않습니다.");
                    }
                } else {
                    System.out.println("유효하지 않은 위치입니다.");
                }
            }

            // 리스트 기능
            else if (menu == 3) {
                for (int i = 0; i < ar.length; i++) {
                    System.out.println((i + 1) + "위치 : " + ar[i]);
                }
            }

            // 종료 기능
            else if (menu == 4) {
                System.out.println("프로그램을 종료합니다.");
                break; // while 루프 종료
            } else {
                System.out.println("유효하지 않은 메뉴 번호입니다.");
            }
            System.out.println();
        }

        scan.close();
    }

}



/*

[문제] 주차장 관리 프로그램



[실행결과]
주차장 관리 프로그램
**************
   1. 입차
   2. 출차
   3. 리스트
   4. 종료
**************
  메뉴 : 

[1번인 경우]
위치 입력 : 3
3위치에 입차 / 이미 주차되어있습니다

[2번인 경우]
위치 입력 : 4
4위치에 출차 / 주차되어 있지않습니다

[3번인 경우]
1위치 : true
2위치 : false
3위치 : true
4위치 : false
5위치 : false

[4번인 경우]
프로그램을 종료합니다.

*/