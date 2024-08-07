package basic;

import java.util.Random;

public class Variable3 {
	
	public static void main(String[] args) {
		int big = Math.max(25, 36);
		System.out.println("큰값 = " + big);
		
		//12.7, 78.5중에서 작은값을 구하시오
		double small = Math.min(12.7, 78.5);
		System.out.println("작은값 = " + small);
		
		//2의 5승 
		double power = Math.pow(2, 5);
		System.out.println("2의 5승 = " + power);
		
		//난수
		//컴퓨터가 불규칙하게 발생하는 수
		// 0 <= 난수 < 1
		double a = Math.random();
		int c = (int)(a * 100); // 0 ~ 99
		
		// x~y사이의 난수 발생
		// (int)(Math.random() * (y-x+1) + x)
		int d = (int)(Math.random() * 26 + 65); //65 ~ 90 사이의 난수
		char e = (char)(Math.random() * 26 + 65);
		
		System.out.println(a);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println();
		
		double b = new Random().nextDouble();
		System.out.println(b);
		
	}

}














