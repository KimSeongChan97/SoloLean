<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/index.css">
<!-- 외부 CSS 파일을 연결합니다. pageContext.request.contextPath는 현재 웹 애플리케이션의 컨텍스트 경로를 나타냅니다. 
     예를 들어, 프로젝트가 http://localhost:8080/projectMVC 라는 URL로 서비스되고 있다면, 
     ${ pageContext.request.contextPath }는 /projectMVC로 대체되어 CSS 파일의 경로를 올바르게 설정해줍니다. -->

<style type="text/css">
table {
	border: collapse;
	/* 테이블의 테두리가 서로 겹쳐지지 않도록 collapse 설정을 사용합니다. */
}

th, td {
	padding: 10px;
	/* 테이블의 셀 안에 여백을 주어 내용을 보기 좋게 만듭니다. */
}

#boardViewForm {
	display: flex;
	flex-direction: column;
	align-items: center;
	margin-top: 30px 0;
	/* 게시글 뷰 폼을 화면 중앙에 정렬하고, 위아래로 여백을 추가합니다. */
}
/* 
     flex-direction: column;은 자식 요소들을 수직으로 나열하며, 
     align-items: center;는 요소들을 수평으로 중앙에 정렬합니다. 
     이렇게 하면 테이블과 버튼들이 화면 가운데에 일관성 있게 배치됩니다. */
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
					style="cursor: pointer;">
				<!-- 클릭하면 홈으로 이동하도록 설정된 이미지입니다. -->
				<!-- 이미지의 크기는 50x50으로 설정되었고, 클릭 시 index.do 페이지로 이동합니다.
				     style="cursor: pointer;"는 마우스를 올렸을 때 포인터 커서가 보이도록 설정한 부분입니다. -->
				
				MVC를 활용한 미니프로젝트
			</h1>
			<hr style="border-color: #483D8B; border-width: 3px;" />
			<!-- 스타일이 적용된 수평선을 추가합니다. 
			     border-color는 선의 색상을 지정하며, border-width는 선의 굵기를 지정합니다.
			     여기서는 3픽셀 두께의 어두운 블루(#483D8B) 색상이 사용되었습니다. -->
			<!-- 이 부분은 페이지의 헤더를 구성합니다. 로고 이미지와 프로젝트 제목을 포함하고 있습니다. -->
		</div>

		<div id="container">
			<jsp:include page="../main/boardMenu.jsp" />
			<!-- 다른 JSP 파일인 boardMenu.jsp 파일을 현재 위치에 포함시킵니다. 
			     이 코드는 주로 메뉴바 같은 공통 요소를 삽입할 때 사용됩니다. 
			     이렇게 하면 메뉴를 여러 페이지에 중복해서 작성할 필요 없이 한 파일로 관리할 수 있어 유지보수에 유리합니다. -->
			<!-- 이 include 문은 게시판 메뉴를 포함시켜 페이지의 일관성을 유지합니다. -->

			<div id="section" class="boardViewDiv">
				<form id="boardViewForm">
					
					<input type="hidden" id="memId" value="${sessionScope.memId }" />
					<!-- 세션 값을 유지하기 위해 가져옴 -->
					<!-- 현재 로그인한 사용자의 ID를 hidden 필드로 저장합니다. 이는 JavaScript에서 사용될 수 있습니다.
					     hidden 필드는 화면에는 표시되지 않지만, 자바스크립트나 서버로 데이터를 전송할 때 활용됩니다. -->
					
					<input type="hidden" name="seq" value="${boardDTO.seq }" />
					<input type="hidden" name="pg" value="${requestScope.pg }" />
					<!-- seq는 게시글 번호, pg는 페이지 정보를 의미하며, hidden 필드로 저장하여 서버로 전송하거나 
					     JavaScript에서 사용할 수 있도록 준비해 둡니다. -->
					
					<table border="1" frame="hsides" rules="rows">
						<!-- 테이블을 생성하고, border="1"로 테두리를 추가합니다.
						     frame="hsides"는 테이블의 상단과 하단에만 테두리를 표시하고, 
						     rules="rows"는 각 행(row)을 구분하는 선을 추가하는 속성입니다. -->

						<tr>
							<td colspan="3">
							<h2>${boardDTO.subject }</h2>
							<!-- ${boardDTO.subject}는 게시글의 제목을 출력하는 부분입니다. -->
							</td>
						</tr>

						<tr>
							<td width="200">글번호 : ${boardDTO.seq }</td>
							<!-- 글번호는 게시글의 고유한 식별자입니다. -->
							<td width="200">작성자 : <span id="id">${boardDTO.id }</span></td>
							<!-- 작성자의 ID를 출력하고, span 태그로 감싸서 이후에 JavaScript에서 접근할 수 있도록 합니다. -->
							<td width="200">조회수 : ${boardDTO.hit }</td>
							<!-- 조회수는 해당 게시글이 몇 번 조회되었는지를 나타냅니다. -->
						</tr>
						
						<tr>
							<td height="300" colspan="3" valign="top" >
								<div style="width: 100%; height:100%; overflow: auto;">
									<pre style="white-space: pre-line; word-break: break-all;">
										${boardDTO.content }
										<!-- 게시글의 내용을 표시하는 부분입니다. -->
										<!-- white-space: pre-line;을 사용해 게시글의 줄바꿈을 유지하고, -->
										<!-- word-break: break-all;로 긴 단어들도 자동으로 줄바꿈이 되도록 설정합니다. -->
									</pre> 
								</div>
							</td>
						</tr>
					</table>

					<div style="width:650px; margin-top: 1px;" >
						<input type="button" value="목록" 
								onclick="location.href='/projectMVC/board/boardList.do?pg=${pg}'">
						<!-- 목록 버튼은 게시글 목록 페이지로 이동합니다.
						     ${pg}는 현재 페이지 번호를 유지하여, 목록 페이지에서 원래 위치로 돌아갈 수 있도록 합니다. -->
						
						<%-- <c:if test="${boardDTO.id == sessionScope.memId}"> --%>
						    <span id="boardViewSpan">
						    <!-- 글 수정 및 삭제 버튼 -->
						    <%-- <input type="button" value="게시글 수정" onclick="location.href='/projectMVC/board/boardUpdate.do?seq=${boardDTO.seq}'">
						    <input type="button" value="게시글 삭제" onclick="location.href='/projectMVC/board/boardDelete.do?seq=${boardDTO.seq}'"> --%>
						    <input type="button" value="게시글 수정" id="boardUpdateFormBtn"> 
						    <!-- 게시글 수정 버튼입니다. 클릭 시 JavaScript로 이벤트가 처리되며,
						         seq (게시글 번호)와 pg (페이지 번호)의 값을 전달하여 수정 화면으로 이동합니다. -->
						    
						    <input type="button" value="게시글 삭제" id="boardDeleteFormBtn"> 
						    <!-- 게시글 삭제 버튼입니다. 클릭 시 JavaScript에서 seq의 값을 가지고 삭제 작업이 수행됩니다. -->
							</span>
						<%-- </c:if> --%>
					</div> <!-- 기타 버튼 -->
				</form>
			</div>
			<!-- id="section" -->
		</div>
		<!-- id="container" -->
	</div>
	<!-- id="wrap" -->
	
	<script src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
	<!-- jQuery 라이브러리를 로드합니다. 여기서 jQuery는 3.7.1 버전을 사용하고 있습니다. 
	     이 라이브러리를 통해 JavaScript의 기능을 더욱 쉽게 사용할 수 있습니다. -->
	
	<script type="text/javascript" src="../js/boardView.js"></script>
	<!-- 사용자 정의 JavaScript 파일을 로드합니다. boardView.js 파일은 이 페이지의 동적 기능을 담당하는 스크립트입니다. -->
</body>
</html>
