package company.service;

import java.util.Scanner;

import company.bean.CompanyDTO;
import company.dao.CompanyDAO;

public class CompanyLeave implements Company{
	CompanyDTO companyDTO = null;
	
	public CompanyLeave(CompanyDTO companyDTO) { // 생성자 추가
        this.companyDTO = companyDTO;
    }
	
    // Company 인터페이스의 execute 메서드를 구현
    @Override
    public void execute() {
        
        CompanyDAO companyDAO = CompanyDAO.getInstance(); // CompanyDAO의 싱글톤 인스턴스 가져오기
        String id = companyDTO.getId();
        String pw = companyDTO.getPw();
        
        String name = companyDAO.delete(id, pw); // 입력받은 아이디와 비밀번호로 퇴사 처리 시도
        System.out.println(name + "님이 퇴사하셨습니다");       
        
    }
}
