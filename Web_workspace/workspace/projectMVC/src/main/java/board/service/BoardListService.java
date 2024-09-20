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
		
		int pg = 1;
		if(request.getParameter("pg") != null) pg = Integer.parseInt(request.getParameter("pg"));
		
		// 'pg' 파라미터를 request에서 받아옵니다. 이는 현재 페이지 번호를 나타냅니다.
	    // 사용자가 특정 페이지 번호를 클릭했을 때, 그 페이지 번호를 'pg'로 전달받아 처리합니다.
	    // (추가 설명) 사용자는 게시판에서 여러 페이지를 탐색할 수 있는데, 이를 위해 'pg' 파라미터가 필요합니다. 'pg'는 URL 쿼리스트링이나 form 데이터를 통해 전달됩니다.
	    // int pg = Integer.parseInt(request.getParameter("pg")); // 'pg'는 문자열로 전달되므로, 이를 정수형으로 변환합니다. 예를 들어, 'pg=1'이면 1로 변환됩니다.
	    
	    // 한 페이지당 표시할 게시글 수를 5개로 설정합니다.
	    // 따라서 'pg'에 따라 계산된 startNum과 endNum으로 해당 페이지에 표시될 게시글을 가져옵니다.
	    // (추가 설명) 한 페이지에서 몇 개의 게시글을 보여줄지 결정하는 것이 pageSize입니다. 이 코드에서는 5개로 설정했습니다.
	    int endNum = pg * 5; // 현재 페이지에서 끝 번호를 계산합니다. 5개씩 보여주므로 예를 들어, 1페이지는 1~5번 글을 가져옵니다.
	    // (추가 설명) endNum은 현재 페이지에서 마지막으로 가져올 게시글의 번호를 의미합니다. 만약 2페이지라면 6~10번 게시글을 가져오게 됩니다.
	    // startNum은 endNum에서 4를 뺀 값으로, 예를 들어 1페이지의 경우 1부터 시작하게 됩니다.
	    int startNum = endNum - 4; // 시작 번호는 끝 번호에서 4를 뺀 값이 됩니다. 즉, 1페이지는 1번부터 시작하게 됩니다.
	    // (추가 설명) startNum은 해당 페이지에서 첫 번째로 가져올 게시글의 번호입니다. 1페이지에서는 1번, 2페이지에서는 6번부터 시작됩니다.

	    // 데이터베이스에서 게시글을 가져오기 위해 BoardDAO 객체를 생성합니다.
	    // Singleton 패턴을 사용하여 하나의 인스턴스만 사용하도록 보장합니다.
	    // (추가 설명) Singleton 패턴은 하나의 인스턴스만을 생성하고, 그 인스턴스를 여러 곳에서 재사용하도록 합니다. 
	    // 이렇게 하면 메모리 낭비를 줄이고, 객체 간의 상태를 일관되게 유지할 수 있습니다.
	    BoardDAO boardDAO = BoardDAO.getInstance(); 
	    // boardList 메서드를 호출하여 startNum과 endNum에 해당하는 게시글 목록을 가져옵니다.
	    // 이 메서드는 해당 페이지에 보여줄 게시글을 DB에서 가져오는 역할을 합니다.
	    // (추가 설명) boardList 메서드는 데이터베이스 쿼리를 실행하여 startNum과 endNum 범위에 속하는 게시글을 반환합니다. 
	    // 이 범위는 페이지네이션에서 중요한 역할을 합니다. 예를 들어, 1페이지는 1~5번 글, 2페이지는 6~10번 글을 가져옵니다.
	    List<BoardDTO> list = boardDAO.boardList(startNum, endNum);
	    
	    // 페이징 처리
	    // 전체 게시글 수(totalA)를 가져오기 위해 BoardDAO 클래스의 getTotalA() 메서드를 호출합니다.
	    // 이 값은 전체 페이지 수를 계산하는 데 사용됩니다.
	    // (추가 설명) 페이징 처리를 위해서는 전체 게시글 수가 필요합니다. 이를 통해 몇 개의 페이지가 필요한지 계산할 수 있습니다.
	    int totalA = boardDAO.getTotalA(); // getTotalA 메서드는 데이터베이스에서 전체 게시글의 개수를 반환합니다.

	    // BoardPaging 객체를 생성하여 페이징 처리를 설정합니다.
	    // (추가 설명) BoardPaging 클래스는 페이징 로직을 처리하는 역할을 합니다. 페이지 번호, 이전/다음 버튼, 전체 페이지 수 등을 관리합니다.
	    BoardPaging boardPaging = new BoardPaging();
		    
	    // 현재 페이지를 설정합니다. 사용자가 보고 있는 페이지 번호입니다.
	    // (추가 설명) 사용자가 현재 보고 있는 페이지 번호를 설정하는 부분입니다. 예를 들어, 사용자가 2페이지를 보고 있다면, 현재 페이지는 2로 설정됩니다.
	    boardPaging.setCurrentPage(pg);
	    // 페이지 블록 수를 3으로 설정합니다. 즉, 한 번에 3개의 페이지 번호를 보여줍니다.
	    // (추가 설명) 페이지 블록 수는 페이지네이션에서 한 번에 표시할 페이지 번호의 개수를 의미합니다. 
	    // 예를 들어, 페이지 번호가 1, 2, 3만 보이도록 설정한 것입니다. 다음 블록에서는 4, 5, 6이 보입니다.
	    boardPaging.setPageBlock(3);
	    // 한 페이지당 5개의 게시글을 표시하도록 설정합니다.
	    // (추가 설명) pageSize는 한 페이지에서 몇 개의 게시글을 보여줄지 결정합니다. 이 경우에는 5개로 설정되었습니다.
	    boardPaging.setPageSize(5);
	    // 전체 게시글 수를 설정합니다. 이 값은 전체 페이지 수를 계산하는 데 사용됩니다.
	    // (추가 설명) totalA는 전체 게시글의 수입니다. 이를 이용해 전체 페이지가 몇 개인지 계산합니다. 
	    // 예를 들어, 게시글이 12개라면, 5개씩 보여주는 경우 3페이지가 필요하게 됩니다.
	    boardPaging.setTotalA(totalA);
	    
	    // 페이징 HTML을 생성하는 메서드를 호출합니다.
	    // 이 메서드는 현재 페이지, 총 페이지 수, 그리고 이전/다음 버튼을 포함하는 HTML 코드를 생성합니다.
	    // (추가 설명) makePagingHTML 메서드는 페이징 처리된 HTML 코드를 생성합니다. 이 코드에는 '이전', '다음' 버튼과 페이지 번호가 포함됩니다.
	    boardPaging.makePagingHTML();
		
	    request.setAttribute("pg", pg);
	    request.setAttribute("list", list);
		// list를 do 페이지로 전달합니다.
		// (추가 설명) request 객체를 사용하여 JSP 페이지로 데이터(게시글 목록)를 전달합니다. 
		// 이렇게 전달된 데이터는 JSP에서 출력되어 사용자가 볼 수 있습니다.
		//request.setAttribute("list", boardDAO.boardList(startNum, endNum));
		// (추가 설명) boardPaging 객체를 JSP에 전달합니다. JSP에서는 이 객체를 통해 페이징 관련 정보를 화면에 표시합니다.
		request.setAttribute("boardPaging", boardPaging);
		
		// (추가 설명) 데이터를 처리한 후 "/board/boardList.jsp" 페이지로 이동하여, 사용자가 볼 수 있도록 화면을 렌더링합니다.
		return "/board/boardList.jsp"; // 처리 결과를 보여줄 JSP 파일의 경로를 반환합니다.
	}

}
