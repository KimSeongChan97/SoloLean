<%-- FilmNote/src/main/webapp/common/header.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
@import url("init.css");
#header {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin: 20px 0 10px 0;
	border-bottom: 1px solid #ccc;
	padding: 20px 0;
}

#title {
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
.user, .logOutBtn {
	display: flex;
    align-items: center;
    justify-content: center;
    text-align: center;
    width: 130px;
    height: 30px;
    background: #FFFFFF;
    border: 1px solid #005898;
    border-radius: 10px;
    font-family: 'Noto Sans CJK KR';
    font-style: normal;
    font-weight: 400;
    font-size: 18px;
    line-height: 50px;
    color: #005898;
    transition: background-color 0.3s ease; 
}

.user:hover, .logOutBtn:hover {
	background-color: #005898;
	color: #FFFFFF;
	cursor: pointer;
}

</style>
<body>
<div id="header">
	<div id="title">
		<img src="./image/film_favicon.png" width="70" alt="logo" />
		
	</div>
	<div id="member">
		<div class="user">로그인</div>
		<div class="user">회원가입</div>
		<c:if test="${memId != null }">
			<div class="user"><span id="user-name"></span> 님</div>
			<button class="logOutBtn">Log Out</button>
		</c:if>
	</div>

</div><!-- <div id="header"> -->






</body>
