package sungJukSolo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * SungJukInsert 클래스는 성적 입력 기능을 제공하는 클래스입니다.
 * 사용자가 입력한 성적 데이터를 리스트에 추가합니다.
 */
public class SungJukInsert implements SungJuk {
    /**
     * execute 메서드는 성적 데이터를 사용자로부터 입력받아 리스트에 추가하는 기능을 수행합니다.
     * 번호 중복 체크를 통해 중복된 번호가 입력되지 않도록 합니다.
     * @param list 성적 데이터가 저장된 ArrayList<SungJukDTO>
     */
    @Override
    public void execute(ArrayList<SungJukDTO> list) {
        Scanner scanner = new Scanner(System.in);  // 사용자 입력을 받기 위한 Scanner 객체 생성

        // 사용자에게 번호를 입력받음
        System.out.print("번호 입력: ");
        int no = scanner.nextInt();
        
        // 입력된 번호가 이미 존재하는지 체크
        for (SungJukDTO dto : list) {
            if (dto.getNo() == no) {
                // 번호가 중복될 경우 경고 메시지를 출력하고 메서드를 종료
                System.out.println("중복된 번호입니다.");
                return;
            }
        }

        // 사용자에게 이름을 입력받음
        System.out.print("이름 입력: ");
        String name = scanner.next();

        // 사용자에게 국어 점수를 입력받음
        System.out.print("국어 입력: ");
        int kor = scanner.nextInt();

        // 사용자에게 영어 점수를 입력받음
        System.out.print("영어 입력: ");
        int eng = scanner.nextInt();

        // 사용자에게 수학 점수를 입력받음
        System.out.print("수학 입력: ");
        int math = scanner.nextInt();

        // 입력받은 데이터를 이용하여 새로운 SungJukDTO 객체를 생성
        SungJukDTO dto = new SungJukDTO(no, name, kor, eng, math);  
        
        // 생성된 객체를 리스트에 추가
        list.add(dto);  

        // 입력 완료 메시지를 출력
        System.out.println("입력되었습니다.");
    }
}
