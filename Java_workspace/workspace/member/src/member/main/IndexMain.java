package member.main;

import java.util.Scanner; // 사용자 입력을 받기 위해 Scanner 클래스를 가져옴

import member.service.DeleteService;
import member.service.LoginService; // 로그인 서비스 클래스를 사용하기 위해 import
import member.service.Member; // Member 인터페이스를 사용하기 위해 import
import member.service.UpdateService;
import member.service.WriteService; // 회원가입 서비스 클래스를 사용하기 위해 import

public class IndexMain {

    // 메뉴를 출력하고 사용자 입력을 받아 해당 서비스를 실행하는 메서드
    public void menu() {
        Scanner scan = new Scanner(System.in); // Scanner 객체를 생성하여 사용자 입력을 받음
        Member member = null; // Member 인터페이스 타입의 변수를 선언, 초기값은 null
        int num; // 사용자로부터 입력받은 메뉴 번호를 저장할 변수
        
        // 무한 루프를 사용하여 사용자가 종료를 선택할 때까지 반복
        while (true) {
            // 메뉴 출력
            System.out.println();
            System.out.println("******************");
            System.out.println("   1. 회원가입");
            System.out.println("   2. 로그인");
            System.out.println("   3. 회원정보수정");
            System.out.println("   4. 회원탈퇴");
            System.out.println("   5. 끝");
            System.out.println("******************");
            System.out.print("  번호 : ");
            
            // 사용자가 입력한 번호를 읽음
            num = scan.nextInt();
            // 사용자가 5번을 입력하면 while 루프 종료
            if (num == 5) break;
            // 사용자가 1번을 입력하면 회원가입 서비스를 실행하도록 설정
            if (num == 1) member = new WriteService();
            // 사용자가 2번을 입력하면 로그인 서비스를 실행하도록 설정
            if (num == 2) member = new LoginService();
            // 사용자가 3번을 입력하면 업데이트 서비스를 실행하도록 설정
            if (num == 3) member = new UpdateService();
            // 사용자가 4번을 입력하면 삭제 서비스를 실행하도록 설정
            if (num == 4 ) member = new DeleteService();
            // 선택된 서비스의 execute 메서드를 호출하여 해당 서비스를 실행
            member.execute();
            
        } // while
        
    } // menu()

    // 프로그램의 진입점, main 메서드
    public static void main(String[] args) {
        IndexMain indexMain = new IndexMain(); // IndexMain 클래스의 인스턴스를 생성
        indexMain.menu(); // menu 메서드를 호출하여 프로그램 실행
        System.out.println("프로그램을 종료합니다."); // 프로그램 종료 메시지 출력
    } // main()
    
} // IndexMain 클래스

/*
Java Project : member

Package        : member.main
Class            : IndexMain.java - main()

Package        : member.service
Interface        : Member.java
                        public void execute();
Class            : WriteService.java
                       LoginService.java

Package        : member.bean
Class            :  MemberDTO.java

Package        : member.dao
Class            :  MemberDAO.java   (Data  Access  Object)

Folder : lib
File : ojdbc11.jar
       lombok.jar
          
Folder : sql
File   : member.sql                      
                      
데이터 : 이름(name), 아이디(id), 비밀번호(pwd), 핸드폰(phone)

테이블 : member
컬럼  : 이름, 15자리
컬럼  : 아이디, 30자리
컬럼  : 비밀번호, 50자리
컬럼  : 핸드폰, 20자리                     
*/
