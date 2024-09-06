package io; // 패키지 선언: 이 클래스가 속한 패키지를 정의합니다. 이 경우 'io' 패키지입니다.

import java.io.FileInputStream; // FileInputStream 클래스 임포트: 파일로부터 바이트 단위로 데이터를 읽어오기 위해 사용됩니다.
import java.io.FileOutputStream; // FileOutputStream 클래스 임포트: 파일로 바이트 단위로 데이터를 쓰기 위해 사용됩니다.
import java.io.IOException; // IOException 클래스 임포트: 입출력 작업 중 발생할 수 있는 예외를 처리하기 위해 사용됩니다.
import java.io.ObjectInputStream; // ObjectInputStream 클래스 임포트: 객체 단위로 파일에서 데이터를 읽어오기 위해 사용됩니다.
import java.io.ObjectOutputStream; // ObjectOutputStream 클래스 임포트: 객체 단위로 파일에 데이터를 쓰기 위해 사용됩니다.

public class ObjectMain { // ObjectMain 클래스 선언: 이 클래스는 객체를 파일에 쓰고, 다시 읽어오는 기능을 구현합니다.

    // main 메서드: 자바 프로그램이 실행될 때 가장 먼저 호출되는 메서드입니다.
    // 이 메서드는 IOException과 ClassNotFoundException 예외를 throws하여 호출한 곳으로 예외를 전달합니다.
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 객체를 파일에 쓰기 위한 ObjectOutputStream 객체를 생성합니다.
        // 'result2.txt' 파일에 데이터를 쓰기 위해 FileOutputStream을 사용합니다.
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("result2.txt"));
        
        // PersonDTO 객체를 생성합니다. 이름, 나이, 키를 초기값으로 설정합니다.
        // 이 객체는 직렬화되어 파일에 저장될 것입니다.
        PersonDTO dto = new PersonDTO("홍길동", 25, 185.3);
        
        // 생성한 PersonDTO 객체를 파일에 씁니다.
        // writeObject 메서드는 객체를 직렬화하여 파일에 저장합니다.
        oos.writeObject(dto);
        
        // ObjectOutputStream을 닫습니다.
        // 스트림을 닫아 자원을 해제하고, 파일을 안전하게 닫습니다.
        oos.close();
        
        // 파일에서 객체를 읽어오기 위한 ObjectInputStream 객체를 생성합니다.
        // 'result2.txt' 파일로부터 데이터를 읽기 위해 FileInputStream을 사용합니다.
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("result2.txt"));
        
        // 파일에서 PersonDTO 객체를 읽어옵니다.
        // readObject 메서드는 파일에 저장된 객체를 역직렬화하여 메모리로 불러옵니다.
        PersonDTO dto2 = (PersonDTO) ois.readObject();
        
        // 읽어온 PersonDTO 객체의 정보를 출력합니다.
        // dto2 객체의 getName(), getAge(), getHeight() 메서드를 호출하여 이름, 나이, 키를 출력합니다.
        System.out.println("이름 = " + dto2.getName()); // dto2 객체의 이름을 출력합니다.
        System.out.println("나이 = " + dto2.getAge()); // dto2 객체의 나이를 출력합니다.
        System.out.println("키 = " + dto2.getHeight()); // dto2 객체의 키를 출력합니다.
        
        // ObjectInputStream을 닫습니다.
        // 스트림을 닫아 자원을 해제하고, 파일을 안전하게 닫습니다.
        ois.close();
    }
}

