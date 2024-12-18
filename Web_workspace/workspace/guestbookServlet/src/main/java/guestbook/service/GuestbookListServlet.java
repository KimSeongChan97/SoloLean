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
    // Serializable 인터페이스를 구현하는 클래스는 serialVersionUID를 정의하여 클래스의 버전 관리를 도와줍니다.
    // 이는 클래스가 직렬화될 때 생성된 고유 ID로, 같은 클래스를 복원할 때 이 ID가 일치해야 오류가 발생하지 않습니다.
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
		// 이 메서드는 GET 요청을 처리합니다.
        // 클라이언트가 "/list" 경로로 요청을 보낼 때 이 메서드가 호출됩니다.
        // 예를 들어, 클라이언트가 브라우저에서 "/list?pg=1"와 같이 요청할 때 이 메서드가 호출됩니다.
        // GET 요청은 주로 클라이언트가 서버로부터 데이터를 요청할 때 사용되며, 이 경우 방명록 목록 데이터를 요청하게 됩니다.

    	// 데이터
    	int pg = Integer.parseInt(request.getParameter("pg"));
    	// 클라이언트가 요청한 페이지 번호를 가져와 정수형으로 변환합니다.
        // 예를 들어, 사용자가 1페이지를 요청했다면 pg 변수는 1이 됩니다.
        // request.getParameter("pg")는 쿼리 스트링에서 'pg'라는 이름의 파라미터 값을 문자열로 가져옵니다.
        // 이를 정수형으로 변환하기 위해 Integer.parseInt() 메서드를 사용합니다.
        // 이 때, 클라이언트가 잘못된 형식의 값을 보내면 NumberFormatException이 발생할 수 있으므로 주의해야 합니다.
        // 페이지 번호는 사용자가 특정 페이지를 보고 싶을 때, 해당 페이지를 서버에 요청하는 데 사용됩니다.

    	// 1페이지당 
    	int endNum = pg * 5;
    	int startNum = endNum - 4;
        // 한 페이지에 표시할 글의 시작 번호와 끝 번호를 계산합니다.
        // 예를 들어, 1페이지에서는 1번부터 3번까지의 글을, 2페이지에서는 4번부터 6번까지의 글을 가져옵니다.
        // 여기서 페이지당 3개의 글을 보여주도록 설정했습니다.
        // startNum과 endNum은 해당 페이지에 보여줄 글 목록의 범위를 지정하는 데 사용됩니다.
        // 이 값들은 데이터베이스 쿼리를 통해 지정된 범위의 글 목록을 가져오도록 도와줍니다.

    	// DB
    	GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();
        // 방명록 데이터를 처리하기 위해 GuestbookDAO 객체의 인스턴스를 가져옵니다.
        // 이 인스턴스는 싱글톤 패턴으로 구현되어 있어 애플리케이션 전체에서 동일한 인스턴스를 사용하게 됩니다.
        // 싱글톤 패턴은 클래스의 인스턴스가 하나만 생성되도록 보장하며, 이를 통해 여러 클라이언트가 동시에 같은 DAO 인스턴스를 공유할 수 있습니다.
        // 이는 데이터베이스 연결 관리와 같은 자원을 효율적으로 사용하도록 도와줍니다.
        // DAO(Data Access Object)는 데이터베이스와의 상호작용을 관리하는 객체입니다.

    	List<GuestbookDTO> list = guestbookDAO.getAllGuestbooks(startNum, endNum); // 부모 = 자식
    	// 지정된 범위의 방명록 데이터를 가져옵니다.
        // 부모 = 자식이라는 주석은 List 인터페이스(부모 타입)가 ArrayList 클래스(자식 타입)의 객체를 참조할 수 있다는 것을 의미합니다.
        // GuestbookDAO의 getAllGuestbooks() 메서드는 데이터베이스에서 startNum과 endNum 사이의 글 목록을 가져옵니다.
        // 가져온 데이터는 GuestbookDTO 객체의 리스트로 반환되며, 이는 방명록 항목 하나하나를 나타냅니다.
        // 리스트에 포함된 각 GuestbookDTO 객체는 방명록의 한 항목을 나타내며, 작성자, 이메일, 작성일, 제목 등의 정보를 포함합니다.
    	// System.out.println(list);
    	// 가져온 방명록 데이터를 콘솔에 출력합니다.
        // 이 코드는 디버깅 목적이며, 서버에서 실행되는 콘솔 창에 출력됩니다.
        // 실제 운영 환경에서는 이 코드를 주석 처리하거나 제거해야 합니다.
        // 이 코드가 유지되면, 서버 로그에 불필요한 데이터가 쌓여 성능에 영향을 줄 수 있습니다.

    	int totalA = guestbookDAO.getTotal(); // 총글수
    	// 방명록에 작성된 총 글 수를 가져옵니다.
        // 총 글 수는 페이지 네비게이션을 계산할 때 사용됩니다.
        // 데이터베이스에서 방명록에 작성된 모든 글의 개수를 가져와, 페이지 계산에 사용합니다.
        // 예를 들어, 총 9개의 글이 있다면 totalA는 9가 됩니다.
        // 총 글 수를 통해 전체 페이지 수를 계산할 수 있습니다.

    	int totalP = (totalA + 4)/5;
        // 전체 페이지 수를 계산합니다.
        // 예를 들어, 글이 12개일 경우, 한 페이지당 3개의 글을 표시하므로 4페이지가 필요합니다.
        // 이 계산식은 나머지가 있을 경우 추가 페이지를 할당하도록 조정됩니다.
        // (totalA + 4)/5는 총 글 수(totalA)에 4를 더해 페이지 수를 올림한 후, 페이지당 표시할 글 수(5)로 나누는 방식입니다.
        // 이 방식으로 글이 딱 떨어지지 않을 경우에도 추가 페이지가 생성됩니다.
        // 예를 들어, 7개의 글이 있는 경우, 5개의 글을 표시하는 페이지는 2페이지가 필요합니다.

    	// 응답
    	response.setContentType("text/html; charset=UTF-8");
        // 응답의 컨텐츠 타입을 설정합니다. 
        // 이 경우 HTML 형식의 텍스트를 UTF-8 인코딩으로 클라이언트에게 전송합니다.
        // 이를 통해 클라이언트가 응답을 올바르게 해석하고, 한글 등 다국어 문자를 제대로 표시할 수 있습니다.
        // text/html은 브라우저가 HTML 문서임을 인식하게 하고, charset=UTF-8은 문서의 인코딩 방식을 지정합니다.
        // UTF-8은 모든 언어의 문자를 표현할 수 있는 범용 문자 인코딩 방식입니다.
        // 이는 다국어 지원이 필요한 웹사이트에서 유용합니다.

        PrintWriter out = response.getWriter();
        // PrintWriter 객체를 생성하여 클라이언트에게 응답을 작성합니다.
        // 이 객체를 통해 HTML 코드를 작성하고 클라이언트에게 전송할 수 있습니다.
        // response.getWriter()는 클라이언트에게 데이터를 출력할 수 있는 Writer 객체를 반환합니다.
        // 이 객체를 사용해 문자열을 출력하면, 해당 문자열이 HTTP 응답으로 클라이언트에게 전송됩니다.
        // 이 과정에서 서버는 클라이언트에게 HTML 형식의 응답을 보내고, 클라이언트는 이를 웹 브라우저에서 해석하여 표시합니다.

        out.println("<html>");
        out.println("<style>");
        out.println("body { background-color: aliceblue; }");
        // 웹 페이지의 배경색을 설정합니다.
        // 'aliceblue'는 밝은 파란색 계열의 색상입니다.
        out.println("div.button-container { text-align: center; margin-top: 20px; }");
        // button-container라는 클래스를 가진 div 요소에 텍스트를 중앙 정렬하고, 상단에 약간의 여백을 추가합니다.
        // div 요소는 HTML에서 구역을 나타내는 블록 레벨 요소로, 이 안에 포함된 내용들을 중앙에 정렬하고, 상단에 20px의 여백을 추가했습니다.
        // 이 스타일 설정은 버튼들이 페이지의 가운데에 배치되도록 도와줍니다.
        out.println("table { margin: 10px auto; border-collapse: collapse; }");
        // 테이블을 수평으로 가운데 정렬하고, 테이블 간격을 없앱니다.
        // margin: 10px auto는 테이블 상하에 10px의 여백을 주고, 좌우로는 자동으로 여백을 설정하여 테이블을 가운데로 정렬합니다.
        // border-collapse: collapse는 테이블의 셀 경계선을 하나로 합쳐 깔끔하게 보이게 합니다.
        out.println("#CurrentPaging { color: red; text-decoration: underline; }");
        out.println("#paging { color: black; text-decoration: none; }");
        out.println("</style>");
        out.println("<body>");

        if(list != null) {
        	// 방명록 데이터가 존재하는지 확인합니다.
            // null이 아니라면, 가져온 방명록 데이터를 순회하며 HTML로 출력합니다.
            // 방명록 데이터 리스트가 null이 아니라면(즉, 방명록에 작성된 글이 하나 이상 있다면), 이를 HTML로 출력합니다.
            // 이 조건문은 데이터가 없을 때의 처리를 위한 것입니다.
        	
            out.println("<div class='button-container'>");
            // 버튼들을 감싸는 div를 생성하여 이 div의 버튼들이 중앙에 정렬되도록 합니다.
            // button-container라는 클래스가 적용된 이 div 안에 페이지 버튼들이 위치하게 됩니다.

            out.println("<input type='button' value='글쓰기' onclick=\"location.href='" + request.getContextPath() + "/guestbook/guestbookWrite.html'\" />");
            // '글쓰기' 버튼을 생성하여 클릭하면 guestbookWrite.html 페이지로 이동합니다.
            // request.getContextPath()는 애플리케이션의 루트 경로를 반환하며, 이를 통해 HTML 파일의 경로를 설정합니다.
            // 이 방식은 서버 환경에 따라 경로가 다를 경우에도 올바르게 파일을 찾을 수 있게 해줍니다.
            	            	
            for (int i = 1; i <= totalP; i++) {
                if (i == pg) {
                    // 현재 페이지인 경우
                    out.println("<input type='button' id='CurrentPaging' value='" + i + "' onclick=\"location.href='/guestbookServlet/list?pg=" + i + "'\" />");
                    // 이 버튼은 현재 페이지를 나타내며, 색상이 빨간색이고 밑줄이 추가됩니다.
                } else {
                    // 다른 페이지인 경우
                    out.println("<input type='button' id='paging' value='" + i + "' onclick=\"location.href='/guestbookServlet/list?pg=" + i + "'\" />");
                    // 이 버튼은 다른 페이지를 나타내며, 색상이 검은색이고 밑줄이 없습니다.
                } // if
            } // for

            out.println("</div>");
            // 버튼을 감싸는 div의 닫는 태그를 추가합니다.
            // 이로써 모든 페이지 버튼이 중앙에 정렬된 상태로 출력됩니다.

            out.println("<hr/>");
            // 수평선을 삽입하여 페이지의 내용과 구분을 줍니다.
            // <hr/> 태그는 HTML에서 구분선을 그릴 때 사용됩니다.
            // 이 수평선은 페이지의 섹션을 시각적으로 구분하는 데 유용합니다.
        	
        	for(GuestbookDTO guestbookDTO : list) {
        		// 방명록 목록을 순회하며 각 항목을 HTML로 출력합니다.
                // for-each 문을 사용하여 list에 포함된 각 GuestbookDTO 객체를 하나씩 순회합니다.
        		out.println("<table border='1'>");
        		// 각 방명록 항목을 테이블로 출력하기 위해 <table> 태그를 사용합니다.
                // border='1' 속성은 테이블의 셀 경계선을 그리도록 설정합니다.
                // 테이블은 각 방명록 항목을 구조화된 형태로 표시하는 데 유용합니다.

        		out.println("<tr>");
        		out.println("<th width='100'>작성자</th>");
        		out.println("<td width='150' align='center'>" + guestbookDTO.getName() + "</td>");
        		// 작성자의 이름을 테이블 셀에 출력합니다.
                // <tr> 태그는 테이블의 한 행을 나타내며, <th> 태그는 테이블 헤더 셀을 나타냅니다.
                // guestbookDTO.getName()은 현재 방명록 항목의 작성자 이름을 반환하며, 이 값을 테이블 데이터 셀(<td>)에 출력합니다.
                // align='center' 속성은 셀 안의 내용을 가운데 정렬합니다.
        		out.println("<th width='100'>작성일</th>");
        		out.println("<td width='150' align='center'>" + guestbookDTO.getLogtime() + "</td>");
        		// 작성일을 테이블 셀에 출력합니다.
                // guestbookDTO.getLogtime()은 현재 방명록 항목의 작성일을 반환하며, 이 값을 테이블 셀에 출력합니다.
                // 작성일은 사용자가 방명록 글을 작성한 날짜와 시간을 나타냅니다.
        		out.println("</tr>");
        		
        		out.println("<tr>");
        		out.println("<th>이메일</th>");
        		out.println("<td colspan='3'>" + guestbookDTO.getEmail() + "</td>");
        		// 작성자의 이메일을 테이블 셀에 출력합니다. 
        		// colspan='3'은 해당 셀이 3개의 열을 차지하게 합니다.
                // colspan 속성은 테이블 셀을 몇 개의 열에 걸쳐 합칠지를 결정합니다.
                // 여기서는 작성자의 이메일을 출력하는 셀이 3개의 열을 합쳐 차지하도록 설정했습니다.
                // 이로 인해 작성자의 이메일이 테이블의 넓은 영역에 걸쳐 표시됩니다.
        		out.println("</tr>");
        		
        		out.println("<tr>");
        		out.println("<th>홈페이지</th>");
        		out.println("<td colspan='3'>" + guestbookDTO.getHomepage() + "</td>");
        		// 작성자의 홈페이지 주소를 테이블 셀에 출력합니다.
                // guestbookDTO.getHomepage()는 현재 방명록 항목의 홈페이지 URL을 반환하며, 이 값을 테이블 셀에 출력합니다.
                // 작성자의 홈페이지 URL이 있다면, 이를 통해 작성자의 웹사이트로 쉽게 접근할 수 있습니다.
        		out.println("</tr>");
        		
        		out.println("<tr>");
        		out.println("<th>제목</th>");
        		out.println("<td colspan='3'>" + guestbookDTO.getSubject() + "</td>");
        		// 글 제목을 테이블 셀에 출력합니다.
                // guestbookDTO.getSubject()는 현재 방명록 항목의 제목을 반환하며, 이 값을 테이블 셀에 출력합니다.
                // 제목은 사용자가 방명록 글을 작성할 때 입력한 제목입니다.
        		out.println("</tr>");
        		
        		out.println("<tr>");
        		out.println("<td colspan='4' style='white-space: normal'>" + guestbookDTO.getContent() + "</td>");
        		// 글 내용을 테이블 셀에 출력합니다.
        		// white-space: normal 스타일은 긴 내용이 있을 경우 자동으로 줄바꿈을 허용합니다.
                // guestbookDTO.getContent()는 현재 방명록 항목의 내용을 반환하며, 이 값을 테이블 셀에 출력합니다.
                // style='white-space: normal' 속성은 텍스트가 셀 너비를 초과할 때 자동으로 줄바꿈되도록 설정합니다.
                // 이 설정을 통해 긴 텍스트도 가독성이 좋게 출력됩니다.
        		out.println("</tr>");
        		out.println("</table>");
        		out.println("<hr style='width: 60%; color:red; background-color:red; height:3px; border:none;'/>");
        		// 각 방명록 항목을 테이블로 구성하여 출력하고, 항목 사이에 수평선을 삽입합니다.
                // 각 방명록 항목은 하나의 테이블로 출력되며, 항목 간의 구분을 위해 수평선을 추가합니다.
                // 이 수평선은 폭이 60%로 설정되어 있으며, 빨간색으로 표시됩니다.
                // height:3px; 속성으로 수평선의 두께를 3픽셀로 설정하여 좀 더 굵게 표시되도록 합니다.
                // border:none; 속성은 기본 테두리를 없애고, 배경색을 빨간색으로 설정합니다.
        	}//for
        }//if
        
        out.println("</html>");
        out.println("</body>");
        // HTML 문서의 종료 태그를 작성하여 응답을 마무리합니다.
        // 클라이언트는 이 태그를 통해 HTML 문서가 끝났음을 인식합니다.
        // </body> 태그는 HTML 문서의 본문이 끝났음을 의미하며, </html> 태그는 전체 HTML 문서의 끝을 나타냅니다.
	}
}
