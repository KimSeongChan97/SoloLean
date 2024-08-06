package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONObject;

public class ChatServer {
    ServerSocket serverSocket; // 클라이언트의 연결 요청을 수락하기 위한 서버 소켓
    ExecutorService threadPool = Executors.newFixedThreadPool(100); // 100개의 클라이언트가 동시에 채팅할 수 있도록 스레드 풀 생성
    Map<String, ChatHandler> chatRoom = Collections.synchronizedMap(new HashMap<>()); // 통신용 ChatHandler를 관리하는 동기화된 Map 컬렉션
    
    // 서버 시작
    private void start() throws IOException {
        serverSocket = new ServerSocket(9500); // 서버 소켓 생성, 포트 9500번 사용
        System.out.println("서버 준비 완료"); // 서버 준비 완료 메시지 출력
        
        Thread thread = new Thread(() -> { // Runnable 를 람다식으로 제공
            try {
                while(true) {
                    Socket socket = serverSocket.accept(); // 클라이언트의 연결 요청을 수락
                    ChatHandler chatHandler = new ChatHandler(this, socket); // 새로운 ChatHandler 객체 생성
                        
                } // while
            } catch (IOException e) {
                //e.printStackTrace();
            }
        }); 
        
        thread.start(); // 스레드 시작
    } // start()
    
    // 클라이언트 연결 시 ChatHandler 생성 및 추가
    public void addSocketClient(ChatHandler chatHandler) {
        String key = chatHandler.chatName + "@" + chatHandler.clientIp; // 클라이언트 식별을 위한 key 생성
        chatRoom.put(key, chatHandler); // chatRoom Map에 클라이언트 추가
        System.out.println("입장 : " + key); // 입장 메시지 출력
        System.out.println("현재 채팅자 수 : " + chatRoom.size() + "\n"); // 현재 채팅자 수 출력
    }
    
    // 클라이언트 연결 종료 시 ChatHandler 제거
    public void removeSocketClient(ChatHandler chatHandler) {
        String key = chatHandler.chatName + "@" + chatHandler.clientIp; // 클라이언트 식별을 위한 key 생성
        chatRoom.remove(key); // chatRoom Map에서 클라이언트 제거
        System.out.println("퇴장 : " + key); // 퇴장 메시지 출력
        System.out.println("현재 채팅자 수 : " + chatRoom.size() + "\n"); // 현재 채팅자 수 출력
    }
    
    // 모든 클라이언트에게 메시지를 보냄
    public void sendToAll(ChatHandler sender, String message) {
        JSONObject jsonObject = new JSONObject(); // JSON 객체 생성
        jsonObject.put("clientIp", sender.clientIp); // JSON 객체에 "clientIp" 속성 추가
        jsonObject.put("chatName", sender.chatName); // JSON 객체에 "chatName" 속성 추가
        jsonObject.put("message", message); // JSON 객체에 "message" 속성 추가
        
        String json = jsonObject.toString(); // JSON 객체를 문자열로 변환
        
        Collection<ChatHandler> collection = chatRoom.values(); // chatRoom Map의 모든 값(클라이언트)을 가져옴
        for(ChatHandler chatHandler : collection) {
            if(chatHandler == sender) continue; // 메시지를 보낸 클라이언트는 제외
            chatHandler.send(json); // 나머지 모든 클라이언트에게 메시지 전송
        }
    }

    // 서버 종료
    private void stop() {
        try {
            serverSocket.close(); // 서버 소켓 종료
            threadPool.shutdownNow(); // 스레드 풀 종료
            
            // chatRoom에 있는 모든 ChatHandler를 닫음
            // chatRoom.values()로 Collection<ChatHandler>를 얻고, 요소 스트림을 이용해서 전체 ChatHandler의 close()를 호출
            chatRoom.values().stream().forEach(ch -> ch.close()); // 모든 클라이언트의 연결을 종료
            
            System.out.println("서버 종료"); // 서버 종료 메시지 출력
            
        } catch (IOException e) {
            //e.printStackTrace();
        }
    } // stop()
    
    public static void main(String[] args) {
        try {
            ChatServer chatServer = new ChatServer(); // ChatServer 객체 생성
            chatServer.start(); // 서버 시작
            
            System.out.println();
            System.out.println("서버를 종료하려면 q를 입력하세요");
            System.out.println();
            
            Scanner scan = new Scanner(System.in); // 사용자로부터 입력을 받기 위한 Scanner 객체 생성
            while(true) {
                String key = scan.nextLine(); // 사용자가 입력한 문자열을 저장
                if(key.toLowerCase().equals("q")) break; // 'q' 입력 시 종료
            }
            
            scan.close(); // Scanner 객체 닫기
            
            chatServer.stop(); // 서버 종료
            
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println("[서버] " + e.getMessage()); // 예외 메시지 출력
        }
    }
}

/*
JSON 데이터 형식
=> *.jar 필요
   https://mvnrepository.com/
   json-20231013.jar 
=> 네트워크로 전달하는 데이터가 복잡할수록 구조화된 형식이 필요하다.
   네트워크 통신에서 가장 많이 사용되는 데이터 형식은 JSON(JavaScript Object Notation)이다.
   
[형식]
① JSON 객체
{
    "속성명" : 값,
    "속성명" : 값
}   

② JSON 배열
[
    "문자열" or
    { ......} or
    [ ......]
]
 */
