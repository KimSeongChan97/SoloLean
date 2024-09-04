<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<style type="text/css">

table {
    width: 600px; /* 테이블의 너비를 600px로 설정하여 좀 더 넓은 화면에서 표시되도록 수정 */
    border-collapse: collapse; /* 테이블 테두리 간격을 없애고, 셀 경계선이 하나로 보이도록 설정 */
    border: 1px solid #ccc; /* 테두리 색을 밝은 회색으로 설정 */
    margin: 50px auto; /* 테이블을 상단에서 50px, 좌우 중앙에 배치 */
    padding: 20px; /* 테이블 내부에 20px의 여유 공간 추가 */
    box-shadow: 0 0 14px rgba(0, 0, 0, 0.9); /* 그림자 효과로 테이블이 입체적으로 보이도록 설정 */
    /* 추가 설명: 테이블의 박스를 시각적으로 더 두드러지게 보여줍니다. */
}

td {
    padding: 10px; /* 테이블 셀 내부에 10px의 여백을 추가하여 텍스트와 입력 필드가 테두리에서 떨어지게 설정 */
    vertical-align: middle; /* 셀 안의 내용이 가운데에 배치되도록 설정 */
    /* 추가 설명: 셀의 텍스트와 입력 필드를 중앙에 정렬하여 보기 좋게 배치합니다. */
}

input[type="text"], input[type="password"], select {
    width: 75%; /* 입력 필드와 드롭다운 목록의 너비를 75%로 설정하여 크기를 적절히 조정 */
    padding: 5px; /* 입력 필드 안에 5px의 여백을 추가하여 입력 시 편안한 여유 공간 제공 */
    box-sizing: border-box; /* 패딩을 포함한 전체 크기를 조정하여 전체 너비를 유지 */
    border: 1px solid #ccc; /* 입력 필드 테두리를 밝은 회색으로 설정 */
    border-radius: 4px; /* 테두리를 둥글게 처리하여 부드럽고 세련된 느낌을 줌 */
    /* 추가 설명: 입력 필드의 크기를 적절하게 유지하고, 사용자가 입력할 때 경계와 공간을 시각적으로 알기 쉽게 만들어 줍니다. */
}

input[type="radio"] {
    margin: 0 10px 0 0; /* 라디오 버튼과 텍스트(남자, 여자) 사이에 10px의 간격을 추가 */
    /* 추가 설명: 라디오 버튼과 라벨 사이의 공간을 두어 텍스트와 버튼이 붙어 있지 않도록 조정합니다. */
}

input[type="button"], input[type="submit"], input[type="reset"] {
    width: 120px; /* 버튼의 너비를 120px로 고정 */
    padding: 10px; /* 버튼 내부에 10px의 여백을 추가하여 클릭 영역을 넓힘 */
    margin-top: 10px; /* 버튼 위에 여백을 10px 추가하여 간격을 둠 */
    border: 1px solid #ccc; /* 버튼의 테두리를 밝은 회색으로 설정 */
    border-radius: 4px; /* 버튼의 모서리를 둥글게 처리하여 부드러운 느낌 제공 */
    background-color: #f9f9f9; /* 버튼 배경색을 밝은 회색으로 설정 */
    cursor: pointer; /* 버튼 위로 마우스를 올렸을 때 커서가 손가락 모양으로 변경 */
    /* 추가 설명: 버튼 위로 마우스를 올렸을 때 시각적인 피드백을 제공하여 클릭 가능하다는 것을 알려줍니다. */
}

input[type="button"]:hover, input[type="submit"]:hover, input[type="reset"]:hover {
    background-color: #ddd; /* 버튼에 마우스를 올렸을 때 배경색이 더 어두운 회색으로 변경 */
    /* 추가 설명: 마우스를 버튼 위에 올리면 색상이 변하여 사용자가 상호작용 중임을 시각적으로 알 수 있습니다. */
}

td:first-child {
    width: 100px; /* 첫 번째 열의 너비를 100px로 고정하여 일관성을 유지 */
    text-align: right; /* 첫 번째 열의 텍스트를 오른쪽 정렬하여 입력 필드와 간격 유지 */
    padding-right: 10px; /* 레이블과 입력 필드 사이에 10px의 간격을 추가 */
    /* 추가 설명: 입력 필드와 레이블 사이의 공간을 적절히 배분하여 정돈된 레이아웃을 제공 */
}

td:last-child {
    text-align: left; /* 마지막 열, 즉 입력 필드가 들어가는 셀의 텍스트를 왼쪽 정렬 */
    /* 추가 설명: 입력 필드는 자연스럽게 왼쪽 정렬되어 사용자가 입력하기 편리한 레이아웃을 형성합니다. */
}

