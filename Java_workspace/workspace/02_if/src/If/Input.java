package If;

import java.io.IOException;

public class Input {

	public static void main(String[] args) throws IOException {
		System.out.println("문자 입력 :");
		int a = System.in.read(); // 1개 문자 입력만 받는 method
		System.in.read(); // flush
		System.in.read(); // 엔터는 두글자 이기 때문에 2번의 읽음
				
		System.out.println("문자 입력 :");
		int b= System.in.read(); // 1개 문자 입력만 받는 method
				
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		
		
	}

}



