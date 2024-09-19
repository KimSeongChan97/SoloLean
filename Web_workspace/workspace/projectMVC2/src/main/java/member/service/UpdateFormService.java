package member.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.bean.MemberDTO;
import member.control.CommandProcess;
import member.dao.MemberDAO;

public class UpdateFormService implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // 세션에 저장되어 있는 값 받기
        // 클라이언트가 로그인한 상태를 유지하기 위해 서버는 세션을 사용합니다.
        // HttpSession 객체는 사용자가 서버에 접속하여 세션이 유지되는 동안 필요한 데이터를 저장할 수 있습니다.
        // 여기서는 세션에 저장된 "memId"라는 이름의 데이터를 가져옵니다. 이 ID는 로그인한 사용자의 ID일 가능성이 큽니다.
        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("memId"); // 세션에서 사용자 ID(memId)를 가져옴

        // DB 작업
        // 데이터베이스에 접근하여 사용자의 정보를 조회하는 부분입니다.
        // MemberDAO는 DAO 패턴을 사용하여 데이터베이스와 상호작용하는 객체입니다. 여기서는 싱글턴 패턴을 사용하여 MemberDAO 인스턴스를 가져옵니다.
        MemberDAO memberDAO = MemberDAO.getInstance();
        // memberDAO의 getMember 메서드를 호출하여 해당 ID의 사용자의 정보를 데이터베이스에서 가져옵니다.
        MemberDTO memberDTO = memberDAO.getMember(id); // ID에 해당하는 회원 정보를 DB에서 가져와 MemberDTO 객체에 저장
        
        // 가져온 회원 정보를 request 객체에 저장
        // 이 부분은 가져온 데이터를 JSP 페이지로 전달하기 위해 request 객체에 저장하는 단계입니다.
        // request 객체에 "memberDTO"라는 이름으로 회원 정보를 담습니다. 이 정보는 이후 JSP 페이지에서 사용자 정보를 출력하거나 수정하는 데 사용될 수 있습니다.
        request.setAttribute("memberDTO", memberDTO); // 조회한 회원 정보를 request에 설정
        
        // forwarding
        // 데이터 처리가 끝난 후 결과를 보여줄 페이지로 이동합니다. 
        // 여기서는 사용자가 정보를 수정할 수 있는 updateForm.jsp 페이지로 포워딩합니다.
        return "/member/updateForm.jsp"; // updateForm.jsp 페이지로 포워딩하여 사용자 정보 수정 화면을 띄움
    }

}