form {
    background-color: #fdfdfd; /* 폼의 배경색을 밝은 회색으로 설정하여 깔끔한 외관 제공 */
    border-radius: 8px; /* 폼의 테두리를 둥글게 처리하여 부드러운 인상을 줌 */
    padding: 20px; /* 폼 내부에 20px의 여백을 추가하여 콘텐츠가 테두리에 너무 가까이 붙지 않도록 함 */
    /* 추가 설명: 폼의 배경색과 테두리를 설정하여 보기 좋은 레이아웃과 사용 편의성을 제공 */
}

.email-field, .id-field {
    display: flex; /* 입력 필드와 레이블을 수평으로 나란히 배치하기 위해 Flexbox 사용 */
    align-items: center; /* 수직 정렬하여 라벨과 입력 필드가 균등하게 배치되도록 설정 */
    /* 추가 설명: Flexbox를 사용하여 필드들이 정렬되고, 레이블과 입력 필드가 동일한 선상에 오도록 배치됩니다. */
}

.email-field input[type="text"], .email-field input[type="email"] {
    width: 45%; /* 이메일 입력 필드의 너비를 45%로 설정하여 도메인 필드와 균등하게 배치되도록 함 */
    margin-right: 5px; /* 이메일 앞부분과 도메인 입력 필드 사이에 5px의 간격을 추가 */
}

.email-field select, .email-field datalist {
    width: 45%; /* 이메일 도메인 선택 필드의 너비를 45%로 설정 */
    /* 추가 설명: 이메일 필드를 나란히 정렬하여 사용자가 편리하게 입력할 수 있도록 균형 잡힌 레이아웃을 형성 */
}

.id-field input[type="text"] {
    width: 75%; /* 아이디 입력 필드의 너비를 75%로 설정하여 중복 체크 버튼과 균형을 맞춤 */
    /* 추가 설명: 입력 필드의 너비를 줄여 버튼과 일관된 크기로 균형을 맞추어 시각적으로 더 보기 좋게 설정 */
}

.id-field input[type="button"] {
    width: auto; /* 버튼의 너비를 자동으로 설정하여 텍스트에 맞추어 크기를 조정 */
    padding: 6px 10px; /* 버튼 내부에 여백을 설정하여 클릭 영역을 넓힘 */
    height: 36px; /* 버튼의 높이를 입력 필드와 동일하게 설정 */
    /* 추가 설명: 버튼의 높이를 입력 필드와 일치시켜 시각적으로 일관성을 유지합니다. */
}

.phone-field {
    display: flex; /* 전화번호 입력 필드들을 수평으로 나란히 배치하여 가독성을 높임 */
    gap: 5px; /* 필드들 사이에 5px의 간격을 추가하여 필드 간의 여유를 둠 */
    /* 추가 설명: 전화번호 필드를 세 부분으로 나누어 사용자가 더 쉽게 입력할 수 있도록 유도 */
}

td[colspan="2"] {
    text-align: center; /* 두 열을 합친 셀의 텍스트를 가운데 정렬 */
    /* 추가 설명: 전체 버튼들이 가운데 정렬되어 화면의 중앙에 위치하게 됩니다. */
}

div {
	color: red;
	font-size: 9pt;
	font-weight: bold;
	margin-top: 5px;
    /* 추가 설명: 오류 메시지를 강조하여 사용자가 쉽게 인지할 수 있도록 스타일 적용 */
}

