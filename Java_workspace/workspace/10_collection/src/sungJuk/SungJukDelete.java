package sungJuk; // 패키지 선언

import java.util.ArrayList; // ArrayList 클래스를 사용하기 위해 import
import java.util.Iterator; // Iterator 인터페이스를 사용하기 위해 import
import java.util.Scanner; // 사용자 입력을 받기 위해 import

// SungJukDelete 클래스 선언, SungJuk 인터페이스를 구현
public class SungJukDelete implements SungJuk {

    // 성적 삭제 기능을 제공하는 클래스
    // 인터페이스에서 정의된 메서드를 구현
    @Override
    public void execute(ArrayList<SungJukDTO> list) {
        System.out.println();
        // 성적 데이터를 삭제하는 메서드
        // 사용자 입력을 받기 위한 Scanner 객체 생성
        Scanner scan = new Scanner(System.in);
        // 사용자에게 삭제할 이름을 입력받음
        System.out.print("삭제할 이름 입력: ");
        String name = scan.next(); // 입력받은 이름을 변수 name에 저장
        // 리스트를 순회하며 요소를 삭제하기 위한 Iterator 객체 생성
        Iterator<SungJukDTO> it = list.iterator(); // iterator 는 항목을 가리키는 역할
        int count = 0; // 삭제된 항목의 개수를 세기 위한 변수
        // 리스트의 모든 요소를 순회
        while (it.hasNext()) {
            SungJukDTO sungJukDTO = it.next(); // 현재 요소를 가져옴
            // 요소의 이름이 입력받은 이름과 일치하는 경우
            if (sungJukDTO.getName().equals(name)) {
                it.remove(); // 해당 이름의 성적 정보를 삭제
                count++; // 삭제된 항목의 개수를 증가
            }
        }

        // 삭제된 항목의 개수를 기준으로 메시지 출력
        if (count == 0) {
            System.out.println("회원의 정보가 없습니다."); // 삭제된 항목이 없는 경우
        } else {
            System.out.println(count + "건의 항목을 삭제하였습니다."); // 삭제된 항목이 있는 경우
        }
    }
}

/*

for(SungJukDTO sungJukDTO : list) {
    // 리스트의 각 요소를 순회
    if(sungJukDTO.getName().equals(name)) {
        // 요소의 이름이 입력받은 이름과 일치하는 경우
        list.remove(sungJukDTO);
        // 해당 요소를 리스트에서 삭제
        count++;
        // 삭제된 항목의 개수를 증가
    }
} //for

// 삭제된 항목의 개수를 기준으로 메시지 출력
if (count == 0) {
    System.out.println("회원의 정보가 없습니다."); // 삭제된 항목이 없는 경우
} else {
    System.out.printf("%d건의 항목을 삭제하였습니다.\n", count); // 삭제된 항목이 있는 경우
}

*/
