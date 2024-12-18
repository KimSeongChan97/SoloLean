package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		// sayHello 메서드 호출
		// MessageBeanKo messageBeanKo = new MessageBeanKo(); // 1:1 관계, 결합도 100%
		// 클래스가 많을 때는 클래스를 생성하는 코드가 많아짐
		// -> 여기서는 `MessageBeanKo`라는 클래스와 `HelloSpring` 클래스가 직접적인 1:1 관계를 맺고 있음.
		// 결합도가 높다는 것은, 만약 `MessageBeanKo`의 구현이 변경되면 `HelloSpring`도 수정이 필요하다는 의미입니다.
		// 스프링을 사용하지 않는 경우에는, 각각의 클래스에 대한 인스턴스를 직접 new 연산자로 생성해야 하기 때문에,
		// 프로젝트가 커질수록 관리가 복잡해지고 코드의 유연성이 떨어집니다.
		// -> 이렇게 new 연산자로 클래스 인스턴스를 만들면, 클래스의 변경이 있을 때마다 매번 모든 코드에서 수정을 해줘야 하고,
		//    의존성이 높아져 유연한 코드 구조를 만들기 어려워집니다.

		// 부모 = 자식, 다형성, 결합도 낮추기
		// MessageBean messageBean = new MessageBeanEn(); // 내부적으로 생성자 
		// -> 이 방식은 부모 클래스(`MessageBean`) 타입의 참조 변수가 자식 클래스(`MessageBeanEn`)의 객체를 참조하는 방식입니다.
		// 이는 다형성의 예시로, 코드의 결합도를 낮추어, 이후에 다른 `MessageBean` 구현체로 쉽게 변경할 수 있게 해줍니다.
		// 그러나 여전히 직접 객체를 생성해야 하므로, 이 부분을 스프링으로 관리하면 더 효율적입니다.
		// -> 다형성(polymorphism)을 이용하면 부모 클래스 타입으로 자식 객체를 처리할 수 있어 유연성이 증가하지만,
		//    여전히 객체 생성을 직접 관리해야 한다는 점에서 유지보수에 부담이 생길 수 있습니다.

		// 스프링 설정파일을 이용
		// -> 스프링에서는 이러한 객체 생성을 `ApplicationContext`라는 컨테이너가 대신 관리해 줍니다.
		// `ApplicationContext`는 스프링의 핵심 컨테이너 중 하나로, 설정 파일을 읽어서 빈(Bean)을 생성하고 관리합니다.
		// ApplicationContext context = new FileSystemXmlApplicationContext("src/applicationContext.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("src/applicationContext.xml");
		// -> `FileSystemXmlApplicationContext`는 파일 시스템에서 XML 설정 파일을 읽어와서 스프링 컨텍스트를 초기화합니다.
		// `"src/applicationContext.xml"`은 XML 파일의 경로를 나타냅니다. 이 XML 파일에는 생성할 객체(빈)의 설정 정보가 담겨 있습니다.
		// 이 컨테이너는 설정된 대로 객체를 자동으로 생성하고, 의존성 주입(Dependency Injection)을 수행합니다.
		// -> 즉, `FileSystemXmlApplicationContext`는 XML 파일로부터 객체 설정을 불러와서 스프링이 알아서 객체를 생성하고 관리하게 합니다.

		MessageBean messageBean = (MessageBean) context.getBean("messageBean");
		// -> `context.getBean("messageBean")`는 XML 파일에서 id가 `"messageBean"`인 빈을 가져옵니다.
		// 이 메서드는 Object 타입을 반환하므로, 이를 `MessageBean` 타입으로 캐스팅해야 합니다.
		// 이렇게 스프링이 객체 생성과 관리를 대신해줌으로써 코드의 결합도를 낮추고, 유지보수를 용이하게 합니다.
		// -> 스프링 컨테이너가 객체를 생성하고 관리하므로, 개발자는 직접 객체를 생성(new)할 필요가 없습니다.
		//    이는 코드의 결합도를 낮추고, 객체 변경 시 유지보수 부담을 덜어줍니다.

		messageBean.sayHello("Spring"); // num = 1
		// -> `sayHello` 메서드를 호출하면서 인수로 `"Spring"` 문자열을 전달합니다.
		// 이 메서드는 `messageBean` 객체에 구현된 대로 동작하게 됩니다. 어떤 구현체인지에 따라 다른 동작을 수행할 수 있습니다.
		// 예를 들어, 한국어 메시지를 출력하거나 영어로 메시지를 출력하는 방식이 다를 수 있습니다.
		// -> 이 경우 `messageBean`이 어떤 구현체인지에 따라 다른 메시지가 출력됩니다.
		//    `MessageBeanKo` 클래스일 경우 한국어로, 다른 구현체일 경우 영어로 출력될 수 있습니다.
		System.out.println();
		
		// MessageBean messageBean = new MessageBeanKo();
		// -> 만약 스프링을 사용하지 않는다면 위 코드처럼 직접 인스턴스를 생성해야 합니다. 이 방식은 결합도가 매우 높아집니다.
		
		MessageBean messageBean2 = (MessageBean) context.getBean("messageBean");
		messageBean2.sayHello("Spring"); // num = 1 일줄 알지만, 2
		// -> 두 번째로 `getBean()` 메서드를 호출해서 `messageBean`을 가져왔을 때도 동일한 인스턴스를 가져옵니다.
		//    스프링의 기본 빈 스코프는 `singleton`이기 때문에, 처음 생성된 객체가 계속해서 반환됩니다.
		//    따라서 두 번째 호출에서는 num이 1이 아닌 2가 됩니다.
		System.out.println();

		MessageBean messageBean3 = (MessageBean) context.getBean("messageBean");
		messageBean3.sayHello("Spring"); // num = 1 일줄 알지만, 3
		// -> 세 번째로 가져온 `messageBean` 역시 동일한 인스턴스입니다.
		//    싱글톤 스코프에서는 모든 요청이 동일한 객체를 참조하므로, 세 번째 호출 시 num은 3이 됩니다.
		System.out.println();
		// Spring 은 기본이 싱글톤이다.
		// applicationContext.xml 에서 scope="prototype" 을 하게되면 각각으로 1을 결과로 나온다.
		// -> 스프링의 기본 스코프는 `singleton`입니다. 이는 애플리케이션이 구동되는 동안 하나의 객체만 생성하여 재사용한다는 의미입니다.
		//    그러나 만약 scope="prototype"으로 설정하면, 매번 `getBean()`을 호출할 때마다 새로운 객체가 생성됩니다.
		//    이 경우 위 예시에서 num 값은 각각 1로 초기화됩니다.
				
	} 

}

// 변환되는 클래스 생성을 스프링이 해준다.
// Scanner scan = new Scanner(System.in); 은 그냥 new 한다.
// -> 일반적인 경우에는 `Scanner`처럼 new 키워드를 사용하여 객체를 직접 생성하지만, 스프링에서는 객체 생성과 관리를 스프링 컨테이너가 대신 처리합니다.
// 이로 인해 객체 생성과 관련된 코드가 분리되고, 코드의 유지보수성과 재사용성이 높아집니다.
// -> 스프링을 사용하면 new 연산자를 통해 직접 객체를 생성하지 않아도 되고, 설정 파일에 정의된 대로 객체를 관리해 줍니다.
//    이렇게 함으로써 코드의 유연성과 유지보수성을 향상시킬 수 있습니다.
