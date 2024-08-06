package abstract_;

import java.util.Scanner;

// ShapeTest 클래스 정의
abstract class ShapeTest {
    // 도형의 넓이를 저장할 변수
    protected double area;
    // 입력을 받기 위한 Scanner 객체
    protected Scanner scan = new Scanner(System.in);
    // 기본 생성자
    public ShapeTest() {
        System.out.println("ShapeTest 기본 생성자");
    }
    // 넓이를 계산하는 메소드 (상속받는 클래스에서 재정의 가능)
    public abstract void calcArea();
    // 넓이를 출력하는 메소드 (상속받는 클래스에서 재정의 가능)
    public abstract void dispArea();
}
//------------------------------------------
// SamTest 클래스는 ShapeTest 클래스를 상속받음
class SamTest extends ShapeTest {
    // 삼각형의 밑변과 높이를 저장할 변수
    protected int base, height;
    // 기본 생성자
    public SamTest() {
        // 부모 클래스의 생성자 호출
        System.out.println("SamTest 기본 생성자");
        
        // 사용자로부터 밑변 입력 받기
        System.out.print("밑변 : ");
        base = scan.nextInt();
        
        // 사용자로부터 높이 입력 받기
        System.out.print("높이 : ");
        height = scan.nextInt();
    }
    
    // 넓이를 계산하는 메소드 재정의
    @Override
    public void calcArea() {
        // 삼각형의 넓이 계산 (밑변 * 높이 / 2)
        area = base * height / 2.0;
    }
    
    // 넓이를 출력하는 메소드 재정의
    @Override
    public void dispArea() {
        // 계산된 삼각형의 넓이 출력
        System.out.println("삼각형 넓이 = " + area);
    }
}
//------------------------------------------
// SaTest 클래스는 ShapeTest 클래스를 상속받음
class SaTest extends ShapeTest {
    // 사각형의 가로와 세로를 저장할 변수
    protected int base, height;
    
    // 기본 생성자
    public SaTest() {
        // 부모 클래스의 생성자 호출
        System.out.println("SaTest 기본 생성자");
        
        // 사용자로부터 가로 입력 받기
        System.out.print("가로 : ");
        base = scan.nextInt();
        
        // 사용자로부터 세로 입력 받기
        System.out.print("세로 : ");
        height = scan.nextInt();
    }
    
    // 넓이를 계산하는 메소드 재정의
    @Override
    public void calcArea() {
        // 사각형의 넓이 계산 (가로 * 세로)
        area = base * height;
    }
    
    // 넓이를 출력하는 메소드 재정의
    @Override
    public void dispArea() {
        // 계산된 사각형의 넓이 출력
        System.out.println("사각형 넓이 = " + area);
    }
}

//------------------------------------------
// SadariTest 클래스는 ShapeTest 클래스를 상속받음
class SadariTest extends ShapeTest {
    // 사다리꼴의 윗변, 밑변, 높이를 저장할 변수
    protected int top, bottom, height;
    
    // 기본 생성자
    public SadariTest() {
        // 부모 클래스의 생성자 호출
        System.out.println("SadariTest 기본 생성자");
        
        // 사용자로부터 윗변 입력 받기
        System.out.print("윗변 : ");
        top = scan.nextInt();
        
        // 사용자로부터 밑변 입력 받기
        System.out.print("밑변 : ");
        bottom = scan.nextInt();
        
        // 사용자로부터 높이 입력 받기
        System.out.print("높이 : ");
        height = scan.nextInt();
    }
    
    // 넓이를 계산하는 메소드 재정의
    @Override
    public void calcArea() {
        // 사다리꼴의 넓이 계산 ((윗변 + 밑변) * 높이 / 2)
        area = (top + bottom) * height / 2.0;
    }
    
    // 넓이를 출력하는 메소드 재정의
    @Override
    public void dispArea() {
        // 계산된 사다리꼴의 넓이 출력
        System.out.println("사다리꼴 넓이 = " + area);
    }
}

//------------------------------------------
// ShapeMain 클래스는 프로그램의 진입점을 제공
public class ShapeMain {
    public static void main(String[] args) {

        // 다형성을 이용한 처리
        ShapeTest shape; // 부모 클래스 타입의 참조 변수 선언

        // SamTest 객체를 생성하고 처리
        shape = new SamTest(); // 다형성, 부모 = 자식이므로 참조할 수 있다.
        shape.calcArea();      // 삼각형의 넓이를 계산
        shape.dispArea();      // 삼각형의 넓이를 출력
        System.out.println();  // 개행 추가

        // SaTest 객체를 생성하고 처리
        shape = new SaTest();  // 다형성, 부모 = 자식이므로 참조할 수 있다.
        shape.calcArea();      // 사각형의 넓이를 계산
        shape.dispArea();      // 사각형의 넓이를 출력
        System.out.println();  // 개행 추가

        // SadariTest 객체를 생성하고 처리
        shape = new SadariTest(); // 다형성, 부모 = 자식이므로 참조할 수 있다.
        shape.calcArea();         // 사다리꼴의 넓이를 계산
        shape.dispArea();         // 사다리꼴의 넓이를 출력
        System.out.println();     // 개행 추가
    }
}


