<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	background-color: #0d0d0d;
	color: #00ffcc;
	text-align: center;
	margin-top: 90px;
}

</style>
</head>
<body>
<link rel="stylesheet" type="text/css" href="/projectMVC/css/logincss.css">

<jsp:include page="/jsp/nav.jsp" />

<script type="text/javascript">
window.onload = function(){
	alert("로그아웃");
	location.href = "/projectMVC/index.do";
}
</script>
</body>
</html>
















