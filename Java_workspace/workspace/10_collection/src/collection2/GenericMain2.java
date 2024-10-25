package collection2; // collection2 패키지에 속한 클래스

// 제네릭 클래스를 정의하는 부분. 타입 매개변수 T를 사용
public class GenericMain2<T> {
    
    // 제네릭 타입 T의 변수 a를 선언. 이 변수는 클래스의 인스턴스마다 다른 타입을 가질 수 있음.
    private T a; // 'a'는 외부에서 지정한 타입. 예: Integer, Double, String 등.

    // 생성자: 제네릭 타입 T의 값을 인수로 받아 멤버 변수 a에 할당
    public GenericMain2(T a) { // 생성자는 void를 반환하지 않음.
        this.a = a; // 인수로 받은 값을 'a' 변수에 저장
    }

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
        // 제네릭 타입을 모르는 상태에서 객체를 생성하지만, 이후 String 타입을 사용할 것을 암시.
        // GenericMain2<?> aa = new GenericMain2<String>(); 
        // aa.setA("홍길동"); // 오류 발생: 데이터를 setter 로 설정할 수 없음, 생성자를 통해서만 설정 가능.

        // 문자열 타입으로 제네릭 클래스를 사용하는 예제
        GenericMain2<?> aa = new GenericMain2<String>("홍길동"); // 생성자에 "홍길동" 문자열을 전달하여 객체 생성
        String name = (String) aa.getA(); // getA()의 반환값은 Object 이므로 String 으로 강제 형변환.
        System.out.println("이름 = " + name); // 'a' 변수의 값을 출력

        // 정수 타입으로 제네릭 클래스를 사용하는 예제
        GenericMain2<?> bb = new GenericMain2<Integer>(25); // 생성자에 25 정수를 전달하여 객체 생성
        int age = (Integer) bb.getA(); // getA()의 반환값은 Object 이므로 int 로 강제 형변환. // Wrapper class 로 Integer 형 변환가능
        // unAutoBoxing
        System.out.println("나이 = " + age); // 'a' 변수의 값을 출력
    }
}
