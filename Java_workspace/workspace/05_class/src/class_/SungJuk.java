package class_;

public class SungJuk {
    // 학생의 성적 정보를 저장할 필드 변수들
    private String name; // 이름
    private int kor, eng, math, tot; // 국어, 영어, 수학 점수와 총점
    private double avg; // 평균 점수
    private char grade; // 학점
    
    // 학생의 정보를 설정하는 메서드
    public void setData(String n, int k, int e, int m) {
        name = n; // 이름 설정
        kor = k; // 국어 점수 설정
        eng = e; // 영어 점수 설정
        math = m; // 수학 점수 설정
    }
    
    // 총점, 평균, 학점을 계산하는 메서드
    public void calc() {
        tot = kor + eng + math; // 총점 계산
        avg = tot / 3.0; // 평균 계산
        // 평균 점수에 따라 학점을 설정
        if (avg >= 90) grade = 'A';
        else if (avg >= 80) grade = 'B';
        else if (avg >= 70) grade = 'C';
        else if (avg >= 60) grade = 'D';
        else grade = 'F';
    }
    
    // 각 필드의 값을 반환하는 getter 메서드들
    public String getName() { return name; }
    public int getKor() { return kor; }
    public int getEng() { return eng; }
    public int getMath() { return math; }
    public int getTot() { return tot; }
    public double getAvg() { return avg; }
    public char getGrade() { return grade; }
}
