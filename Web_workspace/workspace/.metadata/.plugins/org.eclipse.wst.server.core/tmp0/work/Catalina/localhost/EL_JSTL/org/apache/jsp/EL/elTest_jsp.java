/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.93
 * Generated at: 2024-09-11 03:39:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.EL;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class elTest_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>EL 테스트 페이지1</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	\r\n");
      out.write("	<!-- \r\n");
      out.write("		표 형식으로 EL(Expression Language)의 다양한 표현식과 그 결과를 출력하는 페이지.\r\n");
      out.write("		EL은 JSP에서 자바 코드 없이 표현식으로 간단히 데이터를 처리하는 방식.\r\n");
      out.write("		이 표는 EL 표현식과 그 결과 값을 비교해서 보여주기 위한 예시임.\r\n");
      out.write("	-->\r\n");
      out.write("	<table border=\"1\" width=\"50%\" >\r\n");
      out.write("		<tr>\r\n");
      out.write("			<th width=\"50%\">표현식</th> <!-- EL 표현식 자체를 보여주는 열 -->\r\n");
      out.write("			<th>값</th> <!-- EL 표현식의 결과값을 보여주는 열 -->\r\n");
      out.write("		</tr>\r\n");
      out.write("		\r\n");
      out.write("		<!-- 아래부터 EL을 사용하여 연산 및 비교의 결과를 출력하는 부분 -->\r\n");
      out.write("		<tr align=\"center\">\r\n");
      out.write("			<td>${ 25+3 }</td> <!-- 덧셈 연산: 25 + 3 = 28 -->\r\n");
      out.write("			<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ 25+3 }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td> <!-- EL을 사용하여 25+3의 값을 실제로 출력. 결과는 28 -->\r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr align=\"center\">\r\n");
      out.write("			<td>${ 25 / 3 }</td> <!-- 나눗셈 연산: 25 / 3 = 8.3333... -->\r\n");
      out.write("			<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ 25 / 3 }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td> <!-- EL을 사용하여 25 / 3의 결과를 출력. 결과는 8.3333... -->\r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr align=\"center\">\r\n");
      out.write("			<td>${ 25 div 3 }</td> <!-- \"div\"는 나눗셈을 나타내는 EL 연산자. 같은 연산: 25 / 3 -->\r\n");
      out.write("			<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ 25 div 3 }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td> <!-- \"div\"를 사용한 나눗셈 결과를 출력. 결과는 8 -->\r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr align=\"center\">\r\n");
      out.write("			<td>${ 25 % 3 }</td> <!-- 나머지 연산: 25 % 3 = 1 -->\r\n");
      out.write("			<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ 25 % 3 }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td> <!-- EL을 사용하여 25 % 3의 나머지를 출력. 결과는 1 -->\r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr align=\"center\">\r\n");
      out.write("			<td>${ 25 mod 3 }</td> <!-- \"mod\"는 나머지 연산을 나타내는 EL 연산자. 같은 연산: 25 % 3 -->\r\n");
      out.write("			<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ 25 mod 3 }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td> <!-- \"mod\"를 사용한 나머지 연산 결과를 출력. 결과는 1 -->\r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr align=\"center\">\r\n");
      out.write("			<td>${ 25 < 3 }</td> <!-- 비교 연산: 25가 3보다 작은지 비교. 결과는 false -->\r\n");
      out.write("			<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ 25 < 3 }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td> <!-- EL을 사용하여 25 < 3의 결과를 출력. 결과는 false -->\r\n");
      out.write("		</tr>\r\n");
      out.write("		\r\n");
      out.write("		<!-- \r\n");
      out.write("			EL에서는 비교 연산을 할 때 다양한 연산자를 사용할 수 있음.\r\n");
      out.write("			기본적으로 >, <, >=, <=, ==, != 같은 연산자 외에도,\r\n");
      out.write("			'gt', 'lt', 'ge', 'le', 'eq', 'ne'와 같은 키워드도 사용 가능.\r\n");
      out.write("		-->\r\n");
      out.write("		<tr align=\"center\">\r\n");
      out.write("			<td>${ 25 != 3 }</td> <!-- 25가 3과 다른지 비교. 결과는 true -->\r\n");
      out.write("			<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ 25 != 3 }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td> <!-- EL을 사용하여 25 != 3의 결과를 출력. 결과는 true -->\r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr align=\"center\">\r\n");
      out.write("			<td>${ 25 ne 3 }</td> <!-- \"ne\"는 \"!=\"와 동일한 의미로, 25가 3과 다른지 비교. 결과는 true -->\r\n");
      out.write("			<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ 25 ne 3 }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td> <!-- EL을 사용하여 25 ne 3의 결과를 출력. 결과는 true -->\r\n");
      out.write("		</tr>\r\n");
      out.write("		\r\n");
      out.write("		<!-- \r\n");
      out.write("			EL을 사용하여 request 헤더에서 특정 값을 가져오는 방식.\r\n");
      out.write("			header는 HTTP 요청의 헤더 값을 나타내며, [] 안에 헤더 이름을 넣어서 접근 가능.\r\n");
      out.write("			\"host\"는 요청이 온 호스트 정보를 나타냄.\r\n");
      out.write("		-->\r\n");
      out.write("		<tr align=\"center\">\r\n");
      out.write("			<td>${ header['host'] }</td> <!-- header 객체에서 'host' 값을 가져옴 -->\r\n");
      out.write("			<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ header['host'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td> <!-- EL을 사용하여 요청 헤더의 'host' 값 출력 -->\r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr align=\"center\">\r\n");
      out.write("			<td>${ header.host }</td> <!-- 위와 동일하지만, 점(.)을 사용하여 접근 -->\r\n");
      out.write("			<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ header.host }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td> <!-- EL을 사용하여 요청 헤더의 'host' 값 출력 -->\r\n");
      out.write("		</tr>\r\n");
      out.write("		\r\n");
      out.write("		<tr align=\"center\">\r\n");
      out.write("			<td></td> \r\n");
      out.write("			<td></td> \r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr align=\"center\">\r\n");
      out.write("			<td></td>\r\n");
      out.write("			<td></td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		\r\n");
      out.write("	</table>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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