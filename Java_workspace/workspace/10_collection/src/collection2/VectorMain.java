package collection2;

import java.util.Iterator; // Iterator 인터페이스를 사용하기 위해 import
import java.util.Vector; // Vector 클래스를 사용하기 위해 import

public class VectorMain { // VectorMain 클래스 선언

    public static void main(String[] args) { // 프로그램의 시작점인 main 메서드
        Vector<String> v = new Vector<String>(); // 기본 크기의 Vector 객체를 생성
        System.out.println("벡터 크기(사이즈) = " + v.size()); // 현재 벡터의 크기(사이즈)를 출력 (0, 항목이 없음)
        System.out.println("벡터 용량 = " + v.capacity()); // 현재 벡터의 용량을 출력 (기본용량 10, 항목이 들어갈 공간이 없으면 10개씩 자동으로 증가됨)
        System.out.println();
        
        System.out.println("항목 추가");
        for (int i = 1; i <= 10; i++) { // 1부터 10까지 반복
            v.add(i + ""); // 숫자를 문자열로 변환하여 벡터에 추가
            System.out.print(v.get(i - 1) + " "); // 추가된 항목을 출력 (index 는 0부터 시작하므로 i-1로 접근)
        } // for
        System.out.println();
        System.out.println("벡터 크기(사이즈) = " + v.size()); // 항목 추가 후 벡터의 크기를 출력 (10)
        System.out.println("벡터 용량 = " + v.capacity()); // 항목 추가 후 벡터의 용량을 출력 (10)
        System.out.println();
        
        System.out.println("항목 1개 추가");
        v.addElement(5 + ""); // "5"라는 문자열을 벡터에 추가 (중복 허용, 위치는 인덱스 10이 됨)
        System.out.println("벡터 크기(사이즈) = " + v.size()); // 항목 추가 후 벡터의 크기를 출력 (11)
        System.out.println("벡터 용량 = " + v.capacity()); // 항목 추가 후 벡터의 용량을 출력 (기본 용량 10에서 벡터의 크기가 10을 초과하면 자동으로 용량이 증가됨)
        System.out.println();
        
        // 벡터의 모든 요소를 출력
        for (int i = 0; i < v.size(); i++) {
            System.out.print(v.get(i) + "  "); // 모든 항목을 출력
        } // for i
        System.out.println();
        
        System.out.println("항목 5를 삭제");
        v.remove(5); // 인덱스 5에 위치한 항목을 삭제 (값 "6" 삭제)
        v.remove(5 + ""); // 값 "5"를 문자열 "5"로 변환하여 삭제 (중복된 값 중 첫 번째 "5" 삭제)
        System.out.println(v); // 벡터의 현재 상태를 출력 (toString()이 자동 호출되어 벡터의 내용이 출력됨)
        System.out.println();
        
        // Iterator 를 사용하여 벡터의 요소를 순회하면서 출력
        Iterator<String> it = v.iterator(); // 벡터의 Iterator 객체를 생성
        while (it.hasNext()) { // 다음 요소가 있는 동안 반복
            System.out.print(it.next() + "  "); // 현재 요소를 출력하고 다음 요소로 이동
        }
        System.out.println();
    }
}
