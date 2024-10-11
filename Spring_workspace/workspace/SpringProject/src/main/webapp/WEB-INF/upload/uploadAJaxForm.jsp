<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드(AJax) 페이지</title>
<!-- Font Awesome을 이용하여 아이콘을 사용할 수 있게 해주는 CSS 파일을 로드합니다. -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<!-- 외부 CSS 파일을 불러와 스타일을 적용합니다. -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/uploadForm.css">
</head>
<body>
<!-- 홈으로 돌아가는 링크를 제공합니다. Font Awesome의 집 모양 아이콘을 사용하고 있습니다. -->
<a href="/spring/"><i class="fa-solid fa-house"></i> HOME</a>
<br/>

<!-- 
    파일 업로드를 위한 AJAX 폼입니다. 이 폼은 전송시 전체 페이지를 새로고침하지 않고, 비동기식으로 서버와 통신합니다. 
    입력된 데이터와 파일은 JavaScript로 처리하여 서버로 전송됩니다.
-->
<form id="uploadAJaxForm">
	<table border="1">
		<tr>
			<!-- 상품명을 입력할 수 있는 행입니다. -->
			<th>상품명</th>
			<td>
				<!-- 상품명을 입력하는 필드입니다. 크기를 설정하기 위해 size 속성이 사용되었으며, 아이콘도 함께 표시됩니다. -->
				<i class="fa-solid fa-pen-to-square"></i><input type="text" name="imageName" size="35" />
			</td>
		</tr>
		<tr>
			<!-- 상품 설명을 입력할 수 있는 필드입니다. -->
			<td colspan="2">
				<!-- 상품 설명을 여러 줄로 입력할 수 있도록 다중행 텍스트 필드를 사용했습니다. rows와 cols 속성으로 필드 크기를 지정합니다. -->
				<textarea name="imageContent" rows="10" cols="50"></textarea>
				<i class="fa-brands fa-google"></i>
			</td>
		</tr>
		
		<tr>
			<!-- 파일 업로드 필드입니다. 여러 개의 파일을 업로드할 수 있으며, 파일 선택을 돕기 위해 카메라 아이콘을 추가했습니다. -->
			<td colspan="2">
				<!-- 이미지를 선택하는 부분입니다. 카메라 아이콘을 클릭하면 파일 선택 창이 열리도록 설정되어 있습니다. -->
				<i class="fa-solid fa-camera-retro" 
					alt="이미지 선택" width="50" height="50"
					id="camera" >
					이미지 선택
				</i>
				<!-- 사용자가 선택한 이미지 목록을 표시하는 영역입니다. -->
				<span id="showImageList"> 이미지 미리보기 </span>
				<!-- 파일 선택 필드입니다. 여러 개의 파일을 선택할 수 있도록 multiple 속성을 사용하였으며, visibility를 hidden으로 설정하여 보이지 않게 처리했습니다. -->
				<input type="file" style="visibility: hidden;" name="img[]" id="img" multiple="multiple"  />
			</td>
		</tr>
		<tr>
			<!-- 업로드 및 취소 버튼을 표시하는 행입니다. -->
			<td colspan="2" align="center">
				<!-- 이미지를 업로드하는 버튼입니다. 버튼 클릭 시 자바스크립트가 동작하여 비동기적으로 파일을 업로드합니다. -->
				<input type="button" value="이미지 업로드" id="uploadAJaxBtn" />  <i class="fa-solid fa-arrow-up"></i>
				<!-- 취소 버튼은 입력 필드들을 초기화하는 역할을 합니다. -->
				<input type="reset" value="취소" />  <i class="fa-solid fa-xmark"></i>
			</td>
		</tr>			
	</table>
</form>

<!-- jQuery 라이브러리를 사용하여 폼 전송 및 이미지 미리보기를 처리합니다. -->
<script type="text/javascript" src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
<!-- 별도의 JavaScript 파일에서 폼의 비동기 처리를 담당합니다. -->
<script type="text/javascript" src="../js/uploadAJax.js"></script>

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


<!-- 
FileReader 란?
FileReader는 type이 file인 input 태그 또는 API 요청과 같은 인터페이스를 통해 
File 또는 Blob 객체를 편리하게 처리할수있는 방법을 제공하는 객체이며
abort, load, error와 같은 이벤트에서 발생한 프로세스를 처리하는데 주로 사용되며,
File 또는 Blob 객체를 읽어서 result 속성에 저장한다.

FileReader도 비동기로 동작한다.

FileReader.onload()
load 이벤트의 핸들러. 이 이벤트는 읽기 동작이 성공적으로 완료되었을 때마다 발생한다.
-->

