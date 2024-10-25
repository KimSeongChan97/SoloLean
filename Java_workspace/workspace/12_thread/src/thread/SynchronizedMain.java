package thread;

class Synchronized extends Thread { // Thread 클래스를 상속받아 Synchronized 클래스를 만듭니다.
    private static int count; // 모든 Synchronized 인스턴스가 공유하는 정적 변수 count

    @Override
    public void run() {
        // Synchronized.class 객체를 기준으로 동기화 블록을 설정합니다.
        // 이렇게 하면 여러 스레드가 동시에 이 블록에 진입할 수 없습니다.
        synchronized (Synchronized.class) { // 공통점을 잡아라 !
            for (int i = 1; i <= 5; i++) {
                count++; // count 변수를 1씩 증가시킵니다.
                System.out.println(Thread.currentThread().getName() + " : " + count); // 현재 실행 중인 스레드 이름과 count 값을 출력합니다.
            }
        }
    }
}
//SynchronizedMain 클래스는 프로그램의 메인 진입점입니다.
public class SynchronizedMain {

 public static void main(String[] args) {
     // Synchronized 클래스를 상속받은 스레드 객체 aa, bb, cc를 생성합니다.
     Synchronized aa = new Synchronized(); 
     Synchronized bb = new Synchronized();
     Synchronized cc = new Synchronized();
     
     // 각 스레드의 이름을 설정합니다.
     aa.setName("aa");
     bb.setName("bb");
     cc.setName("cc");
     
     // 각 스레드의 우선순위를 설정합니다.
     // 스레드의 우선순위는 1 (가장 낮음)부터 10 (가장 높음)까지 설정할 수 있습니다.
     aa.setPriority(Thread.MIN_PRIORITY); // aa 스레드의 우선순위를 최소 값으로 설정 (1)
     bb.setPriority(Thread.MAX_PRIORITY); // bb 스레드의 우선순위를 최대 값으로 설정 (10)
     cc.setPriority(Thread.NORM_PRIORITY); // cc 스레드의 우선순위를 보통 값으로 설정 (5)
     
     // 스레드를 시작합니다.
     // 스레드가 시작되면 run() 메서드가 호출됩니다.
     aa.start(); 
     bb.start();
     cc.start();
 }
}

