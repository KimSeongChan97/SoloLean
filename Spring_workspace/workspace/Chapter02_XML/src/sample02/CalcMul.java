package sample02;

// import lombok.Setter;
// @Setter 어노테이션을 사용하면 Lombok이 자동으로 setter 메서드를 생성해 줍니다.
// 하지만 여기서는 직접 setter 메서드를 작성하고 있으므로 Lombok을 사용하지 않았습니다.

public class CalcMul implements Calc {
    //@Setter
    // x와 y는 곱셈 연산에 사용될 두 개의 정수 값입니다.
    private int x, y;

    // setX 메서드는 외부에서 x 값을 설정하기 위해 사용됩니다.
    // Setter Injection을 통해 Spring 설정 파일에서 이 메서드를 호출할 수 있습니다.
    public void setX(int x) {
        this.x = x;
    }

    // setY 메서드는 외부에서 y 값을 설정하기 위해 사용됩니다.
    // 역시 Setter Injection을 통해 Spring 설정 파일에서 값을 설정할 수 있습니다.
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void calculate() {
        // calculate 메서드는 인터페이스 Calc에서 정의된 메서드를 구현한 것으로,
        // 여기서는 x와 y 값을 곱한 결과를 출력합니다.
        System.out.println(x + " * " + y + " = " + (x * y));
        // 예를 들어, x가 25이고 y가 36이면 "25 * 36 = 900"이 출력됩니다.
    }
}
