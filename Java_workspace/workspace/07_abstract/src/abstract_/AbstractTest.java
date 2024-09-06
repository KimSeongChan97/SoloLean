package abstract_;

// AbstractTest 클래스 선언 (추상 클래스)
public abstract class AbstractTest { 
    // 멤버 변수 name 선언 
    String name; 
    
    // 기본 생성자 (매개변수 없음)
    // 생성자는 객체 생성 시 초기화를 담당합니다.
    // 기본 생성자를 명시적으로 선언하여, 인자가 없는 경우에도 객체를 생성할 수 있도록 합니다.
    public AbstractTest() {}
    
    // 매개변수가 있는 생성자
    // name 멤버 변수를 초기화하기 위해 사용됩니다.
    // super()는 상위 클래스의 생성자를 호출하는데, 여기서는 명시적으로 호출하지 않아도 기본적으로 호출됩니다.
    public AbstractTest(String name) {
        super(); // 명시적으로 호출하지 않아도 기본적으로 호출됩니다.
        this.name = name; // 전달된 name 값을 멤버 변수 name 에 할당합니다.
    }

    // name 멤버 변수의 값을 반환하는 getter 메서드
    // public 접근 제한자를 사용하여 외부에서도 접근이 가능합니다.
    public String getName() {
        return name;
    }

    // name 멤버 변수를 설정하는 추상 메서드
    // 이 메서드는 구현부가 없으며, 해당 클래스가 추상 클래스여야 함을 의미합니다.
    // 서브 클래스는 반드시 이 메서드를 구현해야 합니다.
    public abstract void setName(String name); 
} // 추상 class 를 먼저 만들었다면 추상 method 를 만들어도 되고 안만들어도 된다.
// 추상 class 는 해당 class 에서 (AbstractTest) new 가 안된다.
