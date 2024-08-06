package lmabda;

class Person02 {
	public void execute(Workable workable) { // 구현
		workable.work();
	}
	
}

public class LambdaMain02 {

	public static void main(String[] args) {
		Person02 person02 = new Person02();// 생성
		
		// 인터페이스 이므로 람다식으로 값을 넣음.
		person02.execute(() -> {
			System.out.println("안녕하세요.");
			System.out.println("나의 이름은 홍길동 입니다.");
			
		}); // 데이터 값이 workable 에 들어감
		
		// 처리하는 실행문이 1개일 경우에는 {} 를 생략할 수 있다.
		person02.execute(() -> System.out.println(" 반갑습니다. "));
		// 매개 변수 값이 없으므로 ...
		
	}

}
