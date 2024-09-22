package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class UpdateFormService implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        // 데이터
        HttpSession session = request.getSession();
        // 사용자의 세션을 가져옵니다. 세션은 사용자가 로그인할 때 생성되었으며, 여기서 로그인된 사용자 정보에 접근할 수 있습니다.
        
        String id = (String) session.getAttribute("memId");
        // 세션에서 "memId" 속성을 가져와서 현재 로그인된 사용자의 ID를 얻습니다.
        // 로그인이 되어 있는 상태라면, 세션에 사용자의 ID가 저장되어 있을 것입니다.

        // DB
        MemberDAO memberDAO = MemberDAO.getInstance();
        // 싱글톤 패턴을 통해 MemberDAO 인스턴스를 가져옵니다. 데이터베이스와 상호작용하는 객체로, 이 객체를 통해 DB 작업을 수행합니다.

        MemberDTO memberDTO = memberDAO.getMember(id);
        // 현재 로그인된 사용자의 ID를 이용해, 데이터베이스에서 해당 사용자의 정보를 가져옵니다.
        // `getMember` 메서드는 ID를 기준으로 회원 정보를 조회하여 `MemberDTO` 객체로 반환합니다.

        request.setAttribute("memberDTO", memberDTO);
        // 가져온 회원 정보를 request 객체에 속성으로 저장합니다. 이 속성은 이후 JSP 페이지에서 사용자 정보를 표시할 때 사용됩니다.
        // "memberDTO"라는 이름으로 회원 정보 객체를 JSP에서 사용할 수 있게 됩니다.

        return "/member/updateForm.jsp";
        // 회원 정보를 수정하는 폼 페이지인 "updateForm.jsp"로 이동합니다. 이 페이지에서 사용자는 자신의 정보를 수정할 수 있습니다.
        // 이 JSP는 request에 저장된 `memberDTO` 객체를 이용해 사용자 정보를 화면에 표시할 것입니다.
    }

}
