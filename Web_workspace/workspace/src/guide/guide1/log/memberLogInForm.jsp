<%-- projectMVC/src/main/webapp/member/memberLogInForm.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="data:,">
<title>로그인</title>
<style type="text/css">
* {
	padding: 0px;
	margin: 0px;
	box-sizing: border-box;
}

#login-jsp {
    text-align: center; 
    margin-top: 50px; 
}

a {
	margin: 10px 0;
	text-align: center;
	display: inline-block;
}

table {
	margin: 20px auto;
	border: 2px solid black;
	border-collapse: collapse;
	border-spacing: 0px;
	text-align: center;
	width: 360px;
}

th, td {
	border: none;
	padding: 10px;
	vertical-align: top;
}

.label {
	width: 30%;
	padding-top: 15px;
}

.input {
    text-align: left;
    width: 80%;
}

input[type="text"], input[type="password"] {
	width: 200px;
	border-radius: 5px;
	height: 30px;
	padding: 0 5px;
}
button {
    width: 130px;
    height: 30px;
    text-align: center;
    vertical-align: middle; 
    padding: 3px 10px;
    background: white;
    border: 1px solid #5A5A5A;
    color: #5A5A5A;
    text-decoration: none;
    border-radius: 5px;
    font-size: 14px;
    transition: background-color 0.3s ease;
    cursor: pointer;
}

button:hover {
    background: #5A5A5A;
    color: white;
}

#idDiv, #pwdDiv, #messageDiv {
	display: none;
	padding: 5px 0 0 3px;
	color: red;
	font-size: 10pt;
}
</style>
</head>
<body>
<div id="login-jsp">
	<a href="${pageContext.request.contextPath }/index.do"><img src="../image/mangom2.jpg" width="150" height="150" alt="mangom" /></a>
	<h2>로그인</h2>
	<form name="memberLogInForm">
		<table>
		    <tr>
		        <th class="label">아이디</th>
		        <td class="input">
		           <input type="text" name="id" id="id" placeholder="아이디 입력" />
		           <div id="idDiv"></div>
		        </td>
		    </tr>
		    <tr>
		        <th class="label">비밀번호</th>
		        <td class="input">
		           <input type="password" name="pwd" id="pwd" placeholder="비밀번호 입력" />
		           <div id="pwdDiv"></div>
		        </td>
		    </tr>		
			<tr align="center">
		        <td colspan="2" height="20">
		            <button type="submit" id="logInBtn">로그인</button>
		            <button type="button" id="joinBtn" onclick="location.href='${pageContext.request.contextPath }/member/memberWriteForm.do'">회원가입</button>
		        </td>
		    </tr>		    
		</table>
		<div id="messageDiv"></div>
	</form>	
</div>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script> 
<script type="text/javascript">
$(document).ready(function() {
    $('#logInBtn').click(function(event) {
    	event.preventDefault(); // 폼 제출 방지
    	$('#idDiv').hide();
        $('#pwdDiv').hide();
        
        let isValid = true;
        let id = $('#id').val().trim();
        let pwd = $('#pwd').val().trim();

        if (id === "") {
            $('#idDiv').html("아이디를 입력하세요").show();
            isValid = false;
        }

        if (pwd === "") {
            $('#pwdDiv').html("비밀번호를 입력하세요").show();
            isValid = false;
        } 
        
        if (isValid) {
        	$.ajax({
        		type: 'post',
        		url: '${pageContext.request.contextPath }/member/memberLogIn.do',
        		data: {
        			'id': id,
        			'pwd': pwd
        		},
        		dataType: 'text', // 서버로부터 받는 응답 타입
        		success: function(data) {
        		    let result = data.trim();
        		    
        		    if (result === 'fail') {
        		        // alert("아이디 또는 비밀번호가 틀렸습니다.");
        		    	$('#messageDiv').html("아이디 또는 비밀번호가 틀렸습니다.").show();
        		    } else {
        		        // alert(result + "님 로그인");
        		        location.href = '${pageContext.request.contextPath }/index.do';
        		    }
        		},
        		error: function(xhr, status, error) {
        		    console.log("로그인 실패:", error);
        		    console.log("상태 코드:", xhr.status); // 상태 코드 확인
        		    console.log("응답 메시지:", xhr.responseText); // 응답 메시지 확인
        		}
        	});
        }
    });

    // 입력 필드에 포커스가 갈 때 오류 메시지 숨기기
    $('#id').focus(function() {
        $('#idDiv').hide();
    });

    $('#pwd').focus(function() {
        $('#pwdDiv').hide();
    });
});
</script>
</body>
</html>