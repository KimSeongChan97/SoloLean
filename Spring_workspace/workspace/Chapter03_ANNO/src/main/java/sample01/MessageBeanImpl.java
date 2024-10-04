package sample01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// 타겟 클래스
// 이 클래스는 스프링의 Component로 등록되며, MessageBean 인터페이스를 구현하여 AOP에서 공통 관심사를 적용할 수 있는 타겟 클래스 역할을 합니다.
@Component
public class MessageBeanImpl implements MessageBean {

    private String str;

    // @Autowired: 스프링이 자동으로 의존성 주입을 해주는 어노테이션입니다.
    // @Value: 기본값을 설정하는 어노테이션으로, "Have a nice day!!"라는 값을 str 변수에 주입합니다.
    @Autowired
    public void setStr(@Value("Have a nice day!!") String str) {
        this.str = str; // str 필드에 외부에서 주입된 값을 설정합니다.
    }

    @Override
    public void showPrintBefore() {
        // 공통 관심사가 적용되기 전에 실행되는 메서드
        System.out.println("showPrintBefore 메세지 = " + str); // str 값 출력
    }

    @Override
    public void viewPrintBefore() {
        try {
            // 1초 동안 스레드를 정지시킴
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("viewPrintBefore 메세지 = " + str); // str 값 출력
    }

    @Override
    public void showPrintAfter() {
        // 공통 관심사가 적용된 후에 실행되는 메서드
        System.out.println("showPrintAfter 메세지 = " + str); // str 값 출력
    }

    @Override
    public void viewPrintAfter() {
        try {
            // 1초 동안 스레드를 정지시킴
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("viewPrintAfter 메세지 = " + str); // str 값 출력
    }

    @Override
    public String showPrint() {
        // 메서드 실행 후에 반환값을 가짐 (Around Advice로 사용될 가능성 있음)
        System.out.println("showPrint 메세지 = " + str); // str 값 출력
        return "스프링"; // 메서드의 반환값
    }

    @Override
    public void viewPrint() {
        try {
            // 1초 동안 스레드를 정지시킴
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("viewPrint 메세지 = " + str); // str 값 출력
    }

    @Override
    public void display() {
        // 핵심 비즈니스 로직을 수행하는 메서드
        System.out.println("display 메세지 = " + str); // str 값 출력
    }
}
