package collection2; // collection2 패키지에 속한 클래스

import java.util.HashSet; // HashSet 클래스를 사용하기 위해 import
import java.util.Iterator; // Iterator 인터페이스를 사용하기 위해 import
import java.util.Set; // Set 인터페이스를 사용하기 위해 import

public class SetMain {

    public static void main(String[] args) {
        // Set<> set = new Set(); // 인터페이스는 인스턴스화할 수 없기 때문에 주석 처리

        // Set 인터페이스를 구현한 HashSet 클래스의 객체를 생성(Generic Type)
        Set<String> set = new HashSet<>();
        
        // Set에 요소를 추가
        set.add("호랑이"); // "호랑이" 문자열을 Set에 추가
        set.add("사자");   // "사자" 문자열을 Set에 추가
        set.add("호랑이"); // "호랑이" 문자열을 Set에 추가 (중복 허용되지 않음), 순서 X
        set.add("기린");   // "기린" 문자열을 Set에 추가
        set.add("코끼리"); // "코끼리" 문자열을 Set에 추가
        
        // Set의 요소들을 순회하기 위해 Iterator 객체를 생성
        Iterator<String> it = set.iterator();
        
        // Iterator를 사용하여 Set의 요소들을 하나씩 출력
        while(it.hasNext()) { // 다음 요소가 있는지 확인, hasNext는 boolean 값 반환: 순회할 다음 요소가 있으면 true,, 요소 없으면 false
            System.out.println(it.next()); // 다음 요소를 출력
        }
    }

}
