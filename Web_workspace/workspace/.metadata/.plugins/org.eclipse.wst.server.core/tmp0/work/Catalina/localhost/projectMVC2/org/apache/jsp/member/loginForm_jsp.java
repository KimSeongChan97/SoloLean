/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.93
 * Generated at: 2024-09-13 08:28:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class loginForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("<style type=\"text/css\">\n");
      out.write("body {\n");
      out.write("	background-color: #0d0d0d;\n");
      out.write("	color: #00ffcc;\n");
      out.write("}\n");
      out.write("\n");
      out.write("table {\n");
      out.write("	border-collapse: collapse;\n");
      out.write("}\n");
      out.write("th, td {\n");
      out.write("	padding: 5px;\n");
      out.write("}\n");
      out.write("div {\n");
      out.write("	color: red;\n");
      out.write("	font-size: 8pt;\n");
      out.write("	font-weight: bold;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/logincss.css\">\n");
      out.write("\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/nav.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("<h1>\n");
      out.write("	<img src=\"../image/4.jpg\" width=\"100\" height=\"100\" alt=\"홈\" \n");
      out.write("		 onclick=\"location.href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/index.jsp'\" style=\"cursor: pointer;\">\n");
      out.write("		  로그인\n");
      out.write("</h1>\n");
      out.write("<form id=\"loginForm\">\n");
      out.write("	<table border=\"1\">\n");
      out.write("		<tr>\n");
      out.write("	        <th>아이디</th>\n");
      out.write("	        <td>\n");
      out.write("	        	<input type=\"text\" name=\"id\" id=\"id\" size=\"30\" placeholder=\"아이디 입력\">\n");
      out.write("	        	<div id=\"idDiv\"></div>\n");
      out.write("	        </td>\n");
      out.write("	    </tr>\n");
      out.write("	    \n");
      out.write("	    <tr>\n");
      out.write("	        <th>비밀번호</th>\n");
      out.write("	        <td>\n");
      out.write("	        	<input type=\"password\" name=\"pwd\" id=\"pwd\" size=\"40\" placeholder=\"비밀번호 입력\">\n");
      out.write("	        	<div id=\"pwdDiv\"></div>\n");
      out.write("	        </td>\n");
      out.write("	    </tr>\n");
      out.write("	    \n");
      out.write("	    <tr>\n");
      out.write("	    	<td colspan=\"2\" align=\"center\">\n");
      out.write("	    		<input type=\"button\" value=\"로그인\" id=\"loginBtn\"/>\n");
      out.write("	    		<input type=\"button\" value=\"회원가입\" onclick=\"location.href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/member/writeForm.do'\" />      \n");
      out.write("	    	</td>\n");
      out.write("	    </tr>\n");
      out.write("	</table>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-3.7.1.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("$(function(){\n");
      out.write("	$('#loginBtn').click(function(){\n");
      out.write("		$('#idDiv').empty();\n");
      out.write("		$('#pwdDiv').empty();\n");
      out.write("		\n");
      out.write("		if($('#id').val() == '')\n");
      out.write("			$('#idDiv').html('아이디 입력');\n");
      out.write("		else if($('#pwd').val() == '')\n");
      out.write("			$('#pwdDiv').html('비밀번호 입력');\n");
      out.write("		else\n");
      out.write("			$.ajax({\n");
      out.write("				type: 'post',\n");
      out.write("				url: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/member/login.jsp',\n");
      out.write("				\n");
      out.write("				//data: 'id=' + $('#id').val() + '&pwd=' + $('#pwd').val(),\n");
      out.write("				data: {\n");
      out.write("					'id': $('#id').val(),\n");
      out.write("					'pwd': $('#pwd').val()\n");
      out.write("				},\n");
      out.write("			\n");
      out.write("				dataType: 'text', //서버로부터 받는 타입, 'text' or 'xml' or 'json'\n");
      out.write("				success: function(data){\n");
      out.write("					//alert(data.trim());\n");
      out.write("					\n");
      out.write("					if(data.trim() == 'fail')\n");
      out.write("						alert(\"아이디 또는 비밀번호가 틀렸습니다.\")\n");
      out.write("					else {\n");
      out.write("						alert(data.trim()+\"님 로그인\");						\n");
      out.write("						location.href = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/index.jsp';\n");
      out.write("					}\n");
      out.write("				},\n");
      out.write("				error: function(e){\n");
      out.write("					console.log(e);\n");
      out.write("				}\n");
      out.write("			});\n");
      out.write("	});\n");
      out.write("});\n");
      out.write("</script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
