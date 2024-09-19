<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	background-color: #0d0d0d;
	color: #00ffcc;
	/* 전체 배경색을 어두운 색(#0d0d0d)으로 설정하고, 텍스트는 밝은 청록색(#00ffcc)으로 설정 */
}

table {
	border-collapse: collapse;
	/* 테이블 셀 사이의 경계를 합쳐 하나로 보이게 설정 */
}

th, td {
	padding: 5px;
	/* 테이블 헤더와 데이터 셀 안쪽에 5px의 패딩을 적용하여 가독성 향상 */
}

#loginForm {
	display: flex;
	flex-direction: column;
	align-items: center;
	margin: 30px auto;
	text-align: left;	
}

#loginForm div {
	color: red;
	font-size: 8pt;
	font-weight: bold;
	/* 경고 메시지를 표시할 div의 스타일을 설정. 빨간색 텍스트, 작은 폰트 크기, 굵은 글씨 */
}
</style>
</head>
<body>

<form id="loginForm">
	<h1>
	<img src="../image/4.jpg" width="100" height="100" alt="홈" 
		 onclick="location.href='${ pageContext.request.contextPath }/index.do'" style="cursor: pointer;">
	<!-- 클릭 시 홈으로 이동하게 설정. 사용자가 클릭하면 메인 페이지(index.do)로 리다이렉트 -->
	로그인
	</h1>
	
	<table border="1">
		<tr>
	        <th>아이디</th>
	        <td>
	        	<input type="text" name="id" id="id" size="30" placeholder="아이디 입력">
	        	<!-- 사용자가 아이디를 입력할 수 있는 필드. 입력이 없을 경우 idDiv에 경고 메시지를 표시 -->
	        	<div id="idDiv"></div>
	        	<!-- 아이디 입력 오류 메시지가 표시될 영역 -->
	        </td>
	    </tr>
	    
	    <tr>
	        <th>비밀번호</th>
	        <td>
	        	<input type="password" name="pwd" id="pwd" size="40" placeholder="비밀번호 입력">
	        	<!-- 사용자가 비밀번호를 입력할 수 있는 필드. 비밀번호는 숨겨져서 입력됨 -->
	        	<div id="pwdDiv"></div>
	        	<!-- 비밀번호 입력 오류 메시지가 표시될 영역 -->
	        </td>
	    </tr>
	    
	    <tr>
	    	<td colspan="2" align="center">
	    		<input type="button" value="로그인" id="loginBtn"/>
	    		<!-- '로그인' 버튼을 클릭하면 로그인 요청이 처리됨 -->
	    		<input type="button" value="회원가입" onclick="location.href='/${ pageContext.request.contextPath }/member/writeForm.do'" />      
	    		<!-- '회원가입' 버튼을 클릭하면 회원가입 페이지로 이동 -->
	    	</td>
	    </tr>
	</table>
	
	<div id="loginResult"></div>
</form>
	

<script type="text/javascript" src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
<!-- jQuery 라이브러리를 사용하여 이벤트 처리를 간편하게 수행 -->
<script type="text/javascript">
$(function(){
	$('#loginBtn').click(function(){
		// '로그인' 버튼 클릭 시 실행되는 함수
		
		// 먼저 이전에 출력된 경고 메시지를 지움
		$('#idDiv').empty();
		$('#pwdDiv').empty();
		
		// 아이디 입력 검증
		if($('#id').val() == '')
			$('#idDiv').html('아이디 입력'); // 아이디가 입력되지 않았을 경우 경고 메시지 출력
		// 비밀번호 입력 검증
		else if($('#pwd').val() == '')
			$('#pwdDiv').html('비밀번호 입력'); // 비밀번호가 입력되지 않았을 경우 경고 메시지 출력
		else
			// 아이디와 비밀번호가 입력된 경우 AJAX 요청을 통해 로그인 처리
			$.ajax({
				type: 'post', // 서버로 데이터를 전송할 때 POST 방식을 사용
				url: '${ pageContext.request.contextPath }/member/login.do',
				// 로그인 처리를 담당하는 서버의 URL. contextPath를 사용하여 상대 경로로 요청
				
				// data: 'id=' + $('#id').val() + '&pwd=' + $('#pwd').val(),
				// id와 pwd 값을 서버로 전송. (더 간결하게 객체 형식으로 전달)
				data: {
					'id': $('#id').val(), // 입력한 아이디를 전송
					'pwd': $('#pwd').val() // 입력한 비밀번호를 전송
				},
			
				dataType: 'text', // 서버로부터 응답받을 데이터 타입을 텍스트로 지정 (text or xml or json)
				success: function(data){
					// 서버로부터 성공적으로 응답을 받았을 때 실행되는 함수
					// alert(data.trim());
					
					// 서버가 'fail'이라는 응답을 보낸 경우 (로그인 실패)
					if(data.trim() == 'fail'){
						$('#loginResult').html('아이디 또는 비밀번호가 틀렸습니다.');
						$('#loginResult').css('font-size', '12px');
						$('#loginResult').css('padding', '10px');
					} else {
						// 로그인 성공 시 사용자 이름을 알리고 메인 페이지로 리다이렉트
						//alert(data.trim()+"님 로그인");						
						location.href = '/projectMVC/index.do'; // 메인 페이지로 이동
					}
				},
				error: function(e){
					// 서버 요청이 실패했을 경우 에러를 콘솔에 출력
					console.log(e);
				}
			});
	});
});
</script>
</body>
</html>
