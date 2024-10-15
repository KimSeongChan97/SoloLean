<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 View 사이트</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/uploadView.css">
<link rel="icon" href="${pageContext.request.contextPath}/static/favicon.ico" type="image/x-icon">

</head>
<body>
<div class="home-container">
    <a href="/spring/"><i class="fa-solid fa-house"></i> HOME</a>
</div>

	<table border="1">
		<tr>
			<td rowspan="3">
				<img src="http://kr.object.ncloudstorage.com/bitcamp-9th-bucket-65/storage/${userUploadDTO.imageFileName}"
				 alt="${userUploadDTO.imageName}" class="fixed-image">
			</td>
			
			<td >번호 : ${userUploadDTO.seq }</td>
		</tr>
		
		<tr>
			<td >상품명 : ${userUploadDTO.imageName }</td>
		</tr>
		<tr>
			<td >파일명 : ${userUploadDTO.imageOriginalFileName }</td>
		</tr>
		
		<tr>
			<td colspan="2" height="100" valign="top">
				<pre>${userUploadDTO.imageContent }</pre>
			</td>
		</tr>
	</table>

	<div>
	    <input type="button" value="목록" onclick="location.href='/spring/user/uploadList'" />
	    <input type="button" value="수정" onclick="location.href='/spring/user/uploadUpdateForm?seq=${userUploadDTO.seq }'" />
	</div>
</body>
</html>
