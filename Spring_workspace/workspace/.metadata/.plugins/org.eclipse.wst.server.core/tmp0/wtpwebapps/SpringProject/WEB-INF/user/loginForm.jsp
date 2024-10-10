<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/loginForm.css">
</head>
<body>
    <div id="login-container">
        <h2>로그인</h2>
        <form action="${pageContext.request.contextPath}/user/login" method="post">
            <input type="text" name="id" placeholder="아이디" required>
            <input type="password" name="pwd" placeholder="비밀번호" required>
            <button type="submit">로그인</button>
        </form>
		
        <div id="login-links">
            <a href="${pageContext.request.contextPath}/user/writeForm">회원가입</a>
            | 
            <a href="">비밀번호 찾기(미구현)</a>
        </div>
    </div>
</body>
</html>
