package sample04;

import java.util.List;
import java.util.Scanner;

public class SungJukDelete implements SungJuk {

    private List<SungJukDTO2> list;
    // applicationContext에서 주입될 리스트
    // 추가 설명: 이 리스트는 Spring에서 의존성 주입을 통해 외부에서 주입됩니다.
    // 성적 데이터를 담고 있는 SungJukDTO2 객체들이 이 리스트에 저장되며, 삭제할 때도 이 리스트에서 제거됩니다.

    // Setter Injection
    // 추가 설명: Spring 컨테이너가 이 메서드를 사용하여 리스트 객체를 주입합니다.
    // 외부에서 관리되는 list 객체가 주입되어 내부 필드에 설정됩니다.
    public void setList(List<SungJukDTO2> list) {
        this.list = list;
    }

    @Override
    public void execute() {
        // 추가 설명: 이 메서드는 특정 이름을 가진 학생의 데이터를 리스트에서 삭제하는 기능을 합니다.
        // 사용자는 삭제할 학생의 이름을 입력하고, 리스트에서 해당 이름을 가진 학생의 데이터를 삭제합니다.

        Scanner scanner = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성
        System.out.print("삭제할 이름 입력: ");
        String name = scanner.next(); // 삭제할 학생의 이름을 입력받음

        // 리스트를 순회하며 해당 이름을 가진 학생을 찾음
        for (SungJukDTO2 dto : list) {
            // 입력받은 이름과 리스트에 있는 학생의 이름이 일치하는지 확인
            if (dto.getName().equals(name)) {
                // 추가 설명: 리스트 내에서 dto.getName() 메서드를 사용해 각 SungJukDTO2 객체의 이름을 가져와
                // 입력된 이름과 비교합니다. equals() 메서드는 문자열 비교를 위해 사용됩니다.

                list.remove(dto); // 리스트에서 해당 학생의 데이터를 삭제
                // 추가 설명: list.remove(dto)를 통해 리스트에서 해당 SungJukDTO2 객체를 삭제합니다.
                // 리스트는 ArrayList 또는 LinkedList와 같은 List 인터페이스를 구현한 자료구조일 가능성이 높으며,
                // 이 메서드는 해당 객체를 리스트에서 제거하는 역할을 합니다.

                System.out.println(dto.getName() + "님의 데이터를 삭제하였습니다.");
                // 추가 설명: 데이터를 성공적으로 삭제한 후, 사용자에게 삭제 완료 메시지를 출력합니다.
                return; // 데이터 삭제 후 메서드를 종료하여 반복문을 빠져나옵니다.
            }
        }
        System.out.println("찾고자 하는 이름이 없습니다.");
        // 추가 설명: 리스트를 모두 순회한 후에도 일치하는 이름을 찾지 못하면, 해당 이름이 없다는 메시지를 출력합니다.
    }
}
