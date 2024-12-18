/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.93
 * Generated at: 2024-10-15 03:12:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.upload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class uploadAJaxForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>파일 업로드(AJax) 페이지</title>\r\n");
      out.write("<!-- Font Awesome을 이용하여 아이콘을 사용할 수 있게 해주는 CSS 파일을 로드합니다. -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css\">\r\n");
      out.write("<!-- 외부 CSS 파일을 불러와 스타일을 적용합니다. -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/uploadForm.css\">\r\n");
      out.write("<link rel=\"icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/favicon.ico\" type=\"image/x-icon\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!-- 홈으로 돌아가는 링크를 제공합니다. Font Awesome의 집 모양 아이콘을 사용하고 있습니다. -->\r\n");
      out.write("<a href=\"/spring/\"><i class=\"fa-solid fa-house\"></i> HOME</a>\r\n");
      out.write("<br/>\r\n");
      out.write("\r\n");
      out.write("<!-- \r\n");
      out.write("    파일 업로드를 위한 AJAX 폼입니다. 이 폼은 전송시 전체 페이지를 새로고침하지 않고, 비동기식으로 서버와 통신합니다. \r\n");
      out.write("    입력된 데이터와 파일은 JavaScript로 처리하여 서버로 전송됩니다.\r\n");
      out.write("-->\r\n");
      out.write("<form id=\"uploadAJaxForm\">\r\n");
      out.write("	<table border=\"1\">\r\n");
      out.write("		<tr>\r\n");
      out.write("			<!-- 상품명을 입력할 수 있는 행입니다. -->\r\n");
      out.write("			<th>상품명</th>\r\n");
      out.write("			<td>\r\n");
      out.write("				<!-- 상품명을 입력하는 필드입니다. 크기를 설정하기 위해 size 속성이 사용되었으며, 아이콘도 함께 표시됩니다. -->\r\n");
      out.write("				<i class=\"fa-solid fa-pen-to-square\"></i><input type=\"text\" name=\"imageName\" size=\"35\" />\r\n");
      out.write("			</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr>\r\n");
      out.write("			<!-- 상품 설명을 입력할 수 있는 필드입니다. -->\r\n");
      out.write("			<td colspan=\"2\">\r\n");
      out.write("				<!-- 상품 설명을 여러 줄로 입력할 수 있도록 다중행 텍스트 필드를 사용했습니다. rows와 cols 속성으로 필드 크기를 지정합니다. -->\r\n");
      out.write("				<textarea name=\"imageContent\" rows=\"10\" cols=\"50\"></textarea>\r\n");
      out.write("				<i class=\"fa-brands fa-google\"></i>\r\n");
      out.write("			</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		\r\n");
      out.write("		<tr>\r\n");
      out.write("			<!-- 파일 업로드 필드입니다. 여러 개의 파일을 업로드할 수 있으며, 파일 선택을 돕기 위해 카메라 아이콘을 추가했습니다. -->\r\n");
      out.write("			<td colspan=\"2\">\r\n");
      out.write("				<!-- 이미지를 선택하는 부분입니다. 카메라 아이콘을 클릭하면 파일 선택 창이 열리도록 설정되어 있습니다. -->\r\n");
      out.write("				<i class=\"fa-solid fa-camera-retro\" \r\n");
      out.write("					alt=\"이미지 선택\" width=\"50\" height=\"50\"\r\n");
      out.write("					id=\"camera\" >\r\n");
      out.write("					이미지 선택\r\n");
      out.write("				</i>\r\n");
      out.write("				<!-- 사용자가 선택한 이미지 목록을 표시하는 영역입니다. -->\r\n");
      out.write("				<span id=\"showImageList\"> 이미지 미리보기 </span>\r\n");
      out.write("				<!-- 파일 선택 필드입니다. 여러 개의 파일을 선택할 수 있도록 multiple 속성을 사용하였으며, visibility를 hidden으로 설정하여 보이지 않게 처리했습니다. -->\r\n");
      out.write("				<input type=\"file\" style=\"visibility: hidden;\" name=\"img[]\" id=\"img\" multiple=\"multiple\"  />\r\n");
      out.write("			</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr>\r\n");
      out.write("			<!-- 업로드 및 취소 버튼을 표시하는 행입니다. -->\r\n");
      out.write("			<td colspan=\"2\" align=\"center\">\r\n");
      out.write("				<!-- 이미지를 업로드하는 버튼입니다. 버튼 클릭 시 자바스크립트가 동작하여 비동기적으로 파일을 업로드합니다. -->\r\n");
      out.write("				<input type=\"button\" value=\"이미지 업로드\" id=\"uploadAJaxBtn\" />  <i class=\"fa-solid fa-arrow-up\"></i>\r\n");
      out.write("				<!-- 취소 버튼은 입력 필드들을 초기화하는 역할을 합니다. -->\r\n");
      out.write("				<input type=\"reset\" value=\"취소\" />  <i class=\"fa-solid fa-xmark\"></i>\r\n");
      out.write("			</td>\r\n");
      out.write("		</tr>			\r\n");
      out.write("	</table>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<!-- jQuery 라이브러리를 사용하여 폼 전송 및 이미지 미리보기를 처리합니다. -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-3.7.1.min.js\"></script>\r\n");
      out.write("<!-- 별도의 JavaScript 파일에서 폼의 비동기 처리를 담당합니다. -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"../js/uploadAJax.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$('#camera').click(function(){\r\n");
      out.write("	// 카메라 아이콘 클릭 시 파일 선택 창이 강제로 열리도록 설정합니다.\r\n");
      out.write("	$('#img').trigger('click'); // 강제 이벤트 발생시킴\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("// 이미지 미리보기 처리\r\n");
      out.write("$('#img').change(function(){\r\n");
      out.write("	// 이미지 미리보기 영역을 비웁니다.\r\n");
      out.write("	$('#showImageList').empty();\r\n");
      out.write("	\r\n");
      out.write("	// 선택된 파일들을 순차적으로 읽어서 미리보기로 출력합니다.\r\n");
      out.write("	for(var i=0; i<this.files.length; i++){\r\n");
      out.write("		readURL(this.files[i]);\r\n");
      out.write("	}\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("// 선택된 파일을 화면에 미리보는 함수\r\n");
      out.write("function readURL(file){\r\n");
      out.write("	var reader = new FileReader(); // FileReader 객체를 생성하여 파일을 읽습니다.\r\n");
      out.write("	\r\n");
      out.write("	var show;\r\n");
      out.write("	reader.onload = function(e){\r\n");
      out.write("		// 파일을 성공적으로 읽은 후, 미리보기로 보여줄 이미지 태그를 생성합니다.\r\n");
      out.write("		var img = document.createElement('img'); // 이미지 태그를 동적으로 생성\r\n");
      out.write("		img.src = e.target.result; // 파일 데이터를 이미지 소스로 설정\r\n");
      out.write("		img.width = 70; // 미리보기 이미지의 너비 설정\r\n");
      out.write("		img.height = 70; // 미리보기 이미지의 높이 설정\r\n");
      out.write("		$('#showImageList').append(img); // 미리보기 영역에 이미지 추가\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	reader.readAsDataURL(file); // 파일을 읽어 데이터 URL로 변환\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- \r\n");
      out.write("FileReader 란?\r\n");
      out.write("FileReader는 type이 file인 input 태그 또는 API 요청과 같은 인터페이스를 통해 \r\n");
      out.write("File 또는 Blob 객체를 편리하게 처리할수있는 방법을 제공하는 객체이며\r\n");
      out.write("abort, load, error와 같은 이벤트에서 발생한 프로세스를 처리하는데 주로 사용되며,\r\n");
      out.write("File 또는 Blob 객체를 읽어서 result 속성에 저장한다.\r\n");
      out.write("\r\n");
      out.write("FileReader도 비동기로 동작한다.\r\n");
      out.write("\r\n");
      out.write("FileReader.onload()\r\n");
      out.write("load 이벤트의 핸들러. 이 이벤트는 읽기 동작이 성공적으로 완료되었을 때마다 발생한다.\r\n");
      out.write("-->\r\n");
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
