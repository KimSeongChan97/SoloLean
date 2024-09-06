// inheritance 패키지 선언
package inheritance;

import java.util.ArrayList; // ArrayList 클래스를 사용하기 위해 import

// Test 클래스 정의, Object 클래스를 상속받음
class Test extends Object {

    // Object 클래스의 toString() 메서드를 오버라이드(재정의) 함
    @Override
    public String toString() {
        // 현재 클래스의 이름과 문자열 "@개바부"를 반환
        // getClass() 메서드는 현재 객체의 런타임 클래스의 이름을 반환
        return getClass() + "@개바부";
    }
}

// ObjectMain 클래스 정의
public class ObjectMain {

    // main 메서드 - 자바 애플리케이션의 시작점
    public static void main(String[] args) {
        // Test 클래스의 인스턴스를 생성하고 test 변수에 할당
        Test test = new Test();
        
        // test 객체의 정보를 출력 (기본적으로 toString() 메서드가 호출됨)
        // Test 클래스에서 오버라이드한 toString() 메서드가 호출되어 클래스명@개바부가 출력됨
        System.out.println("객체 test = " + test); // 클래스명@개바부 출력
        
        // test 객체의 toString() 메서드를 명시적으로 호출하고 그 결과를 출력
        System.out.println("객체 test = " + test.toString()); // 위와 동일한 결과 출력
        
        // test 객체의 해시 코드를 10진수로 출력
        // hashCode() 메서드는 객체의 해시 코드를 반환, 이는 주로 객체의 메모리 주소를 기반으로 함
        System.out.println("객체 test = " + test.hashCode()); // 객체의 해시코드 값 출력
        System.out.println(); // 빈 줄 출력 (출력 결과를 보기 좋게 하기 위함)
        
        // String 객체 생성
        String str = "apple";
        // str 객체의 정보를 출력 (기본적으로 toString() 메서드가 호출됨)
        // String 클래스의 toString() 메서드는 문자열 자체를 반환하므로 "apple"이 출력됨
        System.out.println("객체 str = " + str); // "apple" 출력
        // str 객체의 toString() 메서드를 명시적으로 호출하고 그 결과를 출력
        System.out.println("객체 str = " + str.toString()); // "apple" 출력
        // str 객체의 해시 코드를 10진수로 출력
        // String 클래스의 hashCode() 메서드는 문자열의 해시 코드를 반환
        System.out.println("객체 str = " + str.hashCode()); // "apple"의 해시코드 값 출력
        System.out.println(); // 빈 줄 출력
        
        // 새로운 String 객체 aa와 bb 생성 (값은 동일하지만, 다른 객체)
        String aa = new String("apple");
        String bb = new String("apple");
        // aa와 bb가 같은 객체인지 비교
        System.out.println("aa==bb : " + (aa==bb)); // false 출력 (객체 참조 비교)
        // aa와 bb의 값이 같은지 비교
        System.out.println("aa.equals(bb) : " + aa.equals(bb)); // true 출력 (값 비교)
        System.out.println(); // 빈 줄 출력
        
        // 새로운 Object 객체 cc와 dd 생성
        Object cc = new Object();
        Object dd = new Object();
        // cc와 dd가 같은 객체인지 비교
        System.out.println("cc==dd : " +(cc==dd)); // false 출력 (객체 참조 비교)
        // cc와 dd의 값이 같은지 비교 (Object 클래스의 equals 메서드는 기본적으로 참조 비교)
        System.out.println("cc.equals(dd) : " + cc.equals(dd)); // false 출력 (기본 equals 메서드)
        System.out.println(); // 빈 줄 출력
        
        // 새로운 Object 객체 ee와 ff를 String으로 생성
        Object ee = new String("apple");
        Object ff = new String("apple");
        // ee와 ff가 같은 객체인지 비교
        System.out.println("ee==ff : " + (ee==ff)); // false 출력 (객체 참조 비교)
        // ee와 ff의 값이 같은지 비교 (String 클래스의 equals 메서드가 호출됨)
        System.out.println("ee.equals(ff) : " + ee.equals(ff)); // true 출력 (값 비교) , Override 로 인한 참조값과 문자열 비교.
        System.out.println(); // 빈 줄 출력
        
        // ArrayList 객체 생성
        ArrayList<String> list = new ArrayList<String>();
        // ArrayList에 항목 추가
        list.add("호랑이");
        list.add("사자");
        // ArrayList의 toString() 메서드 호출하여 항목을 출력
        System.out.println(list); // 클래스@16진수 => [항목]
    }
}

/*
class Object {
    // equals 메서드는 기본적으로 객체의 참조값을 비교
    public boolean equals(Object doj){} // 참조값 비교
    
    // toString 메서드는 클래스명과 객체의 해시코드를 16진수로 반환
    public String toString(){} // @16진수
    
    // hashCode 메서드는 객체의 해시코드를 10진수로 반환
    public int hashCode(){} // 10진수
}

class String extends Object {
    // equals 메서드는 문자열 값을 비교
    public boolean equals(Object doj){} // 문자열 비교
    
    // toString 메서드는 문자열 자체를 반환
    public String toString(){} // 문자열
    
    // hashCode 메서드는 문자열의 해시코드를 10진수로 반환
    public int hashCode(){} // 10진수, 문자열 표현은 무한대이기 때문에 모든 문자열을 다 표현할 수 없음
}
*/

