package sungJukSolo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * SungJukService 클래스는 성적 처리 서비스를 제공하는 클래스입니다.
 * 성적 정보를 저장하고, 사용자로부터 입력을 받아 처리하는 기능을 포함합니다.
 */
public class SungJukService {
    // 성적 정보를 저장하는 리스트
    private ArrayList<SungJukDTO> list = new ArrayList<SungJukDTO>();  
    
    // 사용자 입력을 받기 위한 스캐너 객체
    private Scanner scanner = new Scanner(System.in);  

    /**
     * menu 메서드는 메뉴를 출력하고 사용자의 선택을 처리하는 기능을 수행합니다.
     * 사용자가 선택한 기능에 따라 적절한 처리를 수행합니다.
     */
    public void menu() {
        // 성적 처리 기능을 제공하는 SungJuk 객체를 선언
        SungJuk sungJuk = null;
        
        // 무한 루프를 통해 메뉴를 반복 출력
        while (true) {
            // 메뉴를 출력
            System.out.println("\n********************");
            System.out.println("  1. 입력");
            System.out.println("  2. 출력");
            System.out.println("  3. 수정");
            System.out.println("  4. 삭제");
            System.out.println("  5. 정렬");
            System.out.println("  6. 끝");
            System.out.println("********************");
            System.out.print("번호: ");
            
            // 사용자의 선택을 입력받음
            int choice = scanner.nextInt();
            
            // 사용자의 선택에 따라 SungJuk 인터페이스를 구현한 적절한 클래스의 객체를 생성
            switch (choice) {
                case 1: sungJuk = new SungJukInsert(); break;
                case 2: sungJuk = new SungJukPrint(); break;
                case 3: sungJuk = new SungJukUpdate(); break;
                case 4: sungJuk = new SungJukDelete(); break;
                case 5: sungJuk = new SungJukSort(); break;
                case 6: 
                    // 프로그램 종료 메시지를 출력하고 메서드를 종료
                    System.out.println("프로그램을 종료합니다."); 
                    return;
                default: 
                    // 유효하지 않은 선택에 대한 경고 메시지를 출력
                    System.out.println("1~6 중에 선택하세요.");
            }
            
            // 선택된 기능을 실행
            if (sungJuk != null) {
                sungJuk.execute(list);  
            }
        }
    }
}
