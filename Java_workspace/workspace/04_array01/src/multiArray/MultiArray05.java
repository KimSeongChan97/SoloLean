package multiArray;

public class MultiArray05 {

	public static void main(String[] args) {
		//다차원 배열 - 가변길이(ex.영화관 좌석)
		int[][] ar = new int[3][]; // 행은 들어가야 하지만, 열의 값은 가변이다.
		ar[0] = new int[2];
		ar[1] = new int[3];
		ar[2] = new int[4];
		
		ar[0][0] = 10;
		ar[0][1] = 20;
		
		ar[1][0] = 30;
		ar[1][1] = 40;
		ar[1][2] = 50;
		
		ar[2][0] = 60;
		ar[2][1] = 70;
		ar[2][2] = 80;
		ar[2][3] = 90;
		
		
			for(int i=0; i<ar.length; i++) { // 행
			for(int j=0; j<ar[i].length; j++) { // 열
				System.out.println("ar[" + i + "][" + j + "] = " + ar[i][j]); // ar[i][j] 가 data를 가진다.
				
			}
			System.out.println();
		}
	
	}

}


