<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인</title> <!-- 관리자 로그인 페이지의 제목 -->
<link rel="stylesheet" href="../css/adminSignIn.css"> <!-- 외부 스타일시트 연결 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" crossorigin="anonymous" referrerpolicy="no-referrer">
<!-- FontAwesome 아이콘을 사용하기 위한 외부 CDN 연결 -->
</head>
<body>
<jsp:include page="../common/header.jsp" /> <!-- 공통 헤더 파일 포함 -->

<div id="login-jsp" class="signin-container"> <!-- 로그인 페이지 컨테이너 -->
    <h2>관리자 로그인</h2> <!-- 관리자 로그인 제목 -->
    <form id="adminLoginForm" action="${pageContext.request.contextPath}/admin/adminSignInDB.do" method="post">
        <!-- 관리자 로그인 폼. 서버로 전송될 때 POST 방식으로 전달됨 -->
        <table>
            <tr>
                <!-- ID 필드 앞에 아이콘 추가 -->
                <td class="label"><label for="adminId"><i class="fa-solid fa-user"></i> ID</label></td>
                <!-- 아이디 입력 필드. 필수 입력 필드로 지정 -->
                <td class="input"><input type="text" id="adminId" name="aid" required></td>
            </tr>
            <tr>
                <!-- 아이디 유효성 검사 후 메시지를 표시할 div -->
                <td colspan="2"><div id="adminIdDiv"></div></td>
            </tr>
            <tr>
                <!-- Pwd 필드 앞에 아이콘 추가 -->
                <td class="label"><label for="adminPwd"><i class="fa-solid fa-lock"></i> Pwd</label></td>
                <!-- 비밀번호 입력 필드. 필수 입력 필드로 지정 -->
                <td class="input"><input type="password" id="adminPwd" name="apwd" required></td>
            </tr>
            <tr>
                <!-- 비밀번호 유효성 검사 후 메시지를 표시할 div -->
                <td colspan="2"><div id="adminPwdDiv"></div></td>
            </tr>
            <tr>
                <!-- 로그인 버튼. 폼을 제출하는 역할 -->
                <td colspan="2">
                    <button type="submit" id="adminLoginBtn">로그인</button>
                </td>
            </tr>
        </table>
        <div id="adminLoginErrorDiv"></div>
        <!-- 로그인 실패 시 오류 메시지를 표시할 div -->
        <!-- 경고 메시지 div를 여기에 추가 -->
        <div id="adminLoginWarningMessage" class="show" style="display: none;">
            <!-- 로그인 경고 메시지가 표시될 영역. 처음에는 숨겨진 상태로 설정 -->
        </div>
    </form>
</div>

<!-- jQuery 라이브러리와 JavaScript 파일 포함 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/adminSignIn.js"></script>

<!-- 세션에 adminDTO 객체가 있으면 로그인 상태로 간주하고 index 페이지로 리다이렉트 -->
<script>
    <% if (session.getAttribute("adminDTO") != null) { %>
        window.location.href = '${pageContext.request.contextPath}/index.do';
    <% } %>
</script>
</body>
</html>
