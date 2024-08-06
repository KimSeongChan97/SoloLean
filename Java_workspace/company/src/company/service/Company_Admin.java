package company.service;

import java.util.Scanner;

import company.bean.CompanyDTO;
import company.dao.CompanyDAO;

public class Company_Admin implements Company {
	
	Scanner sc = new Scanner(System.in);
	CompanyDAO companyDAO = CompanyDAO.getInstance(); // CompanyDAO의 싱글톤 인스턴스 가져오기
	Company company = null;
	CompanyDTO companyDTO = null;
	
	public Company_Admin(CompanyDTO companyDTO) { // 생성자 추가
        this.companyDTO = companyDTO;
    }
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println("------------------");
			System.out.println("[관리자 페이지]");
			System.out.println("------------------");
			System.out.println("1. 출결체크 및 휴가설정");
			System.out.println("2. 퇴사 사원 목록");
			System.out.println("3. 출퇴근 기록 조회");
			System.out.println("4. 퇴사");
			System.out.println("5. 로그아웃");
			System.out.println("------------------");
			System.out.print("번호 입력 : ");
			int num = sc.nextInt();
			
			if(num == 5) {
				System.out.println("로그아웃 되었습니다");
				return;
			}
			else if(num == 1) {
				company = new CompanyAttendance(companyDTO); //출결체크 및 휴가설정
			}
			else if(num == 2) {
				company = new CompanyLeaveList(); //퇴사 사원 목록
			}
			else if(num == 3) {
				company = new CompanyAttendanceLog(companyDTO); //출퇴근 조회
			}
			else if(num == 4) {
				company = new CompanyLeave(companyDTO);
				company.execute();
				companyDTO = null; //퇴사한 사람의 정보를 null으로 초기화
			}
			//퇴사된 경우
			if(companyDTO == null) {
				return;
			}
			company.execute();
		}
		
	}

}
