<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %> <%-- XML 태그 시작 전의 공백 제거 --%>

<%
	//java 구역
	String user_id = request.getParameter("user_id");
	// 사용자가 입력한 user_id를 request 객체에서 가져옵니다.
	
	String user_password = request.getParameter("user_password");
	// 사용자가 입력한 user_password를 request 객체에서 가져옵니다.
	
	// DB 가는 예시
	// 아이디 : hong, 비밀번호: 111 ==> 로그인 성공
	// 예시로 사용된 DB 로직: 아이디가 'hong'이고 비밀번호가 '111'인 경우에만 로그인 성공입니다.
	boolean result = true;
	// 기본적으로 로그인 성공을 true로 설정합니다.
	
	String message = "안녕하세요 홍길동_님";
	// 기본적으로 로그인 성공 메시지를 설정합니다.
	
	if(!user_id.equals("hong")) {
		result = false;
		// user_id가 'hong'이 아니면 로그인 실패로 설정합니다.
		
		message = "가입되지 않은 아이디입니다.";
		// 로그인 실패 메시지를 설정합니다.
	}else if(!user_password.equals("111")) {
		result = false;
		// user_password가 '111'이 아니면 로그인 실패로 설정합니다.
		
		message = "비밀번호가 틀렸습니다..";
		// 비밀번호 오류 메시지를 설정합니다.
	}
	
%>

<%-- XML 보내기 --%>
<?xml version="1.0" encoding="UTF-8"?>
<login>
	<result><%=result%></result> <%-- 로그인 결과를 출력합니다. 위에서 설정된 result 값(true/false)을 XML로 출력합니다. --%>
	<message><%=message%></message> <%-- 로그인 메시지를 출력합니다. 위에서 설정된 message 값을 XML로 출력합니다. --%>
</login>