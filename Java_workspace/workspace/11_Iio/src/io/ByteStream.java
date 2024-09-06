package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStream {

    public static void main(String[] args) throws IOException {
        // BufferedInputStream을 사용하여 파일 읽기
        // "data.txt" 파일을 읽기 위해 FileInputStream을 생성하고, 이를 BufferedInputStream으로 감싼다.
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("data.txt"));
        int data; // 읽어온 데이터를 정수형 변수에 저장
        
        // 파일에서 데이터를 1바이트씩 읽어들인다. -1이 반환되면 파일의 끝에 도달한 것이다.
        while( (data=bis.read()) != -1) { // bis.read()는 1바이트씩 읽어 정수로 반환, 파일 끝은 -1 반환
            // 읽어온 정수 데이터를 문자(char)로 변환하여 출력
            System.out.print((char)data); // 정수 데이터를 문자로 변환하여 출력
        }
        // while 문이 끝나면 파일 읽기가 완료되었음을 의미
        System.out.println(); // 줄바꿈 출력

        // 사용한 BufferedInputStream을 닫아 리소스 누수 방지
        bis.close(); // 파일 입력 스트림을 닫음
    } // enter 키 입력 시: 13(Carriage Return, \r), 10(Line Feed, \n)이 입력됨. [참고: flush 처리 시 두 번 처리 필요]

}
