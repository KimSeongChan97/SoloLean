<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> <!-- JSTL 함수 라이브러리 추가 -->
<%@ page import="board.dao.BoardDAO" %>
<%@ page import="board.bean.BoardDTO" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 목록</title>
    <link rel="stylesheet" type="text/css" href="/projectMVC/css/boardList.css">
 type="text/css" href="/projectJSP/css/boardList.css"> <!-- 게시글 목록 스타일을 적용하기 위한 CSS 파일 링크 -->
</head>
<body>
<link rel="stylesheet" type="text/css" href="/projectMVC/css/boardList.css">
 type="text/css" href="/projectMVC/css/navbar.css">
<jsp:include page="/jsp/nav.jsp" />


    <jsp:include page="/jsp/nav.jsp" />
    <%-- 
        - 네비게이션 바를 포함합니다. 
        - 'nav.jsp' 파일을 현재 페이지에 삽입하여 상단 네비게이션이 나타나도록 합니다.
        - 이는 다른 페이지로 쉽게 이동할 수 있게 도와줍니다.
    --%>

    <h2 align="center" style="font-family: 'Comic Sans MS';" onclick="location.href='../index.jsp'">N o t e </h2>
    <%-- 
        - 제목을 표시하는 h2 태그로, 제목은 'N o t e'입니다.
        - 텍스트 클릭 시 메인 페이지(index.jsp)로 이동하는 링크 역할을 하도록 onclick 이벤트를 설정했습니다.
        - 제목의 스타일은 'Comic Sans MS' 폰트를 적용했습니다.
    --%>

    <%
        // 페이징 관련 변수 설정
        // 'page' 파라미터에서 현재 페이지 번호를 가져옵니다. 기본값은 1페이지입니다.
        int currentPage = (request.getParameter("page") != null) ? Integer.parseInt(request.getParameter("page")) : 1;
        // 현재 페이지 번호를 가져오고, 기본적으로 1페이지를 보여줍니다. (URL에 'page' 파라미터가 없으면 1로 설정)
        
        // 한 페이지에 표시할 게시글 수를 설정합니다. 이 예에서는 한 페이지에 5개의 게시글을 표시하도록 설정합니다.
        int postsPerPage = 5;
        // 한 페이지에 표시될 게시글의 개수를 설정합니다. 여기서는 5개로 지정합니다.
        
        // 데이터베이스에서 총 게시글 수를 가져옵니다.
        int totalPosts = BoardDAO.getInstance().getTotalPosts();
        // 데이터베이스에서 저장된 전체 게시글 수를 가져옵니다. 이는 페이징 계산에 사용됩니다.

        // 총 페이지 수를 계산합니다. 게시글 수를 페이지당 게시글 수로 나눈 값을 올림하여 총 페이지 수를 계산합니다.
        int totalPages = (int)Math.ceil((double)totalPosts / postsPerPage);
        // 총 게시글 수를 페이지당 게시글 수로 나눈 후 올림하여 총 몇 페이지가 필요한지 계산합니다.

        // 페이지네이션에서 몇 페이지부터 보여줄지 결정합니다. 현재 페이지에서 앞뒤로 2페이지씩 보여주기 위해 설정합니다.
        int startPage = Math.max(1, currentPage - 2);
        int endPage = Math.min(totalPages, currentPage + 2);
        // 페이지네이션에서 시작 페이지와 끝 페이지를 계산합니다. 
        // 현재 페이지를 기준으로 앞뒤로 2개의 페이지를 보여줍니다. (예: 3페이지라면 1-5페이지 범위)

        // 현재 페이지에 해당하는 게시글 목록을 가져옵니다.
        BoardDAO boardDAO = BoardDAO.getInstance();
        List<BoardDTO> boardList = boardDAO.getBoardListByPage(currentPage, postsPerPage);
        // BoardDAO 객체를 통해 현재 페이지에 해당하는 게시글 목록을 불러옵니다.

        // 게시글 목록과 페이징 관련 데이터를 JSP에서 사용할 수 있도록 request에 설정합니다.
        request.setAttribute("boardList", boardList);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("startPage", startPage);
        request.setAttribute("endPage", endPage);
        // request 객체에 페이징 처리와 관련된 정보를 추가하여 JSP에서 사용할 수 있게 합니다.
    %>

    <table border="1" style="width: 100%;">
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>조회수</th>
        </tr>
        <%-- 
            - 게시글 목록을 테이블 형태로 출력합니다.
            - 테이블 헤더는 각각 '번호', '제목', '작성자', '작성일', '조회수'로 설정되어 있으며, 게시글의 주요 정보를 담습니다.
        --%>

        <!-- 게시글 목록을 출력하는 부분 -->
        <c:forEach var="board" items="${boardList}">
            <tr>
                <!-- 게시글 번호를 출력합니다. -->
                <td>${board.seq}</td>
                <%-- 
                    - ${board.seq}: 게시글의 고유 번호를 출력합니다.
                    - 각 게시글의 번호는 BoardDTO 객체의 'seq' 속성에서 가져옵니다.
                --%>

                <!-- 제목을 클릭하면 해당 게시글의 상세 페이지(boardView.jsp)로 이동하도록 링크를 설정합니다. 게시글 번호(seq)를 파라미터로 전달합니다. -->
                <td><a href="boardView.jsp?seq=${board.seq}">${board.subject}</a></td>
                <%-- 
                    - ${board.subject}: 게시글 제목을 출력하며, 제목을 클릭하면 게시글의 상세 페이지로 이동하는 링크를 생성합니다.
                    - 링크는 게시글 번호(seq)를 파라미터로 전달하여 게시글 상세 정보를 보여줍니다.
                --%>

                <!-- 작성자를 출력합니다. -->
                <td>${board.name}</td>
                <%-- ${board.name}: 게시글 작성자의 이름을 출력합니다. --%>

                <!-- 작성일을 출력합니다. -->
                <td>${board.logtime}</td>
                <%-- ${board.logtime}: 게시글이 작성된 날짜를 출력합니다. --%>

                <!-- 조회수를 출력합니다. -->
                <td>${board.hit}</td>
                <%-- ${board.hit}: 게시글의 조회수를 출력합니다. --%>
            </tr>
        </c:forEach>
        <%-- 
            - 게시글 목록을 순차적으로 출력하는 루프입니다. 
            - `boardList` 리스트에 담긴 각 게시글(BoardDTO)의 정보를 하나씩 출력합니다.
            - ${board.seq}, ${board.subject} 등으로 객체의 값을 JSP에서 출력할 수 있습니다.
        --%>
    </table>

    <!-- 페이징 처리 -->
    <nav aria-label="Page navigation" class="pagination-nav" style="margin-top: 20px;">
      <ul class="pagination justify-content-center">
        <!-- 이전 페이지로 이동 -->
        <li class="page-item ${currentPage == 1 ? 'disabled' : ''}">
          <a class="page-link" href="?page=${currentPage > 1 ? currentPage - 1 : 1}" aria-label="Previous">
            <span aria-hidden="true">&laquo;</span>
          </a>
        </li>
        <%-- 
            - '이전' 버튼은 현재 페이지가 1보다 클 때만 활성화됩니다. 
            - 현재 페이지가 1페이지일 경우 'disabled' 클래스를 추가하여 비활성화 상태로 만듭니다.
            - 버튼 클릭 시, 이전 페이지로 이동합니다.
        --%>

        <!-- 페이지 번호 출력 -->
        <c:forEach begin="${startPage}" end="${endPage}" var="i">
            <li class="page-item ${i == currentPage ? 'active' : ''}">
              <a class="page-link" href="?page=${i}">${i}</a>
            </li>
        </c:forEach>
        <%-- 
            - startPage부터 endPage까지의 페이지 번호를 출력합니다.
            - 현재 페이지는 'active' 클래스를 적용하여 강조되며, 나머지 페이지는 일반 버튼으로 표시됩니다.
        --%>

        <!-- 다음 페이지로 이동 -->
        <li class="page-item ${currentPage == totalPages ? 'disabled' : ''}">
          <a class="page-link" href="?page=${currentPage < totalPages ? currentPage + 1 : totalPages}" aria-label="Next">
            <span aria-hidden="true">&raquo;</span>
          </a>
        </li>
        <%-- 
            - '다음' 버튼은 현재 페이지가 마지막(totalPages)보다 작을 때만 활성화됩니다.
            - 현재 페이지가 마지막 페이지일 경우 'disabled' 클래스를 추가하여 비활성화 상태로 만듭니다.
        --%>
      </ul>
    </nav>

    <script type="text/javascript" src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
    <%-- 
        - jQuery 라이브러리를 포함합니다.
        - jQuery를 사용하여 다양한 동적 이벤트 및 기능을 추가할 수 있습니다.
    --%>
</body>
</html>
