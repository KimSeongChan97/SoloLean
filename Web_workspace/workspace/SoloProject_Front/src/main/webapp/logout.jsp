<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    session.invalidate(); // 세션 무효화
    response.sendRedirect("index.html"); // 메인 페이지로 리다이렉트
%>
