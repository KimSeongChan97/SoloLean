package switch_;

import java.util.Scanner;

public class Switch01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("월 입력 : ");
		int month = scanner.nextInt(); // 입력받은 월을 정수형 변수 month 에 저장
		int days = 0; // 해당 월의 일수를 저장할 변수 days 를 초기화
		
		/* if(month == 1 ) days = 31;
		 else if(month == 2) days = 28;
		 else if(month == 3) days = 31;
		 else if(month == 4) days = 30;
		 else if(month == 5) days = 31;
		 else if(month == 6) days = 30;
		 else if(month == 7) days = 31;
		 else if(month == 8) days = 31;
		 else if(month == 9) days = 30;
		 else if(month == 10) days = 31;
		 else if(month == 11) days = 30;
		 else if(month == 12) days = 31;
		 else days = 31; // 입력이 잘못되었을 경우 기본값을 31로 설정
		 */ // if 문
		
		switch(month) {
		case 1 :
		case 3 :
		case 5 :
		case 7 :
		case 8 :
		case 10 :
		case 12 : days=31; break;
		case 2 :  days=28; break;
		case 4 :
		case 6 :
		case 9 :
		case 11 : days=30; break;
		} // switch 문
			
		 System.out.println(month + "월은 " + days + "일 입니다.");
		
	}

}
