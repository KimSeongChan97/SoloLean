package class__;

class StaticTest {
	int a; // class 안의 필드 : 이미 초기화가 되어 있음 ( 0 ) , new 생성 필요 = 인스턴스 변수
	static int b; // class 안의 필드., new 에서 생성해야하지만, static 에서 생성되었음. = 클래스 변수
	
	static {
		System.out.println("static 초기화 영역\n");
		b = 7;
	} // static 초기화 구역
	
	public StaticTest() {
		System.out.println("default 생성자");
		this.a = 7;
	}
	public void calc() {
		a++;
		b++;
	}
	public void disp() {
		System.out.println("a = " + this.a + "\t b = " + StaticTest.b);
	}
	public static void output() {
		System.out.println("static method...");
		//System.out.println("a = " + this.a + "\t b = " + StaticTest.b); // static 영역에는 this 가 안들어간다. 별도의 공유사용
		// error - static method 에서는 static 변수만 사용 가능 -> this 를 참조할 수 없다.
	}
}
// 
public class StaticMain {
	
	public static void main(String[] args) {
		// a, b 접근 가능 한가? -> 가능하다. ( package 안의 내용 만 ! )
		//StaticTest st = new StaticTest();
		//System.out.println("a = "  + st.a);
		//System.out.println("b = "  + StaticTest.b); 
		
		StaticTest aa = new StaticTest(); // 생성자 호출 (new 하여)
		aa.calc();
		aa.disp();
		System.out.println(); // a = 인스턴스 변수, b = 클래스 변수 ( 공유변수 )
		
		StaticTest bb = new StaticTest();
		bb.calc();
		bb.disp();
		System.out.println();
		
		StaticTest cc = new StaticTest();
		cc.calc();
		cc.disp();
		System.out.println();
		
		StaticTest.output(); // 클래스명.메소드 해도 호출 가능
		aa.output(); // 객체명.메소드 해도 호출 가능.
		
		
	}

} // class StaticMain

/*

//
메소드

결과형	메소드명(매개변수형 이름, 매개변수...){ // 구현
retrunType

}
//

int sub(int a, int b){ }
void sub(int a, int b){ } // 생성자는 앞에 int / void 등과 같은 내용이 없다.

***
접근제어자(Modifier)
1. private 
2. default ( private, protected, public 를 안쓴 상태 )
3. protected
4. public

aa.a 	aa.b
bb.a	bb.b
cc.a	cc.b
 ->     static 은 공유변수 이다.

*/
