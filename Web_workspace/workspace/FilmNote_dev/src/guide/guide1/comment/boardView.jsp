<%-- projectMVC/src/main/webapp/board/boardView.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="data:,">
<link rel="stylesheet" href="../css/index.css">
<title>글 조회</title>
<style type="text/css">
* {
    padding: 0px;
    margin: 0px;
    box-sizing: border-box;
}

#view-jsp {
	width: 1100px; 
	margin: 0 auto;
}

.post-detail {
    padding: 20px;
    /* max-width: 1000px; */
    background: #f9f9f9;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

/* 게시물 */
.post-detail h2 {
    font-size: 22px;
    color: #005898;
    margin-bottom: 20px;
}

.post-info {
    margin-bottom: 30px;
    font-size: 16px;
    color: #333;
    display: flex;
    justify-content: space-between;
}

.post-info span {
	display: block;
    margin-bottom: 5px;
    padding-right: 5px;
}

.post-no, .post-id, .post-date, .post-hit {
	letter-spacing: 3px;	
}

#post-id, #post-date {
	display: inline;
	margin-left: 5px;
}

.post-content {
    font-size: 18px;
    color: #333;
    line-height: 1.6;
}

#post-body {
    white-space: pre-wrap;
	
}

/* 게시물 */



/* 댓글 컨테이너 */
.comment-content {
    padding: 15px;
    background: #f9f9f9;
    border: 1px solid #ddd;
    border-radius: 10px;
    margin: 20px 0;
}

/* 댓글 항목 */
.comment {
    display: flex;
    align-items: flex-start;
    padding-bottom: 15px;
    border-bottom: 1px solid #eee;
    position: relative;
}

/* 프로필 사진 */
.profile-pic {
    width: 40px;
    height: 40px;
    border-radius: 50%;
    margin-right: 15px;
}

/* 댓글 세부사항 */
.comment-details {
    flex: 1;
}

.comment-header {
    display: flex;
    justify-content: space-between;
}

.list-user-id {
    font-weight: bold;
    font-size: 14px;
}

.comment-date {
    font-size: 12px;
    color: #888;
}

.list-content {
    margin: 5px 0;
    font-size: 14px;
}

.comment-actions {
    font-size: 12px;
    color: #005898;
}

.reply, .like {
    cursor: pointer;
    margin-right: 10px;
}

.comment-options {
    position: absolute;
    top: 0;
    right: 0;
}

.options-btn {
    background: none;
    border: none;
    cursor: pointer;
}

.options-menu {
    display: none;
    position: absolute;
    right: 0;
    background: white;
    border: 1px solid #ddd;
    border-radius: 5px;
}

.options-btn:hover + .options-menu {
    display: block;
}

.options-menu span {
    display: block;
    padding: 5px 10px;
    cursor: pointer;
}

/* 댓글 작성 폼 */
#post-comment {
    padding-top: 15px;
    display: flex;
    flex-direction: column;
}

.post-header {
    font-weight: bold;
    margin-bottom: 10px;
}

#new-comment {
    width: 100%;
    height: 50px;
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 5px;
    font-size: 14px;
    resize: none;
}

.post-footer {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-top: 10px;
}

.icon-button {
    background: none;
    border: none;
    cursor: pointer;
    transform: scale(1.5);
    margin: 0 5px;
}

#submit-comment {
    background: #005898;
    color: white;
    border: none;
    padding: 5px 15px;
    border-radius: 5px;
    cursor: pointer;
    transition: background 0.3s ease;
}

#submit-comment:hover {
    background: #003d6a;
}

.button-container {
    display: flex;
    justify-content: flex-end;
    margin-top: 20px; 
    gap: 10px;
}

.edit-post-btn, .del-post-btn {
	visibility: hidden;
}

.edit-post-btn, .del-post-btn, .back-btn {
    display: flex; 
    align-items: center; 
    justify-content: center; 
    padding: 5px 20px;
    background: #f9f9f9;
    border: 1px solid #005898;
    color: #005898;
    text-decoration: none;
    border-radius: 5px;
    font-size: 16px;
    text-align: center;
    transition: background-color 0.3s ease;
    cursor: pointer;
}

