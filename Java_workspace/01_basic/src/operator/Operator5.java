package operator;

public class Operator5 {

	public static void main(String[] args) {
		boolean a = 25 > 36;
		System.out.println("a= " + a);
		System.out.println("!a= " + !a);
		System.out.println();
		// String 변수->객체
		String b = "apple"; // 문자가 아닌 주소를 줌.
		String c = "apple"; // 이미 b에서 잡았으므로 c는 잡히지 않는다. 결국 b와 c 둘다 "apple"을 저장.
		String d = new String("apple"); // 새로운 주소로 잡힌다.
		
		System.out.println("b == c " + (b == c ? "같다" : "다르다"));//주소 비교
		System.out.println("b == d " + (b == d ? "같다" : "다르다"));//주소 비교
		System.out.println();
		
		System.out.println("b.equals(c) : " + (b.equals(c) ? "같다" : "다르다"));//문자열 자체를 비교
		System.out.println("b.equals(d) : " + (b.equals(d) ? "같다" : "다르다"));//문자열 자체를 비교
		System.out.println();
		
		System.out.println("!b.equals(c) : " + (!b.equals(c) ? "같다" : "다르다"));//문자열 자체를 비교
		System.out.println("!b.equals(d) : " + (!b.equals(d) ? "같다" : "다르다"));//문자열 자체를 비교
		System.out.println();
						
	}

}
