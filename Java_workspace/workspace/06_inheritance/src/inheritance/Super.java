package inheritance; // 패키지 선언: 클래스가 속한 패키지를 정의

// Super 클래스: 상속 관계에서 부모 클래스 역할을 하는 클래스
public class Super {
    // protected 접근 제어자를 가진 멤버 변수 weight 와 height: 같은 패키지 내에서 접근 가능하고, 자식 클래스에서도 접근 가능
    protected double weight, height; 

    // 기본 생성자: 매개변수가 없고, 객체가 생성될 때 호출됨
    public Super() {
        // 기본 생성자가 호출되면 "Super 기본 생성자" 메시지를 출력
        System.out.println("Super 기본 생성자");
    }

    // 주석 처리된 생성자: 매개변수를 사용하여 멤버 변수를 초기화하는 생성자
    /*
    public Super(double weight, double height) { // 매개변수 weight 와 height 를 받아서 멤버 변수 초기화
        this.weight = weight; // 현재 객체의 weight 멤버 변수를 매개변수 weight 로 초기화
        this.height = height; // 현재 객체의 height 멤버 변수를 매개변수 height 로 초기화
    }
    */

    // 매개변수가 있는 생성자: 객체 생성 시 매개변수를 받아 멤버 변수를 초기화
    public Super(double weight, double height) {
        // 매개변수가 있는 생성자가 호출되면 "Super 생성자" 메시지를 출력
        System.out.println("Super 생성자");
        // 매개변수로 전달받은 값으로 멤버 변수 weight 와 height 를 초기화
        this.weight = weight; 
        this.height = height;
    }

    // disp 메서드: 멤버 변수 weight 와 height 의 값을 출력
    public void disp() {
        // 멤버 변수 weight 의 값을 출력
        System.out.println("몸무게 = " + weight);
        // 멤버 변수 height 의 값을 출력
        System.out.println("키 = " + height);
    }
}



/*

가지고 있는 클래스의 재구현 : 상속 inheritance
is ~ a 관계 :  ~ 이다 . 
택시 is a 자동차 이다.
상속을 왜? : 업그레이드를 위해.
java 에서는 다중 상속 안된다. ( C언어 에서는 단일상속만 가능하다. )
그래서 -> 상속 / interface 로 해결한다. 
상속 : 진  / interface 짭
private 
public
protected : sub class 에서 접근 가능한 class ( 부모 / 자식 )
private < default < protected < public 접근 허가 순
class 생성자 

*/