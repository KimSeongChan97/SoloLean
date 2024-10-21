<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Hotel 회원 조회</title>
<link rel="stylesheet" href="/SpringHotel/resources/css/adminCSS.css">
<link rel="stylesheet" href="/SpringHotel/resources/css/headerCSS.css">
<link rel="stylesheet" href="/SpringHotel/resources/css/bootstrapCSS.css">
</head>

<body>
	<%@ include file="../common/header.jsp" %>
	<div id="reserveTitle">
		<font size="20">회원 조회</font>
	</div>
	<input type="hidden" id="pg" value="${pg }" />
	
	<table align="center" class="reserveInfo">
		<tr align="center" id="list">
			<td>성함</td>
			<td>ID</td>
			<td>PWD</td>
			<td>전화번호</td>
			<td>e-mail</td>
		</tr>
		<c:if test="${map2.list != null }">
			<c:forEach var="userDTO" items="${map2.list }" >
				<tr align="center">
					<td>${userDTO.getName() }</td>
					<td>${userDTO.getUserId() }</td>
					<td>${userDTO.getPwd() }</td>
					<td>${userDTO.getTel1()}-${userDTO.getTel2()}-${userDTO.getTel3()}</td> <!-- 전화번호 출력 -->
					<td>${userDTO.getEmail() }</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${map2.list == null}">
			<tr>
				<td colspan="5" align="center">가입한 회원이 존재하지 않습니다</td>
			</tr>
		</c:if>
	</table>
	<div class="pagination">
	    ${map2.adminPaging.pagingHTML}
	</div>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="/SpringHotel/resources/js/bootstrap.js"></script>
<script src="/SpringHotel/resources/js/header.js"></script>
<script type="text/javascript">
function adminPaging(pg){
	location.href = "/SpringHotel/admin/checkUser?pg=" + pg;
}
</script>
</body>
</html>