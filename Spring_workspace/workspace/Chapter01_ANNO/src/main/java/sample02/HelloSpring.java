package sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;


@Component("helloSpringSample02")
public class HelloSpring {

    public static void main(String[] args) {
        // 스프링 컨테이너를 초기화하고 설정 파일(applicationContext.xml)을 로드합니다.
        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/applicationContext.xml");
    	// FileSystemXmlApplicationContext는 지정된 XML 파일 경로에서 스프링 컨테이너를 생성하고, 빈(bean)을 로드합니다.
        // 여기서 "src/main/resources/applicationContext.xml"은 스프링 설정 파일의 경로로, 빈(bean)들이 정의된 파일입니다.
        // 스프링 컨테이너는 이 설정 파일을 기반으로 객체들을 생성하고 관리합니다.
        // 이를 통해 의존성 주입(Dependency Injection)과 같은 스프링의 기능을 사용할 수 있습니다.

        System.out.println();  // 빈 줄을 출력하여 콘솔에서 가독성을 높입니다.

        // 스프링 컨테이너에서 "calcAdd"라는 이름으로 등록된 빈을 가져옵니다.
        Calc calc = (Calc) context.getBean("calcAdd");
        // getBean() 메서드는 스프링 컨테이너에서 특정 ID로 정의된 빈을 가져오는 메서드입니다.
        // 여기서는 "calcAdd"라는 이름의 빈을 가져오고 있으며, 이는 CalcAdd 클래스의 인스턴스를 의미합니다.
        // Calc 인터페이스로 타입 캐스팅하여 다형성을 활용할 수 있게 합니다.

        calc.calculate(25, 36);
        // 가져온 calc 객체의 calculate() 메서드를 호출하여 25와 36을 더하는 연산을 수행합니다.
        // 이때 calc는 CalcAdd 클래스의 인스턴스이므로 덧셈이 수행됩니다.
        // 결과는 콘솔에 출력됩니다.

        System.out.println();  // 빈 줄을 출력하여 가독성을 높입니다.

        // 스프링 컨테이너에서 "calcMul"이라는 이름으로 등록된 빈을 가져옵니다.
        Calc calc2 = (Calc) context.getBean("calcMul");
        // 마찬가지로, 이번에는 "calcMul"이라는 이름의 빈을 가져오고, 이는 CalcMul 클래스의 인스턴스입니다.
        // Calc 인터페이스로 타입 캐스팅하여 다형성을 활용할 수 있습니다.

        calc2.calculate(25, 36);
        // calc2 객체의 calculate() 메서드를 호출하여 25와 36을 곱하는 연산을 수행합니다.
        // calc2는 CalcMul 클래스의 인스턴스이므로 곱셈이 수행됩니다.
        // 결과는 콘솔에 출력됩니다.

        System.out.println();  // 마지막으로 빈 줄을 출력하여 가독성을 높입니다.
    }

}
