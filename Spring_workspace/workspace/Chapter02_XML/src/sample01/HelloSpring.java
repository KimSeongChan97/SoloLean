package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

    public static void main(String[] args) {
        // Spring의 ApplicationContext는 스프링 프레임워크에서 제공하는 IoC 컨테이너 역할을 합니다.
        // 'applicationContext.xml' 파일에서 설정된 Bean 정의를 로드하여 애플리케이션에서 사용할 수 있도록 관리합니다.
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        /* context.getBean("스프링 설정파일에서 만든 bean의 id 값을 가져온다"); */
        // context.getBean 메서드를 사용하여 스프링 설정 파일에서 정의된 Bean을 가져옵니다.
        // 여기서는 "messageBeanImpl"이라는 id를 가진 Bean을 가져오며, 이 Bean은 MessageBean 타입의 객체로 반환됩니다.
        MessageBean messageBean = context.getBean("messageBeanImpl", MessageBean.class);

        // 설정 파일(applicationContext.xml)에 정의된 값을 사용하여 sayHello 메서드를 호출합니다.
        // 설정된 값인 '사과', cost 5000, qty 3이 출력될 것입니다.
        messageBean.sayHello();

        // 새로운 값("딸기"와 10000)을 전달하여 sayHello 메서드를 호출합니다.
        // 이 경우, 설정된 qty 값은 유지되며, 전달된 '딸기'와 10000이 출력됩니다.
        messageBean.sayHello("딸기", 10000);

        // 값이 없으면 스프링 설정 파일에 설정한 값을 가져온다.
        // 이 메서드는 세 개의 값을 모두 전달받으며, 설정 파일의 값을 무시하고 입력한 값인 '참외', 3500, 10이 출력됩니다.
        messageBean.sayHello("참외", 3500, 10);

        // 값을 모두 입력하면 설정 파일에 잡은 값을 무시하고 입력한 값이 결과로 나온다.
    }
}
