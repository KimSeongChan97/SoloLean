package sample03;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SungJukImpl implements SungJuk {
    private SungJukDTO sungJukDTO;

    // 생성자를 통한 의존성 주입 (Constructor Injection)
    @Autowired
    public SungJukImpl(SungJukDTO sungJukDTO) {
        this.sungJukDTO = sungJukDTO;
    }

    @Override
    public void calcTot() {
        // 총점 계산
        int tot = sungJukDTO.getKor() + sungJukDTO.getEng() + sungJukDTO.getMath();
        sungJukDTO.setTot(tot);
    }

    @Override
    public void calcAvg() {
        // 평균 계산
        double avg = sungJukDTO.getTot() / 3.0;
        sungJukDTO.setAvg(avg);
    }

    @Override
    public void display() {
        // 결과 출력
        System.out.println("이름: " + sungJukDTO.getName());
        System.out.println("국어: " + sungJukDTO.getKor());
        System.out.println("영어: " + sungJukDTO.getEng());
        System.out.println("수학: " + sungJukDTO.getMath());
        System.out.println("총점: " + sungJukDTO.getTot());
        System.out.println("평균: " + sungJukDTO.getAvg());
    }

    @Override
    public void modify() {
        // 입력을 받아 수정하는 기능
        Scanner scanner = new Scanner(System.in);

        System.out.print("이름 입력: ");
        sungJukDTO.setName(scanner.next());

        System.out.print("국어 입력: ");
        sungJukDTO.setKor(scanner.nextInt());

        System.out.print("영어 입력: ");
        sungJukDTO.setEng(scanner.nextInt());

        System.out.print("수학 입력: ");
        sungJukDTO.setMath(scanner.nextInt());

        // 총점과 평균 재계산
        calcTot();
        calcAvg();
    }
}
