package sample04;

import java.util.List;
import java.util.Scanner;

import lombok.Setter;

public class SungJukInput implements SungJuk {
    @Setter
    // @Setter: Lombok 라이브러리의 어노테이션으로, 이 필드에 대해 자동으로 setter 메서드를 생성합니다.
    // 즉, 외부에서 이 클래스에 SungJukDTO2 객체를 주입할 수 있는 setter 메서드가 자동으로 만들어집니다.
    // Spring에서는 의존성 주입(Dependency Injection)을 통해 sungJukDTO2 객체가 주입될 수 있습니다.
    private SungJukDTO2 sungJukDTO2 = null;

    @Setter
    // @Setter: 이 필드(list)에 대해서도 setter 메서드가 Lombok에 의해 자동으로 생성됩니다.
    // List<SungJukDTO2>는 여러 학생의 성적 데이터를 저장하는 리스트로, Spring에서 주입될 수 있습니다.
    private List<SungJukDTO2> list;
    
//  public void setSungJukDTO2(SungJukDTO2 sungJukDTO2) {
//      this.sungJukDTO2 = sungJukDTO2;
//  }
    // 위 코드는 setter 메서드를 수동으로 작성한 코드입니다.
    // 하지만 Lombok의 @Setter 어노테이션을 사용했기 때문에, 이 코드는 주석 처리되어 있습니다.
    // Lombok이 자동으로 setter 메서드를 생성해 주므로 직접 작성할 필요가 없습니다.

//  public void setList(List<SungJukDTO2> list) {
//      this.list = list;
//  }
    // 마찬가지로, 리스트에 대한 setter 메서드도 Lombok @Setter로 대체되어 자동으로 생성됩니다.
    // 수동으로 작성된 setter는 주석 처리되었습니다.

    @Override
    public void execute() {
        System.out.println(); // 공백 줄 출력
        Scanner scan = new Scanner(System.in); // 사용자로부터 입력을 받기 위한 Scanner 객체 생성

        System.out.print("이름 입력: ");
        String name = scan.next(); // 사용자가 입력한 이름을 저장

        System.out.print("국어점수 입력: ");
        int kor = scan.nextInt(); // 사용자가 입력한 국어 점수를 저장

        System.out.print("영어점수 입력: ");
        int eng = scan.nextInt(); // 사용자가 입력한 영어 점수를 저장

        System.out.print("수학점수 입력: ");
        int math = scan.nextInt(); // 사용자가 입력한 수학 점수를 저장

        // 국어, 영어, 수학 점수를 합산하여 총점을 계산
        int tot = kor + eng + math;

        // 평균을 계산, 총점을 3.0으로 나누어 실수형 평균을 구함
        double avg = tot / 3.0;

        // 성적 데이터를 SungJukDTO2 객체에 설정
        sungJukDTO2.setName(name); // 이름 설정
        sungJukDTO2.setKor(kor); // 국어 점수 설정
        sungJukDTO2.setEng(eng); // 영어 점수 설정
        sungJukDTO2.setMath(math); // 수학 점수 설정
        sungJukDTO2.setTot(tot); // 총점 설정
        sungJukDTO2.setAvg(avg); // 평균 설정

        // SungJukDTO2 객체를 리스트에 추가
        list.add(sungJukDTO2);

        // 입력 완료 메시지 출력
        System.out.println(name + "님의 데이터를 입력 하였습니다.");
        System.out.println(); // 공백 줄 출력
    }
}
