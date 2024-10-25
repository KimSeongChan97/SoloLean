package sample04;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
	// List<SungJukDTO2> list = new ArrayList<SungJukDTO2>();
	// 이 코드는 성적 데이터를 저장할 ArrayList 객체를 생성하는 방식이지만, Spring을 사용함으로써
	// 의존성 주입(Dependency Injection)을 통해 리스트를 관리하게 되므로 필요가 없습니다.
	
	public void menu(ApplicationContext context) {
		Scanner scan = new Scanner(System.in); // 사용자로부터 입력을 받기 위한 Scanner 객체 생성
		SungJuk sungJuk = null; // SungJuk 인터페이스를 통해 다양한 성적 처리 객체를 참조할 수 있게 함
        int num;
        
        while (true) {
            System.out.println(); // 줄 간격을 위한 빈 줄 출력
            System.out.println("**************");
            System.out.println("	1. 성적 입력"); // 성적 입력을 위한 메뉴 항목
            System.out.println("	2. 성적 출력"); // 성적 출력을 위한 메뉴 항목
            System.out.println("	3. 성적 수정"); // 성적 수정을 위한 메뉴 항목
            System.out.println("	4. 성적 삭제"); // 성적 삭제를 위한 메뉴 항목
            System.out.println("	5. 종료"); // 프로그램 종료를 위한 메뉴 항목
            System.out.println("**************");
            System.out.print("번호 입력: ");
            num = scan.nextInt(); // 사용자가 입력한 메뉴 번호를 저장

            // 종료 조건: 사용자가 5번을 입력하면 프로그램이 종료됨
            if(num == 5) break;

            // 메뉴 선택에 따라 적절한 Bean 객체를 가져와 실행
            if(num == 1) { 
                // 성적 입력: sungJukInput Bean을 가져와 실행
                sungJuk = (SungJuk) context.getBean("sungJukInput"); 
            } else if (num == 2) { 
                // 성적 출력: sungJukOutput Bean을 가져와 실행
                sungJuk = (SungJuk) context.getBean("sungJukOutput");
            } else if (num == 3) { 
                // 성적 수정: sungJukUpdate Bean을 가져와 실행
                sungJuk = (SungJuk) context.getBean("sungJukUpdate");
            } else if (num == 4) { 
                // 성적 삭제: sungJukDelete Bean을 가져와 실행
                sungJuk = (SungJuk) context.getBean("sungJukDelete");
            }
            
            // 선택한 작업을 수행
            sungJuk.execute(); 
            // 해당 성적 입력, 출력, 수정, 삭제 작업을 실행
        } // while
       
	} // menu()
	
    public static void main(String[] args) {
        // Spring 설정 파일(applicationContext.xml)을 로드하여 ApplicationContext 생성
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // Spring 컨테이너에서 helloSpring Bean을 가져옴
        HelloSpring helloSpring = (HelloSpring) context.getBean("helloSpring");
        
        // menu() 호출
        helloSpring.menu(context);
        // 프로그램이 메뉴를 통해 성적 입력, 출력, 수정, 삭제 기능을 수행
        
        System.out.println("프로그램을 종료합니다."); 
        // 프로그램 종료 메시지 출력
    }
}
