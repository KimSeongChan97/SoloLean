package class_;

public class SungJukMain2 {

	public static void main(String[] args) {
		// SungJuk 클래스의 객체 bb를 생성
        SungJuk bb = new SungJuk();
        
        // aa 객체의 데이터를 설정 (이름, 국어, 영어, 수학 점수)
        bb.setData("홍길동", 90, 96, 100);
        
        // 총점, 평균, 학점을 계산
        bb.calc();
        
        // aa 객체의 정보를 출력
        System.out.println(bb.getName() + "\t" // 이름 출력
                           + bb.getKor() + "\t" // 국어 점수 출력
                           + bb.getEng() + "\t" // 영어 점수 출력
                           + bb.getMath() + "\t" // 수학 점수 출력
                           + bb.getTot() + "\t" // 총점 출력
                           + String.format("%.2f", bb.getAvg()) + "\t" // 평균 출력 (소수점 둘째 자리까지)
                           + bb.getGrade()); // 학점 출력
        
     // SungJuk 클래스의 객체 cc를 생성
        SungJuk cc = new SungJuk();
        
        // aa 객체의 데이터를 설정 (이름, 국어, 영어, 수학 점수)
        cc.setData("프로도", 100, 80, 90);
        
        // 총점, 평균, 학점을 계산
        cc.calc();
        
        // aa 객체의 정보를 출력
        System.out.println(cc.getName() + "\t" // 이름 출력
                           + cc.getKor() + "\t" // 국어 점수 출력
                           + cc.getEng() + "\t" // 영어 점수 출력
                           + cc.getMath() + "\t" // 수학 점수 출력
                           + cc.getTot() + "\t" // 총점 출력
                           + String.format("%.2f", cc.getAvg()) + "\t" // 평균 출력 (소수점 둘째 자리까지)
                           + cc.getGrade()); // 학점 출력
        
     // SungJuk 클래스의 객체 dd를 생성
        SungJuk dd = new SungJuk();
        
        // aa 객체의 데이터를 설정 (이름, 국어, 영어, 수학 점수)
        dd.setData("라이언", 95, 86, 100);
        
        // 총점, 평균, 학점을 계산
        dd.calc();
        
        // aa 객체의 정보를 출력
        System.out.println(dd.getName() + "\t" // 이름 출력
                           + dd.getKor() + "\t" // 국어 점수 출력
                           + dd.getEng() + "\t" // 영어 점수 출력
                           + dd.getMath() + "\t" // 수학 점수 출력
                           + dd.getTot() + "\t" // 총점 출력
                           + String.format("%.2f", dd.getAvg()) + "\t" // 평균 출력 (소수점 둘째 자리까지)
                           + dd.getGrade()); // 학점 출력
    }
}


/*
----------------------------------------------------
이름      국어      영어      수학      총점      평균      학점
----------------------------------------------------
홍길동      90      95      100
프로도      100      89      76
라이언      75      80      48
----------------------------------------------------
*/
