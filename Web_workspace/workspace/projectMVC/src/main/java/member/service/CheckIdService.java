package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import member.dao.MemberDAO;

public class CheckIdService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// request 객체에서 사용자가 입력한 id를 가져옵니다.
		String id = request.getParameter("id");
		
		// MemberDAO 객체를 생성하여 DB와 연결하고, 입력한 id가 존재하는지 확인하는 메서드를 호출합니다.
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		//id가 있으면 true(사용 불가능), id가 없으면 false(사용 가능)
		// DB에 해당 ID가 존재하는지 확인
		boolean exist = memberDAO.isExistId(id); // 싱글톤 패턴으로 DAO 객체를 사용
		 // 확인된 결과를 request 객체에 속성으로 저장하여 뷰에서 사용될 수 있게 전달
		request.setAttribute("exist", exist);
		 // id를 체크하는 서비스는 결과를 보여줄 뷰 페이지로 이동하기 위해 "checkIdResult.jsp"를 반환합니다.
		return "/member/checkId.jsp";
	}

}





