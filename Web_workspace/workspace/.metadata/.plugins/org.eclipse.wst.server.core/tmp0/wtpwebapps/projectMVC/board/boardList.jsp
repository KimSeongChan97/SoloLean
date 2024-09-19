<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="board.bean.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="board.bean.BoardPaging"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판 목록</title>  
    <!-- 커스텀 CSS 파일을 적용 -->
    <link rel="stylesheet" href="${ pageContext.request.contextPath }/css/boardlist.css?v=1.0">
</head>
<body>

    <!-- 게시판 목록 테이블 -->
    <table class="table table-dark table-hover">
        <thead>
            <tr>
                <th scope="col">글번호</th>
                <th scope="col">제목</th>
                <th scope="col">작성자</th>
                <th scope="col">작성일</th>
                <th scope="col">조회수</th>
            </tr>
        </thead>
        <tbody>
        <% 
            // DB에서 가져온 게시글 목록을 출력
            List<BoardDTO> list = (List<BoardDTO>) request.getAttribute("list");
            if (list != null) {
                for (BoardDTO boardDTO : list) { 
        %>
            <tr>
                <td align="center"><%= boardDTO.getSeq() %></td>
                <td><%= boardDTO.getSubject() %></td>
                <td align="center"><%= boardDTO.getId() %></td>
                <td align="center"><%= boardDTO.getLogtime() %></td>
                <td align="center"><%= boardDTO.getHit() %></td>
            </tr>
        <% 
                } 
            } 
        %>
        </tbody>
    </table>

    <!-- 메인 페이지로 이동하는 링크 -->
    <div onclick="location.href='/projectMVC/index.do'" align="center" style="cursor: pointer;">
        index로 
    </div>
    
    <hr/>

    <!-- 페이지네이션 표시 부분 -->
    <div style="text-align: center; width: 800px; margin-top: 15px;">
        <%= ((BoardPaging) request.getAttribute("boardPaging")).getPagingHTML() %>
    </div>

<!-- JavaScript를 이용해 페이지를 넘기는 함수 -->
<script type="text/javascript">
    // 선택한 페이지로 이동하는 함수
    function boardPaging(pg) {
        location.href = "boardList.do?pg=" + pg;
    };
</script>

</body>
</html>
