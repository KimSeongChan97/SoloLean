package board.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardWriteService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
	    // **기존 주석**: 클라이언트로부터 전달된 제목과 내용을 가져옴
	    // **추가 주석**: 사용자가 작성한 게시글의 제목과 내용이 폼을 통해 서버로 전달됨. 
	    // getParameter() 메서드를 사용하여 해당 데이터를 추출하고, 이를 각 변수에 저장
	    String subject = request.getParameter("subject"); // 게시글 제목
	    String content = request.getParameter("content"); // 게시글 내용
	    
	    // **기존 주석**: 세션 객체를 가져옴 
	    // **추가 주석**: 현재 사용자와 관련된 세션 데이터를 가져옴. 
	    // 세션 객체는 클라이언트의 상태를 서버에서 유지하는 방법으로, 로그인 정보 등 사용자 고유 데이터를 유지하는 데 사용됨.
	    HttpSession session = request.getSession(); // 세션 객체 생성
	    
	    // **기존 주석**: 세션에서 사용자 정보(id, name, email)를 가져옴
	    // **추가 주석**: 세션에서 로그인한 사용자의 아이디, 이름, 이메일 정보를 추출함. 
	    // 이 정보는 사용자가 로그인할 때 세션에 저장된 상태로 남아 있으며, 이를 이용해 게시글 작성자 정보를 자동으로 입력
	    String id = (String)session.getAttribute("memId"); // 로그인한 사용자의 ID
	    String name = (String)session.getAttribute("memName"); // 로그인한 사용자의 이름
	    String email = (String)session.getAttribute("memEmail"); // 로그인한 사용자의 이메일

	    // **기존 주석**: 게시글 작성에 필요한 데이터를 맵에 저장
	    // **추가 주석**: 여러 개의 데이터를 한 번에 관리하고 전송하기 위해 HashMap을 사용함. 
	    // 키-값 쌍으로 데이터를 저장하며, DB에 게시글을 저장할 때 필요한 필수 데이터를 하나의 Map 객체로 모음.
	    Map<String, String> map = new HashMap<>();
	    map.put("id", id); // 사용자의 ID 저장
	    map.put("name", name); // 사용자의 이름 저장
	    map.put("email", email); // 사용자의 이메일 저장
	    map.put("subject", subject); // 게시글 제목 저장
	    map.put("content", content); // 게시글 내용 저장

	    // **기존 주석**: BoardDAO를 통해 DB에 접근하여 게시글을 저장
	    // **추가 주석**: Singleton 패턴을 사용해 BoardDAO 인스턴스를 생성 및 호출. 
	    // BoardDAO는 DB와의 연결 및 쿼리 실행을 담당하며, boardWrite() 메서드를 호출해 게시글 데이터를 DB에 저장
	    BoardDAO boardDAO = BoardDAO.getInstance(); // DAO 객체 생성 (Singleton 패턴)
	    boardDAO.boardWrite(map); // DB에 게시글 작성 데이터를 전송
		
	    // **기존 주석**: 처리 완료 후 반환할 페이지가 없을 때 "none" 반환
	    // **추가 주석**: 반환값이 "none"이라는 의미는 특정 JSP 페이지로 이동하지 않고, 이후의 작업이 필요 없음을 나타냄
	    return "none"; // 게시글 작성 후 별도의 페이지 이동 없음
	}

}
