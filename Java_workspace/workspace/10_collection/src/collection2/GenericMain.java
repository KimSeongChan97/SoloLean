package collection2; // collection2 패키지에 속한 클래스

// 제네릭 클래스 GenericMain을 정의, 타입 매개변수 T를 사용
public class GenericMain<T> {
    
    // 제네릭 타입 T를 사용하는 멤버 변수 'a'
    private T a; // 'a'는 외부에서 지정한 타입 (예: Integer, Double, String 등)

    // 'a' 변수에 값을 설정하는 메서드
    public void setA(T a) { // 메서드의 인수 타입도 제네릭 타입 T
        this.a = a; // 인수로 받은 값을 'a' 변수에 저장
    }

    // 'a' 변수의 값을 반환하는 메서드
    public T getA() { // 반환 타입도 제네릭 타입 T
        return a; // 'a' 변수의 값을 반환
    }

    // main 메서드: 프로그램의 시작점
    public static void main(String[] args) {
        // 문자열 타입으로 제네릭 클래스를 사용하는 예제
        GenericMain<String> aa = new GenericMain<String>(); // 제네릭 타입으로 String 을 지정
        aa.setA("홍길동"); // '홍길동' 문자열을 'a' 변수에 설정
        System.out.println("이름 = " + aa.getA()); // 'a' 변수의 값을 출력

        // aa.setA(25); // 오류 발생: GenericMain<String>으로 생성했기 때문에 문자열만 허용

        // 정수 타입으로 제네릭 클래스를 사용하는 예제
        GenericMain<Integer> bb = new GenericMain<>(); // 제네릭 타입으로 Integer 를 지정 (다이아몬드 연산자 <> 사용)
        bb.setA(25); // 25 정수를 'a' 변수에 설정
        System.out.println("나이 = " + bb.getA()); // 'a' 변수의 값을 출력
    }
}
