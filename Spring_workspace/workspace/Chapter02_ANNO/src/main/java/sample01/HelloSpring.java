package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

    public static void main(String[] args) {
        // Spring의 ApplicationContext는 스프링 컨테이너 역할을 하며, 
        // 'applicationContext.xml' 설정 파일을 읽어 Bean을 관리합니다.
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        /* context.getBean("스프링 설정파일에서 만든 bean의 id 값을 가져온다"); */
        // 스프링 설정 파일에서 정의한 "messageBeanImpl"이라는 id의 Bean을 가져옵니다.
        // 이때 MessageBean 타입으로 변환하여 사용합니다.
        MessageBean messageBean = context.getBean("messageBeanImpl", MessageBean.class);
        
        // 생성자의 자동 호출로 인해 String 사과 값을 가져온다
        // 여기서 'messageBean.sayHello()' 메서드를 호출하면,
        // XML 설정 파일(applicationContext.xml)에서 설정한 '사과', 5000, 3이 출력됩니다.
        // '사과' 값은 생성자에서 주입되고, 'cost'와 'qty'는 @Autowired와 @Value로 주입됩니다.
        messageBean.sayHello();
        
        // 하지만 Setter 를 호출 안하기에 Autowired 를 통해 가져온다.
        // 여기서는 '딸기'와 10000이라는 새로운 값을 주입하여 sayHello() 메서드를 호출합니다.
        // '딸기'와 10000은 메서드 호출 시 전달된 값이며, qty는 설정 파일에서 주입된 값인 3이 그대로 유지됩니다.
        messageBean.sayHello("딸기", 10000);
        
        // 값이 없으면 스프링 설정 파일에 설정한 값을 가져온다.
        // 이 메서드에서는 '참외', 3500, 10이라는 값이 모두 전달됩니다.
        // 이때 설정된 기본 값들을 무시하고, 메서드 호출 시 전달한 값들이 출력됩니다.
        messageBean.sayHello("참외", 3500, 10);
        
        // 값을 모두 입력하면 설정 파일에 잡은 값을 무시하고 입력한 값이 결과로 나온다.
        // 즉, 입력된 값이 우선적으로 사용됩니다.
    }

}
