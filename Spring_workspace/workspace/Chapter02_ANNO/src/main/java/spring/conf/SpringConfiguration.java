package spring.conf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sample01.MessageBeanImpl;
import sample02.CalcAdd;
import sample02.CalcMul;
import sample03.SungJukDTO;
import sample03.SungJukImpl;
import sample04.SungJukDTO2;

@Configuration
// @Configuration은 이 클래스가 Spring 설정 파일(자바 기반 설정)임을 나타냅니다.
// 추가 설명: @Configuration 어노테이션은 이 클래스가 Spring에서 사용하는 구성 클래스임을 나타냅니다.
// 이 클래스는 XML 파일이 아닌 자바 코드로 Spring Bean을 정의하고 관리하는 역할을 합니다.
public class SpringConfiguration {
    // 일반 자바 파일이 아닌 스프링 설정 파일이며, applicationContext.xml 의 역할을 한다.
    // 이 클래스는 자바 기반의 Spring 설정을 정의하는 곳입니다.
    // 여기서 Bean을 생성하는 방법을 자바 코드로 작성할 수 있으며, XML 방식 대신 사용됩니다.
    // 추가 설명: XML 설정을 자바 코드로 대체할 수 있으며, 이를 통해 Bean을 생성하고 의존성을 주입할 수 있습니다.

    // sample01의 MessageBeanImpl 클래스의 Bean 정의
    @Bean
    // @Bean은 이 메서드에서 리턴되는 객체를 Spring 컨테이너가 Bean으로 관리할 수 있게 합니다.
    // 추가 설명: @Bean 어노테이션은 메서드에서 반환된 객체를 Spring 컨테이너에서 관리할 수 있도록 만듭니다.
    // 이때 메서드의 이름이 Bean의 id가 되며, 해당 Bean을 다른 클래스에서 주입받아 사용할 수 있습니다.
    public MessageBeanImpl messageBeanImpl() {
        // 이 메서드는 MessageBeanImpl 객체를 생성하고, 생성자에 "사과"라는 값을 전달하여 초기화합니다.
        // 추가 설명: MessageBeanImpl 클래스의 객체를 생성하고, 그 생성자에 "사과"라는 문자열을 전달하여 초기화합니다.
        return new MessageBeanImpl("사과");
        // 이 코드는 MessageBeanImpl 클래스를 Bean으로 등록하고, 해당 객체가 "사과"라는 값을 가지도록 설정합니다.
        // 추가 설명: Bean으로 생성된 객체는 Spring 컨테이너에서 관리되며, 필요할 때마다 주입되어 사용됩니다.
    }

    // 다른 이름으로 MessageBeanImpl 객체를 생성하는 Bean
    @Bean(name="MessageBeanImpl")
    // @Bean 어노테이션에 name 속성을 추가하여, Bean의 id를 직접 설정할 수 있습니다.
    // 추가 설명: @Bean(name="...")을 사용하여 메서드 이름 대신 다른 id로 Bean을 등록할 수 있습니다.
    public MessageBeanImpl getMessageBeanImpl() {
        // MessageBeanImpl 객체를 생성하고, 생성자에 "사과" 값을 전달합니다.
        // 추가 설명: 위의 messageBeanImpl() 메서드와 동일한 기능을 하지만, 다른 id로 등록됩니다.
        return new MessageBeanImpl("사과");
    }

    // 일반 자바 객체로 MessageBeanImpl 생성 (Spring 관리 Bean이 아님)
    MessageBeanImpl messageBeanImpl = new MessageBeanImpl("사과");
    // 이 코드는 일반 필드로서 MessageBeanImpl 객체를 생성합니다.
    // 추가 설명: 이 객체는 Spring 컨테이너에서 관리되는 Bean이 아니라, 일반 자바 객체로 생성된 것입니다.
    // Spring의 관리와는 별개로 이 클래스 내에서 직접 사용될 수 있는 객체입니다.

    // sample02의 CalcAdd 클래스의 Bean 정의
    @Bean(name = "calcAdd")
    // @Bean 어노테이션을 통해 calcAdd라는 이름의 Bean을 등록합니다.
    // 추가 설명: 이 Bean은 CalcAdd 객체를 생성하며, 그 생성자는 25와 36의 값을 받습니다.
    public CalcAdd calcAdd() {
        return new CalcAdd(25, 36);
        // 추가 설명: CalcAdd 클래스의 생성자를 호출하여 x = 25, y = 36 값을 전달하고 객체를 생성합니다.
        // 이 객체는 Spring 컨테이너에서 관리되며 다른 클래스에서 주입되어 사용됩니다.
    }

    // sample02의 CalcMul 클래스의 Bean 정의
    @Bean(name = "calcMul")
    // @Bean 어노테이션을 통해 calcMul이라는 이름의 Bean을 등록합니다.
    public CalcMul calcMul() {
        return new CalcMul(25, 36);
        // 추가 설명: CalcMul 객체를 생성하고, CalcAdd와 동일하게 x = 25, y = 36 값을 전달하여 초기화합니다.
    }

