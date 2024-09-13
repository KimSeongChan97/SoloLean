<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index 페이지</title>
<style type="text/css">
body {
	background-color: #0d0d0d;
	color: #00ffcc;
	text-align: center;
	margin-top: 90px;
}

</style>
</head>
<body>
<h2>메인화면</h2>
<c:if test="${sessionScope.memId == null }">

	<h3><a href="/memberMVC/member/writeForm.do">회원가입</a></h3>
	<h3><a href="/memberMVC/member/loginForm.do">로그인</a></h3>
</c:if> 	
<c:if test="${sessionScope.memId != null }">
	<h3><a href="/memberMVC/member/logout.do">로그아웃</a></h3>
	<h3><a href="/memberMVC/member/updateForm.do">회원정보수정</a></h3>
	<h3><a href="/memberMVC/board/boardWriteForm.do">글쓰기</a></h3>
</c:if> 	
	
	<h3><a href="/memberMVC/board/boardList.do?pg=1">목록</a></h3>
</body>
</html>












