package sungJuk; // 패키지 선언

import java.util.ArrayList; // ArrayList 클래스를 사용하기 위해 import
import java.util.Scanner; // 사용자 입력을 받기 위해 import

// SungJukUpdate 클래스 선언, SungJuk 인터페이스를 구현
public class SungJukUpdate implements SungJuk {
    // 성적 수정 기능을 제공하는 클래스

    // 인터페이스에서 정의된 메서드를 구현
    @Override
    public void execute(ArrayList<SungJukDTO> list) {
        // 사용자 입력을 받기 위한 Scanner 객체 생성
        Scanner scan = new Scanner(System.in);

        // 사용자에게 수정할 성적의 번호를 입력받음
        System.out.print("번호 입력: ");
        int no = scan.nextInt(); // 입력받은 번호를 변수 no에 저장
              
        boolean sw = false; // 번호의 존재 여부를 확인하기 위한 플래그 변수

        // 리스트에 저장된 성적 데이터를 하나씩 확인
        for (SungJukDTO sungJukDTO : list) {
            // 입력받은 번호와 일치하는 성적 데이터를 찾음
            if (sungJukDTO.getNo() == no) {
                sw = true; // 번호가 일치하면 플래그 변수를 true로 설정
                // 성적 데이터를 출력
                System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
                System.out.println(sungJukDTO);
                System.out.println();
                
                // 수정할 이름과 성적을 입력받음
                System.out.print("수정 할 이름 입력: ");
                String name = scan.next();
                System.out.print("수정 할 국어 입력: ");
                int kor = scan.nextInt();
                System.out.print("수정 할 영어 입력: ");
                int eng = scan.nextInt();
                System.out.print("수정 할 수학 입력: ");
                int math = scan.nextInt();
              
                // 입력받은 이름과 성적으로 성적 데이터를 수정
                sungJukDTO.setName(name);
                sungJukDTO.setKor(kor);
                sungJukDTO.setEng(eng);
                sungJukDTO.setMath(math);
                sungJukDTO.calc(); // 총점과 평균을 다시 계산

                // 수정 완료 메시지 출력
                System.out.println("수정하였습니다.");
                
                break; // 성적 데이터가 수정되면 반복문을 종료
            } // if
        } // for

        // 입력받은 번호가 리스트에 없을 경우 오류 메시지 출력
        if (!sw) System.out.println("잘못된 번호입니다.");
    }    
}
