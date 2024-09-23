package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.control.CommandProcess;

public class BoardDeleteFormService implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        // 삭제 확인 페이지로 이동
        int seq = Integer.parseInt(request.getParameter("seq"));
        request.setAttribute("seq", seq); // 게시글 번호를 전달
        
        // 삭제 확인 페이지로 포워딩
        return "/board/boardDeleteForm.jsp";
    }
}
