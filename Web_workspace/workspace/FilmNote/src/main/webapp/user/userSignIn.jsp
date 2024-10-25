<%-- FilmNote/src/main/webapp/user/userSignIn.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="../image/film_favicon.png" type="image/png">
<link rel="stylesheet" href="../css/userSignIn.css">
<%-- 외부 폰트와 아이콘을 사용하기 위한 스타일 시트 링크 --%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" crossorigin="anonymous" referrerpolicy="no-referrer">
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<title>로그인</title>
</head>
<body>
<jsp:include page="../common/header.jsp" />
<%-- 공통 헤더 파일을 포함하여 페이지 상단에 표시 --%>	
	<div id="login-jsp" class="signin-container">
        <%-- 로그인 폼을 담고 있는 컨테이너 div --%>
        
        <h2>로그인</h2>
        <%-- 로그인 제목 표시 --%>
        <form id="loginForm" action="${pageContext.request.contextPath}/user/userSignInDB.do" method="post">
            <%-- 로그인 폼. 입력된 데이터는 POST 방식으로 userSignInDB.do로 전송됨 --%>
            <table>
                <tr>
                    <td class="label"><label for="loginId"><i class="fa-solid fa-user"></i> ID</label></td>
                    <td class="input"><input type="text" id="loginId" name="uid" required></td>
                </tr>
                <%-- 사용자가 로그인할 때 입력하는 ID 필드. 아이디 입력란은 필수(required) --%>
                
                <tr>
                    <td colspan="2"><div id="loginIdDiv"></div></td>
                    <%-- ID 입력 오류나 관련 메시지를 표시할 수 있는 div --%>
                </tr>
                
                <tr>
                    <td class="label"><label for="loginPwd"><i class="fa-solid fa-lock"></i> Pwd</label></td>
                    <td class="input"><input type="password" id="loginPwd" name="upwd" required></td>
                </tr>
                <%-- 사용자가 입력하는 비밀번호 필드. 비밀번호도 필수 항목 --%>
                
                <tr>
                    <td colspan="2"><div id="loginPwdDiv"></div></td>
                    <%-- 비밀번호 입력 오류나 관련 메시지를 표시할 수 있는 div --%>
                </tr>
                
                <tr>
                    <td colspan="2">
                        <button type="submit" id="loginBtn">로그인</button>
                        <button type="button" onclick="location.href='${pageContext.request.contextPath}/user/userSignUp.do'">회원가입</button>
                    </td>
                </tr>
                <%-- 로그인 버튼과 회원가입 버튼을 추가. 로그인 버튼은 폼을 제출하고, 회원가입 버튼은 회원가입 페이지로 이동 --%>
                
                <tr>
                    <td colspan="2"><div id="loginErrorDiv"></div></td> 
                    <%-- 로그인 시 에러 메시지가 표시될 div. 예를 들어, 아이디나 비밀번호가 틀렸을 때 메시지가 여기에 표시됨 --%>
                </tr>
            </table>
            
            <!-- 경고 메시지 div를 여기에 추가 -->
            <div id="loginWarningMessage" class="show" style="display: none;">
                <!-- 이곳에 경고 메시지가 표시됩니다 -->
                <%-- 경고 메시지나 주의 사항을 표시하는 div. 기본적으로 숨겨져 있으며 필요 시에만 표시 --%>
            </div>
        </form>
        
        <button type="button" id="adminBtn" onclick="location.href='${pageContext.request.contextPath}/admin/adminSignIn.do'">Admin</button> 
        <%-- 관리자 로그인 버튼을 추가. 클릭 시 관리자 로그인 페이지로 이동 --%>
    </div>
    
    <!-- 로그인 실패 모달 -->
    <div id="loginErrorModal" title="로그인 실패" style="display:none;">
        <p id="loginErrorMessage"></p>
        <%-- 로그인 실패 시 표시되는 모달 창. 'loginErrorMessage'에 실패 원인이 표시됨 --%>
    </div>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<%-- jQuery 라이브러리 로드 --%>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<%-- jQuery UI 라이브러리 로드. 모달 창 등에 사용 --%>
<script type="text/javascript" src="../js/userSignIn.js"></script>
<%-- 로그인 관련 JavaScript 파일을 로드 --%>

<script>
    <% if (session.getAttribute("userDTO") != null) { %>
        window.location.href = '${pageContext.request.contextPath}/index.do';
    <% } %>
    <%-- 세션에 userDTO가 있으면 이미 로그인 상태이므로 메인 페이지로 리다이렉트 --%>
</script>
</body>
</html>
