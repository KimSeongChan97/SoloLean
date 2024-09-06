package nested;

public abstract class AbstractTest {

		String name;
		
		public String getName() {
			return name;
		}
		public abstract void setName(String name); // 추상 메소드 -> 추상 class 추가
		
}

/*
 
// 추상 클래스 AbstractTest 정의
abstract class AbstractTest {
    // 추상 메서드 정의 (구현되지 않음)
    abstract void someMethod();
}

// 추상 클래스 AbstractExam 정의
abstract class AbstractExam {
    // 추상 메서드 정의 (구현되지 않음)
    abstract void examMethod();
}

// 메인 클래스
public class Main {
    public static void main(String[] args) {
        // AbstractTest 클래스의 객체를 직접 생성할 수 없습니다.
        // AbstractTest at = new AbstractTest(); // 컴파일 오류 발생
        // -> 추상 메서드를 반드시 오버라이드해야 합니다. (강제성)

        // AbstractExam 클래스의 객체를 직접 생성할 수 없습니다.
        // AbstractExam ae = new AbstractExam(); // 컴파일 오류 발생
        // -> 개발자가 원하는 메서드를 선택하여 오버라이드합니다.
    }
}
 
 */
