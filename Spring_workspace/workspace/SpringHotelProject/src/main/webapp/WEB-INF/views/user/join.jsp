<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="/SpringHotel/resources/css/bootstrap.css">
<link rel="stylesheet" href="/SpringHotel/resources/css/custom.css">
<link rel="stylesheet" href="/SpringHotel/resources/css/joinCSS.css">
<title>Spring Hotel</title>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<div class="container" data-view="join">
		<form id="joinForm">
			<c:if test="${userDTO != null}">
				<input hidden name="logintype" value="${userDTO.logintype}"/>
			</c:if>
			<c:if test="${userDTO == null}">
				<input hidden name="logintype" value="SH"/>
			</c:if>
			<table id="joinTable" class="log">
				<tr>
					<th id="title" colspan="2">회원가입</th>
				</tr>
				<tr align="center">
					<td colspan="2">
						<p id="welcomText">
							Spring Hotel에 오신 것을 진심으로 환영합니다.<br/>
							※ 모든 항목에 개인정보를 입력해주시기를 바랍니다
						</p>
					</td>
				</tr>
				<tr align="center">
					<th><label for="userid">아이디</label></th>
					<td class="inputList">
						<input type="text" id="userid" name="userId"  size="35" class="input" placeholder="아이디 입력" data-checkid ="false"/>
						<div class="infoText" id="idDiv"></div>
					</td>
				</tr>
				<tr align="center">
					<th><label for="pwd">비밀번호</label></th>
					<td class="inputList">
						<input type="password" id="pwd" name="pwd" size="35" class="input" placeholder="비밀번호 입력"/>
						<div class="infoText" id="pwdDiv"></div>
					</td>
				</tr>
				<tr align="center">
					<th><label for="name">이름</label></th>
					<td class="inputList">
						<input type="text" id="name" name="name"  size="35" class="input" placeholder="이름 입력" value="${userDTO.name}"/>
						<div class="infoText" id="nameDiv"></div>
					</td>
				</tr>
				<tr align="center">
					<th><label for="email">이메일</label></th>
					<td class="inputList">
						<input type="email" id="emailInput" name="email" size="35" class="input" placeholder="이메일 입력" value="${userDTO.email}"/>
						<div class="infoText" id="emailDiv"></div>
					</td>
				</tr>
				<tr align="center">
				    <th><label> </label></th>
				    <td class="inputList">
				        <input type="button" id="EmailSendbutton" name="EmailSendbutton" style="width: 60%; height: 40px;" class="input" value="인증번호 발송"/>
				    </td>
				</tr>
				<tr align="center">
				    <th><label for="emailCheck">인증번호확인</label></th>
				    <td class="inputList">
				        <input type="text" id="EmailCheckbutton" name="EmailCheckbutton" size="35" class="input" placeholder="인증번호 입력"/>
				        <div class="infoText" id="emailCheckDiv"></div>
				    </td>
				</tr>
				<tr align="center">
				    <th><label for="emailCheck"> </label></th>
				    <td class="inputList">
				        <input type="button" id="emailCheckBtn" name="emailCheckBtn" style="width: 60%; height: 40px;" class="input" value="인증번호 확인"/>
				    </td>
				</tr>
			
				<input type="hidden" id="checkNum" name="checkNum" />

				<tr align="center">
					<th>성별</th>
					<td>
						<c:if test="${userDTO.gender == 'F'}">
							<input type="radio" name="gender" value="M" id="m">남자
							<input type="radio" name="gender" value="F" checked="checked" id="f">여자
						</c:if>
						
						<c:if test="${userDTO.gender == 'M'}">
							<input type="radio" name="gender" value="M" checked="checked" id="m">남자
							<input type="radio" name="gender" value="F" id="f">여자
						</c:if>
						
						<c:if test="${userDTO == null}">
							<input type="radio" name="gender" value="M" checked="checked" id="m">남자
							<input type="radio" name="gender" value="F" id="f">여자
						</c:if>
					</td>
				</tr>
				<tr align="center">
					<th>생일</th>
					<td class="inputList">
						<input type="text" id="birth1" name="birth1" size="10" class="input birth" placeholder="yyyy" value="${userDTO.birth1}"/>
						<input type="text" id="birth2" name="birth2" size="10" class="input birth" placeholder="mm" value="${userDTO.birth2}"/>
						<input type="text" id="birth3" name="birth3" size="10" class="input birth" placeholder="dd" value="${userDTO.birth3}"/>
						<div class="infoText" id="birthDiv"></div>
					</td>
				</tr>
				<tr align="center">
					<th>전화번호</th>
					<td class="inputList">
						<select class="input tel" id="tel1" name="tel1" id="selectEmail">
							<option value="${userDTO.tel1}" selected disabled hidden>${userDTO.tel1}</option>
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="019">019</option>
						</select>
						-
						<input size="10" type="text" id="tel2" class="input tel" name="tel2" maxlength="4" value="${userDTO.tel2}"/>
						-
						<input size="10" type="text" id="tel3" class="input tel" name="tel3" maxlength="4" value="${userDTO.tel3}"/>
						<div class="infoText" id="telDiv"></div>
					</td>
				</tr>
				<tr align="center">
					<td colspan="2"><input id="joinBtn" type="button" value="회원가입" onclick="Join(event)" class="btn"/></td>
				</tr>
			</table>
		</form>
	</div>
<jsp:include page="../common/footer.jsp" />
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="/SpringHotel/resources/js/bootstrap.js"></script>
<script src="/SpringHotel/resources/js/header.js"></script>
<script src="/SpringHotel/resources/js/join.js"></script>
</body>
</html>