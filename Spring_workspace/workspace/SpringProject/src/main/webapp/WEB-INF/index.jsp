<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>메인 인덱스</title>
    <!-- 부트스트랩 CSS 불러오기 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
</head>
<body>

<!-- 메인 컨테이너 -->
<div id="main-container" class="container">
    
    <!-- 로그인 상태 표시 -->
    <div id="login_status">
        <p>환영합니다, ${sessionScope.loginUser.name}님!</p>
        <div>
            <a href="${pageContext.request.contextPath}/user/logout" class="btn btn-sm btn-outline-primary">로그아웃</a>
            <a href="${pageContext.request.contextPath}/user/loginForm" class="btn btn-sm btn-outline-secondary">로그인</a>
        </div>
    </div>
    
    <!-- 메인 화면 제목 -->
    <h2>*** 메인화면 ***</h2>
    
    <!-- 메뉴 링크들 -->
    <h3>
        <p><a href="${pageContext.request.contextPath}/user/loginForm">Login</a></p>
        <p><a href="http://localhost:8080/spring/user/writeForm">회원가입(입력)</a></p>
        <p><a href="${pageContext.request.contextPath}/user/list?pg=1">회원정보(출력)</a></p>
        <br/>
        <p><a href="/spring/user/uploadForm">파일 업로드</a></p>
        <p><a href="/spring/user/uploadAJaxForm">파일 업로드 AJax</a></p>
        <br/>
        <p><a href="/spring/user/uploadList">이미지 출력</a></p>
    </h3>
</div>

<!-- 부트스트랩 JS 불러오기 -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>

<!-- 
Spring Framework + Maven + MySQL + MyBatis(@Mapper 사용) + JSP(jQuery) + NCP (예정)

Project: SpringProject
src/main/java
	com.controller.SpringProject
		MainController.java
	user.controller
		UserController.java
		UserUploadController.java
	user.service
		UserService.java (Interface)
	user.service.impl
		UserServiceImpl.java	
	user.dao
		UserDAO.java (Interface)
	user.dao.impl
		UserMyBatisDAO.java ===> 제거	
	user.bean
		UserDTO.java
		UserPaging.java
		UserUploadDTO.java
		
	
	
		
		
		
src/main/resources
	mapper
		userMapper.xml
	spring
		applicationContext.xml
	sql
		usertable.sql				
src/main/webapp
	WEB-INF
		css
			write.css
			...
		js
			write.js
			..
		image
			*.png
		user
			..
		upload
			uploadForm.jsp
		storage(가상주소, 업로드의 위치)
				
		spring
			..							
		

 -->


