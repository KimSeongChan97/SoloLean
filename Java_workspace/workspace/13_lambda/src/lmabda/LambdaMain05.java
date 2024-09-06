package lmabda;

// Calculator 클래스는 두 정수의 연산 결과를 문자열로 반환하는 메서드를 포함합니다.
class Calculator {
    // 두 정수의 합을 문자열로 반환하는 static 메서드입니다.
    public static String staticMethod(int x, int y) {
        return x + " + " + y + " = " + (x + y);
    }
    
    // 두 정수의 곱을 문자열로 반환하는 non-static 메서드입니다.
    public String non_staticMethod(int x, int y) {
        return x + " * " + y + " = " + (x * y);
    }
}

//-------------------------------------
public class LambdaMain05 {
    public static void main(String[] args) {
        Person04 person04 = new Person04();
        
        // 람다 표현식을 사용하여 static 메서드 호출
        person04.execute((x, y) -> Calculator.staticMethod(x, y));
        
        // 메서드 참조를 사용하여 static 메서드 호출
        person04.execute(Calculator :: staticMethod); // 위와 아랫줄은 같은 형식.
        
        // Calculator 인스턴스 생성 (non-static 메서드 호출을 위해)
        Calculator calculator = new Calculator();
        
        // 람다 표현식을 사용하여 non-static 메서드 호출
        person04.execute((x, y) -> calculator.non_staticMethod(x, y));
        
        // 메서드 참조를 사용하여 non-static 메서드 호출
        person04.execute(calculator :: non_staticMethod);
    }
}



/*
 
메소드를 참조해서 매개변수의 정보 및 리턴 타입을 알아내 람다식에서 불필요한 매개변수를 제거하는 것을 목적으로 한다.

큰수를 리턴하는 람다식
(left, right) -> Math.max(left, right);

위에서 단순히 left, right 값을 매개값으로 전달하는 역활만 하기 때문에 메소드 참조를 이용하면 깔끔하게 처리된다.
Math :: max; // -> 를 :: 로 사용.

[형식]
① 정적 메소드
클래스 :: 메소드

② 인스턴스 메소드
참조변수 :: 메소드

*/

