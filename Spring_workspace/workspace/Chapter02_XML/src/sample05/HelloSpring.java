package sample05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

    public static void main(String[] args) {
        // ApplicationContext는 Spring 프레임워크에서 가장 핵심적인 인터페이스로, 
        // 스프링이 관리하는 객체들(Bean)을 생성하고 관리하는 역할을 합니다.
        // 여기서는 ClassPathXmlApplicationContext를 사용하여 XML 설정 파일(applicationContext.xml)을 읽고,
        // Bean들을 스프링 컨테이너에 등록하고 관리하게 됩니다.
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // ClassPathXmlApplicationContext는 스프링의 설정 파일(applicationContext.xml)을 클래스 경로에서 읽어와서 
        // 스프링 컨테이너를 초기화합니다.
        // 이 과정에서 스프링은 설정된 Bean들을 생성하고, 필요에 따라 의존성을 주입합니다.
        // 즉, 스프링이 관리하는 객체들이 필요할 때, 이 컨텍스트를 통해 Bean을 가져올 수 있습니다.

        // getBean 메서드를 사용하여 스프링 컨테이너에서 messageBeanImpl2라는 이름의 Bean을 가져옵니다.
        // 이 Bean은 MessageBean 인터페이스를 구현한 클래스의 객체입니다.
        // getBean 메서드는 Object 타입을 반환하므로, MessageBean 타입으로 형변환(casting)을 해주어야 합니다.
        MessageBean messageBean = (MessageBean) context.getBean("messageBeanImpl2");
        // 스프링 설정 파일(applicationContext.xml)에서 id가 "messageBeanImpl2"로 설정된 Bean을 가져옵니다.
        // 이 과정에서 실제 구현체인 MessageBeanImpl 클래스가 스프링에 의해 반환됩니다.
        // 이 Bean은 이미 스프링이 생성한 객체이며, 의존성 주입(필요한 필드나 객체들)이 완료된 상태입니다.

        // helloCall 메서드를 호출하여 MessageBeanImpl 클래스에서 정의된 메시지 출력 기능을 실행합니다.
        messageBean.helloCall();
        // messageBean 객체의 helloCall 메서드를 호출하면, 
        // 내부적으로 Outputter 인터페이스를 구현한 객체를 사용하여 메시지를 출력하게 됩니다.
        // 스프링을 통해 관리된 객체의 동작을 확인하는 부분입니다.
        // 이 메서드는 주입된 Outputter 객체를 이용해 특정 형식으로 메시지를 출력하는 기능을 담당합니다.

    }

}
