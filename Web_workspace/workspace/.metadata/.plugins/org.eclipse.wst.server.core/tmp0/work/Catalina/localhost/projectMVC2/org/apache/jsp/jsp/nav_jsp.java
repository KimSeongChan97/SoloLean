/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.93
 * Generated at: 2024-09-14 04:06:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class nav_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!-- 부트스트랩 CSS 링크 추가 -->\n");
      out.write("<!-- Bootstrap은 인기 있는 CSS 프레임워크로, 반응형 레이아웃을 손쉽게 구성할 수 있게 도와줍니다.\n");
      out.write("     여기서는 최신 버전의 Bootstrap CSS 파일을 CDN(Content Delivery Network)에서 가져와 사용합니다. \n");
      out.write("     \"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css\" URL을 통해 브라우저가 부트스트랩 CSS를 로드하게 됩니다. -->\n");
      out.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("<!-- Google Fonts 및 Ionicons 사용 -->\n");
      out.write("<!-- Google Fonts는 웹폰트를 제공하는 서비스로, \"Poppins\" 폰트를 적용합니다. 폰트 두께는 300에서 900까지 다양하게 제공됩니다. \n");
      out.write("     이 링크는 브라우저가 Google의 폰트 서버에서 \"Poppins\" 폰트를 가져와서 페이지에 적용할 수 있도록 합니다. -->\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("<!-- head 태그 안에 CSS 파일 연결 -->\n");
      out.write("\n");
      out.write("<!-- 네비게이션 바 HTML 구조 -->\n");
      out.write("<!-- 부트스트랩의 네비게이션 바 구성요소를 사용하여 메뉴바를 구성합니다.\n");
      out.write("     \"navbar bg-body-tertiary\" 클래스는 Bootstrap의 네비게이션 바 스타일 중 하나로, 기본적인 레이아웃과 스타일을 제공합니다. -->\n");
      out.write("<nav class=\"navbar bg-body-tertiary\">\n");
      out.write("    <div class=\"container-fluid\">\n");
      out.write("        <!-- home.png 이미지를 클릭하면 index.jsp로 이동 -->\n");
      out.write("        <!-- \"navbar-brand\" 클래스는 네비게이션 바의 브랜드 요소로 사용됩니다. 여기서는 \"home.png\" 이미지를 네비게이션 바 왼쪽에 배치하고, 이 이미지를 클릭하면 \"mainpage.html\"로 이동하게 합니다. -->\n");
      out.write("        <a class=\"navbar-brand\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/index.do\">\n");
      out.write("    		<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/image/home.png\" alt=\"Home\" width=\"30\" height=\"30\"/>\n");
      out.write("		</a>\n");
      out.write("\n");
      out.write("        <!-- 부트스트랩의 토글 버튼 (모바일 및 작은 화면에서 메뉴를 여닫을 수 있게 해주는 버튼) -->\n");
      out.write("        <!-- \"navbar-toggler\" 클래스는 작은 화면(모바일)에서 네비게이션 바를 숨기고 토글 버튼을 누르면 메뉴가 펼쳐지도록 해줍니다. \n");
      out.write("             버튼을 클릭하면 \"data-bs-target\" 속성에 지정된 \"navbarNavAltMarkup\" ID를 가진 div 요소를 토글하여 메뉴를 표시하거나 숨깁니다. -->\n");
      out.write("        <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNavAltMarkup\" aria-controls=\"navbarNavAltMarkup\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("            <span class=\"navbar-toggler-icon\"></span> <!-- 부트스트랩에서 제공하는 기본 토글 아이콘을 사용 -->\n");
      out.write("        </button>\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbarNavAltMarkup\">\n");
      out.write("            <!-- 네비게이션 메뉴 항목들을 나열 -->\n");
      out.write("            <!-- \"navbar-nav\" 클래스는 부트스트랩에서 네비게이션 바 내의 메뉴 아이템들을 정렬할 때 사용됩니다. \n");
      out.write("                 이 div 안에는 실제로 보여질 네비게이션 메뉴 항목들이 포함됩니다. -->\n");
      out.write("            <div class=\"navbar-nav navigation\">\n");
      out.write("                <ul>\n");
      out.write("                	 <!-- 세션에 memId가 있는지 확인하여 로그인 상태를 체크 -->\n");
      out.write("        			");
 if (session.getAttribute("memId") == null) { 
      out.write("\n");
      out.write("        			<!-- 로그인하지 않은 경우 보여줄 메뉴 리스트 -->\n");
      out.write("                    <li class=\"list active\">                        \n");
      out.write("                        <!-- 각 네비게이션 항목 -->\n");
      out.write("                        <!-- 네비게이션 항목은 \"nav-link\" 클래스를 통해 부트스트랩 스타일을 적용받으며, 각 항목에 링크가 걸려 있습니다. \n");
      out.write("                             첫 번째 항목은 \"전체 메뉴\"로, \"ion-icon\"을 통해 아이콘을 추가하고 \"index.jsp\"로 이동하게 설정되어 있습니다. -->\n");
      out.write("                        <a class=\"nav-link\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/index.do\">\n");
      out.write("                            <span class=\"icon\">\n");
      out.write("                                <ion-icon name=\"home-outline\"></ion-icon> <!-- 홈 아이콘 추가 -->\n");
      out.write("                            </span>\n");
      out.write("                            <span class=\"text\">Main Menu</span> <!-- 텍스트 표시: 전체 메뉴 -->\n");
      out.write("                            <span class=\"circle\"></span> <!-- 추가적인 스타일 요소로 원형을 나타냅니다. -->\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"list\">\n");
      out.write("                        <!-- 회원가입 메뉴 항목 -->\n");
      out.write("                        <!-- 사용자가 회원가입을 할 수 있는 링크를 표시합니다. -->\n");
      out.write("                        <a class=\"nav-link\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/member/memberWriteForm.do\">\n");
      out.write("                            <span class=\"icon\">\n");
      out.write("                                <ion-icon name=\"person-outline\"></ion-icon> <!-- 사람 아이콘 추가 -->\n");
      out.write("                            </span>\n");
      out.write("                            <span class=\"text\">Register</span> <!-- 텍스트 표시: 회원가입 -->\n");
      out.write("                            <span class=\"circle\"></span> <!-- 원형 스타일 추가 -->\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"list\">\n");
      out.write("                        <!-- 로그인 메뉴 항목 -->\n");
      out.write("                        <!-- 로그인 페이지로 이동하는 링크를 제공합니다. -->\n");
      out.write("                        <a class=\"nav-link\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/member/memberLoginForm.do\">\n");
      out.write("                            <span class=\"icon\">\n");
      out.write("                                <ion-icon name=\"person-outline\"></ion-icon> <!-- 사람 아이콘 추가 -->\n");
      out.write("                            </span>\n");
      out.write("                            <span class=\"text\">Login</span> <!-- 텍스트 표시: Login -->\n");
      out.write("                            <span class=\"circle\"></span> <!-- 원형 스타일 추가 -->\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <!-- 로그인 상태일 때 보이는 메뉴들 -->\n");
      out.write("                    ");
 } else { 
      out.write("\n");
      out.write("                    <!-- 로그인한 상태일 때만 보이는 메뉴 항목들입니다. -->\n");
      out.write("                    <li class=\"list\">\n");
      out.write("                        <!-- 전체 메뉴로 이동하는 링크 -->\n");
      out.write("                        <a class=\"nav-link\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/index.do\">\n");
      out.write("                            <span class=\"icon\">\n");
      out.write("                                <ion-icon name=\"home-outline\"></ion-icon> <!-- 홈 아이콘 추가 -->\n");
      out.write("                            </span>\n");
      out.write("                            <span class=\"text\">Main Menu</span> <!-- 텍스트 표시: 전체 메뉴 -->\n");
      out.write("                            <span class=\"circle\"></span> <!-- 추가적인 스타일 요소로 원형을 나타냅니다. -->\n");
      out.write("                        </a>\n");
      out.write("                    </li>          \n");
      out.write("                    <li class=\"list\">\n");
      out.write("          		    <!-- 로그아웃 메뉴 항목 -->\n");
      out.write("				    <!-- 로그아웃을 처리하는 페이지로 이동하는 링크입니다. -->\n");
      out.write("				    <a class=\"nav-link\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/member/memberLogout.do\">\n");
      out.write("				        <span class=\"icon\">\n");
      out.write("				            <ion-icon name=\"log-out-outline\"></ion-icon> <!-- 로그아웃 아이콘 추가 -->\n");
      out.write("				        </span>\n");
      out.write("				        <span class=\"text\">Logout</span> <!-- 텍스트 표시: 로그아웃 -->\n");
      out.write("				        <span class=\"circle\"></span> <!-- 추가적인 원형 스타일 요소 -->\n");
      out.write("				    </a>\n");
      out.write("					</li>\n");
      out.write("					<li class=\"list\">\n");
      out.write("				    <!-- 회원정보 수정 메뉴 항목 -->\n");
      out.write("				    <!-- 사용자가 자신의 회원 정보를 수정할 수 있는 페이지로 이동하는 링크입니다. -->\n");
      out.write("				    <a class=\"nav-link\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/member/memberUpdateForm.do\">\n");
      out.write("				        <span class=\"icon\">\n");
      out.write("				            <ion-icon name=\"create-outline\"></ion-icon> <!-- 회원정보 수정 아이콘 추가 -->\n");
      out.write("				        </span>\n");
      out.write("				        <span class=\"text\">Edit Profile</span> <!-- 텍스트 표시: 회원정보 수정 -->\n");
      out.write("				        <span class=\"circle\"></span> <!-- 원형 스타일 요소 추가 -->\n");
      out.write("				    </a>\n");
      out.write("					</li>\n");
      out.write("					<li class=\"list\">\n");
      out.write("				    <!-- 글쓰기 메뉴 항목 -->\n");
      out.write("				    <!-- 사용자가 게시글을 작성할 수 있는 링크입니다. -->\n");
      out.write("				    <a class=\"nav-link\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/board/boardWriteForm.do\">\n");
      out.write("				        <span class=\"icon\">\n");
      out.write("				            <ion-icon name=\"pencil-outline\"></ion-icon> <!-- 글쓰기 아이콘 추가 -->\n");
      out.write("				        </span>\n");
      out.write("				        <span class=\"text\">Post</span> <!-- 텍스트 표시: 글쓰기 -->\n");
      out.write("				        <span class=\"circle\"></span> <!-- 원형 스타일 요소 추가 -->\n");
      out.write("				    </a>\n");
      out.write("					</li>\n");
      out.write("					<li class=\"list\">\n");
      out.write("				    <!-- 글목록 메뉴 항목 -->\n");
      out.write("				    <!-- 작성된 게시글 목록을 확인할 수 있는 페이지로 이동하는 링크입니다. -->\n");
      out.write("				    <a class=\"nav-link\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/board/list.do?pg=1\">\n");
      out.write("				        <span class=\"icon\">\n");
      out.write("				            <ion-icon name=\"document-text-outline\"></ion-icon> <!-- 글목록 아이콘 추가 -->\n");
      out.write("				        </span>\n");
      out.write("				        <span class=\"text\">Note</span> <!-- 텍스트 표시: 글목록 -->\n");
      out.write("				        <span class=\"circle\"></span> <!-- 원형 스타일 요소 추가 -->\n");
      out.write("				    </a>\n");
      out.write("					</li>\n");
      out.write("                    <li class=\"list\">\n");
      out.write("                        <!-- 채팅 메뉴 항목 -->\n");
      out.write("                        <!-- 현재 미구현된 기능이며, 채팅 페이지로 이동하는 링크가 추가될 수 있습니다. -->\n");
      out.write("                        <a class=\"nav-link\" href=\"#\">\n");
      out.write("                            <span class=\"icon\">\n");
      out.write("                                <ion-icon name=\"chatbubble-outline\"></ion-icon> <!-- 대화 아이콘 추가 -->\n");
      out.write("                            </span>\n");
      out.write("                            <span class=\"text\">Chat(미구현)</span> <!-- 텍스트 표시: 채팅 (미구현) -->\n");
      out.write("                            <span class=\"circle\"></span> <!-- 원형 스타일 요소 추가 -->\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"list\">\n");
      out.write("                        <!-- 기타 페이지 메뉴 항목 -->\n");
      out.write("                        <!-- 설정과 관련된 페이지로 이동하는 링크입니다. -->\n");
      out.write("                        <a class=\"nav-link\" href=\"#\">\n");
      out.write("                            <span class=\"icon\">\n");
      out.write("                                <ion-icon name=\"settings-outline\"></ion-icon> <!-- 설정 아이콘 추가 -->\n");
      out.write("                            </span>\n");
      out.write("                            <span class=\"text\">Setting(미구현)</span> <!-- 텍스트 표시: 설정 (미구현) -->\n");
      out.write("                            <span class=\"circle\"></span> <!-- 원형 스타일 요소 추가 -->\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <!-- 현재 메뉴를 선택했을 때 보여주는 인디케이터 (위치를 표시하는 애니메이션 요소) -->\n");
      out.write("                    <!-- \"indicator\"는 현재 활성화된 메뉴를 시각적으로 강조하기 위해 사용됩니다. 애니메이션이나 색상 변경 등을 나타낼 때 사용될 수 있습니다. -->\n");
      out.write("                    <div class=\"indicator\"></div>\n");
      out.write("                    \n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("<!-- Ionicons 및 커스텀 JS -->\n");
      out.write("<!-- Ionicons는 아이콘을 쉽게 사용하게 해주는 라이브러리입니다. -->\n");
      out.write("<!-- Ionicons는 ES 모듈을 지원하는 브라우저에서 \"ionicons.esm.js\" 파일을 사용하며, 그렇지 않은 경우 \"ionicons.js\"를 사용합니다. -->\n");
      out.write("<script type=\"module\" src=\"https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js\"></script>\n");
      out.write("<script nomodule src=\"https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js\"></script>\n");
      out.write("\n");
      out.write("<!-- 커스텀 JS 파일 로드 -->\n");
      out.write("<!-- /js/script.js 파일에서 네비게이션 바 관련 애니메이션이나 추가적인 JavaScript 동작을 정의할 수 있습니다. -->\n");
      out.write("<script src=\"../js/script.js\"></script>\n");
      out.write("\n");
      out.write("<!-- 부트스트랩 JS 및 Popper.js 추가 -->\n");
      out.write("<!-- Bootstrap의 JavaScript 기능을 활성화하기 위해 JS 파일을 추가합니다. 이 파일은 팝오버, 모달, 드롭다운 등 다양한 인터랙티브 컴포넌트를 작동시킵니다.\n");
      out.write("     또한, Bootstrap에서 의존하는 Popper.js 라이브러리도 함께 로드하여 툴팁 및 드롭다운 메뉴 위치 계산을 정확히 할 수 있도록 돕습니다. -->\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js\"></script>\n");
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