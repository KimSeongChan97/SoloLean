package sample04;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SungJukOutput implements SungJuk {
	
	// @Setter: Lombok 라이브러리에서 제공하는 어노테이션으로, 이 필드에 대해 setter 메서드를 자동으로 생성해 줍니다.
	// 즉, 외부에서 이 클래스에 List<SungJukDTO2> 객체를 주입할 수 있는 setter 메서드가 자동으로 만들어집니다.
	// 이 리스트는 여러 학생의 성적 데이터를 담고 있으며, Spring의 의존성 주입을 통해 주입될 수 있습니다.
	// Spring은 이 리스트에 성적 데이터를 주입합니다. 이를 통해 성적 데이터를 출력할 수 있습니다.
	@Autowired
	@Qualifier("arrayList")
	private List<SungJukDTO2> list;
	// 학생들의 성적 데이터를 담고 있는 리스트입니다. Spring이 관리하는 이 리스트는
	// 다른 클래스에서 성적 데이터를 입력하거나 수정한 후에 여기에 저장된 데이터를 이용해 출력할 수 있습니다.
	
//	public void setList(List<SungJukDTO2> list) {
//	this.list = list;
//}	
	// 위 코드는 수동으로 setter 메서드를 작성한 것입니다.
	// 그러나 Lombok의 @Setter 어노테이션을 사용하고 있으므로, 이 부분은 주석 처리되어 있습니다.
	// Lombok이 setter를 자동으로 생성해주기 때문에 직접 작성할 필요가 없습니다.
	// 수동으로 작성된 setter 메서드 대신 Lombok이 제공하는 @Setter 어노테이션을 사용하면
	// 코드가 더 간결해지고 유지보수가 쉬워집니다.

    @Override
    public void execute() {
        System.out.println(); // 공백 줄 출력
        // 성적 데이터를 출력하기 전 보기 좋게 하기 위해 공백을 추가합니다.
    	System.out.println("이름\t국어\t영어\t수학\t총점\t평균"); 
    	// 탭(\t)을 사용하여 성적 데이터를 출력할 때 각 열이 일정한 간격을 유지하도록 함.
    	// 성적 데이터는 "이름", "국어", "영어", "수학", "총점", "평균" 순으로 출력됩니다.
    	// 출력되는 포맷이 일관되도록 탭(\t)을 사용하여 각 항목 간의 간격을 맞춥니다.

        for (SungJukDTO2 sungJukDTO2 : list) {
            // 리스트에 있는 각 SungJukDTO2 객체의 데이터를 출력합니다.
            // list는 여러 학생들의 성적 데이터를 담고 있는 리스트입니다. 
            // for-each 루프를 사용하여 이 리스트의 각 SungJukDTO2 객체를 하나씩 가져와 출력합니다.
        	
            System.out.println(sungJukDTO2); 
            // sungJukDTO2 객체의 toString() 메서드가 호출되어 객체 정보를 출력합니다.
            // toString() 메서드는 SungJukDTO2 클래스에서 오버라이드되어 있으며, 학생의 이름, 국어, 영어, 수학, 총점, 평균이 출력됩니다.
            // 이 메서드는 각 학생의 성적 정보를 보기 좋게 한 줄로 출력해 줍니다. 
            // 출력되는 순서는 이름, 국어, 영어, 수학, 총점, 평균이 되며, 평균은 소수점 두 자리까지 표시됩니다.
        }
        // 리스트에 저장된 모든 성적 데이터를 출력한 후, 반복문이 종료됩니다.
    }
}