</style>
</head>
<body>
	<h3 align="center">회원가입</h3> <!-- 회원가입 제목을 가운데 정렬하고, h3 태그로 크기 설정 -->
	<hr/> <!-- 제목 아래에 구분선을 추가 -->

	<!-- 사용자가 입력한 데이터를 서버에 전송할 수 있도록 method="post"로 설정 -->
    <form name="memberForm" method="post" action="memberWrite.jsp" onsubmit="return validateForm()" >
        <table>
            <!-- 이름 입력 필드 -->
            <tr>
                <td>이름</td>
                <td><input type="text" name="name" id="name" placeholder="이름 입력">
                <div id="nameDiv"></div> <!-- 오류 메시지나 확인 메시지를 표시할 div 영역 -->
                </td>
            </tr>

            <!-- 아이디 입력 필드 -->
            <tr>
                <td>아이디</td>
                <td class="id-field">
                    <input type="text" name="id" size="30" id="id" placeholder="아이디 입력">
                    <input type="button" onclick="checkId()" value="중복체크"/> <!-- 아이디 중복체크 버튼 -->
                    <br/>
                    <div id="idDiv"></div> <!-- 아이디 중복 검사 결과를 표시할 div -->
                </td>
            </tr>

            <!-- 비밀번호 입력 필드 -->
            <tr>
                <td>비밀번호</td>
                <td><input type="password" name="pwd" size="40" id="pwd" placeholder="비밀번호 입력">
                <div id="pwDiv"></div> <!-- 비밀번호 입력 관련 오류 메시지를 표시할 div -->
                </td>
            </tr>

            <!-- 비밀번호 재입력 필드 -->
            <tr>
                <td>재확인</td>
                <td><input type="password" name="repwd" size="40" id="repwd" placeholder="비밀번호 재입력">
                <div id="pwDiv"></div> <!-- 비밀번호 재입력 관련 오류 메시지를 표시할 div -->
                </td>
            </tr>

            <!-- 성별 선택 필드 -->
            <tr>
                <td>성별</td>
                <td>
                    <input type="radio" name="gender" value="M" checked="checked" />남자 
                    <input type="radio" name="gender" value="F" />여자 
                </td>
            </tr>

            <!-- 이메일 입력 필드 -->
            <tr>
                <td>이메일</td>
                <td class="email-field">
                    <!-- 사용자가 입력할 이메일의 앞부분 (email1) -->
                    <input type="text" name="email1" id="email1" placeholder="이메일 입력">
                    @ <!-- 이미 포함된 '@' 기호를 사용하여 이메일의 앞뒤를 구분 -->
                    <!-- 사용자가 입력할 이메일의 뒷부분 (email2) -->
                    <input type="text" name="email2" id="email2" placeholder="직접입력" list="email_list" />
                    <datalist id="email_list">
                        <option value="naver.com"></option>
                        <option value="gmail.com"></option>
                        <option value="hanmail.com"></option>
                        <option value="daum.net"></option>
                    </datalist>
                </td>
            </tr>

            <!-- 휴대전화 입력 필드 -->
            <tr>
                <td>휴대전화</td>
                <td class="phone-field">
                    <select name="tel1" id="tel1"> 
                    	<optgroup label="hp">
                        <option value="010">010</option>
                        <option value="011">011</option>
                        <option value="019">019</option>
                        </optgroup>
                    </select>
                    -
                    <input type="text" name="tel2" size="5" maxlength="4" id="tel2" placeholder="앞자리">
                    -
                    <input type="text" name="tel3" size="5" maxlength="4" id="tel3" placeholder="뒷자리">
                </td>
            </tr>

            <!-- 주소 입력 필드 -->
            <tr>
                <td>주소</td>
                <td>
                    <input type="text" name="zipcode" id="zipcode" size="6" readonly placeholder="우편번호">
                    <input type="button" value="우편번호 검색" onclick="checkPost()">
                    <br>
                    <input type="text" name="addr1" id="addr1" size="60" readonly placeholder="주소">
                    <br>
                    <input type="text" name="addr2" id="addr2" size="60" placeholder="상세주소">
                </td>
            </tr>

            <!-- 하단 버튼 필드 -->
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="회원가입"/> 
                    <input type="reset" value="다시입력"/> 
                    <input type="button" value="뒤로가기" onclick="window.location.href='../index.jsp';"> 
                </td>
            </tr>
        </table>
    </form>
    
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script> <!-- 우편번호 검색 API -->
<script src="../js/member.js"></script> <!-- JavaScript 함수 파일 로드 -->
     
</body>
</html>

<!--
validateForm() 함수 설명:

이 함수는 회원가입 폼을 제출하기 전에 모든 입력 값들이 유효한지 확인하는 역할을 합니다.
여러 유효성 검사 항목을 통해 사용자 입력의 오류를 체크하고, 오류가 있으면 폼 제출을 막습니다.

1. 이름 유효성 검사
    - 이름 필드가 비어있는지 확인합니다.
    - 이름에 숫자나 특수문자가 포함되지 않았는지 검사합니다.
    - 오류가 있으면 오류 메시지를 출력하고, 없으면 메시지를 제거합니다.

2. 아이디 중복 체크 확인
    - 사용자가 아이디 중복 체크를 완료했는지 확인합니다.
    - 중복 체크가 완료되지 않았으면 경고 메시지를 띄우고 폼 제출을 막습니다.

3. 비밀번호 유효성 검사
    - 비밀번호의 길이가 3자 이상인지 확인합니다.
    - 비밀번호와 재입력된 비밀번호가 일치하는지 확인합니다.
    - 비밀번호에 숫자와 특수문자가 포함되었는지 검사합니다.
    - 위의 조건을 만족하지 않으면 폼 제출을 막고 오류 메시지를 출력합니다.

4. 이메일 유효성 검사
    - 사용자가 입력한 이메일이 유효한 형식인지 확인합니다.
    - 이메일 앞부분과 도메인(예: naver.com)을 결합하여 전체 이메일을 만듭니다.
    - 정규식을 사용하여 이메일 형식이 유효한지 검사합니다.
    - 유효하지 않은 이메일 형식이면 경고 메시지를 띄우고 폼 제출을 막습니다.

5. 모든 유효성 검사를 통과한 경우 폼을 제출할 수 있도록 허용합니다.
-->

