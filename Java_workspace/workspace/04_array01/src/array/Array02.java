package array;

import java.util.Arrays;

public class Array02 {

	private static char[] data;

	public static void main(String[] args) { // run as 에서 데이터를 주고 시작 (* 호랑이 / 기린 등 )
		for(int i=0; i<args.length; i++) {
			System.out.println("args[" + i +"] = " + args[i]);
			System.out.println("문자열의 크기 = " + args[i].length());
			System.out.println("첫 번째 문자 = " + args[i].charAt(0));
			System.out.println("마지막 문자 = " + args[i].charAt(args[i].length()-1)); 
			System.out.println(); 
			} // for i
		System.out.println();
		
		System.out.println("확장 for문");
			for(String data : args) {
				System.out.println(data); // 현재 저장된 data
			}
		System.out.println("\n");
			
			System.out.println("오름차순 정렬");
			Arrays.sort(args); {
				System.out.println(data);
			}
	}

}

/*
System.out.println("args[0] = " + args[0]); 
System.out.println("args[1] = " + args[1]);
*/

/*
class Test {
	int a; // 필드, 인스턴스 변수
	static int c; // 필드, 클래스 변수

	public static void main(String[] args) { // []은 함수의 괄호 안에 들어옴, 선언된 변수를 매개변수(parameter) 라고 부른다.
	 																			/ 인수(argument)
		int b; // 변수
	
		for(int i=1; ~ ) {
		} // 지역변수	
	
	}

}
*/

/*

	public class Example {
	public static void main(String[] args) {
		    // "Alice"는 인수
		    greet("Alice");
		}
	
		// String name은 매개변수
			public static void greet(String name) {
			    System.out.println("Hello, " + name);
			}
	}
*/