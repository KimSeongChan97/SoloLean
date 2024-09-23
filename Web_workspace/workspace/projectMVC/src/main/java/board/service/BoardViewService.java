package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardViewService implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        
        // 데이터 받아오기
        int seq = Integer.parseInt(request.getParameter("seq"));
        // **추가 설명**: `request.getParameter("seq")`는 URL 또는 폼에서 전달된 'seq' 값을 문자열로 가져옵니다.
        // 게시글 번호(`seq`)는 게시글의 고유 식별자로, 이를 통해 특정 게시글을 조회하게 됩니다.
        // `Integer.parseInt()`는 해당 문자열을 정수형으로 변환하여 변수 `seq`에 저장합니다.
        
        int pg = Integer.parseInt(request.getParameter("pg"));
        // **추가 설명**: 'pg'는 현재 페이지 번호로, 사용자가 어느 페이지에서 이 게시글을 보고 있는지 나타냅니다. 
        // 페이지 번호는 게시판 리스트에서 페이지 이동 시 전달됩니다. 이 값을 나중에 화면으로 전달하여 다시 페이지로 돌아갈 수 있도록 합니다.
        
        // DB 에서 받아오기
        BoardDAO boardDAO = BoardDAO.getInstance(); 
        // **추가 설명**: DAO(Data Access Object) 패턴으로, 데이터베이스와의 상호작용을 담당합니다. 
        // `BoardDAO.getInstance()`는 싱글톤 패턴을 통해 이미 생성된 BoardDAO 인스턴스를 반환합니다. 이를 통해 데이터베이스 연결을 관리하고, 게시글 데이터를 조회하게 됩니다.
        
        // 조회수 증가
        boardDAO.hitUpdate(seq);
        
        
        BoardDTO boardDTO = boardDAO.getBoard(seq); 
        // **추가 설명**: `getBoard(seq)` 메서드는 `seq` 번호에 해당하는 게시글의 정보를 데이터베이스에서 가져옵니다. 
        // 이 메서드는 MyBatis를 통해 SQL 쿼리를 실행하여 게시글 정보를 가져오며, 결과는 `BoardDTO` 객체로 반환됩니다. 
        // 이 객체에는 게시글의 제목, 내용, 작성자 등의 정보가 담겨 있습니다.

        // 가져온 데이터들을 request 객체에 저장
        request.setAttribute("pg", pg); 
        // **추가 설명**: `pg` 값은 다시 request 객체에 저장됩니다. 이 값은 JSP 페이지로 전달되어, 사용자가 현재 보고 있던 페이지 번호로 돌아갈 수 있도록 도와줍니다.
        request.setAttribute("boardDTO", boardDTO); 
        // **추가 설명**: `boardDTO` 객체는 JSP 페이지에서 사용될 게시글의 세부 정보를 포함하고 있으며, 이를 request 객체에 저장하여 나중에 JSP에서 출력하게 됩니다.

        // forward
        return "/board/boardView.jsp"; 
        // **추가 설명**: 요청 처리가 완료되면 `boardView.jsp` 페이지로 포워딩됩니다. 
        // 포워딩된 JSP 페이지에서는 전달받은 `boardDTO` 객체를 사용해 게시글의 세부 정보를 화면에 출력합니다. 
        // 포워딩을 사용함으로써 서버 내에서 페이지를 이동시키고, 클라이언트가 다른 페이지로 리다이렉트되지 않도록 합니다.
    }
}
