package io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStream2 {

    public static void main(String[] args) throws IOException {
        // "data.txt" 파일을 나타내는 File 객체를 생성
        File file = new File("data.txt"); // 파일 경로를 사용하여 File 객체 생성

        // FileInputStream을 사용하여 파일을 읽고, BufferedInputStream으로 감싸서 버퍼링
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file)); // 파일 입력 스트림 생성 및 버퍼링

        // 파일의 크기를 알아내기
        int size = (int) file.length(); // 파일 크기를 바이트 단위로 반환 (long 타입을 int 로 형변환)

        // 파일 크기만큼의 바이트 배열을 생성
        byte[] b = new byte[size]; // 파일 크기만큼의 바이트 배열 생성

        // 파일 내용을 바이트 배열에 한번에 읽어들임
        bis.read(b, 0, size); // 파일의 내용을 바이트 배열에 읽어들임. (b 배열에 0번 인덱스부터 size 만큼)
        
        // 바이트 배열을 문자열로 변환하여 출력
        System.out.println(new String(b)); // 바이트 배열을 문자열로 변환하여 출력

        // BufferedInputStream을 닫아 리소스 해제
        bis.close(); // 파일 입력 스트림 닫기
    }

}
