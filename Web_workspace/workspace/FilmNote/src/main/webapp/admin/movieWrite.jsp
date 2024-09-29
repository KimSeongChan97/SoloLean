<%-- FilmNote/src/main/webapp/admin/movieWrite.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%-- JSTL 라이브러리 사용을 위한 선언 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%-- 페이지에 UTF-8 인코딩 적용 --%>
<link rel="icon" href="../image/film_favicon.png" type="image/png">
<%-- 파비콘(favicon) 설정 --%>
<link rel="stylesheet" href="../css/movieWrite.css">
<%-- CSS 파일 링크 --%>
<title>영화 등록</title>
<%-- 페이지 제목 --%>
</head>
<body>
<jsp:include page="../common/header.jsp" />
<%-- 공통 헤더 파일 포함 --%>
<jsp:include page="../common/adminMenu.jsp" />
<%-- 관리자 메뉴 파일 포함 --%>

<c:if test="${sessionScope.adminDTO.aid == 'admin'}">
<%-- 로그인한 사용자가 admin인 경우에만 아래 내용이 표시됨 --%>

	<div id="movie-write">
		<input type="hidden" name="pg" id="pg" value="${requestScope.pg }" />
		<%-- 현재 페이지 정보(hidden 필드로 저장) --%>
		
		<!-- 영화 제목, 감독, 장르, 개봉일, 등급, 평점, 줄거리, 포스터 이미지를 입력받는 폼 -->
		<form name="movie-write-form" id="movie-write-form">
		    <table>
		    	<tr>
		    		<th width="30%">영화 포스터</th> 
		    		<%-- 영화 포스터 등록을 위한 입력 필드 --%>
				    <th width="20%">영화 제목</th>
				    <td width="50%" class="info-cell">
				    	<input type="text" name="movieTitle" class="movieInput" id="movieTitle" />
				    	<div class="validationDiv" id="movieTitleDiv"></div>
				    	<%-- 영화 제목 입력란과 유효성 검사 결과를 표시할 영역 --%>
				    </td>		    		
		    	</tr>
		        <tr>
		            <td align="center" rowspan="9" class="poster-cell">
		            	<%-- 영화 포스터 미리보기 이미지 --%>
						<img id="showImg" width="257" height="366" />
	                	<label for="moviePoster">
			                <div id="fileInput">
			                	<%-- 포스터 파일 업로드 버튼 --%>
		                		<div id="fileIcon">📁
				                	<input type="file" name="moviePoster" class="movieInput" id="moviePoster" style="display: none;"/>
		                		</div>
				                <div id="fileNotice">영화 포스터 등록</div>
			                </div>
		                </label>
		    			<div class="validationDiv" id="moviePosterDiv"></div>
		    			<%-- 포스터 등록 시 유효성 검사를 표시할 영역 --%>
		            </td>
		        	<th>영화 감독</th>
		            <td class="info-cell">
		            	<input type="text" name="movieDirector" class="movieInput" id="movieDirector" />
		            	<div class="validationDiv" id="movieDirectorDiv"></div>
		            	<%-- 영화 감독 입력란과 유효성 검사 결과를 표시할 영역 --%>
		            </td>
		        </tr>
		        <tr>
		        	<th>영화 장르</th>
		            <td class="info-cell">
		            	<input type="text" name="movieGenre" class="movieInput" id="movieGenre" />
		            	<div class="validationDiv" id="movieGenreDiv"></div>
		            	<%-- 영화 장르 입력란과 유효성 검사 결과를 표시할 영역 --%>
		            </td>
		        </tr>
		        <tr>
		        	<th>영화 개봉일</th>
		            <td class="info-cell">
		            	<input type="text" name="movieReleaseDate" class="movieInput" id="movieReleaseDate" />
		            	<div class="validationDiv" id="movieReleaseDateDiv"></div>
		            	<%-- 영화 개봉일 입력란과 유효성 검사 결과를 표시할 영역 --%>
		            </td>
		        </tr>
		        <tr>
		        	<th>영화 관람가</th>
		            <td class="info-cell">	
		            	<input type="text" name="movieRating" class="movieInput" id="movieRating" />
		            	<div class="validationDiv" id="movieRatingDiv"></div>
		            	<%-- 영화 관람가 입력란과 유효성 검사 결과를 표시할 영역 --%>
		            </td>
		        </tr>
		        <tr>
		        	<th>영화 평점</th>
		            <td class="info-cell">
		            	<input type="text" name="movieScore" class="movieInput" id="movieScore" />
		            	<div class="validationDiv" id="movieScoreDiv"></div>
		            	<%-- 영화 평점 입력란과 유효성 검사 결과를 표시할 영역 --%>
		            </td>
		        </tr>
		        <tr>
		        	<th>영화 줄거리</th>
		            <td class="info-cell">
		            	<textarea name="movieSynopsis" class="movieInput" id="movieSynopsis" rows="5" cols="60"></textarea>
		            	<div class="validationDiv" id="movieSynopsisDiv"></div>
		            	<%-- 영화 줄거리 입력란과 유효성 검사 결과를 표시할 영역 --%>
		            </td>
		        </tr>
		    </table>
		</form>
	</div>

	<!-- 영화 등록, 초기화, 목록 버튼 -->
	<div class="button-container" style="width:1000px; display: flex; justify-content: flex-end;">
		<button type="button" class="crudBtn" id="movieWriteBtn">등록</button> 
		<%-- 영화 등록 버튼 --%>
		<button type="reset" class="crudBtn" id="resetBtn">초기화</button>
		<%-- 폼 입력값 초기화 버튼 --%>
		<button type="button" class="crudBtn" id="listBtn">목록</button>
		<%-- 영화 목록으로 돌아가는 버튼 --%>
	</div>
</c:if>

<!-- 관리자가 아닌 경우 로그인 페이지로 리다이렉트 -->
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

<!-- 외부 자바스크립트 파일 연결 -->
<script type="text/javascript" src="../js/movieWrite.js"></script>
</body>
</html>
