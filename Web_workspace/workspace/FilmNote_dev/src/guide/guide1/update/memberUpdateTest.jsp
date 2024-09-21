<%-- projectMVC/src/main/webapp/member/memberUpdateForm.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="member.bean.MemberDTO" %>
<%@ page import="member.dao.MemberDAO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	//세션에서 사용자 ID 가져오기
	String name = (String)session.getAttribute("memName");
	String id = (String)session.getAttribute("memId"); 
	String email = (String)session.getAttribute("memEmail");
	
    // 로그인 여부 확인
    if (id == null) {
    	response.sendRedirect("../member/memberLogInForm.do");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="data:,">
<title>회원정보수정</title>
<style type="text/css">
* {
    padding: 0px;
    margin: 0px;
    box-sizing: border-box;
}

html, body {
    font-family: Arial, sans-serif;
    width: 100%;
    height: 100%;
}

#update-jsp {
	display: flex;
	justify-content: space-around;
    width: 100%;
    height: 100vh;
}

#left {
	width: 25%;    
	height: 100vh;
	border: 1px solid #ddd;
	box-shadow: 4px 0 6px rgba(0, 0, 0, 0.2);
}

#right {
	width: 60%;
	display: flex;
	flex-direction: column;
	justify-content: center;
	padding: 0 50px;
}

/** <div id="left"> */
#header {
	margin: 30px 20px;
    display: flex;
    justify-content: start;
    align-items: center;
    gap: 5px;
}

#header a {
    display: flex;       
    align-items: center; 
    text-decoration: none;
    color: black;
    font-size: 20px;
    font-weight: 400;
    gap: 10px; 
}

#profile {
	border-bottom: 1px solid #ddd;
	padding: 100px 0;
	margin: 100px 20px;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	gap: 7px;
}

#profile #profile-name {
	font-weight: 800;
	font-size: 24px;
}

#profile  #profile-email {
	color: #666;
}

.links {
	margin: 10px 0;
    font-size: 14px;
    color: #666;
    display: flex;
    justify-content: center;
    text-align: center;
}

.links a {
    color: #666;
    text-decoration: none;
    margin: 0 5px;
}

.links a:hover {
    text-decoration: underline;
}



/** <div id="right"> */
#container {
    border: 1px solid #ddd;
    border-radius: 20px;
    box-shadow: 4px 0 6px rgba(0, 0, 0, 0.2);
}

#container #edit-header {
	border-radius: 20px 20px 0 0;
	background: #03C75A; /* #8ADB9F; */
	color: white;
	height: 60px;
	display: flex;
	align-items: center;
	font-size: 20px;
	font-weight: 700;
	margin: 0;
	padding: 10px 20px;
}

form {
	margin: 0 20px;
}

table {
    margin: 20px auto;
    border-collapse: collapse;
    text-align: center;
}

th, td {
    border-bottom: 1px solid #ddd;
    padding: 10px;
    height: 50px;
    vertical-align: middle;
}

td[colspan="2"] {
    border-bottom: none; /* 하단 테두리 제거 */
    height: 70px;
}

.label {
    width: 20%;
}

.input {
    width: 80%;
    text-align: left;
}

input[type="text"], input[type="password"] {
    width: 200px;
    height: 30px;
    padding: 5px;
    border-radius: 5px;
    border : 1px solid #ddd;
}

input[type="radio"] {
   margin-right: 5px;
}

input[type="text"].input-email, select.input-email {
    width: 170px !important;
    border-radius: 5px;
    height: 30px;
    margin-right: 3px;
    border : 1px solid #ddd;
}

input[type="text"].input-tel, select.input-tel {
    width: 100px !important;
    border-radius: 5px;
    height: 30px;
    border : 1px solid #ddd;
}

input[name="addr1"], input[name="addr2"] {
    width: 100%;
    margin-top: 5px;
    border : 1px solid #ddd;
}

