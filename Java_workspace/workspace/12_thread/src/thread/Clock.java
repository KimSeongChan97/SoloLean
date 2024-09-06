package thread;

import java.awt.Color; // Color 클래스 임포트
import java.awt.Font; // Font 클래스 임포트
import java.awt.Frame; // Frame 클래스 임포트
import java.awt.Graphics; // Graphics 클래스 임포트
import java.awt.event.WindowAdapter; // WindowAdapter 클래스 임포트
import java.awt.event.WindowEvent; // WindowEvent 클래스 임포트
import java.text.SimpleDateFormat; // SimpleDateFormat 클래스 임포트
import java.util.Date; // Date 클래스 임포트

// Clock 클래스는 Frame을 상속받고, Runnable 인터페이스를 구현하여 스레드를 활용한 시계를 표시합니다.
public class Clock extends Frame implements Runnable {

	// Clock 클래스의 생성자
	public Clock() {
		// 폰트 설정: "Consolas" 폰트, 굵게, 크기 30으로 설정
		setFont(new Font("Consolas", Font.BOLD, 30));
		// 글자 색상을 노란색으로 설정
		setForeground(new Color(225, 232, 3));
		// 배경 색상을 보라색으로 설정
		setBackground(new Color(141, 4, 201));

		// 프레임의 크기와 위치를 설정합니다.
		setBounds(900, 200, 300, 400);
		// 프레임을 화면에 표시합니다.
		setVisible(true);

		// 현재 객체(this)를 대상으로 하는 새로운 스레드를 생성하고 시작합니다.
		Thread t = new Thread(this); // Clock 스레드로 생성 (자기 자신의 참조값을 가지고 있는 객체)
		t.start(); // 스레드 시작 -> 스레드 실행(운영체제가 run() 호출)
		
		// 창 닫기 이벤트를 처리하기 위해 WindowAdapter를 사용합니다.
		this.addWindowListener(new WindowAdapter() { // 추상 클래스 이므로 Override 생성
			@Override
			public void windowClosing(WindowEvent e) {
				// 창 닫기 버튼을 누르면 프로그램을 종료합니다.
				System.exit(0);
				// 부모 클래스의 windowClosing 메서드를 호출합니다.
				super.windowClosing(e);
			}
		}); // WindowAdapter 클래스를 사용하여 빈 메서드를 오버라이드합니다.
	}

	// Runnable 인터페이스의 run 메서드를 구현합니다.
	// 이 메서드는 스레드가 실행할 작업을 정의합니다.
	@Override
	public void run() {
		// 무한 루프를 사용하여 시계를 지속적으로 업데이트합니다.
		while (true) {
			// repaint 메서드를 호출하여 프레임을 다시 그립니다.
			repaint();

			try {
				// 현재 스레드를 1초 동안 잠재웁니다.
				Thread.sleep(1000); // 클래스 명이 직접적으로 왔으므로 static 메서드입니다. 따라서 try-catch로 예외 처리 필요
			} catch (InterruptedException e) {
				// 예외 발생 시 스택 트레이스를 출력합니다.
				e.printStackTrace();
			}
		}
	}
	
	// Frame 클래스의 paint 메서드를 오버라이드하여 화면에 시계를 그립니다.
	// paint 메서드는 Frame이 다시 그려질 때마다 호출됩니다. (콜백 메서드)
	@Override
	public void paint(Graphics g) {
		// 현재 시간을 "HH:mm:ss" 형식으로 포맷합니다.
		SimpleDateFormat sdf = new SimpleDateFormat("HH : mm : ss"); // 몇시 : 몇분 : 몇초 형식

		// 현재 시간을 가져옵니다.
		Date date = new Date();

		// 포맷된 시간을 Graphics 객체를 사용하여 프레임에 그립니다.
		g.drawString(sdf.format(date), 50, 70);

		// 부모 클래스의 paint 메서드를 호출합니다.
		super.paint(g);
	}

	// 프로그램의 시작 지점인 main 메서드
	public static void main(String[] args) {
		// Clock 객체를 생성하여 생성자를 호출합니다.
		new Clock(); // Frame이 생성되고, paint() 호출
	}
}


