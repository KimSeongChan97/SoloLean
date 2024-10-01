package sample04;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

    public static void main(String[] args) {
        // Spring 설정 파일(applicationContext.xml)을 로드하여 ApplicationContext 생성
        // 추가 설명: Spring 컨테이너인 ApplicationContext는 Bean을 관리하고 의존성을 주입하는 역할을 합니다.
        // "applicationContext.xml" 파일에 정의된 Bean 설정을 읽고 객체를 생성하여 관리합니다.
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        SungJuk sungJuk; // 인터페이스 타입의 참조변수를 선언하여 다양한 SungJuk 구현체를 참조할 수 있게 함
        Scanner scanner = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성

        // 무한 루프를 사용하여 사용자에게 반복적으로 메뉴를 제공
        while (true) {
            // 메뉴 출력
            System.out.println("**************");
            System.out.println("1. 입력"); // 성적 데이터를 입력하는 메뉴
            System.out.println("2. 출력"); // 입력된 성적 데이터를 출력하는 메뉴
            System.out.println("3. 수정"); // 입력된 성적 데이터를 수정하는 메뉴
            System.out.println("4. 삭제"); // 입력된 성적 데이터를 삭제하는 메뉴
            System.out.println("5. 끝"); // 프로그램을 종료하는 메뉴
            System.out.println("**************");
            System.out.print("번호 입력: "); // 사용자로부터 선택을 입력받음
            int choice = scanner.nextInt(); // 사용자가 선택한 메뉴 번호를 저장

            // 사용자가 선택한 메뉴에 따라 다른 Bean을 실행
            if (choice == 1) {
                // 입력 기능 선택
                sungJuk = context.getBean("sungJukInput", SungJuk.class);
                // 추가 설명: context.getBean() 메서드를 사용하여 applicationContext.xml에 정의된 "sungJukInput" Bean을 가져옴.
                // 이 Bean은 성적 입력을 담당하는 SungJukInput 클래스의 인스턴스임.
                sungJuk.execute(); // 입력된 데이터 처리
            } else if (choice == 2) {
                // 출력 기능 선택
                sungJuk = context.getBean("sungJukOutput", SungJuk.class);
                // 추가 설명: "sungJukOutput" Bean을 가져와 성적 데이터를 출력하는 SungJukOutput 클래스의 인스턴스를 실행.
                sungJuk.execute(); // 저장된 데이터를 출력
            } else if (choice == 3) {
                // 수정 기능 선택
                sungJuk = context.getBean("sungJukUpdate", SungJuk.class);
                // 추가 설명: "sungJukUpdate" Bean을 가져와 성적 데이터를 수정하는 SungJukUpdate 클래스의 인스턴스를 실행.
                sungJuk.execute(); // 데이터 수정 처리
            } else if (choice == 4) {
                // 삭제 기능 선택
                sungJuk = context.getBean("sungJukDelete", SungJuk.class);
                // 추가 설명: "sungJukDelete" Bean을 가져와 성적 데이터를 삭제하는 SungJukDelete 클래스의 인스턴스를 실행.
                sungJuk.execute(); // 데이터 삭제 처리
            } else if (choice == 5) {
                // 프로그램 종료
                System.out.println("프로그램을 종료합니다.");
                break; // 무한 루프를 탈출하여 프로그램 종료
            } else {
                // 잘못된 입력 처리
                System.out.println("잘못된 입력입니다.");
                // 추가 설명: 사용자가 1~5 이외의 번호를 입력했을 때 오류 메시지를 출력하고 다시 메뉴를 보여줌.
            }
        }
    }
}
