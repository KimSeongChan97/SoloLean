<%-- FilmNote/src/main/webapp/common/adminMenu.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Brush+Script&display=swap" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/init.css" rel="stylesheet">

<style type="text/css">
/* 	font-family: 'Sacramento', sans-serif; */
#admin-menu {
	border-bottom: 1px solid #5A5A5A;
	display: flex;
	align-items: center;
}

a.menu-a {
	display: block;
	width: 50%;
}

/* div#movie-list-menu {
	background: #DEC5D2;
} >> js로 처리*/

div.menu-div {
	font: normal 400 22px "Nanum Brush Script", sans-serif; /* style weight size font-family */
}

#movie-list-menu, #movie-write-menu {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 50px;
}

</style>

<body>
<div id="admin-menu" >
	<a class="menu-a" href="${pageContext.request.contextPath }/admin/movieList.do">
		<div class="menu-div" id="movie-list-menu" >
			영화 목록
		</div>
	</a>
	<a class="menu-a" href="${pageContext.request.contextPath }/admin/movieWrite.do">
		<div class="menu-div" id="movie-write-menu" >
			영화 등록
		</div>
	</a>
</div>
</body>
