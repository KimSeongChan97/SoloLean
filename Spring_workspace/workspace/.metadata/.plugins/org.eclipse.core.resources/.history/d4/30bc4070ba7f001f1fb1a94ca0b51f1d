package sample02;

import lombok.AllArgsConstructor;

@AllArgsConstructor
// @AllArgsConstructor는 Lombok 라이브러리를 사용하여 자동으로 모든 필드를 초기화하는 생성자를 만들어줍니다.
// 이 경우, 필드 x와 y에 대해 생성자가 자동으로 생성됩니다.
// 즉, CalcAdd 객체가 생성될 때 x와 y 값이 함께 초기화됩니다.
public class CalcAdd implements Calc {

    private int x, y;
    // 두 개의 정수 필드 x와 y는 계산에 사용될 값들을 저장합니다.

    @Override
    public void calculate() {
        // calculate 메서드는 인터페이스 Calc에서 정의된 메서드로, 더하기 연산을 수행합니다.
        // x와 y의 값을 더한 결과를 출력합니다.
        System.out.println(x + " + " + y + " = " + (x + y));
        // 여기서는 필드 x와 y의 값을 더한 결과를 콘솔에 출력합니다.
        // 예를 들어, x가 25이고 y가 36이면 "25 + 36 = 61"이 출력됩니다.
    }

}
