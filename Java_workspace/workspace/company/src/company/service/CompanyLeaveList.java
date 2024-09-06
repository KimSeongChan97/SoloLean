package company.service;

import company.bean.CompanyDTO;
import company.dao.CompanyDAO;

public class CompanyLeaveList implements Company {

    // Company 인터페이스의 execute 메서드를 구현
    @Override
    public void execute() {
        // 퇴사 사원 목록을 출력하는 코드
        System.out.println("[퇴사 사원 목록]");
        System.out.println("이름\t아이디\t입사일\t\t퇴사일");
        
        CompanyDAO companyDAO = CompanyDAO.getInstance(); // CompanyDAO의 싱글톤 인스턴스 가져오기
        CompanyDTO companyDTO = new CompanyDTO(); // 퇴사 사원 목록을 담기 위한 CompanyDTO 객체 생성
        
        companyDAO.leavelist(companyDTO); // 퇴사 사원 목록을 가져와 출력
    }
}
