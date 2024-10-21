<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="/SpringHotel/resources/css/bootstrap.css">
<link rel="stylesheet" href="/SpringHotel/resources/css/custom.css">
<link rel="stylesheet" href="/SpringHotel/resources/css/footer.css">
<link rel="stylesheet" href="/SpringHotel/resources/css/loginCSS.css">
<title>로그인</title>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<div class="container" data-view="login">
      	<form>
			<table id="loginTable" class="log" style="background-color: #EEEEEE;" >
				<tr>
					<th>로그인</th>
				</tr>
				<tr align="center">
					<td>
						<p id="welcomText">
							Spring Hotel에 오신 것을 진심으로 환영합니다.<br />
							아이디와 비밀번호를 입력해 주시기 바랍니다.
						</p>
					</td>
				</tr>
				<tr align="center">
					<td>
						<input type="text" id="userid" name="userid" size="35" class="input" placeholder="아이디 입력"/>
						<div id="idDiv"></div>
					</td>
				</tr>
				<tr align="center">
					<td>
						<input type="password" id="pwd" name="pwd" size="35" class="input" placeholder="비밀번호 입력"/>
						<div id="pwdDiv"></div>
					</td>
				</tr>
				<tr align="center">
					<td><input id="loginBtn" type="button" value="로그인" class="btn" /></td>
				</tr>
				<tr align="center">
					<td><input id="joinBtn" type="button" value="회원가입" onclick="location.href='/SpringHotel/user/join'" class="btn"/></td>
				</tr>
				<tr align="center">
					<td>
						<p id="SocialText">간편한 소셜 로그인</p>
					</td>
				</tr>
				<tr align="center">
					<td>
						<%-- ${apiURL} --%>
						<a href=${apiURL}><img id="naverLoginBtn" height="40" src="/SpringHotel/resources/image/naverLoginBtn.png"/></a>
					</td>
				</tr>
			</table>
		</form>
	</div>

<jsp:include page="../common/footer.jsp" />
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="/SpringHotel/resources/js/bootstrap.js"></script>
<script src="/SpringHotel/resources/js/header.js"></script>
<script src="/SpringHotel/resources/js/login.js"></script>
</body>
</html>