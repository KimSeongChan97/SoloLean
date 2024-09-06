package sungJuk; // 패키지 선언

// SungJukDTO 클래스 선언 - 성적 정보를 저장하는 역할
public class SungJukDTO implements Comparable<SungJukDTO> {
    // 정보 저장을 위한 필드 선언
    private int no; // 학생 번호
    private String name; // 학생 이름
    private int kor; // 국어 점수
    private int eng; // 영어 점수
    private int math; // 수학 점수
    private int tot; // 총점
    private double avg; // 평균

    // 기본 생성자
    public SungJukDTO() {}

    // 매개변수가 있는 생성자 - 성적 정보를 초기화하고 총점과 평균을 계산
    public SungJukDTO(int no, String name, int kor, int eng, int math) {
        this.no = no;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.calc(); // 총점과 평균을 계산하여 초기화
    }

    // Setter 메서드 - 각 필드의 값을 설정
    public void setNo(int no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public void setTot(int tot) {
        this.tot = tot;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    // Getter 메서드 - 각 필드의 값을 반환
    public int getNo() {
        return no;
    }

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

    // 총점과 평균을 계산하는 메서드
    public void calc() {
        this.tot = this.kor + this.eng + this.math; // 총점을 계산
        this.avg = this.tot / 3.0; // 평균을 계산 (3.0으로 나누어 실수로 계산)
    }
   
    // Comparable 인터페이스의 compareTo 메서드를 구현
    @Override
    public int compareTo(SungJukDTO o) {
        // 기본 비교 기준을 총점 기준으로 설정 (총점 내림차순)
        return o.getTot() - this.getTot();
    }
 
    // 객체의 정보를 문자열로 반환하는 메서드 (toString 메서드 오버라이드)
    @Override
    public String toString() {
        return no + "\t"
               + name + "\t"
               + kor + "\t"
               + eng + "\t"
               + math + "\t"
               + tot + "\t"
               + String.format("%.2f", avg); // 평균을 소수점 둘째 자리까지 포맷팅하여 반환
    }
}

