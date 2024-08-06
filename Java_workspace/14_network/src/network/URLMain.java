package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLMain {

    public static void main(String[] args) throws IOException {
        // URL 객체를 생성하여 특정 웹 페이지의 주소를 지정
        URL url = new URL("https://www.naver.com/index.html");
        // URL 객체의 프로토콜(통신 방식) 정보를 출력
        System.out.println("프로토콜 = " + url.getProtocol());
        // URL 객체의 호스트(서버) 정보를 출력
        System.out.println("호스트 = " + url.getHost());
        // URL 객체의 포트 번호 정보를 출력 (지정되지 않은 경우 -1 반환)
        System.out.println("포트 = " + url.getPort()); // -1
        // URL 객체의 기본 포트 번호 정보를 출력 (HTTP의 경우 80, HTTPS의 경우 443)
        System.out.println("기본 포트 = " + url.getDefaultPort()); // 443
        // URL 객체의 파일 경로 정보를 출력
        System.out.println("파일 = " + url.getFile());
        System.out.println();
        // URL을 통해 입력 스트림을 열고, 이를 BufferedReader로 감싸서 버퍼링된 입력 스트림 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        // 한 줄씩 읽어오기 위해 초기화된 문자열 변수
        String line = null;
        // 입력 스트림에서 한 줄씩 읽어와 출력 (null이 아닐 때까지 반복)
        while ((line = br.readLine()) != null) { // null이 아닐 때까지 읽어라
            System.out.println(line);
            // Enter 값 입력하여 한줄 씩 보기.
            System.in.read();
            System.in.read();
            
        }
        // BufferedReader를 닫아 입력 스트림을 종료
        br.close();
    }

}
