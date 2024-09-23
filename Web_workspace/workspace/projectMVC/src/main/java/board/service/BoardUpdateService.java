package board.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardUpdateService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		// **기존 주석**: 게시글 번호(seq)를 가져옴
		// **추가 주석**: request 객체에서 'seq' 파라미터를 받아 게시글 번호를 가져오고, 이를 정수형으로 변환.
		// 사용자가 수정하려는 게시글의 고유 번호로, DB에서 해당 게시글을 업데이트할 때 필요함.
		int seq = Integer.parseInt(request.getParameter("seq")); // 수정할 게시글 번호
		
		// **기존 주석**: 게시글의 제목과 내용을 파라미터로 받아옴
		// **추가 주석**: 사용자가 입력한 제목(subject)과 내용(content)을 각각 request 객체로부터 받아와 저장.
		// 클라이언트가 서버에 폼 데이터를 전송할 때, 게시글 제목과 내용도 함께 전달됨.
		String subject = request.getParameter("subject"); // 수정된 게시글 제목
		String content = request.getParameter("content"); // 수정된 게시글 내용
			    
	    // **기존 주석**: 수정할 게시글의 정보(번호, 제목, 내용)를 맵에 저장
	    // **추가 주석**: 게시글 번호, 제목, 내용을 각각 key-value 형태로 Map에 저장.
	    // 이를 통해 DAO로 전달 시 여러 데이터를 한 번에 전달할 수 있게 됨.
	    Map<String, Object> map = new HashMap<>();
	    map.put("seq", seq); // 게시글 번호를 맵에 저장
	    map.put("subject", subject); // 게시글 제목을 맵에 저장
	    map.put("content", content); // 게시글 내용을 맵에 저장
	    
	    // **기존 주석**: DAO 객체 생성 (Singleton 패턴)
	    // **추가 주석**: BoardDAO 인스턴스를 Singleton 패턴으로 생성.
	    // Singleton 패턴은 인스턴스를 하나만 생성해 효율적으로 DB 작업을 수행할 수 있게 해줌.
	    BoardDAO boardDAO = BoardDAO.getInstance(); // DAO 객체 생성 (Singleton 패턴)
	    
	    // **기존 주석**: DB에 게시글 작성 데이터를 전송
	    // **추가 주석**: DAO의 boardUpdate 메서드를 호출하여 DB에 게시글 수정 데이터를 전송.
	    // 이때, 앞서 생성한 map에 담긴 게시글 번호, 제목, 내용이 업데이트됨.
	    boardDAO.boardUpdate(map); // DB에 수정된 게시글 데이터를 전송
	    
	    // **기존 주석**: forward 할게 없음.
	    // **추가 주석**: 이 서비스는 페이지 이동이 없기 때문에 별도의 forward 처리가 필요 없음.
	    // 따라서 반환값으로 "none"을 사용해 이후 작업이 필요 없음을 나타냄.
		return "none"; // 처리 후 별도의 페이지 이동 없음
	}

}
