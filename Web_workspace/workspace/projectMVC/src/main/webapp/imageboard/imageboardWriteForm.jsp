<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 등록 페이지</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/index.css">
<style type="text/css">

table {
    border-collapse: collapse;
}

th, td{
    padding: 5px;
}

#imageboardWriteForm {
	display: flex;
	flex-direction: column;
	align-items: center;
	margin: 30px auto;
	text-align: left;
	background-color: #1a1a1a; /* 어두운 배경 */
	padding: 20px;
	border-radius: 10px; /* 둥근 모서리 */
	box-shadow: 0 0 10px #00ffcc; /* 네온 그림자 */
}

#imageboardWriteForm div {
    color: #ff00ff; /* 네온 색상 */
    font-size: 10pt;
    font-weight: bold;
}

input[type="text"], textarea {
    background-color: #333333; /* 어두운 입력 배경 */
    color: #00ffcc; /* 네온 색상 텍스트 */
    border: 1px solid #00ffcc; /* 네온 테두리 */
    padding: 10px;
    width: 100%;
    box-sizing: border-box;
}

input[type="button"], input[type="reset"] {
    background-color: #00ffcc; /* 네온 배경 */
    color: #0d0d0d; /* 어두운 텍스트 */
    border: none;
    padding: 10px 20px;
    cursor: pointer;
    margin: 10px;
    transition: background-color 0.3s;
    border-radius: 25px;    
}

input[type="button"]:hover, input[type="reset"]:hover {
    background-color: #00ffcc; /* 호버 시 네온 색상 변경 */
    box-shadow: 0 0 10px cyan, 0 0 20px cyan, 0 0 30px cyan, 0 0 40px cyan;
    transition: box-shadow 1.5s ease; /* 박스 그림자가 서서히 변하도록 설정 */
    border-radius: 25px; /* 버튼의 모서리를 둥글게 설정 */
}

/* 버튼을 테이블 가운데 하단에 배치 */
.table-buttons {
    text-align: center;
    padding-top: 20px;
}
</style>
</head>
<body>
<div id="wrap">
<div id="header">
	<!-- 페이지의 상단 헤더 영역입니다. -->
	<h1>
		<img alt="사과" src="${ pageContext.request.contextPath }/image/apple.png" 
			width="50" height="50" 
			onclick="location.href='${ pageContext.request.contextPath }/index.do'" 
			style="cursor: pointer;">
		MVC를 활용한 미니프로젝트
	</h1>
		<hr style="border-color: #483D8B; border-width: 5px;" />
</div>
		
	<div id="container">	
	<jsp:include page="../main/imageboardMenu.jsp" />	
	
		<div id="section">
<form id="imageboardWriteForm" method="post" enctype="multipart/form-data" > 
		<!-- multipart/form-data 는 파일 업로드 이다. -->
<table border="1">
    <tr>
        <th width="100">상품코드</th>
        <td>
            <input type="text" id="subject" name="subject" size="70" placeholder="제목 입력">
            <div id="subjectDiv"></div>
        </td>
    </tr>
    
    <tr>
        <th width="100">상품명</th>
        <td>
            <input type="text" id="subject" name="subject" size="70" placeholder="제목 입력">
            <div id="subjectDiv"></div>
        </td>
    </tr>
    
    <tr>
        <th width="100">상품단가</th>
        <td>
            <input type="text" id="subject" name="subject" size="70" placeholder="제목 입력">
            <div id="subjectDiv"></div>
        </td>
    </tr>
    
    <tr>
        <th width="100">상품수량</th>
        <td>
            <input type="text" id="subject" name="subject" size="70" placeholder="제목 입력">
            <div id="subjectDiv"></div>
        </td>
    </tr>
    
    <tr>
        <th>상품 내용</th>
        <td>
            <textarea id="imageContent" name="imageContent" rows="10" cols="50" ></textarea>
            <div id="imageContentDiv"></div>
        </td>
    </tr>
    
    <tr>
        <td colspan="2">
        	<input type="file" id="image1" name="image1" >
        	<div id="image1Div"></div>
        </td>
    </tr>
    
    
    <tr>
        <td colspan="2" class="table-buttons">
            <input type="button" value="이미지 등록" id="imageboardWriteBtn">
            <input type="reset" value="다시작성">
        </td>
    </tr>
</table>
</form>
		</div>
	</div>
</div>
<script src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/boardWrite.js"></script>

</body>
</html>