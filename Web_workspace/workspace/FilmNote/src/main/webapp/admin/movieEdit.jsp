<%-- FilmNote/src/main/webapp/admin/movieEdit.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="../image/film_favicon.png" type="image/png">
<link rel="stylesheet" href="../css/movieEdit.css">
<title>영화 수정</title>
</head>
<body>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/adminMenu.jsp" />


<c:if test="${sessionScope.adminDTO.aid == 'admin'}">

	<div id="movie-edit">
		<!-- 영화 코드, 영화 제목, 영화 감독, 영화 장르, 영화 개봉일, 영화 등급, 영화 평점, 영화 줄거리, 영화 포스터 이미지 -->
		<form name="movie-edit-form" id="movie-edit-form">
		<input type="hidden" name="mcode" id="mcode" value="${requestScope.mcode }" />
		<input type="hidden" name="pg" id="pg" value="${requestScope.pg }" />
		    <table>
		    	<tr>
		    		<th width="30%">영화 포스터</th>
		    		<th width="20%">영화 코드</th>
		    		<td width="50%" class="info-cell">
		    			<input type="text" name="movieCode" class="movieInput" id="movieCode" value="${movieDTO.mcode }" readonly />
		    		</td>
		    	</tr>
		        <tr>
		            <td align="center" rowspan="9" class="poster-cell">
						<div id="showImgDiv">
							<img id="showImg" src="${movieDTO.poster }" alt="영화 포스터" width="257" height="366" />
						</div>
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
				    <th>영화 제목</th>
				    <td class="info-cell">
				    	<input type="text" name="movieTitle" class="movieInput" id="movieTitle" value="${movieDTO.title }" />
				        <div class="validationDiv" id="movieTitleDiv"></div>
				    </td>
		        </tr>
		        <tr>
		        	<th>영화 감독</th>
		            <td class="info-cell">
		            	<input type="text" name="movieDirector" class="movieInput" id="movieDirector" value="${movieDTO.director }" />
		            	<div class="validationDiv" id="movieDirectorDiv"></div>		            
		            </td>
		        </tr>
		        <tr>
		        	<th>영화 장르</th>
		            <td class="info-cell">
		            	<input type="text" name="movieGenre" class="movieInput" id="movieGenre" value="${movieDTO.genre }" />
		            	<div class="validationDiv" id="movieGenreDiv"></div>		            
		            </td>
		        </tr>
		        <tr>
		        	<th>영화 개봉일</th>
		            <td class="info-cell">
		            	<input type="text" name="movieReleaseDate" class="movieInput" id="movieReleaseDate" value="${movieDTO.release_date }" />
		            	<div class="validationDiv" id="movieReleaseDateDiv"></div>		            
		            </td>
		        </tr>
		        <tr>
		        	<th>영화 관람가</th>
		            <td class="info-cell">	
		            	<input type="text" name="movieRating" class="movieInput" id="movieRating" value="${movieDTO.rating }" />
		            	<div class="validationDiv" id="movieRatingDiv"></div>		            
		            </td>
		        </tr>
		        <tr>
		        	<th>영화 평점</th>
		            <td class="info-cell">
		            	<input type="text" name="movieScore" class="movieInput" id="movieScore" value="${movieDTO.score }" />
		            	<div class="validationDiv" id="movieScoreDiv"></div>		            
		            </td>
		        </tr>
		        <tr>
		        	<th>영화 줄거리</th>
		            <td class="info-cell">
		            	<textarea name="movieSynopsis" class="movieInput" id="movieSynopsis" rows="5" cols="60" >${movieDTO.synopsis }</textarea>
		            	<div class="validationDiv" id="movieSynopsisDiv"></div>		            
		            </td>
		        </tr>
		    </table>
		</form>
	</div>
	<div class="button-container" style="width:1000px; display: flex; justify-content: flex-end;">
		<button type="button" class="crudBtn" id="movieEditBtn">수정</button> 
		<button type="reset" class="crudBtn" id="resetBtn">초기화</button>
		<button type="button" class="crudBtn" id="listBtn">목록</button>
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
    
    // 영화 포스터 경로를 변수에 저장- 초기화 버튼 클릭 시 #showImg 를 비우는 것이 아닌 원래 이미지로 복구하기 위함
    var originalPoster = '${movieDTO.poster}';
</script>

<script type="text/javascript" src="../js/movieEdit.js"></script>
</body>
</html>