package user.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import user.service.UserService;

public class HelloSpring {

    public static void main(String[] args) {
        // 스프링의 ApplicationContext를 사용하여 applicationContext.xml 설정 파일을 로드합니다.
        // ClassPathXmlApplicationContext는 classpath에서 지정된 XML 파일을 읽어와 스프링 컨테이너를 초기화합니다.
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        // applicationContext.xml에 정의된 "helloSpring" 빈을 가져와서 HelloSpring 객체로 캐스팅합니다.
        HelloSpring helloSpring = (HelloSpring) context.getBean("helloSpring");

        // 메뉴 메서드를 호출하여 사용자와의 상호작용을 시작합니다.
        helloSpring.menu(context);

        // 프로그램 종료 메시지를 출력합니다.
        System.out.println("프로그램을 종료합니다.");
    }

    public void menu(ApplicationContext context) {
        // 사용자로부터 입력을 받기 위한 Scanner 객체를 생성합니다.
        Scanner scan = new Scanner(System.in);
        int num;
        UserService userService = null;  // 사용자 서비스 인터페이스 변수를 선언합니다. 특정 서비스(입력, 출력, 수정, 삭제)에 따라 다른 구현체가 주입됩니다.

        // 무한 루프를 통해 사용자가 종료를 선택할 때까지 반복 실행합니다.
        while (true) {
            System.out.println();
            System.out.println("**************");
            System.out.println("    1. 회원 정보 입력"); 
            System.out.println("    2. 회원 정보 출력"); 
            System.out.println("    3. 회원 정보 수정"); 
            System.out.println("    4. 회원 정보 삭제"); 
            System.out.println("    5. 종료"); 
            System.out.println("**************");
            System.out.print("    번호 입력: ");
            num = scan.nextInt();  // 사용자가 입력한 메뉴 번호를 변수 num에 저장합니다.

            // 5번(종료)를 선택하면 루프를 빠져나갑니다.
            if (num == 5) break;

            // 사용자 입력에 따라 각 서비스의 빈을 가져와서 userService에 할당합니다.
            // UserInsertService 빈을 가져옵니다.
            if (num == 1) { 
                userService = (UserService) context.getBean("userInsertService"); 
            }
            // UserSelectService 빈을 가져옵니다.
            else if (num == 2) { 
                userService = context.getBean("userSelectService", UserService.class); 
            }
            // UserUpdateService 빈을 가져옵니다.
            else if (num == 3) { 
                userService = (UserService) context.getBean("userUpdateService"); 
            }
            // UserDeleteService 빈을 가져옵니다.
            else if (num == 4) { 
                userService = (UserService) context.getBean("userDeleteService"); 
            }

            // 사용자가 선택한 서비스의 execute() 메서드를 호출하여 해당 작업을 수행합니다.
            userService.execute(); 

        } // while

    } // menu()

}
