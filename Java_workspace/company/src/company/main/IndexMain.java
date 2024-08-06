package company.main;

import java.util.Scanner;

import company.service.Company;
import company.service.CompanyAttendance;
import company.service.CompanyLeave;
import company.service.CompanyLeaveList;
import company.service.CompanyList;
import company.service.CompanyLogin;
import company.service.CompanyRegist;
import company.service.CompanyAttendanceLog;

public class IndexMain {
	
	// 메뉴를 출력하고 사용자 입력을 받아 처리하는 메서드
	public void menu() {
		Scanner sc = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성
		Company company = null; // Company 인터페이스 타입의 객체를 초기화
		
		// 무한 루프를 통해 사용자가 종료를 선택할 때까지 반복
		while(true) {
			// 메뉴 출력
			System.out.println();
			System.out.println("[회사 근태관리 프로그램]");
			System.out.println("---------------------");
			System.out.println("1. 입사");
			System.out.println("2. 로그인");
			System.out.println("3. 사원 목록");
			System.out.println("4. 종료");
			System.out.println("---------------------");
			System.out.print("번호 입력 : ");
			int n = sc.nextInt(); // 사용자가 입력한 번호를 변수 n에 저장
			
			if(n == 4) break; // 사용자가 3을 입력하면 반복문 종료
			if(n == 1) {
				company = new CompanyRegist(); // 1을 입력하면 입사 처리를 위한 객체 생성
			}
			else if(n == 2) {
				company = new CompanyLogin(); // 2를 입력하면 로그인을 위한 객체 생성
			}
			else if(n == 3) {
				company = new CompanyList(); // 3를 입력하면 사원목록을 위한 객체 생성
			}
			else {
				System.out.println("1 ~ 4 중에서 선택하세요"); // 1 ~ 3 이외의 숫자를 입력하면 경고 메시지 출력
				continue; // 반복문 처음으로 돌아가 다시 입력 받음
			}
			company.execute(); // 선택한 번호에 해당하는 작업을 실행
		}
	}
	
	// 프로그램의 시작점
	public static void main(String[] args) {
		IndexMain indexMain = new IndexMain(); // IndexMain 객체 생성
		indexMain.menu(); // menu 메서드 호출하여 프로그램 실행
		
		System.out.println("프로그램이 종료되었습니다."); // 프로그램 종료 메시지 출력
	}
}
