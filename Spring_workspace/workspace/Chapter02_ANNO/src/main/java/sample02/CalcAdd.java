package sample02;

import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Component;

// import lombok.AllArgsConstructor;
// @AllArgsConstructor는 Lombok 라이브러리를 사용하여 자동으로 모든 필드를 초기화하는 생성자를 만들어줍니다.
// 이 경우, 필드 x와 y에 대해 생성자가 자동으로 생성됩니다.
// 즉, CalcAdd 객체가 생성될 때 x와 y 값이 함께 초기화됩니다.
// 여기서는 @AllArgsConstructor를 사용하지 않고, 수동으로 생성자를 작성했습니다.

// @Component
// @Component 어노테이션은 Spring이 이 클래스를 자동으로 Bean으로 등록하게 만듭니다.
// 이제 Spring 설정 파일에서 별도의 <bean> 정의 없이도 이 클래스를 Bean으로 사용할 수 있습니다.
public class CalcAdd implements Calc {

    private int x, y;
    // 두 개의 정수 필드 x와 y는 계산에 사용될 값들을 저장합니다.
    
    public CalcAdd(@Value("25") int x, @Value("36") int y) {
        // @Value 어노테이션을 사용하여 Spring에서 이 생성자에 값을 주입합니다.
        // 여기서는 "25"와 "36"이라는 값이 x와 y에 각각 전달됩니다.
        // Spring이 관리하는 설정 파일이나 다른 소스에서 이 값들을 주입할 수 있습니다.
        this.x = x;
        this.y = y;
    }
        
    @Override
    public void calculate() {
        // calculate 메서드는 인터페이스 Calc에서 정의된 메서드로, 더하기 연산을 수행합니다.
        // x와 y의 값을 더한 결과를 출력합니다.
        System.out.println(x + " + " + y + " = " + (x + y));
        // 여기서는 필드 x와 y의 값을 더한 결과를 콘솔에 출력합니다.
        // 예를 들어, x가 25이고 y가 36이면 "25 + 36 = 61"이 출력됩니다.
        // 이 메서드는 Calc 인터페이스를 구현하여 강제된 메서드입니다.
    }

}
