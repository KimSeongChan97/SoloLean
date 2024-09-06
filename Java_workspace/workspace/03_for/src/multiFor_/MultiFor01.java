package multiFor_;

public class MultiFor01 {

	public static void main(String[] args) {
		/*
		다중 for 문
			- for 문 안에 또 다른 for 문이 존재하는 것
			- for 문에 사용되는 변수 명은 서로 달라야 한다.
			- 겹쳐서도 안된다.
		for (i ~ ) {
    			for (j ~ ) {
   					}
				}
		   위의 형태를 이중 포문이라 한다.
		*/
		int i, j;
	
		for(i=2; i<=4; i+=2) { // i=2, i = 4 2번
			
			for(j=1; j<=3; j++) { // j = 1, j = 2, j = 3 3번
				System.out.println("i = " + i + "  j = " + j);
				
			} // for j ( 분 ) , 초를 구성할때는 for j 안에 들어감. = 삼중포문 
			System.out.println();
		} // for i , 시계와 비슷한 구성의 개념 ( 시 )
		
	}

}
