<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %> <%-- XML 태그 시작 전의 공백 제거 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="result" value="true" />
<%-- "result"라는 변수에 true 값을 설정합니다. 로그인 성공을 기본 값으로 설정합니다. --%>
<c:set var="message" value="안녕하세요 홍길동_님" />
<%-- "message"라는 변수에 기본 메시지를 설정합니다. --%>

<c:if  test="${param.user_id != 'hong' }">
	<c:set var="result" value="false" />
	<%-- 입력된 user_id가 'hong'이 아닌 경우, "result"를 false로 설정하여 로그인 실패로 표시합니다. --%>
	<c:set var="message" value="가입되지 않은 아이디입니다." />
	<%-- 로그인 실패 시 출력할 메시지를 설정합니다. --%>
</c:if>

<c:if  test="${param.user_password != '111' }">
	<c:set var="result" value="false" />
	<%-- 입력된 비밀번호가 '111'이 아닌 경우, "result"를 false로 설정하여 로그인 실패로 표시합니다. --%>
	<c:set var="message" value="비밀번호가 틀렸습니다.." />
	<%-- 비밀번호가 틀렸을 때 출력할 메시지를 설정합니다. --%>
</c:if>

<%-- XML 보내기 --%>
<?xml version="1.0" encoding="UTF-8"?>
<login>
	<result>${result }</result> <%-- 위에서 설정한 "result" 값을 XML의 <result> 태그 안에 출력합니다. --%>
	<message>${message }</message> <%-- 위에서 설정한 "message" 값을 XML의 <message> 태그 안에 출력합니다. --%>
</login>