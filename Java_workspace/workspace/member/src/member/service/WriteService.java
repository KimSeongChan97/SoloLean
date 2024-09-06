package member.service;

import java.util.Scanner;
import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class WriteService implements Member {

    @Override
    public void execute() {
        System.out.println(); // 줄바꿈 출력
        Scanner sc = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성
        String id; // while 로 id 가 맴도므로 새로 생성
        // DB -> 싱글톤 처리
        MemberDAO memberDAO = MemberDAO.getInstance();
        // 사용자로부터 입력 받기
        System.out.print("이름 입력: ");
        String name = sc.next(); // 사용자로부터 이름 입력받기, 공백은 입력받을 수 없음
//      아이디 중복 체크
        while (true) {
        	System.out.println();
            System.out.print("아이디 입력: ");
            id = sc.next(); // 사용자로부터 아이디 입력받기
//      is = true, false 리턴 받기
//      isExistId 메소드 만들기
//      return 된 값이 true 이면 "사용중인 아이디 입니다" 라고 출력하고 다시 입력 받는다. -> 이름에서 while 문 돌아아 햠
//      return 된 값이 false 이면 "사용 가능한 아이디" 라고 출력하고 비밀번호 입력받으러 간다.
            	// DB
            	boolean exist = memberDAO.isExistId(id);
            	if (exist)
            		System.out.println("사용중인 아이디 입니다."); // true
            	else {
            		System.out.println("사용 가능한 아이디 입니다."); // false
            		break;
            	}
		} // while
        System.out.print("비밀번호 입력: ");
        String pwd = sc.next(); // 사용자로부터 비밀번호 입력받기
        System.out.print("핸드폰 입력(010-1234-5678): ");
        String phone = sc.next(); // 사용자로부터 핸드폰 번호 입력받기
        // 입력 받은 데이터를 MemberDTO 객체에 저장
        MemberDTO memberDTO = new MemberDTO(); // 새로운 MemberDTO 객체 생성
        memberDTO.setName(name); // 이름 설정
        memberDTO.setId(id); // 아이디 설정
        memberDTO.setPwd(pwd); // 비밀번호 설정
        memberDTO.setPhone(phone); // 핸드폰 번호 설정
        // MemberDAO를 사용하여 데이터베이스에 저장 -> 싱글톤으로 해야함.
        // MemberDAO 클래스의 유일한 인스턴스를 가져옴
        int su = memberDAO.write(memberDTO); // write 메서드를 호출하여 데이터베이스에 회원 정보 삽입
        System.out.println(su + "개의 행이 만들어 졌습니다.(회원가입완료)"); // 삽입된 행의 수를 출력
        // MemberDAO의 인스턴스는 애플리케이션 내에서 단 하나만 생성되고, 
        // 모든 서비스 클래스에서 동일한 인스턴스를 공유하게 됩니다.
        
    }
}
