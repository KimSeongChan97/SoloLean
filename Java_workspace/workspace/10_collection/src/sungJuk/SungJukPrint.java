package sungJuk; // 패키지 선언

import java.util.ArrayList; // ArrayList 클래스를 사용하기 위해 import

// SungJukPrint 클래스 선언, SungJuk 인터페이스를 구현
public class SungJukPrint implements SungJuk {
    // 성적 출력 기능을 제공하는 클래스

    // 인터페이스에서 정의된 메서드를 구현
    @Override
    public void execute(ArrayList<SungJukDTO> list) {
        // 성적 데이터를 출력하는 메서드

        System.out.println(); // 출력에서의 가독성을 위해 빈 줄 추가
        
        // 성적 데이터를 출력할 때 사용할 헤더를 출력
        System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
        
        // 리스트에 저장된 모든 성적 데이터를 반복하여 출력
        for (SungJukDTO sungJukDTO : list) {
            // 각 성적 객체의 정보를 출력
            // SungJukDTO 클래스의 toString() 메서드가 호출되어 각 필드의 값이 출력됨
            System.out.println(sungJukDTO);
        }
    }
}
