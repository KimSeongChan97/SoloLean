<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Brush+Script&display=swap" rel="stylesheet">
<style type="text/css">
#header {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin: 20px 0 0 0;
	border-bottom: 1px solid #5A5A5A;
	padding: 20px 0;
}

#logoTitle {
	width: 150px;
}

#member {
	width:300px;
	display: flex;
    padding: 0 20px;
    gap:10px;
    flex-direction: row;
    align-items: center;
    justify-content: flex-end;
    border-bottom: 2px solid #00589
}

button.user {
	display: flex;
    align-items: center;
    justify-content: center;
    text-align: center;
    width: 130px;
    height: 30px;
    background: transparent;
    border: 1px solid #3d3d3d;
    border-radius: 3px;
    font: normal 400 20px "Nanum Brush Script", sans-serif; /* style weight size font-family */
    line-height: 50px;
    color: #3d3d3d;
}

button.user:hover {
	background-color: #3d3d3d;
	color: #FFFFFF;
	cursor: pointer;
    transition: background-color 0.3s ease; 
}

</style>
<body>
<div id="header">
	<div id="logoTitle">
		<a href="${pageContext.request.contextPath}/index.do">
			<img src="${pageContext.request.contextPath}/image/filmnote_logo.png" width="300" alt="logo" />
		</a>
	</div>
	
	
	<div id="member">
		<c:choose>
			<c:when test="${not empty sessionScope.userDTO}">
				<button id="profileBtn" class="user" onclick="location.href='${pageContext.request.contextPath}/user/userEdit.do';">${sessionScope.userDTO.uname} 님</button>
				<button id="logOutBtn" class="user" onclick="location.href='${pageContext.request.contextPath}/user/userLogOut.do';">Log Out</button>
			</c:when>
			<c:when test="${not empty sessionScope.adminDTO}">
				<!-- 관리자 버튼 클릭 시 movieList.jsp로 이동 -->
				<button id="profileBtn" class="user" onclick="location.href='${pageContext.request.contextPath}/admin/movieList.do';">${sessionScope.adminDTO.name} 님</button>
				<button id="logOutBtn" class="user" onclick="location.href='${pageContext.request.contextPath}/admin/adminLogOut.do';">Log Out</button>
			</c:when>
			<c:otherwise>
				<button id="signInBtn" class="user" onclick="location.href='${pageContext.request.contextPath}/user/userSignIn.do';">로그인</button>
				<button id="signUpBtn" class="user" onclick="location.href='${pageContext.request.contextPath}/user/userSignUp.do';">회원가입</button>
			</c:otherwise>
		</c:choose>
	</div>

</div><!-- <div id="header"> -->
</body>
