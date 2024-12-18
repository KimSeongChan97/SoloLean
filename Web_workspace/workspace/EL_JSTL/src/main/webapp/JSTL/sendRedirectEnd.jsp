<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sendRedirectEnd</title>
<style type="text/css">

body {
	background-color: #0d0d0d;
	color: #00ffcc;
	text-align: center;
	margin-top: 60px;
}

</style>
</head>
<body>

	sendRedirect로 보내면 데이터는 공유하지 않는다. <br>
	주소도 화면도 sendRedirectEnd.jsp 가 보인다. <br>

<!-- request 로 정보를 담아오므로 -->
결과는 = ${requestScope.list }
<!-- 
    request scope의 데이터를 EL(Expression Language)를 사용해 출력하려고 하지만, 
    sendRedirect는 새로운 요청을 발생시키기 때문에 이전 페이지에서 request scope에 저장된 데이터는 공유되지 않습니다.
    sendRedirect는 클라이언트 측에서 새롭게 요청을 발생시키는 방식입니다. 따라서, 처음 페이지에서 설정된 request scope의 값은 새로운 요청에서 사라지게 됩니다.
    EL(Expression Language)를 사용하여 `${requestScope.list}`로 값을 출력하려고 시도하지만, 
    해당 값은 null이 됩니다.
 -->

<%--
<%
    // 자바로 받는다면
    request.getAttribute("list");
    // 자바 코드로 request에서 데이터를 가져오는 방법입니다. 
    그러나 sendRedirect 방식에서는 request 데이터가 전달되지 않기 때문에 null을 반환합니다.
    sendRedirect는 서버 측에서 새로운 요청을 보내기 때문에 request에 저장된 데이터는 전달되지 않으며, 새로운 요청에서는 이 데이터가 존재하지 않게 됩니다.
%>

pageScope → requestScope → sessionScope → applicationScope 순으로 호출

    JSP에서 데이터를 저장하고 접근할 수 있는 범위(scope)에는 네 가지가 있습니다:
    1. **pageScope**: 현재 JSP 페이지 내에서만 유효한 데이터 저장 범위입니다. 다른 페이지로 이동할 경우 해당 데이터를 사용할 수 없습니다.
    2. **requestScope**: 동일한 요청 내에서 유효한 범위입니다. forward를 사용하면 데이터가 유지되지만, sendRedirect는 새로운 요청을 발생시키기 때문에 데이터가 유지되지 않습니다.
    3. **sessionScope**: 특정 사용자의 세션 동안 유효한 범위로, 브라우저가 종료되거나 세션이 만료될 때까지 데이터가 유지됩니다. 이 범위는 로그인 정보나 사용자 세션을 관리할 때 주로 사용됩니다.
    4. **applicationScope**: 웹 애플리케이션 전체에서 유효한 범위로, 모든 사용자와 세션에서 데이터를 공유할 수 있습니다. 애플리케이션이 종료될 때까지 데이터가 유지됩니다.
    이 범위들은 각기 다른 목적으로 사용되며, 데이터를 저장할 범위에 따라 데이터가 유지되는 범위가 다릅니다.

 --%>

</body>
</html>
