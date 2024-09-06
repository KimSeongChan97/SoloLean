package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.json.JSONObject;

public class ChatClient {
    Socket socket; // 서버와의 소켓 연결을 위한 Socket 객체
    DataInputStream dis; // 서버로부터 데이터를 읽기 위한 입력 스트림
    DataOutputStream dos; // 서버로 데이터를 보내기 위한 출력 스트림
    String chatName; // 사용자의 채팅 이름

    // 서버에 연결하는 메서드
    public void connect() throws UnknownHostException, IOException {
        socket = new Socket("192.168.0.9", 9500); // 서버 IP와 Port 번호로 소켓 생성
        dis = new DataInputStream(socket.getInputStream()); // 서버로부터 데이터를 읽기 위한 스트림 생성
        dos = new DataOutputStream(socket.getOutputStream()); // 서버로 데이터를 보내기 위한 스트림 생성
        
        System.out.println("서버에 연결되었음"); // 서버 연결 완료 메시지 출력
    }
    
    // 서버로부터 JSON 데이터를 받는 메서드
    public void receive() {
        Thread thread = new Thread(() -> {
            try {
                while(true) {
                    String json = dis.readUTF(); // 서버로부터 JSON 형식의 문자열 데이터를 읽음, 서버와 통신이 끊어지면 IOException 발생
                    
                    JSONObject jsonObject = new JSONObject(json); // JSON 문자열을 JSONObject로 변환
                    String clientIp = jsonObject.getString("clientIp"); // JSON에서 클라이언트 IP 추출
                    String chatName = jsonObject.getString("chatName"); // JSON에서 채팅 이름 추출
                    String message = jsonObject.getString("message"); // JSON에서 메시지 추출
                    
                    System.out.println("[" + chatName + "@" + clientIp + "] " + message); // 메시지 형식으로 출력
                    
                } // while
                
            } catch(IOException e) {
                System.out.println("서버와 연결이 끊어졌음"); // 서버와 연결이 끊어졌을 때 예외 처리
                System.exit(0); // 프로그램 종료
            }
        });
        
        thread.start(); // 스레드 시작
    } // receive()
    
    // 서버로 JSON 데이터를 보내는 메서드 - main 메소드에서 키보드로부터 입력한 메시지를 보낼 때 호출
    public void send(String json) throws IOException {
        dos.writeUTF(json); // JSON 문자열을 서버로 전송
        dos.flush(); // 출력 스트림을 비움
    }
    
    // 서버와의 연결을 끊는 메서드
    public void unconnect() throws IOException {
        socket.close(); // 소켓 연결 종료
    }
    
    public static void main(String[] args) {
        try {
            ChatClient chatClient = new ChatClient(); // ChatClient 객체 생성
            chatClient.connect(); // 서버에 연결
            
            Scanner scan = new Scanner(System.in); // 사용자로부터 입력을 받기 위한 Scanner 객체 생성
            System.out.print("닉네임 입력 : "); // 닉네임 입력 요청
            chatClient.chatName = scan.nextLine(); // 사용자가 입력한 닉네임을 저장
            
            // 서버로 입장 메시지를 전송
            JSONObject jsonObject = new JSONObject(); // JSON 객체 생성
            jsonObject.put("command", "enter"); // JSON 객체에 "command" 속성 추가, 값은 "enter"
            jsonObject.put("data", chatClient.chatName); // JSON 객체에 "data" 속성 추가, 값은 사용자의 닉네임
            
            String json = jsonObject.toString(); // JSON 객체를 문자열로 변환
            chatClient.send(json); // 서버로 JSON 문자열 전송
            
            //-------------------
            chatClient.receive(); // 서버로부터 메시지를 받는 메서드 호출
            
            System.out.println();
            System.out.println("메세지를 입력하세요");
            System.out.println("클라이언트를 종료하려면 q를 입력하세요");
            System.out.println();
            
            // 사용자로부터 입력을 받아 서버로 메시지를 전송
            while(true) {
                String message = scan.nextLine(); // 사용자가 입력한 메시지를 저장
                
                if(message.toLowerCase().equals("q")) { // 'q' 입력 시 종료
                    break;
                    
                } else {
                    jsonObject = new JSONObject(); // 새로운 JSON 객체 생성
                    jsonObject.put("command", "message"); // JSON 객체에 "command" 속성 추가, 값은 "message"
                    jsonObject.put("data", message); // JSON 객체에 "data" 속성 추가, 값은 사용자가 입력한 메시지
                    
                    json = jsonObject.toString(); // JSON 객체를 문자열로 변환
                    chatClient.send(json); // 서버로 JSON 문자열 전송
                }
            } // while
            
            scan.close(); // Scanner 객체 닫기
            chatClient.unconnect(); // 서버와의 연결 종료
            
        } catch(IOException e) {
            System.out.println("서버와 연결이 안됨"); // 서버와의 연결 실패 메시지 출력
        }
    }

}
