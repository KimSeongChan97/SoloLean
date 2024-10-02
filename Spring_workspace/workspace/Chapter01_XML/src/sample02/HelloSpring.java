package sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpring {

    public static void main(String[] args) {
        // 스프링 설정 파일(applicationContext.xml)을 읽어 스프링 컨테이너(ApplicationContext)를 초기화합니다.
        // FileSystemXmlApplicationContext는 XML 파일을 기반으로 스프링 빈을 생성하고 관리합니다.
        // 이 컨텍스트는 XML 파일의 경로를 기준으로 스프링 빈을 로드합니다.
        ApplicationContext context = new FileSystemXmlApplicationContext("src/applicationContext.xml");

        // 'calcAdd'라는 ID로 정의된 빈(Bean)을 가져옵니다.
        // 여기서는 Calc 인터페이스를 구현한 CalcAdd 클래스의 객체를 가져옵니다.
        // context.getBean("calcAdd")는 'calcAdd' ID로 등록된 빈을 스프링 컨테이너에서 검색하여 반환합니다.
        // 반환된 객체는 Object 타입이므로, Calc 타입으로 캐스팅해야 합니다.
        Calc calc = (Calc) context.getBean("calcAdd");
        
        // Calc 인터페이스의 calculate 메서드를 호출하여 덧셈 연산을 수행합니다.
        // CalcAdd 클래스에서는 25 + 36의 결과가 출력됩니다.
        calc.calculate(25, 36);
        System.out.println();
        
        // 'calcMul'이라는 ID로 정의된 빈(Bean)을 가져옵니다.
        // 여기서는 Calc 인터페이스를 구현한 CalcMul 클래스의 객체를 가져옵니다.
        // context.getBean("calcMul")는 'calcMul' ID로 등록된 빈을 스프링 컨테이너에서 검색하여 반환합니다.
        Calc calc2 = (Calc) context.getBean("calcMul");

        // Calc 인터페이스의 calculate 메서드를 호출하여 곱셈 연산을 수행합니다.
        // CalcMul 클래스에서는 25 * 36의 결과가 출력됩니다.
        calc2.calculate(25, 36);
        System.out.println();
    }
}
