<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Review List</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/review.css">
</head>
<body>
	
    <div class="container">
        <h2 class="text-center">Review List</h2>

        <table class="table table-striped table-bordered table-responsive">
            <thead class="thead-dark">
                <tr>
                    <th>Room ID</th>
                    <th>User ID</th>
                    <th>Rating</th>
                    <th>Comment</th>
                    <th>Logtime</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="review" items="${reviews}">
                    <tr>
                        <td>${review.roomId}</td>
                        <td>${review.userId}</td>
                        <td>${review.rating}</td>
                        <td>${review.comment}</td>
                        <td>${review.logtime}</td>
                        <td>
                            <button class="btn btn-primary update-btn" data-id="${review.reviewId}">Update</button>
                        </td>
                        <td>
                            <button class="btn btn-danger delete-btn" data-id="${review.reviewId}">Delete</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <div class="text-center">
            <input type="button" class="btn btn-success" value="Index" onclick="window.location.href='${pageContext.request.contextPath}/';">
        </div>
    </div>

    <!-- jQuery and Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/review.js"></script>
</body>
</html>