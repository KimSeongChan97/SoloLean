<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="/SpringHotel/resources/css/bootstrap.css">
<link rel="stylesheet" href="/SpringHotel/resources/css/custom.css">
<link rel="stylesheet" href="/SpringHotel/resources/css/footer.css">
<link rel="stylesheet" href="/SpringHotel/resources/css/reserveList.css">
<link rel="icon" href="${pageContext.request.contextPath}/resources/static/favicon.ico" type="image/x-icon">
<title>Spring Hotel</title>
<style type="text/css">
a {
	text-decoration: none;
}
#noData {
	margin-top: 10%;
}

#reserveId {
	color: black;
}
</style>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
	
	<div class="container" data-view="reservationList">
		<div id="menu2">
			<table width="80%" align="center" class="reserve table">
				<thead>
					<tr align="center" id="colName" style="color:#a0a0a0; font-weight:bold;">
						<td><div id="reserveId">예약 번호</div></td>
						<td><div id="roomType">객실</div></td>
						<td><div id="reserveDate">숙박일</div></td>
						<td><div id="reservePrice">금액</div></td>
						<td><div id="reserveTime">예약 날짜</div></td>
					</tr>
				</thead>
				<tbody>
					<c:if test="${reserveDTOList.size() == 0}">
						<tr align="center">
							<td colspan="5"><div id="noData">예약 내역이 존재하지 않습니다.</div></td>
						</tr>
					</c:if>
					<c:forEach items="${reserveDTOList }" var="reserveDTO">
						<tr id="calVal" align="center">
							<td><a href="/SpringHotel/reserve/list/detail?reserveId=${reserveDTO.reserveId }"><div id="reserveId">${reserveDTO.reserveId }</div></a></td>
							<td><div id="roomType">${reserveDTO.room.type }</div></td>
							<td><div id="reserveDate">${reserveDTO.days }박</div></td>
							<td><div id="reservePrice">₩ ${reserveDTO.price }</div></td>
							<td><div id="reserveTime">${reserveDTO.time.split(" ")[0] }</div></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
<jsp:include page="../common/footer.jsp" />
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="/SpringHotel/resources/js/bootstrap.js"></script>
<script src="/SpringHotel/resources/js/header.js"></script>
<script src="/SpringHotel/resources/js/reservation.js"></script>
</body>
</html>