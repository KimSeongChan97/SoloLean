package user.main;

import java.util.Scanner; // 사용자 입력을 받기 위해 Scanner 클래스를 import

import user.service.UserInsertService; // 사용자를 등록하는 서비스 import
import user.service.UserSelectService; // 사용자를 출력하는 서비스 import
import user.service.UserUpdateService; // 사용자를 수정하는 서비스 import
import user.service.UserDeleteService; // 사용자를 삭제하는 서비스 import
import user.service.UserSearchService; // 사용자를 검색하는 서비스 import
import user.service.UserService; // 모든 사용자 서비스의 부모 클래스 역할을 하는 UserService 인터페이스 import

public class UserMain {
	
    // 프로그램의 시작점인 main 메소드
    public static void main(String[] args) {
        UserMain userMain = new UserMain(); // UserMain 클래스의 객체 생성
        userMain.menu(); // menu() 메소드 호출, 메뉴를 출력하고 사용자 선택에 따라 동작 수행
        System.out.println("프로그램을 종료합니다."); // 프로그램이 종료된 후 메시지를 출력
    }

    // 메뉴를 출력하고, 사용자 입력을 받아 해당 서비스로 연결하는 메소드
    public void menu() {
        Scanner scan = new Scanner(System.in); // 사용자로부터 입력을 받기 위해 Scanner 객체 생성
        UserService userService = null; // 추후에 서비스 객체를 저장할 변수 선언 (UserService는 부모 타입으로 사용됨)

        int num; // 사용자가 입력한 메뉴 번호를 저장할 변수

        // 무한 루프를 통해 계속해서 메뉴를 출력하고, 사용자의 선택에 따라 동작을 수행
        while (true) {
            System.out.println();
            System.out.println("********MyBatisTest********"); // 간단한 메뉴 인터페이스 출력
            System.out.println("    	1. 등록"); // 1번 메뉴: 사용자 등록
            System.out.println("    	2. 출력"); // 2번 메뉴: 사용자 출력
            System.out.println("    	3. 수정"); // 3번 메뉴: 사용자 정보 수정
            System.out.println("    	4. 삭제"); // 4번 메뉴: 사용자 삭제
            System.out.println("    	5. 검색"); // 5번 메뉴: 사용자 검색
            System.out.println("    	6. 종료"); // 6번 메뉴: 프로그램 종료
            System.out.println("********-----------********");
            System.out.println();
            
            num = scan.nextInt(); // 사용자가 선택한 메뉴 번호를 입력받음

            if (num == 6) break; // 만약 사용자가 6을 선택하면 무한 루프 종료, 프로그램 종료

            // 사용자가 선택한 메뉴 번호에 따라 각기 다른 서비스 객체 생성
            if (num == 1) {
                userService = new UserInsertService(); // 1번을 선택했을 때: 사용자 등록 서비스 호출, 부모 = 자식
            } else if (num == 2) {  	
                userService = new UserSelectService(); // 2번을 선택했을 때: 사용자 출력 서비스 호출             
            } else if (num == 3) {         	
                userService = new UserUpdateService(); // 3번을 선택했을 때: 사용자 정보 수정 서비스 호출             
            } else if (num == 4) {         	
                userService = new UserDeleteService(); // 4번을 선택했을 때: 사용자 삭제 서비스 호출              
            } else if (num == 5) {          	
                userService = new UserSearchService(); // 5번을 선택했을 때: 사용자 검색 서비스 호출             
            }
            
            // 선택한 서비스에 맞는 메소드를 호출
            userService.execute();  // 각 서비스 클래스의 공통적으로 구현된 execute() 메소드를 실행
                                    // 이 부분은 다형성을 활용한 것으로, UserService 타입이지만
                                    // 실제로는 자식 클래스의 메소드가 실행됨 (등록, 출력, 수정, 삭제, 검색 각각 다름)
            
        } // while 문 끝, 사용자가 '6'을 입력하면 무한 루프가 종료되고 메뉴가 더 이상 반복되지 않음
        
        
    }

}
