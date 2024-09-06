// com.zoo 패키지 선언
package com.zoo;

// Zoo2 클래스 정의
public class Zoo2 {

    // main 메서드 - 자바 애플리케이션의 시작점
    public static void main(String[] args) {
        // Zoo 클래스의 인스턴스를 생성하고 zoo 변수에 할당
        Zoo zoo = new Zoo();
        
        // Zoo 클래스의 tiger() 메서드를 호출
        zoo.tiger();
        
        // Zoo 클래스의 giraffe() 메서드를 호출
        zoo.giraffe();
        
        // Zoo 클래스의 elephant() 메서드를 호출
        zoo.elephant();
        
        // Zoo 클래스의 lion() 메서드를 호출하려 하지만,
        // lion() 메서드는 private 접근 제어자이기 때문에 외부 클래스에서는 접근할 수 없음.
        // 따라서, 이 줄은 주석 처리되어 있음.
        // zoo.lion(); - private 이기 때문에 막힘.
    }
}
