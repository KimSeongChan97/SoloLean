package collection; // 패키지 선언: collection 패키지에 속함

import java.util.ArrayList; // ArrayList 클래스를 사용하기 위한 import 문
import java.util.Collection; // Collection 인터페이스를 사용하기 위한 import 문
import java.util.Iterator; // Iterator 인터페이스를 사용하기 위한 import 문

public class CollectionMain { // CollectionMain 클래스 선언

    @SuppressWarnings("all") // 경고를 모두 무시하도록 설정
    public static void main(String[] args) { 
        // implements 키워드는 클래스가 특정 인터페이스를 구현할 때 사용

        // Collection 인터페이스 타입의 변수를 선언하고, ArrayList 객체를 할당
        // ArrayList는 Collection 인터페이스를 구현한 클래스 중 하나
        Collection coll = new ArrayList(); 
        
        // Collection에 요소 추가
        coll.add("호랑이"); // 인덱스 0
        coll.add("사자");   // 인덱스 1
        coll.add("호랑이"); // 인덱스 2, 중복 허용
        coll.add(25);       // 인덱스 3, 정수형 데이터
        coll.add(43.8);     // 인덱스 4, 실수형 데이터
        coll.add("기린");   // 인덱스 5
        coll.add("코끼리"); // 인덱스 6
        
        // Iterator 객체 생성
        Iterator it = coll.iterator(); // get(i)를 못하기 때문에...
        
        // 요소 반복
        while (it.hasNext()) { // 컬렉션에 다음 요소가 있는 동안 반복
            System.out.println(it.next()); // 현재 요소를 출력하고 다음 요소로 이동
        }
    }
}

/*
1. implements
=> 모든 추상 메서드를 Override 해야함.

2. 대신 Override 해주는 클래스

3. 메서드 제공

iterator
it.hasNext() : 현재 위치에 항목이 있으면 true, 없으면 false 반환
it.next() : 현재 위치의 항목을 꺼내서 버퍼에 기억시키고, 다음 항목으로 이동
*/
