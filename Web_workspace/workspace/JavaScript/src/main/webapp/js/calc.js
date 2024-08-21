/*
 // 클래스 선언
public class Calc {
	// 변수 추가
	public int x = 0; // x와 y는 이 클래스의 인스턴스 변수를 선언하고 0으로 초기화
	public int y = 0;
	
	// 메서드
	public void setValue(int x, int y) { // x와 y 값을 설정하는 메서드
		this.x = x; // 클래스 변수 x에 매개변수로 받은 x 값을 할당
		this.y = y; // 클래스 변수 y에 매개변수로 받은 y 값을 할당
	}
	
	// 덧셈 메서드
	public void plus() {
		return x + y; // 클래스 변수 x와 y를 더한 값을 반환
	}
	
	// 뺄셈 메서드
	public void minus() {
		return x - y; // 클래스 변수 x와 y를 뺀 값을 반환
	}
	
	// 결과 출력 메서드
	public void result() {
		int sum = plus(); // plus 메서드를 호출해 덧셈 결과를 sum에 저장
		int sub = minus(); // minus 메서드를 호출해 뺄셈 결과를 sub에 저장
		
		// 덧셈과 뺄셈 결과를 출력
		System.out.println("덧셈 = " + sum); 
		System.out.println("뺄셈 = " + sub);
	}
}

// 객체 생성
Calc calc = new Calc(); // Calc 클래스의 객체 생성 -> Java에서 객체 생성 방식
calc.x = 25; // 객체의 x 변수에 값 할당 (실제로는 setValue 메서드를 사용하는 것이 더 나음)
*/

// JavaScript에서는 객체를 빈 객체로 생성
var calc = {}

// 멤버변수(필드) 추가
calc.x = 0; // calc 객체의 필드 x를 0으로 초기화
calc.y = 0; // calc 객체의 필드 y를 0으로 초기화

// 멤버함수(메서드) 추가
calc.setValue = function(x, y) { // setValue 메서드 정의: x와 y 값을 설정
	this.x = x; // this는 현재 객체(calc)를 가리킴, 필드 x에 매개변수 x를 할당
	this.y = y; // 필드 y에 매개변수 y를 할당
}

calc.plus = function() { // 덧셈 메서드 정의
	return this.x + this.y; // calc 객체의 x와 y 값을 더한 결과를 반환
}

calc.minus = function() { // 뺄셈 메서드 정의
	return this.x - this.y; // calc 객체의 x와 y 값을 뺀 결과를 반환
}

calc.result = function() { // 결과 출력 메서드 정의
	var sum = this.plus(); // plus 메서드를 호출해 덧셈 결과를 sum에 저장
	var sub = this.minus(); // minus 메서드를 호출해 뺄셈 결과를 sub에 저장
	
	// document.write를 사용해 웹페이지에 덧셈과 뺄셈 결과를 출력
	document.write("<div>" + sum + "</div>"); // 덧셈 결과 출력
	document.write("<div>" + sub + "</div>"); // 뺄셈 결과 출력
}

/*// 사용 예시
calc.setValue(25, 10); // x = 25, y = 10으로 설정
calc.result(); // 덧셈과 뺄셈 결과를 웹 페이지에 출력*/
