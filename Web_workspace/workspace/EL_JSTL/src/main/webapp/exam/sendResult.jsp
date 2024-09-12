<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%
    String apple = (String)request.getAttribute("apple");
    // sendRedirect를 사용했기 때문에 request의 데이터는 전달되지 않으므로,
    // 이 변수는 null을 반환하게 됩니다.
%>    

결과는 = <%=apple %>
<!-- 
    request에 "apple" 속성이 없기 때문에 "결과는 = null"이 출력됩니다.
    sendRedirect는 새로운 요청을 보내기 때문에 이전 요청의 데이터는 더 이상 사용할 수 없습니다.
 -->