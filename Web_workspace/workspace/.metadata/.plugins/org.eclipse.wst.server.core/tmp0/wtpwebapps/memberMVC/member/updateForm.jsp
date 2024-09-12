<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.bean.MemberDTO"%>
<%@ page import="member.dao.MemberDAO"%>

<%
	String id = (String)session.getAttribute("memId");

	//DB
	MemberDAO memberDAO = MemberDAO.getInstance();
	MemberDTO memberDTO = memberDAO.getMember(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border-collapse: collapse;
}
th, td {
	padding: 5px;
}
div {
	color: red;
	font-size: 8pt;
	font-weight: bold;
}
</style>
</head>
<body>
<h1>
	<img src="../image/4.jpg" width="100" height="100" alt="홈" 
		 onclick="location.href='../index.jsp'" style="cursor: pointer;"> 회원정보수정
</h1>
<form name="updateForm">
	<table border="1">
		<tr>
	        <th width="100">이름</th>
	        <td>
	        	<input type="text" name="name" id="name" value="<%=memberDTO.getName() %>">
	        	<div id="nameDiv"></div>
	        </td>
	    </tr>
	    
	    <tr>
	        <th>아이디</th>
	        <td>
	        	<input type="text" name="id" id="id" size="30" value="<%=memberDTO.getId() %>" readonly>     
	        </td>
	    </tr>
	    
	    <tr>
	        <th>비밀번호</th>
	        <td>
	        	<input type="password" name="pwd" id="pwd" size="40" placeholder="비밀번호 입력">
	        	<div id="pwdDiv"></div>
	        </td>
	    </tr>
	    
	    <tr>
	        <th>재확인</th>
	        <td>
	        	<input type="password" id="repwd" size="40" placeholder="비밀번호 입력">
	        </td>
	    </tr>
	    
	    <tr>
	        <th>성별</th>
	        <td>
	        	<input type="radio" name="gender" value="0" />남자
	            <input type="radio" name="gender" value="1" />여자
	        </td>
	    </tr>
	    
	    <tr>
	        <th>이메일</th>
	        <td>
	        	<input type="email" name="email1" value="<%=memberDTO.getEmail1() %>">
	        	@
	        	<input type="text" name="email2" id="email2" value="<%=memberDTO.getEmail2() %>">
	        	
	        	<input type="email" name="email3" id="email3" list="email3_list" oninput="change()">        
	        	<datalist id="email3_list">
	        		<option value="직접입력"></option>
	                <option value="naver.com"/>
	                <option value="gmail.com"/>
	                <option value="daum.net"/>
	        	</datalist>
	        </td>
	    </tr>
	    
	    <tr>
	        <th>휴대전화</th>
	        <td>
	            <select name="tel1">
	                <optgroup label="hp">
	                    <option value="010">010</option>
	                    <option value="011">011</option>
	                    <option value="019">019</option>
	                </optgroup>
	            </select>
		         -
		         <input type="text" name="tel2" size="4" maxlength="4" value="<%=memberDTO.getTel2() %>">
		         -
		         <input type="text" name="tel3" size="4" maxlength="4" value="<%=memberDTO.getTel3() %>">
			</td>
	    </tr>
	    
	    <tr>
	    	<th>주소</th>
	    	<td>
	    		<input type="text" name="zipcode" id="zipcode" size="6" readonly value="<%=memberDTO.getZipcode() %>">
	    		<button type="button" onclick="checkPost(); return false;">우편번호 검색</button><br/>
	    		<input type="text" name="addr1" id="addr1" size="60" readonly value="<%=memberDTO.getAddr1() %>"><br/>
	    		<input type="text" name="addr2" id="addr2" size="60" value="<%=memberDTO.getAddr2() %>">
	    	</td>
	    </tr>
	    
	    <tr>
	    	<td colspan="2" align="center">
	    		<input type="button" value="회원정보수정" id="updateBtn" />
	    		<input type="reset" value="다시작성" onclick="location.reload()" />
	    	</td>
	    </tr>
	</table>
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="../js/member.js"></script>
<script type="text/javascript">
window.onload = function(){
	document.updateForm.gender['<%=memberDTO.getGender() %>'].checked = true;
	document.updateForm.tel1.value = '<%=memberDTO.getTel1() %>';
}
</script>
</body>
</html>













