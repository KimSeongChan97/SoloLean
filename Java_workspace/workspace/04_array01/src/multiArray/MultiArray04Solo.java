package multiArray;

public class MultiArray04Solo {

    public static void main(String[] args) {
    	// 배열 생성
        String[] name = {"홍길동", "프로도", "라이언"}; // 이름 배열
        int[][] jumsu = {{90, 95, 100}, {100, 89, 76}, {75, 80, 48}}; // 점수 배열 
        int[] total = new int[name.length]; // 총점 배열
        double[] avg = new double[name.length]; // 평균 배열
        char[] grade = new char[name.length]; // 학점 배열

        // 총점, 평균, 학점 계산
	        for (int i = 0; i < name.length; i++) {
	            for (int j = 0; j < jumsu[i].length; j++) {
	                total[i] += jumsu[i][j]; // 총점 계산
	            }
	            
		            // 평균 계산
		            avg[i] = (double) total[i] / jumsu[i].length;
            
			            // 학점 부여
			            if (avg[i] >= 90) {
			                grade[i] = 'A';
			            } else if (avg[i] >= 80) {
			                grade[i] = 'B';
			            } else if (avg[i] >= 70) {
			                grade[i] = 'C';
			            } else if (avg[i] >= 60) {
			                grade[i] = 'D';
			            } else {
			                grade[i] = 'F';
			            }
			        }

        // 출력
	        System.out.println(" ------------------------------------------ ");
	        System.out.println(" 이름      국어   영어   수학   총점   평균   학점  ");
	        System.out.println(" ------------------------------------------ ");
	        	for(int i=0; i<name.length; i++) {
	        		System.out.printf("%-6s", name[i]); //이름 출력
	        		for(int j=0; j<jumsu[i].length; j++) {
	        			System.out.printf("%5d", jumsu[i][j]); //과목점수
	        		}
	        		System.out.printf("%7d", total[i]);
	        		System.out.printf("%8.2f", avg[i]);
	        		System.out.printf("%3c\n", grade[i]);
	        		
	        	}
	        System.out.println(" ------------------------------------------ ");

    }
}

/*
 
[문제] 성적 계산

1. 공식
총점 = 국어 + 영어 + 수학
평균 = 총점 / 과목수
학점은 평균이 90이상이면 A
          80이상이면 B
          70이상이면 C
          60이상이면 D
그 외는 F

2. 평균은 소수이하 2째자리까지 출력        

[실행결과]          
----------------------------------------------------
이름      국어      영어      수학      총점      평균      학점
----------------------------------------------------
홍길동      90      95      100
프로도      100      89      76
라이언      75      80      48
----------------------------------------------------

*/