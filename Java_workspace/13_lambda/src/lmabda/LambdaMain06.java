package lmabda;

@FunctionalInterface
interface Comp { 
	public int compare(String name, String irum); // 두개의 문자열을 비교하는 compare 
	// , 음수이거나 0이거나 양수가 떨어짐.
}
//----------------------

class Person06 {
	public void order(Comp comp) {
		String name = "홍길동"; // 홍길동, 둘리, 코난 으로 비교
		String irum = "코난";
		int result = comp.compare(name, irum); // interface 와 전닳하여 값을 연결
		
			if(result < 0) 
				System.out.println(name + ", " + irum);
				else if (result > 0)
					System.out.println(irum + ", " + name);
				else
					System.out.println("같은 이름입니다.");
			
	}
}

//--------------
public class LambdaMain06 {

	public static void main(String[] args) {
		Person06 person06 = new Person06();
		
		// String 클래스의 compareTo 메소드를 사용. ( method 만 호출 )
		person06.order((name, irum) -> name.compareTo(irum)); // compare 값을 넣음
		System.out.println();
		// :: 형식으로 변경 가능 ( method 만 호출 하므로 ), String 이라는 static 함수 이므로 가능 !
		person06.order(String :: compareTo);
		
	}

}
