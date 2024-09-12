<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    String apple = (String)request.getAttribute("apple");
    // forward로 이동되었기 때문에 request에 저장된 "apple" 속성을 가져옵니다.
    // 여기서 "사과"라는 값이 저장되어 있으므로, 이를 문자열로 캐스팅하여 가져옵니다.
%>    

결과는 = <%=apple %>
<!-- 
    JSP 표현식으로 request에서 가져온 "apple" 값을 출력합니다.
    화면에 "결과는 = 사과"가 출력됩니다.
 -->