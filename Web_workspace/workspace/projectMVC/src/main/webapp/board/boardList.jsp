<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<!-- 커스텀 CSS 파일을 적용 -->
<!-- (추가 설명) 여기서 pageContext.request.contextPath는 현재 웹 애플리케이션의 루트 경로를 의미합니다.
         따라서 /css/boardlist.css?v=1.0 파일을 가져와서 스타일을 적용하게 됩니다.
         "?v=1.0"은 버전 관리를 통해 캐시 문제를 방지하기 위한 방법입니다. -->
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/boardlist.css?v=1.0">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/index.css">	
</head>
<body>

	<div id="wrap">
		<div id="header">
			<!-- 페이지의 상단 헤더 영역입니다. -->
			<h1>
				<img alt="사과" src="${ pageContext.request.contextPath }/image/apple.png" 
				width="50" height="50" style="cursor: pointer;" >
				<!-- 헤더 안에 사과 이미지를 삽입합니다. 이미지의 크기는 50x50으로 고정됩니다. -->
				MVC를 활용한 미니프로젝트
				<!-- 페이지 제목입니다. 헤더 안에 텍스트로 표시됩니다. -->
			</h1>
			<jsp:include page="../main/menu.jsp" />
			<!-- menu.jsp 파일을 현재 페이지에 포함시킵니다. 이는 공통 메뉴를 사용할 때 유용하며, JSP 페이지에서 다른 JSP 파일을 동적으로 포함시킬 수 있는 방법입니다. -->
		</div>	
		<div id="container">
			<div id="nav">
				<!-- 네비게이션 영역입니다. 페이지의 좌측에 배치되며, 메뉴 등을 포함합니다. -->
				<jsp:include page="../main/nav.jsp" />
				<!-- nav.jsp 파일을 현재 페이지에 포함시킵니다. 이 영역에는 네비게이션 메뉴가 표시됩니다. -->
			</div>
			<div id="section">
				<!-- 게시판 목록 테이블 -->
				<!-- (추가 설명) 이 테이블은 게시판의 게시글 목록을 보여줍니다. 테이블은 bootstrap 클래스를 이용하여
         어두운 테마의 테이블로 꾸며져 있습니다. -->
				<table class="table table-dark table-hover">
					<thead>
						<!-- (추가 설명) thead 태그 안에서는 테이블의 머리글을 정의합니다. 여기서 각 열의 제목을 설정합니다. -->
						<tr>
							<th scope="col">글번호</th>
							<!-- (추가 설명) 게시글의 번호를 표시하는 열 -->
							<th scope="col">제목</th>
							<!-- (추가 설명) 게시글의 제목을 표시하는 열 -->
							<th scope="col">작성자</th>
							<!-- (추가 설명) 게시글을 작성한 작성자의 ID를 표시하는 열 -->
							<th scope="col">작성일</th>
							<!-- (추가 설명) 게시글이 작성된 날짜를 표시하는 열 -->
							<th scope="col">조회수</th>
							<!-- (추가 설명) 게시글이 몇 번 조회되었는지 조회수를 표시하는 열 -->
						</tr>
					</thead>
					<tbody>

						<!-- (추가 설명) JSP의 JSTL 문법을 사용하여 조건부 렌더링을 수행합니다.
        	 'list'라는 객체가 requestScope에 존재할 경우에만 테이블의 데이터가 렌더링됩니다. -->
						<c:if test="${requestScope.list != null }">
							<!-- (추가 설명) 'list' 객체가 null이 아닌 경우 forEach 루프를 사용하여 목록을 순회합니다.
        		 여기서 'list'는 boardDTO 객체의 목록이며, 이 목록에 포함된 각 게시글의 정보를 출력합니다. -->
							<c:forEach var="boardDTO" items="${list }">

								<tr>
									<!-- (추가 설명) 각 게시글의 글번호를 출력하는 부분입니다.
                	 boardDTO의 seq 값이 테이블의 해당 셀에 출력됩니다. -->
									<td align="center">${boardDTO.seq }</td>
									<!-- (추가 설명) 각 게시글의 제목을 출력하는 부분입니다.
                	 제목은 boardDTO 객체의 subject 속성에서 가져옵니다. -->
									<td><a href="#" class="subjectA">${boardDTO.subject }</a></td>
									
									
									<!-- (추가 설명) 게시글 작성자의 ID를 출력하는 부분입니다.
                	 boardDTO 객체의 id 속성을 사용하여 작성자를 표시합니다. -->
									<td align="center">${boardDTO.id }</td>
									<td align="center">
										<!-- (추가 설명) 작성일을 포맷팅하여 출력하는 부분입니다. 
                	     JSTL의 fmt:formatDate 태그를 사용하여 날짜 형식을 "yyyy.MM.dd"로 변환하여 출력합니다.
                	     logtime은 작성된 시간을 의미하는 속성입니다. --> <fmt:formatDate
											pattern="yyyy.MM.dd" value="${boardDTO.logtime }" />
									</td>
									<!-- (추가 설명) 게시글의 조회수를 출력하는 부분입니다.
                	 조회수는 boardDTO 객체의 hit 속성에서 가져옵니다. -->
									<td align="center">${boardDTO.hit }</td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
				<!-- table table-dark table-hover -->
			</div>
			<!-- id="section" -->
		</div>
		<!-- id="container" -->
	</div>
	<!-- id="wrap" -->

	<!-- 메인 페이지로 이동하는 링크 -->
	<div onclick="location.href='/projectMVC/index.do'" align="center"
		style="cursor: pointer;">index</div>
	<br />
	<!-- 페이지네이션 표시 부분 -->
	<!-- (추가 설명) boardPaging 객체에 있는 pagingHTML 속성을 사용하여 페이지 번호를 표시하는 부분입니다.
         여기서 페이지네이션 처리를 통해 여러 페이지로 나누어진 게시글 목록을 탐색할 수 있습니다. -->
	<div id="list" align="center">${boardPaging.pagingHTML }</div>
	<!-- id="list" -->

	<!-- JavaScript를 이용해 페이지를 넘기는 함수 -->
	<script type="text/javascript">
    // 선택한 페이지로 이동하는 함수
    // (추가 설명) 사용자가 특정 페이지 번호를 클릭하면 해당 페이지 번호로 이동하게 해주는 함수입니다.
    // 'pg'라는 변수로 페이지 번호를 받아와 URL에 붙여서 서버로 요청을 보냅니다.
    // 이 함수는 페이지 번호를 클릭할 때마다 동작하며, 그 번호에 해당하는 게시글 목록을 다시 불러옵니다.
    function boardPaging(pg) {
        location.href = "/projectMVC/board/boardList.do?pg=" + pg;
        // (추가 설명) location.href는 브라우저에서 특정 URL로 이동시키는 역할을 합니다.
        // 여기서는 'pg'에 해당하는 페이지 번호를 쿼리스트링으로 전달하여 해당 페이지 게시글을 로드합니다.
    };
</script>

</body>
</html>
