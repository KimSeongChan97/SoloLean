<%-- SpringProject/src/main/webapp/WEB-INF/user/writeForm.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<!-- user.css 파일을 불러와 회원가입 폼의 스타일을 설정합니다 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/user.css">
<!-- Font Awesome 아이콘 라이브러리를 사용하여 아이콘을 추가합니다 -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
	<div id="write-jsp">
		<div id="left">
			<div id="header">
				<!-- HOME 링크: 홈으로 돌아가는 링크입니다. 클릭 시 /spring 경로로 이동합니다. -->
				<a href="/spring/"> 
					<img src="${pageContext.request.contextPath}/image/Logo.png" alt="Logo" width="50" height="50" />
					HOME
				</a>
			</div>
			<div id="profile">
				<!-- 사용자가 등록할 이미지 혹은 기본 프로필 이미지를 표시합니다 -->
				<img src="${pageContext.request.contextPath}/image/mang.png" width="140" height="140" alt="mangLogo" />
			</div>
			<div id="links">
				<!-- 기타 링크들: 고객센터 및 언어 설정 링크를 표시합니다 -->
				<a href="#">고객센터</a> | <a href="#">한국어</a>
			</div>
		</div>

		<div id="right">
			<div id="container">
				<div id="edit-header">회원가입</div>
				<!-- 회원가입 폼입니다. 사용자가 입력한 데이터를 전송하는 폼입니다. -->
				<form name="userWriteForm" id="userWriteForm">
					<table>
						<tr>
							<!-- 아이콘과 함께 '이름' 입력 필드를 표시합니다. -->
							<th class="label"><i class="fas fa-user"></i> 이름</th>
							<td class="input">
								<!-- 사용자가 입력하는 이름 필드입니다. placeholder 속성은 필드에 힌트를 제공합니다. -->
								<input type="text" name="name" id="name" placeholder="이름 입력" />
								<!-- 이 div는 오류 메시지 또는 추가 정보를 보여줄 때 사용됩니다. 예를 들어 이름이 입력되지 않은 경우 메시지를 여기에 출력할 수 있습니다. -->
								<div id="nameDiv"></div>
							</td>
						</tr>
						<tr>
							<!-- 아이콘과 함께 '아이디' 입력 필드를 표시합니다. -->
							<th class="label"><i class="fas fa-id-badge"></i> 아이디</th>
							<td class="input">
								<!-- 사용자가 입력하는 아이디 필드입니다. -->
								<input type="text" name="id" id="id" placeholder="아이디 입력" />
								<!-- 오류 메시지 또는 추가 정보를 보여줄 div입니다. -->
								<div id="idDiv"></div>
							</td>
						</tr>
						<tr>
							<!-- 아이콘과 함께 '비밀번호' 입력 필드를 표시합니다. -->
							<th class="label"><i class="fas fa-lock"></i> 비밀번호</th>
							<td class="input">
								<!-- 사용자가 입력하는 비밀번호 필드입니다. 비밀번호는 보안상 화면에 표시되지 않습니다. -->
								<input type="password" name="pwd" id="pwd" placeholder="비밀번호 입력" />
								<!-- 오류 메시지 또는 추가 정보를 보여줄 div입니다. -->
								<div id="pwdDiv"></div>
							</td>
						</tr>
						<tr align="center">
							<td colspan="2" height="20">
								<!-- '회원가입' 버튼입니다. 클릭 시 폼에 입력된 데이터를 전송합니다. -->
								<button type="button" id="writeBtn">회원가입</button>
								<!-- '초기화' 버튼입니다. 클릭하면 입력된 데이터를 모두 지웁니다. -->
								<button type="reset">초기화</button>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>

	<!-- jQuery 라이브러리를 불러옵니다. 주로 Ajax 요청과 DOM 조작을 위해 사용됩니다. -->
	<script src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
	<!-- 사용자 입력 데이터 처리를 위한 자바스크립트 파일을 불러옵니다. 회원가입 시 발생하는 이벤트와 서버 요청 처리를 담당합니다. -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/write.js"></script>
</body>
</html>
