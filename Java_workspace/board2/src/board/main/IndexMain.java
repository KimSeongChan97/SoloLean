package board.main;

import java.util.Scanner;

import board.service.Board;
import board.service.BoardListService;
import board.service.BoardViewService;
import board.service.BoardWriteService;

public class IndexMain {
    public static void main(String[] args) {
        // Scanner 객체 생성 (사용자 입력을 받기 위해)
        Scanner scan = new Scanner(System.in);
        Board board = null; // Board 인터페이스 변수 선언

        while (true) { // 무한 루프 시작 (프로그램 종료 시까지 반복)
            System.out.println();
        	// 메뉴 출력
            System.out.println("******************");
            System.out.println("   1. 글쓰기");
            System.out.println("   2. 목록");
            System.out.println("   3. 작성한 글 내용 보기");
            System.out.println("   4. 끝");
            System.out.println("******************");
            System.out.print("  번호 : ");
            int num = scan.nextInt(); // 사용자로부터 번호 입력 받기
            scan.nextLine();

            // 선택한 번호에 따라 다른 서비스 실행
            if (num == 1) { // 글쓰기 서비스
                board = new BoardWriteService();
            } else if (num == 2) { // 목록 보기 서비스
                board = new BoardListService();
            } else if (num == 3) { // 작성한 글 내용 보기 서비스
                board = new BoardViewService();
            } else if (num == 4) { // 프로그램 종료
                System.out.println("프로그램을 종료합니다.");
                System.exit(0); // 프로그램 종료
            } else { // 잘못된 번호
            	System.out.println("잘못된 번호 입니다. 다시 입력하세요");
            	continue;
            }
            
            // 선택한 서비스 실행
            board.execute();
        }
    }
}
