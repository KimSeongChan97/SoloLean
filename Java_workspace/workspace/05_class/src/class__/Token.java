package class__;

import java.util.StringTokenizer;

public class Token {

    public static void main(String[] args) {
        // 초기 문자열 선언
        String str = "학원,집,,게임방";

        // StringTokenizer 객체를 생성하여 문자열을 ','를 기준으로 분리 << 주로 쓰임
        StringTokenizer st = new StringTokenizer(str, ",");
        // 토큰의 개수를 출력
        System.out.println("토큰 개수 = " + st.countTokens());

	        // 더 이상 토큰이 없을 때까지 반복하며 각 토큰을 출력
	        while (st.hasMoreTokens()) {
	            System.out.println(st.nextToken());
	        }

        System.out.println("------------------");

        // 문자열을 ','를 기준으로 분리하여 배열에 저장 << 주로 쓰임
        String[] ar = str.split(","); // split 은 배열로만 꺼내온다.

	        // 배열의 각 요소를 출력
	        for (String data : ar) {
	            System.out.println(data);
	        }
    }
}
