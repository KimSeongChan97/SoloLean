package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.control.CommandProcess;

public class WriteFormService implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 클라이언트가 서버에 특정 요청을 했을 때 해당 요청을 처리하고,
        // 이 메소드에서 처리된 결과로 JSP 파일의 경로를 반환하는 역할을 합니다.
        // 여기서는 /member/writeForm.jsp로 포워딩하기 위한 경로를 반환합니다.
        
        return "/member/writeForm.jsp";  // 이 JSP 파일은 member 폴더 안에 위치하고 있으며, 사용자가 글쓰기 양식을 작성하는 페이지입니다.
    }
    
}
