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

    <!-- 네비게이션 바를 포함시킵니다. nav.jsp 파일을 포함하여 상단 네비게이션을 보여줍니다. -->
	<jsp:include page="/jsp/nav.jsp" /> 
	
    <!-- 제목을 가운데 정렬하고, Comic Sans MS 폰트로 설정합니다. 클릭 시 index.jsp로 이동하게 합니다. -->
    <h2 align="center" style="font-family: 'Comic Sans MS';"  
	 onclick="location.href='../index.jsp'" > N o t e </h2>
	 
    <table border="1">
        <tr>
            <!-- 게시글 목록의 테이블 헤더를 설정합니다. -->
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>조회수</th>
        </tr>

        <%
            // DAO를 통해 게시글 목록 가져오기
            // BoardDAO는 게시글 데이터를 데이터베이스에서 가져오는 역할을 합니다.
            BoardDAO boardDAO = BoardDAO.getInstance();
            // 데이터베이스에서 모든 게시글 목록을 가져옵니다. 이 목록은 List 형태로 저장됩니다.
            List<BoardDTO> boardList = boardDAO.getBoardList();

            // 가져온 게시글 목록을 하나씩 순회하면서 테이블에 표시합니다.
            for (BoardDTO board : boardList) {
        %>
        
        <tr>
            <!-- 게시글 번호(시퀀스)를 테이블에 표시합니다. -->
            <td><%= board.getSeq() %></td>
            <!-- 제목을 클릭하면 게시글 상세 페이지(boardView.jsp)로 이동합니다. 게시글 번호(seq)를 URL에 포함시켜 해당 글을 조회합니다. -->
            <td><a href="boardView.jsp?seq=<%= board.getSeq() %>"><%= board.getSubject() %></a></td>
            <!-- 작성자 이름을 표시합니다. -->
            <td><%= board.getName() %></td>
            <!-- 작성일을 표시합니다. 데이터베이스에 저장된 logtime 필드를 가져옵니다. -->
            <td><%= board.getLogtime() %></td>
            <!-- 조회수를 표시합니다. 데이터베이스에서 해당 글의 조회수(hit)를 가져옵니다. -->
            <td><%= board.getHit() %></td>
        </tr>
        <%
            }
        %>
    </table>
    
    <!-- 페이징 처리를 위한 부분 -->
    <!-- 페이지 하단에 페이지 번호 및 이전/다음 버튼을 생성합니다. -->
    <nav aria-label="Page navigation example" class="pagination-nav" style="margin-top: 20px;">
      <ul class="pagination justify-content-center">
        <!-- 이전 페이지 버튼. 현재 페이지가 1페이지일 경우 비활성화. -->
        <li class="page-item">
          <a class="page-link" href="?page=${previousPage}" aria-label="Previous">
            <!-- << 표시로 이전 페이지임을 나타냅니다. -->
            <span aria-hidden="true">&laquo;</span>
          </a>
        </li>
    
        <!-- 현재 페이지를 기준으로 동적으로 페이지 번호를 생성하여 표시합니다. -->
        <c:forEach var="i" begin="${startPage}" end="${endPage}">
          <li class="page-item <c:if test='${i == currentPage}'>active</c:if>'">
            <!-- 페이지 번호를 클릭하면 해당 페이지로 이동합니다. URL에 page 파라미터를 붙여 해당 페이지로 이동 -->
            <a class="page-link" href="?page=${i}">${i}</a>
          </li>
        </c:forEach>
    
        <!-- 다음 페이지 버튼. 마지막 페이지일 경우 비활성화. -->
        <li class="page-item">
          <a class="page-link" href="?page=${nextPage}" aria-label="Next">
            <!-- >> 표시로 다음 페이지임을 나타냅니다. -->
            <span aria-hidden="true">&raquo;</span>
          </a>
        </li>
      </ul>
    </nav>
    
    <!-- jQuery 라이브러리 파일을 포함합니다. jQuery는 자바스크립트 라이브러리로, 다양한 이벤트 및 DOM 조작을 쉽게 할 수 있도록 도와줍니다. -->
    <script type="text/javascript" src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
</body>
</html>
