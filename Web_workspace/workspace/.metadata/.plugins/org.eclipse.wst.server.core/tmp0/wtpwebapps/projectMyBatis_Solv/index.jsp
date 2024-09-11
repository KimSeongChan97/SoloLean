<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>메인화면</h2>
<% if(session.getAttribute("memId") == null){ %>
	<h3><a href="./member/writeForm.jsp">회원가입</a></h3>
	<h3><a href="./member/loginForm.jsp">로그인</a></h3>
	
<%}else{ %>
	<h3><a href="./member/logout.jsp">로그아웃</a></h3>
	<h3><a href="./member/updateForm.jsp">회원정보수정</a></h3>
	<h3><a href="./board/boardWriteForm.jsp">글쓰기</a></h3>
	
<%} %>	
	
<h3><a href="./board/boardList.jsp?pg=1">목록</a></h3>
</body>
</html>












