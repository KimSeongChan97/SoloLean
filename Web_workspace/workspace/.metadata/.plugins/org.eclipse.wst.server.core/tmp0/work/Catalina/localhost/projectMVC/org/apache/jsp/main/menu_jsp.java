/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.93
 * Generated at: 2024-09-26 00:42:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.main;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menu_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("/* .mainnav 클래스 스타일 정의 */\r\n");
      out.write(".mainnav{\r\n");
      out.write("    background-color: #483D8B;\r\n");
      out.write("    /* .mainnav 클래스를 적용한 요소의 배경색을 설정합니다. 이 색상은 짙은 파란색(#483D8B)입니다. */\r\n");
      out.write("    list-style: none;\r\n");
      out.write("    /* 리스트 아이템의 기본 스타일(점, 숫자 등)을 제거합니다. 이는 ul 요소의 기본 리스트 아이콘을 없애기 위한 설정입니다. */\r\n");
      out.write("    color: #ffffff;\r\n");
      out.write("    /* 텍스트 색상을 흰색으로 설정합니다. 이 설정은 ul 안의 텍스트 색상에 적용됩니다. */\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* .mainnav 요소 뒤에 가상 요소 생성 */\r\n");
      out.write(".mainnav:after{ \r\n");
      out.write("    content: '';\r\n");
      out.write("    /* .mainnav 요소 뒤에 빈 콘텐츠를 추가합니다. 이 콘텐츠는 화면에 표시되지 않으며, 순전히 레이아웃을 위해 사용됩니다. \r\n");
      out.write("       가상 요소를 이용해 부모 요소의 높이를 자식 요소에 맞춰 조정할 수 있도록 합니다. */\r\n");
      out.write("    display: block;\r\n");
      out.write("    /* 이 가상 요소를 블록 요소로 만듭니다. 블록 요소는 자동으로 줄 바꿈되고, 부모의 너비를 모두 차지합니다. */\r\n");
      out.write("    clear: both;\r\n");
      out.write("    /* float 속성을 적용한 요소들이 .mainnav 내부에 있을 때, 이 요소가 흐름을 정리(clear)하게 만들어줍니다. \r\n");
      out.write("       이를 통해 부모 요소가 자식 요소들을 완전히 감싸게 하고, 레이아웃이 붕괴되는 것을 방지합니다. */\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* .mainnav 내 li 요소 스타일 설정 */\r\n");
      out.write(".mainnav li{\r\n");
      out.write("    display: inline-block;\r\n");
      out.write("    /* 리스트 항목을 가로로 배치합니다. 즉, li 요소들이 한 줄로 정렬됩니다. \r\n");
      out.write("       기본적으로 li 요소는 블록 요소이므로 세로로 나열되지만, inline-block을 사용하여 가로로 배치됩니다. */\r\n");
      out.write("    justify-content: space-between;\r\n");
      out.write("    /* flexbox 레이아웃에서 요소 간의 간격을 균등하게 분배하는 속성이지만, 이 경우 inline-block에서는 적용되지 않음. \r\n");
      out.write("       이 코드는 현재 상황에서는 불필요한 속성입니다. flexbox가 사용되지 않기 때문입니다. */\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* .mainnav li a 태그의 기본 스타일 설정 */\r\n");
      out.write(".mainnav li a {\r\n");
      out.write("    display: block;\r\n");
      out.write("    /* 링크 요소를 블록 요소로 만듭니다. 이를 통해 클릭 가능한 영역이 요소 전체로 확장됩니다. \r\n");
      out.write("       a 요소가 li 요소의 전체 크기를 차지하도록 설정함으로써 클릭 가능한 영역이 넓어집니다. */\r\n");
      out.write("    padding: 0 13px; \r\n");
      out.write("    /* 링크의 내부 여백을 위아래는 0, 좌우는 13px로 설정합니다. \r\n");
      out.write("       링크 텍스트가 양쪽으로 적당한 여백을 가지고 배치되게 만듭니다. */\r\n");
      out.write("    background-color: #483D8B;\r\n");
      out.write("    /* 링크의 배경색을 .mainnav와 동일한 짙은 파란색(#483D8B)으로 설정합니다. */\r\n");
      out.write("    color: #ffffff;\r\n");
      out.write("    /* 링크 텍스트의 색상을 흰색(#ffffff)으로 설정합니다. */\r\n");
      out.write("    font: bold 16px/40px 'Nanum Gothic', sans-serif; \r\n");
      out.write("    /* 폰트 설정입니다. 텍스트의 굵기는 bold, 글자 크기는 16px, 줄 간격(line-height)은 40px로 설정합니다. \r\n");
      out.write("       글꼴은 'Nanum Gothic'을 사용하고, 만약 'Nanum Gothic'이 없을 경우에는 기본 sans-serif 글꼴을 사용합니다. */\r\n");
      out.write("    text-transform: uppercase;\r\n");
      out.write("    /* 텍스트를 모두 대문자로 변환합니다. 이를 통해 링크 텍스트가 일관된 대문자 스타일을 유지합니다. */\r\n");
      out.write("    text-decoration: none;\r\n");
      out.write("    /* 링크의 기본 밑줄을 제거합니다. 이를 통해 텍스트가 밑줄 없이 깔끔하게 표시됩니다. */\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* .mainnav li a:hover 상태 스타일 */\r\n");
      out.write(".mainnav li a:hover {\r\n");
      out.write("    color: #660000;\r\n");
      out.write("    /* 마우스가 링크 위에 있을 때 텍스트 색상을 짙은 붉은색(#660000)으로 변경합니다. */\r\n");
      out.write("    background-color: #00ffcc;\r\n");
      out.write("    /* 마우스가 링크 위에 있을 때 배경색을 밝은 청록색(#00ffcc)으로 변경합니다. \r\n");
      out.write("       사용자 인터랙션(hover) 시 시각적 변화를 주어 링크의 강조 효과를 만듭니다. */\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<!-- 메뉴를 나타내는 ul 요소 -->\r\n");
      out.write("<ul class=\"mainnav\">\r\n");
      out.write("    <!-- 세션에 memId 값이 있을 때(사용자가 로그인 상태일 때) 링크를 표시 -->\r\n");
      out.write("    ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("   \r\n");
      out.write("    <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/board/boardList.do?pg=1\">목록</a></li>\r\n");
      out.write("    <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/imageboard/imageboardList.do\">이미지 목록</a></li>\r\n");
      out.write("    \r\n");
      out.write("</ul>\r\n");
      out.write("\r\n");
      out.write("<!-- 설명: 위의 코드는 ul 요소를 사용해 네비게이션 메뉴를 구성합니다.\r\n");
      out.write("     세션에 memId 값이 있으면 '글쓰기' 메뉴가 표시되고, '목록' 메뉴는 항상 표시됩니다. -->");
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
      // /main/menu.jsp(71,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.memId != null }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("        <li><a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("/board/boardWriteForm.do\">글쓰기</a></li>\r\n");
          out.write("	        ");
          if (_jspx_meth_c_005fif_005f1(_jspx_th_c_005fif_005f0, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("    ");
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

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f1_reused = false;
    try {
      _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f0);
      // /main/menu.jsp(73,9) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.memId == 'admin' }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("	        <li><a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("/imageboard/imageboardWriteForm.do\">이미지 등록</a></li>\r\n");
          out.write("	        <li><a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("/imageboard/imageboardWriteAjaxForm.do\">이미지 등록(Ajax)</a></li>\r\n");
          out.write("	        ");
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
