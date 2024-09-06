package io; // 패키지 선언: 현재 클래스가 속한 패키지를 정의합니다.

import java.io.DataInputStream; // DataInputStream 클래스를 가져옵니다. 기본 데이터 타입을 읽기 위해 사용됩니다.
import java.io.DataOutputStream; // DataOutputStream 클래스를 가져옵니다. 기본 데이터 타입을 쓰기 위해 사용됩니다.
import java.io.FileInputStream; // FileInputStream 클래스를 가져옵니다. 파일에서 데이터를 읽기 위해 사용됩니다.
import java.io.FileOutputStream; // FileOutputStream 클래스를 가져옵니다. 파일에 데이터를 쓰기 위해 사용됩니다.
import java.io.IOException; // IOException 클래스를 가져옵니다. 입출력 예외를 처리하기 위해 사용됩니다.

public class DataStream { // 클래스 선언: DataStream이라는 이름의 클래스를 정의합니다.

	// main 메서드: 프로그램의 시작점입니다.
	// Java 프로그램이 실행되면 가장 먼저 main 메서드가 호출됩니다.
	public static void main(String[] args) throws IOException { // IOException을 throws 하여 입출력 예외가 발생할 수 있음을 명시합니다.
		// FileOutputStream 객체를 생성합니다. 파일이 없으면 자동으로 생성됩니다.
		// "result.txt" 파일에 데이터를 쓰기 위해 FileOutputStream을 생성합니다.
		FileOutputStream fos = new FileOutputStream("result.txt"); 
		// DataOutputStream 객체를 생성합니다. 기본 데이터 타입을 파일에 쓰기 위해 사용됩니다.
		DataOutputStream dos = new DataOutputStream(fos);
		// DataOutputStream dos = new DataOutputStream(new FileOutputStream("result.txt")); 위의 줄을 한줄로 요약
		
		// UTF-8 형식의 문자열을 파일에 씁니다.
		dos.writeUTF("홍길동"); 
		// 정수를 파일에 씁니다.
		dos.writeInt(25); 
		// 실수를 파일에 씁니다.
		dos.writeDouble(185.3); 

		// DataOutputStream을 닫습니다. 자원을 해제하고 파일에 모든 데이터를 쓰기 위해 반드시 필요합니다.
		dos.close(); 

		// FileInputStream 객체를 생성합니다. "result.txt" 파일에서 데이터를 읽기 위해 FileInputStream을 생성합니다.
		DataInputStream dis = new DataInputStream(new FileInputStream("result.txt")); 

		// UTF-8 형식의 문자열을 파일에서 읽습니다.
		String name = dis.readUTF(); 
		// 정수를 파일에서 읽습니다.
		int age = dis.readInt(); 
		// 실수를 파일에서 읽습니다.
		double height = dis.readDouble(); 

		// 읽은 데이터를 출력합니다.
		System.out.println("이름 = " + name); 
		System.out.println("나이 = " + age); 
		System.out.println("키 = " + height); 

		// DataInputStream을 닫습니다. 자원을 해제하기 위해 반드시 필요합니다.
		dis.close(); 
	}
}
