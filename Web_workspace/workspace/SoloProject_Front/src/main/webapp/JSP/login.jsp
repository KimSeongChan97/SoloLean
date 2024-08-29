<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    // 사용자 검증 로직
    if (email.equals("test@example.com") && password.equals("password")) {
        session.setAttribute("user", email);
        response.sendRedirect("index.html");
    } else {
        out.println("로그인 실패");
    }
%>
