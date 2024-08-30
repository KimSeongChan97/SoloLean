<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String user = (String) session.getAttribute("user");
    if (user != null) {
%>
    <h2>My Page</h2>
    <p>이메일: <%= user %></p>
<%
    } else {
        response.sendRedirect("login.html");
    }
%>
