package thread;

// SnackMain 클래스는 Thread 클래스를 상속받아 멀티스레드 작업을 수행합니다.
public class SnackMain extends Thread {
    // 스레드가 출력할 문자열을 저장할 변수
    private String str;

    // 생성자: 스레드가 출력할 문자열을 매개변수로 받아 초기화합니다.
    public SnackMain(String str) {
        this.str = str;
    }

    // run 메서드: 스레드가 실행할 작업을 정의합니다.
    @Override
    public void run() {
        // 1부터 5까지 반복하며 스레드의 이름과 현재 반복 횟수를 출력합니다.
        for (int i = 1; i <= 5; i++) {
            System.out.println(str + "\t" + "i=" + i + "\t" + Thread.currentThread());
        }
    }

    // main 메서드: 프로그램의 시작 지점으로 스레드를 생성하고 실행합니다.
    public static void main(String[] args) {
        // 새로운 SnackMain 스레드 객체를 생성합니다. (각각 "새우깡", "포카칩", "수미칩" 문자열을 출력할 스레드)
        SnackMain aa = new SnackMain("새우깡"); // 스레드 생성
        SnackMain bb = new SnackMain("포카칩"); // 스레드 생성
        SnackMain cc = new SnackMain("수미칩"); // 스레드 생성

        // 각 스레드의 이름을 설정합니다.
        aa.setName("새우깡"); // 스레드의 이름 부여 
        bb.setName("포카칩");
        cc.setName("수미칩");

        // 스레드를 시작합니다. (start() 메서드는 운영체제가 스레드를 실행하도록 합니다.)
        aa.start(); // 운영 체제가 알아서 run() 을 호출, 콜백메소드 (Call Back)
        
        try {
            // aa 스레드가 종료될 때까지 다른 스레드들을 대기시킵니다.
            aa.join(); // aa 스레드가 완료될 때까지 다른 스레드는 대기합니다.
        } catch (InterruptedException e) {
            // 예외 발생 시 스택 트레이스를 출력합니다.
            e.printStackTrace();
        }

        // 나머지 스레드를 시작합니다.
        bb.start();
        cc.start();

        /*
         * 주의: 아래 코드는 스레드를 시작하는 것이 아니라 run() 메서드를 호출하는 것입니다.
         * 이렇게 하면 멀티스레딩의 장점을 살릴 수 없습니다.
         * aa.run();
         * bb.run();
         * cc.run();
         */
    }
}






