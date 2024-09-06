package network;

// Protocol 클래스는 채팅 프로토콜의 상수를 정의합니다.
public final class Protocol {
    // 클라이언트가 입장할 때 사용할 프로토콜 상수입니다.
    public static final String ENTER = "100";
    
    // 클라이언트가 퇴장할 때 사용할 프로토콜 상수입니다.
    public static final String EXIT = "200";
    
    // 클라이언트가 메시지를 보낼 때 사용할 프로토콜 상수입니다.
    public static final String SEND_MESSAGE = "300";
}
