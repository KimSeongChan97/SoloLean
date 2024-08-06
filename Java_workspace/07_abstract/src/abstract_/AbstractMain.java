package abstract_;

//AbstractTest 클래스를 상속받는 AbstractMain 클래스 선언
public class AbstractMain extends AbstractTest {
	// 부모 클래스의 추상 메서드 setName을 구현 (Override)
	@Override
	public void setName(String name) {
		this.name = name;
		
	}
	 // main 메서드 - 프로그램의 시작점
	public static void main(String[] args) {
		//error - AbstractTest at = new AbstractTest(); AbstractTest 클래스는 추상 클래스이므로 인스턴스를 생성할 수 없습니다.
		// 추상 class 이기 때문에 생성이 불가능하다.
		// 해결안 : Sub Class 제어, Method 활용
		// 1. Sub Class => 반드시 부모의 추상 method 를 Override 해야 한다.
		// 2. Method => 추상 메서드는 서브 클래스에서 구현하여 사용해야 한다.
		// 추상은 한국의 카드 빚(연좌제) 와 비슷하다.
		// 추상 메서드를 상속받은 클래스는 반드시 그 빚을 갚아야 한다 (즉, 구현해야 한다).
		
		// AbstractTest 타입의 변수 at에 AbstractMain의 인스턴스를 할당
        // 부모 클래스 타입의 변수에 자식 클래스의 인스턴스를 할당 (다형성)
		AbstractTest at = new AbstractMain(); // 부모 = 자식
		
		 // setName 메서드를 호출하여 이름을 설정
        // 이 메서드는 AbstractMain 클래스에서 구현된 메서드입니다	
		at.setName("홍길동"); // Override 했기 때문에 Main 의 값을 호출 (부모 값은 X)
		
		// getName 메서드를 호출하여 이름을 출력
        // 이 메서드는 부모 클래스인 AbstractTest에서 정의된 메서드로, 자식 클래스에서도 사용 가능합니다.
		System.out.println("이름 = " + at.getName());
		
		
	}

}

