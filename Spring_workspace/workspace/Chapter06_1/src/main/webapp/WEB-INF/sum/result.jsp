<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result Page</title>
<link rel="stylesheet" href="css/result.css">
</head>
<body>
	
	<div class="result-text">
        <%-- ${param.x} + ${param.y } = ${param.x + param.y } --%>
        ${x } + ${y } = ${x + y }
    </div>
	<form action="input.do" method="get">
	     <input type="submit" value="Back" />
	 </form>	
	 <!-- forwarding 방식이므로 전체 데이터를 가져옴 -->
</body>
</html>