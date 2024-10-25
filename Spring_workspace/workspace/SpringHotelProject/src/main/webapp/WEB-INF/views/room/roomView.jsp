<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/SpringHotel/resources/css/bootstrap.css">
    <link rel="stylesheet" href="/SpringHotel/resources/css/footer.css">
    <link rel="icon" href="/SpringHotel/resources/static/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="/SpringHotel/resources/css/room.css">
    <title>Room Information - Hotel S&H</title>
</head>
<body>

    <!-- header -->
    <jsp:include page="../common/header.jsp" />

    <div class="container main" data-view="roomView">
        <!-- 페이지 타이틀 -->
        <h2 class="my-4 text-center">
            <i class="fas fa-bed"></i> 객실 정보
        </h2>

        <!-- Bootstrap Carousel 사용 -->
        <div id="roomCarousel" class="carousel slide main" data-bs-ride="carousel">
            <div class="carousel-inner">
                <c:forEach var="room" items="${rooms}" varStatus="status">
                    <div class="carousel-item ${status.index == 0 ? 'active' : ''}">
                        <div class="card shadow-sm roomInfo">
                            <img class="card-img-top"
                                src="https://kr.object.ncloudstorage.com/springhotel/storage/${room.roomImg.imageFileName}"
                                alt="${room.type}">
                            <div class="card-body">
                                <h5 class="card-title">${room.type}</h5>
                                <p class="card-text">크기: ${room.size}m² | 수용 인원: ${room.capacity}명</p>
                                <p class="card-text">가격: ₩${room.price}</p>
                                <p class="card-text">${room.description}</p>
                                <div class="d-flex justify-content-between align-items-center">
                                    <button class="btn btn-outline-primary"
                                        onclick="location.href='${pageContext.request.contextPath}/room/detail/${room.roomId}'">
                                        상세 보기
                                    </button>
                                    <button class="btn btn-primary" 
                                    onclick="location.href='${pageContext.request.contextPath}/reserve/main'">예약</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            
    
		    <!-- 부대시설 정보 섹션 -->
		    <div class="amenity-section bg-light p-4 rounded">
		        <h3><i class="fas fa-dumbbell"></i> 부대시설</h3>
		        <table class="table">
		            <!-- 부대시설 정보 나열 -->
		            <tr>
		                <td>
		                    <h4><i class="fas fa-check-circle"></i> 피트니스 센터 무료 이용</h4>
		                    <ul class="list-unstyled">
		                        <li>이용 가능 시간: 06:00 ~ 22:00</li>
		                    </ul>
		                </td>
		            </tr>
		            <tr>
		                <td>
		                    <h4><i class="fas fa-calendar-alt"></i> 피트니스 센터 휴일</h4>
		                    <ul class="list-unstyled">
		                        <li>매월 세 번째 수요일 정기 휴일</li>
		                    </ul>
		                </td>
		            </tr>
		            <tr>
		                <td>
		                    <h4><i class="fas fa-swimmer"></i> 실내 수영장</h4>
		                    <ul class="list-unstyled">
		                        <li>만 13세 이상 입장 가능</li>
		                        <li>이용 가능 시간: 07:00 ~ 21:00</li>
		                    </ul>
		                </td>
		            </tr>
		            <tr>
		                <td>
		                    <h4><i class="fas fa-hot-tub"></i> 사우나</h4>
		                    <ul class="list-unstyled">
		                        <li>유료 이용</li>
		                        <li>이용 가능 시간: 07:00 ~ 22:00</li>
		                    </ul>
		                </td>
		            </tr>
		            <tr>
		                <td>
		                    <h4><i class="fas fa-parking"></i> 무료 주차</h4>
		                    <ul class="list-unstyled">
		                        <li>투숙 기간 내 무료 주차 가능</li>
		                    </ul>
		                </td>
		            </tr>
		        </table>
		    </div>
	
			<!-- 호텔 정보 섹션 -->
			<div class="hotel-info bg-light p-4 mt-5 rounded">
				<h3>
					<i class="fas fa-hotel"></i> 호텔 정보
				</h3>
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
								<i class="fas fa-clock"></i> 체크인 / 체크아웃 시간
							</h4>
							<ul class="list-unstyled">
								<li>체크인 : 오후 2시 이후</li>
								<li>체크아웃 : 오전 11시</li>
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
				</table>
	    	</div>
	    </div>
    </div>
    
    <!-- footer -->
    <jsp:include page="../common/footer.jsp" />
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- 최신 jQuery -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    <script src="/SpringHotel/resources/js/bootstrap.js"></script>
    <script src="/SpringHotel/resources/js/header.js"></script>
</body>
</html>
