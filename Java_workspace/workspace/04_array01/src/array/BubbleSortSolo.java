package array;

public class BubbleSortSolo {

	public static void main(String[] args) {
		// 정렬할 배열을 초기화
		int [] ar = {30, 36, 25, 45, 28};
		
		// 정렬 전 배열 출력
		System.out.print("정렬 전 : ");
		for(int i=0; i<ar.length; i++) {
			System.out.print(ar[i] + " ");
		}
		System.out.println();

		
		// 버블 정렬 알고리즘 (내림차순 정렬)
		int temp;  // 두 요소를 교환하기 위한 임시 변수
		// 배열의 길이 - 1 만큼 반복
		for (int i = 0; i < ar.length - 1; i++) {   
			// i 다음 위치부터 배열의 끝까지 반복
		    for (int j = i + 1; j < ar.length; j++) {  
		    	// 현재 요소(ar[i])가 다음 요소(ar[j])보다 작다면 교환
		        if (ar[i] < ar[j]) {  
		            temp = ar[i];     // 임시 변수를 사용하여 요소를 교환
		            ar[i] = ar[j];
		            ar[j] = temp;
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
