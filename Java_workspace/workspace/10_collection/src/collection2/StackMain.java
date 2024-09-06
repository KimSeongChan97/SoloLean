package collection2; // collection2 패키지에 속한 클래스

import java.util.Stack; // Stack 클래스를 사용하기 위해 import

import static java.lang.System.out; // System.out 객체를 'out'으로 간단히 사용하기 위해 static import

public class StackMain {

    public static void main(String[] args) {
        // 문자열 배열을 선언 및 초기화
        String[] groupA = {"우즈베키스탄", "쿠웨이트", "사우디", "대한민국"};
        
        // Stack 객체를 생성
        Stack<String> stack = new Stack<String>();
        
        // for 루프를 사용하여 배열의 요소를 스택에 추가
        // 중괄호를 생략한 형태로 작성됨. 한 줄만 포함된 경우 중괄호는 생략 가능함.
        for (int i = 0; i < groupA.length; i++)
            stack.push(groupA[i]); // 스택의 맨 위에 요소를 추가
        
        // while 루프를 사용하여 스택이 비어있지 않은 동안 요소를 출력 및 제거
        // 중괄호를 생략한 형태로 작성됨. 한 줄만 포함된 경우 중괄호는 생략 가능함.
        while (!stack.isEmpty()) // 스택이 비어있지 않으면
            out.println(stack.pop()); // 스택의 맨 위 요소를 제거하고 출력
        
    }
}
