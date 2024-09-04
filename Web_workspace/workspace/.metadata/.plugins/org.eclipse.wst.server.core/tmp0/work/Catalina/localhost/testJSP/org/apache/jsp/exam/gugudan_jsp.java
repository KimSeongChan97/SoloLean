/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.93
 * Generated at: 2024-09-04 03:16:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.exam;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class gugudan_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>JSP를 활용한 구구단 만들기</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("td {\r\n");
      out.write("    padding: 5px; /* 테이블 셀 내부의 패딩을 지정하여, 셀 안의 내용이 여유 공간을 가질 수 있도록 합니다. */\r\n");
      out.write("    width: 120px; /* 각 테이블 셀의 너비를 120px로 고정하여, 모든 셀이 동일한 너비를 가지도록 합니다. */\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <h1 align=\"center\">JSP를 활용한 구구단 만들기</h1>\r\n");
      out.write("    <hr/>\r\n");
      out.write("    \r\n");
      out.write("    <table>\r\n");
 
    // i는 1부터 9까지 반복하며, 구구단의 곱해지는 수를 나타냅니다.
    // 이 외부 루프는 구구단에서 각 곱해지는 수에 대해 하나의 행을 생성합니다.
    for(int i=1; i<=9; i++) { 

      out.write("\r\n");
      out.write("    <tr>\r\n");
      out.write("    ");
 
        // j는 2부터 9까지 반복하며, 구구단의 각 단(2단부터 9단까지)을 나타냅니다.
        // 내부 루프를 통해 각 단에 대해 하나의 열(td)를 생성하여 해당 단의 결과를 출력합니다.
        for(int j=2; j<=9; j++) { 
    
      out.write("\r\n");
      out.write("    \r\n");
      out.write("        <!-- j와 i를 곱한 결과를 출력 -->\r\n");
      out.write("        <!-- j(단)와 i(곱해지는 수)를 곱한 결과를 테이블 셀(td)에 출력합니다. -->\r\n");
      out.write("        <td>");
      out.print( j );
      out.write(' ');
      out.write('*');
      out.write(' ');
      out.print( i );
      out.write(' ');
      out.write('=');
      out.write(' ');
      out.print( j * i );
      out.write("</td>\r\n");
      out.write("        <!-- 여기서 ");
      out.print( );
      out.write(" 표현식은 j와 i의 값을 각각 HTML에 출력하며, 두 값을 곱한 결과(j * i)도 출력합니다. -->\r\n");
      out.write("\r\n");
      out.write("    ");
 } // for j 
      out.write("\r\n");
      out.write("    <!-- 내부 루프가 종료되면 하나의 행이 완성됩니다. -->\r\n");
      out.write("    </tr>\r\n");
 } // for i 
      out.write("\r\n");
      out.write("<!-- 외부 루프가 종료되면 모든 구구단 결과가 테이블에 출력됩니다. -->\r\n");
      out.write("        \r\n");
      out.write("</table>\r\n");
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
