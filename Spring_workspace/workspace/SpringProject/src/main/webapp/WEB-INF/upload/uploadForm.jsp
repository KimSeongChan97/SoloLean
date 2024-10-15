<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 페이지</title>
<!-- Font Awesome을 이용하여 아이콘을 사용할 수 있게 해주는 CSS 파일을 로드합니다. -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<!-- 외부 CSS 파일을 불러와 스타일을 적용합니다. -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/uploadForm.css">
<link rel="icon" href="${pageContext.request.contextPath}/static/favicon.ico" type="image/x-icon">

</head>
<body>
<!-- 홈으로 돌아가는 링크를 제공합니다. Font Awesome의 집 모양 아이콘을 사용하고 있습니다. -->
<a href="/spring/"><i class="fa-solid fa-house"></i> HOME</a>
<br/>

<!-- 
    enctype 속성에 "multipart/form-data"를 설정하여 폼에서 파일을 함께 전송할 수 있게 설정.
    action은 파일 업로드 처리를 위한 서버의 URL을 지정하고 있습니다.
-->
<form method="post" enctype="multipart/form-data" action="/spring/user/upload">
	<table border="1">
		<tr>
			<!-- 상품명 입력을 위한 행입니다. -->
			<th>상품명</th>
			<td>
				<!-- 상품명을 입력할 수 있는 입력 필드입니다. size 속성으로 필드 크기를 설정하고 있으며, 아이콘도 추가되었습니다. -->
				<i class="fa-solid fa-pen-to-square"></i><input type="text" name="imageName" size="35" />
			</td>
		</tr>
		<tr>
			<!-- 상품 설명을 입력할 수 있는 행입니다. -->
			<td colspan="2">
				<!-- 다중행 텍스트 입력 필드입니다. rows는 줄 수, cols는 칸 수를 지정합니다. 아이콘이 포함되어 있습니다. -->
				<textarea name="imageContent" rows="10" cols="50"></textarea>
				<i class="fa-brands fa-google"></i>
			</td>
		</tr>
		<%-- 
		<tr>
			<!-- 파일 선택을 위한 입력 필드입니다. 단일 파일 업로드만 지원합니다. -->
			<td colspan="2"><i class="fa-solid fa-image"></i>
				<input type="file" name="img">
			</td>
		</tr>
		<!-- 다중 파일 업로드를 지원하기 위해 같은 name 속성을 사용합니다. -->
		<tr>
			<td colspan="2"><i class="fa-solid fa-image"></i>
				<input type="file" name="img">
			</td>
		</tr>
		--%>
		<!-- 
			파일 업로드 시 한번에 여러 파일을 업로드할 수 있는 필드입니다. 
			서버에서는 List로 파일을 받을 수 있습니다. multiple 속성으로 다중 선택을 허용합니다.
		-->
		<tr>
			<td colspan="2"><i class="fa-solid fa-image"></i>
				<input type="file" name="img[]" multiple="multiple" />
			</td>
		</tr>
		<tr>
			<!-- 이미지 업로드 및 취소 버튼을 제공하는 마지막 행입니다. -->
			<td colspan="2" align="center">
				<!-- 이미지를 업로드할 때 사용하는 버튼입니다. 아이콘이 함께 표시됩니다. -->
				<input type="submit" value="이미지 업로드" />  <i class="fa-solid fa-arrow-up"></i>
				<!-- 취소 버튼입니다. 입력 필드를 초기화합니다. 아이콘이 함께 표시됩니다. -->
				<input type="reset" value="취소" />  <i class="fa-solid fa-xmark"></i>
			</td>
		</tr>			
	</table>
</form>

<!-- jQuery 라이브러리를 사용하여 이벤트 처리 및 Ajax 통신을 쉽게 할 수 있도록 추가합니다. -->
<script src="http://code.jquery.com/jquery-3.7.1.min.js"></script>

</body>
</html>
