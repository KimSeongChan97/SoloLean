<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.dao.BoardDAO" %>
<%@ page import="board.bean.BoardDTO" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 보기</title>
    <link rel="stylesheet" type="text/css" href="/projectJSP/css/boardView.css">
</head>
<body>

    <jsp:include page="/jsp/nav.jsp" />

    <h2 align="center" style="font-family: 'Comic Sans MS';"  
    	onclick="location.href='../index.jsp'" > N o t e _ V i e w </h2>

     <%
        // 게시글 정보를 가져오는 로직
        int seq = Integer.parseInt(request.getParameter("seq"));
        BoardDAO boardDAO = BoardDAO.getInstance();
        
        // 조회수 증가
        boardDAO.increaseHit(seq); 
        
        // 게시글 조회
        BoardDTO board = boardDAO.getBoard(seq);
    %>

    <div class="view-form">
        <label for="subject">제목:</label>
        <div id="subject"><%= board.getSubject() %></div><br>

        <label for="content">내용:</label>
        <div id="content"><%= board.getContent() %></div><br>

        <label for="name">작성자:</label>
        <div id="name"><%= board.getName() %></div><br>
		
		<label for="email">작성자 email : </label>
        <div id="email"><%= board.getEmail() %></div><br>
		
        <label for="logtime">작성일:</label>
        <div id="logtime"><%= board.getLogtime() %></div><br>

        <label for="hit">조회수:</label>
        <div id="hit"><%= board.getHit() %></div><br>

        <input type="button" value="목록으로" onclick="location.href='boardList.jsp'">
    </div>

    <script type="text/javascript" src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
</body>
</html>
