package company.service;

import java.util.Scanner;

import company.bean.CompanyDTO;
import company.dao.CompanyDAO;

public class CompanyLogin implements Company{

	Scanner sc = new Scanner(System.in);
	Company company = null;
	CompanyDTO companyDTO = new CompanyDTO();// 정보가 담긴 companyDTO 객체생성
	CompanyDAO companyDAO = CompanyDAO.getInstance(); // CompanyDAO의 싱글톤 인스턴스 가져오기
	
	@Override
	public void execute() {
		System.out.println("[로그인]");
		System.out.println("---------------------");
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		System.out.println("---------------------");
		
		companyDTO = companyDAO.login(id, pw);
		
		
		if(companyDTO.getId() == null || companyDTO.getPw() == null) {
			System.out.println("아이디 또는 비밀번호가 맞지 않습니다.");
		}else {
			String name = companyDTO.getName();
			String rank = companyDTO.getRank();
			
			System.out.println(name + "님이 로그인 하였습니다.");
			
			if(rank.equals("0")) {
				company = new Company_Admin(companyDTO);
			}
			else if(rank.equals("1")) {
				company = new Company_Emp(companyDTO);
			}
			company.execute();
		}
		
	}

}
