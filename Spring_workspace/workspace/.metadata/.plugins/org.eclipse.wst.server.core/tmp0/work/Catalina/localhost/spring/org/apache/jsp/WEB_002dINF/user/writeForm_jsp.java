/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.93
 * Generated at: 2024-10-11 00:38:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class writeForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>회원가입</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css\">\r\n");
      out.write("    <!-- user.css 파일을 불러와 회원가입 폼의 스타일을 설정합니다 -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/user.css\">\r\n");
      out.write("    <!-- Font Awesome 아이콘 라이브러리를 사용하여 아이콘을 추가합니다 -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div id=\"write-jsp\" class=\"container-fluid\">\r\n");
      out.write("        <!-- 좌측 영역: 홈 링크, 프로필 이미지, 기타 링크 -->\r\n");
      out.write("        <div id=\"left\">\r\n");
      out.write("            <div id=\"header\">\r\n");
      out.write("                <!-- HOME 링크 -->\r\n");
      out.write("                <a href=\"/spring/\">\r\n");
      out.write("                    <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/image/Logo.png\" alt=\"Logo\" width=\"50\" height=\"50\" />\r\n");
      out.write("                    HOME\r\n");
      out.write("                </a>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div id=\"profile\">\r\n");
      out.write("                <!-- 사용자가 등록할 이미지 혹은 기본 프로필 이미지 -->\r\n");
      out.write("                <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/image/mang.png\" width=\"140\" height=\"140\" alt=\"mangLogo\" />\r\n");
      out.write("            </div>\r\n");
      out.write("            <div id=\"links\">\r\n");
      out.write("                <!-- 고객센터 및 언어 설정 링크 -->\r\n");
      out.write("                <a href=\"#\">고객센터</a> | <a href=\"#\">한국어</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- 우측 영역: 회원가입 폼 -->\r\n");
      out.write("        <div id=\"right\">\r\n");
      out.write("            <div id=\"container\">\r\n");
      out.write("                <div id=\"edit-header\">회원가입</div>\r\n");
      out.write("                <!-- 회원가입 폼 -->\r\n");
      out.write("                <form name=\"userWriteForm\" id=\"userWriteForm\" class=\"needs-validation\" novalidate>\r\n");
      out.write("                    <!-- 이름 입력 필드 -->\r\n");
      out.write("                    <div class=\"mb-3\">\r\n");
      out.write("                        <label for=\"name\" class=\"form-label\">\r\n");
      out.write("                            <i class=\"fas fa-user\"></i> 이름\r\n");
      out.write("                        </label>\r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"name\" id=\"name\" placeholder=\"이름 입력\" required>\r\n");
      out.write("                        <div id=\"nameDiv\" class=\"error\">이름을 입력하세요.</div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <!-- 아이디 입력 필드 -->\r\n");
      out.write("                    <div class=\"mb-3\">\r\n");
      out.write("                        <label for=\"id\" class=\"form-label\">\r\n");
      out.write("                            <i class=\"fas fa-id-badge\"></i> 아이디\r\n");
      out.write("                        </label>\r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"id\" id=\"id\" placeholder=\"아이디 입력\" required>\r\n");
      out.write("                        <div id=\"idDiv\" class=\"error\">아이디를 입력하세요.</div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <!-- 비밀번호 입력 필드 -->\r\n");
      out.write("                    <div class=\"mb-3\">\r\n");
      out.write("                        <label for=\"pwd\" class=\"form-label\">\r\n");
      out.write("                            <i class=\"fas fa-lock\"></i> 비밀번호\r\n");
      out.write("                        </label>\r\n");
      out.write("                        <input type=\"password\" class=\"form-control\" name=\"pwd\" id=\"pwd\" placeholder=\"비밀번호 입력\" required>\r\n");
      out.write("                        <div id=\"pwdDiv\" class=\"error\">비밀번호를 입력하세요.</div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <!-- 회원가입 및 초기화 버튼 -->\r\n");
      out.write("                    <div class=\"d-grid gap-2\">\r\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-primary\" id=\"writeBtn\">회원가입</button>\r\n");
      out.write("                        <button type=\"reset\" class=\"btn btn-secondary\">초기화</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- jQuery 및 Bootstrap JS -->\r\n");
      out.write("    <script src=\"http://code.jquery.com/jquery-3.7.1.min.js\"></script>\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/js/write.js\"></script>\r\n");
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