package homework;

public class SungJuk {

	public static void main(String[] args) {
		System.out.println(" *** L(name) 성적표 *** ");
		
		String name = "L"; // 이름 설정
		int kor = 85, eng = 90, math = 100; // 과목별 점수
		
		// 총점 계산
		int tot = kor + eng + math;
		
		// 평균 계산
		// 평균을 소수점 셋째자리까지 출력하기 위해 문자열 포맷을 사용하여 계산 결과를 저장
		String avg = String.format("%.3f", (double) tot / 3);
		
		// 결과 출력
		System.out.println("\t *** " + name + " 성적표 ***");
		System.out.println("국어\t영어\t수학\t총점\t평균");
		System.out.println(kor + "\t" + eng + "\t" + math + "\t" + tot + "\t" + avg);
	}
}

/*
[문제] 성적 계산
이름이 L(name)이고 국어점수 85(kor), 영어점수 90(eng), 수학점수 100(math)일때 총점(tot)과 평균(avg)을 구하시오

[조건]
총점 = 국어 + 영어 + 수학
평균 = 총점 / 과목수
평균의 소수이하 3째자리까지 출력

[실행결과]
 *** L 성적표 ***
국어 영어 수학 총점 평균
85 90 100 xxx xx.xxx

*/