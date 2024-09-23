<%-- FilmNote/src/main/webapp/user/userSignUp.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="../image/film_favicon.png" type="image/png">
<link rel="stylesheet" href="../css/userSignUp.css">
<title>회원가입</title>
</head>
<body>
	
	<div class="signup-container">
        
        <h2>회원가입</h2>
        <form id="writeForm">
            <div class="form-group">
                <label for="name">이름</label>
                <input type="text" id="name" name="name" required>
                <div id="nameDiv"></div>
            </div>
            <div class="form-group">
                <label for="id">아이디</label>
                <input type="text" id="id" name="id" required>
                <div id="idDiv"></div>
            </div>
            <div class="form-group">
                <label for="pwd">비밀번호</label>
                <input type="password" id="pwd" name="pwd" required>
                <div id="pwdDiv"></div>
            </div>
            <div class="form-group">
                <label for="repwd">재확인</label>
                <input type="password" id="repwd" name="repwd" required>
                <div id="repwdDiv"></div>
            </div>
            <div class="form-group">
                <label>성별</label>
                <div class="gender-group">
                    <input type="radio" name="gender" value="M" checked> 남자
                    <input type="radio" name="gender" value="F"> 여자
                </div>
            </div>
            <div class="form-group">
                <label for="birth">생년월일</label>
                <div class="birth-group">
                    <input type="text" id="birth1" placeholder="YYYY" name="birth1" maxlength="4" required>
                    <input type="text" id="birth2" placeholder="MM" name="birth2" maxlength="2" required>
                    <input type="text" id="birth3" placeholder="DD" name="birth3" maxlength="2" required>
                </div>
                <div id="birthDiv"></div>
            </div>
            <div class="form-group">
                <label for="email">이메일</label>
                <div class="email-group">
                    <input type="text" id="email1" name="email1" required> @
                    <input type="text" id="email2" name="email2" required>
                    <select id="email3" name="email3" onchange="change();">
                        <option value="직접입력">직접입력</option>
                        <option value="gmail.com">gmail.com</option>
                        <option value="naver.com">naver.com</option>
                    </select>
                </div>
                <div id="emailDiv"></div>
            </div>
            <div class="form-group">
                <label for="phone">휴대전화</label>
                <div class="phone-group">
                    <select name="tel1">
                        <option value="010">010</option>
                    </select>
                    <input type="text" id="tel2" name="tel2" maxlength="4" required>
                    <input type="text" id="tel3" name="tel3" maxlength="4" required>
                </div>
                <div id="telDiv"></div>
            </div>
            <div class="form-group">
                <button type="submit" id="signUpBtn">회원가입</button>
                <button type="button" onclick="location.href='userSignIn.jsp'">로그인</button>
            </div>
        </form>
    </div>
	
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/userSignUp.js"></script>
</body>
</html>