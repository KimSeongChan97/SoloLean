<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.bean.BoardDTO"%> <!-- BoardDTO 클래스를 임포트하여 사용 -->
<%@ page import="board.bean.BoardPaging"%> <!-- 페이징 처리를 위한 BoardPaging 클래스를 임포트 -->
<%@ page import="board.dao.BoardDAO"%> <!-- 데이터베이스와의 연동을 위한 BoardDAO 클래스를 임포트 -->
<%@page import="java.text.SimpleDateFormat"%> <!-- 날짜 형식을 변환하기 위한 SimpleDateFormat 클래스 임포트 -->
<%@ page import="java.util.List"%> <!-- List 자료구조 사용을 위한 java.util.List 임포트 -->

<%
	int pg = Integer.parseInt(request.getParameter("pg")); 
	// 현재 페이지 번호를 request 파라미터로부터 받아와서 정수형으로 변환.
	// 'pg'는 URL에서 전달된 값으로, 사용자가 보고자 하는 페이지 번호를 나타낸다.
	// 예를 들어, "boardList.jsp?pg=1"이 전달되면 pg는 1이 된다.

	//1페이지당 5개씩
	int endNum = pg * 5;
	// endNum은 해당 페이지의 마지막 게시글 번호로, 페이지 번호(pg)에 따라 다르다.
	// 예를 들어, pg가 1일 때 endNum은 5가 되며, 이는 1페이지에서 5번째 글이 마지막이라는 뜻이다.
	
	int startNum = endNum - 4;
	// startNum은 해당 페이지의 첫 번째 게시글 번호이다.
	// 예를 들어, 1페이지일 경우 startNum은 1이 되고, 2페이지라면 startNum은 6이 된다.

	//DB 연동을 위한 DAO 객체 생성
	BoardDAO boardDAO = BoardDAO.getInstance();
	// DAO는 데이터베이스와의 연동을 담당하는 객체로, 싱글톤 패턴으로 생성된 인스턴스를 사용한다.

	List<BoardDTO> list = boardDAO.boardList(startNum, endNum);
	// boardList 메서드를 호출하여 startNum과 endNum 사이의 게시글 목록을 가져온다.
	// 이 목록은 현재 페이지에 표시될 게시글들이다.
	
	//페이징 처리
	int totalA = boardDAO.getTotalA();
	// 전체 게시글의 수를 데이터베이스에서 조회하여 totalA에 저장한다.

	BoardPaging boardPaging = new BoardPaging();
	// 페이징 처리를 위한 BoardPaging 객체를 생성한다.
	boardPaging.setCurrentPage(pg);
	// 현재 페이지 번호를 설정한다.
	boardPaging.setPageBlock(3);
	// 한 번에 보여줄 페이지 번호의 개수를 설정. 여기서는 3개씩 보여준다.
	boardPaging.setPageSize(5);
	// 한 페이지당 보여줄 게시글 수를 설정. 여기서는 5개로 설정되어 있다.
	boardPaging.setTotalA(totalA);
	// 전체 게시글의 개수를 설정하여 페이징 처리를 위한 정보로 사용한다.
	
	boardPaging.makePagingHTML();
	// 페이징 HTML 코드를 생성한다. 이를 통해 페이지 번호 링크들이 만들어진다.

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
    border-collapse: collapse;
    /* 테이블 경계를 합쳐서 하나로 만든다 */
}
th, td{
    padding: 10px;
    /* 테이블 셀 내부의 여백을 설정한다 */
}
#currentPaging {
	border: 1px solid blue;
	/* 현재 페이지 번호에 파란색 테두리를 설정 */
	color: red;
	/* 현재 페이지 번호의 텍스트 색상을 빨간색으로 설정 */
	font-size: 15pt;
	/* 글자 크기를 15포인트로 설정 */
	padding: 5px 8px;
	/* 안쪽 여백을 설정 */
	margin: 3px;
	/* 바깥쪽 여백을 설정 */
}
#paging {
	color: black;
	/* 일반 페이지 번호의 텍스트 색상을 검정색으로 설정 */
	font-size: 15pt;
	/* 글자 크기를 15포인트로 설정 */
	padding: 5px 8px;
	/* 안쪽 여백을 설정 */
	margin: 3px;
	/* 바깥쪽 여백을 설정 */
}
span:hover {
	text-decoration: underline;
	/* 페이지 번호에 마우스를 올리면 밑줄을 표시 */
}
</style>
</head>
<body>
	<table border="1" frame="hsides" rules="rows">
		<!-- 테이블을 생성하고, 가로선만 표시되도록 설정 -->
		<tr>
			<th width="100">글번호</th> <!-- 글 번호 열 -->
			<th width="400">제목</th> <!-- 제목 열 -->
			<th width="150">작성자</th> <!-- 작성자 열 -->
			<th width="150">작성일</th> <!-- 작성일 열 -->
			<th width="100">조회수</th> <!-- 조회수 열 -->
		</tr>
		
		<!-- list가 null이 아니면 게시글 목록을 출력한다. -->
		<% if(list != null){ %>
			<!-- for문을 사용하여 list에 있는 각 BoardDTO 객체에 대해 반복문을 실행 -->
			<% for(BoardDTO boardDTO : list) { %>
				<tr>
					<td align="center"><%=boardDTO.getSeq() %></td>
					<!-- 게시글 번호를 출력한다. getSeq() 메서드는 게시글의 고유 번호를 반환한다. -->
					<td><%=boardDTO.getSubject() %></td>
					<!-- 게시글 제목을 출력한다. getSubject() 메서드는 제목을 반환한다. -->
					<td align="center"><%=boardDTO.getId() %></td>
					<!-- 게시글 작성자의 ID를 출력한다. getId() 메서드는 작성자의 ID를 반환한다. -->
					<td align="center">
						<!-- 게시글 작성일을 'yyyy.MM.dd' 형식으로 변환하여 출력한다. -->
							<%=new SimpleDateFormat("yyyy.MM.dd").format(boardDTO.getLogtime()) %></td>
					<!-- getLogtime()은 게시글이 작성된 시간을 반환하며, SimpleDateFormat을 사용해 형식을 지정한다. -->
					<td align="center"><%=boardDTO.getHit() %></td>
					<!-- 게시글의 조회수를 출력한다. getHit() 메서드는 해당 게시글의 조회수를 반환한다. -->
				</tr>
			<%}//for %>
		<%}//if %>
	</table>
	
	<!-- 페이지 번호를 출력하는 영역 -->
	<div style="text-align: center; width: 1000px; margin-top: 15px;">
		<%=boardPaging.getPagingHTML() %>
		<!-- 페이징 HTML을 출력한다. getPagingHTML()은 페이징 처리된 페이지 번호들을 포함한 HTML 코드를 반환한다. -->
	</div>
	
<script type="text/javascript">
function boardPaging(pg){
	// 페이지 번호를 클릭할 때 호출되는 자바스크립트 함수.
	// 클릭한 페이지 번호를 매개변수로 받아서 해당 페이지로 이동한다.
	location.href = "boardList.jsp?pg=" + pg;
	// 'boardList.jsp' 페이지로 이동하면서 클릭한 페이지 번호를 'pg' 파라미터로 전달.
}
</script>	
</body>
</html>
