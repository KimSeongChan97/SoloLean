package guestbook.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;

@WebServlet("/list")
public class GuestbookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // 서블릿 클래스는 HTTP 요청을 처리하는데 사용됩니다.
    // 이 클래스는 클라이언트의 방명록 목록 요청을 처리하여, 해당 데이터를 HTML로 반환합니다.
    // serialVersionUID는 클래스의 버전 관리에 사용되며, 직렬화된 객체가 올바른 클래스에서 복원되는지 확인합니다.
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 이 메서드는 GET 요청을 처리합니다.
        // 클라이언트가 "/list" 경로로 요청을 보낼 때 이 메서드가 호출됩니다.
        // 예를 들어, 클라이언트가 브라우저에서 "/list?pg=1"와 같이 요청할 때 이 메서드가 호출됩니다.

    	// 데이터
    	int pg = Integer.parseInt(request.getParameter("pg"));
    	// 클라이언트가 요청한 페이지 번호를 가져와 정수형으로 변환합니다.
        // 예를 들어, 사용자가 1페이지를 요청했다면 pg 변수는 1이 됩니다.

    	// 1페이지당 
    	int endNum = pg * 5;
    	int startNum = endNum - 4;
        // 한 페이지에 표시할 글의 시작 번호와 끝 번호를 계산합니다.
        // 예를 들어, 1페이지에서는 1번부터 5번까지의 글을, 2페이지에서는 6번부터 10번까지의 글을 가져옵니다.

    	// DB
    	GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();
        // 방명록 데이터를 처리하기 위해 GuestbookDAO 객체의 인스턴스를 가져옵니다.
        // 이 인스턴스는 싱글톤 패턴으로 구현되어 있어 애플리케이션 전체에서 동일한 인스턴스를 사용하게 됩니다.

    	List<GuestbookDTO> list = guestbookDAO.getAllGuestbooks(startNum, endNum); // 부모 = 자식
    	// 지정된 범위의 방명록 데이터를 가져옵니다.
        // 부모 = 자식이라는 주석은 List 인터페이스(부모 타입)가 ArrayList 클래스(자식 타입)의 객체를 참조할 수 있다는 것을 의미합니다.
    	System.out.println(list);
    	// 가져온 방명록 데이터를 콘솔에 출력합니다.
        // 이 코드는 디버깅 목적이며, 서버에서 실행되는 콘솔 창에 출력됩니다.

    	int totalA = guestbookDAO.getTotal(); // 총글수
    	// 방명록에 작성된 총 글 수를 가져옵니다.
        // 총 글 수는 페이지 네비게이션을 계산할 때 사용됩니다.

    	int totalP = (totalA + 4)/5;
        // 전체 페이지 수를 계산합니다.
        // 예를 들어, 글이 12개일 경우, 한 페이지당 5개의 글을 표시하므로 3페이지가 필요합니다.
        // 이 계산식은 나머지가 있을 경우 추가 페이지를 할당하도록 조정됩니다.

    	// 응답
    	response.setContentType("text/html; charset=UTF-8");
        // 응답의 컨텐츠 타입을 설정합니다. 
        // 이 경우 HTML 형식의 텍스트를 UTF-8 인코딩으로 클라이언트에게 전송합니다.
        // 이를 통해 클라이언트가 응답을 올바르게 해석하고, 한글 등 다국어 문자를 제대로 표시할 수 있습니다.

        PrintWriter out = response.getWriter();
        // PrintWriter 객체를 생성하여 클라이언트에게 응답을 작성합니다.
        // 이 객체를 통해 HTML 코드를 작성하고 클라이언트에게 전송할 수 있습니다.

        out.println("<html>");
        out.println("<body>");
        // HTML 문서의 시작 태그와 body 태그를 작성합니다.
        // 클라이언트는 이 태그를 통해 웹 페이지의 구조를 해석하고 표시합니다.

        out.println("<input type='button' value='뒤로' onclick=history.go(-1) />");
        // '뒤로' 버튼을 생성하여 사용자가 이전 페이지로 돌아갈 수 있도록 합니다.
        // history.go(-1)은 브라우저의 히스토리를 통해 한 단계 이전 페이지로 이동하는 자바스크립트 코드입니다.

        out.println("<input type='button' value='1'> ");
        // '1'이라는 값을 가진 버튼을 생성합니다.
        // 이 버튼은 페이지 네비게이션을 위한 버튼으로 예상되며, 이후 페이지 번호가 표시될 수 있습니다.

        out.println("<hr/>");
        // 수평선을 삽입하여 페이지의 내용과 구분을 줍니다.

        if(list != null) {
        	// 방명록 데이터가 존재하는지 확인합니다.
            // null이 아니라면, 가져온 방명록 데이터를 순회하며 HTML로 출력합니다.

        	for(GuestbookDTO guestbookDTO : list) {
        		// 방명록 목록을 순회하며 각 항목을 HTML로 출력합니다.
        		out.println("<table border='1'>");
        		out.println("<tr>");
        		out.println("<th width='100'>작성자</th>");
        		out.println("<td width='150' align='center'>" + guestbookDTO.getName() + "</td>");
        		// 작성자의 이름을 테이블 셀에 출력합니다.
        		out.println("<th width='100'>작성일</th>");
        		out.println("<td width='150' align='center'>" + guestbookDTO.getLogtime() + "</td>");
        		// 작성일을 테이블 셀에 출력합니다.
        		out.println("</tr>");
        		
        		out.println("<tr>");
        		out.println("<th>이메일</th>");
        		out.println("<td colspan='3'>" + guestbookDTO.getEmail() + "</td>");
        		// 작성자의 이메일을 테이블 셀에 출력합니다. 
        		// colspan='3'은 해당 셀이 3개의 열을 차지하게 합니다.
        		out.println("</tr>");
        		
        		out.println("<tr>");
        		out.println("<th>홈페이지</th>");
        		out.println("<td colspan='3'>" + guestbookDTO.getHomepage() + "</td>");
        		// 작성자의 홈페이지 주소를 테이블 셀에 출력합니다.
        		out.println("</tr>");
        		
        		out.println("<tr>");
        		out.println("<th>제목</th>");
        		out.println("<td colspan='3'>" + guestbookDTO.getSubject() + "</td>");
        		// 글 제목을 테이블 셀에 출력합니다.
        		out.println("</tr>");
        		
        		out.println("<tr>");
        		out.println("<td colspan='4' style='white-space: normal'>" + guestbookDTO.getContent() + "</td>");
        		// 글 내용을 테이블 셀에 출력합니다.
        		// white-space: normal 스타일은 긴 내용이 있을 경우 자동으로 줄바꿈을 허용합니다.
        		out.println("</tr>");
        		out.println("</table>");
        		out.println("<hr/>");
        		// 각 방명록 항목을 테이블로 구성하여 출력하고, 항목 사이에 수평선을 삽입합니다.
        	}//for
        }//if
        
        out.println("</html>");
        out.println("</body>");
        // HTML 문서의 종료 태그를 작성하여 응답을 마무리합니다.
        // 클라이언트는 이 태그를 통해 HTML 문서가 끝났음을 인식합니다.
	}
}
