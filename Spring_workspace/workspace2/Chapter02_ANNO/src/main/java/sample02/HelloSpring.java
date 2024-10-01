package sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
    public static void main(String[] args) {
        // Spring의 ApplicationContext는 스프링 프레임워크에서 제공하는 IoC(제어의 역전) 컨테이너입니다.
        // 여기서 'applicationContext.xml' 파일을 로드하여, 스프링이 관리하는 Bean들을 가져옵니다.
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	
    	Calc calc;  // Calc 인터페이스 타입의 변수를 선언합니다. 이 변수는 Spring에서 주입받은 Bean을 저장하게 됩니다.
    	
    	// 'calcAdd'라는 id를 가진 Bean을 가져옵니다. 이 Bean은 XML에서 생성자 인젝션을 통해 생성된 CalcAdd 객체입니다.
    	// context.getBean() 메서드는 해당 Bean의 id로 Bean을 검색하고, 이를 Calc 타입으로 변환하여 반환합니다.
    	calc = (Calc) context.getBean("calcAdd");
    	calc.calculate();  // CalcAdd 객체의 calculate() 메서드를 호출하여 더하기 계산을 수행하고 결과를 출력합니다.

    	// 'calcMul'이라는 id를 가진 Bean을 가져옵니다. 이번에는 getBean() 메서드를 사용하여 타입도 함께 지정합니다.
    	// XML에서 Setter 인젝션을 통해 설정된 CalcMul 객체입니다.
    	calc = context.getBean("calcMul", Calc.class);
    	calc.calculate();  // CalcMul 객체의 calculate() 메서드를 호출하여 곱하기 계산을 수행하고 결과를 출력합니다.
    }
}
