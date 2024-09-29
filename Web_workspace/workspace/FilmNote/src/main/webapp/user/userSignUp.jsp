<%-- FilmNote/src/main/webapp/user/userSignUp.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="../image/film_favicon.png" type="image/png">
<link rel="stylesheet" href="../css/userSignUp.css">
<%-- 외부 아이콘과 폰트를 사용하기 위한 외부 라이브러리 CSS 파일들 --%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" crossorigin="anonymous" referrerpolicy="no-referrer">
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<title>회원가입</title>
<script type="text/javascript">
    var contextPath = '<%= request.getContextPath() %>';
    <%-- JSP에서 context path를 자바스크립트에서 사용할 수 있게 변수로 저장 --%>
</script>
</head>
<body>
<jsp:include page="../common/header.jsp" />	
<%-- 상단에 공통 헤더를 포함하여 페이지 전반에 걸쳐 일관된 네비게이션을 제공 --%>
	
	<div id="write-jsp" class="signup-container">
        <h2>회원가입</h2>
        <%-- 회원가입 제목을 표시 --%>
        
        <!-- 경고 메시지를 표시하는 영역 -->
        <div id="warningMessage" class="show"></div>
        <%-- 경고 메시지를 표시하기 위한 div, 기본적으로 숨겨져 있지만 유효성 검사 실패 시 메시지를 표시 --%>
        
        <form id="signUpForm" action="${pageContext.request.contextPath}/user/userSignUpDB.do" method="post">
            <%-- 회원가입 폼. 입력 데이터를 POST 방식으로 전송하고 userSignUpDB.do로 처리 --%>
            <table>
                <!-- 이름 입력 필드 -->
                <tr>
                    <th class="label"><label for="uname"><i class="fa-solid fa-user"></i> 이름</label></th>
                    <td class="input">
                        <input type="text" id="uname" name="uname" placeholder="이름 입력" maxlength="8"> 
                        <%-- 이름을 입력받는 필드. 최대 8자로 제한됨 --%>
                        <div id="unameDiv"></div>
                        <%-- 이름 입력의 유효성 검사 결과가 표시될 div --%>
                    </td>
                </tr>
                
                <!-- 아이디 입력 필드 -->
                <tr>
                    <th class="label"><label for="uid"><i class="fa-solid fa-id-badge"></i> 아이디</label></th>
                    <td class="input">
                        <input type="text" id="uid" name="uid" placeholder="아이디 입력">
                        <%-- 아이디를 입력받는 필드 --%>
                        <div id="uidDiv"></div>
                        <%-- 아이디 유효성 검사 메시지가 표시될 div --%>
                    </td>
                </tr>
                
                <!-- 비밀번호 입력 필드 -->
                <tr>
                    <th class="label"><label for="upwd"><i class="fa-solid fa-lock"></i> 비밀번호</label></th>
                    <td class="input">
                        <input type="password" id="upwd" name="upwd" placeholder="비밀번호 입력">
                        <%-- 비밀번호를 입력받는 필드 --%>
                        <div id="upwdDiv"></div>
                        <%-- 비밀번호 유효성 검사 결과가 표시될 div --%>
                    </td>
                </tr>
                
                <!-- 비밀번호 확인 필드 -->
                <tr>
                    <th class="label"><label for="repwd"><i class="fa-solid fa-lock"></i> 재확인</label></th>
                    <td class="input">
                        <input type="password" id="repwd" name="repwd" placeholder="비밀번호 재입력">
                        <%-- 비밀번호 확인을 위해 동일한 비밀번호를 재입력받는 필드 --%>
                        <div id="repwdDiv"></div>
                        <%-- 비밀번호 확인 유효성 검사 결과가 표시될 div --%>
                    </td>
                </tr>
                
                <!-- 성별 선택 필드 -->
                <tr>
                    <th class="label"><label for="gender"><i class="fa-solid fa-venus-mars"></i> 성별</label></th>
                    <td class="input">
                        <label><input type="radio" id="male" name="gender" value="M"> 남자</label>
                        <label><input type="radio" id="female" name="gender" value="F"> 여자</label>
                        <%-- 성별을 선택하는 라디오 버튼. '남자' 또는 '여자'를 선택 가능 --%>
                        <div id="genderDiv"></div>
                        <%-- 성별 유효성 검사 결과가 표시될 div --%>
                    </td>
                </tr>
                
                <!-- 생년월일 입력 필드 -->
                <tr>
                    <th class="label"><label for="birth1"><i class="fa-solid fa-calendar"></i> 생년월일</label></th>
                    <td class="input">
                        <input type="text" id="birth1" name="birth1" placeholder="YYYY" class="input-tel"> 
                        <input type="text" id="birth2" name="birth2" placeholder="MM" class="input-tel"> 
                        <input type="text" id="birth3" name="birth3" placeholder="DD" class="input-tel">
                        <%-- 생년월일을 'YYYY', 'MM', 'DD' 형식으로 나누어 입력받는 필드 --%>
                        <div id="birthDiv"></div>
                        <%-- 생년월일 유효성 검사 결과가 표시될 div --%>
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
                        <%-- 이메일을 입력받는 필드. 사용자가 직접 이메일 도메인을 입력하거나 선택할 수 있음 --%>
                        <div id="emailDiv"></div>
                        <%-- 이메일 유효성 검사 결과가 표시될 div --%>
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
                        <%-- 휴대전화 번호를 입력받는 필드. 세 개의 필드로 나누어 입력 받음 (앞 번호, 중간 번호, 끝 번호) --%>
                        <div id="telDiv"></div>
                        <%-- 휴대전화 유효성 검사 결과가 표시될 div --%>
                    </td>
                </tr>
                
                <!-- 제출 및 초기화 버튼 -->
                <tr align="center">
                    <td colspan="2" height="20">
                        <button type="submit" id="signUp">회원가입</button>
                        <button type="reset" id="resetBtn">초기화</button>
                        <%-- 회원가입을 처리하는 제출 버튼과 입력된 값을 초기화하는 버튼 --%>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    
    <!-- 모달 다이얼로그 -->
    <div id="dialog" title="FilmNote" style="display:none;">
        <p id="dialogMessage"></p>
        <%-- 유효성 검증 실패 시 모달로 알림을 제공할 div --%>
    </div>
	
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<%-- jQuery 라이브러리 로드 --%>
<script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<%-- jQuery UI 라이브러리 로드 (모달 기능에 사용) --%>
<script type="text/javascript" src="../js/userSignUp.js"></script>
<%-- 회원가입 관련 로직을 처리하는 자바스크립트 파일 --%>
</body>
</html>
