package sample04;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        SungJuk sungJuk;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("**************");
            System.out.println("1. 입력");
            System.out.println("2. 출력");
            System.out.println("3. 수정");
            System.out.println("4. 삭제");
            System.out.println("5. 끝");
            System.out.println("**************");
            System.out.print("번호 입력: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                sungJuk = context.getBean(SungJukInput.class);
                sungJuk.execute();
            } else if (choice == 2) {
                sungJuk = context.getBean(SungJukOutput.class);
                sungJuk.execute();
            } else if (choice == 3) {
                sungJuk = context.getBean(SungJukUpdate.class);
                sungJuk.execute();
            } else if (choice == 4) {
                sungJuk = context.getBean(SungJukDelete.class);
                sungJuk.execute();
            } else if (choice == 5) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
