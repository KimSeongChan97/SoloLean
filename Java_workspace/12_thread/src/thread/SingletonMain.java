package thread;

// Singleton 클래스는 싱글톤 패턴을 구현합니다.
// 싱글톤 패턴은 클래스의 인스턴스가 하나만 생성되도록 보장하는 디자인 패턴입니다.
class Singleton {
    private int num = 3; // 인스턴스 변수 num 을 초기화합니다.
    private static Singleton instance; // Singleton 클래스의 유일한 인스턴스를 저장할 정적 변수

    // Singleton 클래스의 인스턴스를 반환하는 정적 메서드입니다.
    public static Singleton getInstance() {
        // 인스턴스가 아직 생성되지 않았을 경우에만 생성합니다.
        if (instance == null) { // 초기화를 통해 객체 주소 넣을 공간을 만듦.
            // 클래스 객체를 기준으로 동기화하여 여러 쓰레드가 동시에 접근하지 못하게 합니다.
            synchronized (Singleton.class) {
                instance = new Singleton(); // Singleton 클래스의 새로운 인스턴스를 생성합니다.
            }
        }
        return instance; // 이미 생성된 인스턴스를 반환합니다.
    }

    // num 값을 증가시키는 메서드입니다.
    public void calc() {
        num++; // num을 1 증가시킵니다.
    }

    // num 값을 출력하는 메서드입니다.
    public void disp() {
        System.out.println("num = " + num); // num의 현재 값을 출력합니다.
    }
}
//SingletonMain 클래스는 싱글톤 패턴을 테스트합니다.
public class SingletonMain {

 public static void main(String[] args) {
     // Singleton 클래스의 인스턴스를 가져와서 사용합니다.
     Singleton aa = Singleton.getInstance(); // 새로운 인스턴스를 생성하지 않고, getInstance 메서드를 통해 인스턴스를 가져옵니다.
     aa.calc(); // num 값을 증가시킵니다.
     aa.disp(); // num 값을 출력합니다.
     System.out.println(); // 빈 줄을 출력합니다.

     Singleton bb = Singleton.getInstance(); // 이미 생성된 인스턴스를 가져옵니다.
     bb.calc(); // num 값을 증가시킵니다.
     bb.disp(); // num 값을 출력합니다.
     System.out.println(); // 빈 줄을 출력합니다.

     Singleton cc = Singleton.getInstance(); // 이미 생성된 인스턴스를 가져옵니다.
     cc.calc(); // num 값을 증가시킵니다.
     cc.disp(); // num 값을 출력합니다.
     System.out.println(); // 빈 줄을 출력합니다.
 }
}

