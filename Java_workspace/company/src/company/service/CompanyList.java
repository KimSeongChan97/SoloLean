package company.service;

import company.bean.CompanyDTO;
import company.dao.CompanyDAO;

public class CompanyList implements Company {

    // Company 인터페이스의 execute 메서드를 구현
    @Override
    public void execute() {
        // 사원 목록을 출력하는 코드
        System.out.println("이름\t아이디\t입사일\t\t전화번호\t\t출결현황\t지각횟수\t조퇴횟수");
        System.out.println("---------------------------------------------------------------------");
        
        CompanyDAO companyDAO = CompanyDAO.getInstance(); // CompanyDAO의 싱글톤 인스턴스 가져오기
        CompanyDTO companyDTO = new CompanyDTO(); // 사원 목록을 담기 위한 CompanyDTO 객체 생성
        
        companyDAO.list(companyDTO); // 사원 목록을 가져와 출력
    }
}
