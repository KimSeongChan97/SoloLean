package If;

import java.util.Scanner;

public class If01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("데이터 입력 : ");
		int a = scan.nextInt();
		
		if(a >= 50) System.out.println(a + "는 50보다 크거나 같다"); // 입력값이 50 이상인 경우 출력
		System.out.println(a + "는 50보다 작다");// 항상 출력
		System.out.println();
		
		// A -> C
		if(true)
			if(true) System.out.println("A");
		else System.out.println("B");
		System.out.println("C");
		System.out.println(); // 첫번째 if(true)가 항상 참이므로 내부의 if(true)실행 :: A -> C
		
		// B -> C
		if(true)
			if(false) System.out.println("A");
			else System.out.println("B");
		System.out.println("C");
		System.out.println(); // 첫번째 if(true)가 항상 참이므로 내부의 if(false)실행X, 바로 else 실행 :: B->C

		// C
		if(false)
			if(false) System.out.println("A");
			else System.out.println("B");
		System.out.println("C");
		System.out.println();// 첫번째 if(false)가 거짓이므로 내부의 실행X, 바로 else 실행 :: C				
	
		
		/* 입력한 값이 대문자이면 소문자로 바꿔서 출력하고,
		 			소문자이면 대문자로 바꿔서 출력하고
		 그외는 문자로 출력한다.
		 [실행결과]
		 데이터 입력 : 66
		 B -> b
		 
		 데이터 입력 : 98
		 b -> B
		 
		 데이터 입력 : 43
		 +
		 
		 
		*/
		if(a>='A' && a<='Z') // 65~ 90
			System.out.println((char)a + " -> " + (char)(a+32));
		else if(a>='a' && a<='z') // 97~122
			System.out.println((char)a + " -> " + (char)(a-32));
		else
		    System.out.println((char)a);
		
		
		
	}

}
