<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Spring Hotel Q&A</title>
	<meta name="viewport" content="width=device-width", initial-scale="1">
	<link rel="stylesheet" href="/SpringHotel/resources/css/inquiryCSS.css">
	<link rel="stylesheet" href="/SpringHotel/resources/css/adminCSS.css">
	<link rel="stylesheet" href="/SpringHotel/resources/css/bootstrap.css">
	<link rel="stylesheet" href="/SpringHotel/resources/css/header.css">
</head>

<body>
<jsp:include page="../common/header.jsp"/>
	<div id="reserveTitle"><font size="20">	Q&A</font></div>

	<input type="hidden" id="pg" value="${pg }" />
	
	<table align="center" class="reserveInfo">
	    <tr align="center" id="list">
	        <td>NO</td>
	        <td>작성자</td>
	        <td>문의 유형</td>
	        <td>내용</td>
	        <td>작성일</td>
	    </tr>
	    
	    <c:choose>
	        <c:when test="${map2.list != null}">
	            <c:forEach items="${map2.list}" var="questionsDTO">
	                <tr align="center">
	                    <td>${questionsDTO.questionsId}</td>
	                    <td>${questionsDTO.userName}</td> 
	                    <td>${questionsDTO.typename}</td>
	                    <input type="hidden" name="seq" value="${questionsDTO.seq}">
	                    <td><a href="/SpringHotel/admin/inquiryDetail2?questionsId=${questionsDTO.questionsId}&userName=${questionsDTO.userName}&typename=${questionsDTO.typename}&seq=${questionsDTO.seq}"><b>${questionsDTO.content}</b></a></td>
	                    <td>${questionsDTO.logtime}</td>
	                </tr>
	            </c:forEach>
	        </c:when>
	        <c:otherwise>
	            <tr>
	                <td colspan="5" align="center">작성된 글이 없습니다</td>
	            </tr>
	        </c:otherwise>
	    </c:choose>
	</table>
	
	<div style="text-align: center; margin-top: 20px;">
	    <a href="/SpringHotel/admin/inquiryWrite">
	        <button class="btn small-btn" style="margin-bottom: 20px;">글쓰기</button>
	    </a>
	</div>
	
	<div class="pagination" style="align-items: center;">
	    ${map2.adminPaging.pagingHTML}
	</div>
<script type="text/javascript">
function adminPaging(pg){
	location.href = "/SpringHotel/admin/inquiryList2?pg=" + pg;
}
</script>
</body>
</html>
