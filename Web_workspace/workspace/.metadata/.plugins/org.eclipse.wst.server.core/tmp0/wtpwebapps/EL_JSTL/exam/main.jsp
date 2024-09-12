<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
</head>
<body>

	<h3>*** include directive ***</h3>

	<%@ include file="today.jsp"%>
	<%-- 
	 	include directive를 사용하여 'today.jsp' 파일을 현재 JSP 페이지에 포함시킵니다.
		컴파일 시점에 포함되어 최종 JSP 파일이 하나로 처리됩니다. 이 방식은 주로 정적인 콘텐츠(변화가 자주 없고 고정적인 콘텐츠)에 적합합니다.
		즉, 페이지가 로드될 때마다 별도의 요청을 하지 않고, 페이지가 컴파일될 때 미리 포함되므로 성능상 이점이 있을 수 있습니다.
		현재 페이지의 HTML에 'today.jsp' 파일의 내용을 포함시킨다고 볼 수 있습니다.
		여기서는 날짜와 관련된 정보를 'today.jsp'에서 처리할 수 있습니다.
      --%>
	<br />

	<h2>*** include JSP tag ***</h2>

	<jsp:include page="image.jsp" />
	<%-- 
	 	<jsp:include> 액션 태그를 사용하여 'image.jsp' 파일을 동적으로 포함시킵니다.
		이 방식은 요청 시점에 포함된 파일을 별도로 처리하고, 그 결과를 현재 JSP에 포함시킵니다.
		이렇게 동적으로 파일을 포함하는 방식은 자주 변경되는 콘텐츠에 적합하며, 요청마다 새로운 데이터를 받아서 처리할 때 유용합니다.
		여기서는 'image.jsp'가 동적으로 불러와져 이미지와 관련된 내용을 표시할 수 있습니다.
      --%>

	<%
     	String name = "홍길동";
     %>

	<%--
     	이 부분은 자바 코드를 사용하여 문자열 변수를 선언하는 JSP 코드입니다.
		`<% %>` 안에 자바 코드를 작성할 수 있으며, 여기서는 "홍길동"이라는 문자열을 `name` 변수에 저장합니다.
		JSP 내에서 자바 코드를 직접 실행할 수 있는 구문입니다.
      --%>

	<h3>
		main.jsp name = <%=name %></h3>

	<%-- 
     	이 부분은 `<%= %>` 표현식을 사용하여 JSP에서 자바 변수를 HTML에 출력하는 코드입니다.
		`name` 변수에 저장된 값인 "홍길동"을 HTML로 출력합니다.
		이 코드는 JSP에서 자바 변수의 값을 직접 HTML에 삽입하는 데 사용됩니다.
		출력되는 내용은 `<h3>` 태그 안에 "main.jsp name = 홍길동"과 같은 형태로 표시됩니다. 
      --%>

	<% response.setHeader("Refresh", "3;url=https://www.naver.com"); %>
	<%-- 
     	이 부분은 HTTP 응답 헤더를 설정하여 페이지를 자동으로 리프레시(새로고침)하는 기능을 추가합니다.
		`Refresh` 헤더는 페이지가 3초 후에 `https://www.naver.com`으로 리디렉션되도록 설정합니다.
		여기서 `3`은 3초를 의미하며, `url=https://www.naver.com`은 3초 후 이동할 URL을 의미합니다.
		즉, 사용자가 현재 페이지에 머물러 있으면 3초 후에 네이버로 자동으로 이동하게 됩니다.
		이 방식은 페이지 리디렉션을 제어하는 간단한 방법입니다.
      --%>



</body>
</html>