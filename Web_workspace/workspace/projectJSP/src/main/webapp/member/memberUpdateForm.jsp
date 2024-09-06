<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="member.dao.MemberDAO" %>    
<%@page import="member.bean.MemberDTO" %>   
    
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
<title>회원정보 수정 페이지</title>
<link rel="stylesheet" type="text/css" href="/projectJSP/css/updatecss.css">
</head>
<body>

    <jsp:include page="/jsp/nav.jsp" />
    <hr/>
    <img src="../image/back.png" onclick="location.href='../index.jsp'"
    		width="100" height="100" alt="메인메뉴" />
    		
    <form name="updateForm" method="post" action="memberUpdate.jsp">
        <table>
            <!-- 로그인한 사용자 정보를 미리 채워서 보여줍니다. -->
            <!-- 이름 입력 필드 -->
            <tr>
                <td>이름</td>
                <td>
                <input type="text" name="name" id="name" value="<%=memberDTO.getName() %>">
                <div id="nameDiv"></div>
                </td>
            </tr>

            <!-- 아이디 필드는 수정할 수 없도록 읽기 전용으로 설정합니다. -->
            <tr>
                <td>아이디</td>
                <td>
                <input type="text" name="id" id="id" value="<%=memberDTO.getId() %>" readonly>
                </td>
            </tr>

            <!-- 비밀번호 입력 필드 -->
            <tr>
                <td>비밀번호</td>
                <td>
                <input type="password" name="pwd" id="pwd" placeholder="새 비밀번호 입력">
                <div id="pwdDiv"></div>
                </td>
            </tr>

            <!-- 비밀번호 재입력 필드 -->
            <tr>
                <td>재확인</td>
                <td><input type="password" name="repwd" id="repwd" placeholder="비밀번호 재입력">
                </td>
            </tr>
			 <!-- 성별 선택 필드 -->
            <tr>
                <td>성별</td>
                <td>
                    <input type="radio" name="gender" value="M" />남자 
                    <input type="radio" name="gender" value="F" />여자 
                </td>
            </tr>
            <!-- 이메일 필드 -->
            <tr>
                <td>이메일</td>
                <td class="email-field">
                    <input type="text" name="email1" id="email1" value="<%=memberDTO.getEmail1() %>" >
					@
					<input type="text" name="email2" id="email2" value="<%=memberDTO.getEmail2() %>" list="email_list">
					
                    <datalist id="email_list">
                        <option value="naver.com"></option>
                        <option value="gmail.com"></option>
                        <option value="hanmail.com"></option>
                        <option value="daum.net"></option>
                    </datalist>
                </td>
            </tr>

            <!-- 전화번호 입력 필드 -->
            <tr>
                <td>휴대전화</td>
                <td class="phone-field">
                    <select name="tel1" id="tel1"> 
                        <option value="010">010</option>
                        <option value="011">011</option>
                        <option value="011">019</option>
                    </select>
                    -
                    <input type="text" name="tel2" id="tel2" maxlength="4" value="<%=memberDTO.getTel2() %>">
                    -
                    <input type="text" name="tel3" id="tel3" maxlength="4" value="<%=memberDTO.getTel3() %>">
                </td>
            </tr>

            <!-- 주소 입력 필드 -->
            <tr>
                <td>주소</td>
                <td>
                    <input type="text" name="zipcode" id="zipcode" value="<%=memberDTO.getZipcode() %>" readonly placeholder="우편번호">
                    <input type="button" value="우편번호 검색" onclick="checkPost()">
                    <br>
                    <input type="text" name="addr1" id="addr1" value="<%=memberDTO.getAddr1() %>" readonly placeholder="주소">
                    <br>
                    <input type="text" name="addr2" id="addr2" value="<%=memberDTO.getAddr2() %>" placeholder="상세주소">
                </td>
            </tr>

            <!-- 수정 버튼 -->
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="회원정보 수정" /> 
                    <input type="reset" value="다시 입력" onclick="location.reload()" /> 
                    <input type="button" value="뒤로 가기" onclick="window.location.href='../index.jsp';"> 
                </td>
            </tr>
        </table>
    </form>




<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="../js/member.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $('#navbar').load('/projectJSP/jsp/nav.jsp');
</script>

<script type="text/javascript" >
	window.onload = function() {
	    var gender = "<%= memberDTO.getGender() %>";  
	 	// 성별 값을 서버에서 가져옵니다.
	    if (gender === "M") {
	        document.updateForm.gender[0].checked = true; // 남성 (첫 번째 radio 버튼 선택)
	    } else if (gender === "F") {
	        document.updateForm.gender[1].checked = true; // 여성 (두 번째 radio 버튼 선택)
	    }
	 	
	 	document.updateForm.tel1.value = '<%=memberDTO.getTel1() %>';
	};

</script>
  
</body>
</html>
