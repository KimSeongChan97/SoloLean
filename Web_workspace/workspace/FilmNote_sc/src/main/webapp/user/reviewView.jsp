<%-- FilmNote/src/main/webapp/user/reviewView.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="../image/film_favicon.png" type="image/png">
<link rel="stylesheet" href="../css/reviewView.css">
<title>리뷰 조회</title>
<style type="text/css">
#page-block {
   margin: 20px auto;
   font-size: 13pt;
   display: flex;
   justify-content: center;
   align-items: center;
   gap: 5px;
}

#currentPaging {
   background-color: #e5e7ea;
   border-radius: 5px;
   padding: 5px 8px;
   font-weight: bold;
}

#paging {
   border-radius: 5px;
   padding: 5px 8px;
}

span:hover {
   text-decoration: underline;
   cursor: pointer;
}

</style>
</head>
<body>



<div id="page-block">${boardPaging.pagingHTML }</div>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/reviewView.js"></script>
</body>
</html>