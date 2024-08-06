package inheritance;

// AA 클래스 선언
class AA {
    public int a = 3; // AA 클래스의 멤버 변수 a를 3으로 초기화

    // disp() 메서드 선언
    public void disp() {
        a += 5; // 멤버 변수 a의 값을 5 증가
        System.out.print("AA : " + a + " "); // 증가된 a 값을 출력
    }
}

// BB 클래스 선언, AA 클래스를 상속
class BB extends AA {
    public int a = 8; // BB 클래스의 멤버 변수 a를 8로 초기화 (AA 클래스의 a와 별개)

    // disp() 메서드 오버라이딩
    public void disp() {
        this.a += 5; // BB 클래스의 멤버 변수 a의 값을 5 증가 (this 키워드로 BB의 a 사용)
        System.out.print("BB : " + a + " "); // 증가된 a 값을 출력
    }
}

// 메인 클래스
public class TestMain {
    public static void main(String[] args) {
        // BB 클래스의 객체 aa 생성
        BB aa = new BB();
        aa.disp(); // BB 클래스의 disp() 메서드 호출
        System.out.println("aa : " + aa.a); // BB 클래스의 멤버 변수 a 출력 (8 + 5 = 13)
        System.out.println(); // 한 줄 띄기

        // 다형성: 부모 클래스 타입의 변수 bb가 자식 클래스 BB 객체를 참조
        AA bb = new BB();
        bb.disp(); // BB 클래스의 disp() 메서드 호출 (오버라이딩된 메서드)
        System.out.println("bb : " + bb.a); // AA 클래스의 멤버 변수 a 출력 (오버라이딩은 메서드에만 적용, 따라서 3 + 5 = 8)
        System.out.println(); // 한 줄 띄기

        // bb 변수를 BB 타입으로 캐스팅하여 cc 변수에 할당 => 자식=(자식)부모 의 형식
        BB cc = (BB) bb;
        cc.disp(); // BB 클래스의 disp() 메서드 호출
        System.out.println("cc : " + cc.a); // BB 클래스의 멤버 변수 a 출력 (이미 증가된 13에서 5를 더해 18이 됨)
        System.out.println(); // 한 줄 띄기

        // AA 클래스의 객체 dd 생성
        AA dd = new AA();
        dd.disp(); // AA 클래스의 disp() 메서드 호출
        System.out.println("dd : " + dd.a); // AA 클래스의 멤버 변수 a 출력 (3 + 5 = 8)
        System.out.println(); // 한 줄 띄기
        
        // 다음 줄은 ClassCastException을 발생시킴
        BB ee = (BB)dd; // 자식 = (자식)부모, ClassCastException 발생
        // 이유: dd는 실제로 AA 클래스의 객체이므로 BB 클래스로 캐스팅할 수 없음 -> memory 에 잡혀있지 않음.
    }
}
