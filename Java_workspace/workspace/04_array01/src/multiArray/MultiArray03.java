package multiArray;

public class MultiArray03 {

	public static void main(String[] args) {
		int[][] ar = {{1, 2, 3, 0}, {4, 5, 6, 0}, {7, 8, 9, 0}, {0, 0, 0, 0}}; // 2차원 배열 초기화
		
			//행의 합 구하는 계산
			for (int i=0; i<ar.length-1; i++) { // 마지막 행과 열은 합을 구하지 않음
				for (int j=0; j<ar[i].length-1; j++ ) { // 마지막 열은 합을 구하지 않음
					ar[i][3] += ar[i][j]; // 각 행의 합을 배열의 마지막 열(ar[i][3])에 저장
					ar[3][i] += ar[j][i];  // 각 열의 합을 배열의 마지막 행(ar[3][i])에 저장
				//	ar[3][j] += ar[i][j]; 위와 같지만 다른 방식
					ar[3][3] += ar[i][j]; // // 전체 요소의 합을 배열의 마지막 요소(ar[3][3])에 저장
					
				}
			}
			//출력
			for (int i = 0; i < ar.length; i++) { // 행
	            for (int j = 0; j < ar[i].length; j++) { // 열
	                System.out.print(String.format("%5d", ar[i][j])); // 각 요소를 5자리로 출력
	            }
	            System.out.println(); // 한 행 출력이 끝나면 줄바꿈
			}
	}

}
