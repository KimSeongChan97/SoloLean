<%-- projectMVC/src/main/webapp/member/memberWriteForm.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="data:,">
<title>회원가입</title>
<style type="text/css">
* {
	padding: 0px;
	margin: 0px;
	box-sizing: border-box;
}

#write-jsp {
    text-align: center; 
    margin-top: 20px; 
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
	width: 800px;
}

th, td {
	border: 1px solid black;
	padding: 10px;
	vertical-align: middle;
}

.label {
	width: 20%;
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

input[type="radio"] {
	margin-right: 5px;
}

input[type="text"].input-email, select.input-email {
    width: 170px !important;
    border-radius: 5px;
    height: 30px;
    margin-right: 3px;
}

input[type="text"].input-tel, select.input-tel {
    width: 100px !important;
    border-radius: 5px;
    height: 30px;
}

input[name="addr1"], input[name="addr2"] {
    width: 100%;
    margin-top: 5px;
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

#nameDiv, #idDiv, #pwdDiv, #repwdDiv {
	display: none;
	padding: 5px 0 0 3px;
	color: red;
	font-size: 10pt;
}
</style>
</head>
<body>
<div id="write-jsp">
	<a href="${pageContext.request.contextPath }/index.do"><img src="../image/mangom3.png" width="140" height="140" alt="mangom" /></a>
	<h2>회원가입</h2>
	<form name="memberWriteForm" id="memberWriteForm">
		<table>
			<tr>
		        <th class="label">이름</th>
		        <td class="input">
		           <input type="text" name="name" id="name" placeholder="이름 입력" />
		           <div id="nameDiv"></div>
		        </td>
		    </tr>
		    <tr>
		        <th class="label">아이디</th>
		        <td class="input">
		           <input type="text" name="id" id="id" placeholder="아이디 입력" />
		           <input type="hidden" name="check" id="check" value="" />
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
		    <tr>
		        <th class="label">재확인</th>
		        <td class="input">
		           <input type="password" name="repwd" id="repwd" placeholder="비밀번호 입력" />
		           <div id="repwdDiv"></div>
		        </td>
		    </tr>
		    <tr>
		        <th class="label">성별</th>
		        <td class="input">
		           <label><input type="radio" name="gender" value="M" checked="checked">남자</label>
        			<label><input type="radio" name="gender" value="F">여자</label>
		        </td>
		    </tr>
		        <th class="label">생년월일</th>
		        <td class="input">
		        	<input type="text" size="10" name="birth1" placeholder="YYYY" class="input-tel"/>
					<input type="text" size="10" name="birth12" placeholder="MM" class="input-tel"/>
					<input type="text" size="10" name="birth13" placeholder="DD" class="input-tel"/>
		        </td>
		    </tr>
		    <tr>
		        <th class="label">이메일</th>
		        <td class="input">
		           <input type="text" name="email1" class="input-email" />@
		           <input type="text" name="email2" class="input-email" id="email-domain" />
		           <select name="email2" class="input-email" onchange="setEmailDomain(this.value)">
			            <option value="직접입력" select="selected">직접입력</option>
			            <option value="hanmail.net" >hanmail.net</option>
			            <option value="naver.com" >naver.com</option>
			            <option value="gmail.com" >gmail.com</option>
		        	</select>
		        </td>
		    </tr>
		    <tr>
		        <th class="label">휴대전화</th>
		        <td class="input">
		        	<select name="tel1" class="input-tel" >
			            <option value="010" select="selected">010</option>
			            <option value="011">011</option>
			            <option value="019">019</option>
			        </select>
		           <input type="text" size="10" name="tel2" class="input-tel"/>
		           <input type="text" size="10" name="tel3" class="input-tel"/>
		        </td>
		    </tr>
		    <tr>
			<tr align="center">
		        <td colspan="2" height="20">
		            <button type="submit" id="joinBtn" onclick="memberWrite()" >회원가입</button>
		            <button type="reset" id="resetBtn">초기화</button>
		        </td>
		    </tr>
		</table>
	</form>
</div>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script> 
<script type="text/javascript" src="../js/member.js"></script>
</body>
</html>
