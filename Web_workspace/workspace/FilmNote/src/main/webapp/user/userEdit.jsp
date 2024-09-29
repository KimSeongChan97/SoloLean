<%-- FilmNote/src/main/webapp/user/userEdit.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="../image/film_favicon.png" type="image/png">
<link rel="stylesheet" href="../css/userEdit.css">
<title>회원정보수정</title>
<%-- 페이지의 제목을 '회원정보수정'으로 설정하고, 사용자 아이콘과 CSS 파일을 로드합니다. --%>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<%-- 상단에 header.jsp 파일을 포함하여 공통 헤더를 표시합니다. 주로 네비게이션 바나 로고가 포함됩니다. --%>
	<div id="userEdit-jsp" class="userEdit-jsp">
		<%-- 회원정보 수정 화면을 위한 메인 컨테이너 div입니다. --%>
	
		<h2>회원정보수정</h2>
		<%-- '회원정보수정' 제목을 표시합니다. --%>

		<input type="hidden" name="checkpwd" id="checkpwd" value="${userDTO.upwd }">
		<%-- 사용자의 비밀번호를 숨겨서 전달하기 위한 hidden 필드입니다. 여기서 'userDTO.upwd'는 사용자의 기존 비밀번호입니다. --%>

		<form id="userEditForm" name="userEditForm" method="post" action="/FilmNote/userEditDB.do">
			<%-- 사용자의 정보를 수정할 수 있는 폼입니다. 메서드는 POST이며, 수정된 정보는 /FilmNote/userEditDB.do로 전송됩니다. --%>
			<table>
				<tr>
					<th class="label"><label for="uname"><i class="fa-solid fa-user"></i> 이름</label></th>
					<td class="input"><input type="text" name="uname" id="uname" maxlength="8" value="${userDTO.uname }">
						<div id="unameDiv"></div></td>
					<%-- 사용자의 이름을 입력받는 필드입니다. 기본 값으로 사용자의 기존 이름(userDTO.uname)이 표시됩니다. 최대 입력 길이는 8자로 제한됩니다. --%>
				</tr>
				
				<tr>
					<th class="label"><label for="uid"><i class="fa-solid fa-badge"></i> 아이디</label></th>
					<td class="input"><input type="text" name="uid" id="uid" value="${userDTO.uid }" readonly >
						<div id="uidDiv"></div></td>
					<%-- 사용자의 아이디를 표시하는 필드입니다. 아이디는 수정할 수 없으므로 readonly 속성이 적용되어 있습니다. --%>
				</tr>

				<tr>
					<th class="label"><label for="nowupwd"><i class="fa-solid fa-lock"></i> 현재 비밀번호</label></th>
					<td class="input"><input type="password" name="nowupwd" id="nowupwd">
						<div id="nowupwdDiv"></div></td>
					<%-- 현재 비밀번호를 입력받는 필드입니다. 비밀번호 입력란이므로 type="password"로 설정되어 있습니다. --%>
				</tr>

				<tr>
					<th class="label"><label for="upwd"><i class="fa-solid fa-lock"></i>수정할 비밀번호</label></th>
					<td class="input"><input type="password" name="upwd" id="upwd">
						<div id="upwdDiv"></div></td>
					<%-- 수정할 비밀번호를 입력받는 필드입니다. 비밀번호 수정 시 사용됩니다. --%>
				</tr>

				<tr>
					<th class="label"><label for="reupwd"><i class="fa-solid fa-lock"></i> 비밀번호 확인</label></th>
					<td class="input"><input type="password" name="reupwd" id="reupwd">
						<div id="reupwdDiv"></div></td>
					<%-- 수정한 비밀번호를 다시 입력받아 확인하는 필드입니다. 비밀번호 일치 여부를 검증할 때 사용됩니다. --%>
				</tr>

		         <tr>
					<th class="label"><label for="gender"><i class="fa-solid fa-venus-mars"></i> 성별</label></th>
                    <td class="input">
                        <label><input type="radio" id="male" name="gender" value="M" ${userDTO.gender == 'M' ? 'checked' : ''}> 남자 </label>
                        <label><input type="radio" id="female" name="gender" value="F" ${userDTO.gender == 'F' ? 'checked' : ''}> 여자</label>
					<%-- 사용자의 성별을 선택할 수 있는 라디오 버튼입니다. 사용자의 기존 성별(userDTO.gender)에 따라 남자(M) 또는 여자(F)가 선택된 상태로 표시됩니다. --%>
					</td>
				</tr>
                
                <tr>
                    <th class="label"><label for="birth"><i class="fa-solid fa-calendar"></i> 생년월일</label></th>
                    <td class="input">
                        <input type="text" id="birth1" name="birth1" value="${userDTO.birth1 }" class="input-tel"> 
                        <input type="text" id="birth2" name="birth2" value="${userDTO.birth2 }" class="input-tel"> 
                        <input type="text" id="birth3" name="birth3" value="${userDTO.birth3 }" class="input-tel">
					<%-- 사용자의 생년월일을 입력하는 필드입니다. 'birth1'은 년도, 'birth2'는 월, 'birth3'은 일을 의미합니다. 각각의 필드는 기존의 생년월일(userDTO.birth1, userDTO.birth2, userDTO.birth3) 값을 기본으로 가집니다. --%>
					</td>
                </tr>
                
				<tr>
					<th class="label"><label for="email"><i class="fa-solid fa-envelope"></i> 이메일</label></th>
					<td class="input">
					<input type="text" name="email1" id="email1" class="input-email" value="${userDTO.email1 }"> @
					<input type="text" name="email2" id="email2" class="input-email" value="${userDTO.email2 }">
						<select id="emailSelect" name="emailSelect" class="input-email">
                            <option value="">직접입력</option>
                            <option value="naver.com">naver.com</option>
                            <option value="gmail.com">gmail.com</option>
                            <option value="daum.net">daum.net</option>
                        </select>
					<%-- 사용자의 이메일을 수정할 수 있는 필드입니다. 'email1'은 이메일의 아이디 부분, 'email2'는 도메인 부분을 의미합니다. 사용자는 직접 도메인을 입력하거나, 셀렉트 박스를 통해 선택할 수 있습니다. --%>
					</td>
				</tr>

				<tr>
					<th class="label"><label for="tel"><i class="fa-solid fa-phone"></i> 휴대전화</label></th>
                    <td class="input">
					<select id="tel1" name="tel1" class="input-tel" value="${userDTO.tel1 }">
								<option value="010">010</option>
								<option value="011">011</option>
								<option value="019">019</option>
					</select> - 
					<input type="text" name="tel2" size="4" maxlength="4" value="${userDTO.tel2 }" class="input-tel"> - 
					<input type="text" name="tel3" size="4" maxlength="4" value="${userDTO.tel3 }" class="input-tel">
					<%-- 사용자의 휴대전화 번호를 수정하는 필드입니다. 첫 번째 박스는 휴대전화의 앞 번호를 선택할 수 있으며, 나머지 두 필드는 사용자가 번호를 입력하는 공간입니다. --%>
					</td>
				</tr>

				<tr>
					<td colspan="3" align="center">
					<button type="button" id="userEditBtn">회원정보 수정</button>
					<button type="reset" id="resetBtn">수정 취소</button>
					<button type="button" id="withdrawBtn"  style="font-size: 10px !important;
					width: 50px !important; height: 20px !important; background: gray !important;
					color: rightgray !important; float: right;">탈퇴</button>
					<%-- '회원정보 수정' 버튼을 클릭하면 정보가 수정됩니다. '수정 취소' 버튼은 폼을 초기화합니다. '탈퇴' 버튼은 사용자 탈퇴를 처리합니다. 탈퇴 버튼은 작고 우측에 배치되어 있습니다. --%>
					</td>
				</tr>
			</table>
		</form>
	</div>

	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<%-- jQuery 라이브러리를 로드하여 JavaScript 기능을 지원합니다. --%>
	<script type="text/javascript" src="../js/userEdit.js"></script>
	<%-- 회원정보 수정 관련된 JavaScript 파일을 로드합니다. 입력 검증이나 비밀번호 확인 등의 기능이 있을 수 있습니다. --%>
</body>
</html>
