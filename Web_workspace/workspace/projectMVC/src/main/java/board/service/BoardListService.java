package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;
import com.control.CommandProcess;

public class BoardListService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		// 'pg' 파라미터를 request에서 받아옵니다. 이는 현재 페이지 번호를 나타냅니다.
	    // 사용자가 특정 페이지 번호를 클릭했을 때, 그 페이지 번호를 'pg'로 전달받아 처리합니다.
	    int pg = Integer.parseInt(request.getParameter("pg"));
	    
	    // 한 페이지당 표시할 게시글 수를 5개로 설정합니다.
	    // 따라서 'pg'에 따라 계산된 startNum과 endNum으로 해당 페이지에 표시될 게시글을 가져옵니다.
	    int endNum = pg * 8; // 현재 페이지에서 끝 번호를 계산합니다. 8개씩 보여주므로 예를 들어, 1페이지는 1~8번 글을 가져옵니다.
	    // startNum은 endNum에서 7를 뺀 값으로, 예를 들어 1페이지의 경우 1부터 시작하게 됩니다.
	    int startNum = endNum - 7; // 시작 번호는 끝 번호에서 7를 뺀 값이 됩니다. 즉, 1페이지는 1번부터 시작하게 됩니다.

	    // 데이터베이스에서 게시글을 가져오기 위해 BoardDAO_lean 객체를 생성합니다.
	    // Singleton 패턴을 사용하여 하나의 인스턴스만 사용하도록 보장합니다.
	    BoardDAO boardDAO = BoardDAO.getInstance(); 
	    // boardList 메서드를 호출하여 startNum과 endNum에 해당하는 게시글 목록을 가져옵니다.
	    // 이 메서드는 해당 페이지에 보여줄 게시글을 DB에서 가져오는 역할을 합니다.
	    List<BoardDTO> list = boardDAO.boardList(startNum, endNum);
	    
	    // 페이징 처리
	    // 전체 게시글 수(totalA)를 가져오기 위해 BoardDAO 클래스의 getTotalA() 메서드를 호출합니다.
	    // 이 값은 전체 페이지 수를 계산하는 데 사용됩니다.
	    int totalA = boardDAO.getTotalA();
	    
	    // BoardPaging 객체를 생성하여 페이징 처리를 설정합니다.
	    BoardPaging boardPaging = new BoardPaging();
		    
	    // 현재 페이지를 설정합니다. 사용자가 보고 있는 페이지 번호입니다.
	    boardPaging.setCurrentPage(pg);
	    // 페이지 블록 수를 3으로 설정합니다. 즉, 한 번에 3개의 페이지 번호를 보여줍니다.
	    boardPaging.setPageBlock(3);
	    // 한 페이지당 5개의 게시글을 표시하도록 설정합니다.
	    boardPaging.setPageSize(5);
	    // 전체 게시글 수를 설정합니다. 이 값은 전체 페이지 수를 계산하는 데 사용됩니다.
	    boardPaging.setTotalA(totalA);
	    
	    // 페이징 HTML을 생성하는 메서드를 호출합니다.
	    // 이 메서드는 현재 페이지, 총 페이지 수, 그리고 이전/다음 버튼을 포함하는 HTML 코드를 생성합니다.
	    boardPaging.makePagingHTML();
		
		// list를 do 페이지로 전달합니다.
		request.setAttribute("list", boardDAO.boardList(startNum, endNum));
		request.setAttribute("boardPaging", boardPaging);

		return "/board/boardList.jsp";
	}

}
