<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index 페이지</title>
<link rel="stylesheet" type="text/css" href="/projectMVC2/css/indexcss.css" />
</head>
<body>
<jsp:include page="/jsp/nav.jsp" />

<div id="link">
<h2>메인화면</h2>

Context = ${ pageContext.request.contextPath }

<c:set var="context" value="${ pageContext.request.contextPath }" />

<c:if test="${sessionScope.memId == null }">

	<h3><a href="${context }/member/writeForm.do">회원가입</a></h3>
	<h3><a href="${context }/member/loginForm.do">로그인</a></h3>
</c:if> 	
<c:if test="${sessionScope.memId != null }">
	<h3><a href="${context }/member/logout.do">로그아웃</a></h3>
	<h3><a href="${context }/member/updateForm.do">회원정보수정</a></h3>
	<h3><a href="${context }/board/boardWriteForm.do">글쓰기</a></h3>
</c:if> 	
	<h3><a href="${context }/board/boardList.do?pg=1">목록</a></h3>
</div>	
</body>
</html>












