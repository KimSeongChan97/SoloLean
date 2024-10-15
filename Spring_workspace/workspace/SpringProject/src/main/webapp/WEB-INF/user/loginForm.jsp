<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css">
    <!-- 로그인 폼을 위한 CSS 파일을 불러옵니다. ${pageContext.request.contextPath}는 애플리케이션의 기본 경로를 동적으로 불러옵니다. -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/loginForm.css">
<link rel="icon" href="${pageContext.request.contextPath}/static/favicon.ico" type="image/x-icon">
    
</head>
<body>
    <div id="login-container">
        <h2>로그인</h2>
        <!-- 로그인 폼입니다. 사용자가 입력한 데이터를 'POST' 방식으로 서버에 전송합니다. -->
        <!-- action 속성은 로그인 처리를 위한 서버의 경로를 지정합니다. ${pageContext.request.contextPath}/user/login으로 데이터를 전송합니다. -->
        <form action="${pageContext.request.contextPath}/user/login" method="post">
            <!-- 아이디 입력 필드입니다. 사용자가 아이디를 입력하는 텍스트 상자입니다. -->
            <!-- 'required' 속성은 빈 값 제출을 막습니다. 즉, 아이디가 입력되지 않으면 폼이 전송되지 않습니다. -->
            <input type="text" name="id" placeholder="아이디" required>
            
            <!-- 비밀번호 입력 필드입니다. 'password' 타입으로 설정되어 있어 사용자가 입력하는 값이 화면에 표시되지 않고 *로 표시됩니다. -->
            <!-- 'required' 속성은 사용자가 빈 값을 제출할 수 없도록 합니다. -->
            <input type="password" name="pwd" placeholder="비밀번호" required>
            
            <!-- 로그인 버튼입니다. 사용자가 입력을 완료한 후, 로그인 요청을 서버로 전송하기 위한 버튼입니다. -->
            <button type="submit">로그인</button>
        </form>
		
        <div id="login-links">
            <!-- 회원가입 페이지로 이동하는 링크입니다. 사용자가 회원가입을 할 수 있는 경로로 이동합니다. -->
            <a href="${pageContext.request.contextPath}/user/writeForm">회원가입</a>
            | 
            <!-- 비밀번호 찾기 기능을 구현할 예정인 링크입니다. 현재는 기능이 미구현 상태임을 표시합니다. -->
            <a href="">비밀번호 찾기(미구현)</a>
        </div>
    </div>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>
