package sungJukSolo;

/**
 * SungJukDTO 클래스는 학생의 성적 데이터를 저장하고 처리하는 역할을 합니다.
 * 학생 번호, 이름, 국어, 영어, 수학 점수와 함께 총점과 평균을 계산합니다.
 */
public class SungJukDTO {
    // 학생의 고유 번호를 저장합니다.
    private int no;     

    // 학생의 이름을 저장합니다.
    private String name; 

    // 학생의 국어 점수를 저장합니다.
    private int kor;    

    // 학생의 영어 점수를 저장합니다.
    private int eng;    

    // 학생의 수학 점수를 저장합니다.
    private int math;   

    // 학생의 총점을 저장합니다.
    private int tot;    

    // 학생의 평균 점수를 저장합니다.
    private double avg; 

    /**
     * 생성자 메서드는 객체가 생성될 때 호출되며, 학생 번호, 이름, 국어, 영어, 수학 점수를 초기화합니다.
     * 총점과 평균은 calc() 메서드를 호출하여 자동으로 계산됩니다.
     * @param no 학생 번호
     * @param name 학생 이름
     * @param kor 국어 점수
     * @param eng 영어 점수
     * @param math 수학 점수
     */
    public SungJukDTO(int no, String name, int kor, int eng, int math) {
        this.no = no;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.calc();  // 총점과 평균을 계산하는 메서드 호출
    }

    // Getter와 Setter 메서드들은 객체의 속성을 읽고 쓸 수 있도록 합니다.
    
    // 학생 번호를 반환합니다.
    public int getNo() {
        return no;
    }

    // 학생 번호를 설정합니다.
    public void setNo(int no) {
        this.no = no;
    }

    // 학생 이름을 반환합니다.
    public String getName() {
        return name;
    }

    // 학생 이름을 설정합니다.
    public void setName(String name) {
        this.name = name;
    }

    // 국어 점수를 반환합니다.
    public int getKor() {
        return kor;
    }

    // 국어 점수를 설정합니다.
    public void setKor(int kor) {
        this.kor = kor;
    }

    // 영어 점수를 반환합니다.
    public int getEng() {
        return eng;
    }

    // 영어 점수를 설정합니다.
    public void setEng(int eng) {
        this.eng = eng;
    }

    // 수학 점수를 반환합니다.
    public int getMath() {
        return math;
    }

    // 수학 점수를 설정합니다.
    public void setMath(int math) {
        this.math = math;
    }

    // 총점을 반환합니다. 총점은 직접 설정하지 않습니다.
    public int getTot() {
        return tot;
    }

    // 평균 점수를 반환합니다. 평균 점수는 직접 설정하지 않습니다.
    public double getAvg() {
        return avg;
    }

    /**
     * calc() 메서드는 국어, 영어, 수학 점수를 합산하여 총점을 계산하고,
     * 총점을 이용하여 평균 점수를 계산합니다.
     */
    public void calc() {
        this.tot = this.kor + this.eng + this.math;  // 총점을 계산하여 tot에 저장합니다.
        this.avg = this.tot / 3.0;  // 평균을 계산하여 avg에 저장합니다.
    }

    /**
     * 객체의 현재 상태를 문자열로 반환합니다.
     * @return 학생 정보와 성적을 포함한 문자열
     */
    @Override
    public String toString() {
        return String.format("번호: %d\t이름: %s\t국어: %d\t영어: %d\t수학: %d\t총점: %d\t평균: %.2f", 
                              no, name, kor, eng, math, tot, avg);
    }
}
