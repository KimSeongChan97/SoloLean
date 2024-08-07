package basic;

public class HelloTest {
	
	public static void main(String[] args) {
		System.out.println("안녕하세요");
		System.out.println();
		
		System.out.println('A' + 32);
		System.out.println((char)('A' + 32)); //강제형변환, Cast
		System.out.println();
		
		System.out.println(2 + 3);
		System.out.println('2' + '3'); //101
		
		//결과가 5가 나오도록 하시오
		System.out.println('2'-48 + '3'-48);
		
		System.out.println("2" + "3"); //23
		
		//결과가 5가 나오도록 하시오
		System.out.println(Integer.parseInt("2") + Integer.parseInt("3"));
		System.out.println();
		
		System.out.println("12.5" + "36.8");
		
		//결과가 49.3가 나오도록 하시오
		System.out.println(Double.parseDouble("12.5") + Double.parseDouble("36.8"));
	}
}














