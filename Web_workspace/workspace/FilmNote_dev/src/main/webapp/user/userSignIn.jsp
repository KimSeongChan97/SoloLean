<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/SignIn.css">
    <script src="${pageContext.request.contextPath}/js/member.js"></script>
</head>
<body>
    <div class="signin-container">
        
        <h2>로그인</h2>
        <form id="loginForm" method="post" action="user/login.do">
            <table>
                <tr>
                    <td><label for="loginId">아이디</label></td>
                    <td><input type="text" id="loginId" name="loginId" required></td>
                </tr>
                <tr>
                    <td colspan="2"><div id="loginIdDiv"></div></td>
                </tr>
                <tr>
                    <td><label for="loginPwd">비밀번호</label></td>
                    <td><input type="password" id="loginPwd" name="loginPwd" required></td>
                </tr>
                <tr>
                    <td colspan="2"><div id="loginPwdDiv"></div></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <button type="submit" id="loginBtn">로그인</button>
                        <button type="button" onclick="location.href='userSignUp.jsp'">회원가입</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
