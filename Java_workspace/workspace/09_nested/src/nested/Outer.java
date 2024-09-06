package nested; // 패키지 선언

public class Outer { // 외부 클래스 Outer 선언

    private String name; // 외부 클래스의 private 멤버 변수 name
    
    public void output() { // 외부 클래스의 멤버 메서드 output 선언
        // 외부 클래스는 내부 클래스의 멤버에 직접 접근할 수 없습니다.
        // System.out.println("이름 = " + name + "\t나이 = " + age); - error : age 는 inner class 이므로 접근불가
        // 따라서 내부 클래스의 객체를 생성하여 접근해야 합니다.
        System.out.println("이름 = " + this.name + "\t나이 = " + new Inner().age);
        // new Inner()를 사용하여 내부 클래스의 객체를 생성하고, 이를 통해 age 변수에 접근합니다.
        // Inner().getAge()를 사용하지 않는 이유는 클래스와 클래스의 멤버 변수가 겹치기 때문입니다.
        // this. 생략 가능
    }

    class Inner { // 내부 클래스 Inner 선언
        private int age; // 내부 클래스의 private 멤버 변수 age

        public void disp() { // 내부 클래스의 멤버 메서드 disp 선언
            // 내부 클래스는 외부 클래스의 모든 멤버에 접근할 수 있습니다.
            System.out.println("이름 = " + Outer.this.name + "\t나이 = " + this.age);
            // 여기서 name 은 외부 클래스의 멤버 변수이고, age 는 내부 클래스의 멤버 변수입니다.
            // Outer.this.name을 사용하여 외부 클래스의 멤버 변수에 접근합니다.
            // this. 생략 가능
        }
    } // 내부 클래스 Inner 의 끝

    public static void main(String[] args) {
        Outer outer = new Outer(); // Outer 클래스의 객체 생성
        outer.name = "홍길동"; // Outer 클래스의 멤버 변수 name 설정
        outer.output(); // Outer 클래스의 멤버 메서드 output 호출
        System.out.println(); // 빈 줄 출력

        Outer.Inner inner = outer.new Inner(); // outer 객체를 통해 Inner 클래스의 객체 생성
        inner.age = 25; // Inner 클래스의 멤버 변수 age 설정
        inner.disp(); // Inner 클래스의 멤버 메서드 display 호출
        System.out.println(); // 빈 줄 출력

        Outer.Inner inner2 = outer.new Inner(); // outer 객체를 통해 새로운 Inner 클래스의 객체 생성
        inner2.age = 30; // 새로운 Inner 객체의 멤버 변수 age 설정
        inner2.disp(); // 새로운 Inner 객체의 멤버 메서드 display 호출
        System.out.println(); // 빈 줄 출력

        Outer.Inner inner3 = new Outer().new Inner(); // 새로운 Outer 객체를 통해 Inner 클래스의 객체 생성
        // inner3.name = "코난"; - error 의 이유는 Outer 객체와 Inner 객체가 다른 인스턴스이기 때문입니다.
        // inner3의 Outer 객체는 새로운 인스턴스이므로 name 변수를 설정하지 않아서 null 이 됩니다.
        inner3.age = 35; // 새로운 Inner 객체의 멤버 변수 age 설정
        inner3.disp(); // 새로운 Inner 객체의 멤버 메서드 display 호출, name 은 null 로 출력됨
        
    }
} // 외부 클래스 Outer 의 끝


/*

class Outer {
    // 외부 클래스의 멤버와 메서드

    // 외부 클래스는 내부 클래스의 멤버에 직접 접근할 수 없습니다.
    // 내부 클래스의 객체를 생성해야만 접근할 수 있습니다.

    class Inner {
        // 내부 클래스는 외부 클래스의 모든 멤버에 접근할 수 있습니다.
        // 이는 상속과 유사한 관계로, 내부 클래스가 외부 클래스의 멤버처럼 동작할 수 있다는 의미입니다.
    }
}

*/

