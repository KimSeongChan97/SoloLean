package for_;

import java.io.IOException;

public class For02 {

	public static void main(String[] args) throws IOException {
		System.out.print("원하는 단을 입력 : ");
		// System.in.read(); 1개의 문자로 받아들임.
		int dan = System.in.read() - 48; // 48='0'
		System.out.println();
		for(int i= 1; i<=9; i++) {
			System.out.println(dan+ " * " + i + " = " + (dan*i));
		}
		System.out.println(); 
	}
		
	
	
}

/*
  
 원하는 단을 입력 : 2 <- System.in.read();를 이용하여 출력, 변수명 dan
    
2 * 1 = 2
2 * 2 = 4
2 * 3 = 6
2 * 4 = 8
2 * 5 = 10
2 * 6 = 12
2 * 7 = 14
2 * 8 = 16
2 * 9 = 18
*/