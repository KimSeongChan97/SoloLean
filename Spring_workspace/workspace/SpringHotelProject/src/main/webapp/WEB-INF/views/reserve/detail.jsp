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
<link rel="stylesheet" href="/SpringHotel/resources/css/reserveDetail.css">
<link rel="icon" href="${pageContext.request.contextPath}/resources/static/favicon.ico" type="image/x-icon">
<title>Spring Hotel</title>
<style type="text/css">
#detailTitle, .roomInfo {
	padding: 0 15px;
}
#detailTitle {
	font-weight: bold;
	margin: 3% auto;
	float: right;
}
#detailTitle h2 {
	margin: auto;
}
#listBtn, #reviewBtn {
	margin: 5% 0.5%;
	padding: 0 15px;
	float: right;
}
#listBtn, #reviewBtn {
	background-color: #ded3c5;
	color: #382f24;
	height: 35px;
}
#listBtn:hover, #reviewBtn:hover {
	background-color: #382f24;
	color: white;
}
.name{
	margin-top: 9%;
}
.name, #name{
	margin-bottom: 4%;
}
.name h4, #name {
	padding: 4px;
}
#info div p {
	margin-bottom: 1%;
}
#type {
	margin: 0;
	margin-bottom: 10%;
	font-family: 'Playfair Display', serif;
    font-size: 3rem;
    font-weight: bold;
    color: #b8860b;
}
</style>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
	
	<div class="container" data-view="reservationList">
		<div id="detailTitle">
			<h2>예약 상세 내역</h2>
		</div>
		<div class="card mb-3" >
			<img class="col-md-6" src="https://kr.object.ncloudstorage.com/springhotel/storage/${reserveDTO.roomImgDTO.imageFileName}" width="450px" class="card-img-top" alt="">
			<div class="room-details bg-light p-5 rounded shadow-sm">
				<div class="row roomInfo">
					<div class="col-md-6" id="info">
						<h3 id="type">${reserveDTO.room.type}</h3>
						<div>
							<h4 id="name"><i class="fas fa-bed"></i>  체크인 / 체크아웃 (${reserveDTO.days}박)</h4><hr>
							<p>체크인: ${reserveDTO.checkin} 14:00</p>
							<p>체크아웃: ${reserveDTO.checkout} 11:00</p>
						</div>
	                    <div>
							<h4 class="name"><i class="fas fa-users"></i>  투숙 인원</h4><hr>
							<p>투숙 인원: ${reserveDTO.adults + reserveDTO.kids}인</p>
							<p>어른: ${reserveDTO.adults}인, 어린이: ${reserveDTO.kids}인</p>
						</div>
	                    <div>
							<h4 class="name"><i class="fas fa-money-bill-wave"></i>  금액 (${reserveDTO.days}박)</h4><hr>
	                    	<p>총 금액: ₩ ${reserveDTO.price}</p>
							<p>1박 금액: ₩ ${reserveDTO.room.price}</p>
						</div>
               		</div>
           		</div>
          	</div>
			<div class="roomInfo">
				<button type="button" class="btn btn-primary" id="listBtn" onclick="location.href='/SpringHotel/reserve/list'">예약 내역</button>
				<button type="button" class="btn btn-primary" id="reviewBtn" onclick="location.href='/SpringHotel/room/detail/${reserveDTO.roomId}'">리뷰 작성</button>
			</div>
		</div>
	</div>
	
<jsp:include page="../common/footer.jsp" />
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="/SpringHotel/resources/js/bootstrap.js"></script>
<script src="/SpringHotel/resources/js/header.js"></script>
</body>
</html>