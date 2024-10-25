package multiArray;

public class MultiArray02 {

	public static void main(String[] args) {
		int[][] ar = new int[10][10]; // 10행 10열의 2차원 정수 배열 생성
        int num = 0; // 정수 값 초기화
        
	       /*
	        // 입력방식 1 : 배열에 순차적 값 할당 1 ~ 100 (행 우선)
	        for (int i = 0; i < ar.length; i++) { // 행
	            for (int j = 0; j < ar[i].length; j++) { // 열
	                num++; // num 값을 1 증가시킴
	                ar[i][j] = num; // num 값을 배열의 요소에 할당
	            }
	        }
	      
	        // 입력방식 2 : 열 기준으로 할당 ( 열 기준 )
	        for (int i = 0; i < ar.length; i++) { // 행
	            for (int j = 0; j < ar[i].length; j++) { // 열
	                num++; // num 값을 1 증가시킴
	                ar[j][i] = num; // num 값을 배열의 요소에 할당
	            }
	        }
	        
	        */
        
        	// 입력방식 3 : 역순으로 할당 (100~1) ( 역순 )
	        for (int i =ar.length-1; i >=0; i--) { // 행
	            for (int j =ar.length-1; j >=0; j--) { // 열
	                num++; // num 값을 1 증가시킴
	                ar[i][j] = num; // num 값을 배열의 요소에 할당
	            }
	        }
	        
	        // 출력
	        for (int i = 0; i < ar.length; i++) { // 행
	            for (int j = 0; j < ar[i].length; j++) { // 열
	                System.out.print(String.format("%5d", ar[i][j])); // 각 요소를 5자리로 출력
	            }
	            System.out.println(); // 한 행 출력이 끝나면 줄바꿈
	        }
	        
    }

}
