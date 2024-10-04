package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("helloSpringSample03")
public class HelloSpring {

    public static void main(String[] args) {
        // SungJukImpl sungJukImpl = new SungJukImpl();
        // 위 코드는 `SungJukImpl` 객체를 직접 생성하는 방식입니다.
        // 그러나 스프링 프레임워크를 사용하면 객체의 생성과 관리가 스프링 컨테이너에 의해 자동으로 이루어집니다.
        // 따라서 스프링 컨테이너에서 필요한 객체를 가져오기 위해 위 코드는 주석 처리되어 있습니다.

        // 스프링 컨테이너를 초기화하고 XML 설정 파일(applicationContext.xml)을 로드하는 코드입니다.
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // ClassPathXmlApplicationContext는 지정된 클래스 경로 내의 XML 설정 파일에서 스프링 컨테이너를 생성하고, 빈(bean)을 로드합니다.
        // "applicationContext.xml"은 스프링 설정 파일의 이름입니다.
        // 이 파일 안에 스프링이 관리하는 빈들이 정의되어 있으며, 스프링이 이 파일을 읽어 필요한 객체들을 자동으로 생성하고 관리합니다.
        // 스프링의 주요 기능인 의존성 주입(Dependency Injection)이 여기서 이루어집니다.

        // 컨텍스트에서 "sungJukImpl"이라는 ID로 정의된 빈을 가져와서 SungJuk 인터페이스 타입으로 캐스팅합니다.
        SungJuk sungJuk = (SungJuk) context.getBean("sungJukImpl");
        // getBean() 메서드는 스프링 컨테이너로부터 특정 ID에 해당하는 빈을 가져오는 메서드입니다.
        // 여기서는 "sungJukImpl"이라는 이름으로 정의된 SungJukImpl 객체를 가져옵니다.
        // 스프링 설정 파일에서 이 ID와 연결된 객체를 가져오며, SungJuk 인터페이스로 캐스팅하여 사용합니다.
        // SungJuk 인터페이스를 통해 다형성을 활용할 수 있습니다. 즉, 같은 인터페이스를 구현하는 다른 구현체가 있어도, 유연하게 처리할 수 있습니다.

        // SungJuk 인터페이스의 calc() 메서드를 호출하여 성적 계산을 수행합니다.
        sungJuk.calc();
        // calc() 메서드는 총점과 평균을 계산하는 로직을 포함하고 있습니다.
        // sungJukImpl 객체가 스프링 컨테이너에서 주입되었으므로, 이 메서드를 호출하여 성적 계산을 실행합니다.

        // 성적 정보를 화면에 출력하는 메서드입니다.
        sungJuk.display();
        // display() 메서드는 calc() 메서드를 통해 계산된 결과(총점과 평균)를 화면에 출력하는 역할을 합니다.
        // 이름과 국어, 영어, 수학 점수를 포함한 성적 정보를 콘솔에 출력합니다.
    }

}
