<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>Update Review</title>
</head>
<body>
    <h2>Update Review</h2>
    
    <form action="${pageContext.request.contextPath}/review/updateReview" method="post">
	    <input type="hidden" name="reviewId" value="${review.reviewId}" />
	    <label for="roomId">Room ID: </label><input type="text" name="roomId" value="${review.roomId}" /><br/>
	    <label for="userId">User ID: </label><input type="text" name="userId" value="${review.userId}" /><br/>
	    <label for="rating">Rating: </label><input type="number" name="rating" min="1" max="5" value="${review.rating}" /><br/>
	    <label for="comment">Comment: </label><textarea name="comment">${review.comment}</textarea><br/>
	    <button type="submit">Update Review</button>
	</form>

</body>
</html>