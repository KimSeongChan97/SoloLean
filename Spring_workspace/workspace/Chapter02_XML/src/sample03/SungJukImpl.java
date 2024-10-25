package sample03;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;

@AllArgsConstructor
// @AllArgsConstructor 어노테이션은 Lombok에서 제공하는 기능으로, 모든 필드를 매개변수로 받는 생성자를 자동으로 생성합니다.
// 추가 설명: 이 어노테이션은 클래스의 모든 필드에 대한 생성자를 자동으로 생성해 줍니다. 
// 따라서 개발자가 일일이 생성자를 작성하지 않아도 되며, Spring에서 의존성 주입을 간편하게 사용할 수 있습니다.
public class SungJukImpl implements SungJuk {
    
	@Autowired
    private SungJukDTO sungJukDTO = null;
    // 추가 설명: SungJukDTO 객체를 의존성으로 주입받아 성적 데이터를 관리하는 역할을 합니다.
    // 이 필드는 실제 성적 데이터를 저장하고, 점수 계산 및 수정 시 사용됩니다.

    // 생성자를 통한 의존성 주입 (Constructor Injection)
    // 추가 설명: @AllArgsConstructor 어노테이션으로 인해 생성자는 자동으로 생성됩니다.
    // 외부에서 의존성 주입을 통해 sungJukDTO 객체가 이 클래스에 주입됩니다.
    // 이렇게 생성자를 통해 의존성을 주입하면 클래스 간 결합도가 낮아지고, 외부에서 객체의 상태를 쉽게 설정할 수 있습니다.
    // 기존 주석을 유지하며 @AllArgsConstructor를 통해 생성자가 자동 생성됨을 설명합니다.
    /*
    public SungJukImpl(SungJukDTO sungJukDTO) {
        this.sungJukDTO = sungJukDTO;
    }
    */

    @Override
    public void calcTot() {
        // 총점 계산
        // 추가 설명: 국어, 영어, 수학 점수를 더하여 총점을 계산합니다. sungJukDTO 객체의 getKor(), getEng(), getMath() 메서드를 통해
        // 각각의 점수를 가져와 합산한 후, setTot() 메서드를 통해 총점을 sungJukDTO 객체에 저장합니다.
        int tot = sungJukDTO.getKor() + sungJukDTO.getEng() + sungJukDTO.getMath();
        sungJukDTO.setTot(tot);
        // 추가 설명: 이 계산은 사용자가 입력한 국어, 영어, 수학 점수를 기반으로 하며, 총점을 다시 계산하고 저장합니다.
    }

    @Override
    public void calcAvg() {
        // 평균 계산
        // 추가 설명: 총점을 3으로 나누어 평균을 구합니다. 3.0으로 나누는 이유는 정수 계산이 아닌 소수점 이하까지
        // 계산하기 위해서입니다. getTot() 메서드로 총점을 가져와 3으로 나눈 값을 setAvg() 메서드를 통해 저장합니다.
        double avg = sungJukDTO.getTot() / 3.0;
        sungJukDTO.setAvg(avg);
        // 추가 설명: 3으로 나누는 이유는 과목이 3개(국어, 영어, 수학)이기 때문에, 각 과목의 평균을 구하기 위해 3.0으로 나눕니다.
    }

    @Override
    public void display() {
        // 결과 출력
        System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
        // 추가 설명: 점수 데이터 출력 전, 데이터를 보기 쉽게 탭 문자(\t)를 사용하여 표 형식으로 출력합니다.
        System.out.print(sungJukDTO);
        // 추가 설명: SungJukDTO 객체의 toString() 메서드가 호출되며, 성적 데이터를 출력합니다.
    }

    @Override
    public void modify() {
        // 입력을 받아 수정하는 기능
        // 추가 설명: 사용자로부터 입력을 받아 SungJukDTO 객체의 데이터를 수정합니다.
        // Scanner 클래스를 사용하여 입력을 받고, 입력된 값을 각각의 필드에 저장합니다.
        // 입력이 완료되면 총점과 평균을 다시 계산하는 calcTot() 및 calcAvg() 메서드를 호출하여 값을 업데이트합니다.
        Scanner sc = new Scanner(System.in);

        System.out.print("이름 입력: ");
        String name = sc.next();
        // 추가 설명: 사용자가 입력한 이름을 sungJukDTO 객체의 name 필드에 저장합니다.

        System.out.print("국어 입력: ");
        int kor = sc.nextInt();
        // 추가 설명: 사용자가 입력한 국어 점수를 sungJukDTO 객체의 kor 필드에 저장합니다.

        System.out.print("영어 입력: ");
        int eng = sc.nextInt();
        // 추가 설명: 사용자가 입력한 영어 점수를 sungJukDTO 객체의 eng 필드에 저장합니다.

        System.out.print("수학 입력: ");
        int math = sc.nextInt();
        // 추가 설명: 사용자가 입력한 수학 점수를 sungJukDTO 객체의 math 필드에 저장합니다.

        // sungJukDTO 객체에 수정된 데이터 설정
        sungJukDTO.setName(name);
        sungJukDTO.setKor(kor);
        sungJukDTO.setEng(eng);
        sungJukDTO.setMath(math);
        // 추가 설명: 입력받은 값을 각각의 필드에 저장하고, 총점과 평균을 다시 계산하여 갱신된 데이터를 저장합니다.
        
        // 총점과 평균 재계산
        // 추가 설명: 사용자 입력이 완료되면 calcTot() 메서드로 총점을 다시 계산하고,
        // calcAvg() 메서드로 평균을 다시 계산합니다. 이렇게 함으로써 수정된 점수를 반영한 결과가 정확하게 저장됩니다.
        calcTot();
        calcAvg();
    }
}
