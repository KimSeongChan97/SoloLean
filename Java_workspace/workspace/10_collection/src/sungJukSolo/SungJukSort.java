package sungJukSolo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SungJukSort implements SungJuk {
    // 성적 정렬 기능을 제공하는 클래스

    @Override
    public void execute(ArrayList<SungJukDTO> list) {
        // Scanner 객체를 생성하여 사용자 입력을 받기 위해 준비
        Scanner scanner = new Scanner(System.in);

        // 무한 루프를 통해 사용자에게 반복적으로 메뉴를 제공
        while (true) {
            // 메뉴를 출력하여 사용자에게 선택지를 제공
            System.out.println("\n********************");
            System.out.println("  1. 총점으로 내림차순");
            System.out.println("  2. 이름으로 오름차순");
            System.out.println("  3. 이전 메뉴");
            System.out.println("********************");
            System.out.print("번호: ");
            int choice = scanner.nextInt();  // 사용자의 선택을 입력 받음

            // 사용자의 선택에 따라 분기 처리
            switch (choice) {
                case 1:
                    // 총점으로 내림차순 정렬
                    Collections.sort(list, new Comparator<SungJukDTO>() {
                        @Override
                        public int compare(SungJukDTO o1, SungJukDTO o2) {
                            // 총점 기준으로 내림차순 정렬
                            // o2.getTot() - o1.getTot()는 총점을 비교하여 내림차순 정렬함
                            return o2.getTot() - o1.getTot(); // 결과가 양수이면 o2가 앞으로 오게 됨.
                        }
                    });
                    // 정렬 완료 메시지 출력
                    System.out.println("총점으로 내림차순 정렬되었습니다.");
                    break;

                case 2:
                    // 이름으로 오름차순 정렬
                    Collections.sort(list, new Comparator<SungJukDTO>() {
                        @Override
                        public int compare(SungJukDTO o1, SungJukDTO o2) {
                            // 이름 기준으로 오름차순 정렬
                            // o1.getName().compareTo(o2.getName())는 이름을 비교하여 오름차순 정렬함
                            return o1.getName().compareTo(o2.getName()); // 사전순으로 비교, 오름차순하여 이름이 앞서는 객체
                            // 결과가 음수이면 o1이 o2보다 앞으로 오게 됨.
                            /*
                             오름차순 (Ascending Order): 작은 값이 앞에 오도록 정렬합니다.
							예시: 1, 2, 3, 4
							비교 연산: o1 - o2 또는 o1.compareTo(o2)
							내림차순 (Descending Order): 큰 값이 앞에 오도록 정렬합니다.
							예시: 4, 3, 2, 1
							비교 연산: o2 - o1 또는 o2.compareTo(o1) 
                             */
                        }
                    });
                    // 정렬 완료 메시지 출력
                    System.out.println("이름으로 오름차순 정렬되었습니다.");
                    break;

                case 3:
                    // 이전 메뉴로 돌아감 (while 루프를 종료)
                    return;

                default:
                    // 잘못된 입력에 대한 안내 메시지 출력
                    System.out.println("1~3 중에 선택하세요.");
            }
        }
    }
}

