package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardUpdateFormService implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        // 'seq'라는 파라미터로 전달된 값을 가져옵니다. 
        // 이 값은 수정하려는 게시글의 고유번호로, 문자열 형태의 파라미터를 정수로 변환합니다.
        // Integer.parseInt() 메서드를 사용하여 문자열을 정수로 변환합니다.
        int seq = Integer.parseInt(request.getParameter("seq"));

        // 'pg'라는 파라미터로 전달된 값을 가져옵니다. 
        // 이 값은 현재 사용자가 보고 있는 페이지 번호입니다.
        // 마찬가지로 문자열 형태의 파라미터를 정수로 변환합니다.
        int pg = Integer.parseInt(request.getParameter("pg"));

        // BoardDAO 객체를 싱글톤 패턴을 사용하여 가져옵니다.
        // BoardDAO는 데이터베이스에서 게시글과 관련된 작업을 처리하는 클래스입니다.
        // getInstance() 메서드는 이 클래스의 유일한 인스턴스를 반환합니다.
        BoardDAO boardDAO = BoardDAO.getInstance();

        // 데이터베이스에서 'seq' 번호에 해당하는 게시글 정보를 가져옵니다.
        // boardDAO의 getBoard() 메서드를 사용하여 해당 게시글의 정보를 담은 BoardDTO 객체를 반환받습니다.
        // BoardDTO는 게시글의 모든 데이터를 담고 있는 데이터 객체입니다.
        BoardDTO boardDTO = boardDAO.getBoard(seq);

        // request 객체에 'pg' 값을 저장합니다.
        // 이 값은 나중에 JSP 페이지에서 사용되며, 사용자가 원래 보고 있던 페이지 번호를 유지하는 데 사용됩니다.
        request.setAttribute("pg", pg);

        // request 객체에 'boardDTO' 값을 저장합니다.
        // 이 값은 나중에 JSP 페이지에서 사용되며, 수정하려는 게시글의 데이터를 화면에 표시하기 위해 사용됩니다.
        request.setAttribute("boardDTO", boardDTO);

        // 수정 폼으로 이동하기 위한 경로를 반환합니다.
        // 이 경로는 사용자가 수정하려는 게시글의 내용을 보여주는 JSP 페이지입니다.
        return "/board/boardUpdateForm.jsp";
    }

}
