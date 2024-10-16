package com.el;

public class Compute {
	// 메서드 이름은 sum 이고, 2개의 파라메터(문자열)를 받아서 합을 리턴하는 메서드 이다.
	// -> 메서드 이름이 `sum`이며, 두 개의 문자열(String)을 입력으로 받아 그 문자열을 숫자로 변환한 뒤, 합을 계산하고 반환하는 메서드입니다.
	// -> 두 입력값은 문자열로 전달되지만, 그 값을 더하려면 문자열을 정수(int)로 변환한 후 연산을 진행합니다.

	public static int sum(String x, String y) {
		// x와 y는 각각 문자열로 전달되며, 내부적으로 정수로 변환되어 덧셈 연산이 수행됩니다.
		
		// `Integer.parseInt(x)`는 문자열 x를 정수로 변환합니다.
		// 예를 들어, "5"라는 문자열이 전달되면 5라는 정수로 변환됩니다.
		// 만약 전달된 문자열이 숫자가 아닌 경우(NumberFormatException이 발생할 수 있음), 오류가 발생할 수 있습니다.
		// x와 y 각각의 값을 정수로 변환한 후 더하고, 그 결과를 반환합니다.
		// 여기서 중요한 점은 두 문자열이 모두 숫자 형식이어야 한다는 것입니다. 예를 들어, "10"과 "20"이 전달되면 30이 반환됩니다.
		
		return Integer.parseInt(x) + Integer.parseInt(y);
		// -> 최종적으로 변환된 두 정수 값을 더한 후 반환(return)합니다.
		// -> 반환값의 타입은 int이며, 이 메서드는 정수의 합을 호출한 쪽에 돌려줍니다.
	}
	
	public static int sub(String x, String y) {
		return Integer.parseInt(x) - Integer.parseInt(y);
	}
	
	// 요약:
	// 1. 이 메서드는 두 개의 문자열을 입력으로 받습니다.
	// 2. 각 문자열을 정수로 변환합니다.
	// 3. 변환된 정수를 더한 후 그 결과를 반환합니다.
	// 4. 반환된 값은 int 타입입니다.
}

 