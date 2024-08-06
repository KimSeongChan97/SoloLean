package basic;

public class Variable {

	public static void main(String[] args) {
		System.out.println(25 < 36); //true 지만 1이라고 생각하는 java
		System.out.println(25 > 36); //false
		System.out.println();
		
		boolean a = 25 > 36; // =은 오른쪽의 결과가 왼쪽에 "대입"한다. 즉, a=0의 1bit를 사용한다.
		System.out.println(a); // "문자열"은 못들어감, 결과는 거짓.
		System.out.println();
		
		char b = 'A'; // 16bit = 2byte
		System.out.println(b); // 결과는 A
		char c = 65; // char 함수의 문자이므로
		System.out.println(c); // 결과는 A
		System.out.println();
		
		//byte d = 300; - error : int(4byte=32bit) 의 값으로 보기에 error
		
		int e = 65;
		System.out.println(e);
		int f = 'A'; // 문자가 아닌 65로 본다.
		System.out.println(f); // 65
		System.out.println();
		
		long g = 25L; // 기본이 int 형태, long 형 상수로 취급시 숫자 뒤에 L 을 붙이면 된다.
		System.out.println();
		
		//float h = 43.8; double 타입과 안맞음
		//float h = 43.8; - error 해결 방법
		// 해결 첫번째
		float h = 43.8F; // float형 상수로 변경
		
		// 해결 두번째
		float h1 = (float)43.8; // Casting 강제형변환 사용
		System.out.println();
		
	}

}
