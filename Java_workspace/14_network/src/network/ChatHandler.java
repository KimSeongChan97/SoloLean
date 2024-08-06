package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.json.JSONObject;

public class ChatHandler {
    ChatServer chatServer; // 서버 객체 참조
    Socket socket; // 클라이언트와의 소켓 연결을 위한 Socket 객체
    DataInputStream dis; // 클라이언트로부터 데이터를 읽기 위한 입력 스트림
    DataOutputStream dos; // 클라이언트로 데이터를 보내기 위한 출력 스트림
    String chatName; // 클라이언트의 채팅 이름
    String clientIp; // 클라이언트의 IP 주소

    // 생성자
    public ChatHandler(ChatServer chatServer, Socket socket) throws IOException {
        this.chatServer = chatServer; // 서버 객체 초기화
        this.socket = socket; // 소켓 객체 초기화
        dis = new DataInputStream(socket.getInputStream()); // 클라이언트로부터 데이터를 읽기 위한 스트림 생성
        dos = new DataOutputStream(socket.getOutputStream()); // 클라이언트로 데이터를 보내기 위한 스트림 생성
        
        InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress(); // 클라이언트의 주소 정보 가져오기
        clientIp = isa.getHostName(); // 클라이언트의 호스트 이름(IP 주소) 저장
        
        receive(); // 클라이언트로부터 데이터 받기 시작
    }

    // 클라이언트로부터 오는 JSON 데이터를 받기
    public void receive() {
        chatServer.threadPool.execute(() -> { // 스레드 풀에서 새로운 스레드 실행
            try {
                while(true) {
                    String receiveJSON = dis.readUTF(); // 클라이언트로부터 JSON 형식의 문자열 데이터를 읽음
                    
                    JSONObject jsonObject = new JSONObject(receiveJSON); // JSON 문자열을 JSONObject로 변환
                    String command = jsonObject.getString("command"); // JSON에서 명령어 추출
                    
                    switch(command) {
                    case "enter": 
                        this.chatName = jsonObject.getString("data"); // JSON에서 채팅 이름 추출
                        chatServer.sendToAll(this, "입장하셨습니다"); // 모든 클라이언트에게 입장 메시지 전송
                        chatServer.addSocketClient(this); // 서버에 클라이언트 추가
                        break;
                    case "message":
                        String message = jsonObject.getString("data"); // JSON에서 메시지 추출
                        chatServer.sendToAll(this, message); // 모든 클라이언트에게 메시지 전송
                        break;
                    }
                } // while
            } catch(IOException e) {
                chatServer.sendToAll(this, "퇴장하셨습니다"); // 모든 클라이언트에게 퇴장 메시지 전송
                chatServer.removeSocketClient(this); // 서버에서 클라이언트 제거
            }
        });
    }

    // 클라이언트로 JSON 데이터를 보내기
    public void send(String json) {
        try {
            dos.writeUTF(json); // JSON 문자열을 클라이언트로 전송
            dos.flush(); // 출력 스트림을 비움

        } catch (IOException e) {
            //e.printStackTrace();
        }    
    }

    // 클라이언트와의 연결을 닫는 메서드
    public void close() {
        try {
            socket.close(); // 소켓 연결 종료
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
}
