package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

    public static void main(String[] args) {
        // ApplicationContext는 스프링의 IoC 컨테이너를 의미하며, Bean의 생성과 관리를 담당합니다.
        // ClassPathXmlApplicationContext는 지정된 XML 파일을 로드하여 컨텍스트(스프링 빈 설정 파일)를 생성합니다.
        // 여기서는 'acQuickStart.xml' 파일을 로드하여 스프링 컨텍스트를 초기화합니다.
        ApplicationContext context = new ClassPathXmlApplicationContext("acQuickStart.xml");
        
        // context.getBean()을 사용하여 'messageBeanImpl'이라는 ID를 가진 Bean을 가져옵니다.
        // 이때 반환된 Bean은 MessageBean 인터페이스 타입으로 캐스팅됩니다.
        MessageBean messageBean = (MessageBean) context.getBean("messageBeanImpl");
        
//        
//        // *** Before *** 구역에서는 AOP의 Before Advice가 적용된 메서드들을 실행합니다.
//        System.out.println("*** Before ***");
//        // showPrintBefore 메서드를 실행합니다. AOP Before Advice가 적용되어 메서드 실행 전에 공통 관심 사항이 실행됩니다.
//        messageBean.showPrintBefore();
//        System.out.println(); // 줄바꿈을 위한 출력
//        
//        // viewPrintBefore 메서드를 실행합니다. 이 메서드도 Before Advice가 적용되어 있으며,
//        // 실행 전 공통 관심 사항이 적용됩니다. 메서드 안에서는 1초 대기 후 메시지를 출력합니다.
//        messageBean.viewPrintBefore();
//        System.out.println();
//        
//        // display 메서드를 실행합니다. 이 메서드는 AOP와 관련 없이 단순한 비즈니스 로직을 수행합니다.
//        messageBean.display();
//        System.out.println();
//
//        // *** After *** 구역에서는 AOP의 After Advice가 적용된 메서드들을 실행합니다.
//        System.out.println("*** After ***");
//        // showPrintAfter 메서드를 실행합니다. After Advice가 적용되어 메서드 실행 후에 공통 관심 사항이 실행됩니다.
//        messageBean.showPrintAfter();
//        System.out.println(); // 줄바꿈을 위한 출력
//        
//        // viewPrintAfter 메서드를 실행합니다. 이 메서드도 After Advice가 적용되어 있으며,
//        // 실행 후 공통 관심 사항이 적용됩니다. 메서드 안에서는 1초 대기 후 메시지를 출력합니다.
//        messageBean.viewPrintAfter();
//        System.out.println();
//        // display 메서드를 다시 한 번 실행합니다. 이 메서드는 AOP와 관련 없이 비즈니스 로직을 수행합니다.
//        messageBean.display();
//        System.out.println();
//        
        
        
        System.out.println("*** Around ***");
        messageBean.showPrint();
        System.out.println(); 
        messageBean.viewPrint();
        System.out.println();
        messageBean.display();
        System.out.println();
        
        
    }

}
