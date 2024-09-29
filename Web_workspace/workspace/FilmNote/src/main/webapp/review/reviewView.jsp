<%-- FilmNote/src/main/webapp/review/reviewView.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="../image/film_favicon.png" type="image/png">
<link rel="stylesheet" href="../css/reviewView.css">
<title>리뷰 조회</title>
</head>
<body>
<jsp:include page="../common/header.jsp" />

<div id="movieInfo">
	
	<table>
	<tr>
		<td colspan="3" id="movietitle" data-moviecode="${movieDTO.mcode}"><span>${movieDTO.title}</span></td>
	</tr>
		<tr>
		    <td width="30%" align="center" rowspan="9" class="poster-cell">
		        <img width="90%" src="${movieDTO.poster }" alt="영화 포스터">
		    </td>
		</tr>
		<tr>
			<th width="20%">영화 감독</th>
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
		    <td class="info-cell">${movieDTO.rating }세</td>
		</tr>
		<tr>
			<th>영화 평점</th>
		    <td class="info-cell" id="movieAvgScore"><fmt:formatNumber pattern="0.00점" value="${movieDTO.score}"/></td>
		</tr>
		<tr>
			<th>영화 줄거리</th>
		    <td class="info-cell">${movieDTO.synopsis }</td>
		</tr>
	</table>
</div>

<%-- 
<div id="reviewTotalNum" hidden>${reviewDTOList.size()}</div> --%>
<div id="reviewDiv">
	<!-- 리뷰 -->
	<div id="reviewList">
		<c:if test="${reviewDTOList.size() != 0}">
			<c:forEach var="reviewDTO" items="${reviewDTOList}">
				<div class="review">
					<div class="icon-button">👲</div>
				    <!-- <img class="profile-pic" src="default-profile.jpg" alt="User Profile"> -->
				    <div class="comment-details">
				        <div class="comment-header">
				        	<span class="review-code" hidden>${reviewDTO.getRcode()}</span>
				        	<span class="list-user-id">
				            	<c:if test="${reviewDTO.getUser_id() == null}">알수없음</c:if>
				            	<c:if test="${reviewDTO.getUser_id() != null}">${reviewDTO.getUser_id()}</c:if>
				            </span>
				            <span class="comment-date">${reviewDTO.getLogtime()}</span>
				        </div>
				        
				        <div class="list-content">
					        <div class="review-score">${reviewDTO.getScore()}.0점</div>
					        <div class="review-content">${reviewDTO.getContent()}</div>
				        </div>
				        
				        <div class="update-review">
					        <div class="update-score">
					    		<div class="score-num"><span class="scoreText">${reviewDTO.getScore()}</span>점</div>
					    		<div class="score-star">
					    			<span class="score" data-score="1">☆</span>
						    		<span class="score" data-score="2">☆</span>
						    		<span class="score" data-score="3">☆</span>
						    		<span class="score" data-score="4">☆</span>
						    		<span class="score" data-score="5">☆</span>
						    		<span class="score" data-score="6">☆</span>
						    		<span class="score" data-score="7">☆</span>
						    		<span class="score" data-score="8">☆</span>
						    		<span class="score" data-score="9">☆</span>
						    		<span class="score" data-score="10">☆</span>
					    		</div>
					    	</div>
					        <textarea class="update-reviewText">${reviewDTO.getContent()}</textarea>
					        <input type="button" class="btn update-reviewBtn" value="수정">
				        </div>
				        <div class="comment-actions">
				            <!-- <span class="reply">답글쓰기</span>
				            <span class="like">❤️</span> -->
				        </div>
				    </div>
				    <c:if test="${sessionScope.userDTO.uname == reviewDTO.getUser_id()}">
					    <div class="comment-options">
					        <button class="options-btn">⋮</button>
					        <div class="options-menu">
					            <span class="edit">수정</span>
					            <span class="delete">삭제</span>
					        </div>
					    </div>
				    </c:if>
				</div>
			</c:forEach>
		</c:if>
		
		<c:if test="${reviewDTOList.size() == 0}">
			<div id="noReview">
				리뷰가 존재하지 않습니다.
			</div>
		</c:if>
	</div>
	<!-- 리뷰 -->
	
	<div id="post-comment" data-uid="${sessionScope.userDTO.uid}">
	    <div class="post-header">${sessionScope.userDTO.uname}</div>
	    <form id="reviewForm">
	    	<textarea id="new-review" name="new-review" placeholder="리뷰을 남겨보세요."></textarea>
	    	
	    	
	    	<div id="new-score">
	    		<div id="score-num"><span id="scoreText">0</span>점</div>
	    		<div id="score-star">
		    		<span class="score" data-score="1">☆</span>
		    		<span class="score" data-score="2">☆</span>
		    		<span class="score" data-score="3">☆</span>
		    		<span class="score" data-score="4">☆</span>
		    		<span class="score" data-score="5">☆</span>
		    		<span class="score" data-score="6">☆</span>
		    		<span class="score" data-score="7">☆</span>
		    		<span class="score" data-score="8">☆</span>
		    		<span class="score" data-score="9">☆</span>
		    		<span class="score" data-score="10">☆</span>
	    		</div>
	    	</div>
	    	
	    	
	    	<div class="post-footer">
		    	<div id="emoji">
			         <input type="button" class="icon-button" value="📷">
			         <input type="button" class="icon-button" value="😊">
		        </div>
		        <input type="button" class="btn" id="submit-review" value="등록">
	    	</div>
	    </form>
	</div>
	<div id="page-block">${reviewPagingHTML}</div>
