package member.service;

import java.util.Scanner; // 사용자 입력을 받기 위해 Scanner 클래스를 가져옴
import member.bean.MemberDTO; // 회원 정보를 담기 위해 MemberDTO 클래스를 가져옴
import member.dao.MemberDAO; // 데이터베이스와 상호작용하기 위해 MemberDAO 클래스를 가져옴

public class LoginService implements Member {
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성
        
        // 사용자로부터 아이디와 비밀번호 입력 받기
        System.out.print("아이디 입력: ");
        String id = sc.nextLine(); // 사용자로부터 아이디 입력받기
        
        System.out.print("비밀번호 입력: ");
        String pwd = sc.nextLine(); // 사용자로부터 비밀번호 입력받기
        
        // MemberDAO를 사용하여 데이터베이스에서 사용자 정보 확인
        MemberDAO memberDAO = MemberDAO.getInstance(); // MemberDAO 객체 생성, 싱글톤 인스턴스 가져오기
        MemberDTO memberDTO = memberDAO.selectMember(id, pwd); // 입력 받은 아이디와 비밀번호로 데이터베이스에서 사용자 정보 조회
        
        // 조회된 회원 정보가 있을 경우 로그인 성공, 없을 경우 로그인 실패 메시지 출력
        if (memberDTO != null) {
        	System.out.println();
            // 로그인 성공 시 환영 메시지 출력
            System.out.println("로그인 성공: " + memberDTO.getName() + " 님 로그인 되었습니다.");
        } else {
        	System.out.println();
            // 로그인 실패 시 에러 메시지 출력
            System.out.println("로그인 실패: 아이디 또는 비밀번호가 맞지 않습니다.");
        }
                
    }
}

