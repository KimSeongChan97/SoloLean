<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Format 에 대하여</title>
</head>
<body>

<fmt:formatNumber type="number" value="123456789" /><br>
<fmt:formatNumber type="number" value="123456789.88" /><br>
<fmt:formatNumber type="number" value="123456789.88" maxFractionDigits="1" /><br>
<br/>

<fmt:formatNumber type="number" value="123456.78" pattern="#,###"/><br>
<fmt:formatNumber type="number" value="123456.789" pattern=".##" /><br>
<fmt:formatNumber type="number" value="123456.789" pattern="#,###.##" /><br>
<br/>

<fmt:formatNumber type="number" value="0000.00" pattern="#,###.##" /><br>
<fmt:formatNumber type="number" value="0000.00" pattern="0,000.00" /><br> <!-- 강제로 0을 표사 -->
<fmt:formatNumber type="number" value="12.3" pattern="000.00" /><br>
<br/>

<!-- 날짜 형식 -->

<c:set var="now" value="<%=new java.util.Date()%>"/>
<c:out value="${now}"/><br>
date : <fmt:formatDate value="${now }" type="date"/><br>
time : <fmt:formatDate value="${now }" type="time"/><br>
both : <fmt:formatDate value="${now }" type="both"/><br>
<br><br>

<fmt:formatDate value="${now }" pattern="yyyy-MM-dd hh:mm" type="both" /><br>
<fmt:formatDate value="${now }" pattern="yyyy-MM-dd hh:mm" type="date" /><br>
<fmt:formatDate value="${now }" pattern="yy-MM-dd E요일 a" type="date" /><br>
<fmt:formatDate value="${now }" pattern="HH:mm:ss" type="time" /><br>



</body>
</html>