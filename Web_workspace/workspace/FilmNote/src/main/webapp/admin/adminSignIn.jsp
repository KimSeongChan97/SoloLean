<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인</title>
<link rel="stylesheet" href="../css/adminSignIn.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" crossorigin="anonymous" referrerpolicy="no-referrer">
</head>
<body>
<jsp:include page="../common/header.jsp" />

<div id="login-jsp" class="signin-container">
    <h2>관리자 로그인</h2>
    <form id="adminLoginForm" action="${pageContext.request.contextPath}/admin/adminSignInDB.do" method="post">
        <table>
            <tr>
                <!-- ID 필드 앞에 아이콘 추가 -->
                <td class="label"><label for="adminId"><i class="fa-solid fa-user"></i> ID</label></td>
                <td class="input"><input type="text" id="adminId" name="aid" required></td>
            </tr>
            <tr>
                <td colspan="2"><div id="adminIdDiv"></div></td>
            </tr>
            <tr>
                <!-- Pwd 필드 앞에 아이콘 추가 -->
                <td class="label"><label for="adminPwd"><i class="fa-solid fa-lock"></i> Pwd</label></td>
                <td class="input"><input type="password" id="adminPwd" name="apwd" required></td>
            </tr>
            <tr>
                <td colspan="2"><div id="adminPwdDiv"></div></td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit" id="adminLoginBtn">로그인</button>
                </td>
            </tr>
        </table>
			<div id="adminLoginErrorDiv"></div>
        <!-- 경고 메시지 div를 여기에 추가 -->
        <div id="adminLoginWarningMessage" class="show" style="display: none;"> <!--  text-align: center; color: #e74c3c; margin-top: 10px; -->
            <!-- 이곳에 경고 메시지가 표시됩니다 -->
        </div>
    </form>
</div>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/adminSignIn.js"></script>

<script>
    <% if (session.getAttribute("adminDTO") != null) { %>
        window.location.href = '${pageContext.request.contextPath}/index.do';
    <% } %>
</script>
</body>
</html>
