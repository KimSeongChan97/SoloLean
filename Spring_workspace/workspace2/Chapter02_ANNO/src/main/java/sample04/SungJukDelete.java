package sample04;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SungJukDelete implements SungJuk {

	@Autowired
    private List<SungJukDTO2> list;
	
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("삭제할 이름 입력: ");
        String name = scanner.next();

        for (SungJukDTO2 dto : list) {
            if (dto.getName().equals(name)) {
                list.remove(dto);
                System.out.println(dto.getName() + "님의 데이터를 삭제하였습니다.");
                return;
            }
        }
        System.out.println("찾고자 하는 이름이 없습니다.");
    }
}
