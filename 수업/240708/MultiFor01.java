package multiFor;

public class MultiFor01 {

	public static void main(String[] args) {
		int i, j;
		
		for(i=2; i<=4; i+=2) {//i=2, i=4 2번
			
			for(j=1; j<=3; j++) {//j=1, j=2, j=3 3번
			
				System.out.println("i = " + i + "   j = " + j);
				
			}//for j
			
			System.out.println();
		}//for i

	}

}
