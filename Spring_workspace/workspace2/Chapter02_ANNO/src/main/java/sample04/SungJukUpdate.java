package sample04;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SungJukUpdate implements SungJuk {
	
	@Autowired
    private List<SungJukDTO2> list;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("수정할 이름 입력: ");
        String name = scanner.next();

        for (SungJukDTO2 dto : list) {
            if (dto.getName().equals(name)) {
                System.out.println("수정할 국어 점수 입력: ");
                dto.setKor(scanner.nextInt());
                System.out.println("수정할 영어 점수 입력: ");
                dto.setEng(scanner.nextInt());
                System.out.println("수정할 수학 점수 입력: ");
                dto.setMath(scanner.nextInt());

                dto.setTot(dto.getKor() + dto.getEng() + dto.getMath());
                dto.setAvg(dto.getTot() / 3.0);

                System.out.println(dto.getName() + "님의 데이터를 수정하였습니다.");
                return;
            }
        }
        System.out.println("찾고자 하는 이름이 없습니다.");
    }
}
