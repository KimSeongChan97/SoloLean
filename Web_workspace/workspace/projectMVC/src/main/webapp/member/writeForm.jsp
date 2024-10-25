<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입Form</title>
<style type="text/css">

body {
	background-color: #0d0d0d;
	color: #00ffcc;
	/* 페이지 전체 배경색을 어두운 색(#0d0d0d)으로 설정하고, 텍스트를 밝은 청록색(#00ffcc)으로 설정 */
}

table {
	border-collapse: collapse;
	/* 테이블 셀의 경계를 합쳐 하나로 보이게 설정하여 깔끔한 테이블 스타일을 구현 */
}
th, td {
	padding: 5px;
	/* 테이블의 각 셀 안에 여백을 추가하여 내용을 보기 좋게 만듦 */
}

#writeForm {
	display: flex;
	flex-direction: column;
	align-items: center;
	margin: 30px auto;
	text-align: left;	
}

#writeForm div {
	color: red;
	font-size: 8pt;
	font-weight: bold;
	/* 경고 메시지를 표시할 div의 스타일: 빨간색 글씨, 작은 글씨 크기, 굵은 글씨 */
}
h1 {
	text-align: center;
	/* 페이지 상단의 제목을 가운데 정렬 */
}

</style>
</head>
<body>

<form name="writeForm" id="writeForm" >
	<!-- 사용자가 회원가입 정보를 작성하고 제출할 폼. post 방식으로 데이터를 전송하고, 서버에서 처리할 URL을 설정 -->
	
	<h1>
	<img src="../image/4.jpg" width="100" height="100" alt="홈" 
		 onclick="location.href='${ pageContext.request.contextPath }/index.do'"
		  style="cursor: pointer;"> 
	<!-- 홈 버튼을 이미지로 구현하여 클릭 시 메인 페이지로 이동하게 설정 -->
	회원가입
	</h1>
	
	<table border="1">
		<tr>
	        <th width="100">이름</th>
	        <td>
	        	<input type="text" name="name" id="name" placeholder="이름 입력">
	        	<!-- 사용자가 이름을 입력할 수 있는 필드 -->
	        	<div id="nameDiv"></div>
	        	<!-- 이름 입력 관련 경고 메시지를 표시할 영역 -->
	        </td>
	    </tr>
	    
	    <tr>
	        <th>아이디</th>
	        <td>
	        	<input type="text" name="id" id="id" size="30" placeholder="아이디 입력">
	        	<!-- 사용자가 아이디를 입력할 수 있는 필드 -->
	        	<input type="hidden" id="check" value="">
	        	<!-- 중복체크를 완료했는지 확인하는 hidden 필드 -->
	        	<div id="idDiv"></div>
	        	<!-- 아이디 입력 관련 경고 메시지를 표시할 영역 -->
	        </td>
	    </tr>
	    
	    <tr>
	        <th>비밀번호</th>
	        <td>
	        	<input type="password" name="pwd" id="pwd" size="40" placeholder="비밀번호 입력">
	        	<!-- 사용자가 비밀번호를 입력할 수 있는 필드 -->
	        	<div id="pwdDiv"></div>
	        	<!-- 비밀번호 입력 관련 경고 메시지를 표시할 영역 -->
	        </td>
	    </tr>
	    
	    <tr>
	        <th>재확인</th>
	        <td>
	        	<input type="password" id="repwd" size="40" placeholder="비밀번호 입력">
	        	<!-- 사용자가 입력한 비밀번호를 다시 한 번 확인하기 위한 필드 -->
	        </td>
	    </tr>
	    
	    <tr>
	        <th>성별</th>
	        <td>
	        	<input type="radio" name="gender" value="0" checked="checked" />남자
	            <input type="radio" name="gender" value="1" />여자
	            <!-- 사용자가 성별을 선택할 수 있는 라디오 버튼 -->
	        </td>
	    </tr>
	    
	    <tr>
	        <th>이메일</th>
	        <td>
	        	<input type="email" name="email1">
	        	<!-- 이메일 앞부분을 입력하는 필드 -->
	        	@
	        	<input type="text" name="email2" id="email2">
	        	<!-- 이메일 도메인을 입력하는 필드 -->
	        	
	        	<input type="email" name="email3" id="email3" list="email3_list" oninput="change()">        
	        	<!-- 사용자가 이메일 도메인을 직접 입력하거나 선택할 수 있도록 제공하는 필드 -->
	        	<datalist id="email3_list">
	        		<option value="직접입력"></option>
	                <option value="naver.com"/>
	                <option value="gmail.com"/>
	                <option value="daum.net"/>
	                <!-- 자주 사용하는 이메일 도메인을 미리 선택할 수 있도록 datalist 제공 -->
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
	                <!-- 휴대전화 앞자리 번호를 선택할 수 있도록 제공 -->
	            </select>
		         -
		         <input type="text" name="tel2" size="4" maxlength="4">
		         <!-- 휴대전화 중간 번호 입력 필드 -->
		         -
		         <input type="text" name="tel3" size="4" maxlength="4">
		         <!-- 휴대전화 끝 번호 입력 필드 -->
			</td>
	    </tr>
	    
	    <tr>
	    	<th>주소</th>
	    	<td>
	    		<input type="text" name="zipcode" id="zipcode" size="6" readonly placeholder="우편번호">
	    		<!-- 우편번호는 직접 입력하지 않고, 검색 버튼을 통해 설정하게 함 -->
	    		<button type="button" onclick="checkPost(); return false;">우편번호 검색</button><br/>
	    		<input type="text" name="addr1" id="addr1" size="60" readonly placeholder="주소"><br/>
	    		<!-- 주소는 우편번호 검색으로 자동 설정되므로 readonly로 처리 -->
	    		<input type="text" name="addr2" id="addr2" size="60" placeholder="상세주소">
	    		<!-- 사용자가 직접 입력해야 하는 상세 주소 필드 -->
	    	</td>
	    </tr>
	    
	    <tr>
	    	<td colspan="2" align="center">
	    		<input type="button" value="회원가입" onclick="checkWrite()"/>
	    		<!-- '회원가입' 버튼 클릭 시 유효성 검사를 수행하는 함수 checkWrite() 호출 -->
	    		<input type="reset" value="다시작성" />
	    		<!-- '다시작성' 버튼을 클릭하면 폼이 초기화됨 -->
	    	</td>
	    </tr>
	</table>
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
<!-- jQuery 라이브러리를 불러와 DOM 조작 및 이벤트 처리를 간편하게 수행 -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- Daum의 주소 검색 API를 사용해 우편번호 및 주소를 자동으로 채워줌 -->
<script src="../js/member.js"></script>
<!-- 회원가입과 관련된 유효성 검사 및 기타 로직이 담긴 외부 JavaScript 파일을 불러옴 -->
</body>
</html>