</div>

<div id="footer">
	<p id="footer-p">
		Film Note / 서울 강남구 강남대로94길 20 삼오빌딩 6층 602호 / 대표전화 : 0507-1414-9601 / 팀장 : 박채연
	</p>
	<a id="footer-a" href="https://github.com/bitcamp-aiaas-9/FilmNote" target="_blank">
		<div id="github">
			<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 496 512" width="32" height="35">
	  			<path d="M165.9 397.4c0 2-2.3 3.6-5.2 3.6-3.3 .3-5.6-1.3-5.6-3.6 0-2 2.3-3.6 5.2-3.6 3-.3 5.6 1.3 5.6 3.6zm-31.1-4.5c-.7 2 1.3 4.3 4.3 4.9 2.6 1 5.6 0 6.2-2s-1.3-4.3-4.3-5.2c-2.6-.7-5.5 .3-6.2 2.3zm44.2-1.7c-2.9 .7-4.9 2.6-4.6 4.9 .3 2 2.9 3.3 5.9 2.6 2.9-.7 4.9-2.6 4.6-4.6-.3-1.9-3-3.2-5.9-2.9zM244.8 8C106.1 8 0 113.3 0 252c0 110.9 69.8 205.8 169.5 239.2 12.8 2.3 17.3-5.6 17.3-12.1 0-6.2-.3-40.4-.3-61.4 0 0-70 15-84.7-29.8 0 0-11.4-29.1-27.8-36.6 0 0-22.9-15.7 1.6-15.4 0 0 24.9 2 38.6 25.8 21.9 38.6 58.6 27.5 72.9 20.9 2.3-16 8.8-27.1 16-33.7-55.9-6.2-112.3-14.3-112.3-110.5 0-27.5 7.6-41.3 23.6-58.9-2.6-6.5-11.1-33.3 2.6-67.9 20.9-6.5 69 27 69 27 20-5.6 41.5-8.5 62.8-8.5s42.8 2.9 62.8 8.5c0 0 48.1-33.6 69-27 13.7 34.7 5.2 61.4 2.6 67.9 16 17.7 25.8 31.5 25.8 58.9 0 96.5-58.9 104.2-114.8 110.5 9.2 7.9 17 22.9 17 46.4 0 33.7-.3 75.4-.3 83.6 0 6.5 4.6 14.4 17.3 12.1C428.2 457.8 496 362.9 496 252 496 113.3 383.5 8 244.8 8zM97.2 352.9c-1.3 1-1 3.3 .7 5.2 1.6 1.6 3.9 2.3 5.2 1 1.3-1 1-3.3-.7-5.2-1.6-1.6-3.9-2.3-5.2-1zm-10.8-8.1c-.7 1.3 .3 2.9 2.3 3.9 1.6 1 3.6 .7 4.3-.7 .7-1.3-.3-2.9-2.3-3.9-2-.6-3.6-.3-4.3 .7zm32.4 35.6c-1.6 1.3-1 4.3 1.3 6.2 2.3 2.3 5.2 2.6 6.5 1 1.3-1.3 .7-4.3-1.3-6.2-2.2-2.3-5.2-2.6-6.5-1zm-11.4-14.7c-1.6 1-1.6 3.6 0 5.9 1.6 2.3 4.3 3.3 5.6 2.3 1.6-1.3 1.6-3.9 0-6.2-1.4-2.3-4-3.3-5.6-2z"/>
			</svg>
			<span id="gitlink">Github : FilmNote</span>
		</div>
	</a>
</div>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/reviewView.js"></script>
</body>
</html>