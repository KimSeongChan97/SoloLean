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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<link rel="stylesheet" href="/SpringHotel/resources/css/reserveCSS.css">
<link rel="stylesheet" href="/SpringHotel/resources/css/reserveMenu.css">
<link rel="icon" href="${pageContext.request.contextPath}/resources/static/favicon.ico" type="image/x-icon">
<title>Spring Hotel</title>
<style type="text/css">
#menu2 #roomType, .roomInfo {
	padding: 0 15px;
}
#menu2 #roomType {
	height: 100px;
	font-weight: bold;
	margin: 0 auto;
}

#menu2 #roomType h2 {
	margin: 0 auto;
	font-family: 'Playfair Display', serif;
    font-size: 3rem;
    font-weight: bold;
    color: #b8860b;
}
</style>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
	
	<div class="container" data-view="reservation" data-menu="3">
	
		<!-- 메인 메뉴 -->
		<div id="reservation">
			<!-- 예약 순서 --> 
			<jsp:include page="./menu.jsp"/>
			<!-- 예약 화면 -->
			<div id="menu2">
				<div id="roomType">
					<h2>
						${reserveDTO.room.type }
					</h2>
					<h4>
						예약 옵션
					</h4>
				</div>
				
				<div class="card mb-3" >
					<img class="col-md-6" src="https://kr.object.ncloudstorage.com/springhotel/storage/${reserveDTO.room.roomImg.imageFileName}" width="450px" class="card-img-top" alt="">
					<div class="room-details bg-light p-5 rounded shadow-sm">
						<div class="row roomInfo">
							<div class="col-md-6"> <span id="roomId" hidden>${reserveDTO.room.roomId}</span>
								<p><i class="fa fa-calendar"></i> 체크인: <span id="checkin">${reserveDTO.checkin}</span> 14:00</p>
			                    <p><i class="fa fa-calendar"></i> 체크아웃: <span id="checkout">${reserveDTO.checkout}</span> 11:00</p>
			                    <p><i class="fas fa-users"></i> 어른: <span id="adults">${reserveDTO.adults}</span>인</p>
			                    <p><i class="fas fa-users"></i> 어린이: <span id="kids">${reserveDTO.kids}</span> 인</p>
			                    <p><i class="fas fa-users"></i> 투숙 인원: ${reserveDTO.adults + reserveDTO.kids}인</p>
			                    <p><i class="fas fa-money-bill-wave"></i> 총 금액: ₩ <span id="price">${reserveDTO.price}</span> </p>
			                    <p><i class="fas fa-money-bill-wave"></i> 객실 정보: ${reserveDTO.room.view}</p>
			                    <p><i class="fas fa-expand-arrows-alt"></i> 객실 면적: ${reserveDTO.room.size} m²</p>
	                		</div>
	            		</div>
		          	</div>
				</div>
			</div>
			
			<div class="hotel-info bg-light p-4 mt-5 rounded">
				<table class="table">
					<tr>
						<td>
							<h4>
								<i class="fas fa-utensils"></i> 조식 이용 안내
							</h4>
							<ul class="list-unstyled">
								<li>다이닝 존 (뷔페) : 07:30 ~ 10:30</li>
							</ul>
						</td>
					</tr>
					<tr>
						<td>
							<h4>
								<i class="fas fa-clock"></i> 체크인 / 체크아웃
							</h4>
							<ul class="list-unstyled">
								<li>체크인 : ${reserveDTO.checkin} 14:00</li>
								<li>체크아웃 : ${reserveDTO.checkout} 11:00</li>
							</ul>
						</td>
					</tr>
					<tr>
						<td>
							<h4>
								<i class="fas fa-calendar-times"></i> 예약 취소/변경 및 No-Show 안내
							</h4>
							<ul class="list-unstyled">
								<li>숙박 예정일 7일 전: 위약금 없음</li>
								<li>숙박 예정일 6일 전 ~ 1일 전 : 1박 요금의 20%</li>
								<li>숙박 예정일 1일 전 (18시 이후 취소 및 변경): 1박 요금의 80%</li>
							</ul>
						</td>
					</tr>
					<tr>
						<td>
							<button type="button" class="btn btn-primary" id="reserveBtn">예약하기</button>
						</td>
					</tr>
				</table>
			</div>
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