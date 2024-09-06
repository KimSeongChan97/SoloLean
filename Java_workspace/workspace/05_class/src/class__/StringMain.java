package class__;

public class StringMain {

	public	StringMain() { // 기본 생성자
		// 문자열 리터럴과 String 객체의 비교
				String aa = "apple"; // 문자열 리터럴
				String bb = "apple"; // 문자열 리터럴, 같은 내용의 문자열 리터럴은 메모리에 하나만 생성됩니다. 
				
				// 참조값 비교
		if(aa==bb) System.out.println("aa와 bb의 참조값은 같다.");
		else System.out.println("aa와 bb의 참조값은 다르다");
		// 문자열 내용 비교
		if(aa.equals(bb)) System.out.println("aa와 bb의 문자열은 같다.");
		else System.out.println("aa와 bb의 문자열은 다르다");
		System.out.println();
		// String 객체 생성 방법 비교
		String cc = new String("apple"); // 새로운 String 객체 생성
		String dd = new String("apple");
		// 참조값 비교
		if(cc==dd) System.out.println("cc와 dd의 참조값은 같다");
		else System.out.println("cc와 dd의 참조값은 다르다");
		// 문자열 내용 비교
		if(cc.equals(dd)) System.out.println("cc와 dd의 문자열은 같다");
		else System.out.println("cc와 dd의 문자열은 다르다");
		System.out.println();
		
		String e = " 오늘 날짜는 " + 2024 + 07 + 12 ; // String 으로 연산은 피해야 한다.
		System.out.println(" e = " + e);
		
		/*
		 "오늘 날짜는 "
		 "오늘 날짜는 2024 "
		 "오늘 날짜는 202407 "
		 e ---> "오늘 날짜는 20240712 " 주소값 전달.
		 
		 메모리가 꽉 차서 더이상 생성이 안된다면
		 -> JVM에 의해서 휴지통(Garbage Collector)으로 보낸다. 
		 -> JVM에 의해서 휴지통(Garbage Collector)으로 보내는 동안은 컴퓨터는 작동을 멈춘다. :: 관건 임... load balance 에 의해 정리 (cloud) 
		 
		 */
		// 문자열의 길이 출력
				System.out.println("문자열 크기 = " + e.length());
				
				// 특정 위치의 문자 출력
				System.out.println("5번째 위치의 문자 = " + e.charAt(5)); // 는
				
				// 부분 문자열 추출
				System.out.println("부분 문자열 추출 = " + e.substring(7)); //  "20240712 "
				System.out.println("부분 문자열 추출 = " + e.substring(7, 11)); // "2024" 7 8 9 10 <- 7번부터 11번 "이전까지"
				
				// 대소문자 변환
				System.out.println("대문자 변경 = " + "Hello".toUpperCase()); // 대문자 HELLO
				System.out.println("소문자 변경 = " + "Hello".toLowerCase()); // 소문자 hello
				
				// 문자열 검색
				System.out.println("문자열 검색 = " + e.indexOf("짜")); // 위에 String.e 에서 "짜" 가 5 번째
				System.out.println("문자열 검색 = " + e.indexOf("날짜")); //  위에 String.e 에서 "날짜" 찾기
				System.out.println("문자열 검색 = " + e.indexOf("개바부")); // -1 찾을 수 있는 게 없으면 -1로 표기됨.
				
				// 문자열 치환
				System.out.println("문자열 치환 = " + e.replace("날짜", "일자")); // 앞에 "날짜"를 뒤에 "일자" 로 변경
		
		}
		
	public static void main(String[] args) {
		// StringMain 객체 생성하여 생성자 호출
		new StringMain();
		
		
	}

}


/*
 코드 설명:
문자열 리터럴과 String 객체 비교
String aa = "apple";와 String bb = "apple";에서 aa와 bb는 동일한 문자열 리터럴을 가리킵니다. Java는 문자열 리터럴이 동일할 경우 메모리에서 공유하므로 참조값 비교(==)는 true를 반환합니다.
equals() 메서드를 사용하여 문자열 내용 비교를 할 경우에도 true를 반환합니다.

새로운 String 객체 생성
String cc = new String("apple");과 String dd = new String("apple");에서는 새로운 String 객체가 각각 생성됩니다. 따라서 cc == dd는 false가 되고, 
cc.equals(dd)는 true가 됩니다. 이는 각각의 객체는 서로 다른 메모리 공간을 차지하게 되기 때문입니다.

문자열 연결 시 주의사항
String e = " 오늘 날짜는 " + 2024 + 07 + 12 ;에서는 숫자와 문자열이 함께 연결되어 있습니다. 
Java에서는 이렇게 문자열을 연결할 때 연산자 +가 왼쪽에서 오른쪽으로 순차적으로 실행되므로, 연결된 결과는 " 오늘 날짜는 20240712 "가 됩니다.

기타 문자열 메서드 활용
e.length()는 문자열의 길이를 반환합니다.
e.charAt(5)는 문자열에서 5번째 위치의 문자를 반환합니다.
e.substring(7)는 문자열에서 7번째 위치부터 끝까지의 부분 문자열을 반환합니다.
e.substring(7, 11)는 문자열에서 7번째부터 10번째 위치까지의 부분 문자열을 반환합니다.
"Hello".toUpperCase()는 문자열을 모두 대문자로 변환하여 반환합니다.
"Hello".toLowerCase()는 문자열을 모두 소문자로 변환하여 반환합니다.
e.indexOf("짜"), e.indexOf("날짜"), e.indexOf("개바부")는 각각 문자열에서 해당 문자열이 위치하는 인덱스를 반환합니다. 만약 찾는 문자열이 존재하지 않으면 -1을 반환합니다.
e.replace("날짜", "일자")는 문자열에서 첫 번째 매개변수로 전달된 문자열을 찾아 두 번째 매개변수로 전달된 문자열로 치환한 결과를 반환합니다.
  
  */
