package operator;

public class BitOperator {

	public static void main(String[] args) {
		int a = +16; // 변수 'a' 의 값에 16 할당
		
		System.out.println("+16 = " + a);
		System.out.println("+16 = " + Integer.toBinaryString(a)); // 'a'를 2진수 문자열로 변환하여 출력. 2진수로 16은 '10000'.
		System.out.println();
				
		System.out.println("~16 = " + ~a); // 1의 보수('a'의 비트 반전 값을 출력. 비트 반전은 모든 비트를 반전시킴.)
		System.out.println("~16 = " + Integer.toBinaryString(~a)); // 위의 2진수 0->1 변환
		System.out.println();
		
		System.out.println("-16 = " + (~a+1)); // 'a'의 2의 보수를 출력. 2의 보수는 1의 보수에 1을 더하여 얻음.
		System.out.println("-16 = " + Integer.toBinaryString(~a+1)); // 위의 1의 보수에서 +1 한 값 (2의 보수 결과를 2진수 문자열로 변환하여 출력.)
		System.out.println();
		
		
		
	}

}

/*
+16 = 16
+16 = 1 0000

~16 = -17
~16 = 1111111111111111111111111110 1111

-16 = -16
-16 = 1111111111111111111111111111 0000
*/