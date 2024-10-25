package class__;

public class Method01 {

	public static void main(String[] args) { // 구현 method, 호출은 JVM
			//static method 호출 - 클래스명.메소드명
			Method01.display(); // 호출
			display(); // static 이 있는 함수는 class 명을 생략할 수 있다.
			
			Method01 m = new Method01(); // static 이 없으므로 새로운 객체를 생성한다.
			m.output();
			m.display(); // display 또한 같이 사용되는데 그 이유는?

	}

		public static void display() { // 구현, 반드시 호출이 필요
			System.out.println("static method");
		}
	
		public void output() { // 구현, 반드시 호출이 필요, " 사용자 메소드 "
			System.out.println("non-static method");
		}
	
}

