package sample04;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// @Getter와 @Setter는 Lombok 라이브러리에서 제공하는 어노테이션으로, 
// 클래스 내의 필드에 대해 자동으로 getter와 setter 메서드를 생성해 줍니다.
// 이 어노테이션을 사용함으로써, 우리는 매번 getter와 setter 메서드를 수동으로 작성할 필요가 없습니다.
// 예를 들어, name 필드의 경우 'getName()'과 'setName(String name)' 메서드가 자동으로 생성됩니다.
// Lombok을 사용하면 코드가 간결해지고 유지보수가 쉬워집니다. 
// 하지만, 현재 코드에서는 Lombok을 사용하지 않고, 수동으로 getter와 setter 메서드를 작성하고 있습니다.
// Lombok을 사용하는 경우에도 동일한 로직이 적용될 것입니다.

//prototype 스코프는 요청할 때마다 새로운 인스턴스를 생성하는 스코프입니다.
//즉, 클라이언트가 매번 요청할 때마다 새로운 객체가 생성되며, 스프링 컨테이너는 해당 객체의 상태를 더 이상 관리하지 않습니다.
//이 스코프는 빈을 여러 번 사용할 필요가 있거나, 각 요청마다 상태가 달라져야 하는 경우에 유용


@Component // Spring에서 관리되는 Bean으로 등록됩니다. 이를 통해 Spring이 이 객체를 생성하고 필요할 때 주입할 수 있습니다.
@Scope("prototype") // Spring Framework에서 빈(Bean)의 스코프를 정의할 때 사용(스프링 빈의 라이프사이클을 제어하는 데 사용)
public class SungJukDTO2 {
    // 학생의 이름을 저장하는 필드입니다.
    // name은 학생의 이름을 나타내는 문자열 필드입니다. 이름은 각 학생을 구별하는 주요 정보입니다.
    private String name;

    // 국어 점수를 저장하는 필드입니다.
    // kor은 학생이 국어 과목에서 받은 점수를 나타냅니다. 
    // 국어, 영어, 수학 점수는 모두 성적을 계산하는 데 사용됩니다.
    private int kor;

    // 영어 점수를 저장하는 필드입니다.
    // eng는 학생이 영어 과목에서 받은 점수를 나타냅니다.
    private int eng;

    // 수학 점수를 저장하는 필드입니다.
    // math는 학생이 수학 과목에서 받은 점수를 나타냅니다.
    private int math;

    // 총점 필드로, 국어, 영어, 수학 점수의 합을 저장하는 변수입니다.
    // tot는 세 과목의 점수를 합산한 총점을 저장하는 변수입니다.
    // 총점은 입력된 각 과목 점수를 바탕으로 계산되며, 수동으로 설정할 수도 있습니다.
    private int tot;

    // 평균 필드로, 국어, 영어, 수학 점수의 평균을 저장합니다.
    // 평균은 소수점을 포함한 값이므로 double 타입으로 선언되었습니다.
    // avg는 총점을 과목 수(3)로 나누어 계산된 평균 점수를 저장합니다.
    // 평균은 성적의 전반적인 상태를 나타내는 중요한 지표입니다.
    private double avg;
    
    // Object 클래스의 toString() 메서드를 오버라이딩합니다.
    // toString() 메서드는 객체를 문자열로 표현할 때 호출되는 메서드입니다.
    // 여기서는 SungJukDTO2 객체의 각 필드를 탭(\t)으로 구분하여 문자열로 반환합니다.
    // 객체의 정보를 보기 좋게 출력할 수 있도록 커스터마이즈한 메서드입니다.
    @Override
    public String toString() {
    	// name: 학생의 이름을 나타냅니다.
    	// kor: 국어 점수를 나타냅니다.
    	// eng: 영어 점수를 나타냅니다.
    	// math: 수학 점수를 나타냅니다.
    	// tot: 총점, 국어, 영어, 수학 점수의 합계를 나타냅니다.
    	// avg: 평균 점수를 나타냅니다. String.format("%.2f", avg)를 사용하여 평균을 소수점 둘째 자리까지 포맷팅합니다.
        // toString 메서드는 객체의 값을 출력할 때 자동으로 호출되며, 학생의 성적 데이터를 형식에 맞춰 출력하는 데 사용됩니다.
        // String.format을 사용하여 평균을 소수점 두 자리까지만 표시하여 성적 정보를 더 명확하게 보여줍니다.
    	return name + "\t" 
    		  + kor + "\t" 
    		  + eng + "\t" 
    		  + math + "\t" 
    		  + tot + "\t" 
    		  + String.format("%.2f", avg); // 평균은 소수점 둘째 자리까지만 출력됩니다.
    }

    // Setter 메서드들은 각각의 필드에 값을 설정하는 데 사용됩니다.
    // 이 메서드들은 외부에서 해당 필드에 접근하지 않고도 값을 변경할 수 있게 해줍니다.
	public void setName(String name) {
		this.name = name; // name 필드에 사용자가 전달한 이름 값을 설정합니다.
	}

	public void setKor(int kor) {
		this.kor = kor; // kor 필드에 국어 점수를 설정합니다.
	}

	public void setEng(int eng) {
		this.eng = eng; // eng 필드에 영어 점수를 설정합니다.
	}

	public void setMath(int math) {
		this.math = math; // math 필드에 수학 점수를 설정합니다.
	}

	public void setTot(int tot) {
		this.tot = tot; // tot 필드에 총점을 설정합니다.
		// 일반적으로 tot는 국어, 영어, 수학 점수의 합으로 계산되지만, 필요한 경우 외부에서 수동으로 설정할 수도 있습니다.
	}

	public void setAvg(double avg) {
		this.avg = avg; // avg 필드에 평균을 설정합니다.
		// 평균 역시 국어, 영어, 수학 점수를 바탕으로 계산되며, 수동으로 설정될 수 있습니다.
	}

    // Getter 메서드들은 각각의 필드 값을 외부에서 가져올 수 있게 해줍니다.
    // 이 메서드들을 통해 해당 필드의 값을 읽어올 수 있습니다.
	public String getName() {
		return name; // name 필드의 값을 반환합니다.
	}

	public int getKor() {
		return kor; // kor 필드의 값을 반환합니다.
	}

	public int getEng() {
		return eng; // eng 필드의 값을 반환합니다.
	}

	public int getMath() {
		return math; // math 필드의 값을 반환합니다.
	}

	public int getTot() {
		return tot; // tot 필드의 값을 반환합니다.
	}

	public double getAvg() {
		return avg; // avg 필드의 값을 반환합니다.
	}
    
}
