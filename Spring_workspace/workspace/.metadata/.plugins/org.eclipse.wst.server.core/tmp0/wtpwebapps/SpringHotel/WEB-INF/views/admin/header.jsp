<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="/SpringHotel/resources/css/bootstrap.css">
<link rel="stylesheet" href="/SpringHotel/resources/css/custom.css">
<title>호텔 예약 시스템</title>
<style type="text/css">
@charset "UTF-8";
html,body{
	margin:0;
	width:100%;
	height:100%;
	font-family : "Nanum Gothic";
}

/*모든 폴더의 header에 적용*/
.header{
	height:8%;
	text-align:center; 
	font-size: 22px;
}
.header tr th{
	width:13%;
}
.header a:link {					/* a 태그 클릭 안한 상태 */
	text-align:center; 
	color: black;
	text-decoration : none;	/*밑줄 제거*/
}

.header a:visited { 				/* a 태그 1회 이상 클릭 했을 때 상태 */
 	color: black; 
 	text-decoration: none;
}

.header a:hover { 					/* a 태그에 마우스 올렸을 때 상태 */
 	color: black; 
 	text-decoration: none;	
}
</style>
</head>
<body class="header">
	<nav class="navbar navbar-default">
		<div class="navbar-header">
         	<button type="button" class="navbar-toggle collapsed"
            	data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
            	aria-expanded="false">
            	<span class="icon-bar"></span>
            	<span class="icon-bar"></span>
            	<span class="icon-bar"></span>
         	</button>
         	<a class="navbar-brand" href="/SpringHotel/">Spring Hotel</a>
     	 </div>
     	  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
         	<ul class="nav navbar-nav">
         		<li><a href="/SpringHotel/admin/checkUser">회원조회</a></li>
            	<li><a href="/SpringHotel/admin/updateRoom">객실 정보</a></li>
            	<li><a href="/SpringHotel/admin/checkReserve">예약내역</a></li>
            	<li><a href="/SpringHotel/admin/inquiryList">Q&A</a></li>
            </ul>

		<ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <c:if test="${not empty sessionScope.adminId}">
                    <a href="/SpringHotel/admin/logout" class="dropdown-toggle" role="button" aria-haspopup="true" aria-expanded="false">
                        로그아웃 <span class="caret"></span>
                    </a>
                </c:if>
                <c:if test="${empty sessionScope.adminId}">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        접속하기 <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="/SpringHotel/admin/login">로그인</a></li>
                    </ul>
                </c:if>
            </li>
        </ul>                    

     	 </div> 
	</nav>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
   	<script src="/SpringHotel/resources/js/bootstrap.js"></script>
</body>
</html>