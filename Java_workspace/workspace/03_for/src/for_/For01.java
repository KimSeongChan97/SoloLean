package for_;

public class For01 {

	public static void main(String[] args) {
		/* for(A;B;c) {
			D;
			}
			E   //A->B(조건) -> [D -> C -> B(조건)] 반복. -> 거짓일 때 E
		*/
		
		/*System.out.println("Hello Kitty!!");
		System.out.println("Hello Kitty!!");
		System.out.println("Hello Kitty!!");
		System.out.println("Hello Kitty!!"); // 단순한 반복
		System.out.println();
		*/		
		int i; // 지역변수 i (local variable)
		for(i = 1; i<=10; i++) {
			System.out.println("Hello Kitty!!  " + i);
		} // i가 10번 반복, i는 값이 1씩 증가
		// System.out.println("탈출 i =" + i); i 의 값이 11일때 벗어남. 또한, {구역}까지에서만 i 가 존재한다.
		System.out.println("탈출 i =" + i);		
		System.out.println();
		
		// 10 9 8 7 6 5 4 3 2 1
		for(i= 10; i>=1; i--) {
			System.out.print(i + " ");
		}		
		System.out.println();
		
		// A B C D E F G ~ X Y Z
		for(i='A'; i<='Z'; i++) {
			System.out.print((char)i + " ");
		}
		System.out.println();
		
	}

}

/*
 local variable (지역변수)
 - { 구역 } 안에서 선언된 변수
 - { 구역 } 을 벗어나면 소멸된다.
  
 */
