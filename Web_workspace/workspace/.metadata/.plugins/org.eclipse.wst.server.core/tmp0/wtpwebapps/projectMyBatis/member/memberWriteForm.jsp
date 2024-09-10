<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<link rel="stylesheet" type="text/css" href="/projectJSP/css/memberWritecss.css">
</head>
<body>

	<jsp:include page="/jsp/nav.jsp" />
		<hr/>
	    <h3 align="center" style="font-family: 'Comic Sans MS';" style="cursor: pointer;" 
	 		onclick="location.href='../index.jsp'" >회원가입</h3>
			
		<form name="memberForm" method="post" action="/projectJSP/member/memberWrite.jsp">
        <table>
            <!-- 이름 입력 필드 -->
            <tr>
                <td>이름</td>
                <td>
                <input type="text" name="name" id="name" placeholder="이름 입력">
                <div id="nameDiv"></div> <!-- 오류 메시지나 확인 메시지를 표시할 div 영역 -->
                </td>
            </tr>

            <!-- 아이디 입력 필드 -->
	            <tr>
				    <td>아이디</td>
				    <td class="id-field">
				        <input type="text" name="id" size="30" id="id" placeholder="아이디 입력">
				        <input type="text" id="check" value="" />
				        <div id="idDiv"></div> <!-- 아이디 중복 검사 결과를 표시할 div -->
				        <input type="button" onclick="checkId()" value="중복체크" class="check-btn"/> <!-- 아이디 중복체크 버튼 -->
			    	</td>
				</tr>
				
            <!-- 비밀번호 입력 필드 -->
            <tr>
                <td>비밀번호</td>
                <td>
                <input type="password" name="pwd" size="40" id="pwd" placeholder="비밀번호 입력">
                <div id="pwdDiv"></div> <!-- 비밀번호 입력 관련 오류 메시지를 표시할 div -->
                </td>
            </tr>

            <!-- 비밀번호 재입력 필드 -->
            <tr>
                <td>재확인</td>
                <td><input type="password" name="repwd" size="40" id="repwd" placeholder="비밀번호 재입력">
                <div id="repwdDiv"></div> <!-- 비밀번호 재입력 관련 오류 메시지를 표시할 div -->
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
                    <input type="text" name="email2" id="email2" placeholder="직접입력" list="email_list" oninput="change()" />
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
			    <td colspan="2">
			        <div class="button-container">
			            <input type="submit" value="회원가입">
			            <input type="reset" value="다시입력">
			            <input type="button" value="뒤로가기" onclick="window.location.href='../index.jsp';">
			        </div>
			    </td>
			</tr>

        </table>
    </form>
    
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script> <!-- 우편번호 검색 API -->
<script src="../js/member.js"></script> <!-- JavaScript 함수 파일 로드 -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- jQuery로 JSP 파일을 불러오는 코드 -->
    <script>
        // jQuery의 load() 메서드를 사용하여 JSP 파일을 불러옴
        $('#navbar').load('/projectJSP/jsp/nav.jsp');
    </script>  
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

