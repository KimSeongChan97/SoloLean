package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class UpdateService implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        // 데이터
        // 사용자가 폼에서 입력한 데이터를 request 객체에서 받아옵니다.
        String name = request.getParameter("name"); // 사용자 이름
        String id = request.getParameter("id");     // 사용자 ID (로그인된 사용자 ID)
        String pwd = request.getParameter("pwd");   // 비밀번호
        String gender = request.getParameter("gender"); // 성별
        String email1 = request.getParameter("email1"); // 이메일 앞부분
        String email2 = request.getParameter("email2"); // 이메일 뒷부분
        String tel1 = request.getParameter("tel1"); // 전화번호 앞부분 (지역번호)
        String tel2 = request.getParameter("tel2"); // 전화번호 중간부분
        String tel3 = request.getParameter("tel3"); // 전화번호 끝부분
        String zipcode = request.getParameter("zipcode"); // 우편번호
        String addr1 = request.getParameter("addr1"); // 주소1
        String addr2 = request.getParameter("addr2"); // 주소2 (상세주소)
        
        // MemberDTO 객체에 입력된 정보를 저장합니다.
        // MemberDTO는 회원 정보를 담는 데이터 전송 객체입니다.
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName(name);     // 사용자 이름 설정
        memberDTO.setId(id);         // 사용자 ID 설정 (필수 값)
        memberDTO.setPwd(pwd);       // 비밀번호 설정
        memberDTO.setGender(gender); // 성별 설정
        memberDTO.setEmail1(email1); // 이메일 앞부분 설정
        memberDTO.setEmail2(email2); // 이메일 뒷부분 설정
        memberDTO.setTel1(tel1);     // 전화번호 앞부분 설정
        memberDTO.setTel2(tel2);     // 전화번호 중간부분 설정
        memberDTO.setTel3(tel3);     // 전화번호 끝부분 설정
        memberDTO.setZipcode(zipcode); // 우편번호 설정
        memberDTO.setAddr1(addr1);   // 주소1 설정
        memberDTO.setAddr2(addr2);   // 주소2 (상세주소) 설정
        
        // DB에 회원 정보 업데이트
        MemberDAO memberDAO = MemberDAO.getInstance();
        // 싱글톤 패턴으로 DAO 객체를 얻어와서 데이터베이스 작업을 처리합니다.
        memberDAO.update(memberDTO);
        // 입력된 데이터를 바탕으로 데이터베이스에서 회원 정보를 업데이트합니다.
        
        // 세션 무효화
        HttpSession session = request.getSession();
        session.invalidate(); // 세션을 무효화하여 사용자의 로그인 상태를 해제합니다.
        // 사용자 정보가 수정되면 세션을 무효화하여 로그아웃 처리합니다. 새로 로그인해야 업데이트된 정보가 반영됩니다.
        
        return "none";
        // 화면 이동 없이 서버에서 작업만 처리하고 끝냅니다. 
        // 이 값은 'forward'나 'redirect'가 없다는 것을 의미하며, 일반적으로 추가적인 페이지 전환이 필요 없는 작업에 사용됩니다.
    }
}
