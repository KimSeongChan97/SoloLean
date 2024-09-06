package basic;

import java.text.DecimalFormat;

//기본 패키지가 java.lang이기 때문에 아래의 문장은 쓸 필요가 없다.
// import java.lang.String;
// import java.lang.system;

public class Computel {

	public static void main(String[] args) {
		short a = 320;
		short b = 258;
		//short sum = 578; -> 명령어를 사용해야함
		//short sum = 320 + 258; 수정이 많이 들어가서 비선호 됨.
		//short sum = a + b; 578(int)로 보기 때문에 error가 나옴.
		int sum = a + b;
		int sub = a - b;
		int mul = a * b;
		//int div = a / b; 정수형만 나왔음, 소수점 이하 계산이 안됬음. a,b 둘중 하나를 실수형으로 변경 필요
		double div = (double)a / b; // 강제형변환 / 자동형변환
		
		System.out.println(a + " + " + b + " = " + sum);
		System.out.println(a + " - " + b + " = " + sub);
		System.out.println(a + " * " + b + " = " + new DecimalFormat().format(mul)); //java.lang에서 import해왔음
		System.out.println(a + " / " + b + " = " + String.format("%.2f", div)); 
		// %f 는 전체 자리수, 소수점 자리수 f 이므로 4.2 인데, 전체 자릿수는 생략이 가능하다
		// mul에서 new가 등장하였고, div는 안나왔음. 해당 함수는 객체형
		
	}

}

/*[문제] 변수를 이용하여 320(a), 258(b)의 합(sum), 차(sub), 곱(mul), 몫(div)을 구하시오

[실행결과]
320 + 258 = XXX 
320 - 258 = XXX
320 * 258 = 82560 --- > 3자리 마다 , 를 표시  320 * 258 = 82,560 
320 / 258 = 1.24031007751938 ----> 소수이하 2째자리 까지 출력하시오 320 / 258 = 1.24
 */