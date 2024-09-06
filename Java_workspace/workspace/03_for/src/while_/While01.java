package while_;

public class While01 {

	public static void main(String[] args) {
		/*
		
		 초기값
		 while(조건) {                  do{
		참 일때(증감)
			}                         }while(조건);
		=> 거짓                          => 거짓
		
		 */
		int a=0;
		// 1 2 3 4 5 6 7 8 9 10
		while(a<10) {
			a++; // 1 2 ~ 9 10 
			System.out.print(a + "  ");
			} // while 문장
		System.out.println();
		// 1 2 3 4 5 6 7 8 9 10
		int b=1;
		while(true) {
			System.out.print(b + "  ");
			b++;
			if(b > 10 ) break;
			} // true
		}

}
