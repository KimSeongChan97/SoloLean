/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.93
 * Generated at: 2024-08-30 07:52:54 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.JSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.io.*;
import java.util.*;

public final class view_005fpost_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(8);
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("java.io");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>게시글 보기</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../css/style.css\">\r\n");
      out.write("    <!-- Bootstrap CSS -->\r\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <!-- 네비게이션 바를 인라인으로 작성 -->\r\n");
      out.write("    <nav class=\"navbar navbar-expand-lg bg-body-tertiary\">\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("            <a class=\"navbar-brand\" href=\"../index.html\">\r\n");
      out.write("                <img src=\"../images/home.png\" alt=\"Home\" style=\"width:30px; height:30px;\">\r\n");
      out.write("            </a>\r\n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("            </button>\r\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\r\n");
      out.write("                <ul class=\"navbar-nav ms-auto\">\r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link active\" aria-current=\"page\" href=\"../index.html\">Home</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"../board.html\">게시판</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"../register.html\">회원가입</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a id=\"loginLink\" class=\"nav-link\" href=\"../login.html\">Login</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("\r\n");
      out.write("    <main>\r\n");
      out.write("        <section class=\"container mt-5\">\r\n");
      out.write("        ");

            String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
            String dbUser = "hr";
            String dbPass = "hr";

            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;

            String postId = request.getParameter("seq");  // 게시글 ID
            String memberId = (String)session.getAttribute("memberId"); // 세션에서 로그인한 사용자 ID 가져오기

            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

                // 게시글 내용 가져오기
                String postSQL = "SELECT B.SEQ, B.SUBJECT, B.CONTENT, M.NAME AS WRITER, B.LOGTIME, B.VIEWS FROM BOARD B JOIN MEMBER M ON B.MEMBER_ID = M.MEMBER_ID WHERE B.SEQ = ?";
                pstmt = conn.prepareStatement(postSQL);
                pstmt.setString(1, postId);
                rs = pstmt.executeQuery();

                // 조회수 증가시키기
                String updateViewsSQL = "UPDATE BOARD SET VIEWS = VIEWS + 1 WHERE SEQ = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updateViewsSQL);
                updateStmt.setString(1, postId);
                updateStmt.executeUpdate();

                if(rs.next()) {
                    String subject = rs.getString("SUBJECT");
                    String content = rs.getString("CONTENT");
                    String writer = rs.getString("WRITER");
                    String logtime = rs.getString("LOGTIME");
                    int views = rs.getInt("VIEWS");

                    out.println("<h2>" + subject + "</h2>");
                    out.println("<p><strong>작성자:</strong> " + writer + "</p>");
                    out.println("<p><strong>작성일:</strong> " + logtime + "</p>");
                    out.println("<p><strong>조회수:</strong> " + views + "</p>");
                    out.println("<hr>");
                    out.println("<p>" + content + "</p>");
                }

                // 댓글 목록 가져오기
                String commentSQL = "SELECT C.COMMENT_ID, C.CONTENT, M.NAME AS WRITER, C.LOGTIME FROM COMMENTS C JOIN MEMBER M ON C.MEMBER_ID = M.MEMBER_ID WHERE C.POST_ID = ? ORDER BY C.COMMENT_ID ASC";
                pstmt = conn.prepareStatement(commentSQL);
                pstmt.setString(1, postId);
                rs = pstmt.executeQuery();

                out.println("<hr><h3>댓글</h3>");
                while(rs.next()) {
                    String commentContent = rs.getString("CONTENT");
                    String commentWriter = rs.getString("WRITER");
                    String commentLogtime = rs.getString("LOGTIME");

                    out.println("<div><strong>" + commentWriter + ":</strong> " + commentContent + " <em>(" + commentLogtime + ")</em></div>");
                }

                // 댓글 작성 폼
                if(memberId != null) {
                    out.println("<hr><h4>댓글 작성</h4>");
                    out.println("<form action='add_comment.jsp' method='post'>");
                    out.println("<input type='hidden' name='postId' value='" + postId + "'>");
                    out.println("<textarea name='content' class='form-control' rows='4' required></textarea><br>");
                    out.println("<div class='text-end'><button type='submit' class='btn btn-primary'>댓글 달기</button></div>");
                    out.println("</form>");
                } else {
                    out.println("<p><a href='../login.html'>로그인</a> 후 댓글을 작성할 수 있습니다.</p>");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try { if (rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
                try { if (pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
                try { if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
            }
        
      out.write("\r\n");
      out.write("        </section>\r\n");
      out.write("    </main>\r\n");
      out.write("\r\n");
      out.write("    <!-- 네비게이션 바 스크립트 -->\r\n");
      out.write("    <script>\r\n");
      out.write("        document.addEventListener(\"DOMContentLoaded\", function() {\r\n");
      out.write("            const userEmail = sessionStorage.getItem(\"userEmail\");\r\n");
      out.write("            if (userEmail) {\r\n");
      out.write("                const loginButton = document.getElementById(\"loginLink\");\r\n");
      out.write("                loginButton.textContent = \"MyPage\";\r\n");
      out.write("                loginButton.href = \"MyPage.html\";\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap JS -->\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
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
