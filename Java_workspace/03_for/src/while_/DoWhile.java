package while_;

public class DoWhile {

	public static void main(String[] args) {
		/*
		
		 초기값
		 while(조건) {                  do{
		참 일때(증감)
			}                         }while(조건);
		=> 거짓                          => 거짓
		
		 */
		
		// A B C D E F G ~ X Y Z
		
			char ch = 'A';
			
			int count = 0; // 알파벳 수 변수
			
			do {
				System.out.print(ch++ + " ");
				count++; // 1 2 3 4 ~ ...
				
				if(count%7==0) {
					System.out.println(); // 7로 나누면 나머지가 0일때가 7의 배수로 조건을 걸 수 있음.
				}
				
				}while(ch<='Z');
			System.out.println();
	}

}


/*
 [문제] A~Z 출력하되, 1줄에 7개씩 출력하시오.
 
 
 [결과]
 A B C D E F G H
 
 I J K L M N O P
 
 Q R S T U V W X
 Y Z 
 
 */

