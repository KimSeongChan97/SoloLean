package sample03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// @Component("sungJukDTO")
// @Component 어노테이션은 이 클래스가 Spring 컨테이너에서 관리되는 Bean이라는 것을 나타냅니다.
// 추가 설명: 이 클래스는 Spring의 Bean으로 등록되어 Spring이 자동으로 관리합니다. 
// 애플리케이션 내에서 다른 클래스가 이 Bean을 의존성 주입받아 사용할 수 있습니다.
public class SungJukDTO {
     private String name; // 학생의 이름
     private int kor; // 국어 점수
     private int eng; // 영어 점수
     private int math; // 수학 점수
     private int tot; // 총점
     private double avg; // 평균
     
     @Override
     public String toString() {
         // 성적 정보를 출력하는 메서드로, 이름, 국어, 영어, 수학 점수와 총점, 평균을 문자열로 반환합니다.
    	 return name + "\t"
    			+ kor + "\t"
    			+ eng + "\t"
    			+ math + "\t"
    			+ tot + "\t"
    			+ String.format("%2f", avg); // 평균을 소수점 두 자리까지 포맷하여 출력
     };
     
    // Setter 메서드에 @Value 어노테이션을 사용하여 값을 주입
    // 추가 설명: @Value 어노테이션을 사용하면 기본값을 설정할 수 있습니다.
    // 이 값들은 Spring이 객체를 생성할 때 주입됩니다.
     
    @Autowired 
	public void setName(@Value("홍길동") String name) {
		this.name = name;
		// 추가 설명: 기본적으로 "홍길동"이라는 이름이 주입됩니다.
		// 만약 외부에서 다른 값을 주입하지 않는다면, 기본값으로 홍길동이 사용됩니다.
	}
    @Autowired 
	public void setKor(@Value("97") int kor) {
		this.kor = kor;
		// 추가 설명: 국어 점수의 기본값은 97로 설정됩니다.
	}
    @Autowired 
	public void setEng(@Value("100") int eng) {
		this.eng = eng;
		// 추가 설명: 영어 점수의 기본값은 100으로 설정됩니다.
	}
    @Autowired 
	public void setMath(@Value("95") int math) {
		this.math = math;
		// 추가 설명: 수학 점수의 기본값은 95로 설정됩니다.
	}
	public void setTot(int tot) {
		this.tot = tot;
		// 추가 설명: 총점은 setTot() 메서드를 통해 설정됩니다. 기본적으로는 계산을 통해 설정됩니다.
	}
	public void setAvg(double avg) {
		this.avg = avg;
		// 추가 설명: 평균 값은 setAvg() 메서드를 통해 설정되며, 일반적으로 총점을 바탕으로 계산됩니다.
	}
	
	// Getter 메서드
	// 추가 설명: Getter 메서드는 각 필드의 값을 읽기 위해 사용됩니다. 외부 클래스에서 SungJukDTO 객체의 데이터를 가져올 때 사용됩니다.

	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}
	public int getTot() {
		return tot;
	}
	public double getAvg() {
		return avg;
	}
}
