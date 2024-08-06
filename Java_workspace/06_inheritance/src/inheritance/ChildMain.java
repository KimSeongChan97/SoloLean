package inheritance; // 패키지 선언: 클래스가 속한 패키지를 정의합니다.

// ChildMain 클래스는 Super 클래스를 상속받습니다.
public class ChildMain extends Super {
    // private 접근 제어자를 가진 멤버 변수 name: 클래스 내부에서만 접근할 수 있습니다.
    private String name; 
    // protected 접근 제어자를 가진 멤버 변수 age: 같은 패키지 내에서 접근 가능하며, 자식 클래스에서도 접근할 수 있습니다.
    protected int age;

    // 기본 생성자: 매개변수가 없으며, 객체가 생성될 때 호출됩니다.
    public ChildMain() {
        // 기본 생성자가 호출되면 "ChildMain 의 기본 생성자" 메시지를 출력합니다.
        System.out.println("ChildMain 의 기본 생성자");
    }

    // 매개변수가 있는 생성자: 객체 생성 시 이름, 나이, 몸무게, 키를 초기화합니다.
    public ChildMain(String name, int age, double weight, double height) {
        // 부모 클래스(Super)의 생성자를 호출하여 weight와 height를 초기화합니다.
        super(weight, height); // super()는 부모 클래스의 생성자를 호출하며, 이 문장은 생성자의 첫 줄이어야 합니다.
        System.out.println("ChildMain 생성자"); // 생성자가 호출되면 "ChildMain 생성자" 메시지를 출력합니다.
        this.name = name; // 현재 객체의 name 멤버 변수를 매개변수 name으로 초기화합니다.
        this.age = age; // 현재 객체의 age 멤버 변수를 매개변수 age로 초기화합니다.
    }
    	
	    // disp 메서드: 객체의 멤버 변수 값을 출력합니다.
	    // 이 메서드는 부모 클래스인 Super 클래스의 disp 메서드를 오버라이드(Override)합니다.
	    @Override
	    public void disp() {
	        // 이름과 나이를 출력합니다.
	        System.out.println("이름 = " + name);
	        System.out.println("나이 = " + age);
	        
	        // 부모 클래스의 disp 메서드를 호출합니다.
	        super.disp(); // 부모 클래스의 disp 메서드를 호출합니다. (this, super 생략 가능)
	    }
	
	    // 메인 메서드: 프로그램 실행의 시작점입니다.
	    public static void main(String[] args) {
	        // ChildMain 클래스의 객체를 생성하면서, 매개변수로 이름, 나이, 몸무게, 키를 전달합니다.
	        // 객체 생성 시 부모 클래스와 자식 클래스의 생성자가 순서대로 호출됩니다.
	        ChildMain aa = new ChildMain("홍길동", 25, 85.3, 178.6); // 매개변수가 있는 생성자가 호출됩니다.
	        // 생성된 객체의 disp 메서드를 호출하여 멤버 변수 값을 출력합니다.
	        aa.disp();
	        
	        System.out.println("-----------------------"); // 출력 결과 간의 구분을 위해 구분선을 추가합니다.
	        
	        // Super 타입의 참조 변수 bb를 선언하고 ChildMain 객체를 생성하여 할당합니다.
	        Super bb = new ChildMain("코난", 13, 35.8, 156.7);
	        
	        // bb.output(); - error: Super 타입의 참조 변수는 ChildMain 클래스에 정의된 메서드를 호출할 수 없습니다.
	        bb.disp(); // 부모 클래스에 정의된 disp() 메서드는 호출할 수 있습니다.
	    }
}

/*
 
 | 구분              | 메서드 오버로딩 (Overloading)                                     | 메서드 오버라이딩 (Overriding)                                    |
|------------------|-----------------------------------------------------------------|---------------------------------------------------------------|
| 정의              | 같은 클래스 내에서 같은 이름을 가진 메서드를 여러 개 정의하는 것                   | 상속 관계에서 부모 클래스의 메서드를 자식 클래스에서 재정의하는 것                     |
| 클래스            | 동일한 클래스 내에서 발생                                           | 상속 관계의 클래스들 사이에서 발생                                     |
| 매개변수          | 메서드 이름은 같고 매개변수의 타입, 개수, 순서가 다름                             | 메서드 이름, 매개변수 목록, 반환 타입 모두 동일                                |
| 반환 타입          | 상관 없음                                                        | 부모 클래스의 메서드와 동일해야 함                                        |
| 접근 제어자        | 상관 없음                                                        | 부모 클래스의 접근 제어자와 같거나 더 넓은 범위여야 함                              |
| 사용 목적          | 같은 기능을 수행하지만 다른 매개변수로 메서드를 사용할 수 있게 하기                       | 부모 클래스의 메서드를 자식 클래스에서 새롭게 정의하여 동작을 변경하기 위해 사용  |
| 예제 코드          | ```java                                                       | ```java                                                     |
|                  | public class Example {                                        | class Parent {                                               |
|                  |     public void method(int a) {                               |     public void display() {                                  |
|                  |         // 코드                                                |         System.out.println("Parent display");                |
|                  |     }                                                          |     }                                                        |
|                  |                                                               | }                                                            |
|                  |     public void method(String a) {                            | class Child extends Parent {                                 |
|                  |         // 코드                                                |     @Override                                                |
|                  |     }                                                          |     public void display() {                                  |
|                  | }                                                              |         System.out.println("Child display");                 |
|                  |                                                               |     }                                                        |
|                  |     public void method(int a, int b) {                        | }                                                            |
|                  |         // 코드                                                | public class Main {                                          |
|                  |     }                                                          |     public static void main(String[] args) {                 |
|                  | }                                                              |         Parent obj = new Child();                            |
|                  |                                                               |         obj.display();                                       |
|                  | ```                                                           |     }                                                        |
|                  |                                                               | }                                                            |

 
 차이점 !
 overload							Override
쌍둥이								부모자식
1. 하나의 클래스 안에서					1.상속관계
2. 메소드 명이 똑같다.					2. 다 똑같아야함
	인수 개수, 또는 인수형이 틀린경우			Modifier(접근제어자)는 틀려도 되지만, 반드시 자식 class(sub) 가 더 커야 한다.

class Test {							class Super {
	public void sub(int a){}					protected void disp(int a){}
	public void sub(int a, int b){}			}
	public int sub(char a){}
}

class Sample {						class Sub extends Super {	
	public int sub(char a){}					public void disp(int a){}
}										}




 */


