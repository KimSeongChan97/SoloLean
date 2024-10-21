<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>리뷰 수정</title>
    <link rel="stylesheet" href="/SpringHotel/resources/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/review.css">
</head>
<body>
<!-- Navigation Bar -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed"
                        data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                        aria-expanded="false">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/">Spring Hotel</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="${pageContext.request.contextPath}/">HOME</a></li>
                    <li><a href="${pageContext.request.contextPath}/room/roomView">객실 정보</a></li>
                    <li><a href="reservation1.jsp">예약</a></li>
                    <li><a href="reserveInfo.jsp">예약내역</a></li>
                    <li><a href="inquiryList.jsp">Q&A</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                           aria-haspopup="true" aria-expanded="false">접속하기<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li class="active"><a href="login.jsp">로그인</a></li>
                            <li><a href="join.jsp">회원가입</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    
 <div class="container review-form-container">   
<h2 class="text-center">리뷰 수정</h2>

<form action="${pageContext.request.contextPath}/review/updateReview" method="post">
    <input type="hidden" name="reviewId" value="${review.reviewId}">
    <input type="hidden" name="roomId" value="${review.roomId}">
    
    <label for="rating">Rating:</label>
    <input type="number" id="rating" name="rating" value="${review.rating}" min="1" max="5" required /><br/><br/>
    
    <label for="comment">Comment:</label>
    <textarea id="comment" name="comment" rows="4" cols="50">${review.comment}</textarea><br/><br/>
    
    <button type="submit">리뷰 수정</button>
</form>
</div>
</body>
</html>
