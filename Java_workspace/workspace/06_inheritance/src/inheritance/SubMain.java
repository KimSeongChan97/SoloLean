package inheritance; // 패키지 선언: 클래스가 속한 패키지를 정의합니다.

// SubMain 클래스는 Super 클래스를 상속받습니다.
public class SubMain extends Super {
    // private 접근 제어자를 가진 멤버 변수 name: 클래스 내부에서만 접근할 수 있습니다.
    private String name; 
    // protected 접근 제어자를 가진 멤버 변수 age: 같은 패키지 내에서 접근 가능하며, 자식 클래스에서도 접근할 수 있습니다.
    protected int age; 

    // 기본 생성자: 매개변수가 없으며, 객체가 생성될 때 호출됩니다.
    public SubMain() {
        // 기본 생성자가 호출되면 "SubMain 기본 생성자" 메시지를 출력합니다.
        System.out.println("SubMain 기본 생성자");
    }

    // 매개변수가 있는 생성자: 객체 생성 시 이름, 나이, 몸무게, 키를 초기화합니다.
    public SubMain(String name, int age, double weight, double height) {
        // 부모 클래스(Super)의 생성자를 호출하여 weight와 height를 초기화합니다.
        super(weight, height); // super()는 부모 클래스의 생성자를 호출하며, 이 문장은 생성자의 첫 줄이어야 합니다.
        System.out.println("SubMain 생성자"); // 생성자가 호출되면 "SubMain 생성자" 메시지를 출력합니다.
        this.name = name; // 현재 객체의 name 멤버 변수를 매개변수 name으로 초기화합니다.
        this.age = age; // 현재 객체의 age 멤버 변수를 매개변수 age로 초기화합니다.

        // 아래 두 방식은 주석 처리되었습니다. 대신 부모 생성자를 호출하는 방식을 사용합니다.
        // 1. 방식: 현재 객체의 weight와 height를 직접 초기화하는 방식입니다.
        // this.weight = weight;
        // this.height = height;
        
        // 2. 방식: 부모 클래스의 weight와 height를 초기화하는 방식입니다.
        // super.weight = weight; // 부모 클래스의 weight 멤버 변수를 초기화합니다.
        // super.height = height; // 부모 클래스의 height 멤버 변수를 초기화합니다.
    }
    
    // output 메서드: 객체의 멤버 변수 값을 출력합니다.
    public void output() {
        // 이름과 나이를 출력합니다.
        System.out.println("이름 = " + name);
        System.out.println("나이 = " + age);
        
        // 아래 두 줄은 주석 처리되어, 부모 클래스에서 상속받은 weight와 height를 출력하지 않습니다.
        // System.out.println("몸무게 = " + weight); // weight는 부모 클래스에서 상속받은 멤버 변수입니다.
        // System.out.println("키 = " + height); // height는 부모 클래스에서 상속받은 멤버 변수입니다.
        
        // 대신, 부모 클래스의 disp() 메서드를 호출합니다.
        disp(); // 부모 클래스의 메서드를 호출합니다. (this, super 생략 가능)
    }

    // 메인 메서드: 프로그램 실행의 시작점입니다.
    public static void main(String[] args) {
        // SubMain 클래스의 객체를 생성하면서, 매개변수로 이름, 나이, 몸무게, 키를 전달합니다.
        // 객체 생성 시 부모 클래스와 자식 클래스의 생성자가 순서대로 호출됩니다.
        SubMain aa = new SubMain("홍길동", 25, 85.3, 178.6); // 매개변수가 있는 생성자가 호출됩니다.
        
        // 생성된 객체의 output 메서드를 호출하여 멤버 변수 값을 출력합니다.
        aa.output();
        System.out.println(); // 출력 결과 간의 구분을 위해 빈 줄을 추가합니다.
        
        // disp() 메서드를 직접 호출하여 부모 클래스의 메서드를 실행합니다.
        aa.disp();
        System.out.println("-----------------------"); // 출력 결과 간의 구분을 위해 구분선을 추가합니다.
        
        // Super 타입의 참조 변수 bb를 선언하고 SubMain 객체를 생성하여 할당합니다.
        Super bb = new SubMain("코난", 13, 35.8, 156.7);
        
        // bb.output(); - error: Super 타입의 참조 변수는 SubMain 클래스에 정의된 메서드를 호출할 수 없습니다.
        bb.disp(); // 부모 클래스에 정의된 disp() 메서드는 호출할 수 있습니다.
    }
}


