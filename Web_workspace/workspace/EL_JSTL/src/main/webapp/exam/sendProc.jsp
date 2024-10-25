<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
    request.setAttribute("apple", "사과");
    // request scope에 "apple"이라는 속성으로 "사과" 값을 저장하지만,
    // sendRedirect는 새로운 요청을 발생시키므로, 이 데이터는 이후 페이지에서 사용할 수 없습니다.
%>

<%
    response.sendRedirect("sendResult.jsp");
    // 클라이언트 측에서 sendResult.jsp로 리다이렉트됩니다.
    // 새로운 요청이 발생하기 때문에 request에 저장된 데이터는 전달되지 않습니다.
%>