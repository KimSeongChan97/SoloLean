<%-- FilmNote/src/main/webapp/user/userSignIn.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="../image/film_favicon.png" type="image/png">
<link rel="stylesheet" href="../css/userSignIn.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" crossorigin="anonymous" referrerpolicy="no-referrer">
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<title>로그인</title>
</head>
<body>
<jsp:include page="../common/header.jsp" />	
	<div id="login-jsp" class="signin-container">
        
        <h2>로그인</h2>
        <form id="loginForm" action="${pageContext.request.contextPath}/user/userSignInDB.do" method="post">
            <table>
                <tr>
                    <td class="label"><label for="loginId"><i class="fa-solid fa-user"></i> ID</label></td>
                    <td class="input"><input type="text" id="loginId" name="uid" required></td>
                </tr>
                <tr>
                    <td colspan="2"><div id="loginIdDiv"></div></td>
                </tr>
                <tr>
                    <td class="label"><label for="loginPwd"><i class="fa-solid fa-lock"></i> Pwd</label></td>
                    <td class="input"><input type="password" id="loginPwd" name="upwd" required></td>
                </tr>
                <tr>
                    <td colspan="2"><div id="loginPwdDiv"></div></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <button type="submit" id="loginBtn">로그인</button>
                        <button type="button" onclick="location.href='${pageContext.request.contextPath}/user/userSignUp.do'">회원가입</button>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><div id="loginErrorDiv"></div></td> <!-- 로그인 에러 메시지 div 추가 -->
                </tr>
            </table>
            		<!-- 경고 메시지 div를 여기에 추가 -->
			    <div id="loginWarningMessage" class="show" style="display: none;"> <!--  text-align: center; color: #e74c3c; margin-top: 10px;  -->
			        <!-- 이곳에 경고 메시지가 표시됩니다 -->
			    </div>
        </form>
        <button type="button" id="adminBtn" onclick="location.href='${pageContext.request.contextPath}/admin/adminSignIn.do'">Admin</button> <!-- 관리자 로그인 버튼 추가 -->
    </div>
    
			   <!-- 로그인 실패 모달 -->
		<div id="loginErrorModal" title="로그인 실패" style="display:none;">
		    <p id="loginErrorMessage"></p>
		</div>

    
	
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="../js/userSignIn.js"></script>

<script>
    <% if (session.getAttribute("userDTO") != null) { %>
        window.location.href = '${pageContext.request.contextPath}/index.do';
    <% } %>
</script>
</body>
</html>