button {
    width: 130px;
    height: 40px;
    padding: 3px 10px;
    background: white;
    border: 1px solid #ddd;
    color: #5A5A5A;
    text-decoration: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

.input button {
	height: 30px;
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

#withdrawLink {
	margin-right: auto;  /* 부모 컨테이너에서 왼쪽으로 정렬 */
	padding: 20px;
}
</style>
</head>
<body>
<div id="update-jsp">
	<div id="left">
		<div id="header">
			<a href="${pageContext.request.contextPath}/index.do">
				<img src="../image/alarm_logo.png" alt="logo" width="50" height="50" />
				HOME
			</a>
		</div>
		<div id="profile">
			<img src="../image/mangom3.png" width="140" height="140" alt="mangom" />
			<p id="profile-name"><%=name %></p>
			<p id="profile-email"><%= email %></p>
		</div>
		<div class="links">
			<a id="logOutBtn" href="${context }/member/memberLogOut.do">로그아웃</a> |
			<a href="#">고객센터</a> |
			<a href="#">한국어</a>
		</div>
	</div> <!-- <div id="left"> -->

	<div id="right">
		<div id="container">
			<div id="edit-header">회원정보수정</div>
			<form name="memberUpdateForm" id="memberUpdateForm">
				<table>
				<tr>
				     <th class="label">이름</th>
				     <td class="input">
				        <input type="text" name="name" id="name" value="${memberDTO.name }" />
				     	<div id="nameDiv"></div>
				    </td>
				</tr>
				<tr>
				    <th class="label">아이디</th>
				    <td class="input">
				       <input type="text" name="id" id="id" value="${memberDTO.id }" readonly />
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
				      <label><input type="radio" name="gender" value="M" ${memberDTO.gender == 'M' ? 'checked' : ''} />남자</label>
				     <label><input type="radio" name="gender" value="F" ${memberDTO.gender == 'F' ? 'checked' : ''} />여자</label>
				  </td>
				</tr>
				<tr>
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
				       <input type="text" name="email1" class="input-email" value="${memberDTO.email1 }" />@
				       <input type="text" name="email2" class="input-email" id="email-domain" value="${memberDTO.email2 }" />
				       <select name="email2" class="input-email" onchange="setEmailDomain(this.value)">
				           <option value="직접입력" ${memberDTO.email2 == '직접입력' ? 'selected' : ''}>직접입력</option>
				        <option value="hanmail.net" ${memberDTO.email2 == 'hanmail.net' ? 'selected' : ''}>hanmail.net</option>
				        <option value="naver.com" ${memberDTO.email2 == 'naver.com' ? 'selected' : ''}>naver.com</option>
				        <option value="gmail.com" ${memberDTO.email2 == 'gmail.com' ? 'selected' : ''}>gmail.com</option>
				       </select>
				    </td>
				</tr>
				<tr>
				    <th class="label">휴대전화</th>
				    <td class="input">
				       <select name="tel1" class="input-tel">
				          <option value="010" ${memberDTO.tel1 == '010' ? 'selected' : ''}>010</option>
				        <option value="011" ${memberDTO.tel1 == '011' ? 'selected' : ''}>011</option>
				        <option value="019" ${memberDTO.tel1 == '019' ? 'selected' : ''}>019</option>
				     </select>
				       <input type="text" size="10" name="tel2" class="input-tel" value="${memberDTO.tel2 }" />
				       <input type="text" size="10" name="tel3" class="input-tel" value="${memberDTO.tel3 }" />
				    </td>
				</tr>

				<tr align="center">
				     <td colspan="2" height="20">
				         <button type="submit" id="updateBtn">회원정보수정</button>
				         <button type="reset" id="resetBtn">초기화</button>
					</td>
				</tr>
			</table>
		</form>
		</div> <!-- <div id="container"> -->
		
		<div class="links" id="withdraw">
			<a id="withdrawLink" href="${context }/member/memberDelete.do">회원탈퇴 ></a>
		</div>
	</div> <!-- <div id="right"> -->
</div>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../js/member.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	// 로그아웃
	$('#logOutBtn').click(function(){
		$.ajax({
			type: 'post',
			url: '${context }/member/memberLogOut.do',
			success: function(){
				location.href="${context }/index.do";
			},
    		error: function(xhr, status, error) {
    		    console.log("로그아웃 실패:", error);
    		    console.log("상태 코드:", xhr.status); // 상태 코드 확인
    		    console.log("응답 메시지:", xhr.responseText); // 응답 메시지 확인
    		}
		});
	});
	
	
    $('#updateBtn').click(function(event) {
        event.preventDefault(); // 폼 제출 방지
        $('#pwdDiv').hide();
        $('#repwdDiv').hide();
        
        let isValid = true;
        let pwd = $('#pwd').val().trim();
        let repwd = $('#repwd').val().trim();
        
        if (pwd === "") {
            $('#pwdDiv').html("비밀번호를 입력하세요").show();
            isValid = false;
        }

        if (isValid) {
            console.log("폼 데이터:", $('form[name="memberUpdateForm"]').serialize());
    
            $.ajax({
                type: 'post',
                url: '${pageContext.request.contextPath}/member/memberUpdate.do',
                data: $('form[name="memberUpdateForm"]').serialize(),
                success: function(status) {  // 서버로부터 status 값을 받아옴
                    console.log("서버 응답:", status);
                    if (status === "fail") {
                        alert("회원정보 수정에 실패하였습니다.");
                    } else {
                        alert("회원정보가 수정되었습니다");
                        location.href = '${pageContext.request.contextPath}/index.do';
                    }
                },
                error: function(xhr, status, error) {
                    console.log("회원정보수정 실패:", error);
                    console.log("상태 코드:", xhr.status);
                    console.log("응답 메시지:", xhr.responseText);
                }
            });
        }
    });
    
    // 비밀번호 확인 입력 필드에 실시간으로 비밀번호 일치 여부를 확인하는 기능 추가
    $('#repwd').on('input', function() {
        let pwd = $('#pwd').val().trim();
        let repwd = $('#repwd').val().trim();
        let repwdDiv = $('#repwdDiv');

        if (pwd !== repwd) {
            repwdDiv.html("비밀번호가 일치하지 않습니다").show();
        } else {
            repwdDiv.html("");  
            repwdDiv.hide();
        }
    });

    // 입력 필드에 포커스가 갈 때 오류 메시지 숨기기
    $('#name').focus(function() {
        $('#nameDiv').hide();
    });

    $('#pwd').focus(function() {
        $('#pwdDiv').hide();
    });

    $('#repwd').focus(function() {
        $('#repwdDiv').hide();
    });
});

</script>
</body>
</html>
