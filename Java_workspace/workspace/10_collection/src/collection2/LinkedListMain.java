package collection2; // collection2 패키지에 속한 클래스

import static java.lang.System.out; // System.out 객체를 'out'으로 간단히 사용하기 위해 static import

import java.util.LinkedList; // LinkedList 클래스를 사용하기 위해 import

public class LinkedListMain { // LinkedListMain 클래스를 선언

    public static void main(String[] args) { // 프로그램의 시작점인 main 메서드
        // 문자열 배열을 선언 및 초기화
        // 각 요소는 자동차의 모델 이름입니다.
        String[] item = {"소나타", "렉스톤", "제규어"};
        
        // LinkedList 객체를 생성
        // LinkedList는 큐와 스택의 기능을 제공하는 자료구조입니다.
        LinkedList<String> q = new LinkedList<String>();
        
        // for-each 루프를 사용하여 배열의 요소를 큐에 추가
        // 배열 item의 각 요소를 순회하며 큐 q에 추가합니다.
        for (String n : item)
            q.offer(n); // offer 메서드를 사용하여 요소를 큐의 끝에 추가
        
        // 큐의 크기를 출력
        // 큐에 있는 요소의 개수를 출력합니다.
        out.println("q의 크기 : " + q.size() + "\n");
        String data = ""; // 큐에서 꺼낸 데이터를 저장할 변수 초기화
        
        // while 루프를 사용하여 큐에서 요소를 제거하고 출력
        // 큐가 비어있지 않은 동안 반복합니다.
        while ((data = q.poll()) != null) { // poll 메서드는 큐의 첫 번째 요소를 제거하고 반환합니다. 큐가 비어있으면 null을 반환합니다.
            // 큐에서 꺼낸 데이터를 출력
            out.println(data + " 삭제!");
            // 현재 큐의 크기를 출력
            out.println("q의 크기 : " + q.size() + "\n");
        }
    }
}
