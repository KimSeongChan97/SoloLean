package class__;

public class VarArgs {

	/*
	public int sum(int a, int b) {
		return a+b;
	}
	public int sum(int a, int b, int c) {
		return a+b+c;
	}
	public int sum(int a, int b, int c, int d) {
		return a+b+c+d;
	}
	*/
	// 인수의 파라매터 개수를 자유롭게
	// 가변 인자를 사용하여 여러 개의 정수를 받아 그 합을 반환하는 메서드
		public int sum(int... ar) { // " ... "  자유롭게 , 내부적으로 배열 인식하여 적용.
			int hap = 0;
			for (int i=0; i<ar.length; i++) {
				hap += ar[i];
			} // for i
			return hap;
		}
	
	public static void main(String[] args) {
		VarArgs va = new VarArgs(); // 생성자 부름. 생성자를 미리 만든 적이 없는데 error 가 안뜨는 이유는 
									//클래스 안에 생성자가 하나도 없을 시에는 자동으로 기본(default) 생성자 호출
									// 기본 생성자 : 인수가 없는 메소드
		System.out.println("합 = " + va.sum(10, 20)); // static 이 아님
		System.out.println("합 = " + va.sum(10, 20, 30));
		System.out.println("합 = " + va.sum(10, 20, 30, 40));
		
		
	}

}


/*



*/
