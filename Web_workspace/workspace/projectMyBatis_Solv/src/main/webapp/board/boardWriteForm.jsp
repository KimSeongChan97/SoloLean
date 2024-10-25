<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
    border-collapse: collapse;
}
th, td{
    padding: 5px;
}
div{
    color: red;
    font-size: 8pt;
    font-weight: bold;
}
</style>
</head>
<body>
<h3>
    <img src="../image/4.jpg" width="100" height="100" alt="홈"
         onclick="location.href='../index.jsp'" style="cursor: pointer;">
    글 등록
</h3>
<form id="boardWriteForm">
	<table border="1">
		<tr>
        	<th width="100">제목</th>
	        <td>
	            <input type="text" id="subject" name="subject" size="50" placeholder="제목 입력">
	            <div id="subjectDiv"></div>
	        </td>
    	</tr>
    	<tr>
	        <th>내용</th>
	        <td>
	            <textarea id="content" name="content" rows="15" cols="50" placeholder="내용 입력"></textarea>
	            <div id="contentDiv"></div>
	        </td>
	    </tr>
	    <tr>
	        <td colspan="2" align="center">
	            <input type="button" value="글쓰기" id="boardWriteBtn">
	            <input type="reset" value="다시작성">
	        </td>
	    </tr>
	</table>
</form>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../js/boardWrite.js"></script>
</body>
</html>













