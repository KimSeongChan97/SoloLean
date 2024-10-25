package company.service;

import java.util.Scanner;

import company.bean.CompanyDTO;
import company.dao.CompanyDAO;

public class Company_Emp implements Company{
	Scanner sc = new Scanner(System.in);
	CompanyDAO companyDAO = CompanyDAO.getInstance(); // CompanyDAO의 싱글톤 인스턴스 가져오기
	Company company = null;
	CompanyDTO companyDTO = null;
	
	
	public Company_Emp(CompanyDTO companyDTO) {
		this.companyDTO = companyDTO;
	}
	
	
	@Override
	public void execute() {
		while(true) {
			System.out.println("------------------");
			System.out.println("[사원 페이지]");
			System.out.println("------------------");
			System.out.println("1. 출결체크 및 휴가설정");
			System.out.println("2. 출퇴근 기록 조회");
			System.out.println("3. 퇴사");
			System.out.println("4. 로그아웃");
			System.out.println("------------------");
			System.out.print("번호 입력 : ");
			int num = sc.nextInt();
			
			if(num == 4) {
				System.out.println("로그아웃 되었습니다");
				return;
			}
			else if(num == 1) {
				company = new CompanyAttendance(companyDTO);
			}
			else if(num == 2) {
				company = new CompanyAttendanceLog(companyDTO);
			}else if(num == 3) {
				company = new CompanyLeave(companyDTO);
				company.execute();
				companyDTO = null; //퇴사한 사람의 정보를 null값으로 초기화
			}
			
			//퇴사된 경우
			if(companyDTO == null) {
				return;
			}
			company.execute();
			
		}
		
	}

}
