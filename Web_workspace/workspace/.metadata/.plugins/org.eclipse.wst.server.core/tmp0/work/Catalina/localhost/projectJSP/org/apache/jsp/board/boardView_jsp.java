/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.93
 * Generated at: 2024-09-11 08:53:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import board.dao.BoardDAO;
import board.dao.CommentDAO;
import board.bean.BoardDTO;
import java.util.List;

public final class boardView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(6);
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("board.dao.BoardDAO");
    _jspx_imports_classes.add("board.bean.BoardDTO");
    _jspx_imports_classes.add("board.dao.CommentDAO");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>게시글 보기</title>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"/projectJSP/css/boardView.css\">\r\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("    <!-- 페이지 상단에 네비게이션 바를 포함합니다. nav.jsp 파일의 내용을 불러옵니다. -->\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/nav.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- 게시글 제목을 출력하는 부분입니다. 클릭 시 메인 페이지로 이동합니다. -->\r\n");
      out.write("    <h2 align=\"center\" style=\"font-family: 'Comic Sans MS';\" onclick=\"location.href='../index.jsp'\"> N o t e _ V i e w </h2>\r\n");
      out.write("\r\n");
      out.write("    ");

        // 게시글 번호를 요청 파라미터에서 받아옵니다.
        int seq = Integer.parseInt(request.getParameter("seq")); // 게시글의 고유 번호를 받아서 처리합니다.

        // BoardDAO와 CommentDAO 객체를 인스턴스화합니다. 각각 게시글과 댓글 데이터를 처리합니다.
        BoardDAO boardDAO = BoardDAO.getInstance(); // 싱글톤 패턴으로 설계된 BoardDAO 인스턴스를 가져옵니다.
        CommentDAO commentDAO = CommentDAO.getInstance(); // 싱글톤 패턴으로 설계된 CommentDAO 인스턴스를 가져옵니다.

        // 조회수 증가 및 게시글 조회
        boardDAO.increaseHit(seq); // 해당 게시글의 조회수를 1 증가시킵니다.
        BoardDTO board = boardDAO.getBoard(seq); // 해당 게시글의 정보를 데이터베이스에서 조회해 BoardDTO 객체에 저장합니다.

        // 댓글 목록 조회
        List<String[]> comments = commentDAO.getCommentsByBoardSeq(seq); // 특정 게시글 번호에 해당하는 댓글 목록을 가져옵니다.
    
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <!-- 왼쪽 섹션: 게시글 정보 및 댓글을 보여주는 영역입니다. -->\r\n");
      out.write("        <div class=\"left-section\">\r\n");
      out.write("            <!-- 게시글의 제목을 출력합니다. -->\r\n");
      out.write("            <label for=\"subject\">제목:</label>\r\n");
      out.write("            <div id=\"subject\">");
      out.print( board.getSubject() );
      out.write("</div><br> <!-- BoardDTO 객체에서 제목(subject)을 가져와 출력합니다. -->\r\n");
      out.write("\r\n");
      out.write("            <!-- 게시글의 내용을 출력합니다. -->\r\n");
      out.write("            <label for=\"content\">내용:</label>\r\n");
      out.write("            <div id=\"content\">");
      out.print( board.getContent() );
      out.write("</div><br> <!-- BoardDTO 객체에서 내용(content)을 가져와 출력합니다. -->\r\n");
      out.write("\r\n");
      out.write("            <!-- 댓글 목록 출력 -->\r\n");
      out.write("            <label for=\"comment\">댓글:</label>\r\n");
      out.write("            <div id=\"comment\" class=\"comment-section\">\r\n");
      out.write("                <!-- 댓글 리스트를 출력합니다. -->\r\n");
      out.write("                <ul class=\"comment-list\">\r\n");
      out.write("                    ");

                        // 댓글 리스트를 순회하면서 각 댓글의 작성자 이름과 내용을 출력합니다.
                        for (String[] comment : comments) {
                    
      out.write("\r\n");
      out.write("                        <li><strong>");
      out.print( comment[0] );
      out.write("</strong>: ");
      out.print( comment[1] );
      out.write("</li> <!-- comment[0]: 작성자 이름, comment[1]: 댓글 내용 -->\r\n");
      out.write("                    ");

                        }
                    
      out.write("\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("			\r\n");
      out.write("			<!-- 세션에 저장된 회원 이름 확인 -->\r\n");
      out.write("			");

			    // 로그인한 사용자의 이름을 세션에서 가져옵니다.
			    String sessionName = (String) session.getAttribute("memName"); // 세션에 저장된 로그인된 사용자 이름을 가져옵니다.
			    if (sessionName != null) { // 만약 세션에 사용자 이름이 존재하면 출력합니다.
			
      out.write("	\r\n");
      out.write("			    <p>로그인된 사용자: ");
      out.print( sessionName );
      out.write("</p> <!-- 세션에서 가져온 사용자의 이름을 출력합니다. -->\r\n");
      out.write("			");

			    } else { // 세션에 사용자 이름이 없으면 아래 메시지를 출력합니다.
			
      out.write("\r\n");
      out.write("			    <p>로그인된 사용자 정보가 없습니다.</p> <!-- 로그인되지 않은 사용자에게 보여줄 메시지입니다. -->\r\n");
      out.write("			");

			    }
			
      out.write("\r\n");
      out.write("						\r\n");
      out.write("            <!-- 댓글 작성 버튼을 로그인된 사용자에게만 표시 -->\r\n");
      out.write("            ");

                // 로그인된 사용자에게만 댓글 작성 버튼을 보여줍니다.
                if (session.getAttribute("memName") != null) { // 세션에 저장된 사용자 이름이 있으면 댓글 작성 버튼을 활성화합니다.
            
      out.write("\r\n");
      out.write("                <button type=\"button\" class=\"btn btn-primary\" data-bs-toggle=\"modal\" data-bs-target=\"#commentModal\">\r\n");
      out.write("                    댓글 작성 <!-- 댓글 작성 버튼을 출력하며, 클릭 시 모달이 열립니다. -->\r\n");
      out.write("                </button>\r\n");
      out.write("            ");

                } else { // 로그인이 되어 있지 않은 사용자는 댓글 작성 버튼을 누를 수 없고, 대신 로그인 안내 메시지를 표시합니다.
            
      out.write("\r\n");
      out.write("                <p style=\"color: red;\">로그인 후 댓글을 작성할 수 있습니다.</p> <!-- 로그인되지 않은 경우 댓글 작성 불가 메시지를 표시합니다. -->\r\n");
      out.write("            ");

                }
            
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- 오른쪽 섹션: 게시글 작성자 정보 및 기타 정보를 보여주는 영역입니다. -->\r\n");
      out.write("        <div class=\"right-section\">\r\n");
      out.write("            <!-- 작성자의 이름을 출력합니다. -->\r\n");
      out.write("            <label for=\"name\">작성자:</label>\r\n");
      out.write("            <div id=\"name\">");
      out.print( board.getName() );
      out.write("</div><br> <!-- BoardDTO 객체에서 작성자의 이름(name)을 가져와 출력합니다. -->\r\n");
      out.write("\r\n");
      out.write("            <!-- 작성자의 이메일을 출력합니다. -->\r\n");
      out.write("            <label for=\"email\">작성자 email:</label>\r\n");
      out.write("            <div id=\"email\">");
      out.print( board.getEmail() );
      out.write("</div><br> <!-- BoardDTO 객체에서 이메일(email)을 가져와 출력합니다. -->\r\n");
      out.write("\r\n");
      out.write("            <!-- 작성일을 포맷팅하여 출력합니다. -->\r\n");
      out.write("            ");

                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");
                String formattedLogtime = sdf.format(board.getLogtime()); // Date를 String으로 변환
            
      out.write("\r\n");
      out.write("            <label for=\"logtime\">작성일:</label>\r\n");
      out.write("            <div id=\"logtime\">");
      out.print( formattedLogtime );
      out.write("</div><br> <!-- 변환된 날짜 문자열을 출력 -->\r\n");
      out.write("\r\n");
      out.write("            <!-- 게시글 조회수를 출력합니다. -->\r\n");
      out.write("            <label for=\"hit\">조회수:</label>\r\n");
      out.write("            <div id=\"hit\">");
      out.print( board.getHit() );
      out.write("</div><br> <!-- BoardDTO 객체에서 조회수(hit)를 가져와 출력합니다. -->\r\n");
      out.write("\r\n");
      out.write("            <!-- 목록으로 돌아가는 버튼 -->\r\n");
      out.write("            <input type=\"button\" value=\"목록으로\" onclick=\"location.href='boardList.jsp'\"> <!-- 게시글 목록 페이지로 돌아가는 버튼입니다. -->\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>  \r\n");
      out.write("\r\n");
      out.write("    <!-- 댓글 작성 모달: 로그인된 사용자가 댓글을 작성할 수 있도록 폼을 제공합니다. -->\r\n");
      out.write("    <div class=\"modal fade\" id=\"commentModal\" tabindex=\"-1\" aria-labelledby=\"commentModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("      <div class=\"modal-dialog\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("          <div class=\"modal-header\">\r\n");
      out.write("            <h5 class=\"modal-title\" id=\"commentModalLabel\">댓글 작성</h5> <!-- 모달의 제목을 표시합니다. -->\r\n");
      out.write("            <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button> <!-- 모달을 닫는 버튼입니다. -->\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"modal-body\">\r\n");
      out.write("            <!-- 댓글 작성 폼 -->\r\n");
      out.write("            <form id=\"commentForm\" action=\"addComment.jsp\" method=\"post\">\r\n");
      out.write("              <!-- 댓글 내용을 입력하는 텍스트 영역 -->\r\n");
      out.write("              <div class=\"mb-3\">\r\n");
      out.write("                <label for=\"commentContent\" class=\"form-label\">댓글 내용</label>\r\n");
      out.write("                <textarea class=\"form-control\" id=\"commentContent\" name=\"commentContent\" rows=\"3\"></textarea> <!-- 댓글 내용을 입력받는 텍스트 박스입니다. -->\r\n");
      out.write("              </div>\r\n");
      out.write("              <!-- 게시글 번호를 숨겨서 폼에 포함시킵니다. -->\r\n");
      out.write("              <input type=\"hidden\" name=\"boardSeq\" value=\"");
      out.print( seq );
      out.write("\"> <!-- 게시글 번호를 댓글과 함께 전송하기 위한 숨겨진 필드입니다. -->\r\n");
      out.write("            </form>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"modal-footer\">\r\n");
      out.write("            <button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">닫기</button> <!-- 모달을 닫는 버튼입니다. -->\r\n");
      out.write("            <button type=\"submit\" form=\"commentForm\" class=\"btn btn-primary\">댓글 저장</button> <!-- 폼을 제출하는 버튼으로, 댓글을 저장하는 역할을 합니다. -->\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- jQuery 라이브러리를 포함합니다. -->\r\n");
      out.write("    <script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-3.7.1.min.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
