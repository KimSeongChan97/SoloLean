package sample03;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// @Component 어노테이션을 사용하여 Spring 컨테이너에서 관리되는 Bean으로 등록
// 추가 설명: 이 클래스는 Spring 컨테이너에서 Bean으로 등록되어 관리됩니다. @Component 어노테이션을 사용하면,
// Spring이 자동으로 이 클래스를 스캔하여 Bean으로 등록하고, 필요할 때 의존성 주입을 통해 사용할 수 있습니다.
// @Component


public class SungJukImpl implements SungJuk {
	// 필드에 @Autowired 어노테이션을 사용하여 의존성 주입
	// 추가 설명: @Autowired 어노테이션은 Spring 컨테이너가 관리하는 Bean 중에서 SungJukDTO 타입의 Bean을 찾아서 자동으로 주입해줍니다.
	// 필드에 직접 주입하는 방식(Field Injection)으로, Spring이 SungJukDTO 객체를 자동으로 이 필드에 주입합니다.
	// Spring은 타입을 기준으로 Bean을 찾아 주입하므로, 동일한 타입의 Bean이 있을 경우 적절한 Bean이 선택됩니다.
	// 생성된 빈 중에서 SungJukDTO를 찾아서 자동 매핑
	// 생성자 이건 Setter 이건 상관없이 SungJukDTO를 찾아서 자동으로 매핑한다.
	@Autowired
	private SungJukDTO sungJukDTO = null;

	// 생성자를 통한 의존성 주입 방식이 사라지고 필드 주입 방식으로 변경됨
	// 추가 설명: 이전에는 생성자를 통한 의존성 주입 방식(Constructor Injection)을 사용했지만, 지금은 필드 주입(Field Injection) 방식으로 변경되었습니다.
	// 즉, 생성자를 사용하지 않고, 필드에 직접적으로 @Autowired 어노테이션을 붙여 의존성을 주입받습니다.
	// 이 방식은 코드가 간결해지는 장점이 있지만, 테스트나 유지보수 측면에서 생성자 주입이 권장될 수 있습니다.

	// 생성자
	// 추가 설명: 생성자는 더 이상 의존성 주입에 사용되지 않으며, 의존성 주입은 @Autowired가 적용된 필드를 통해 이루어집니다.
	public SungJukImpl(SungJukDTO sungJukDTO) {
         this.sungJukDTO = sungJukDTO;
	    // 추가 설명: 생성자가 의존성 주입 역할을 하지는 않지만, 이 경우 생성자로 전달된 객체를 해당 필드에 할당하는 역할을 합니다.
	}


    @Override
    public void calcTot() {
        // 총점 계산
        // 추가 설명: 국어, 영어, 수학 점수를 더하여 총점을 계산합니다. 
        // sungJukDTO 객체의 getKor(), getEng(), getMath() 메서드를 통해 점수를 가져와 합산한 후, 
        // setTot() 메서드를 통해 계산된 총점을 SungJukDTO 객체에 저장합니다.
        int tot = sungJukDTO.getKor() + sungJukDTO.getEng() + sungJukDTO.getMath();
        sungJukDTO.setTot(tot);
    }

    @Override
    public void calcAvg() {
        // 평균 계산
        // 추가 설명: 총점을 3으로 나누어 평균을 구합니다. 총점은 getTot() 메서드를 통해 가져오며,
        // 3.0으로 나누는 이유는 정수 나눗셈이 아닌 소수점 이하까지 계산하기 위해서입니다.
        double avg = sungJukDTO.getTot() / 3.0;
        sungJukDTO.setAvg(avg);
    }

    @Override
    public void display() {
        // 결과 출력
        System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
        // 추가 설명: 점수 데이터를 보기 쉽게 탭 문자(\t)를 사용하여 표 형식으로 출력합니다.
        System.out.print(sungJukDTO);
        // 추가 설명: SungJukDTO 객체의 toString() 메서드가 호출되며, 성적 데이터를 한 줄로 출력합니다.
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
        // 추가 설명: 사용자로부터 입력받은 이름, 국어, 영어, 수학 점수를 각각의 필드에 저장합니다.
        sungJukDTO.setName(name);
        sungJukDTO.setKor(kor);
        sungJukDTO.setEng(eng);
        sungJukDTO.setMath(math);

        // 총점과 평균 재계산
        // 추가 설명: calcTot() 메서드를 호출하여 총점을 다시 계산하고, calcAvg() 메서드를 호출하여 평균을 다시 계산합니다.
        // 이렇게 함으로써 수정된 데이터를 바탕으로 총점과 평균이 업데이트됩니다.
        calcTot();
        calcAvg();
    }
}
