package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class LoginService implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        // 데이터
        String id = request.getParameter("id"); // 사용자가 입력한 ID를 가져옵니다.
        String pwd = request.getParameter("pwd"); // 사용자가 입력한 비밀번호를 가져옵니다.
        
        // DB
        MemberDAO memberDAO = MemberDAO.getInstance(); // 싱글톤 패턴으로 MemberDAO 객체를 가져옵니다.
        MemberDTO memberDTO = memberDAO.login(id, pwd); // 입력한 ID와 비밀번호로 로그인 시도
        
        if (memberDTO == null) {
            // 로그인 실패 시
            return "/member/loginFail.jsp"; // 로그인 실패 시 로그인 실패 페이지로 이동합니다.
        } else {
            // 세션
            HttpSession session = request.getSession(); // 세션 생성
            // 사용자의 이름, ID, 이메일을 세션에 저장하여 로그인 상태를 유지합니다.
            session.setAttribute("memName", memberDTO.getName()); // 사용자의 이름을 세션에 저장
            session.setAttribute("memId", id); // 사용자의 ID를 세션에 저장
            session.setAttribute("memEmail", memberDTO.getEmail1() + "@" + memberDTO.getEmail2()); // 사용자의 이메일을 세션에 저장
            
            session.setAttribute("memDTO", memberDTO); // 전체 MemberDTO 객체를 세션에 저장하여 필요할 때 쉽게 접근할 수 있도록 함.
            
            return "/member/loginOk.jsp"; // 로그인 성공 시 로그인 성공 페이지로 이동합니다.
        }
    }

}
