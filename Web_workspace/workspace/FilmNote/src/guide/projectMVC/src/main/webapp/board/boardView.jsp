<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/index.css">
<style type="text/css">
table {
	border:  collapse;
}

th, td {
	padding: 10px;
}

#boardViewForm {
	display: flex;
	flex-direction: column;
	align-items: center;
	margin-top: 30px 0;
	
}

</style>
</head>
<body>
	<div id="wrap">
		<div id="header">
			<h1>
				<img alt="사과"
					src="${ pageContext.request.contextPath }/image/apple.png"
					width="50" height="50"
					onclick="location.href='${ pageContext.request.contextPath }/index.do'"
					style="cursor: pointer;"> MVC를 활용한 미니프로젝트

			</h1>
			<hr style="border-color: #483D8B; border-width: 3px;" />
			<!-- 스타일이 적용된 수평선을 추가합니다. border-color는 선의 색상을 지정하며, border-width는 선의 굵기를 지정합니다. -->
		</div>

		<div id="container">
			<jsp:include page="../main/boardMenu.jsp" />
			<!-- 다른 JSP 파일인 boardMenu.jsp 파일을 현재 위치에 포함시킵니다. 이 코드는 주로 메뉴바 같은 공통 요소를 삽입할 때 사용됩니다. -->

			<div id="section" class="boardViewDiv">

				<form id="boardViewForm">

					<table border="1" frame="hsides" rules="rows">

						<tr>
							<td colspan="3">
							<h2>${boardDTO.subject }</h2>
							</td>

						</tr>

						<tr>
							<td width="200">글번호 : ${boardDTO.seq }</td>
							<td width="200">작성자 : ${boardDTO.id }</td>
							<td width="200">조회수 : ${boardDTO.hit }</td>
							<!-- 작성한 글을 확인할 때 마다 조회수 증가 : 함수 hitUpdate() 사용 -->
						</tr>
						
						<tr>
							<td height="300" colspan="3" valign="top" style="white-space: pre-wrap;">
								${boardDTO.content } 
							</td>

						</tr>
						
					</table>
					
					<div style="width:650px; margin-top: 1px;" >
						<input type="button" value="목록" 
								onclick="location.href='/projectMVC/board/boardList.do?pg=${pg}'">
						
						<c:if test="${boardDTO.id == sessionScope.memId}">
						    <!-- 글 수정 및 삭제 버튼 -->
						    <input type="button" value="게시글 수정" onclick="location.href='/projectMVC/board/boardUpdate.do?seq=${boardDTO.seq}'">
						    <input type="button" value="게시글 삭제" onclick="location.href='/projectMVC/board/boardDelete.do?seq=${boardDTO.seq}'">
						</c:if>
						
					</div> <!-- 기타 버튼 -->
					
				</form>
			</div>
			<!-- id="section" -->
		</div>
		<!-- id="container" -->
	</div>
	<!-- id="wrap" -->
</body>
</html>