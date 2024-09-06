package collection; // 패키지 선언: collection 패키지에 속함

import java.util.ArrayList; // ArrayList 클래스를 사용하기 위한 import 문

public class CollectionMain2 { // CollectionMain2 클래스 선언

    public static void main(String[] args) {
        // ArrayList 생성 및 초기화
        ArrayList<String> list = new ArrayList<String>();
        list.add("호랑이"); // 인덱스 0
        list.add("사자");   // 인덱스 1
        list.add("호랑이"); // 인덱스 2, 중복 허용
        // list.add(25); // 주석 처리: 정수형 데이터 추가 불가 (타입 불일치)
        // list.add(43.8); // 주석 처리: 실수형 데이터 추가 불가 (타입 불일치)
        list.add("기린");   // 인덱스 3
        list.add("코끼리"); // 인덱스 4
        
        // 인덱스를 사용한 요소 반복
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i)); // 현재 인덱스의 요소 출력 // list 직접 지목
        }
        System.out.println("------------");
        
        // 향상된 for 루프를 사용한 요소 반복
        for (String data : list) {
            System.out.println(data); // 현재 요소 출력
        }
    }
}
