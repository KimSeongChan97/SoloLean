package sample04;

import java.util.List;
import java.util.Scanner;

public class SungJukInput implements SungJuk {

    private List<SungJukDTO2> list; // applicationContext에서 주입될 리스트
    // 추가 설명: 이 리스트는 Spring의 DI(Dependency Injection)로 주입될 예정입니다.
    // applicationContext.xml 파일에서 이 리스트가 설정되어 이 클래스의 list 필드에 주입됩니다.
    // SungJukDTO2 객체들이 이 리스트에 추가되며, 이는 프로그램 내에서 공유되고 사용됩니다.

    // Setter Injection
    // 추가 설명: 이 메서드는 Setter Injection을 통해 외부에서 의존성을 주입받습니다.
    // Spring 컨테이너는 applicationContext.xml에서 정의된 list를 이 메서드를 통해 주입합니다.
    // Setter Injection은 객체가 생성된 후에 필요한 값을 주입하는 방법 중 하나입니다.
    public void setList(List<SungJukDTO2> list) {
        this.list = list;
    }

    @Override
    public void execute() {
        // 추가 설명: 이 메서드는 실제로 사용자로부터 데이터를 입력받아 SungJukDTO2 객체를 생성하고, 
        // 생성된 데이터를 리스트에 저장하는 역할을 합니다.

        Scanner scan = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성
        SungJukDTO2 dto = new SungJukDTO2(); // 새로운 SungJukDTO2 객체 생성
        // 추가 설명: 사용자가 입력한 데이터를 저장할 SungJukDTO2 객체를 생성합니다.
        // 각 입력된 데이터는 dto 객체의 필드에 저장되며, 이후 리스트에 추가됩니다.

        System.out.print("이름 입력: ");
        dto.setName(scan.next()); // 사용자로부터 이름을 입력받아 dto 객체에 저장
        // 추가 설명: 사용자 입력을 통해 이름을 받아 dto 객체의 name 필드에 저장합니다.
        // dto.setName() 메서드를 사용하여 데이터를 저장합니다.

        System.out.print("국어점수 입력: ");
        dto.setKor(scan.nextInt()); // 사용자로부터 국어 점수를 입력받아 dto 객체에 저장
        // 추가 설명: 입력된 국어 점수는 dto 객체의 kor 필드에 저장됩니다.

        System.out.print("영어점수 입력: ");
        dto.setEng(scan.nextInt()); // 사용자로부터 영어 점수를 입력받아 dto 객체에 저장
        // 추가 설명: 입력된 영어 점수는 dto 객체의 eng 필드에 저장됩니다.

        System.out.print("수학점수 입력: ");
        dto.setMath(scan.nextInt()); // 사용자로부터 수학 점수를 입력받아 dto 객체에 저장
        // 추가 설명: 입력된 수학 점수는 dto 객체의 math 필드에 저장됩니다.

        // 총점 계산: 국어, 영어, 수학 점수를 합하여 총점을 계산
        dto.setTot(dto.getKor() + dto.getEng() + dto.getMath());
        // 추가 설명: 국어, 영어, 수학 점수를 합산하여 총점을 계산한 후, dto 객체의 tot 필드에 저장합니다.

        // 평균 계산: 총점을 3으로 나누어 평균을 계산
        dto.setAvg(dto.getTot() / 3.0);
        // 추가 설명: 총점을 3으로 나누어 평균을 계산하고, dto 객체의 avg 필드에 저장합니다.
        // 나누기 연산에서 3.0을 사용한 이유는 실수형(double) 계산을 위해서입니다.

        list.add(dto); // 생성된 dto 객체를 리스트에 추가
        // 추가 설명: 입력된 데이터를 포함한 dto 객체를 list에 추가합니다.
        // 이 리스트는 applicationContext에서 주입된 리스트로, 다른 객체들과 공유될 수 있습니다.

        System.out.println(dto.getName() + "님의 데이터를 입력 하였습니다.");
        // 추가 설명: 입력이 완료된 후, 성공적으로 데이터를 입력했음을 사용자에게 알리는 메시지를 출력합니다.
    }
}
