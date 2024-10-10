<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 인덱스</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/index.css">
</head>
<body>
<%-- 헤더에 로그인 상태 표시 --%>
<div id="header">
    <c:choose>
        <c:when test="${sessionScope.loginUser != null}">
            <p>환영합니다, ${sessionScope.loginUser.name}님!</p>
            <a href="${pageContext.request.contextPath}/user/logout">로그아웃</a>
        </c:when>
        <c:otherwise>
            <a href="${pageContext.request.contextPath}/user/loginForm">로그인</a>
        </c:otherwise>
    </c:choose>
</div>

<h2>*** 메인화면 ***</h2>
<h3>
	<P><a href="/spring/user/loginForm">Login</a></P>
	<p><a href="http://localhost:8080/spring/user/writeForm">회원가입(입력)</a></p>
	<p><a href="/spring/user/list?pg=1">회원정보(출력)</a></p> <!-- pg=1 일때는 생략 가능 -->
</h3>
</body>
</html>