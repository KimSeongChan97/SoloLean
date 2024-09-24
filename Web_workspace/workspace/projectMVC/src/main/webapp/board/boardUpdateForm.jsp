<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/index.css">
<style type="text/css">
table {
    border-collapse: collapse;
}

th, td{
    padding: 5px;
}

#boardUpdateForm {
	display: flex;
	flex-direction: column;
	align-items: center;
	margin: 30px auto;
	text-align: left;
}

#boardUpdateForm div{
    color: red;
    font-size: 8pt;
    font-weight: bold;
}
</style>
</head>
<body>
<div id="wrap">
	<div id="header">
		<h1>
			<img alt="사과" src="${ pageContext.request.contextPath }/image/apple.png" 
			     width="50" height="50"
			     onclick="location.href='${ pageContext.request.contextPath }/index.do'"
			     style="cursor: pointer;">
			MVC를 활용한 미니프로젝트
		</h1>
		<hr style="border-color: #483D8B; border-width: 3px;" />
	</div>
	
	<div id="container">
	
		<jsp:include page="../main/boardMenu.jsp" />
		
		<div id="section">
			<form id="boardUpdateForm">
			
				<input type="hidden" id="seq" value="${boardDTO.seq }" />
				<input type="hidden" id="pg" value="${pg }" />
			
				<table border="1">
					<tr>
			        	<th width="100">제목</th>
				        <td>
				            <input type="text" id="subject" name="subject" size="50" value="${boardDTO.subject }" placeholder="제목 입력">
				            <div id="subjectDiv"></div>
				        </td>
			    	</tr>
			    	<tr>
				        <th>내용</th>
				        <td>
				            <textarea id="content" name="content" rows="15" cols="50" placeholder="내용 입력">${boardDTO.content }</textarea>
				            <div id="contentDiv"></div>
				        </td>
				    </tr>
				    <tr>
				        <td colspan="2" align="center">
				            <input type="button" value="글수정" id="boardUpdateBtn">
				            <input type="reset" value="다시작성">
				        </td>
				    </tr>
				</table>
			</form>
		</div>
	</div>
</div> <!-- id="wrap" -->

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$('#boardUpdateBtn').click(function(){
	$('#subjectDiv').empty();
	$('#contentDiv').empty();
	
	if($('#subject').val() == '')
		$('#subjectDiv').html('제목 입력');
	
	else if($('#content').val() == '')
		$('#contentDiv').html('내용 입력');
	
	else
		$.ajax({
			type: 'post',
			url: '/projectMVC/board/boardUpdate.do',
			data: {
				'seq': $('#seq').val(),
				'subject': $('#subject').val(),
				'content': $('#content').val()
			},
			success: function(){
				alert("글수정 완료");
				location.href = "/projectMVC/board/boardList.do?pg=" + $('#pg').val();
			},
			error: function(e){
				console.log(e);
			}
		});
});
</script>
</body>
</html>













