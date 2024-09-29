<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="../image/film_favicon.png" type="image/png">
<link rel="stylesheet" href="../css/movieEdit.css">
<title>영화 수정</title> <!-- 페이지 제목: 영화 수정 -->
</head>
<body>
<jsp:include page="../common/header.jsp" /> <!-- 공통 헤더 파일 포함 -->
<jsp:include page="../common/adminMenu.jsp" /> <!-- 관리자 메뉴 파일 포함 -->

<!-- 관리자 권한이 있는지 확인. aid 값이 'admin'인 경우에만 수정 페이지를 표시 -->
<c:if test="${sessionScope.adminDTO.aid == 'admin'}">

	<div id="movie-edit">
		<!-- 영화 수정 폼: 영화 관련 데이터를 수정할 수 있는 입력 필드들로 구성 -->
		<form name="movie-edit-form" id="movie-edit-form">
		<!-- 영화 코드와 현재 페이지 정보를 hidden 필드로 전달 -->
		<input type="hidden" name="mcode" id="mcode" value="${requestScope.mcode }" />
		<input type="hidden" name="pg" id="pg" value="${requestScope.pg }" />
		    <table>
		    	<tr>
		    		<th width="30%">영화 포스터</th> <!-- 영화 포스터 컬럼 제목 -->
		    		<th width="20%">영화 코드</th> <!-- 영화 코드 컬럼 제목 -->
		    		<td width="50%" class="info-cell">
		    			<!-- 영화 코드는 수정할 수 없도록 readonly 속성을 부여 -->
		    			<input type="text" name="movieCode" class="movieInput" id="movieCode" value="${movieDTO.mcode }" readonly />
		    		</td>
		    	</tr>
		        <tr>
		            <td align="center" rowspan="9" class="poster-cell">
						<!-- 영화 포스터 미리보기 -->
						<div id="showImgDiv">
							<img id="showImg" src="${movieDTO.poster }" alt="영화 포스터" width="257" height="366" />
						</div>
	                	<!-- 파일 선택을 위한 인풋과 그에 대한 설명 -->
	                	<label for="moviePoster">
			                <div id="fileInput">
		                		<div id="fileIcon">📁
				                	<input type="file" name="moviePoster" class="movieInput" id="moviePoster" style="display: none;"/>
		                		</div>
				                <div id="fileNotice">영화 포스터 등록</div>
			                </div>
		                </label>
		    			<div class="validationDiv" id="moviePosterDiv"></div>		                
		            </td>
				    <th>영화 제목</th> <!-- 영화 제목 입력 필드 -->
				    <td class="info-cell">
				    	<input type="text" name="movieTitle" class="movieInput" id="movieTitle" value="${movieDTO.title }" />
				        <div class="validationDiv" id="movieTitleDiv"></div> <!-- 제목 유효성 검사 메시지 -->
				    </td>
		        </tr>
		        <tr>
		        	<th>영화 감독</th> <!-- 영화 감독 입력 필드 -->
		            <td class="info-cell">
		            	<input type="text" name="movieDirector" class="movieInput" id="movieDirector" value="${movieDTO.director }" />
		            	<div class="validationDiv" id="movieDirectorDiv"></div> <!-- 감독 유효성 검사 메시지 -->	            
		            </td>
		        </tr>
		        <tr>
		        	<th>영화 장르</th> <!-- 영화 장르 입력 필드 -->
		            <td class="info-cell">
		            	<input type="text" name="movieGenre" class="movieInput" id="movieGenre" value="${movieDTO.genre }" />
		            	<div class="validationDiv" id="movieGenreDiv"></div> <!-- 장르 유효성 검사 메시지 -->	            
		            </td>
		        </tr>
		        <tr>
		        	<th>영화 개봉일</th> <!-- 영화 개봉일 입력 필드 -->
		            <td class="info-cell">
		            	<input type="text" name="movieReleaseDate" class="movieInput" id="movieReleaseDate" value="${movieDTO.release_date }" />
		            	<div class="validationDiv" id="movieReleaseDateDiv"></div> <!-- 개봉일 유효성 검사 메시지 -->	            
		            </td>
		        </tr>
		        <tr>
		        	<th>영화 관람가</th> <!-- 영화 관람 등급 입력 필드 -->
		            <td class="info-cell">	
		            	<input type="text" name="movieRating" class="movieInput" id="movieRating" value="${movieDTO.rating }" />
		            	<div class="validationDiv" id="movieRatingDiv"></div> <!-- 관람가 유효성 검사 메시지 -->	            
		            </td>
		        </tr>
		        <tr>
		        	<th>영화 평점</th> <!-- 영화 평점 입력 필드 -->
		            <td class="info-cell">
		            	<input type="text" name="movieScore" class="movieInput" id="movieScore" value="${movieDTO.score }" />
		            	<div class="validationDiv" id="movieScoreDiv"></div> <!-- 평점 유효성 검사 메시지 -->	            
		            </td>
		        </tr>
		        <tr>
		        	<th>영화 줄거리</th> <!-- 영화 줄거리 입력 필드 -->
		            <td class="info-cell">
		            	<textarea name="movieSynopsis" class="movieInput" id="movieSynopsis" rows="5" cols="60">${movieDTO.synopsis }</textarea>
		            	<div class="validationDiv" id="movieSynopsisDiv"></div> <!-- 줄거리 유효성 검사 메시지 -->	            
		            </td>
		        </tr>
		    </table>
		</form>
	</div>
	<div class="button-container" style="width:1000px; display: flex; justify-content: flex-end;">
		<!-- 수정, 초기화, 목록 버튼 -->
		<button type="button" class="crudBtn" id="movieEditBtn">수정</button> 
		<button type="reset" class="crudBtn" id="resetBtn">초기화</button>
		<button type="button" class="crudBtn" id="listBtn">목록</button>
	</div>
</c:if>

<!-- 관리자가 아닌 경우, 경고 메시지를 띄우고 로그인 페이지로 이동 -->
<c:if test="${sessionScope.adminDTO.aid != 'admin'}">
    <script>
        alert("관리자로 로그인하세요");
        location.href = "${pageContext.request.contextPath}/admin/adminSignIn.do";
    </script>
</c:if>

<!-- 외부 라이브러리 및 JavaScript 파일 연결 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

<script>
    var context = '${pageContext.request.contextPath}';
    
    // 영화 포스터 경로를 변수에 저장 - 초기화 버튼 클릭 시 #showImg 를 비우는 것이 아닌 원래 이미지로 복구하기 위함
    var originalPoster = '${movieDTO.poster}';
</script>

<!-- 외부 JS 파일 연결 -->
<script type="text/javascript" src="../js/movieEdit.js"></script>
</body>
</html>
