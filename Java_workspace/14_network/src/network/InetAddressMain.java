package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMain {

    public static void main(String[] args) throws UnknownHostException {
        // www.naver.com의 IP 주소를 InetAddress 객체로 가져오기
        InetAddress naver = InetAddress.getByName("www.naver.com");
        // naver 객체에서 IP 주소를 문자열로 가져와 출력
        System.out.println("Naver IP = " + naver.getHostAddress());
        System.out.println();

        // 로컬 호스트(현재 컴퓨터)의 IP 주소를 InetAddress 객체로 가져오기
        InetAddress local = InetAddress.getLocalHost();
        // local 객체에서 IP 주소를 문자열로 가져와 출력
        System.out.println("localhost IP = " + local.getHostAddress());
        System.out.println();

        // www.naver.com 도메인에 할당된 모든 IP 주소를 InetAddress 배열로 가져오기
        InetAddress[] ar = InetAddress.getAllByName("www.naver.com");
        	// 가져온 모든 IP 주소를 순회하며 출력
	        for (InetAddress data : ar) {
	            System.out.println("Naver IP = " + data.getHostAddress());
	            System.out.println();
	        }
    }
}
