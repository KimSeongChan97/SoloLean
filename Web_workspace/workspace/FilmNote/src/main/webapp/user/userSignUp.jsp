<%-- FilmNote/src/main/webapp/user/userSignUp.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="../image/film_favicon.png" type="image/png">
<link rel="stylesheet" href="../css/userSignUp.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" crossorigin="anonymous" referrerpolicy="no-referrer">
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<title>회원가입</title>
<script type="text/javascript">
    var contextPath = '<%= request.getContextPath() %>';
</script>
</head>
<body>
<jsp:include page="../common/header.jsp" />	
	<div id="write-jsp" class="signup-container">
        <h2>회원가입</h2>
        
        <!-- 경고 메시지를 표시하는 영역 -->
		<div id="warningMessage" class="show" ></div>
        
        <form id="signUpForm" action="${pageContext.request.contextPath}/user/userSignUpDB.do" method="post">
            <table>
                <!-- 이름 입력 필드 -->
                <tr>
                    <th class="label"><label for="uname"><i class="fa-solid fa-user"></i> 이름</label></th>
                    <td class="input">
                        <input type="text" id="uname" name="uname" placeholder="이름 입력" maxlength="8"> <!-- 화면크기 조절로 인한 8자제한 추가 -->
                        <div id="unameDiv"></div> <!-- 유효성 검사 메시지 표시 -->
                    </td>
                </tr>
                <!-- 아이디 입력 필드 -->
                <tr>
                    <th class="label"><label for="uid"><i class="fa-solid fa-id-badge"></i> 아이디</label></th>
                    <td class="input">
                        <input type="text" id="uid" name="uid" placeholder="아이디 입력">
                        <div id="uidDiv"></div> <!-- 아이디 유효성 검사 메시지 표시 -->
                    </td>
                </tr>
                <!-- 비밀번호 입력 필드 -->
                <tr>
                    <th class="label"><label for="upwd"><i class="fa-solid fa-lock"></i> 비밀번호</label></th>
                    <td class="input">
                        <input type="password" id="upwd" name="upwd" placeholder="비밀번호 입력">
                        <div id="upwdDiv"></div> <!-- 비밀번호 유효성 검사 메시지 표시 -->
                    </td>
                </tr>
                <!-- 비밀번호 확인 필드 -->
                <tr>
                    <th class="label"><label for="repwd"><i class="fa-solid fa-lock"></i> 재확인</label></th>
                    <td class="input">
                        <input type="password" id="repwd" name="repwd" placeholder="비밀번호 재입력">
                        <div id="repwdDiv"></div> <!-- 비밀번호 확인 유효성 검사 메시지 표시 -->
                    </td>
                </tr>
                <!-- 성별 선택 필드 -->
                <tr>
                    <th class="label"><label for="gender"><i class="fa-solid fa-venus-mars"></i> 성별</label></th>
                    <td class="input">
                        <label><input type="radio" id="male" name="gender" value="M"> 남자</label>
                        <label><input type="radio" id="female" name="gender" value="F"> 여자</label>
                        <div id="genderDiv"></div> <!-- 성별 유효성 검사 메시지 표시 -->
                    </td>
                </tr>
                <!-- 생년월일 입력 필드 -->
                <tr>
                    <th class="label"><label for="birth1"><i class="fa-solid fa-calendar"></i> 생년월일</label></th>
                    <td class="input">
                        <input type="text" id="birth1" name="birth1" placeholder="YYYY" class="input-tel"> 
                        <input type="text" id="birth2" name="birth2" placeholder="MM" class="input-tel"> 
                        <input type="text" id="birth3" name="birth3" placeholder="DD" class="input-tel">
                        <div id="birthDiv"></div> <!-- 생년월일 유효성 검사 메시지 표시 -->
                    </td>
                </tr>
                <!-- 이메일 입력 필드 -->
                <tr>
                    <th class="label"><label for="email1"><i class="fa-solid fa-envelope"></i> 이메일</label></th>
                    <td class="input">
                        <input type="text" id="email1" name="email1" placeholder="이메일 입력" class="input-email"> @ 
                        <input type="text" id="email2" name="email2" placeholder="직접입력" class="input-email">
                        <select id="emailSelect" name="emailSelect" class="input-email">
                            <option value="">직접입력</option>
                            <option value="naver.com">naver.com</option>
                            <option value="gmail.com">gmail.com</option>
                            <option value="daum.net">daum.net</option>
                        </select>
                        <div id="emailDiv"></div> <!-- 이메일 유효성 검사 메시지 표시 -->
                    </td>
                </tr>
                <!-- 휴대전화 입력 필드 -->
                <tr>
                    <th class="label"><label for="tel1"><i class="fa-solid fa-phone"></i> 휴대전화</label></th>
                    <td class="input">
                        <select id="tel1" name="tel1" class="input-tel">
                            <option value="010">010</option>
                            <option value="011">011</option>
                            <option value="016">016</option>
                        </select> - 
                        <input type="text" id="tel2" name="tel2" placeholder="입력" class="input-tel" maxlength="4"> - 
                        <input type="text" id="tel3" name="tel3" placeholder="입력" class="input-tel" maxlength="4">
                        <div id="telDiv"></div> <!-- 휴대전화 유효성 검사 메시지 표시 -->
                    </td>
                </tr>
                <!-- 제출 및 초기화 버튼 -->
                <tr align="center">
                    <td colspan="2" height="20">
                        <button type="submit" id="signUp">회원가입</button>
                        <button type="reset" id="resetBtn">초기화</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    
    <!-- 모달 다이얼로그 -->
    <div id="dialog" title="FilmNote" style="display:none;">
        <p id="dialogMessage"></p>
    </div>
	
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="../js/userSignUp.js"></script>
</body>
</html>
