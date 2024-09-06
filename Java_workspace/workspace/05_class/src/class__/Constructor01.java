package class__;

public class Constructor01 {
		
	private String name; // 기본값 null 초기화
	private int age; // 기본값 0 초기화
	
	
	public Constructor01() { // () 안에 아무 것도 없는 것이 기본 생성자
		System.out.println("기본 생성자");
		System.out.println("this = " + this); // class 객체 주소값을 연결
	}
	
	/*
	 public void Constructor01() { // () 안에 아무 것도 없는 것이 기본 생성자
		System.out.println("기본 생성자"); // 생성자를 'void' 로 취급을 박탈.
	}
	 */
	
	public Constructor01(String name) {
		this();
		System.out.println("Constructor01(String name)");
		this.name = name;
		
	}
	
	public Constructor01(int age) { // 생성자 overload 된 생성자끼리는 호출이 가능하다.
		this("코난"); // overload 된 생성자(외부X)를 호출 가능함. - 전제조건 : 반드시 첫번째 줄.
		System.out.println("Constructor01(int age)");
		this.age = age;
		
	}
	
	public static void main(String[] args) {
		
		Constructor01 aa = new Constructor01(); // 생성자를 호출.
		System.out.println("aa = " + aa); // aa 의 객체 주소값을 불러옴.
		System.out.println(aa.name + ", " + aa.age);
		System.out.println();
		
		Constructor01 bb = new Constructor01("홍길동"); // 처리할 생성자가 필요함.
		System.out.println(bb.name + ", " + bb.age);
		System.out.println();
		
		Constructor01 cc = new Constructor01(25); // 생성자 필요함.
		System.out.println(cc.name + ", " + cc.age);
		System.out.println();
		
		
		
	}

}


