/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.93
 * Generated at: 2024-09-06 08:28:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class boardWriteForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>글쓰기 폼</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/projectJSP/css/boardWrite.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/nav.jsp", out, false);
      out.write(" \r\n");
      out.write("\r\n");
      out.write("<h2 align=\"center\" style=\"font-family: 'Comic Sans MS';\" style=\"cursor: pointer;\" \r\n");
      out.write("	 onclick=\"location.href='../index.jsp'\" > P o s t </h2>\r\n");
      out.write("	 \r\n");
      out.write("<form action=\"boardWrite.jsp\" method=\"post\" onsubmit=\"return validateForm();\">\r\n");
      out.write("\r\n");
      out.write("    <label for=\"subject\">제목:</label>\r\n");
      out.write("    <input type=\"text\" id=\"subject\" name=\"subject\">\r\n");
      out.write("    <br><br>\r\n");
      out.write("    <div id=\"subjectDiv\"></div> <!-- 유효성 검사 결과가 출력될 div -->\r\n");
      out.write("	\r\n");
      out.write("    <label for=\"content\">내용:</label>\r\n");
      out.write("    <textarea id=\"content\" name=\"content\" rows=\"10\" cols=\"40\"></textarea>\r\n");
      out.write("    <br><br>\r\n");
      out.write("    <div id=\"contentDiv\"></div> <!-- 유효성 검사 결과가 출력될 div -->\r\n");
      out.write("	\r\n");
      out.write("    <input type=\"submit\" value=\"글쓰기\">\r\n");
      out.write("    <input type=\"reset\" value=\"다시작성\">\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-3.7.1.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    // 유효성 검사 함수\r\n");
      out.write("    function validateForm() {\r\n");
      out.write("        // 각 입력 필드의 값 가져오기\r\n");
      out.write("        var subject = document.getElementById(\"subject\").value;\r\n");
      out.write("        var content = document.getElementById(\"content\").value;\r\n");
      out.write("\r\n");
      out.write("        // 메시지를 출력할 div 요소 가져오기\r\n");
      out.write("        var subjectDiv = document.getElementById(\"subjectDiv\");\r\n");
      out.write("        var contentDiv = document.getElementById(\"contentDiv\");\r\n");
      out.write("\r\n");
      out.write("        // 기존 메시지 초기화\r\n");
      out.write("        subjectDiv.innerHTML = \"\";\r\n");
      out.write("        contentDiv.innerHTML = \"\";\r\n");
      out.write("\r\n");
      out.write("        // 제목이 없을 경우 메시지 출력\r\n");
      out.write("        if (subject == null || subject.trim() == \"\") {\r\n");
      out.write("            subjectDiv.innerHTML = \"제목을 입력하세요.\";\r\n");
      out.write("            return false;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        // 내용이 없을 경우 메시지 출력\r\n");
      out.write("        if (content == null || content.trim() == \"\") {\r\n");
      out.write("            contentDiv.innerHTML = \"내용을 입력하세요.\";\r\n");
      out.write("            return false;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        return true; // 유효성 검사를 통과한 경우 폼 제출\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
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