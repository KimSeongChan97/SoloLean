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
th, td {
	padding: 5px;
}
div {
	color: red;
	font-size: 8pt;
	font-weight: bold;
}
</style>
</head>
<body>
<h1>
	<img src="../image/4.jpg" width="100" height="100" alt="홈" 
		 onclick="location.href='../index.jsp'" style="cursor: pointer;"> 로그인
</h1>
<form id="loginForm">
	<table border="1">
		<tr>
	        <th>아이디</th>
	        <td>
	        	<input type="text" name="id" id="id" size="30" placeholder="아이디 입력">
	        	<div id="idDiv"></div>
	        </td>
	    </tr>
	    
	    <tr>
	        <th>비밀번호</th>
	        <td>
	        	<input type="password" name="pwd" id="pwd" size="40" placeholder="비밀번호 입력">
	        	<div id="pwdDiv"></div>
	        </td>
	    </tr>
	    
	    <tr>
	    	<td colspan="2" align="center">
	    		<input type="button" value="로그인" id="loginBtn"/>
	    		<input type="button" value="회원가입" onclick="location.href='writeForm.jsp'" />      
	    	</td>
	    </tr>
	</table>
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#loginBtn').click(function(){
		$('#idDiv').empty();
		$('#pwdDiv').empty();
		
		if($('#id').val() == '')
			$('#idDiv').html('아이디 입력');
		else if($('#pwd').val() == '')
			$('#pwdDiv').html('비밀번호 입력');
		else
			$.ajax({
				type: 'post',
				url: 'login.jsp',
				
				//data: 'id=' + $('#id').val() + '&pwd=' + $('#pwd').val(),
				data: {
					'id': $('#id').val(),
					'pwd': $('#pwd').val()
				},
			
				dataType: 'text', //서버로부터 받는 타입, 'text' or 'xml' or 'json'
				success: function(data){
					//alert(data.trim());
					
					if(data.trim() == 'fail')
						alert("아이디 또는 비밀번호가 틀렸습니다.")
					else {
						alert(data.trim()+"님 로그인");						
						location.href = '../index.jsp';
					}
				},
				error: function(e){
					console.log(e);
				}
			});
	});
});
</script>
</body>
</html>











