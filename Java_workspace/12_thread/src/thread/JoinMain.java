package thread;

// JoinTest 클래스는 Runnable 인터페이스를 구현하여 스레드로 실행될 수 있는 작업을 정의합니다.
class JoinTest implements Runnable {

	@Override
	public void run() { // 운영체제에 의해 호출되는 콜백 메서드
		// run 메서드는 스레드가 실행할 작업을 정의합니다.
		// throws InterruptException 은 Override 에 사용하지 못한다.
		// ( 사용할려면 main class 에도 사용해야 함 )
		for (int i = 1; i <= 5; i++) {
			// 현재 반복 횟수를 출력합니다.
			System.out.println(i);

			try {
				// 현재 스레드를 1초 동안 잠재웁니다.
				// Thread.sleep(1000)은 1000밀리초(1초) 동안 스레드를 일시 정지시킵니다.
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// 예외가 발생하면 스택 트레이스를 출력합니다.
				e.printStackTrace();
			} // 기본 단위는 1/1000초

		} // for 반복문 종료

	} // run 메서드 종료, 운영체제가 알아서 run() 호출

}

//-----------------------------
// JoinMain 클래스는 프로그램의 시작 지점으로 스레드를 생성하고 실행합니다.
public class JoinMain {

	public static void main(String[] args) {
		// JoinTest 클래스의 인스턴스를 생성합니다.
		JoinTest joinTest = new JoinTest();
		// Thread 객체를 생성하고, JoinTest 인스턴스를 전달하여 스레드를 생성합니다.
		Thread t = new Thread(joinTest); // joinTest 를 thread 로 생성

		// 스레드 시작을 알리는 메시지를 출력합니다.
		System.out.println("스레드 시작(0)");
		// 스레드를 시작합니다. (start() 메서드는 운영체제가 스레드를 실행하도록 합니다.)
		t.start(); // 스레드 시작되며 운영체제가 알아서 run() 호출, Call Back 메소드

		try {
			// t 스레드가 종료될 때까지 현재 스레드를 대기시킵니다.
			// t.join()은 t 스레드가 완료될 때까지 main 스레드를 대기시킵니다.
			t.join();
		} catch (InterruptedException e) {
			// 예외 발생 시 스택 트레이스를 출력합니다.
			e.printStackTrace();
		} // 스레드 파괴 대기

		// 스레드 종료를 알리는 메시지를 출력합니다.
		System.out.println("스레드 종료(6)");

	} // main 메서드 종료

}

// main 메서드가 종료되어도 백그라운드에서 스레드는 계속 실행됩니다.
// main 메서드가 종료되어도 t 스레드가 종료될 때까지 대기합니다.
