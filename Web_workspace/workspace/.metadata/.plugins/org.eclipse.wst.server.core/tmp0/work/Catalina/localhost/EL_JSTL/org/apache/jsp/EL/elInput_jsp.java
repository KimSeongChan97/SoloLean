/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.93
 * Generated at: 2024-09-11 05:58:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.EL;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class elInput_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>EL Input</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("body {\r\n");
      out.write("	display: flex;\r\n");
      out.write("	justify-content: center;\r\n");
      out.write("	align-items: flex-start;\r\n");
      out.write("	height: 100vh;\r\n");
      out.write("	margin-top: 50px;\r\n");
      out.write("	background-color: #0d0d0d;\r\n");
      out.write("	color: #00ffcc;\r\n");
      out.write("	/* \r\n");
      out.write("	- body 태그에 Flexbox를 적용하여 화면 중앙에 정렬되도록 설정했습니다.\r\n");
      out.write("	- justify-content: center는 가로 중앙으로 정렬하고,\r\n");
      out.write("	  align-items: flex-start는 세로축에서 위쪽부터 시작하도록 설정합니다.\r\n");
      out.write("	- height: 100vh는 화면 높이를 100% 사용한다는 의미입니다.\r\n");
      out.write("	- margin-top: 50px으로 상단에 여백을 추가하여 중앙에 더 가까워지도록 했습니다.\r\n");
      out.write("	- 배경 색상은 어두운 사이버펑크 느낌(#0d0d0d)을 주었고, \r\n");
      out.write("	  텍스트 색상은 형광 네온 느낌의 #00ffcc 색상을 사용했습니다.\r\n");
      out.write("	*/\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("table {\r\n");
      out.write("	width: 350px;\r\n");
      out.write("	margin: 0 auto;\r\n");
      out.write("	border-collapse: collapse;\r\n");
      out.write("	border: 2px solid #00ffcc;\r\n");
      out.write("	box-shadow: 0px 0px 20px #00ffcc, 0px 0px 40px #ff00ff;\r\n");
      out.write("	/*\r\n");
      out.write("	- 테이블의 너비를 350px로 고정하고, 테두리(border)를 형광색(#00ffcc)으로 지정했습니다.\r\n");
      out.write("	- border-collapse: collapse는 테두리 간의 공간을 없애서 하나로 보이도록 하는 설정입니다.\r\n");
      out.write("	- margin: 0 auto는 테이블을 가운데로 정렬하기 위한 설정입니다.\r\n");
      out.write("	- box-shadow로 테이블에 네온 느낌의 그림자를 추가하여 미래적인 스타일을 구현했습니다.\r\n");
      out.write("	- 그림자는 두 가지 색(#00ffcc와 #ff00ff)을 사용하여 네온 효과를 더 극적으로 만들었습니다.\r\n");
      out.write("	*/\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("th, td {\r\n");
      out.write("	padding: 15px;\r\n");
      out.write("	text-align: center;\r\n");
      out.write("	background-color: #1a1a1a;\r\n");
      out.write("	border-bottom: 1px solid #00ffcc;\r\n");
      out.write("	color: #00ffcc;\r\n");
      out.write("	/*\r\n");
      out.write("	- 테이블의 셀 내부 공간에 padding을 15px 주어 여백을 추가했습니다.\r\n");
      out.write("	- text-align: center로 텍스트를 가운데 정렬했고, 셀의 배경색을 #1a1a1a로 지정하여 어두운 느낌을 더했습니다.\r\n");
      out.write("	- border-bottom: 1px solid #00ffcc로 셀 하단에 테두리를 넣어 강조 효과를 추가했습니다.\r\n");
      out.write("	- 셀 내부의 텍스트 색상은 형광 네온 느낌(#00ffcc)으로 지정했습니다.\r\n");
      out.write("	- 테두리와 텍스트 색상은 통일감 있게 설정되어 있어 화면 전체 디자인에 일관성을 줍니다.\r\n");
      out.write("	*/\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(".buttons {\r\n");
      out.write("	text-align: center;\r\n");
      out.write("	padding-top: 20px;\r\n");
      out.write("	/*\r\n");
      out.write("	- buttons 클래스로 버튼을 포함한 셀을 중앙 정렬했고, 상단에 20px의 여백을 추가했습니다.\r\n");
      out.write("	- 이를 통해 버튼들이 테이블 하단 중앙에 배치되도록 했습니다.\r\n");
      out.write("	- 버튼의 위치가 명확하게 중앙에 정렬되어 사용자의 접근성을 높였습니다.\r\n");
      out.write("	*/\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input[type=\"text\"] {\r\n");
      out.write("	width: 80%;\r\n");
      out.write("	padding: 10px;\r\n");
      out.write("	background-color: #0d0d0d; /* 어두운 배경 */\r\n");
      out.write("	border: 2px solid #00ffcc; /* 형광색 테두리 */\r\n");
      out.write("	color: #00ffcc; /* 텍스트 색상 */\r\n");
      out.write("	outline: none; /* 클릭 시 외곽선 제거 */\r\n");
      out.write("	/*\r\n");
      out.write("	- 텍스트 입력 필드의 너비를 80%로 설정하여 화면에 적절한 크기로 보이도록 했습니다.\r\n");
      out.write("	- padding을 10px 설정하여 입력 필드 안의 텍스트와 테두리 사이에 여백을 추가했습니다.\r\n");
      out.write("	- 배경색은 어두운 #0d0d0d로 설정해 사이버펑크 분위기를 유지했고, 테두리(border)는 형광색(#00ffcc)으로 지정했습니다.\r\n");
      out.write("	- 입력된 텍스트의 색상도 형광 네온 느낌(#00ffcc)으로 지정해 디자인을 일관성 있게 유지했습니다.\r\n");
      out.write("	- outline: none으로 클릭 시 외곽선이 나타나지 않게 설정했습니다.\r\n");
      out.write("	- 넓이(80%)와 패딩(10px)은 사용자가 텍스트를 입력할 때 편안한 사용자 경험을 제공합니다.\r\n");
      out.write("	*/\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input[type=\"submit\"], input[type=\"reset\"] {\r\n");
      out.write("	background-color: #1a1a1a; \r\n");
      out.write("	border: 2px solid #ff00ff; \r\n");
      out.write("	color: #00ffcc; \r\n");
      out.write("	padding: 10px 20px;\r\n");
      out.write("	cursor: pointer;\r\n");
      out.write("	text-transform: uppercase;\r\n");
      out.write("	box-shadow: 0px 0px 10px #00ffcc, 0px 0px 20px #ff00ff; \r\n");
      out.write("	transition: all 0.3s ease-in-out; /* 마우스 오버 시 애니메이션 */\r\n");
      out.write("	/*\r\n");
      out.write("	- 제출 버튼과 리셋 버튼의 배경색을 어두운 #1a1a1a로 설정하여 배경과 잘 어울리도록 했습니다.\r\n");
      out.write("	- 테두리(border)를 형광 보라색(#ff00ff)으로 지정하여 버튼이 강조되도록 했습니다.\r\n");
      out.write("	- 버튼의 텍스트 색상도 형광 네온(#00ffcc)으로 설정해 일관된 스타일을 유지했습니다.\r\n");
      out.write("	- padding은 버튼의 크기를 조정하기 위해 설정되었고, cursor: pointer로 마우스를 올리면 포인터가 바뀌게 했습니다.\r\n");
      out.write("	- text-transform: uppercase는 텍스트를 모두 대문자로 표시하는 설정입니다.\r\n");
      out.write("	- box-shadow로 네온 효과를 추가하여 버튼이 마우스를 올렸을 때 강조되는 느낌을 줍니다.\r\n");
      out.write("	- transition으로 버튼에 마우스를 올릴 때 부드럽게 색상이 바뀌는 애니메이션 효과를 설정했습니다.\r\n");
      out.write("	- 전반적으로 버튼의 시각적 강조와 사용성을 높이기 위한 스타일입니다.\r\n");
      out.write("	*/\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input[type=\"submit\"]:hover, input[type=\"reset\"]:hover {\r\n");
      out.write("	background-color: #00ffcc; /* 호버 시 형광색 배경 */\r\n");
      out.write("	color: #0d0d0d; \r\n");
      out.write("	box-shadow: 0px 0px 30px #00ffcc, 0px 0px 50px #ff00ff; \r\n");
      out.write("	/*\r\n");
      out.write("	- 버튼에 마우스를 올리면 배경색이 형광 네온(#00ffcc)으로 바뀌며, 텍스트 색상은 어두운 #0d0d0d로 변경됩니다.\r\n");
      out.write("	- box-shadow의 크기를 키워서 버튼에 마우스를 올리면 네온 효과가 더 크게 나타나도록 했습니다.\r\n");
      out.write("	- 이 효과는 사용자 인터페이스를 보다 직관적으로 만들어 주며, 버튼의 가시성을 높여줍니다.\r\n");
      out.write("	- hover 효과는 사용자와의 상호작용을 강화시켜 시각적인 피드백을 줍니다.\r\n");
      out.write("	*/\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	<form action=\"elResult.jsp\" method=\"get\" >\r\n");
      out.write("	<table >\r\n");
      out.write("\r\n");
      out.write("		<tr>\r\n");
      out.write("			<th>X</th> \r\n");
      out.write("			<td><input type=\"text\" name=\"x\" id=\"x\" value=\"\" ></td> \r\n");
      out.write("		</tr>\r\n");
      out.write("		");
      out.write("\r\n");
      out.write("		\r\n");
      out.write("		<tr>\r\n");
      out.write("			<th>Y</th> \r\n");
      out.write("			<td><input type=\"text\" name=\"y\" id=\"y\" value=\"\" ></td> \r\n");
      out.write("		</tr>\r\n");
      out.write("		");
      out.write("\r\n");
      out.write("		\r\n");
      out.write("			<tr>\r\n");
      out.write("			<td colspan=\"2\" class=\"buttons\">\r\n");
      out.write("			<input type=\"submit\" value=\"계산\" />\r\n");
      out.write("			<input type=\"reset\" value=\"취소\"  />\r\n");
      out.write("			</td>\r\n");
      out.write("			</tr>		\r\n");
      out.write("			");
      out.write("	\r\n");
      out.write("		</table>\r\n");
      out.write("	</form>\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
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
