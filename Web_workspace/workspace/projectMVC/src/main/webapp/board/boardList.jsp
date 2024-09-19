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
<style type="text/css">
table {
    border-collapse: collapse; /* 테이블의 셀 간 경계선을 하나로 합칩니다 */
}
th, td{
    padding:7px; /* 셀 안의 내용을 일정한 간격으로 배치하여 가독성을 높입니다 */
}

#currentPaging {
    /* 현재 페이지를 표시하는 스타일 */
	border: 1px solid blue;
	color: red;
	font-size: 15pt;
	padding: 5px 8px;
}

#paging {
    /* 다른 페이지 번호를 표시하는 스타일 */
	border: 1px solid blue;
	color: black;
	font-size: 15pt;
	padding: 5px 8px;
}

span:hover {
	text-decoration: underline; /* 마우스를 올렸을 때 밑줄 표시 */
}

</style>
</head>
<body>

	<table border="1" frame="hsides" >
        <tr>
            <th width="100"> 글번호 </th>
            <th width="400"> 제목 </th>
            <th width="150"> 작성자 </th>
            <th width="150"> 작성일 </th>
            <th width="100"> 조회수 </th>
        </tr>
        
        <% 
            List<BoardDTO> list = (List<BoardDTO>) request.getAttribute("list");
            if (list != null) {
                for (BoardDTO boardDTO : list) { 
        %>
                <tr>
                    <td align="center"><%=boardDTO.getSeq() %></td>
                    <td><%=boardDTO.getSubject() %></td>
                    <td align="center"><%=boardDTO.getId() %></td>
                    <td align="center"><%=boardDTO.getLogtime() %></td>
                    <td align="center"><%=boardDTO.getHit() %></td>
                </tr>
        <% 
                } 
            } 
        %>
    </table>
    
    <div onclick="location.href='/projectMVC/index.do'" align="center" style="cursor: pointer;">
        index로 
    </div>
    
    <hr/> 
    
    <div style="text-align: center; width: 800px; margin-top: 15px;" >
        <%= ((BoardPaging) request.getAttribute("boardPaging")).getPagingHTML() %>
    </div>
    
<script type="text/javascript">
    function boardPaging(pg){
        location.href = "boardList.do?pg=" + pg;
    };
</script>
</body>
</html>
