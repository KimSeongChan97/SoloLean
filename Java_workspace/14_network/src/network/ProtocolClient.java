package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ProtocolClient {
    Socket socket; // 서버와의 연결을 위한 소켓 객체입니다.
    BufferedReader br; // 서버로부터 데이터를 읽기 위한 BufferedReader 객체입니다.
    BufferedWriter bw; // 서버로 데이터를 보내기 위한 BufferedWriter 객체입니다.
    Scanner scan; // 사용자 입력을 받기 위한 Scanner 객체입니다.
    
    public ProtocolClient() {
        try {
            // 로컬호스트와 9500 포트로 연결을 시도합니다.
            socket = new Socket("localhost", 9500);
            
            // 소켓의 입력 스트림을 BufferedReader로 감싸서 초기화합니다.
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 소켓의 출력 스트림을 BufferedWriter로 감싸서 초기화합니다.
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            
            // 사용자 입력을 받기 위해 Scanner를 초기화합니다.
            scan = new Scanner(System.in);
            
        } catch (UnknownHostException e) {
            // 서버를 찾을 수 없는 경우의 예외 처리입니다.
            System.out.println("서버를 찾을 수 없습니다");
            e.printStackTrace();
            System.exit(0);
        } catch (IOException e) {
            // 서버와 연결할 수 없는 경우의 예외 처리입니다.
            System.out.println("서버와 연결이 안되었습니다");
            e.printStackTrace();
            System.exit(0);
        }
        //-----------------
        String message, line;
        
        try {
            while(true) {
                // 사용자에게 프로토콜 입력 방법을 안내합니다.
                System.out.println();
                System.out.println("입장은 100:대화명 이라고 입력하세요");
                System.out.println("퇴장은 200:대화명 이라고 입력하세요");
                System.out.println("메세지는 300:대화명:메세지 이라고 입력하세요\n");
                
                // 사용자 입력을 받습니다.
                message = scan.nextLine();
                
                // 입력된 메시지를 서버로 보냅니다.
                bw.write(message + "\n");
                bw.flush();
                
                // 서버로부터 응답을 받습니다.
                line = br.readLine();
                System.out.println("서버 응답: " + line);
                System.out.println();
                
                // 메시지를 프로토콜에 따라 분리합니다.
                String[] ar = message.split(":");
                
                // 퇴장 프로토콜인 경우 연결을 종료합니다.
                if(ar[0].equals(Protocol.EXIT)) {
                    br.close();
                    bw.close();
                    socket.close();
                    break; // 루프를 빠져나갑니다.
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        // 클라이언트 객체를 생성합니다.
        new ProtocolClient();
    }
}
