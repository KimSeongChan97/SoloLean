/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.93
 * Generated at: 2024-09-12 02:19:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.exam;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class forwardProc_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");

    request.setAttribute("apple", "사과");
    // request scope에 "apple"이라는 속성 이름으로 "사과" 값을 저장합니다.
    // request scope는 동일한 요청 내에서 데이터를 유지하며, 다른 페이지로 forward될 때도 데이터가 유지됩니다.
    // 여기서 "사과"는 문자열로 설정되어 이후 JSP 페이지에서 접근 가능합니다.
    
    // 페이지 이동
    RequestDispatcher dispatcher = request.getRequestDispatcher("forwardResult.jsp");
    // 절대경로가 아닌 상대경로로 해야한다.
    // RequestDispatcher는 서버 내부에서 다른 페이지로 요청을 전달할 때 사용하는 객체입니다.
    // 여기서 "forwardResult.jsp"는 상대 경로로 지정되었으며, 이 경로를 통해 forward할 페이지를 지정합니다.
    // 절대경로(`/`)를 사용할 경우, 애플리케이션의 루트에서부터 경로를 계산하게 되므로, 상대경로를 사용하는 것이 일반적입니다.

    dispatcher.forward(request, response);
    // 제어권을 넘겨줘서 실행하게 한다.
    // forward 메소드는 서버 내부에서 다른 페이지로 요청을 넘기며, 클라이언트는 이 과정에서 페이지 전환이 일어났는지 알 수 없습니다.
    // forward는 클라이언트가 보낸 원래의 request와 response 객체를 다른 페이지로 전달하며, 그 결과를 최종적으로 클라이언트에게 전송합니다.
    // 즉, 클라이언트는 처음 요청한 페이지(`forwardProc.jsp`)로부터 전환된 것을 모른 채, 최종적으로 `forwardResult.jsp`의 결과를 받게 됩니다.

      out.write("    \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- \r\n");
      out.write("    forward를 사용하여 \"forwardResult.jsp\" 페이지로 요청을 전달합니다.\r\n");
      out.write("    forward는 서버 내부에서 처리되는 방식으로, 클라이언트는 이를 알지 못합니다.\r\n");
      out.write("    request scope에 설정된 데이터가 forward된 페이지에서도 유지됩니다.\r\n");
      out.write("    -- JSP 표준 액션 태그를 사용한 forward 방식 대신, Java 코드로 forward를 처리하는 방식으로 변경되었습니다.\r\n");
      out.write("    -- 이 방식에서는 `RequestDispatcher` 객체를 사용해 좀 더 명시적이고 유연한 방식으로 페이지를 이동시킬 수 있습니다.\r\n");
      out.write("    -- JSP 액션 태그와의 차이점은 보다 명확한 흐름 제어가 가능하다는 점입니다.\r\n");
      out.write(" -->\r\n");
      out.write("\r\n");
      out.write(" ");
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
