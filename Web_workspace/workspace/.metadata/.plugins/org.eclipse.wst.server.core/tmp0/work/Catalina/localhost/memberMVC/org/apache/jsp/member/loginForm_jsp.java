/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.93
 * Generated at: 2024-09-13 06:49:46 UTC
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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("body {\r\n");
      out.write("	background-color: #0d0d0d;\r\n");
      out.write("	color: #00ffcc;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("table {\r\n");
      out.write("	border-collapse: collapse;\r\n");
      out.write("}\r\n");
      out.write("th, td {\r\n");
      out.write("	padding: 5px;\r\n");
      out.write("}\r\n");
      out.write("div {\r\n");
      out.write("	color: red;\r\n");
      out.write("	font-size: 8pt;\r\n");
      out.write("	font-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h1>\r\n");
      out.write("	<img src=\"../image/4.jpg\" width=\"100\" height=\"100\" alt=\"홈\" \r\n");
      out.write("		 onclick=\"location.href='/memberMVC/index.do'\" style=\"cursor: pointer;\">\r\n");
      out.write("		  로그인\r\n");
      out.write("</h1>\r\n");
      out.write("<form id=\"loginForm\">\r\n");
      out.write("	<table border=\"1\">\r\n");
      out.write("		<tr>\r\n");
      out.write("	        <th>아이디</th>\r\n");
      out.write("	        <td>\r\n");
      out.write("	        	<input type=\"text\" name=\"id\" id=\"id\" size=\"30\" placeholder=\"아이디 입력\">\r\n");
      out.write("	        	<div id=\"idDiv\"></div>\r\n");
      out.write("	        </td>\r\n");
      out.write("	    </tr>\r\n");
      out.write("	    \r\n");
      out.write("	    <tr>\r\n");
      out.write("	        <th>비밀번호</th>\r\n");
      out.write("	        <td>\r\n");
      out.write("	        	<input type=\"password\" name=\"pwd\" id=\"pwd\" size=\"40\" placeholder=\"비밀번호 입력\">\r\n");
      out.write("	        	<div id=\"pwdDiv\"></div>\r\n");
      out.write("	        </td>\r\n");
      out.write("	    </tr>\r\n");
      out.write("	    \r\n");
      out.write("	    <tr>\r\n");
      out.write("	    	<td colspan=\"2\" align=\"center\">\r\n");
      out.write("	    		<input type=\"button\" value=\"로그인\" id=\"loginBtn\"/>\r\n");
      out.write("	    		<input type=\"button\" value=\"회원가입\" onclick=\"location.href='/memberMVC/member/writeForm.do'\" />      \r\n");
      out.write("	    	</td>\r\n");
      out.write("	    </tr>\r\n");
      out.write("	</table>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-3.7.1.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
      out.write("	$('#loginBtn').click(function(){\r\n");
      out.write("		$('#idDiv').empty();\r\n");
      out.write("		$('#pwdDiv').empty();\r\n");
      out.write("		\r\n");
      out.write("		if($('#id').val() == '')\r\n");
      out.write("			$('#idDiv').html('아이디 입력');\r\n");
      out.write("		else if($('#pwd').val() == '')\r\n");
      out.write("			$('#pwdDiv').html('비밀번호 입력');\r\n");
      out.write("		else\r\n");
      out.write("			$.ajax({\r\n");
      out.write("				type: 'post',\r\n");
      out.write("				url: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/member/login.do',\r\n");
      out.write("				\r\n");
      out.write("				//data: 'id=' + $('#id').val() + '&pwd=' + $('#pwd').val(),\r\n");
      out.write("				data: {\r\n");
      out.write("					'id': $('#id').val(),\r\n");
      out.write("					'pwd': $('#pwd').val()\r\n");
      out.write("				},\r\n");
      out.write("			\r\n");
      out.write("				dataType: 'text', //서버로부터 받는 타입, 'text' or 'xml' or 'json'\r\n");
      out.write("				success: function(data){\r\n");
      out.write("					//alert(data.trim());\r\n");
      out.write("					\r\n");
      out.write("					if(data.trim() == 'fail')\r\n");
      out.write("						alert(\"아이디 또는 비밀번호가 틀렸습니다.\")\r\n");
      out.write("					else {\r\n");
      out.write("						alert(data.trim()+\"님 로그인\");						\r\n");
      out.write("						location.href = '/memberMVC/index.do';\r\n");
      out.write("					}\r\n");
      out.write("				},\r\n");
      out.write("				error: function(e){\r\n");
      out.write("					console.log(e);\r\n");
      out.write("				}\r\n");
      out.write("			});\r\n");
      out.write("	});\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
