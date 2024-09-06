package company.service;

import java.util.Scanner;

import company.bean.CompanyDTO;
import company.dao.CompanyDAO;

public class CompanyAttendanceLog implements Company {
	CompanyDTO companyDTO = null;
	
	public CompanyAttendanceLog(CompanyDTO companyDTO) {
		 this.companyDTO = companyDTO;
	}
    
    // Company 인터페이스의 execute 메서드를 구현
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성
        CompanyDAO companyDAO = CompanyDAO.getInstance(); // CompanyDAO의 싱글톤 인스턴스 가져오기
        
        String id = companyDTO.getId();
        // 출퇴근 기록 조회
        companyDAO.getAttendanceLogs(id);
    }
}
