package lmabda;

class Person04 {
    // Compute02 인터페이스를 구현한 객체를 받아 calc 메서드를 호출합니다.
    public void execute(Compute02 compute02) {
        String result = compute02.calc(25, 36); // 인터페이스의 리턴 값을 받습니다.
        System.out.println(result);
    }
    
    // 두 정수를 곱하는 일반 메서드입니다.
    public int mul(int x, int y) {
        return x * y;
    }
    
    // 두 정수를 나누어 소수점 이하까지 계산하는 일반 메서드입니다.
    public double div(int x, int y) {
        return (double)x / y;
    }
}    

public class LambdaMain04 {
    public static void main(String[] args) {
        // Person04 클래스의 인스턴스를 생성합니다.
        Person04 person04 = new Person04();
        
        /*
        person04.execute((x ,y) -> {
            int result = x + y;
            return x + " + " + y + " = " + result;
        }); // compute02 에게 값을 넘겨줌
        */
        // 위의 줄을 간단하게 한줄로 줄여줌
        /*
        person04.execute((x ,y) -> {
            return x + " + " + y + " = " + (x+y);
        });
        */
        // 실행문이 1개인 경우이므로 {} 와 함께 return 도 생략 가능
        // 람다 표현식을 사용하여 두 정수의 합을 문자열로 반환합니다.
        person04.execute((x ,y) -> x + " + " + y + " = " + (x+y));
        System.out.println();
        
        // - 연산 으로 변경
        // 람다 표현식을 사용하여 두 정수의 차를 문자열로 반환합니다.
        person04.execute((x, y) -> x + " - " + y + " = " + (x-y));
        System.out.println();
        
        // * 매개변수를 일반 함수에서 넣어서 계산
        // 람다 표현식을 사용하여 두 정수의 곱을 문자열로 반환합니다.
        person04.execute((x, y) -> x + " * " + y + " = " + person04.mul(x, y));
        System.out.println();
        
        // 소수점 이하까지 계산되게끔 계산
        // 람다 표현식을 사용하여 두 정수의 나눗셈 결과를 소수점 이하까지 문자열로 반환합니다.
        person04.execute((x, y) -> x + " / " + y + " = " + person04.div(x, y));
        System.out.println();
    }
}
