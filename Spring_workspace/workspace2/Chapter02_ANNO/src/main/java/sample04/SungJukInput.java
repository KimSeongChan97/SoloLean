package sample04;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SungJukInput implements SungJuk {
	
	@Autowired
    private List<SungJukDTO2> list; //  Spring이 List<SungJukDTO2>를 자동으로 주입합니다.
	
    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        SungJukDTO2 dto = new SungJukDTO2();

        System.out.print("이름 입력: ");
        dto.setName(scan.next());

        System.out.print("국어점수 입력: ");
        dto.setKor(scan.nextInt());

        System.out.print("영어점수 입력: ");
        dto.setEng(scan.nextInt());

        System.out.print("수학점수 입력: ");
        dto.setMath(scan.nextInt());

        dto.setTot(dto.getKor() + dto.getEng() + dto.getMath());
        dto.setAvg(dto.getTot() / 3.0);
        
        list.add(dto);
        System.out.println(dto.getName() + "님의 데이터를 입력 하였습니다.");
    }
}
