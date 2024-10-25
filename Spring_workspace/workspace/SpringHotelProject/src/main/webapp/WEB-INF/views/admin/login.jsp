<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Spring Hotel 로그인</title>
    <link rel="stylesheet" href="/SpringHotel/resources/css/adminCSS.css">
    <link rel="stylesheet" href="/SpringHotel/resources/css/header.css">
    <link rel="stylesheet" href="/SpringHotel/resources/css/bootstrap.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <jsp:include page="../common/header.jsp" />
    
    <div class="container">
        <!-- 관리자 로그인 form -->
        <form id="loginForm" class="login-form">
            <table class="log">
                <tr align="center">
                    <th style="text-align: center; margin-top: 50px; padding-top: 50px;">ADMIN LOGIN</th>
                </tr>
                <tr align="center">
                    <td>
                        <p id="welcomText" style="font-size: 20px;">
                            Spring Hotel<br> 관리자 로그인 화면입니다.
                        </p>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="text" name="adminId" id="adminId" placeholder="아이디 입력" class="input" /><br><br>
                        <input type="password" name="pwd" id="pwd" placeholder="비밀번호 입력" class="input" />
                        <div id="loginDiv" style="color: red; margin-top: 10px;"></div>
                        <input type="button" value="로그인" id="loginBtn" class="btn" style="margin-top: 50px;"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="/SpringHotel/resources/js/bootstrap.js"></script>
    <script src="/SpringHotel/resources/js/header.js"></script>
    <script src="/SpringHotel/resources/js/admin.js"></script>
</body>
</html>
