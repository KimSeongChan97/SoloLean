package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ATM implements Runnable {
    private long depositMoney = 100000; // 은행 계좌의 초기 예치 금액
    private long balance; // 출금할 금액을 저장할 변수

    @Override
    public synchronized void run() { // synchronized 로 메서드를 동기화하여 여러 스레드가 동시에 접근하지 못하게 함
        System.out.println("안녕하세요 " + Thread.currentThread().getName() + " 고객님 "); // 현재 실행 중인 스레드의 이름을 출력

        // IO를 이용하여 사용자로부터 입력을 받음 (Scanner 대신 BufferedReader 사용)
        // Scanner 에서 사용하던 System.in은 InputStream이므로 InputStreamReader를 통해 BufferedReader로 감쌈
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("찾고자 하는 금액 입력 : ");
            balance = Long.parseLong(br.readLine()); // 입력받은 금액을 long 타입으로 변환하여 balance 에 저장
        } catch (NumberFormatException e) { // 숫자가 아닌 값을 입력했을 때 발생하는 예외 처리
            e.printStackTrace();
        } catch (IOException e) { // 입력 중 발생하는 IO 예외 처리
            e.printStackTrace();
        }

        withDraw(); // 출금 메서드 호출
    }

    // 출금 처리 메서드
    public void withDraw() {
        // 예치 금액이 출금 요청 금액보다 크거나 같을 경우 출금 진행
        if (depositMoney >= balance) { // 예치 금액이 출금하려는 금액보다 크거나 같은지 확인
            if (depositMoney % 10000 == 0) { // 출금 요청 금액이 만원 단위일 경우
                depositMoney -= balance; // 예치 금액에서 출금 요청 금액을 뺌
                System.out.println(" 잔액은 " + depositMoney + " 원 입니다."); // 출금 후 남은 잔액 출력
            } else {
                System.out.println("만원 단위로 입력 하세요."); // 만원 단위가 아닌 금액을 입력한 경우 메시지 출력
            }
        } else {
            System.out.println("잔액이 부족합니다."); // 예치 금액이 출금 요청 금액보다 적을 경우 메시지 출력
        }
    }
}

//------------------------------
public class ATMMain {

    public static void main(String[] args) {
        // ATM 객체 생성
        ATM atm = new ATM();
        
        // 새로운 스레드 mom을 생성하고 이름을 "엄마"로 설정
        Thread mom = new Thread(atm, "엄마");
        
        // 새로운 스레드 son을 생성하고 이름을 "아들"로 설정
        Thread son = new Thread(atm, "아들");

        // 각각의 스레드를 시작하여 run() 메서드를 실행
        mom.start(); // mom 스레드 시작
        son.start(); // son 스레드 시작
    }
}

