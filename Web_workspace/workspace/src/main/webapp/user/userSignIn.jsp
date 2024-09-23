<%-- FilmNote/src/main/webapp/user/userSignIn.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="../image/film_favicon.png" type="image/png">
<link rel="stylesheet" href="../css/userSignIn.css">
<title>로그인</title>
</head>
<body>
	
	   <div class="signin-container">
        
        <h2>로그인</h2>
        <form id="loginForm">
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
                <tr>
                    <td colspan="2"><div id="loginErrorDiv"></div></td> <!-- 로그인 에러 메시지 div 추가 -->
                </tr>
            </table>
        </form>
    </div>
	
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/userSignIn.js"></script>
</body>
</html>