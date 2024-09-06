package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ProtocolServer {
    ServerSocket serverSocket; // 클라이언트의 연결을 기다리는 서버 소켓입니다.
    Socket socket; // 클라이언트와의 연결을 위한 소켓입니다.
    BufferedReader br; // 클라이언트로부터 데이터를 읽기 위한 BufferedReader 객체입니다.
    BufferedWriter bw; // 클라이언트로 데이터를 보내기 위한 BufferedWriter 객체입니다.
    
    public ProtocolServer() {
        try {
            // 서버 소켓을 9500 포트에 바인딩하여 초기화합니다.
            serverSocket = new ServerSocket(9500); 
            System.out.println("서버준비완료..");
            
            // 클라이언트의 연결을 대기하고 수락합니다.
            socket = serverSocket.accept();
            
            // 소켓의 입력 스트림을 BufferedReader로 감싸서 초기화합니다.
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 소켓의 출력 스트림을 BufferedWriter로 감싸서 초기화합니다.
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            
        } catch (IOException e) {
            // 클라이언트와 연결할 수 없는 경우의 예외 처리입니다.
            System.out.println("클라이언트와 연결이 안되었습니다");
            e.printStackTrace();
            System.exit(0);
        }
        
        //---------------
        String line;
        
        try {
            while(true) {
                // 클라이언트로부터 데이터를 읽습니다.
                line = br.readLine();
                System.out.println("클라이언트로부터 받은 메시지: " + line);
                
                // 데이터를 프로토콜에 따라 분리합니다.
                String[] ar = line.split(":");
                
                // 입장 프로토콜인 경우 처리합니다.
                if(ar[0].equals(Protocol.ENTER)) { // 입장 => 100:대화명
                    bw.write(ar[1] + "님 입장하였습니다\n");
                    bw.flush();
                    
                // 퇴장 프로토콜인 경우 처리합니다.
                } else if(ar[0].equals(Protocol.EXIT)) { // 퇴장 => 200:대화명
                    bw.write(ar[1] + "님 퇴장하였습니다\n");
                    bw.flush();
                    
                    br.close();
                    bw.close();
                    socket.close();
                    
                    System.out.println("서버 종료");
                    System.exit(0);
                    
                // 메시지 전송 프로토콜인 경우 처리합니다.
                } else if(ar[0].equals(Protocol.SEND_MESSAGE)) { // 메시지 => 300:대화명:메세지
                    bw.write("[" + ar[1] + "] " + ar[2] + "\n");
                    bw.flush();
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        // 서버 객체를 생성합니다.
        new ProtocolServer();
    }
}
