package inheritance;

enum ColorEnum { // 열거형 (enum) 선언. 상수들을 나열하며, 마지막에 세미콜론(;)을 붙이지 않아도 됩니다.
	RED, GREEN, BLUE
} 
//-------------------------------------------
class Final { // 'Final' 클래스 선언. 불변 값 (상수화)을 나타냅니다.
	// 인스턴스 상수화 선언. 인스턴스가 생성될 때 초기화되며, 값이 변경될 수 없습니다.
	public final String FRUIT = "사과"; 
	
	// 인스턴스 상수화 선언. 생성자를 통해 초기화됩니다.
	public final String FRUIT2;
	
	// 클래스 상수화 선언. static이므로 클래스가 로드될 때 초기화됩니다.
	public static final String ANIMAL = "호랑이"; 
	
	// 클래스 상수화 선언. static 블록에서 초기화됩니다.
	public static final String ANIMAL2; 
	
	// static 초기화 블록. 클래스가 메모리에 로드될 때 실행됩니다.
	static {
		ANIMAL2 = "기린"; // static final 필드는 static 블록에서 초기화해야 합니다.
	}
	
	// 생성자. 인스턴스가 생성될 때 호출되며, 인스턴스 필드를 초기화합니다.
	public Final() { 
		FRUIT2 = "딸기"; // final 필드 FRUIT2를 초기화합니다.
	}
	
}

//-------------------------------------------
public class FinalMain {

	public static void main(String[] args) {
		// final 지역 변수 선언. 초기화 후 값이 변경될 수 없습니다.
		final int AGE = 25;
		// AGE = 30; - error: final 변수는 값을 변경할 수 없습니다.
		System.out.println("AGE = " + AGE);
		
		// final 지역 변수 선언. 초기화 후 값이 변경될 수 없습니다.
		final String NAME;
		NAME = "홍길동";
		// NAME = "코난"; - error: final 변수는 값을 변경할 수 없습니다.
		System.out.println("NAME = " + NAME);
		System.out.println();
		
		// 'Final' 클래스의 인스턴스 생성.
		Final f = new Final();
		System.out.println("FRUIT = " + f.FRUIT);
		System.out.println("FRUIT2 = " + f.FRUIT2);
		System.out.println();
		
		// 클래스 상수화 필드 접근. 클래스 이름을 통해 접근합니다.
		System.out.println("ANIMAL = " + Final.ANIMAL);
		System.out.println("ANIMAL2 = " + Final.ANIMAL2);
		System.out.println();
		
		// 열거형 상수 출력.
		System.out.println("빨강 = " + ColorEnum.RED);
		// 열거형 상수의 ordinal 값 (순서) 출력. 열거형 상수의 순서를 0부터 시작하는 정수로 반환합니다.
		System.out.println("빨강 = " + ColorEnum.RED.ordinal()); 
		System.out.println();
		
		// 열거형 상수 순회. 모든 열거형 상수를 출력합니다.
		for (ColorEnum data : ColorEnum.values()) {
			System.out.println(data.ordinal() + " : " + data);
		}
	}
}
