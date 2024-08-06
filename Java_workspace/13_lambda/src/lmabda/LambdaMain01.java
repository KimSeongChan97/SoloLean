package lmabda;

public class LambdaMain01 {
		
	public void execute(Compute compute) { // 매개변수를 Compute 로 받음. , 구현
		int x = 25 ;
		int y = 36;
		
		compute.calc(x, y); // 메소드 호출
	}
	
		
	public static void main(String[] args) {
		LambdaMain01 lambdaMain01 = new LambdaMain01(); // 객체 생성
		
		lambdaMain01.execute((x, y) -> {
			int result = x + y;
			System.out.println(x + " + " + y + " = " + result);
			
		}); // compute 의 값을 불러와야 함. [ execute(데이터의 값) ]
		// lambdaMain01.execute(new Compute()); class 가 아니기 때문에 불가능 (인터페이스는 new 불가능)
		// 인터페이스에 익명 이너 클래스가 나타나서 인터페이스에 있는 모든 값을 오버라이딩 해야함. [ {} ]
		// 이걸 람다식으로 변형하여 쉽게 해결. {} 에 처리할 값을 입력
		
		lambdaMain01.execute((x,y) -> {
			int result = x * y;
			System.out.println(x + " * " + y + " = " + result);
		}); // 같은 인터페이스 지만 입력할 때 마다 데이터 입력(처리부)를 변경하여 원하는 값을 얻을수 있음.
		
	}

}
