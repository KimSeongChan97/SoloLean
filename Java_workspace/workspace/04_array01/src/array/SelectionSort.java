package array;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int [] ar = {25, 36, 30, 45, 28}; // 배열 초기화
		// int[] ar;
		//ar = {25, 36, 30, 45, 28}; ---- error
		
		//초기 배열 출력
		System.out.print("정렬 전 : ");
			for(int i=0; i<ar.length; i++) {
			System.out.print(ar[i] + " ");
			}
		System.out.println();
		
		// Arrays.sort(ar); // 오름차순 정렬
		
		// Selection sort
			int temp; // 임시 변수 선언
			for(int i=0; i<ar.length-1; i++) { // 배열을 순회
				for(int j=i+1; j<ar.length; j++) { // 현재 요소 이후의 요소를 순회
					//if(ar[i] > ar[j]) { // 오름차순, 빈곳에 할당하는 temp 사용
					if(ar[i] < ar[j]) { // 내림차순 : 비교하여 현재 요소가 다음 요소보다 작으면 교환	
						temp = ar[i]; // 현재 요소를 temp에 저장
						ar[i] = ar[j]; // // 다음 요소를 현재 위치에 저장
						ar[j] = temp; //  temp에 저장된 현재 요소를 다음 위치에 저장, 교환법칙 == Arrays.sort(ar);
					}
				}
			}
		
		
		System.out.print("정렬 후 : ");
			for(int i=0; i<ar.length; i++) {
			System.out.print(ar[i] + " ");
			}
		System.out.println();
	
	}

}


/*








*/