.edit-post-btn:hover, .del-post-btn:hover, .back-btn:hover {
    background: #005898;
    color: white;
    cursor: pointer;
}

</style>
</head>
<body>
<div id="view-jsp">
		<!-- main.jsp 포함 -->
		<%-- <jsp:include page="../main/menu.jsp"></jsp:include> --%>
	
	<div id="container">
		<!-- nav.jsp 포함 -->
		<div id="nav">
		    <%-- <jsp:include page="../main/nav.jsp"></jsp:include> --%>
		</div> 
		
		<div id="section">
			<div class="post-detail">
				<h2 id="post-title">${boardDTO.subject }</h2>
				<div class="post-info">
					<span class="post-no">글번호 : ${boardDTO.seq }</span>
					<span class="post-id">작성자 : ${boardDTO.id }</span>
                    <span class="post-date">작성일 : 
						<fmt:formatDate value="${boardDTO.logtime}" pattern="yyyy.MM.dd" />
					</span> 
					<span class="post-no">조회수 : ${boardDTO.hit }</span>
				</div> <!-- <div class="post-info"> -->
				
				<div class="post-content">
                    <pre id="post-body">${boardDTO.content }</pre>
                </div>
                
			 <div class="comment-content">
			    <div class="comment">
			    	<div class="icon-button">👲</div>
			        <!-- <img class="profile-pic" src="default-profile.jpg" alt="User Profile"> -->
			        <div class="comment-details">
			            <div class="comment-header">
			                <span class="list-user-id">codus3</span>
			                <span class="comment-date">2024.09.10. 19:45</span>
			            </div>
			            <div class="list-content">감사합니다</div>
			            <div class="comment-actions">
			                <span class="reply">답글쓰기</span>
			                <span class="like">❤️</span>
			            </div>
			        </div>
			        <div class="comment-options">
			            <button class="options-btn">⋮</button>
			            <div class="options-menu">
			                <span class="edit">수정</span>
			                <span class="delete">삭제</span>
			            </div>
			        </div>
			    </div>
			
			    <div id="post-comment">
			        <div class="post-header">codus3</div>
			        <textarea id="new-comment" placeholder="댓글을 남겨보세요"></textarea>
			        <div class="post-footer">
			        	<div id="emoji">
				            <button class="icon-button">📷</button>
				            <button class="icon-button">😊</button>
			            </div>
			            <button id="submit-comment">등록</button>
			        </div>
			    </div>
			</div>

			<div class="button-container"
				data-mem-id="${sessionScope.memId}" data-board-id="${boardDTO.id}">
               	<button type="submit" class="edit-post-btn">수정</button>
                <button type="submit" class="del-post-btn">삭제</button>
	    		<button class="back-btn" onclick="window.location.href='${pageContext.request.contextPath }/board/boardList.do?pg=${pg }';">목록</button>
	    	</div>
                
 
                
                <!-- <div class="comment-content">
                	<div id="comment-list">
                   	 	<div class="comment">
				            <div class="list-user-id"></div>
				            <div class="list-content"></div>
				            <div class="list-date"></div>
                		</div>             		
                	</div>
                	<div id="post-comment">
                		<textarea id="new-comment" placeholder="댓글을 작성하세요..."></textarea>
            			<button id="submit-comment">작성</button>
                	</div>
				</div><div class="comment-content"> -->
				
				
			</div><!-- <div class="post-detail"> -->
		</div><!-- <div id="section"> -->
	</div><!-- <div id="container"> -->

</div><!-- <div id="view-jsp"> -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script> 
<script type="text/javascript">
$(document).ready(function() {
    var memId = $('.button-container').data('mem-id');
    var boardId = $('.button-container').data('board-id');
    
    if (memId === boardId) {
        $('.edit-post-btn, .del-post-btn').css('visibility', 'visible');
    }
});

</script>
</body>
</html>