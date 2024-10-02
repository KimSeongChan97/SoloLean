package sample04;

import java.util.List;
import java.util.Scanner;

public class SungJukUpdate implements SungJuk {

    private List<SungJukDTO2> list; 
    // applicationContext에서 주입될 리스트
    // 추가 설명: 이 리스트는 Spring의 의존성 주입(DI, Dependency Injection)을 통해 주입됩니다. 
    // 외부 설정 파일에서 관리되고, 성적 데이터(SungJukDTO2 객체들)를 담고 있는 리스트입니다.

    // Setter Injection
    // 추가 설명: Spring에서 이 메서드를 사용하여 의존성(리스트 객체)을 주입합니다.
    // 외부에서 주입된 list 객체는 이후에 성적 데이터를 저장하고 수정하는데 사용됩니다.
    public void setList(List<SungJukDTO2> list) {
        this.list = list;
    }

    @Override
    public void execute() {
        // 추가 설명: 이 메서드는 성적 데이터 중에서 특정 이름을 가진 학생의 데이터를 수정하는 역할을 합니다.
        // 사용자 입력을 통해 이름을 검색하고, 해당 학생의 국어, 영어, 수학 점수를 새로 입력받아 업데이트합니다.
        
        Scanner scanner = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성
        System.out.print("수정할 이름 입력: ");
        String name = scanner.next(); // 수정할 학생의 이름을 입력받음

        // 리스트를 순회하며 해당 이름을 가진 학생을 찾음
        for (SungJukDTO2 dto : list) {
            // 입력받은 이름과 리스트에 있는 학생의 이름이 일치하는지 확인
            if (dto.getName().equals(name)) { 
                // 추가 설명: dto.getName() 메서드를 통해 리스트에 저장된 각 SungJukDTO2 객체의 이름을 가져와 
                // 입력받은 이름과 비교합니다. equals() 메서드는 문자열 비교 시 사용됩니다.

                System.out.println("수정할 국어 점수 입력: ");
                dto.setKor(scanner.nextInt()); // 새로운 국어 점수를 입력받아 설정

                System.out.println("수정할 영어 점수 입력: ");
                dto.setEng(scanner.nextInt()); // 새로운 영어 점수를 입력받아 설정

                System.out.println("수정할 수학 점수 입력: ");
                dto.setMath(scanner.nextInt()); // 새로운 수학 점수를 입력받아 설정

                // 총점 및 평균 재계산
                dto.setTot(dto.getKor() + dto.getEng() + dto.getMath()); 
                // 추가 설명: 새로운 점수를 바탕으로 총점을 다시 계산하여 저장합니다.
                dto.setAvg(dto.getTot() / 3.0); 
                // 추가 설명: 총점을 3으로 나누어 평균을 계산하고 저장합니다. 3.0으로 나누는 이유는 정수형이 아닌 
                // 소수점 이하의 계산을 포함한 평균을 구하기 위함입니다.

                System.out.println(dto.getName() + "님의 데이터를 수정하였습니다.");
                // 추가 설명: 데이터를 성공적으로 수정한 후, 사용자에게 수정 완료 메시지를 출력합니다.
                return; // 데이터 수정이 완료되었으므로 메서드를 종료
            }
        }
        System.out.println("찾고자 하는 이름이 없습니다.");
        // 추가 설명: 리스트에서 해당 이름을 찾지 못한 경우, 사용자가 잘못된 이름을 입력한 경우로 간주하고, 
        // 해당 이름이 없다는 메시지를 출력합니다.
    }
}
