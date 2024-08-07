package operator;

import java.util.Scanner;

public class Operator02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("점수 입력 : ");
		int score = scan.nextInt();
		
		String result = score>=80 && score<=100 ? "합격" : "불합격";
		//System.out.println( score>=80 && score<=100 ? "합격" : "불합격" );
		
		System.out.println(result);
	}

}

/*
[문제] 점수를 입력하여 합격인지 불합격인지 판별하는 프로그램
점수가 80~100 사이면 합격으로 한다.

 */
