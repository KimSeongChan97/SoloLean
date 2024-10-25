package network;  // 네트워크 관련 클래스들이 포함된 패키지 선언

import java.io.BufferedReader;  // 버퍼링된 리더를 사용하기 위한 import
import java.io.IOException;  // 입출력 예외 처리를 위한 import
import java.io.InputStreamReader;  // 입력 스트림을 리더로 변환하기 위한 import
import java.net.URL;  // URL 객체를 사용하기 위한 import

public class URL2Main {  // URL2Main 클래스 선언

    public static void main(String[] args) throws IOException {  // main 메서드 시작, IOException을 던질 수 있음
        // URL 객체를 생성하여 특정 웹 페이지의 주소를 지정
        URL url = new URL("http://www.goldria.net/m/product_list.html?xcode=012");
        
        // URL을 통해 입력 스트림을 열고, 이를 BufferedReader로 감싸서 버퍼링된 입력 스트림 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        String line = null;  // 한 줄씩 읽어올 변수를 초기화

        // 입력 스트림에서 한 줄씩 읽어와서 처리 (null 이 아닐 때까지 반복)
        while ((line = br.readLine()) != null) {  // 한 줄씩 읽어와서 line 변수에 저장, null 이 아닐 때까지 반복
            System.out.println(line);  // 읽어온 줄을 출력
        }
        
        // BufferedReader를 닫아 입력 스트림을 종료
        br.close();  // BufferedReader를 닫아 리소스를 해제
    }
}
