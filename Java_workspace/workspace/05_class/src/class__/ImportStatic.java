package class__;

//import static java.lang.Math.random; // import static 으로 미리 선언.
//import static java.lang.Math.pow;
import static java.lang.Math.*; // * 는 모든 것(wild card),(all) 비추..
import static java.lang.System.out; // error 안걸리지만 비추
import static java.util.Arrays.sort;

import java.util.Arrays;

public class ImportStatic {

	public static void main(String[] args) {
		out.println("난수 = " + random()); // 0~1 사이의 난수 ,math 클래스가 앞에 오므로 static 변수이다.
		out.println("2의 5승 = " + pow(2, 5)); // Math 클래스지만, import 를 통해 지울 수 있다.
		
		int[] ar = {25, 78, 32, 40, 55};
		sort(ar); // Arrays.sort 에서 Arrays 삭제 할시..
		for (int data : ar) 
			out.print(data + "  "); // 1줄만 함수 사용 할시 { } 삭제
		
		out.println();
		
		String[] ar2 = {"apple", "strawberry", "Applemango", "pineapple", "tomato"};
		sort(ar2); // Arrays.sort 에서 Arrays 삭제 할시..
		for (String data : ar2) 
			out.print(data + "  "); // 1줄만 for 사용 할시 { } 삭제
		
		
	}

}
