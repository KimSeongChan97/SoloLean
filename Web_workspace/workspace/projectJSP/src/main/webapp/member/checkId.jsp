<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.dao.MemberDAO" %>
    
<%
    // 클라이언트가 입력한 id 값을 가져옴
    // 사용자가 입력한 id를 파라미터로 가져옴. 이때 getParameter() 메서드를 사용하여 폼 데이터에서 "id" 값을 추출합니다.
    String id = request.getParameter("id");
	System.out.println("Received ID: " + id); // 받은 id를 콘솔에 출력해 디버깅에 활용

    // MemberDAO 객체 생성 및 DB 연결 (싱글톤 패턴을 사용한 경우)
    // getInstance()를 통해 싱글톤으로 만들어진 MemberDAO 객체를 가져옵니다. 이는 DB와의 연결을 위해 사용됩니다.
    MemberDAO memberDAO = MemberDAO.getInstance(); // 싱글톤 객체 가져오기

    // id 중복 여부 확인 (true: 중복됨, false: 사용 가능)
    // idExistId 메서드를 사용하여 해당 id가 데이터베이스에 있는지 확인합니다. true이면 중복된 ID, false이면 사용 가능한 ID입니다.
    boolean exist = memberDAO.idExistId(id); // idExist 메서드는 해당 id가 DB에 있는지 확인
%>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID 중복체크</title>

</head>
<body>

<%
    // 존재 여부에 따른 메시지 출력
    // id 중복 여부에 따라 다른 메시지를 출력합니다.
    if (exist) { // id가 이미 존재하는 경우
%>
    <p><%=id %> 은(는) 이미 사용 중인 아이디입니다. 다른 아이디를 입력하세요.</p>
    <!-- 중복된 아이디라는 메시지를 사용자에게 보여줍니다. -->
    <br><br>
    <form action="checkId.jsp"> <!-- 사용자가 다시 ID를 입력할 수 있도록 폼을 제공 -->
    아이디 입력 <input type="text" name="id" /> <!-- id 입력 필드 -->
    <input type="submit" value="중복체크" /> <!-- 다시 중복 체크를 할 수 있는 버튼 -->
    </form>
<% 
    } else { // id가 사용 가능한 경우
%>
    <%=id %> 은(는) 사용 가능한 아이디입니다. 계속 진행해주세요.
    <!-- 사용 가능한 아이디라는 메시지를 사용자에게 보여줍니다. -->
    <br><br>
    <input type="button" value="사용하기" onclick="checkIdClose('<%=id %>')"/> 
    <!-- 사용자가 해당 ID를 사용하기로 결정하면 '사용하기' 버튼을 클릭하고, checkIdClose() 함수를 호출합니다. -->
<% 
    } 
%>

<!-- JavaScript 함수 정의 -->
<script type="text/javascript">
function checkIdClose(id){
	// 부모 창의 id 입력 필드에 선택된 id 값을 설정함
	// opener는 팝업 창을 열었던 부모 창을 의미하며, 부모 창의 특정 필드에 접근할 수 있습니다.
	opener.document.getElementById("id").value = id;
	opener.document.getElementById("check").value = id;
    // 팝업 창을 닫습니다.
	window.close();
    
    // 부모 창의 비밀번호 입력 필드로 포커스를 이동시킴
	opener.document.getElementById("pwd").focus();
};
</script>

</body>
</html>
