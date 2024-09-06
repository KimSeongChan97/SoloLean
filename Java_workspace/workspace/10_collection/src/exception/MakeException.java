package exception; // 패키지 선언: 현재 클래스가 속한 패키지를 정의합니다.

public class MakeException extends Exception { // 사용자 정의 예외 클래스 MakeException을 정의합니다. Exception 클래스를 확장합니다.
    private String errorMsg; // 예외 메시지를 저장할 인스턴스 변수 errorMsg를 선언합니다.

    // 기본 생성자: 인수가 없는 생성자입니다.
    public MakeException() {}

    // 인수 있는 생성자: 예외 메시지를 인수로 받아들입니다.
    public MakeException(String errorMsg) {
        super(); // 부모 클래스(Exception)의 기본 생성자를 호출합니다.
        this.errorMsg = errorMsg; // 전달받은 예외 메시지를 인스턴스 변수 errorMsg에 저장합니다.
    }

    // toString() 메서드를 오버라이드합니다.
    // 예외 객체가 문자열로 변환될 때 호출됩니다.
    @Override
    public String toString() {
        return errorMsg; // 예외 메시지를 반환합니다.
    }
}
