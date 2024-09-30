<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Brush+Script&display=swap" rel="stylesheet">
<style type="text/css">
/* 헤더 스타일: 헤더를 화면 상단에 고정하며, 로고와 사용자 정보를 정렬 */
#header {
	display: flex;
	justify-content: space-between; /* 로고와 사용자 정보 양 끝에 배치 */
	align-items: center; /* 수직 정렬 */
	margin: 20px 0 0 0; /* 상단 여백 설정 */
	border-bottom: 1px solid #5A5A5A; /* 하단에 얇은 선을 추가하여 구분 */
	padding: 20px 0; /* 위아래 패딩 추가 */
}

/* 로고 스타일: 로고 영역 크기 지정 */
#logoTitle {
	width: 150px; /* 로고 영역 너비 */
}

/* 사용자 영역 스타일: 사용자 버튼(로그인/로그아웃)을 배치 */
#member {
	width: 300px; /* 사용자 버튼 영역의 너비 설정 */
	display: flex; /* 내부 요소들을 가로로 배치 */
    padding: 0 20px; /* 좌우 패딩 추가 */
    gap: 10px; /* 버튼 사이의 간격 설정 */
    flex-direction: row; /* 요소를 가로로 정렬 */
    align-items: center; /* 수직 가운데 정렬 */
    justify-content: flex-end; /* 버튼을 오른쪽에 정렬 */
    border-bottom: 2px solid #00589; /* 하단에 추가적인 경계선 */
}

/* 사용자 버튼 스타일: 기본 로그인, 로그아웃, 프로필 버튼 스타일 */
button.user {
	display: flex;
    align-items: center; /* 수직 가운데 정렬 */
    justify-content: center; /* 수평 가운데 정렬 */
    text-align: center;
    width: 130px; /* 버튼 너비 */
    height: 30px; /* 버튼 높이 */
    background: transparent; /* 투명 배경 */
    border: 1px solid #3d3d3d; /* 테두리 색상 설정 */
    border-radius: 3px; /* 버튼 모서리를 둥글게 처리 */
    font: normal 400 20px "Nanum Brush Script", sans-serif; /* 폰트 설정 */
    line-height: 50px;
    color: #3d3d3d; /* 버튼 텍스트 색상 */
}

/* 사용자 버튼 호버 스타일: 마우스 올릴 때 스타일 */
button.user:hover {
	background-color: #3d3d3d; /* 배경색이 어두운 회색으로 변경 */
	color: #FFFFFF; /* 텍스트 색상은 흰색으로 변경 */
	cursor: pointer; /* 커서를 손 모양으로 변경 */
    transition: background-color 0.3s ease; /* 배경색 전환 애니메이션 */
}

</style>

<body>
<div id="header">
	<div id="logoTitle">
		<a href="${pageContext.request.contextPath}/index.do">
			<img src="${pageContext.request.contextPath}/image/filmnote_logo.png" width="300" alt="logo" />
			<!-- 로고 이미지: FilmNote 로고가 화면에 표시되며 클릭 시 메인 페이지로 이동 -->
		</a>
	</div>
	
	
	<div id="member"><!-- 로그인 상태에 따라 다른 버튼 표시 -->
		<c:choose> 
			<c:when test="${not empty sessionScope.userDTO}">
				<%-- 사용자 로그인 상태  --%>
				<button id="profileBtn" class="user" onclick="location.href='${pageContext.request.contextPath}/user/userEdit.do';">
					${sessionScope.userDTO.uname} 님 <%-- 유저 이름 표시 --%>
				</button>
				<button id="logOutBtn" class="user" onclick="location.href='${pageContext.request.contextPath}/user/userLogOut.do';">Log Out</button>
			</c:when>
			<c:when test="${not empty sessionScope.adminDTO}">
				<%-- 관리자 로그인 상태 --%>
				<%-- 관리자 버튼 클릭 시 movieList.jsp로 이동 --%>
				<button id="profileBtn" class="user" onclick="location.href='${pageContext.request.contextPath}/admin/movieList.do';">
					${sessionScope.adminDTO.name} 님 <!-- 관리자 이름 표시 -->
				</button>
				<button id="logOutBtn" class="user" onclick="location.href='${pageContext.request.contextPath}/admin/adminLogOut.do';">Log Out</button>
			</c:when>
			<c:otherwise>
				<%--  로그아웃 상태 --%>
				<button id="signInBtn" class="user" onclick="location.href='${pageContext.request.contextPath}/user/userSignIn.do';">로그인</button>
				<button id="signUpBtn" class="user" onclick="location.href='${pageContext.request.contextPath}/user/userSignUp.do';">회원가입</button>
			</c:otherwise>
		</c:choose>
	</div>

</div><!-- <div id="header"> 끝 -->
</body>
