package if_;

import java.io.IOException;

public class Input {

	public static void main(String[] args) throws IOException {
		System.out.print("문자 입력 : ");
		int a = System.in.read(); //1개 문자 입력
		System.in.read(); //flush
		System.in.read();
		
		System.out.print("문자 입력 : ");
		int b = System.in.read(); //1개 문자 입력
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);

	}

}























