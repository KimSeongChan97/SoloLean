<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>리뷰 작성</title>
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

    <!-- Review Form -->
    <div class="container review-form-container">
        <h2 class="text-center">리뷰 작성</h2>
        <form action="${pageContext.request.contextPath}/review/insertReview" method="post">
            <input type="hidden" name="roomId" value="${roomId}">

            <!-- Room ID -->
            <div class="form-group">
                <label for="roomId">Room ID:</label>
                <input type="text" id="roomId" name="roomId" value="${roomId}" readonly class="form-control" />
            </div>

            <!-- Rating -->
            <div class="form-group">
                <label for="rating">Rating:</label>
                <div class="star-rating">
                    <input type="radio" id="star5" name="rating" value="5" required />
                    <label for="star5" class="full" title="5 stars"></label>

                    <input type="radio" id="star4" name="rating" value="4" />
                    <label for="star4" class="full" title="4 stars"></label>

                    <input type="radio" id="star3" name="rating" value="3" />
                    <label for="star3" class="full" title="3 stars"></label>

                    <input type="radio" id="star2" name="rating" value="2" />
                    <label for="star2" class="full" title="2 stars"></label>

                    <input type="radio" id="star1" name="rating" value="1" />
                    <label for="star1" class="full" title="1 star"></label>
                </div>
            </div>

            <!-- Comment -->
            <div class="form-group">
                <label for="comment">Comment:</label>
                <textarea id="comment" name="comment" rows="4" class="form-control" required></textarea>
            </div>

            <!-- Submit Button -->
            <div class="text-center">
                <button type="submit" class="btn btn-primary">리뷰 작성</button>
                <input type="button" class="btn btn-success" value="List" onclick="window.location.href='${pageContext.request.contextPath}/review/reviewList';">
            </div>
        </form>
    </div>

    <!-- jQuery and Bootstrap JS -->
    <script type="text/javascript"></script>
</body>
</html>
