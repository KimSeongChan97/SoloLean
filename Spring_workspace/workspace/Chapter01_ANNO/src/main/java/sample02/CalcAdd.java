package sample02;

import org.springframework.stereotype.Component;

@Component("calcAdd")
// @Component 어노테이션은 이 클래스를 스프링이 관리하는 빈(Bean)으로 등록하도록 합니다.
// "calcAdd"라는 이름으로 빈이 등록되며, 나중에 스프링 컨테이너에서 이 이름으로 객체를 찾아 사용할 수 있습니다.
// 스프링이 이 클래스의 객체를 자동으로 생성하고 관리하기 때문에 개발자는 직접 객체를 생성할 필요가 없습니다.
// 이 방식은 의존성 주입(Dependency Injection)을 용이하게 해줍니다.

public class CalcAdd implements Calc {
    // Calc 인터페이스를 구현하는 클래스입니다.
    // 인터페이스를 구현함으로써 이 클래스는 Calc 타입으로 다형성(polymorphism)을 활용할 수 있게 됩니다.
    // 즉, Calc 타입의 변수나 메서드에서 이 클래스의 인스턴스를 사용할 수 있습니다.

    @Override
    public void calculate(int x, int y) {
        // 두 정수 x와 y를 더한 결과를 출력하는 메서드입니다.
        // 여기서는 간단하게 x와 y의 합을 콘솔에 출력하는 기능만을 수행합니다.
        System.out.println(x + " + " + y + " = " + (x + y));
        // x와 y 값을 더한 후, 결과를 "x + y = 결과" 형식으로 출력합니다.
        // System.out.println()은 콘솔에 출력을 해주는 메서드로, 결과를 화면에 바로 보여줍니다.
        // (x + y)는 두 숫자의 합을 계산하는 부분입니다. 괄호를 사용하여 덧셈이 우선적으로 수행되도록 합니다.
        // 이 코드는 단순한 계산 로직이지만, 이를 인터페이스로 구현하여 다양한 계산 클래스를 확장할 수 있습니다.
    }

}
