<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<meta name="viewport" content="width=device-width", initial-scale="1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer.css">
<body>
<nav class="navbar navbar-default">
	<div class="navbar-header">
        	<button type="button" class="navbar-toggle collapsed"
           	data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
           	aria-expanded="false">
           	<span class="icon-bar"></span>
           	<span class="icon-bar"></span>
           	<span class="icon-bar"></span>
        	</button>
		<a class="navbar-brand" href="/SpringHotel/">Spring HOTEL</a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    	<ul class="nav navbar-nav">
    		<c:if test="${sessionScope.adminId != null}">
    			<li><a id="header-6" href="${pageContext.request.contextPath}/admin/checkUser">회원조회</a></li>
            	<li><a id="header-7" href="${pageContext.request.contextPath}/admin/updateRoom">객실 정보</a></li>
            	<li><a id="header-8" href="${pageContext.request.contextPath}/admin/checkReserve">예약내역</a></li>
            	<li><a id="header-9" href="${pageContext.request.contextPath}/admin/inquiryList">Q&A</a></li>
    		</c:if>
    		<!-- 로그인 전 && 사용자 로그인-->
    		<c:if test="${sessionScope.adminId == null}">
    			<li id="header-1"><a href="/SpringHotel/">HOME</a></li>
	          	<li id="header-2"><a href="/SpringHotel/room/roomView">객실 정보</a></li>
	            <li id="header-3"><a href="/SpringHotel/reserve/main">예약</a></li>
	            <li id="header-4"><a href="/SpringHotel/">예약내역</a></li>
	            <li id="header-5"><a href="/SpringHotel/admin/inquiryList2">Q&A</a></li>
    		</c:if>
        </ul>
        <ul class="nav navbar-nav navbar-right">
        	<c:if test="${sessionScope.userName == null && sessionScope.adminId == null}">
        		<li class="dropdown">
	          		<a href="#" class="dropdown-toggle"
	          			data-toggle="dropdown" role="button" aria-haspopup="true"
	          			aria-expanded="false">접속하기<span class="caret"></span>
	          		</a>
	         		<ul class="dropdown-menu">
	              		<li id="header-loginMenu"><a href="${pageContext.request.contextPath}/user/login">로그인</a></li>
	                	<li id="header-joinMenu"><a href="${pageContext.request.contextPath}/user/join">회원가입</a></li>
	                	<li id="header-adminMenu"><a href="${pageContext.request.contextPath}/admin/login">관리자</a></li>
	             	</ul>
	          	</li>
        	</c:if>
          	<c:if test="${sessionScope.userName != null}">
        		<li class="dropdown">
	          		<a href="#" class="dropdown-toggle"
	          			data-toggle="dropdown" role="button" aria-haspopup="true"
	          			aria-expanded="false">접속하기<span class="caret"></span>
	          		</a>
	         		<ul class="dropdown-menu">
	              		<li><a href="${pageContext.request.contextPath}/">${sessionScope.userName }</a></li>
	                	<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
	             	</ul>
	          	</li>
        	</c:if>
        	<c:if test="${sessionScope.adminId != null}">
    			<li class="dropdown">
	          		<a href="#" class="dropdown-toggle"
	          			data-toggle="dropdown" role="button" aria-haspopup="true"
	          			aria-expanded="false">접속하기<span class="caret"></span>
	          		</a>
	         		<ul class="dropdown-menu">
	              		<li><a href="#">관리자</a></li>
	                	<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
	             	</ul>
	          	</li>
    		</c:if>
       	</ul>
   	 </div> 
</nav>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<!-- <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> -->
</body>