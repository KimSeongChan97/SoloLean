<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Spring Hotel 예약 내역 조회</title>
	<link rel="stylesheet" href="/SpringHotel/resources/css/adminCSS.css">
<link rel="stylesheet" href="/SpringHotel/resources/css/headerCSS.css">
<link rel="stylesheet" href="/SpringHotel/resources/css/bootstrapCSS.css">
</head>

<body>
	<%@ include file="../common/header.jsp" %>
	
	<div id="reserveTitle"><font size="20">예약 내역</font></div>
	
	<input type="hidden" id="pg" value="${pg }" />

	<table align="center" class="reserveInfo">
		<tr align="center" id="list">
			<td>NO</td>
			<td>ID</td>
			<td>성인 투숙객 수(명)</td>
			<td>어린이 투숙객 수(명)</td>
			<td>체크인</td>
			<td>체크아웃</td>
			<td>객실</td>
			<td>금액(원)</td>
			<td>예약시간</td>
		</tr>
				
		<c:choose>
			<c:when test="${map2.list != null }">
				<c:forEach items="${map2.list }" var="reserveDTO">
					<tr align="center">
						<td>${reserveDTO.getReserveId() }</td>
						<td>${reserveDTO.getRoomId() }</td>
						<td>${reserveDTO.getAdults() }</td>
						<td>${reserveDTO.getKids() }</td>
						<td>${reserveDTO.getCheckin() }</td>
						<td>${reserveDTO.getCheckout() }</td>
						<td>${reserveDTO.getRoom().getType()}</td>
						<td><fmt:formatNumber value="${reserveDTO.getPrice()}" pattern="#,###" />원</td>
						<td>${reserveDTO.getTime() }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr align="center"><td colspan="9" align="center">예약 내역이 존재하지 않습니다</td></tr>
			</c:otherwise>
		</c:choose>
						
	</table>
	<div class="pagination">
	    ${map2.adminPaging.pagingHTML}
	</div>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="/SpringHotel/resources/js/bootstrap.js"></script>
<script src="/SpringHotel/resources/js/header.js"></script>
<script type="text/javascript">
function adminPaging(pg){
	location.href = "/SpringHotel/admin/checkReserve?pg=" + pg;
}
</script>			
</body>
</html>