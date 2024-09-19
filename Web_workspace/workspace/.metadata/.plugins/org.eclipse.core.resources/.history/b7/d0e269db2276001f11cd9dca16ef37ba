package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.control.CommandProcess;
import member.dao.MemberDAO;

public class CheckIdService implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
    	// 데이터
    	// 클라이언트에서 전달된 "id" 파라미터 값을 가져옴 (회원가입 폼에서 입력한 아이디)
    	// getParameter() 메서드를 사용하여 요청(request)으로부터 전달된 데이터를 받아오는 것
    	String id = request.getParameter("id");

    	// DB
    	// MemberDAO의 인스턴스를 가져옴. MemberDAO는 데이터베이스와의 상호작용을 처리하는 클래스
    	// getInstance()는 싱글톤 패턴을 사용해 DAO 객체를 하나만 생성하고 여러 곳에서 사용하도록 함
    	MemberDAO memberDAO = MemberDAO.getInstance();
    	
    	// id가 있으면 true(사용 불가능), id가 없으면 false(사용 가능)
    	// 데이터베이스에서 사용자가 입력한 아이디가 이미 존재하는지 확인 (isExistId 메서드 호출)
    	// 이미 존재하는 아이디일 경우 true를 반환하여 "사용 불가능" 상태를 나타냄
    	// 존재하지 않는 아이디일 경우 false를 반환하여 "사용 가능" 상태를 나타냄
    	boolean exist = memberDAO.isExistId(id);  
    	
    	// request 객체에 "exist" 속성을 추가함
    	// 이 속성은 JSP 페이지로 전달되어 아이디가 존재하는지 여부를 클라이언트에게 표시하는 데 사용됨
    	// 예: true이면 "아이디가 존재함", false이면 "아이디가 사용 가능함"과 같은 메시지를 표시
    	request.setAttribute("exist", exist); // servlet 의 exist 를 가지고 감
    	
    	// 아이디 중복 체크 결과를 표시할 JSP 페이지로 이동
    	// checkId.jsp 페이지에서 위의 "exist" 속성을 참조하여 아이디 중복 여부에 대한 결과를 화면에 출력하게 됨
    	return "/member/checkId.jsp";
    }
}
