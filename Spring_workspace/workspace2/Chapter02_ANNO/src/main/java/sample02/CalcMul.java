package sample02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Component;

// import lombok.Setter;
// @Setter 어노테이션을 사용하면 Lombok이 자동으로 setter 메서드를 생성해 줍니다.
// 하지만 여기서는 직접 setter 메서드를 작성하고 있으므로 Lombok을 사용하지 않았습니다.

// @Component
// @Component 어노테이션은 Spring이 이 클래스를 자동으로 Bean으로 등록하게 만듭니다.
// Spring 설정 파일에서 별도로 <bean> 정의를 하지 않아도, 이 클래스가 자동으로 Bean으로 관리됩니다.
public class CalcMul implements Calc {
    //@Setter
    // x와 y는 곱셈 연산에 사용될 두 개의 정수 값입니다.
    private int x, y;

    // 이전에 사용된 Setter Injection 방식은 주석 처리되었으며, 현재는 생성자 인젝션 방식이 사용되고 있습니다.
    // 생성자 인젝션은 객체가 생성될 때 x와 y 값을 주입받도록 하는 방식입니다.

    //@Autowired
    // @Autowired는 Spring이 해당 메서드를 자동으로 호출하여 값을 주입하도록 설정합니다.
    // @Value 어노테이션은 이 메서드가 호출될 때 "25"라는 값을 x 필드에 주입합니다.
    // public void setX(@Value("25") int x) {
    //     this.x = x;
    // }

    //@Autowired
    // @Autowired는 Spring이 이 메서드를 자동으로 호출하여 y 값을 주입합니다.
    // @Value 어노테이션은 "36"이라는 값을 주입하여 y 필드에 설정합니다.
    // public void setY(@Value("36") int y) {
    //     this.y = y;
    // }

    @Autowired
    // @Autowired 어노테이션을 통해 Spring이 이 생성자에 의존성을 주입할 수 있도록 설정합니다.
    // @Value 어노테이션을 사용하여 x에는 25, y에는 36이라는 값이 각각 주입됩니다.
    public CalcMul(@Value("25") int x, @Value("36") int y) {
        // 이 생성자는 객체가 생성될 때 x와 y의 값을 설정합니다.
        this.x = x;
        this.y = y;
    }

    @Override
    public void calculate() {
        // calculate 메서드는 인터페이스 Calc에서 정의된 메서드를 구현한 것으로,
        // 여기서는 x와 y 값을 곱한 결과를 출력합니다.
        System.out.println(x + " * " + y + " = " + (x * y));
        // 예를 들어, x가 25이고 y가 36이면 "25 * 36 = 900"이 출력됩니다.
        // 이 메서드는 Calc 인터페이스를 구현하는 클래스에서 반드시 구현해야 하는 메서드입니다.
    }
}
