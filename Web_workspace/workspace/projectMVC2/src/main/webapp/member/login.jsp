<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="member.bean.MemberDTO"%>
<%@ page import="member.dao.MemberDAO"%>

<%
	//데이터
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	//DB
	MemberDAO memberDAO = MemberDAO.getInstance();
	MemberDTO memberDTO = memberDAO.login(id, pwd);
%>

<% if(memberDTO == null) {
	//페이지 이동
	response.sendRedirect("loginFail.jsp");
	
}else{
	//중요한 데이터를 주소표시줄에 실어서 보내지 말자
	//response.sendRedirect("loginOk.jsp?name=" + URLEncoder.encode(name, "UTF-8") + "&id=" + id);
	
	//쿠키
	/*
	Cookie cookie = new Cookie("memName", name); //쿠키 생성
	cookie.setMaxAge(3*10*60); //초 단위 - 30분
	response.addCookie(cookie); //클라이언트에 저장
	
	Cookie cookie2 = new Cookie("memId", id); //쿠키 생성
	cookie2.setMaxAge(3*10*60); //초 단위
	response.addCookie(cookie2); //클라이언트에 저장
	*/
	
	//세션
	//HttpSession session = request.getSession(); //세션 생성
	
	session.setAttribute("memName", memberDTO.getName());
	session.setAttribute("memId", id);
	session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2());
	
	session.setAttribute("memDTO", memberDTO);
	
	response.sendRedirect("loginOk.jsp");
} %>













