<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index 페이지</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/index.css">
</head>
<body>
 
	<div id="wrap">
		<!-- 전체 페이지의 콘텐츠를 감싸는 래퍼입니다. -->
		<div id="header">
			<!-- 페이지의 상단 헤더 영역입니다. -->
			<h1>
				<img alt="사과" src="${ pageContext.request.contextPath }/image/apple.png" 
				width="50" height="50" style="cursor: pointer;" >
				<!-- 헤더 안에 사과 이미지를 삽입합니다. 이미지의 크기는 50x50으로 고정됩니다. -->
				MVC를 활용한 미니프로젝트
				<!-- 페이지 제목입니다. 헤더 안에 텍스트로 표시됩니다. -->
			</h1>
			<jsp:include page="./main/menu.jsp" />
			<!-- menu.jsp 파일을 현재 페이지에 포함시킵니다. 이는 공통 메뉴를 사용할 때 유용하며, JSP 페이지에서 다른 JSP 파일을 동적으로 포함시킬 수 있는 방법입니다. -->
		</div>	
		<div id="container">
			<!-- 페이지의 메인 콘텐츠를 감싸는 컨테이너입니다. nav와 section을 포함하고 있습니다. -->
			<div id="nav">
				<!-- 네비게이션 영역입니다. 페이지의 좌측에 배치되며, 메뉴 등을 포함합니다. -->
				<jsp:include page="./main/nav.jsp" />
				<!-- nav.jsp 파일을 현재 페이지에 포함시킵니다. 이 영역에는 네비게이션 메뉴가 표시됩니다. -->
			</div>
			<div id="section">
				<h3>
					저희 홈페이지를 방문해주셔서 감사합니다. <br><br/>
					Have a nice day !! <br><br/>
					<img alt="home" src="/projectMVC/image/home.png">
				</h3>
			</div>
			<!-- 메인 콘텐츠가 표시될 섹션입니다. 좌측의 네비게이션 옆에 배치됩니다. 현재는 빈 상태로 설정되어 있습니다. -->
		</div>
		<div id="footer"></div>	
		<!-- 페이지의 하단 footer 영역입니다. 현재는 빈 상태로 설정되어 있습니다. 추후 콘텐츠 추가 가능. -->
	</div>
 
</body>
</html>

