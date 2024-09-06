package class_;

public class SungJukMain3 {

	public static void main(String[] args) {
		/*
		SungJuk aa = new SungJuk();
		SungJuk bb = new SungJuk();
		SungJuk cc = new SungJuk(); // SungJuk class 객체 를 표시
		*/
		SungJuk[] ar = new SungJuk[3]; // 객체배열 생성
		ar[0] = new SungJuk(); // 배열에 속하는 class 의 객체를 넣음
		ar[1] = new SungJuk();
		ar[2] = new SungJuk(); // 진짜 객체를 생성
		
		// 각 객체에 데이터 설정 및 계산
        ar[0].setData("프로도", 100, 80, 90); // 첫 번째 객체의 데이터 설정
        ar[1].setData("라이언", 95, 85, 70); // 두 번째 객체의 데이터 설정
        ar[2].setData("무지", 70, 75, 60); // 세 번째 객체의 데이터 설정
		
        System.out.println("\t" + "----------------------" + "\t");
     // 각 객체의 calc 메서드 호출하여 총점, 평균, 학점 계산
        for(int i = 0; i < ar.length; i++) {
            ar[i].calc(); // 각 객체의 총점, 평균, 학점 계산
            // 각 객체의 정보 출력
            
			System.out.println(ar[i].getName() + "\t" // 이름 출력
                    + ar[i].getKor() + "\t" // 국어 점수 출력
                    + ar[i].getEng() + "\t" // 영어 점수 출력
                    + ar[i].getMath() + "\t" // 수학 점수 출력
                    + ar[i].getTot() + "\t" // 총점 출력
                    + String.format("%.2f", ar[i].getAvg()) + "\t" // 평균 출력 (소수점 둘째 자리까지)
                    + ar[i].getGrade()); // 학점 출력
			System.out.println("\t" + "----------------------" + "\t");
		}

	}

}
