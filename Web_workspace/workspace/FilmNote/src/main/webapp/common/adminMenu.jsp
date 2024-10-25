<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Brush+Script&display=swap" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/init.css" rel="stylesheet">

<style type="text/css">
/* 관리자 메뉴 스타일 설정 */

/* #admin-menu: 관리자 메뉴 컨테이너 */
#admin-menu {
	border-bottom: 1px solid #5A5A5A; /* 하단 경계선 추가 */
	display: flex; /* 메뉴들을 가로로 배치 */
	align-items: center; /* 요소들을 수직 가운데 정렬 */
}

/* a.menu-a: 각각의 메뉴 링크 스타일 */
a.menu-a {
	display: block; /* 링크를 블록 요소로 변경하여 클릭 범위 확장 */
	width: 50%; /* 각 메뉴의 너비를 50%로 설정하여 두 개의 메뉴가 화면을 나눔 */
}

/* div.menu-div: 메뉴 텍스트 스타일 */
div.menu-div {
	font: normal 400 22px "Nanum Brush Script", sans-serif; /* 서체 설정: Nanum Brush Script */
}

/* 영화 목록 메뉴 및 영화 등록 메뉴 스타일 설정 */
#movie-list-menu, #movie-write-menu {
	display: flex; /* 텍스트를 가로 중앙에 배치 */
	justify-content: center; /* 텍스트를 수평 중앙에 배치 */
	align-items: center; /* 텍스트를 수직 중앙에 배치 */
	height: 50px; /* 메뉴의 높이를 50px로 설정 */
}

/* movie-list-menu의 배경색을 JS에서 동적으로 처리하도록 설정 (JS로 처리) */
/* div#movie-list-menu {
	background: #DEC5D2; 
} */
</style>

<body>
<div id="admin-menu">
	<!-- 영화 목록으로 이동하는 메뉴 -->
	<a class="menu-a" href="${pageContext.request.contextPath }/admin/movieList.do">
		<div class="menu-div" id="movie-list-menu">
			영화 목록 <!-- 메뉴 텍스트: '영화 목록' -->
		</div>
	</a>
	<!-- 영화 등록 페이지로 이동하는 메뉴 -->
	<a class="menu-a" href="${pageContext.request.contextPath }/admin/movieWrite.do">
		<div class="menu-div" id="movie-write-menu">
			영화 등록 <!-- 메뉴 텍스트: '영화 등록' -->
		</div>
	</a>
</div>
</body>
