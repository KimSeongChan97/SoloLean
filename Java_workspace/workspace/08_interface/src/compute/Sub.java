package compute;

import java.util.Scanner;

public class Sub implements Compute {
	private int x, y;
	
	public Sub() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("x의 값 입력 : ");
		x = scan.nextInt();
		System.out.print("y의 값 입력 : ");
		y = scan.nextInt();
	}

	@Override
	public void execute() {
		System.out.println(x  + " - " + y + " = " + (x-y));
	}
}
