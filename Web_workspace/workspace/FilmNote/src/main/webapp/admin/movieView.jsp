<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="../image/film_favicon.png" type="image/png">
<link rel="stylesheet" href="../css/movieView.css"> <!-- 영화 상세 조회 페이지 스타일 연결 -->
<title>영화 상세 조회</title>
</head>
<body>
<jsp:include page="../common/header.jsp" /> <!-- 공통 헤더 파일 포함 -->
<jsp:include page="../common/adminMenu.jsp" /> <!-- 관리자 메뉴 포함 -->

<!-- 세션에서 관리자로 로그인한 경우에만 영화 상세 정보를 보여줌 -->
<c:if test="${sessionScope.adminDTO.aid == 'admin'}">
<div id="movie-detail">

	<!-- 영화 상세 정보를 표시하는 폼 -->
	<form name="movie-view-form" id="movie-view-form">
	<input type="hidden" name="pg" id="pg" value="${requestScope.pg }" /> <!-- 현재 페이지 정보를 hidden 필드로 저장 -->
	    <table>
	    	<tr>
	    		<th width="30%">영화 포스터</th>
	    		<th width="20%">영화 코드</th>
	    		<!-- 영화 코드 정보는 화면에 출력하고 hidden 필드로도 저장 -->
	    		<td width="50%" class="info-cell">
	    			${movieDTO.mcode }
	    			<input type="hidden" id="mcode" name="mcode" value="${movieDTO.mcode }" />
	    		</td>
	    	</tr>
	        <tr>
	            <!-- 영화 포스터 이미지 출력 -->
	            <td align="center" rowspan="9" class="poster-cell">
	                <img width="90%" src="${movieDTO.poster }" alt="영화 포스터">
	            </td>
			    <th>영화 제목</th>
			    <!-- 영화 제목 출력과 hidden 필드에 제목 저장 -->
			    <td class="info-cell">
			        ${movieDTO.title }
			        <input type="hidden" id="movieTitle" value="${movieDTO.title }" />
			    </td>
	        </tr>
	        <tr>
	        	<!-- 영화 감독 출력 -->
	        	<th>영화 감독</th>
	            <td class="info-cell">${movieDTO.director }</td>
	        </tr>
	        <tr>
	        	<!-- 영화 장르 출력 -->
	        	<th>영화 장르</th>
	            <td class="info-cell">${movieDTO.genre }</td>
	        </tr>
	        <tr>
	        	<!-- 영화 개봉일 출력 -->
	        	<th>영화 개봉일</th>
	            <td class="info-cell">${movieDTO.release_date }</td>
	        </tr>
	        <tr>
	        	<!-- 영화 관람가 출력 -->
	        	<th>영화 관람가</th>
	            <td class="info-cell">	
	        		<!-- 관람 등급이 0이면 전체 관람가로 표시 -->
	        		<c:if test="${movieDTO.rating == 0}">전체</c:if>
					<c:if test="${movieDTO.rating != 0}">${movieDTO.rating }세</c:if>
	            </td>
	        </tr>
	        <tr>
	        	<!-- 영화 평점 출력 -->
	        	<th>영화 평점</th>
	            <td class="info-cell">${movieDTO.score }</td>
	        </tr>
	        <tr>
	        	<!-- 영화 줄거리 출력 -->
	        	<th>영화 줄거리</th>
	            <td class="info-cell">${movieDTO.synopsis }</td>
	        </tr>
	    </table>
	</form>

	<!-- 영화 수정, 삭제, 목록 버튼 -->
	<div class="button-container">
		<button type="button" class="crudBtn" id="movieEditBtn">수정</button> <!-- 수정 버튼 클릭 시 수정 페이지로 이동 -->
		<button type="button" class="crudBtn" id="movieDeleteBtn">삭제</button> <!-- 삭제 버튼 클릭 시 영화 삭제 -->
   		<button class="crudBtn" id="listBtn">목록</button> <!-- 목록 버튼 클릭 시 영화 목록 페이지로 이동 -->
   	</div>
</div>
</c:if>

<!-- 관리자로 로그인하지 않은 경우 로그인 페이지로 이동 -->
<c:if test="${sessionScope.adminDTO.aid != 'admin'}">
    <script>
        alert("관리자로 로그인하세요");
        location.href = "${pageContext.request.contextPath}/admin/adminSignIn.do";
    </script>
</c:if>

<!-- jQuery 라이브러리 추가 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

<!-- contextPath를 자바스크립트 변수에 저장 -->
<script>
    var context = '${pageContext.request.contextPath}';
</script>

<!-- 외부 자바스크립트 파일(movieView.js) 연결 -->
<script type="text/javascript" src="../js/movieView.js"></script>
</body>
</html>
