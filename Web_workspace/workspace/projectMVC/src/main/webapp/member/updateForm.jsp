<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.bean.MemberDTO"%>
<%@ page import="member.dao.MemberDAO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	background-color: #0d0d0d;
	color: #00ffcc;
}
table {
	border-collapse: collapse;
}
th, td {
	padding: 5px;
}

#updateForm {
	display: flex;
	flex-direction: column;
	align-items: center;
	margin: 30px auto;
	text-align: left;	
}

#updateForm div {
	color: red;
	font-size: 8pt;
	font-weight: bold;
}
</style>
</head>
<body>

<form name="updateForm" id="updateForm" >
		<h1>
			<img src="../image/4.jpg" width="100" height="100" alt="홈" 
		 	onclick="location.href='/projectMVC/index.do'" style="cursor: pointer;">
		 	<!-- 클릭 시 메인 페이지로 이동하는 홈 버튼을 구현 -->
		  	회원정보수정
		</h1>
	<table border="1">
		<tr>
	        <th width="100">이름</th>
	        <td>
	        	<input type="text" name="name" id="name" value="${memberDTO.name }">
	        	<!-- 회원 이름을 출력하고 수정할 수 있도록 제공 -->
	        	<div id="nameDiv"></div>
	        	<!-- 이름 유효성 검사 메시지가 표시될 영역 -->
	        </td>
	    </tr>
	    
	    <tr>
	        <th>아이디</th>
	        <td>
	        	<input type="text" name="id" id="id" size="30" value="${memberDTO.id }" readonly>     
	        	<!-- 회원의 아이디는 수정 불가하도록 readonly 속성을 추가하여 출력 -->
	        </td>
	    </tr>
	    
	    <tr>
	        <th>비밀번호</th>
	        <td>
	        	<input type="password" name="pwd" id="pwd" size="40" placeholder="비밀번호 입력">
	        	<!-- 비밀번호를 수정할 수 있는 입력 필드 -->
	        	<div id="pwdDiv"></div>
	        	<!-- 비밀번호 유효성 검사 메시지가 표시될 영역 -->
	        </td>
	    </tr>
	    
	    <tr>
	        <th>재확인</th>
	        <td>
	        	<input type="password" id="repwd" size="40" placeholder="비밀번호 입력">
	        	<!-- 비밀번호 확인 입력 필드, 비밀번호 일치 여부를 확인하는 데 사용 -->
	        </td>
	    </tr>
	    
	    <tr>
	        <th>성별</th>
	        <td>
	        	<input type="radio" name="gender" value="0" />남자
	            <input type="radio" name="gender" value="1" />여자
	            <!-- 성별을 선택할 수 있는 라디오 버튼, 데이터베이스에서 값을 읽어와 자동 선택 -->
	        </td>
	    </tr>
	    
	    <tr>
	        <th>이메일</th>
	        <td>
	        	<input type="email" name="email1" value="${memberDTO.email1 }">
	        	<!-- 이메일 앞부분 입력 -->
	        	@
	        	<input type="text" name="email2" id="email2" value="${memberDTO.email2 }">
	        	<!-- 이메일 도메인 부분을 입력 -->
	        	
	        	<input type="email" name="email3" id="email3" list="email3_list" oninput="change()">        
	        	<datalist id="email3_list">
	        		<!-- 이메일 도메인 선택을 위한 datalist, 사용자는 직접 입력하거나 선택 가능 -->
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
	                    <!-- 휴대전화 앞자리를 선택할 수 있도록 제공 -->
	                    <option value="010">010</option>
	                    <option value="011">011</option>
	                    <option value="019">019</option>
	                </optgroup>
	            </select>
		         -
		         <input type="text" name="tel2" size="4" maxlength="4" value="${memberDTO.tel1 }">
		         <!-- 전화번호 중간 자리 입력 -->
		         -
		         <input type="text" name="tel3" size="4" maxlength="4" value="${memberDTO.tel2 }">
		         <!-- 전화번호 마지막 자리 입력 -->
			</td>
	    </tr>
	    
	    <tr>
	    	<th>주소</th>
	    	<td>
	    		<input type="text" name="zipcode" id="zipcode" size="6" readonly value="${memberDTO.zipcode }">
	    		<!-- 우편번호는 직접 입력이 불가하며 버튼을 통해 검색하도록 함 -->
	    		<button type="button" onclick="checkPost(); return false;">우편번호 검색</button><br/>
	    		<input type="text" name="addr1" id="addr1" size="60" readonly value="${memberDTO.addr1 }"><br/>
	    		<!-- 주소 입력 필드, addr1은 기본 주소, addr2는 상세 주소를 입력 -->
	    		<input type="text" name="addr2" id="addr2" size="60" value="${memberDTO.addr2 }">
	    	</td>
	    </tr>
	    
	    <tr>
	    	<td colspan="2" align="center">
	    		<input type="button" value="회원정보수정" id="updateBtn" />
	    		<!-- '회원정보 수정' 버튼 클릭 시 JavaScript로 유효성 검사 후 서버로 데이터 전송 -->
	    		<input type="reset" value="다시작성" onclick="location.reload()" />
	    		<!-- '다시작성' 버튼 클릭 시 페이지를 새로고침하여 입력 필드를 초기화 -->
	    	</td>
	    </tr>
	</table>
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
<!-- jQuery 라이브러리를 사용하여 다양한 이벤트 및 동작을 제어 -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- Daum 주소 검색 API를 사용해 우편번호 및 주소 검색 -->
<script src="../js/member.js"></script>
<!-- 회원 정보 수정과 관련된 JavaScript 파일을 외부에서 불러옴 -->
<script type="text/javascript">
window.onload = function(){
	document.updateForm.gender['${memberDTO.gender }'].checked = true;
	// 사용자가 저장한 성별 정보에 맞게 라디오 버튼을 자동으로 선택
	document.updateForm.tel1.value = '${memberDTO.tel1 }';
	// 사용자의 휴대전화 첫 번째 번호를 자동으로 선택
}
</script>
</body>
</html>
