/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.93
 * Generated at: 2024-09-24 00:56:02 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.main;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class nav_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/D:/git/SoloLean/SoloLean/Web_workspace/workspace/projectMVC/src/main/webapp/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1726024852904L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

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
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write("   \r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("/* a 태그의 기본 스타일 */\r\n");
      out.write("a {\r\n");
      out.write("    text-decoration: none; /* 밑줄 제거 */\r\n");
      out.write("    color: #f2f2f2; /* 텍스트 색상을 연한 회색으로 설정 */\r\n");
      out.write("    transition: color 1.5s ease, text-shadow 1.5s ease; /* 색상이 서서히 변하도록 트랜지션 설정 */\r\n");
      out.write("    /* transition을 사용하면 색상과 그림자가 부드럽게 변화함 */\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a:hover {\r\n");
      out.write("    color: cyan; /* 마우스를 올렸을 때 텍스트 색상을 cyan으로 변경 */\r\n");
      out.write("    text-shadow: 0 0 10px cyan, 0 0 20px cyan, 0 0 30px cyan, 0 0 40px cyan;\r\n");
      out.write("    /* 마우스를 올렸을 때 글자에 네온 효과를 주는 그림자 설정 */\r\n");
      out.write("    /* text-shadow는 글자 주위로 빛이 퍼져나가는 네온 효과를 구현함 */\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* 공통 네온 버튼 스타일 */\r\n");
      out.write(".neon-btn {\r\n");
      out.write("    background-color: #f2f2f2; /* 기본 배경색을 연한 회색으로 설정 */\r\n");
      out.write("    color: black; /* 기본 텍스트 색상을 검은색으로 설정 */\r\n");
      out.write("    padding: 10px 20px; /* 버튼 내부의 여백 설정 (위아래 10px, 좌우 20px) */\r\n");
      out.write("    border: none; /* 버튼 테두리를 제거 */\r\n");
      out.write("    cursor: pointer; /* 마우스 커서를 손 모양으로 변경 */\r\n");
      out.write("    transition: box-shadow 1.5s ease; /* 박스 그림자가 서서히 변하도록 트랜지션 설정 */\r\n");
      out.write("    border-radius: 25px; /* 버튼의 모서리를 둥글게 설정 */\r\n");
      out.write("    /* border-radius는 버튼의 모서리를 둥글게 만들어 시각적으로 더 부드럽게 보이게 함 */\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* 버튼에 대한 hover 시 네온 효과 적용 */\r\n");
      out.write(".neon-btn:hover {\r\n");
      out.write("    box-shadow: 0 0 10px cyan, 0 0 20px cyan, 0 0 30px cyan, 0 0 40px cyan;\r\n");
      out.write("    /* 마우스를 올렸을 때 버튼의 박스 주위에 네온 효과가 나타나도록 설정 */\r\n");
      out.write("    /* box-shadow는 버튼 주위로 빛나는 테두리를 만들어 네온사인 효과를 줌 */\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Logout 버튼의 스타일 설정 */\r\n");
      out.write("#logoutBtn {\r\n");
      out.write("    background-color: #f2f2f2; /* Logout 버튼의 배경색을 연한 회색으로 설정 */\r\n");
      out.write("    color: black; /* 텍스트 색상은 검은색으로 설정 */\r\n");
      out.write("    padding: 10px 20px; /* 버튼 내부 여백 설정 (위아래 10px, 좌우 20px) */\r\n");
      out.write("    border: none; /* 버튼 테두리 제거 */\r\n");
      out.write("    cursor: pointer; /* 마우스 커서를 손 모양으로 변경 */\r\n");
      out.write("    transition: box-shadow 1.5s ease; /* 박스 그림자가 서서히 변하도록 설정 */\r\n");
      out.write("    border-radius: 25px; /* 버튼의 모서리를 둥글게 설정 */\r\n");
      out.write("    /* logoutBtn 스타일은 네온 버튼과 동일하지만 별도로 정의하여 특화된 변경 가능성을 남김 */\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Logout 버튼에 대한 hover 시 박스 네온 효과 적용 */\r\n");
      out.write("#logoutBtn:hover {\r\n");
      out.write("    box-shadow: 0 0 10px cyan, 0 0 20px cyan, 0 0 30px cyan, 0 0 40px cyan;\r\n");
      out.write("    /* 마우스를 올렸을 때 Logout 버튼 주위에 네온사인 효과를 줌 */\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<!-- 세션이 없을 때 -->\r\n");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- 세션이 있을 때 -->\r\n");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-3.7.1.min.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("	// 로그아웃 버튼 클릭 시 처리\r\n");
      out.write("	$('#logoutBtn').click(function(){\r\n");
      out.write("		 $.ajax({\r\n");
      out.write("			type: 'post',  // POST 요청 방식으로 서버에 로그아웃 요청을 보냄\r\n");
      out.write("			url: '/projectMVC/member/logout.do',  // 로그아웃을 처리할 서버 URL\r\n");
      out.write("			success: function(){\r\n");
      out.write("				// 로그아웃 성공 시 메인 페이지로 이동\r\n");
      out.write("				location.href=\"/projectMVC/index.do\";\r\n");
      out.write("			},\r\n");
      out.write("			error: function(e){\r\n");
      out.write("				console.log(e);  // 오류 발생 시 콘솔에 출력\r\n");
      out.write("			}\r\n");
      out.write("		}); \r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("</script>\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /main/nav.jsp(60,0) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${memId == null }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("    <!-- 로그인 및 회원가입 버튼을 표시 -->\r\n");
          out.write("	<input type=\"button\" class=\"neon-btn\" value=\"Login\" \r\n");
          out.write("		   onclick=\"location.href='");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("/member/loginForm.do'\" /> <br><br/>\r\n");
          out.write("	<!-- 로그인 버튼: 클릭 시 loginForm.do로 이동 -->\r\n");
          out.write("\r\n");
          out.write("	<input type=\"button\" class=\"neon-btn\" value=\"회원가입\" \r\n");
          out.write("		   onclick=\"location.href='");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("/member/writeForm.do'\"  /> <br><br/>\r\n");
          out.write("	<!-- 회원가입 버튼: 클릭 시 writeForm.do로 이동 -->\r\n");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f1_reused = false;
    try {
      _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f1.setParent(null);
      // /main/nav.jsp(72,0) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${memId != null }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("    <!-- 로그인된 상태일 때 사용자 ID를 표시 -->\r\n");
          out.write("	<h3>\r\n");
          out.write("		<a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("/member/updateForm.do\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${memId }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write(" 님.</a>\r\n");
          out.write("		<!-- 사용자 ID를 클릭하면 회원정보 수정 페이지로 이동 -->\r\n");
          out.write("	</h3>\r\n");
          out.write("		\r\n");
          out.write("	<input type=\"button\" value=\"Logout\" id=\"logoutBtn\"/> <br><br/>\r\n");
          out.write("	<!-- Logout 버튼: 클릭 시 로그아웃 처리 -->\r\n");
          out.write("	\r\n");
          out.write("	");
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      _jspx_th_c_005fif_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f1_reused);
    }
    return false;
  }
}
