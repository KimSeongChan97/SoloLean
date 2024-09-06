package array;

public class BubbleSort {

	public static void main(String[] args) {
		// 정렬할 배열을 초기화
		int [] ar = {30, 36, 25, 45, 28};
				
		// 정렬 전 배열 출력
		System.out.print("정렬 전 : ");
		for(int i=0; i<ar.length; i++) {
			System.out.print(ar[i] + " ");
		}
		System.out.println();

		
		// 버블 정렬 알고리즘
		int temp;  // 두 요소를 교환하기 위한 임시 변수
		// 배열의 길이 - 1 만큼 반복
		for (int i = 0; i < ar.length-1; i++) {   
			// 배열의 길이 - 1 - i 만큼 반복
			// 매번 큰 값이 맨 뒤로 이동하므로 비교할 범위가 줄어든다.
		    for (int j=0; j < ar.length-1-i; j++) {  
		    	// 현재 요소가 다음 요소보다 크면 교환
		        if (ar[j] > ar[j+1]) {  
		            temp = ar[j];     
		            ar[j] = ar[j+1];
		            ar[j+1] = temp;
		        }
		    }
		}
		
		// 정렬 후 배열 출력
		System.out.print("정렬 후 : ");
		for(int i=0; i<ar.length; i++) {
			System.out.print(ar[i] + " ");
		}
		System.out.println();
		
	}

}



/*









*/