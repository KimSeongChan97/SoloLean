<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload File Update Page</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/uploadUpdate.css">
<link rel="icon" href="${pageContext.request.contextPath}/static/favicon.ico" type="image/x-icon">

</head>
<body>
<div class="home-container">
    <a href="/spring/"><i class="fa-solid fa-house"></i> HOME</a>
</div>
	
	<form  id="uploadUpdateForm">
	
		<input type="hidden" name="seq" size="35" value="${userUploadDTO.seq }">
	<table border="1">
		<tr>
			<th>상품명</th>
			<td>
				<i class="fa-solid fa-pen-to-square"></i><input type="text" 
				name="imageName" size="35" value="${userUploadDTO.imageName }"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<textarea name="imageContent" rows="10" cols="50" >${userUploadDTO.imageContent }</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<span id="showImageList"> 
					<img src="http://kr.object.ncloudstorage.com/bitcamp-9th-bucket-65/storage/${userUploadDTO.imageFileName}" 
						alt="${userUploadDTO.imageName }">
				 </span>
				 
				<i class="fa-solid fa-camera-retro" 
					alt="이미지 선택" width="100" height="100"
					id="camera" >
				</i>
				<input type="file" style="visibility: hidden;" name="img" id="img" />
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="수정" id="uploadUpdateBtn" />  
				<input type="reset" value="취소" /> 
			</td>
		</tr>			
	</table>
</form>
	
	<div>
	    <input type="button" value="목록" onclick="location.href='/spring/user/uploadList'" />
	</div>
	
	
<script src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/uploadUpdate.js"></script>
<script type="text/javascript">
$('#camera').click(function(){
	// 카메라 아이콘 클릭 시 파일 선택 창이 강제로 열리도록 설정합니다.
	$('#img').trigger('click'); // 강제 이벤트 발생시킴
});

// 이미지 미리보기 처리
$('#img').change(function(){
	// 이미지 미리보기 영역을 비웁니다.
	$('#showImageList').empty();
	
	// 선택된 파일들을 순차적으로 읽어서 미리보기로 출력합니다.
	for(var i=0; i<this.files.length; i++){
		readURL(this.files[i]);
	}
});

// 선택된 파일을 화면에 미리보는 함수
function readURL(file){
	var reader = new FileReader(); // FileReader 객체를 생성하여 파일을 읽습니다.
	
	var show;
	reader.onload = function(e){
		// 파일을 성공적으로 읽은 후, 미리보기로 보여줄 이미지 태그를 생성합니다.
		var img = document.createElement('img'); // 이미지 태그를 동적으로 생성
		img.src = e.target.result; // 파일 데이터를 이미지 소스로 설정
		img.width = 70; // 미리보기 이미지의 너비 설정
		img.height = 70; // 미리보기 이미지의 높이 설정
		$('#showImageList').append(img); // 미리보기 영역에 이미지 추가
	}
	
	reader.readAsDataURL(file); // 파일을 읽어 데이터 URL로 변환
}

</script>
	
</body>
</html>