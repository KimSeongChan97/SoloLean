package array;

import java.util.Arrays;

public class Array01 {

	public static void main(String[] args) {
		int[] ar; // 배열 선언
		ar = new int[5]; // 배열 (주소) 생성 0~5
		ar[0] = 25;
		ar[1] = 36;
		ar[2] = 42;
		ar[3] = 17;
		ar[4] = 95;
		
		System.out.println("배열명 ar = " + ar); // 클래스명(Integer) @ 16진수 의 형태
		System.out.println("배열 크기 = " + ar.length); // 배열의 크기
		// System.out.println("ar[0] = " + ar[0]); // 반복을 for 문으로 변경
		
			for(int i=0; i<ar.length; i++) {
				System.out.println("ar[" + i + "] = " + ar[i]);
			} // for i 배열
		System.out.println();
			
		System.out.println("거꾸로 출력");
			for(int i=ar.length-1; i>=0; i--) {
				System.out.println("ar[" + i + "] = " + ar[i]);
			}
		System.out.println();
				
		System.out.println("홀수 데이터만 출력"); // 홀수는 2로 나누면 나머지 1
			for(int i=0; i<ar.length; i++) {
				if(ar[i]%2 == 1) 
				System.out.println("ar[" + i + "] = " + ar[i]);
				}
		System.out.println();
		
		System.out.println("첨자가 짝수인 것만 출력"); // 짝수는 2로 나누면 나머지 0, 첨자는 Index
			for(int i=0; i<ar.length; i++) {
				if(i%2 == 0)
				System.out.println("ar[" + i + "] = " + ar[i]);
			}
		System.out.println();
		
		System.out.println("오름차순 정렬");
			Arrays.sort(ar); // 결과물 받을게 없음.
			for(int i=0; i<ar.length; i++) {
				System.out.print(ar[i] + " ");
			}
		System.out.println("\n");
		
		System.out.println("확장 for 문");
			for(int data : ar) { // 배열로부터 데이터를 하나씩 받겠다는 의미. ar.length를 안써도 배열 크기 만큼 for 문이 진행된다.
				System.out.print(data + " ");
			}
		System.out.println();
		
		
	}

}
