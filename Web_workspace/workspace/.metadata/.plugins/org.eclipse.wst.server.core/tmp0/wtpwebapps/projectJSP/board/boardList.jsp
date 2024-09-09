<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="board.dao.BoardDAO" %>
<%@ page import="board.bean.BoardDTO" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 목록</title>
    <!-- 게시글 목록에 대한 스타일을 정의한 외부 CSS 파일을 연결합니다. 
         "/projectJSP/css/boardList.css" 경로에 있는 CSS 파일을 로드하여, 페이지 스타일을 적용합니다. -->
    <link rel="stylesheet" type="text/css" href="/projectJSP/css/boardList.css">
</head>
<body>

    <!-- 네비게이션 바를 포함합니다. 'nav.jsp' 파일을 삽입하여 상단 네비게이션 바가 나타나도록 합니다. 
         이를 통해 다른 페이지로 쉽게 이동할 수 있습니다. -->
    <jsp:include page="/jsp/nav.jsp" />

    <!-- 제목을 가운데 정렬하고, 클릭 시 메인 페이지('index.jsp')로 이동하는 h2 태그입니다. 
         Comic Sans MS 폰트를 사용하여 제목을 꾸몄습니다. -->
    <h2 align="center" style="font-family: 'Comic Sans MS';" onclick="location.href='../index.jsp'">N o t e </h2>

    <%
        // 페이징 관련 변수 설정
        // 현재 페이지 번호를 URL에서 가져옵니다. 만약 'page' 파라미터가 없으면 기본값으로 1페이지로 설정됩니다.
        int currentPage = (request.getParameter("page") != null) ? Integer.parseInt(request.getParameter("page")) : 1; 

        // 한 페이지에 표시할 게시글 수를 설정합니다. 여기서는 한 페이지당 5개의 게시글을 표시합니다.
        int postsPerPage = 5;

        // DAO를 통해 데이터베이스에 저장된 총 게시글 수를 가져옵니다. 이 값은 페이징 계산에 사용됩니다.
        int totalPosts = BoardDAO.getInstance().getTotalPosts();

        // 총 페이지 수를 계산합니다. 전체 게시글 수를 페이지당 게시글 수로 나누고, 소수점이 있으면 올림 처리를 합니다.
        int totalPages = (int)Math.ceil((double)totalPosts / postsPerPage); 

        // 현재 페이지를 기준으로 시작 페이지 번호를 설정합니다. 현재 페이지가 1이라면 startPage는 1로 설정됩니다.
        // 페이지네이션에서 몇 페이지부터 보여줄지를 결정합니다.
        int startPage = Math.max(1, currentPage - 2); 

        // 끝 페이지 번호를 설정합니다. 현재 페이지를 기준으로 다음 2개의 페이지까지를 보여주며, 총 페이지 수를 넘지 않도록 합니다.
        int endPage = Math.min(totalPages, currentPage + 2); 

        // DAO를 통해 현재 페이지에 해당하는 게시글 목록을 가져옵니다.
        // 'currentPage'와 'postsPerPage'를 매개변수로 하여, 해당 페이지에 맞는 게시글만 불러옵니다.
        BoardDAO boardDAO = BoardDAO.getInstance();
        List<BoardDTO> boardList = boardDAO.getBoardListByPage(currentPage, postsPerPage);
    %>

    <!-- 게시글 목록을 보여주는 테이블입니다. 테이블은 100% 너비로 설정되며, 각 게시글의 정보가 행(row) 단위로 표시됩니다. -->
    <table border="1" style="width: 100%;">
        <tr>
            <!-- 테이블 헤더 부분. 게시글 목록의 각 항목(번호, 제목, 작성자, 작성일, 조회수)에 해당하는 열의 제목을 표시합니다. -->
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>조회수</th>
        </tr>

        <%
            // 가져온 게시글 목록(boardList)을 하나씩 순회하면서 각 게시글의 정보를 테이블에 출력합니다.
            // boardList는 BoardDTO 객체들의 리스트로, 각 객체에는 하나의 게시글 정보가 담겨 있습니다.
            for (BoardDTO board : boardList) {
        %>
        <tr>
            <!-- 게시글 번호(seq)를 테이블에 표시합니다. 이는 게시글 고유의 식별자 역할을 합니다. -->
            <td><%= board.getSeq() %></td>

            <!-- 제목을 클릭하면 해당 게시글의 상세 페이지(boardView.jsp)로 이동하게 합니다. 
                 링크의 URL에 게시글 번호(seq)를 파라미터로 전달하여, 클릭한 게시글의 내용을 조회할 수 있도록 합니다. -->
            <td><a href="boardView.jsp?seq=<%= board.getSeq() %>"><%= board.getSubject() %></a></td>

            <!-- 작성자의 이름(name)을 표시합니다. -->
            <td><%= board.getName() %></td>

            <!-- 게시글이 작성된 날짜(logtime)를 표시합니다. -->
            <td><%= board.getLogtime() %></td>

            <!-- 게시글의 조회수(hit)를 표시합니다. -->
            <td><%= board.getHit() %></td>
        </tr>
        <%
            }
        %>
    </table>

    <!-- 페이징 처리 부분입니다. 페이지네이션을 구현하여 사용자가 여러 페이지를 쉽게 이동할 수 있도록 합니다. -->
    <nav aria-label="Page navigation" class="pagination-nav" style="margin-top: 20px;">
      <ul class="pagination justify-content-center">
        <!-- 이전 페이지로 이동하는 버튼입니다. 현재 페이지가 1페이지이면 비활성화(disabled)됩니다. -->
        <li class="page-item <%= (currentPage == 1) ? "disabled" : "" %>">
          <!-- 이전 페이지로 이동하는 링크입니다. 현재 페이지에서 1을 뺀 페이지로 이동합니다. -->
          <a class="page-link" href="?page=<%= (currentPage > 1) ? currentPage - 1 : 1 %>" aria-label="Previous">
            <!-- << 기호를 사용하여 이전 페이지를 나타냅니다. -->
            <span aria-hidden="true">&laquo;</span>
          </a>
        </li>

        <!-- 현재 페이지 기준으로 startPage부터 endPage까지의 페이지 번호를 동적으로 생성하여 표시합니다. -->
        <%
            // startPage부터 endPage까지의 페이지 번호를 순회하면서 페이지 버튼을 생성합니다.
            for (int i = startPage; i <= endPage; i++) {
        %>
        <!-- 현재 페이지를 나타내는 버튼은 active 클래스를 추가하여 시각적으로 강조합니다. -->
        <li class="page-item <%= (i == currentPage) ? "active" : "" %>">
          <!-- 각 페이지 번호에 맞는 링크를 생성하여 클릭 시 해당 페이지로 이동하도록 합니다. -->
          <a class="page-link" href="?page=<%= i %>"><%= i %></a>
        </li>
        <%
            }
        %>

        <!-- 다음 페이지로 이동하는 버튼입니다. 현재 페이지가 마지막 페이지(totalPages)이면 비활성화(disabled)됩니다. -->
        <li class="page-item <%= (currentPage == totalPages) ? "disabled" : "" %>">
          <!-- 다음 페이지로 이동하는 링크입니다. 현재 페이지에서 1을 더한 페이지로 이동합니다. -->
          <a class="page-link" href="?page=<%= (currentPage < totalPages) ? currentPage + 1 : totalPages %>" aria-label="Next">
            <!-- >> 기호를 사용하여 다음 페이지를 나타냅니다. -->
            <span aria-hidden="true">&raquo;</span>
          </a>
        </li>
      </ul>
    </nav>

    <!-- jQuery 라이브러리 파일을 로드하여 페이지에서 다양한 이벤트 처리가 가능하도록 합니다. 
         이는 자바스크립트의 간단한 DOM 조작 및 이벤트 처리를 쉽게 만들어 줍니다. -->
    <script type="text/javascript" src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
</body>
</html>
