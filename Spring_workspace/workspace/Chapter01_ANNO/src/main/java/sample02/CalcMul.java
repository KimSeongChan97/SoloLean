package sample02;

import org.springframework.stereotype.Component;

@Component("calcMul")
// @Component 어노테이션을 사용하여 이 클래스를 스프링 컨테이너가 관리하는 빈(Bean)으로 등록합니다.
// "calcMul"이라는 이름으로 빈이 등록되며, 나중에 이 이름으로 해당 객체를 주입받거나 사용할 수 있습니다.
// 스프링이 이 객체의 생성을 자동으로 처리해주기 때문에 개발자는 직접 new를 사용해 객체를 만들지 않아도 됩니다.
// 이렇게 스프링에서 관리되는 빈은 주로 의존성 주입(Dependency Injection)을 통해 필요한 곳에서 사용됩니다.

public class CalcMul implements Calc {
    // Calc 인터페이스를 구현한 클래스입니다.
    // 이 클래스는 Calc 인터페이스에서 정의한 calculate 메서드를 구체적으로 구현합니다.
    // 인터페이스를 사용함으로써 다양한 연산(예: 덧셈, 곱셈 등)을 하나의 공통된 방식으로 처리할 수 있게 됩니다.

    @Override
    public void calculate(int x, int y) {
        // 두 정수 x와 y를 곱하는 계산을 수행하고 그 결과를 콘솔에 출력하는 메서드입니다.
        // x와 y는 이 메서드의 매개변수로, 호출 시 사용자가 입력한 두 값입니다.
        System.out.println(x + " * " + y + " = " + (x * y));
        // 여기서는 x와 y의 곱셈 결과를 "x * y = 결과" 형식으로 출력합니다.
        // (x * y)는 두 정수의 곱을 계산하는 부분으로, 이 결과가 콘솔에 출력됩니다.
        // 곱셈 연산은 기본적인 산술 연산이므로 특별한 계산 로직은 필요하지 않습니다.
        // 이 클래스는 곱셈에 대한 로직을 제공하는 역할을 하며, 다른 클래스들이 덧셈, 뺄셈 등을 구현할 수 있게 확장 가능합니다.
    }

}
