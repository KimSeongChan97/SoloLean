/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.93
 * Generated at: 2024-09-19 03:25:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.member;

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
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>회원가입Form</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("body {\r\n");
      out.write("	background-color: #0d0d0d;\r\n");
      out.write("	color: #00ffcc;\r\n");
      out.write("	/* 페이지 전체 배경색을 어두운 색(#0d0d0d)으로 설정하고, 텍스트를 밝은 청록색(#00ffcc)으로 설정 */\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("table {\r\n");
      out.write("	border-collapse: collapse;\r\n");
      out.write("	/* 테이블 셀의 경계를 합쳐 하나로 보이게 설정하여 깔끔한 테이블 스타일을 구현 */\r\n");
      out.write("}\r\n");
      out.write("th, td {\r\n");
      out.write("	padding: 5px;\r\n");
      out.write("	/* 테이블의 각 셀 안에 여백을 추가하여 내용을 보기 좋게 만듦 */\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#writeForm {\r\n");
      out.write("	display: flex;\r\n");
      out.write("	flex-direction: column;\r\n");
      out.write("	align-items: center;\r\n");
      out.write("	margin: 30px auto;\r\n");
      out.write("	text-align: left;	\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#writeForm div {\r\n");
      out.write("	color: red;\r\n");
      out.write("	font-size: 8pt;\r\n");
      out.write("	font-weight: bold;\r\n");
      out.write("	/* 경고 메시지를 표시할 div의 스타일: 빨간색 글씨, 작은 글씨 크기, 굵은 글씨 */\r\n");
      out.write("}\r\n");
      out.write("h1 {\r\n");
      out.write("	text-align: center;\r\n");
      out.write("	/* 페이지 상단의 제목을 가운데 정렬 */\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<form name=\"writeForm\" id=\"writeForm\" >\r\n");
      out.write("	<!-- 사용자가 회원가입 정보를 작성하고 제출할 폼. post 방식으로 데이터를 전송하고, 서버에서 처리할 URL을 설정 -->\r\n");
      out.write("	\r\n");
      out.write("	<h1>\r\n");
      out.write("	<img src=\"../image/4.jpg\" width=\"100\" height=\"100\" alt=\"홈\" \r\n");
      out.write("		 onclick=\"location.href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/index.do'\"\r\n");
      out.write("		  style=\"cursor: pointer;\"> \r\n");
      out.write("	<!-- 홈 버튼을 이미지로 구현하여 클릭 시 메인 페이지로 이동하게 설정 -->\r\n");
      out.write("	회원가입\r\n");
      out.write("	</h1>\r\n");
      out.write("	\r\n");
      out.write("	<table border=\"1\">\r\n");
      out.write("		<tr>\r\n");
      out.write("	        <th width=\"100\">이름</th>\r\n");
      out.write("	        <td>\r\n");
      out.write("	        	<input type=\"text\" name=\"name\" id=\"name\" placeholder=\"이름 입력\">\r\n");
      out.write("	        	<!-- 사용자가 이름을 입력할 수 있는 필드 -->\r\n");
      out.write("	        	<div id=\"nameDiv\"></div>\r\n");
      out.write("	        	<!-- 이름 입력 관련 경고 메시지를 표시할 영역 -->\r\n");
      out.write("	        </td>\r\n");
      out.write("	    </tr>\r\n");
      out.write("	    \r\n");
      out.write("	    <tr>\r\n");
      out.write("	        <th>아이디</th>\r\n");
      out.write("	        <td>\r\n");
      out.write("	        	<input type=\"text\" name=\"id\" id=\"id\" size=\"30\" placeholder=\"아이디 입력\">\r\n");
      out.write("	        	<!-- 사용자가 아이디를 입력할 수 있는 필드 -->\r\n");
      out.write("	        	<input type=\"hidden\" id=\"check\" value=\"\">\r\n");
      out.write("	        	<!-- 중복체크를 완료했는지 확인하는 hidden 필드 -->\r\n");
      out.write("	        	<div id=\"idDiv\"></div>\r\n");
      out.write("	        	<!-- 아이디 입력 관련 경고 메시지를 표시할 영역 -->\r\n");
      out.write("	        </td>\r\n");
      out.write("	    </tr>\r\n");
      out.write("	    \r\n");
      out.write("	    <tr>\r\n");
      out.write("	        <th>비밀번호</th>\r\n");
      out.write("	        <td>\r\n");
      out.write("	        	<input type=\"password\" name=\"pwd\" id=\"pwd\" size=\"40\" placeholder=\"비밀번호 입력\">\r\n");
      out.write("	        	<!-- 사용자가 비밀번호를 입력할 수 있는 필드 -->\r\n");
      out.write("	        	<div id=\"pwdDiv\"></div>\r\n");
      out.write("	        	<!-- 비밀번호 입력 관련 경고 메시지를 표시할 영역 -->\r\n");
      out.write("	        </td>\r\n");
      out.write("	    </tr>\r\n");
      out.write("	    \r\n");
      out.write("	    <tr>\r\n");
      out.write("	        <th>재확인</th>\r\n");
      out.write("	        <td>\r\n");
      out.write("	        	<input type=\"password\" id=\"repwd\" size=\"40\" placeholder=\"비밀번호 입력\">\r\n");
      out.write("	        	<!-- 사용자가 입력한 비밀번호를 다시 한 번 확인하기 위한 필드 -->\r\n");
      out.write("	        </td>\r\n");
      out.write("	    </tr>\r\n");
      out.write("	    \r\n");
      out.write("	    <tr>\r\n");
      out.write("	        <th>성별</th>\r\n");
      out.write("	        <td>\r\n");
      out.write("	        	<input type=\"radio\" name=\"gender\" value=\"0\" checked=\"checked\" />남자\r\n");
      out.write("	            <input type=\"radio\" name=\"gender\" value=\"1\" />여자\r\n");
      out.write("	            <!-- 사용자가 성별을 선택할 수 있는 라디오 버튼 -->\r\n");
      out.write("	        </td>\r\n");
      out.write("	    </tr>\r\n");
      out.write("	    \r\n");
      out.write("	    <tr>\r\n");
      out.write("	        <th>이메일</th>\r\n");
      out.write("	        <td>\r\n");
      out.write("	        	<input type=\"email\" name=\"email1\">\r\n");
      out.write("	        	<!-- 이메일 앞부분을 입력하는 필드 -->\r\n");
      out.write("	        	@\r\n");
      out.write("	        	<input type=\"text\" name=\"email2\" id=\"email2\">\r\n");
      out.write("	        	<!-- 이메일 도메인을 입력하는 필드 -->\r\n");
      out.write("	        	\r\n");
      out.write("	        	<input type=\"email\" name=\"email3\" id=\"email3\" list=\"email3_list\" oninput=\"change()\">        \r\n");
      out.write("	        	<!-- 사용자가 이메일 도메인을 직접 입력하거나 선택할 수 있도록 제공하는 필드 -->\r\n");
      out.write("	        	<datalist id=\"email3_list\">\r\n");
      out.write("	        		<option value=\"직접입력\"></option>\r\n");
      out.write("	                <option value=\"naver.com\"/>\r\n");
      out.write("	                <option value=\"gmail.com\"/>\r\n");
      out.write("	                <option value=\"daum.net\"/>\r\n");
      out.write("	                <!-- 자주 사용하는 이메일 도메인을 미리 선택할 수 있도록 datalist 제공 -->\r\n");
      out.write("	        	</datalist>\r\n");
      out.write("	        </td>\r\n");
      out.write("	    </tr>\r\n");
      out.write("	    \r\n");
      out.write("	    <tr>\r\n");
      out.write("	        <th>휴대전화</th>\r\n");
      out.write("	        <td>\r\n");
      out.write("	            <select name=\"tel1\">\r\n");
      out.write("	                <optgroup label=\"hp\">\r\n");
      out.write("	                    <option value=\"010\">010</option>\r\n");
      out.write("	                    <option value=\"011\">011</option>\r\n");
      out.write("	                    <option value=\"019\">019</option>\r\n");
      out.write("	                </optgroup>\r\n");
      out.write("	                <!-- 휴대전화 앞자리 번호를 선택할 수 있도록 제공 -->\r\n");
      out.write("	            </select>\r\n");
      out.write("		         -\r\n");
      out.write("		         <input type=\"text\" name=\"tel2\" size=\"4\" maxlength=\"4\">\r\n");
      out.write("		         <!-- 휴대전화 중간 번호 입력 필드 -->\r\n");
      out.write("		         -\r\n");
      out.write("		         <input type=\"text\" name=\"tel3\" size=\"4\" maxlength=\"4\">\r\n");
      out.write("		         <!-- 휴대전화 끝 번호 입력 필드 -->\r\n");
      out.write("			</td>\r\n");
      out.write("	    </tr>\r\n");
      out.write("	    \r\n");
      out.write("	    <tr>\r\n");
      out.write("	    	<th>주소</th>\r\n");
      out.write("	    	<td>\r\n");
      out.write("	    		<input type=\"text\" name=\"zipcode\" id=\"zipcode\" size=\"6\" readonly placeholder=\"우편번호\">\r\n");
      out.write("	    		<!-- 우편번호는 직접 입력하지 않고, 검색 버튼을 통해 설정하게 함 -->\r\n");
      out.write("	    		<button type=\"button\" onclick=\"checkPost(); return false;\">우편번호 검색</button><br/>\r\n");
      out.write("	    		<input type=\"text\" name=\"addr1\" id=\"addr1\" size=\"60\" readonly placeholder=\"주소\"><br/>\r\n");
      out.write("	    		<!-- 주소는 우편번호 검색으로 자동 설정되므로 readonly로 처리 -->\r\n");
      out.write("	    		<input type=\"text\" name=\"addr2\" id=\"addr2\" size=\"60\" placeholder=\"상세주소\">\r\n");
      out.write("	    		<!-- 사용자가 직접 입력해야 하는 상세 주소 필드 -->\r\n");
      out.write("	    	</td>\r\n");
      out.write("	    </tr>\r\n");
      out.write("	    \r\n");
      out.write("	    <tr>\r\n");
      out.write("	    	<td colspan=\"2\" align=\"center\">\r\n");
      out.write("	    		<input type=\"button\" value=\"회원가입\" onclick=\"checkWrite()\"/>\r\n");
      out.write("	    		<!-- '회원가입' 버튼 클릭 시 유효성 검사를 수행하는 함수 checkWrite() 호출 -->\r\n");
      out.write("	    		<input type=\"reset\" value=\"다시작성\" />\r\n");
      out.write("	    		<!-- '다시작성' 버튼을 클릭하면 폼이 초기화됨 -->\r\n");
      out.write("	    	</td>\r\n");
      out.write("	    </tr>\r\n");
      out.write("	</table>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-3.7.1.min.js\"></script>\r\n");
      out.write("<!-- jQuery 라이브러리를 불러와 DOM 조작 및 이벤트 처리를 간편하게 수행 -->\r\n");
      out.write("<script src=\"//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js\"></script>\r\n");
      out.write("<!-- Daum의 주소 검색 API를 사용해 우편번호 및 주소를 자동으로 채워줌 -->\r\n");
      out.write("<script src=\"../js/member.js\"></script>\r\n");
      out.write("<!-- 회원가입과 관련된 유효성 검사 및 기타 로직이 담긴 외부 JavaScript 파일을 불러옴 -->\r\n");
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
