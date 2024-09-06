package inheritance;

// AAA 클래스 선언
class AAA {}

// BBB 클래스 선언, AAA 클래스를 상속
class BBB extends AAA {}

// 메인 클래스
public class InstanceOf {

    public static void main(String[] args) {
        // AAA 클래스의 객체 aa 생성
        AAA aa = new AAA();
        // BBB 클래스의 객체 bb 생성
        BBB bb = new BBB();
        // BBB 클래스를 상속받은 AAA 타입의 객체 aa2 생성
        AAA aa2 = new BBB();
        
        // AAA 타입의 변수 aa3에 aa를 할당
        AAA aa3 = aa;
        // aa가 AAA 클래스의 인스턴스인지 확인
        if (aa instanceof AAA) 
            System.out.println("1. TRUE"); // aa는 AAA의 인스턴스이므로 TRUE
        else 
            System.out.println("1. FALSE");
        System.out.println();
        
        // AAA 타입의 변수 aa4에 bb를 할당 (다형성)
        AAA aa4 = bb;
        // bb가 AAA 클래스의 인스턴스인지 확인
        if (bb instanceof AAA) 
            System.out.println("2. TRUE"); // bb는 AAA의 하위 클래스인 BBB의 인스턴스이므로 TRUE
        else 
            System.out.println("2. FALSE");
        System.out.println();
        
        // aa2를 BBB 타입으로 캐스팅하여 bb2에 할당
        BBB bb2 = (BBB) aa2; // 자식 = (자식)부모; cast
        // aa2가 BBB 클래스의 인스턴스인지 확인
        if (aa2 instanceof BBB) 
            System.out.println("3. TRUE"); // aa2는 실제로 BBB 객체이므로 TRUE
        else 
            System.out.println("3. FALSE");
        System.out.println();
        // BBB bb3 = (BBB)aa; // 자식 = (자식)부모, ClassCastException.
        // aa가 BBB 클래스의 인스턴스인지 확인
        if (aa instanceof BBB) 
            System.out.println("4. TRUE");
        else 
            System.out.println("4. FALSE"); // aa는 AAA 객체이므로 FALSE
    }
}
