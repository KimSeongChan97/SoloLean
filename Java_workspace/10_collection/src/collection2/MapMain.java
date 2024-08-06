package collection2;

import java.util.HashMap;
import java.util.Map;

public class MapMain {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        
        // 키-값 쌍을 맵에 추가
        map.put("book101", "백설공주");
        map.put("book201", "인어공주");
        map.put("book102", "백설공주"); // value 중복 허용
        map.put("book301", "자스민");
        map.put("book101", "엄지공주"); // key 중복 허용, 마지막 값인 "엄지공주"가 덮어씀
        map.put("book401", "덕혜옹주");
        
        // 특정 키에 해당하는 값 출력
        System.out.println(map.get("book101")); // "book101" 키에 대한 값 출력
        System.out.println(map.get("book301"));
        System.out.println(map.get("book501")); // 없는 키는 null 반환
        System.out.println();
        
        // 맵의 모든 엔트리를 순회하며 출력
        for (Map.Entry<String, String> data : map.entrySet()) { // entrySet()으로 맵의 엔트리들을 가져옴
            String key = data.getKey(); // 엔트리의 키 가져옴
            String value = data.getValue(); // 엔트리의 값 가져옴
            
            // 키와 값을 출력
            System.out.println("Key : " + key + "\t Value : " + value);
        }
    }
}
