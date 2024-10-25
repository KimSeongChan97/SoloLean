package multiArray;

public class MultiArray01 {

	public static void main(String[] args) {
		int[][] ar;
		// int ar[][]; 이렇게 해도 된다.
		ar = new int[3][2]; // 3행 2열의 2차원 정수 배열을 생성
		/*
		 	ar[0][0]  ar[0][1]
			ar[1][0]  ar[1][1]
			ar[2][0]  ar[2][1]	열
				행	
		 */
		ar[0][0] = 10;
		ar[0][1] = 20;
		
		ar[1][0] = 30;
		ar[1][1] = 40;
		
		ar[2][0] = 50;
		ar[2][1] = 60;
		
		System.out.println("배열명 ar = " + ar);
		for(int i=0; i<ar.length; i++) { // 행
			
			System.out.println("ar[" + i + "] = " + ar[i]); // 각 배열의 행마다 주소를 가지고 있다.
			for(int j=0; j<ar[i].length; j++) { // 열
				System.out.println("ar[" + i + "][" + j + "] = " + ar[i][j]); // ar[i][j] 가 data를 가진다.
				
			}
			System.out.println();
		}
		
	}

}

/*
 
 
 
 
 
 
 */
