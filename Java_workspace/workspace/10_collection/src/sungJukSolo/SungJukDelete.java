package sungJukSolo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * SungJukDelete 클래스는 성적 삭제 기능을 제공하는 클래스입니다.
 * 성적 데이터 리스트에서 특정 이름의 성적 정보를 삭제합니다.
 */
public class SungJukDelete implements SungJuk {
    /**
     * execute 메서드는 성적 데이터를 리스트에서 삭제하는 기능을 수행합니다.
     * 사용자로부터 삭제할 이름을 입력받아, 해당 이름의 성적 정보를 리스트에서 제거합니다.
     * @param list 성적 데이터가 저장된 ArrayList<SungJukDTO>
     */
    @Override
    public void execute(ArrayList<SungJukDTO> list) {
        Scanner scanner = new Scanner(System.in);  // 사용자 입력을 받기 위한 Scanner 객체 생성

        // 사용자에게 삭제할 이름을 입력받음
        System.out.print("삭제할 이름 입력: ");
        String name = scanner.next();

        // 리스트에서 성적 정보를 순회하기 위한 Iterator 객체 생성
        Iterator<SungJukDTO> it = list.iterator();
        int count = 0;  // 삭제된 항목의 수를 기록할 변수

        // 리스트를 순회하며 입력된 이름과 일치하는 성적 정보를 찾음
        while (it.hasNext()) {
            SungJukDTO dto = it.next();
            if (dto.getName().equals(name)) {
                it.remove();  // 이름이 일치하면 해당 항목을 리스트에서 제거
                count++;  // 삭제된 항목의 수 증가
            }
        }

        // 삭제된 항목이 없는 경우와 삭제된 항목이 있는 경우를 구분하여 메시지 출력
        if (count == 0) {
            System.out.println("회원의 정보가 없습니다.");
        } else {
            System.out.printf("%d건의 항목을 삭제하였습니다.\n", count);
        }
    }
}
