package guestbook.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/write")
public class GuestbookWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//데이터
		request.setCharacterEncoding("UTF-8"); // 한글처리(post 방식)
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String homepage = request.getParameter("homepage");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		// DB
		
		// 응답
		
		
		
		
		
		/*
		 * // 데이터 받기 request.setCharacterEncoding("UTF-8");
		 * 
		 * // 클라이언트로부터 폼 데이터를 받아 DTO에 설정 GuestbookDTO dto = new GuestbookDTO();
		 * dto.setName(request.getParameter("name"));
		 * dto.setEmail(request.getParameter("email"));
		 * dto.setHomepage(request.getParameter("homepage"));
		 * dto.setSubject(request.getParameter("subject"));
		 * dto.setContent(request.getParameter("content"));
		 * 
		 * // DAO 객체를 생성하고 DB에 데이터 저장 GuestbookDAO dao = new GuestbookDAO();
		 * dao.guestbookWrite(dto);
		 * 
		 * // 응답을 설정하여 작성 완료 메시지를 출력
		 * response.setContentType("text/html; charser=UTF-8");
		 * response.getWriter().println("작성하신 글을 저장 완료하였습니다.");
		 * 
		 */
		
	}

}
