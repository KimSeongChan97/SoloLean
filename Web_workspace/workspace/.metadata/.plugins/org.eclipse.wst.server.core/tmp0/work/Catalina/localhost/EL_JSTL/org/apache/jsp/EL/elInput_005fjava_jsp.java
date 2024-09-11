/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.93
 * Generated at: 2024-09-11 06:20:02 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.EL;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class elInput_005fjava_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>EL Input_java</title>\r\n");
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
      out.write("	/*\r\n");
      out.write("		- `display: flex`는 Flexbox 레이아웃을 사용해 페이지 요소를 배치합니다.\r\n");
      out.write("		- `justify-content: center`는 페이지 가로 방향으로 요소들을 중앙에 배치합니다.\r\n");
      out.write("		- `align-items: flex-start`는 세로 방향으로 요소들을 상단에 배치합니다.\r\n");
      out.write("		- `height: 100vh`는 페이지의 높이를 100%로 사용한다는 의미입니다. (화면의 전체 높이를 차지함)\r\n");
      out.write("		- `margin-top: 50px`은 페이지 상단에 50px의 여백을 주어 좀 더 아래쪽에 폼을 배치합니다.\r\n");
      out.write("		- 배경 색상은 #0d0d0d(어두운 배경), 글씨 색상은 형광 네온 스타일의 #00ffcc를 사용하여 스타일을 정의했습니다.\r\n");
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
      out.write("		- 테이블의 너비를 350px로 설정하였습니다.\r\n");
      out.write("		- `margin: 0 auto`는 테이블을 수평으로 가운데 정렬합니다.\r\n");
      out.write("		- `border-collapse: collapse`는 테이블 셀의 경계선을 하나로 합쳐서 표시합니다.\r\n");
      out.write("		- 테두리는 형광 네온 느낌의 #00ffcc로 설정했고, 네온 효과를 강조하기 위해 box-shadow를 추가했습니다.\r\n");
      out.write("		- `box-shadow`는 형광 테두리의 그림자 효과로, 네온과 사이버펑크 느낌을 주는 시각적 효과를 강화합니다.\r\n");
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
      out.write("		- `padding: 15px`은 테이블 셀 안의 여백을 지정합니다.\r\n");
      out.write("		- `text-align: center`는 셀 안의 텍스트를 가운데 정렬합니다.\r\n");
      out.write("		- 셀의 배경색은 #1a1a1a로 어두운 분위기를 유지하고, 글자색은 #00ffcc로 형광 효과를 강조했습니다.\r\n");
      out.write("		- 셀의 하단에 1px의 형광 네온 테두리(#00ffcc)를 추가해 테이블 요소를 구분했습니다.\r\n");
      out.write("	*/\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(".buttons {\r\n");
      out.write("	text-align: center;\r\n");
      out.write("	padding-top: 20px;\r\n");
      out.write("	/*\r\n");
      out.write("		- 버튼들을 가운데 정렬하고, 상단에 20px의 여백을 추가하여 공간을 확보했습니다.\r\n");
      out.write("		- 이 클래스를 사용해 submit과 reset 버튼을 테이블 하단에 적절히 배치했습니다.\r\n");
      out.write("	*/\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(" input[type=\"text\"] {\r\n");
      out.write("     width: 80%;\r\n");
      out.write("     padding: 10px;\r\n");
      out.write("     background-color: #0d0d0d; /* 어두운 배경 */\r\n");
      out.write("     border: 2px solid #00ffcc; /* 형광색 테두리 */\r\n");
      out.write("     color: #00ffcc; /* 텍스트 색상 */\r\n");
      out.write("     outline: none; /* 클릭 시 외곽선 제거 */\r\n");
      out.write("	 /*\r\n");
      out.write("		- 입력 필드의 너비를 80%로 설정하여 적절한 크기로 조정하였습니다.\r\n");
      out.write("		- `padding: 10px`을 설정하여 입력 필드 내부의 여백을 주었습니다.\r\n");
      out.write("		- 배경색(#0d0d0d)은 페이지의 어두운 톤과 일치시키고, 테두리와 텍스트 색상은 네온 스타일(#00ffcc)로 설정했습니다.\r\n");
      out.write("		- 클릭 시 입력 필드에 생기는 기본 외곽선을 제거하여 깔끔한 디자인을 유지했습니다.\r\n");
      out.write("	 */\r\n");
      out.write(" }\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write(" input[type=\"submit\"], input[type=\"reset\"] {\r\n");
      out.write("     background-color: #1a1a1a; \r\n");
      out.write("     border: 2px solid #ff00ff; \r\n");
      out.write("     color: #00ffcc; \r\n");
      out.write("     padding: 10px 20px;\r\n");
      out.write("     cursor: pointer;\r\n");
      out.write("     text-transform: uppercase;\r\n");
      out.write("     box-shadow: 0px 0px 10px #00ffcc, 0px 0px 20px #ff00ff; \r\n");
      out.write("     transition: all 0.3s ease-in-out; /* 마우스 오버 시 애니메이션 */\r\n");
      out.write("	 /*\r\n");
      out.write("		- 제출(submit) 및 리셋(reset) 버튼의 스타일을 설정했습니다.\r\n");
      out.write("		- 어두운 배경(#1a1a1a)과 형광 보라색(#ff00ff) 테두리를 사용하여 미래적인 느낌을 줍니다.\r\n");
      out.write("		- 버튼에 `box-shadow`를 추가해 네온 느낌의 그림자를 주어 시각적으로 더 돋보이게 했습니다.\r\n");
      out.write("		- `text-transform: uppercase`는 텍스트를 대문자로 변환하여 강조 효과를 줍니다.\r\n");
      out.write("		- `transition`으로 마우스 오버 시 애니메이션 효과를 추가하여 사용자 경험을 향상시킵니다.\r\n");
      out.write("	 */\r\n");
      out.write(" }\r\n");
      out.write("\r\n");
      out.write(" input[type=\"submit\"]:hover, input[type=\"reset\"]:hover {\r\n");
      out.write("     background-color: #00ffcc; /* 호버 시 형광색 배경 */\r\n");
      out.write("     color: #0d0d0d; \r\n");
      out.write("     box-shadow: 0px 0px 30px #00ffcc, 0px 0px 50px #ff00ff; \r\n");
      out.write("	 /*\r\n");
      out.write("		- 마우스 오버 시 버튼의 배경색이 형광색(#00ffcc)으로 변경되고, 글자 색상은 어두운 배경(#0d0d0d)으로 변경됩니다.\r\n");
      out.write("		- box-shadow의 크기를 늘려 네온 효과가 더욱 강해지도록 설정했습니다.\r\n");
      out.write("		- 이런 시각적 피드백은 버튼을 더 매력적이고 상호작용하기 쉬운 요소로 만듭니다.\r\n");
      out.write("	 */\r\n");
      out.write(" }\r\n");
      out.write(" \r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("		\r\n");
      out.write("	<form action=\"elResult_java.jsp\" method=\"get\" >\r\n");
      out.write("		<h3> Java Class 의 메소드를 이용 하겠습니다.</h3>\r\n");
      out.write("	<table >\r\n");
      out.write("				\r\n");
      out.write("		<tr>\r\n");
      out.write("			<th>X</th> \r\n");
      out.write("			<td><input type=\"text\" name=\"x\" id=\"x\" value=\"\" ></td> \r\n");
      out.write("		</tr>\r\n");
      out.write("		\r\n");
      out.write("		<tr>\r\n");
      out.write("			<th>Y</th> \r\n");
      out.write("			<td><input type=\"text\" name=\"y\" id=\"y\" value=\"\" ></td> \r\n");
      out.write("		</tr>\r\n");
      out.write("		\r\n");
      out.write("			<tr>\r\n");
      out.write("			<td colspan=\"2\" class=\"buttons\">\r\n");
      out.write("			<input type=\"submit\" value=\"계산\" />\r\n");
      out.write("			<input type=\"reset\" value=\"취소\"  />\r\n");
      out.write("			</td>\r\n");
      out.write("			</tr>		\r\n");
      out.write("		</table>\r\n");
      out.write("	</form>\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
