package member.service;

import java.util.Scanner; // 사용자 입력을 받기 위해 Scanner 클래스를 가져옴
import member.dao.MemberDAO; // MemberDAO 클래스 사용을 위해 import

public class DeleteService implements Member {

    // Member 인터페이스의 execute 메서드를 오버라이드합니다.
    @Override
    public void execute() {
        // 사용자로부터 입력을 받기 위해 Scanner 객체를 생성합니다.
        Scanner sc = new Scanner(System.in);
        System.out.print("아이디 입력 : ");
        String id = sc.nextLine(); 
        System.out.print("비밀번호 입력 : ");
        String pwd = sc.nextLine(); // 입력받은 비밀번호를 변수 pwd에 저장
        // MemberDAO 인스턴스를 가져옵니다.
        MemberDAO memberDAO = MemberDAO.getInstance();
        // 아이디와 비밀번호가 일치하는지 확인합니다.
        boolean TruePwd = memberDAO.TruePwd(id, pwd);
        // 비밀번호가 일치하지 않는 경우
        if (!TruePwd) {
            System.out.println("비밀번호가 맞지 않습니다."); // 오류 메시지 출력
            return; // 메서드를 종료하여 더 이상 진행하지 않음 ( break; 는 반복문 )
        } // id, pwd 일치 확인이 되었으므로 id 만으로 확인하여 삭제 진행 가능.
        // 비밀번호가 일치하는 경우 회원 정보를 삭제합니다.
        int su = memberDAO.deleteMember(id);
        // 삭제 결과에 따라 메시지를 출력합니다.
        if (su > 0) {
            // 삭제가 성공한 경우
            System.out.println(su + " 개의 행이 삭제되었습니다.");
        } else {
            // 삭제가 실패한 경우
            System.out.println("회원 정보 삭제에 실패하였습니다.");
        }
    }
}

// 웹 - 세션이 로그인 정보를 가지고 있음, java - 정보가 없으므로 아이디로 구분
/*

아이디입력 : hong
비밀번호 입력 : 1234
비밀번호가 맞지 않습니다.

아이디 입력 : hong
비밀번호 입력 : 111

x 개의 행이 삭제되었습니다.

*/