package compute;

import java.util.Scanner;

public class ComputeService {
	
	public void menu() {
		Scanner scan = new Scanner(System.in);
		int num = 0;
		Compute com = null;
		
		while(true) {
			System.out.println();
			System.out.println("*************");
			System.out.println("   1. 합");
			System.out.println("   2. 차");
			System.out.println("   3. 곱");
			System.out.println("   4. 몫");	
			System.out.println("   5. 끝내기");	
			System.out.println("*************");
			System.out.print("  번호 : ");
			num = scan.nextInt();
			
			if(num == 5) break;
			if(num == 1)
				com = new Sum(); //생성				
			else if(num == 2)
				com = new Sub();
			else if(num == 3)
				com = new Mul();
			else if(num == 4)
				com = new Div();
			
			com.execute();
		}
		
	}//menu()
}












