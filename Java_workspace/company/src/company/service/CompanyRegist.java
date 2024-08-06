package company.service;

import java.util.Scanner;

import company.dao.CompanyDAO;

public class CompanyRegist implements Company {
    private String id = ""; // 클래스 멤버 변수로 아이디를 선언

    // Company 인터페이스의 execute 메서드를 구현
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성
        CompanyDAO companyDAO = CompanyDAO.getInstance(); // CompanyDAO의 싱글톤 인스턴스 가져오기
        
        // 사용자로부터 이름 입력 받기
        System.out.print("이름 : ");
        String name = sc.next();
        
        // 사용자로부터 유효한 아이디를 입력 받을 때까지 반복
        while(true) {
            System.out.println();
            System.out.print("아이디 입력 : ");
            id = sc.next();
            
            boolean exist = companyDAO.isExistId(id); // 입력받은 아이디가 이미 존재하는지 확인
            if(exist) {
                System.out.println("이미 사용중인 아이디입니다."); // 아이디가 이미 존재할 경우 메시지 출력
            } else {
                System.out.println("사용가능한 아이디입니다."); // 아이디가 사용 가능할 경우 메시지 출력
                break; // 반복문 탈출
            }
        }
        
        // 사용자로부터 비밀번호와 전화번호 입력 받기
        System.out.print("비밀번호 : ");
        String pw = sc.next();
        System.out.print("전화번호(010-0000-0000) : ");
        String phone = sc.next();
        System.out.print("관리자 = 0 | 사원 = 1 : ");
        String rank = sc.next();
        
        // 입력받은 정보로 새로운 직원 등록
        companyDAO.regist(name, id, pw, phone, rank);
        
        // 직원 등록 완료 메시지 출력
        System.out.println(name + "님이 입사하셨습니다.");
    }
}
