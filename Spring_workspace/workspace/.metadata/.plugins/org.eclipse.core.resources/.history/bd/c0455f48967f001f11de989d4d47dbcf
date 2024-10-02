package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

    public static void main(String[] args) {
        // SungJukImpl sungJukImpl = new SungJukImpl();
        // 위 코드는 `SungJukImpl` 객체를 직접 생성하는 방법입니다.
        // 하지만 스프링 프레임워크를 사용하면 의존성 주입을 통해 객체를 관리할 수 있습니다.
        // 스프링은 객체를 직접 생성하고 관리하는 대신, XML 설정이나 어노테이션을 통해 필요한 객체를 자동으로 주입합니다.
        // 그래서 위 코드는 주석 처리되어 있습니다. 대신 아래에서 스프링 컨테이너를 통해 객체를 가져옵니다.

        // 스프링 컨테이너를 초기화하고 설정 파일(applicationContext.xml)을 로드하는 코드입니다.
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // ClassPathXmlApplicationContext는 지정된 XML 설정 파일에서 스프링 컨테이너를 생성하고, 빈(bean)을 로드합니다.
        // 여기서 "applicationContext.xml"은 스프링 설정 파일의 이름으로, 이 파일 안에 스프링이 관리하는 빈(bean)들이 정의되어 있습니다.
        // 스프링 컨테이너가 이 설정 파일을 기반으로 객체들을 생성하고, 그 객체들을 의존성 주입(Dependency Injection)을 통해 관리합니다.
        
        // 컨텍스트에서 "sungJukImpl"이라는 ID를 가진 빈(bean)을 가져와서 SungJuk 인터페이스 타입으로 캐스팅합니다.
        SungJuk sungJuk = (SungJuk) context.getBean("sungJukImpl");
        // getBean() 메서드는 스프링 컨테이너로부터 특정 ID에 해당하는 빈(bean)을 가져오는 메서드입니다.
        // 여기서는 "sungJukImpl"이라는 ID로 정의된 SungJukImpl 객체를 가져오고 있습니다.
        // `SungJuk`은 아마도 인터페이스일 것이며, `sungJukImpl`은 그 인터페이스를 구현한 클래스입니다.
        // 스프링이 관리하는 빈을 가져올 때는 보통 인터페이스 타입으로 받아서 사용하면, 유연한 설계를 할 수 있습니다.

        // SungJuk 인터페이스의 calc() 메서드를 호출하여 성적 계산을 수행합니다.
        sungJuk.calc();
        // 이 코드는 SungJuk 인터페이스의 calc() 메서드를 실행하는 것으로, 아마도 성적 계산과 관련된 작업을 수행하는 메서드일 것입니다.
        // `sungJukImpl` 클래스에 calc() 메서드가 구현되어 있어야 하며, 스프링이 그 구현체를 주입했으므로 바로 사용 가능합니다.

        // 성적 정보를 화면에 출력하는 메서드입니다.
        sungJuk.display();
        // calc() 메서드를 통해 계산된 성적 정보를 출력하는 역할을 하는 메서드로 보입니다.
        // 마찬가지로 `sungJukImpl` 클래스에 이 메서드가 구현되어 있을 것입니다.
    }

}
