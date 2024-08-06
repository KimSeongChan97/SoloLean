package basic;

public class Variable2 {
	int a; // 필드,이미 0으로 초기화 되어있음 : class 소속의 함수이기 때문에 아래의 main 함수와 별개로 취급한다.
	static int b; //java 실행하자마자 기본적으로 실행됨.
	static String c; // 클래스 타입의 초기 값은 null 이다.
		
	// c = "apple"; error, 함수 안에 써야 한다.
	public static void main(String[] args) {
		int a = 100; // 지역변수(local variable), 쓰레기 값이 들어가서 초기화 해야함
		System.out.println(a);
		
		//int a; -- error : 이미 메인 함수에 a에 대한 정의가 있으므로 중복됨.
		
		System.out.println("필드 a = " + new Variable2().a);
		//System.out.println("필드 b = " + b);
		System.out.println("필드 b = " + Variable2.b);
		c = "apple"; // String 타입만 new 없이 새로 생성 가능하다. -> 리터럴 생성
		// c = new String("apple"); 위와 메모리 위치 및 사용 방법이 다름.
		System.out.println("필드 c = " + c);
		
	}

}
