<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="member.dao.MemberDAO" %>    
<%@page import="member.bean.MemberDTO" %>   
    
<% 
    // 로그인된 사용자 세션에서 사용자 ID를 가져옵니다.
    // 'memId'는 세션에 저장된 사용자 ID를 의미하며, 이 값을 사용해 DB에서 회원 정보를 조회합니다.
	String id = (String)session.getAttribute("memId"); 
 	
 	//DB에서 해당 사용자 정보를 가져오기 위해 MemberDAO의 인스턴스를 생성합니다.
 	MemberDAO memberDAO = MemberDAO.getInstance();
 	// getMember() 메서드를 호출하여 로그인된 사용자의 회원 정보를 가져옵니다.
 	MemberDTO memberDTO = memberDAO.getMember(id);
 	 
%>   
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정 페이지</title>
<!-- 회원 정보 수정 페이지의 CSS 파일을 링크합니다. -->
<link rel="stylesheet" type="text/css" href="/projectJSP/css/updatecss.css">
</head>
<body>

    <!-- 네비게이션 바를 외부 JSP 파일에서 포함시킵니다. -->
    <jsp:include page="/jsp/nav.jsp" />
    <hr/>
    <!-- 메인 메뉴로 돌아가는 버튼입니다. 이미지를 클릭하면 메인 페이지로 이동합니다. -->
    <img src="../image/back.png" onclick="location.href='../index.jsp'"
    		width="100" height="100" alt="메인메뉴" />
    		
    <!-- 회원정보 수정 폼입니다. -->
    <form name="updateForm" >
        <table>
            <!-- 로그인한 사용자 정보를 미리 채워서 보여줍니다. -->

            <!-- 이름 입력 필드: 사용자의 이름을 보여주며, 수정 가능합니다. -->
            <tr>
                <td>이름</td>
                <td>
                <!-- value 속성으로 DB에서 가져온 회원 이름을 미리 보여줍니다. -->
                <input type="text" name="name" id="name" value="<%=memberDTO.getName() %>" maxlength="50">
                <div id="nameDiv"></div>
                </td>
            </tr>

            <!-- 아이디 필드는 수정할 수 없도록 읽기 전용으로 설정합니다. -->
            <tr>
                <td>아이디</td>
                <td>
                <!-- 아이디는 변경할 수 없으므로 readonly 속성을 사용합니다. -->
                <input type="text" name="id" id="id" value="<%=memberDTO.getId() %>" readonly>
                </td>
            </tr>

            <!-- 비밀번호 입력 필드: 비밀번호는 새로 입력할 수 있습니다. -->
            <tr>
                <td>비밀번호</td>
                <td>
                <!-- 새 비밀번호를 입력받는 필드입니다. -->
                <input type="password" name="pwd" id="pwd" placeholder="새 비밀번호 입력">
                <div id="pwdDiv"></div>
                </td>
            </tr>

            <!-- 비밀번호 재입력 필드: 비밀번호 확인을 위한 필드입니다. -->
            <tr>
                <td>재확인</td>
                <td><input type="password" name="repwd" id="repwd" placeholder="비밀번호 재입력">
                </td>
            </tr>
            
            <!-- 성별 선택 필드: 남성/여성 중 하나를 선택할 수 있습니다. -->
            <tr>
                <td>성별</td>
                <td>
                    <!-- 성별을 라디오 버튼으로 표시하며, 서버에서 가져온 값을 기준으로 선택 상태를 설정합니다. -->
                    <input type="radio" name="gender" value="M" />남자 
                    <input type="radio" name="gender" value="F" />여자 
                </td>
            </tr>

            <!-- 이메일 필드: 사용자의 이메일 정보를 보여주고 수정할 수 있습니다. -->
            <tr>
                <td>이메일</td>
                <td class="email-field">
                    <!-- 이메일 앞부분과 뒷부분을 나누어 입력받습니다. -->
                    <input type="text" name="email1" id="email1" value="<%=memberDTO.getEmail1() %>" >
					@
					<!-- 이메일 도메인은 직접 입력하거나 미리 제공된 목록에서 선택할 수 있습니다. -->
					<input type="text" name="email2" id="email2" value="<%=memberDTO.getEmail2() %>" list="email_list">
					
                    <!-- 이메일 도메인을 선택할 수 있는 리스트를 제공합니다. -->
                    <datalist id="email_list">
                        <option value="naver.com"></option>
                        <option value="gmail.com"></option>
                        <option value="hanmail.com"></option>
                        <option value="daum.net"></option>
                    </datalist>
                </td>
            </tr>

            <!-- 전화번호 입력 필드: 전화번호는 3부분으로 나누어 입력받습니다. -->
            <tr>
                <td>휴대전화</td>
                <td class="phone-field">
                    <!-- 첫 번째 필드에서는 전화번호 앞자리를 선택할 수 있습니다. -->
                    <select name="tel1" id="tel1"> 
                        <option value="010">010</option>
                        <option value="011">011</option>
                        <option value="019">019</option>
                    </select>
                    <!-- 전화번호 중간과 마지막 자리는 직접 입력받습니다. -->
                    -
                    <input type="text" name="tel2" id="tel2" maxlength="4" value="<%=memberDTO.getTel2() %>">
                    -
                    <input type="text" name="tel3" id="tel3" maxlength="4" value="<%=memberDTO.getTel3() %>">
                </td>
            </tr>

            <!-- 주소 입력 필드: 우편번호와 주소를 보여주고 수정할 수 있습니다. -->
            <tr>
                <td>주소</td>
                <td>
                    <!-- 우편번호는 읽기 전용 필드로 설정하며, 버튼을 눌러 우편번호 검색을 할 수 있습니다. -->
                    <input type="text" name="zipcode" id="zipcode" value="<%=memberDTO.getZipcode() %>" readonly placeholder="우편번호">
                    <input type="button" value="우편번호 검색" onclick="checkPost()">
                    <br>
                    <!-- 기본 주소는 읽기 전용 필드로 설정합니다. -->
                    <input type="text" name="addr1" id="addr1" value="<%=memberDTO.getAddr1() %>" readonly placeholder="주소">
                    <br>
                    <!-- 상세 주소는 사용자가 직접 입력할 수 있습니다. -->
                    <input type="text" name="addr2" id="addr2" value="<%=memberDTO.getAddr2() %>" placeholder="상세주소">
                </td>
            </tr>

            <!-- 수정 버튼과 폼 초기화 버튼을 제공합니다. -->
            <tr>
                <td colspan="2" align="center">
                    <!-- 회원 정보를 수정하는 버튼입니다. -->
                    <input type="button" value="회원정보 수정" id="updateBtn" /> 
                    <!-- 폼을 초기화하는 리셋 버튼입니다. -->
                    <input type="reset" value="다시 입력" onclick="location.reload()" /> 
                    <!-- 뒤로 가기 버튼으로, 메인 Main Menu 로 돌아갑니다. -->
                    <input type="button" value="Main Menu" onclick="window.location.href='../index.jsp';"> 
                </td>
            </tr>
        </table>
    </form>

<!-- 외부 JS 파일 및 Daum 우편번호 API를 포함합니다. -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="../js/member.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script>
    // 네비게이션 바를 외부 JSP 파일에서 불러옵니다.
    $('#navbar').load('/projectJSP/jsp/nav.jsp');
</script>

<script type="text/javascript" >
	// 페이지가 로드될 때 실행됩니다.
	window.onload = function() {
	    // 성별 값을 서버에서 가져옵니다. (남성: M, 여성: F)
	    var gender = "<%= memberDTO.getGender() %>";  
	 	// 성별 값을 비교하여 해당하는 라디오 버튼을 선택 상태로 만듭니다.
	    if (gender === "M") {
	        document.updateForm.gender[0].checked = true; // 남성 (첫 번째 radio 버튼 선택)
	    } else if (gender === "F") {
	        document.updateForm.gender[1].checked = true; // 여성 (두 번째 radio 버튼 선택)
	    }
	 	
	 	// 전화번호 첫 번째 필드 값을 서버에서 가져와서 설정합니다.
	 	document.updateForm.tel1.value = '<%=memberDTO.getTel1() %>';
	};
</script>
  
</body>
</html>