    // sample03의 SungJukDTO 클래스의 Bean 정의
    @Bean
    public SungJukDTO sungJukDTO() {
        // SungJukDTO sungJukDTO = new SungJukDTO();
        // 추가 설명: SungJukDTO 객체를 생성하고, 생성된 객체에 데이터를 설정합니다.
        // 이 코드는 SungJukDTO라는 데이터를 담는 객체를 생성하는 코드입니다.
        // SungJukDTO 객체는 이름, 국어, 영어, 수학 점수를 담을 수 있는 클래스입니다.
        // 주로 데이터를 한 곳에서 다른 곳으로 전달할 때 사용되며, 여기서는 빈(Bean)으로 설정됩니다.
        // 빈(Bean)은 Spring이 관리하는 객체로, 의존성 주입(Dependency Injection)에서 사용됩니다.
        
        // sungJukDTO.setName("홍길동");
        // sungJukDTO.setKor(97);
        // sungJukDTO.setEng(100);
        // sungJukDTO.setMath(95);
        // 추가 설명: 이름, 국어, 영어, 수학 점수를 설정한 후, 생성된 SungJukDTO 객체를 반환합니다.
        // 이 코드는 SungJukDTO 객체에 데이터를 설정하는 코드입니다.
        // setName("홍길동")을 통해 이름을 설정하고, setKor(97)로 국어 점수,
        // setEng(100)으로 영어 점수, setMath(95)로 수학 점수를 설정하는 방식입니다.
        // 이 부분은 현재 주석 처리되어 있어 실행되지 않지만,
        // 필요 시 해당 데이터를 직접 설정하여 SungJukDTO 객체를 생성할 수 있습니다.
        
        return new SungJukDTO();
        // 새로운 SungJukDTO 객체를 생성하고 반환합니다.
        // 여기서 반환된 객체는 Spring 컨테이너에 의해 관리되며,
        // 다른 클래스에서 의존성 주입을 통해 해당 객체를 사용할 수 있게 됩니다.
    }

    // sample03의 SungJukImpl 클래스의 Bean 정의
    @Bean
    public SungJukImpl sungJukImpl() {
        // SungJukDTO 를 주입받아 생성
        // 추가 설명: SungJukDTO 객체를 의존성으로 주입받아 SungJukImpl 객체를 생성합니다.
        // 이 코드는 Spring에서 의존성 주입을 통해 SungJukImpl 객체를 생성하는 코드입니다.
        // SungJukImpl 클래스는 SungJukDTO 데이터를 기반으로 로직을 수행하는 클래스입니다.
        // sungJukDTO() 메서드를 통해 SungJukDTO 객체를 주입받아 SungJukImpl 생성자에 전달합니다.
        // 이로 인해 SungJukImpl 클래스는 SungJukDTO 객체를 사용하여 작업을 수행할 수 있습니다.

        return new SungJukImpl(sungJukDTO());
        // SungJukDTO 객체를 생성자의 매개변수로 전달하여 SungJukImpl 객체를 생성하고 반환합니다.
        // 이 반환된 SungJukImpl 객체 역시 Spring 컨테이너에 의해 관리되며,
        // 의존성이 필요한 곳에 자동으로 주입될 수 있습니다.
    }
    
    // sample04
    @Bean
    public List<SungJukDTO2> arrayList() {
        // @Bean: 이 어노테이션은 Spring 프레임워크에서 사용되며, 이 메서드가 반환하는 객체를 Spring 컨테이너에서 관리하는 Bean으로 등록합니다.
        // 즉, 이 메서드를 통해 반환된 객체는 Spring에서 주입할 수 있는 Bean이 됩니다. 여기서는 List<SungJukDTO2> 타입의 Bean을 등록하고 있습니다.
    	
        return new ArrayList<SungJukDTO2>();
        // ArrayList<SungJukDTO2> 객체를 생성하여 반환합니다.
        // 이 리스트는 SungJukDTO2 객체들을 저장하기 위한 리스트로 사용됩니다.
        // 즉, 성적 데이터를 저장하는 여러 SungJukDTO2 객체들이 이 리스트에 추가되며, 이후 출력, 수정, 삭제 등의 작업에 사용됩니다.
        // Spring에서 이 리스트를 관리하며, 여러 클래스에서 의존성 주입을 통해 공유됩니다.
    }


}

/*
@Bean 
- 메서드 에서 리턴 되는 값을 스프링의 bean 으로 생성한다.
- 메서드 명은 반드시 bean 의 id 명으로 해야 한다.
- 추가 설명: @Bean 어노테이션이 붙은 메서드는 그 리턴 값이 Spring의 Bean으로 관리되며, 메서드 이름이 Bean의 id로 사용된다.
- 메서드 명을 자바처럼 getter 로 사용하려면 Bean(name="") 을 이용한다.
*/
