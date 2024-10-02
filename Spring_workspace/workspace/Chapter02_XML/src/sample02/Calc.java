package sample02;

public interface Calc {
    // 인터페이스 Calc는 계산 기능을 제공하기 위한 구조를 정의합니다.
    // 인터페이스는 메서드의 동작 방식을 구현하지 않고, 해당 메서드가 어떤 역할을 해야 하는지만 정의합니다.

    public void calculate();
    // calculate 메서드는 계산을 수행하는 역할을 합니다.
    // 이를 구현하는 클래스에서 실제 계산 로직을 정의해야 합니다.
    // 예를 들어, 더하기 연산을 수행하는 CalcAdd 클래스나 곱하기 연산을 수행하는 CalcMul 클래스가 이 메서드를 구현하게 됩니다.
}
