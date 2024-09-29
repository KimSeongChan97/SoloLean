<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<link rel="icon" href="../image/film_favicon.png" type="image/png">
<link rel="stylesheet" href="../css/movieList.css"> <!-- 영화 목록 페이지의 스타일시트를 연결 -->
<title>영화 목록</title> <!-- 페이지 제목 -->
</head>
<body>
<jsp:include page="../common/header.jsp" /> <!-- 공통 헤더 포함 -->
<jsp:include page="../common/adminMenu.jsp" /> <!-- 관리자 메뉴 포함 -->

<!-- 관리자로 로그인한 경우에만 영화 목록 페이지를 볼 수 있음 -->
<c:if test="${sessionScope.adminDTO.aid == 'admin'}">
<input type="hidden" id="adminId" value="${sessionScope.adminDTO.aid }" />  
<input type="hidden" id="pg" value="${requestScope.pg }" /> <!-- 현재 페이지 번호를 hidden 필드로 전달 -->

<!-- 영화 삭제와 검색 기능을 위한 카드 -->
<div class="card">
	<div id="card-title">영화 삭제 & 검색</div> <!-- 카드 제목 -->
	<div id="card-content">
		<!-- 선택한 영화를 삭제하는 버튼 -->
		<button type="submit" id="deleteBtn" class="cardBtn">선택 삭제</button>
		
		<!-- 영화 검색을 위한 검색 옵션과 입력 필드 -->
		<div id="search-div">
			<select class="search-opt">
			    <optgroup label="검색 항목">
			        <!-- 검색 옵션: 영화 코드, 영화 제목, 영화 감독 -->
			        <option value="movie-code">영화 코드</option>
			        <option value="movie-title" selected="selected">영화 제목</option>
			        <option value="movie-director">영화 감독</option>
			    </optgroup>
			</select>
			<!-- 검색어를 입력할 수 있는 텍스트 필드 -->
			<input id="title-box" class="input-box"/>
			<!-- 검색 버튼 -->
			<button id="searchBtn" class="cardBtn">검색</button>
		</div>
	</div>
</div>

<!-- 영화 목록을 표시하는 테이블 -->
<table>
	<tr>
		<!-- 테이블 헤더: 영화 코드, 영화 제목, 영화 감독, 영화 관람가 -->
		<th width="20%">
			<!-- 모든 영화를 선택할 수 있는 체크박스 -->
			<input type="checkbox" id="all_check" class="check-size" /> 영화 코드
		</th>
		<th width="30%">영화 제목</th>
		<th width="30%">영화 감독</th>
		<th width="20%">영화 관람가</th>
	</tr>
	
	<!-- 영화 목록 데이터를 담을 tbody -->
	<tbody id="movieTableBody">
		<!-- requestScope에 영화 목록이 있을 경우에만 목록을 출력 -->
		<c:if test="${requestScope.list != null }"> 
			<!-- 각 영화 데이터를 반복 출력 -->
			<c:forEach var="movieDTO" items="${list }">
				<tr>
					<!-- 영화 코드와 해당 영화를 선택할 수 있는 체크박스 -->
					<td align="center">
						<input type="checkbox" name="mcode" class="board-list-check" value="${movieDTO.mcode}" /> 
						${movieDTO.mcode } <!-- 영화 코드 출력 -->
						<input type="hidden" id="mcode" value="${movieDTO.mcode }" />
					</td>      
					<!-- 영화 제목: 제목 클릭 시 상세 정보 페이지로 이동 가능 -->
					<td align="left">
						<a href="#" class="subject-a">${movieDTO.title }</a>
					</td>
					<!-- 영화 감독 -->
					<td align="center">
						${movieDTO.director }
					</td>
					<!-- 영화 관람가: 관람 등급이 0인 경우 '전체'로 출력 -->
					<td align="center">
						<c:if test="${movieDTO.rating == 0}">전체</c:if>
						<c:if test="${movieDTO.rating != 0}">${movieDTO.rating }세</c:if>
					</td>
				</tr> 	    
	 	    </c:forEach>
		</c:if> 
	</tbody>
</table>

<!-- 페이징 처리 영역: 영화 목록의 페이징을 위한 HTML을 출력 -->
<div id="list-page-block" class="page-block">${moviePaging.pagingHTML }</div>
<!-- 검색 결과에 대한 페이징 영역 (처음에는 숨김 처리됨) -->
<div id="select-page-block" class="page-block" style="display:none;"></div>
</c:if>

<!-- 관리자가 아닌 경우 로그인 페이지로 리다이렉트 -->
<c:if test="${sessionScope.adminDTO.aid != 'admin'}">
    <script>
        alert("관리자로 로그인하세요");
        location.href = "${pageContext.request.contextPath}/admin/adminSignIn.do";
    </script>
</c:if>

<!-- jQuery 라이브러리 연결 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

<!-- 현재 웹 애플리케이션의 context path를 자바스크립트 변수에 저장 -->
<script>
    var context = '${pageContext.request.contextPath}';
</script>

<!-- 외부 자바스크립트 파일(movieList.js) 연결 -->
<script type="text/javascript" src="../js/movieList.js"></script>
</body>
</html>
