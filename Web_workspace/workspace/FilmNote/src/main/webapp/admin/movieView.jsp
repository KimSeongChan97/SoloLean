<%-- FilmNote/src/main/webapp/admin/movieBoardView.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="../image/film_favicon.png" type="image/png">
<link rel="stylesheet" href="../css/movieView.css">
<title>영화 상세 조회</title>
</head>
<body>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/adminMenu.jsp" />

<c:if test="${sessionScope.adminDTO.aid == 'admin'}">
<div id="movie-detail">


	<!-- 영화 코드, 영화 제목, 영화 감독, 영화 장르, 영화 개봉일, 영화 등급, 영화 평점, 영화 줄거리, 영화 포스터 이미지 -->
	<form name="movie-view-form" id="movie-view-form">
	<input type="hidden" name="pg" id="pg" value="${requestScope.pg }" />
	    <table>
	    	<tr>
	    		<th width="30%">영화 포스터</th>
	    		<th width="20%">영화 코드</th>
	    		<td width="50%" class="info-cell">
	    			${movieDTO.mcode }
	    			<input type="hidden" id="mcode" name="mcode" value="${movieDTO.mcode }" />
	    		</td>
	    	</tr>
	        <tr>
	            <td align="center" rowspan="9" class="poster-cell">
	                <img width="90%" src="${movieDTO.poster }" alt="영화 포스터">
	            </td>
			    <th>영화 제목</th>
			    <td class="info-cell">
			        ${movieDTO.title }
			        <input type="hidden" id="movieTitle" value="${movieDTO.title }" />
			    </td>
	        </tr>
	        <tr>
	        	<th>영화 감독</th>
	            <td class="info-cell">${movieDTO.director }</td>
	        </tr>
	        <tr>
	        	<th>영화 장르</th>
	            <td class="info-cell">${movieDTO.genre }</td>
	        </tr>
	        <tr>
	        	<th>영화 개봉일</th>
	            <td class="info-cell">${movieDTO.release_date }</td>
	        </tr>
	        <tr>
	        	<th>영화 관람가</th>
	            <td class="info-cell">	
	        		<c:if test="${movieDTO.rating == 0}">전체</c:if>
					<c:if test="${movieDTO.rating != 0}">${movieDTO.rating }세</c:if>
	            </td>
	        </tr>
	        <tr>
	        	<th>영화 평점</th>
	            <td class="info-cell">${movieDTO.score }</td>
	        </tr>
	        <tr>
	        	<th>영화 줄거리</th>
	            <td class="info-cell">${movieDTO.synopsis }</td>
	        </tr>
	    </table>
	</form>
	<div class="button-container">
		<button type="button" class="crudBtn" id="movieEditBtn">수정</button> <!-- mcode, pg 가져가야함 -->
		<button type="button" class="crudBtn" id="movieDeleteBtn">삭제</button> <!-- mcode 가져가야함 -->
   		<button class="crudBtn" id="listBtn" >목록</button>
   	</div>
</div>
</c:if>

<c:if test="${sessionScope.adminDTO.aid != 'admin'}">
    <script>
        alert("관리자로 로그인하세요");
        location.href = "${pageContext.request.contextPath}/admin/adminSignIn.do";
    </script>
</c:if>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
    var context = '${pageContext.request.contextPath}';
</script>

<script type="text/javascript" src="../js/movieView.js"></script>
</body>
</html>