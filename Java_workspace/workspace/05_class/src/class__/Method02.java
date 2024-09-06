package class__;

public class Method02 {
		
		public int sum(int a, int b){ // 구현
			return a+b; 
		}
		public int sub(int a, int b){ // 구현
			return a-b; 
		}
		public int mul(int a, int b){ // 구현
			return a*b; 
		}
		/*
		public double div(double a, double b){ // 구현
			return a/b; 
		}
		*/ // 문제가 풀리긴 하다. a 가 더 크니까..
		public double div(int a, int b){ // 구현, overload 진행된 함수 !
			return (double)a/b; // casting 
		}
		
	public static void main(String[] args) {
		//System.out.println("25 + 36 = " + sum(25, 36)); static 이 없으므로 error
		
		Method02 m = new Method02(); // 객체 생성
		System.out.println("25 + 36 = " + m.sum(25, 36)); // error 없게 하기 위해 객체 생성을 해야함
		System.out.println("25 - 36 = " + m.sub(25, 36));
		System.out.println("25 * 36 = " + m.mul(25, 36));
		System.out.println("25 / 36 = " + m.div(25, 36));
		
		
		
		
	}

}
