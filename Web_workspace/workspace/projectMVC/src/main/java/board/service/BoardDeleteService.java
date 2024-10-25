package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import com.control.CommandProcess;

public class BoardDeleteService implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
    	// 게시글 번호를 request에서 추출
        int seq = Integer.parseInt(request.getParameter("seq"));
        System.out.println("Deleting post with seq: " + seq); // 로그 출력
        
        // DAO를 통해 게시글 삭제
        BoardDAO boardDAO = BoardDAO.getInstance();
        boardDAO.boardDelete(seq);
        System.out.println("Deletion completed for seq: " + seq); // 삭제 후 로그 출력
        
        // 삭제 후 게시글 목록으로 리다이렉트
        response.sendRedirect("/projectMVC/board/boardList.do");
        return "none"; // ControlServlet에서 중복 처리하지 않도록 "none" 반환
    }
}
