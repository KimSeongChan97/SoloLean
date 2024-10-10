<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/updateForm.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
	<div id="update-jsp">
		<div id="left">
			<div id="header">
				<a href="/spring/"> <img
					src="${pageContext.request.contextPath}/image/Logo.png" alt="Logo"
					alt="logo" width="50" height="50" /> HOME
				</a>
			</div>
			<div id="profile">
				<img src="${pageContext.request.contextPath}/image/mang.png"
					width="140" height="140" alt="mangLogo" />
			</div>
			<div id="links">
				<a href="#">고객센터</a> | <a href="#">한국어</a>
			</div>
		</div>

		<div id="right">
			<div id="container">
				<div id="edit-header">회원수정</div>
				<form name="userUpdateForm" id="userUpdateForm">
					<input type="hidden" id="pg" value="${pg }" />
					<table>
						<tr>
							<th class="label"><i class="fas fa-user"></i> 이름</th>
							<td class="input"><input type="text" name="name" id="name"
								value="${userDTO.name}" />
								<div id="nameDiv"></div></td>
						</tr>
						<tr>
							<th class="label"><i class="fas fa-id-badge"></i> 아이디</th>
							<td class="input"><input type="text" name="id" id="id"
								value="${userDTO.id}" readonly />
						</tr>
						<tr>
							<th class="label"><i class="fas fa-lock"></i> 비밀번호</th>
							<td class="input"><input type="password" name="pwd" id="pwd"
								 value="${userDTO.pwd}" />
								<div id="pwdDiv"></div></td>
						</tr>
						<tr align="center">
							<td colspan="2" height="20">
								<button type="button" onclick="location.href='/spring/user/list?pg=${pg}'">회원목록</button>
								<button type="button" id="updateBtn">정보수정</button>
								<button type="button" id="deleteBtn">회원탈퇴 </button>
								<button type="reset">초기화</button>
							</td>
						</tr>
					</table>
				</form>
				
			</div>
		</div>
	</div>

	<script src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/update.js"></script>
</body>
</html>