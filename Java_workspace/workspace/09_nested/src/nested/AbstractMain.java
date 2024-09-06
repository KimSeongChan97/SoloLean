package nested;

public class AbstractMain {

    public static void main(String[] args) {
        // AbstractTest at = new AbstractTest(); - error : 이유는? Sub class 를 이용함(Override)
        // 위 코드는 에러가 발생합니다. 그 이유는 AbstractTest가 추상 클래스이기 때문입니다.
        // 추상 클래스는 인스턴스를 직접 생성할 수 없고, 이를 상속받는 서브 클래스에서만 인스턴스를 생성할 수 있습니다.
        
        AbstractTest at = new AbstractTest() { // 클래스의 역할 (익명 inner class)
            @Override
            public void setName(String name) {  
                // setName 메서드를 Override 하여 사용 가능합니다.
                // 이 익명 내부 클래스는 일회용으로 주로 사용되며, 주로 특정 메서드의 동작을 구현하기 위해 사용됩니다.
            }
        };
        
        // InterA in = new InterA(); error 이유는?
        // 인터페이스는 인스턴스를 직접 생성할 수 없습니다.
        // 인터페이스의 메서드를 구현한 익명 내부 클래스를 통해 인스턴스를 생성해야 합니다.
        InterA in = new InterA() {
        	@Override
        	public void aa() { 	}
        	@Override
        	public void bb() {}
        	};
     AbstractExam ae = new AbstractExam() {}; // 개발자가 원하는 메소드만 Override  
     
     
    }

}

/*
 class 클 {
     필드
     메소드() {} // 메소드의 구현부를 생성은 class 만 가능하다?
     // 일반 클래스는 필드와 메서드를 포함할 수 있습니다.
     // 메서드의 구현부(본문)는 클래스에서만 정의할 수 있습니다.
     // 인터페이스에서는 메서드의 구현부를 정의할 수 없습니다.
     
     class 클2 { // inner class
         // 내부 클래스는 외부 클래스의 멤버에 접근할 수 있습니다.
     }
 }

interface 인 {
    // 메소드() { } error : 인터페이스 안에는 추상만 가능.
    // 인터페이스 안에서는 메서드의 본문을 정의할 수 없고, 추상 메서드만 선언할 수 있습니다.
    
    메소드(); // 추상 메서드의 선언입니다. 구현은 이 인터페이스를 구현하는 클래스에서 이루어져야 합니다.
}

new 클래스() {
	메소드() { 
	구현 }
	}

*/
