package sungJukSolo;

import java.util.ArrayList;
import java.util.Scanner;

public class SungJukUpdate implements SungJuk {
    // 성적 수정 기능을 제공하는 클래스

    @Override
    public void execute(ArrayList<SungJukDTO> list) {
        // Scanner 객체를 생성하여 사용자 입력을 받기 위해 준비
        Scanner scanner = new Scanner(System.in);

        // 수정할 학생의 번호를 입력 받음
        System.out.print("번호 입력: ");
        int no = scanner.nextInt();

        SungJukDTO target = null; // 수정할 학생 정보를 저장할 변수

        // 입력받은 번호와 일치하는 학생 정보를 찾음
        for (SungJukDTO dto : list) {
            if (dto.getNo() == no) {
                target = dto; // 일치하는 학생을 찾으면 target에 저장
                break; // 찾았으므로 반복문 종료
            }
        }

        // 입력한 번호에 해당하는 학생이 없는 경우
        if (target == null) {
            System.out.println("잘못된 번호입니다."); // 오류 메시지 출력
            return; // 메소드 종료
        }

        // 해당 학생의 현재 성적 정보를 출력
        System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
        System.out.println(target);

        // 수정할 이름 입력 받음
        System.out.print("수정 할 이름 입력: ");
        target.setName(scanner.next());

        // 수정할 국어 점수 입력 받음
        System.out.print("수정 할 국어 입력: ");
        target.setKor(scanner.nextInt());

        // 수정할 영어 점수 입력 받음
        System.out.print("수정 할 영어 입력: ");
        target.setEng(scanner.nextInt());

        // 수정할 수학 점수 입력 받음
        System.out.print("수정 할 수학 입력: ");
        target.setMath(scanner.nextInt());

        // 총점과 평균을 재계산
        target.calc();

        // 수정 완료 메시지 출력
        System.out.println("수정하였습니다.");
    }
}

