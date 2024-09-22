package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardDeleteService implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        // 파라미터에서 게시글 번호 받아오기
        int seq = Integer.parseInt(request.getParameter("seq"));

        // DB에서 게시글 삭제
        BoardDAO boardDAO = BoardDAO.getInstance();
        boardDAO.deleteBoard(seq);

        // 삭제 후 게시글 목록으로 리다이렉트
        return "/board/boardList.do";
    }
}
