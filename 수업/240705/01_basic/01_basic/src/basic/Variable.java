package basic;

public class Variable {

	public static void main(String[] args) {
		boolean a = 25 > 36;
		System.out.println(a);
		System.out.println();
		
		char b = 'A';
		System.out.println(b);
		char c = 65;
		System.out.println(c); //A
		System.out.println();
		
		//byte d = 300; - error
		
		int e = 65;
		System.out.println(e);
		int f = 'A';
		System.out.println(f); //65
		
		long g = 25L; //long형 상수
		System.out.println();
		
		//float h = 43.8; - error
		
		//첫번째
		//float h = 43.8f; //float형 상수
		
		//두번째
		float h = (float)43.8; //Casting
		System.out.println(h);
		
	}

}









