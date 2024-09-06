/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.93
 * Generated at: 2024-09-06 06:24:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import member.bean.MemberDTO;
import member.dao.MemberDAO;

public final class memberWrite_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = new java.util.LinkedHashSet<>(3);
    _jspx_imports_classes.add("member.dao.MemberDAO");
    _jspx_imports_classes.add("member.bean.MemberDTO");
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
      out.write("\r\n");
      out.write("\r\n");

    // 데이터
	// 요청의 인코딩을 UTF-8로 설정하여 한글이 깨지지 않도록 합니다.
    // request.setCharacterEncoding("UTF-8")는 클라이언트에서 보낸 데이터를 서버에서 UTF-8로 처리하도록 인코딩 방식을 지정하는 코드입니다.
    request.setCharacterEncoding("UTF-8");

    // 요청 파라미터를 가져옵니다.
    // 사용자가 회원가입 폼에 입력한 데이터를 서버에서 받기 위한 코드입니다. 
    // request.getParameter() 메서드를 통해 클라이언트(사용자)가 입력한 값을 각각의 변수에 저장합니다.
    String id = request.getParameter("id"); // 사용자가 입력한 ID를 가져옵니다.
    String pwd = request.getParameter("pwd"); // 사용자가 입력한 비밀번호를 가져옵니다.
    String repwd = request.getParameter("repwd"); // 비밀번호 재확인 입력 값을 가져옵니다.
    String name = request.getParameter("name"); // 사용자가 입력한 이름을 가져옵니다.
    String gender = request.getParameter("gender"); // 성별 선택 값을 가져옵니다.
    String email1 = request.getParameter("email1"); // 이메일 앞 부분 (예: user) 값을 가져옵니다.
    String email2 = request.getParameter("email2"); // 이메일 도메인 부분 (예: naver.com)을 가져옵니다.
    String tel1 = request.getParameter("tel1"); // 전화번호 첫 부분 (예: 010)을 가져옵니다.
    String tel2 = request.getParameter("tel2"); // 전화번호 중간 부분 (예: 1234)을 가져옵니다.
    String tel3 = request.getParameter("tel3"); // 전화번호 마지막 부분 (예: 5678)을 가져옵니다.
    String zipcode = request.getParameter("zipcode"); // 사용자가 입력한 우편번호를 가져옵니다.
    String addr1 = request.getParameter("addr1"); // 사용자가 입력한 기본 주소를 가져옵니다.
    String addr2 = request.getParameter("addr2"); // 사용자가 입력한 상세 주소를 가져옵니다.
	
    // MemberDTO 객체를 생성하여 회원 정보를 저장합니다.
    // MemberDTO는 회원 정보를 담는 자바 클래스입니다. 해당 객체를 통해 사용자 정보를 한 곳에서 관리할 수 있습니다.
    MemberDTO memberDTO = new MemberDTO();
    memberDTO.setName(name); // DTO 객체에 이름을 설정합니다.
    memberDTO.setId(id); // DTO 객체에 ID를 설정합니다.
    memberDTO.setPwd(pwd); // DTO 객체에 비밀번호를 설정합니다.
    memberDTO.setGender(gender); // DTO 객체에 성별 정보를 설정합니다.
    memberDTO.setEmail1(email1); // DTO 객체에 이메일 앞 부분을 설정합니다.
    memberDTO.setEmail2(email2); // DTO 객체에 이메일 도메인 부분을 설정합니다.
    memberDTO.setTel1(tel1); // DTO 객체에 전화번호 첫 부분을 설정합니다.
    memberDTO.setTel2(tel2); // DTO 객체에 전화번호 중간 부분을 설정합니다.
    memberDTO.setTel3(tel3); // DTO 객체에 전화번호 마지막 부분을 설정합니다.
    memberDTO.setZipcode(zipcode); // DTO 객체에 우편번호를 설정합니다.
    memberDTO.setAddr1(addr1); // DTO 객체에 기본 주소를 설정합니다.
    memberDTO.setAddr2(addr2); // DTO 객체에 상세 주소를 설정합니다.
    // DTO 객체에 정보를 설정하는 과정은, 이후에 DAO로 데이터를 전달할 때 필요한 형태로 데이터를 준비하는 작업입니다.
    	
    // DB
    // 데이터베이스에 회원 정보를 저장하기 위해 DAO(Data Access Object) 객체를 생성합니다.
    // MemberDAO는 데이터베이스와 연결하여 실제로 데이터를 저장하는 클래스입니다.
    MemberDAO memberDAO = MemberDAO.getInstance(); 
    // 데이터베이스에 회원 정보를 저장하는 메서드를 호출합니다.
    // memberWrite 메서드는 DTO에 담긴 회원 정보를 데이터베이스에 삽입하는 역할을 합니다.
    memberDAO.memberWrite(memberDTO);
    

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>회원가입 완료</title> <!-- 페이지 제목을 '회원가입 완료'로 설정합니다. -->\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<!-- 회원가입 완료 메시지를 가운데 정렬하여 출력합니다. -->\r\n");
      out.write("<h3 align=\"center\">회원가입을 완료하였습니다.</h3>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("window.onload = function() {\r\n");
      out.write("	// 페이지가 로드되면, 회원가입이 완료되었음을 알리는 알림 창을 띄웁니다.\r\n");
      out.write("	alert(\"회원가입을 축하합니다.\");\r\n");
      out.write("	// 사용자가 알림창을 확인한 후, 메인 페이지로 이동시킵니다.\r\n");
      out.write("	location.href = \"../index.jsp\"; // 메인 페이지로 이동합니다.\r\n");
      out.write("};\r\n");
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
