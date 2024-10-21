<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Hotel RoomInfo</title>
<link rel="stylesheet" href="/SpringHotel/resources/css/adminCSS.css">
<link rel="stylesheet" href="/SpringHotel/resources/css/headerCSS.css">
<link rel="stylesheet" href="/SpringHotel/resources/css/bootstrapCSS.css">
<style>
#updateBtn {
	margin: 1% auto;
	background-color: #382f24;
	width: 110px;
	height: 50px;
	border: none;
	font-size: medium;
	color: #f1ebd5;
}
</style>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	<div id="inquiryTitle">
		<font size="20">객실 정보 수정</font>
	</div>

	<form id="updateRoomInfo" action="/SpringHotel/admin/update" method="post" enctype="multipart/form-data">
		<table align="center" class="inquiryDetail">
			<tr>
				<td id="detail">객실 타입</td>
				<td align="center">
					<img id="roomImage" src="https://kr.object.ncloudstorage.com/springhotel/storage/${roomDTO.roomImg.imageFileName}" width="300" height="250" name=""><br /> 
					<input type="text" class="writeTitle" name="type" value="${roomDTO.getType()}" readonly="readonly" size="15" />
				</td>
			</tr>
			<tr>
				<td id="detail">객실 크기(㎡)</td>
				<td>
					<input type="text" class="writeTitle" name="size" value="${roomDTO.getSize()}" required="required" pattern="[0-9]+" size="15" />
				</td>
			</tr>
			<tr>
				<td id="detail">수용 인원(명)</td>
				<td>
					<input type="text" class="writeTitle" name="capacity" value="${roomDTO.getCapacity()}" required="required" pattern="[0-9]+" size="15" />
				</td>
			</tr>
			<tr>
				<td id="detail">금 액(원)</td>
				<td>
					<input type="text" class="price" name="price" onkeyup="inputNumberFormat(this)" value="${roomDTO.getPrice()}" required="required" pattern="[0-9]+" size="15" />
				</td>
			</tr>
			<tr>
				<td id="detail">객실 수(개)</td>
				<td>
					<input type="text" class="writeTitle" name="count" value="${roomDTO.getCount()}" required="required" pattern="[0-9]+" size="15" />
				</td>
			</tr>
			<tr>
				<td id="detail">이미지 업로드</td>
				<td>
					<input type="file" id="imgBtn" name="img" accept="image/*" required onchange="previewImage(this)" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="hidden" name="roomId" value="${roomDTO.getRoomId()}"> 
					<input type="submit" id="updateBtn" value="수정완료" />
				</td>
			</tr>
		</table>
	</form>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="/SpringHotel/resources/js/bootstrap.js"></script>
<script src="/SpringHotel/resources/js/header.js"></script>
<script>
function previewImage(input) {
    if (input.files && input.files[0]) {
        const reader = new FileReader();
        reader.onload = function(e) {
            const img = document.getElementById('roomImage');
            img.src = e.target.result; // 선택한 이미지의 결과를 img 태그의 src로 설정
        }
        reader.readAsDataURL(input.files[0]); // 파일을 Data URL로 변환하여 읽기
    }
}
</script>

</body>
</html>
