// UpdateService.java
package member.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class UpdateService implements Member {

    @Override
    public void execute() {
        System.out.println();
        Scanner sc = new Scanner(System.in);

        // 사용자에게 아이디를 입력받습니다.
        System.out.print("아이디 검색 : ");
        String id = sc.nextLine();

        // MemberDAO 인스턴스를 가져옵니다.
        MemberDAO memberDAO = MemberDAO.getInstance();

        // 아이디로 회원 정보를 조회합니다.
        MemberDTO memberDTO = memberDAO.getMember(id);

        // 조회된 회원 정보가 없는 경우
        if (memberDTO == null) {
            System.out.println("검색한 아이디가 없습니다.");
            return; // 메서드를 종료합니다.
        }

        // 기존 회원 정보를 출력합니다.
        System.out.println(memberDTO);

        // 변경할 정보를 입력받습니다.
        System.out.print("변경할 이름 입력 : ");
        String name = sc.nextLine();
        System.out.print("변경할 비밀번호 입력 : ");
        String pwd = sc.nextLine();
        System.out.print("변경할 전화번호 입력 : ");
        String phone = sc.nextLine();
        
        // 입력받은 정보를 Map에 저장합니다.
        Map<String, String> map = new HashMap<>(); // key-value 형태로 데이터를 저장할 Map 생성
        map.put("name", name); // 이름
        map.put("id", id); // 아이디
        map.put("pwd", pwd); // 비밀번호
        map.put("phone", phone); // 전화번호

        // MemberDAO를 통해 회원 정보를 업데이트합니다.
        int su = memberDAO.update(map); // update 메서드 호출

        // 업데이트 결과를 출력합니다.
        System.out.println(su + " 개의 행을 수정하였습니다."); // 업데이트 결과 출력
    }
}



//아이디 검색 : angel
// 검색한 아이디가 없습니다.
		
// 아이디 검색 : hong
// 홍길동 hong 111
		
// 수정할 이름 입력 : 홍당무
// 수정할 비밀번호 입력 : 333
// x 개의 행을 수정하였습니다.
// id 가 중복되면 안됨.