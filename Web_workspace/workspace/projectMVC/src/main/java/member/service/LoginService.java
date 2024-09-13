package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.bean.MemberDTO;
import member.control.CommandProcess;
import member.dao.MemberDAO;

public class LoginService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// Data 받기
		// 클라이언트로부터 전달된 로그인 폼의 데이터를 받아옴 (id와 pwd 값)
		// getParameter() 메서드를 사용해 요청(request)에서 해당 파라미터의 값을 가져옴
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// DB 연결
		// MemberDAO 객체를 통해 데이터베이스와 연결하여 회원 정보를 조회함
		// getInstance() 메서드를 통해 싱글톤 패턴으로 MemberDAO 인스턴스를 얻음
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		// 로그인 처리
		// login() 메서드를 호출하여 사용자가 입력한 id와 pwd가 데이터베이스에 존재하는지 확인
		// 해당 아이디와 비밀번호가 일치하는 회원이 있으면 해당 회원의 정보(MemberDTO 객체)를 반환함
		MemberDTO memberDTO = memberDAO.login(id, pwd);
		
		// ok, fail 구분
		// 로그인 성공 여부에 따라 처리 분기
		// memberDTO가 null이면 해당 아이디/비밀번호로 일치하는 회원이 없으므로 로그인 실패
		if(memberDTO == null) {
			// 페이지 이동
			// 로그인 실패 시 로그인 실패 페이지로 이동 (loginFail.jsp)
			return "/member/loginFail.jsp";
		} else {
			// 세션 등록
			// 로그인 성공 시, 세션(Session)에 회원 정보를 등록함
			// HttpSession 객체를 생성하여 세션을 관리 (세션은 서버에서 클라이언트의 상태를 유지하기 위한 방법)
			HttpSession session = request.getSession(); //세션 생성 (있으면 기존 세션 반환, 없으면 새 세션 생성)
			
			// 세션에 회원 이름, 아이디, 이메일, 회원 정보를 저장
			// 클라이언트의 상태를 서버에서 관리하며, 로그인 상태를 유지하기 위해 사용
			session.setAttribute("memName", memberDTO.getName());  // 세션에 회원 이름 저장
			session.setAttribute("memId", id);  // 세션에 회원 아이디 저장
			session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2());  // 세션에 회원 이메일 저장 (이메일을 두 부분으로 나누어 저장하고 있으므로 합침)
			session.setAttribute("memDTO", memberDTO);  // 세션에 전체 회원 정보 DTO 저장 (회원의 전체 정보를 필요로 할 경우를 대비)

			// 로그인 성공 시 로그인 확인 페이지로 이동 (loginOk.jsp)
			return "/member/loginOk.jsp";
		}
	}
}
