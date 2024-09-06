package sungJuk; // 패키지 선언

import java.util.ArrayList; // ArrayList 클래스를 사용하기 위해 import
import java.util.Scanner; // 사용자 입력을 받기 위해 import

// SungJukInsert 클래스 선언, SungJuk 인터페이스를 구현
public class SungJukInsert implements SungJuk {

    // 인터페이스에서 정의된 메서드를 구현
    @Override
    public void execute(ArrayList<SungJukDTO> list) {
        // 성적 데이터를 입력받아 리스트에 추가하는 메서드
        
        System.out.println(); // 출력에서의 가독성을 위해 빈 줄 추가
        
        // 사용자 입력을 받기 위한 Scanner 객체 생성
        Scanner scan = new Scanner(System.in);
        
        // 사용자에게 성적 데이터를 입력받음
        System.out.print("번호 입력: ");
        int no = scan.nextInt(); // 입력받은 번호를 변수 no에 저장
        
        System.out.print("이름 입력: ");
        String name = scan.next(); // 입력받은 이름을 변수 name에 저장
        
        System.out.print("국어 입력: ");
        int kor = scan.nextInt(); // 입력받은 국어 점수를 변수 kor에 저장
        
        System.out.print("영어 입력: ");
        int eng = scan.nextInt(); // 입력받은 영어 점수를 변수 eng에 저장
        
        System.out.print("수학 입력: ");
        int math = scan.nextInt(); // 입력받은 수학 점수를 변수 math에 저장

        // 입력받은 데이터를 이용해 SungJukDTO 객체 생성
        SungJukDTO sungJukDTO = new SungJukDTO(no, name, kor, eng, math);
        // 총점과 평균을 계산하는 메서드 호출
        sungJukDTO.calc();
        
        // 입력받은 성적 데이터를 리스트에 추가
        list.add(sungJukDTO);
        
        // 입력 완료 메시지 출력
        System.out.println("입력되었습니다.");
    }
}
