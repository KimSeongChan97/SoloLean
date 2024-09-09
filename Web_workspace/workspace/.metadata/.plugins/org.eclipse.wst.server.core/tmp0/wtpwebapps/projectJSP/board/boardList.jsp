<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.dao.BoardDAO" %>
<%@ page import="board.bean.BoardDTO" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 목록</title>
    <link rel="stylesheet" type="text/css" href="/projectJSP/css/boardList.css">
</head>
<body>

	<jsp:include page="/jsp/nav.jsp" /> 
	
	
    <h2 align="center" style="font-family: 'Comic Sans MS';"  
	 onclick="location.href='../index.jsp'" > N o t e </h2>
	 
    <table border="1">
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>조회수</th>
        </tr>

        <%
            // DAO를 통해 게시글 목록 가져오기
            BoardDAO boardDAO = BoardDAO.getInstance();
            List<BoardDTO> boardList = boardDAO.getBoardList();

            for (BoardDTO board : boardList) {
        %>
        
        <tr>
            <td><%= board.getSeq() %></td>
            <td><a href="boardView.jsp?seq=<%= board.getSeq() %>"><%= board.getSubject() %></a></td>
            <td><%= board.getName() %></td>
            <td><%= board.getLogtime() %></td>
            <td><%= board.getHit() %></td>
        </tr>
        <%
            }
        %>
    </table>
    
		    <!-- 페이징 처리를 위한 부분 -->
		<nav aria-label="Page navigation example" class="pagination-nav" style="margin-top: 20px;">
		  <ul class="pagination justify-content-center">
		    <li class="page-item">
		      <a class="page-link" href="?page=${previousPage}" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		
		    <c:forEach var="i" begin="${startPage}" end="${endPage}">
		      <li class="page-item <c:if test='${i == currentPage}'>active</c:if>'">
		        <a class="page-link" href="?page=${i}">${i}</a>
		      </li>
		    </c:forEach>
		
		    <li class="page-item">
		      <a class="page-link" href="?page=${nextPage}" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		  </ul>
		</nav>
    
    <script type="text/javascript" src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
</body>
</html>