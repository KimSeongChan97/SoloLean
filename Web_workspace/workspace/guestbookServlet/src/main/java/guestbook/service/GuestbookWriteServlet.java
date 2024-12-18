package guestbook.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;

@WebServlet("/write")
public class GuestbookWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // 서블릿 클래스는 클라이언트의 요청을 처리하고 응답을 생성하는 데 사용됩니다.
    // 이 클래스는 방명록에 새 글을 작성하는 요청을 처리합니다.
    // serialVersionUID는 클래스의 버전 관리에 사용되며, 직렬화된 객체가 올바른 클래스에서 복원되는지 확인합니다.
  
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		// 클라이언트가 POST 방식으로 요청을 보낼 때 호출되는 메서드입니다.
        // POST 방식은 보통 폼 데이터를 전송할 때 사용됩니다.
 		
 		// 데이터
 		request.setCharacterEncoding("UTF-8"); //한글처리 - post 방식
 		// 요청 본문의 인코딩을 UTF-8로 설정하여, 한글 등의 다국어 문자를 올바르게 처리할 수 있게 합니다.
        // 이는 POST 요청에서만 필요하며, GET 요청에서는 필요하지 않습니다.
 		
 		String name = request.getParameter("name");
 		String email = request.getParameter("email");
 		String homepage = request.getParameter("homepage");
 		String subject = request.getParameter("subject");
 		String content = request.getParameter("content");
 		// 클라이언트가 폼을 통해 전송한 데이터를 request 객체로부터 가져옵니다.
        // getParameter() 메서드는 HTML 폼 필드의 이름을 사용하여 해당 값을 가져옵니다.

 		GuestbookDTO guestbookDTO = new GuestbookDTO();
 		guestbookDTO.setName(name);
 		guestbookDTO.setEmail(email);
 		guestbookDTO.setHomepage(homepage);
 		guestbookDTO.setSubject(subject);
 		guestbookDTO.setContent(content);
 		// 가져온 데이터를 GuestbookDTO 객체에 설정합니다.
        // DTO는 데이터베이스로 전송하거나 데이터베이스에서 가져온 데이터를 저장하는 데 사용되는 객체입니다.
        // 이 객체는 데이터의 저장과 전송을 위한 용도로 사용되며, 클라이언트와 서버 간에 데이터를 주고받는 데 유용합니다.

 		// DB
 		GuestbookDAO guestbookDAO = GuestbookDAO.getInstance(); //싱글톤
 		// GuestbookDAO 객체를 싱글톤 패턴으로 가져옵니다.
        // 싱글톤 패턴을 사용하면 애플리케이션 전체에서 이 인스턴스를 공유하게 됩니다.
        // 이를 통해 데이터베이스와의 연결 및 데이터 처리의 효율성을 높일 수 있습니다.

 		guestbookDAO.guestbookWrite(guestbookDTO);
 		// DAO 객체를 사용하여 방명록에 새 글을 작성합니다.
        // 이 메서드는 데이터베이스에 연결하여, 작성된 글을 저장하는 역할을 합니다.

 		// 응답
 		response.setContentType("text/html; charset=UTF-8");
 		// 클라이언트에게 보낼 응답의 컨텐츠 타입을 설정합니다.
        // HTML 문서 형식으로 응답을 보내며, UTF-8 인코딩을 사용하여 다국어 문자를 올바르게 표시합니다.

 		PrintWriter out = response.getWriter();
 		// PrintWriter 객체를 생성하여 클라이언트에게 응답을 보낼 준비를 합니다.
        // 이 객체를 사용하여 HTML 문서의 내용을 작성하고, 이를 클라이언트에게 전송합니다.

 		out.println("<html>");
		out.println("<body>");
		// HTML 문서의 시작 태그와 body 태그를 작성합니다.
        // 이 태그들은 클라이언트의 브라우저에서 웹 페이지의 구조를 정의합니다.

		out.println("<h3>작성하신 글을 저장하였습니다.</h3>");
		// 사용자가 작성한 글이 성공적으로 저장되었음을 알리는 메시지를 출력합니다.
        // <h3> 태그는 HTML에서 제목을 나타내며, 이 경우 3단계 크기의 제목을 의미합니다.

		out.println("<br><br>");
		// 줄바꿈을 위해 <br> 태그를 두 번 사용하여 두 줄을 띄웁니다.
        // 이는 HTML에서 줄바꿈을 의미하며, 다음 내용과의 간격을 줍니다.

		out.println("""
				<input type='button' value='뒤로' onclick=history.go(-1) />
				<input type='button' value='글목록' 
					   onclick=location.href='/guestbookServlet/list?pg=1'
				""");
		// '뒤로' 버튼을 생성하여 사용자가 이전 페이지로 돌아갈 수 있도록 합니다.
        // history.go(-1)은 브라우저의 히스토리에서 이전 페이지로 이동하는 자바스크립트 코드입니다.
        // '글목록' 버튼을 생성하여 사용자가 방명록 목록 페이지로 이동할 수 있도록 합니다.
        // location.href 속성을 사용하여 '/guestbookServlet/list?pg=1' 경로로 이동합니다.

		out.println("</body>");
		out.println("</html");
		// HTML 문서의 종료 태그를 작성하여 응답을 마무리합니다.
        // 클라이언트는 이 태그들을 통해 HTML 문서가 끝났음을 인식합니다.
 	}
}

