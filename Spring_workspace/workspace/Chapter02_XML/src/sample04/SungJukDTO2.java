package sample04;

import lombok.Getter;
import lombok.Setter;

// @Getter와 @Setter는 Lombok 라이브러리에서 제공하는 어노테이션으로, 
// 클래스 내의 필드에 대해 자동으로 getter와 setter 메서드를 생성해 줍니다.
// 이 어노테이션을 사용함으로써, 우리는 매번 getter와 setter 메서드를 수동으로 작성할 필요가 없습니다.
// 예를 들어, name 필드의 경우 'getName()'과 'setName(String name)' 메서드가 자동으로 생성됩니다.
@Getter
@Setter
public class SungJukDTO2 {
    // 학생의 이름을 저장하는 필드입니다.
    private String name;

    // 국어 점수를 저장하는 필드입니다.
    private int kor;

    // 영어 점수를 저장하는 필드입니다.
    private int eng;

    // 수학 점수를 저장하는 필드입니다.
    private int math;

    // 총점 필드로, 국어, 영어, 수학 점수의 합을 저장하는 변수입니다.
    // 계산된 값이 저장될 수 있으며, setter를 통해 외부에서 값을 설정할 수도 있습니다.
    private int tot;

    // 평균 필드로, 국어, 영어, 수학 점수의 평균을 저장합니다.
    // 평균은 소수점을 포함한 값이므로 double 타입으로 선언되었습니다.
    private double avg;
    
    // Object 클래스의 toString() 메서드를 오버라이딩합니다.
    // toString() 메서드는 객체를 문자열로 표현할 때 호출되는 메서드입니다.
    // 여기서는 SungJukDTO2 객체의 각 필드를 탭(\t)으로 구분하여 문자열로 반환합니다.
    @Override
    public String toString() {
    	// name: 학생의 이름을 나타냅니다.
    	// kor: 국어 점수를 나타냅니다.
    	// eng: 영어 점수를 나타냅니다.
    	// math: 수학 점수를 나타냅니다.
    	// tot: 총점, 국어, 영어, 수학 점수의 합계를 나타냅니다.
    	// avg: 평균 점수를 나타냅니다. String.format("%.2f", avg)를 사용하여 평균을 소수점 둘째 자리까지 포맷팅합니다.
    	return name + "\t" 
    		  + kor + "\t" 
    		  + eng + "\t" 
    		  + math + "\t" 
    		  + tot + "\t" 
    		  + String.format("%.2f", avg); // 평균은 소수점 둘째 자리까지만 출력됩니다.
    }
    
}
