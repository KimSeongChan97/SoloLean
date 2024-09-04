<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="member.dao.MemberDAO" %>
<html>
<head>
    <title>회원가입 완료</title>
</head>
<body>
<%
    // 요청의 인코딩을 UTF-8로 설정하여 한글이 깨지지 않도록 합니다.
    request.setCharacterEncoding("UTF-8");

    // 요청 파라미터를 가져옵니다.
    String id = request.getParameter("id");
    String pwd = request.getParameter("pwd");
    String repwd = request.getParameter("repwd");
    String name = request.getParameter("name");
    String gender = request.getParameter("gender"); // 성별
    String email1 = request.getParameter("email1");
    String email2 = request.getParameter("email2");
    String tel1 = request.getParameter("tel1"); // 전화번호 첫 부분
    String tel2 = request.getParameter("tel2"); // 전화번호 중간 부분
    String tel3 = request.getParameter("tel3"); // 전화번호 끝 부분
    String zipcode = request.getParameter("zipcode");
    String addr1 = request.getParameter("addr1");
    String addr2 = request.getParameter("addr2");

    // 입력값 체크
    if (id == null || id.trim().isEmpty()) {
        out.println("<script>alert('아이디를 입력해주세요'); history.back();</script>");
    } else if (pwd == null || pwd.trim().isEmpty()) {
        out.println("<script>alert('비밀번호를 입력해주세요'); history.back();</script>");
    } else if (!pwd.equals(repwd)) {
        out.println("<script>alert('비밀번호가 일치하지 않습니다'); history.back();</script>");
    } else if (name == null || name.trim().isEmpty()) {
        out.println("<script>alert('이름을 입력해주세요'); history.back();</script>");
    } else {
        // DB 저장 처리
        try {
            MemberDAO memberDAO = MemberDAO.getInstance();
            memberDAO.insertMember(id, pwd, name, gender, email1, email2, tel1, tel2, tel3, zipcode, addr1, addr2);
            out.println("<script>alert('회원가입이 완료되었습니다'); location.href='../index.jsp';</script>");
        } catch (Exception e) {
            e.printStackTrace();  // 예외 발생 시 콘솔에 출력
            out.println("<script>alert('회원가입 처리 중 오류가 발생했습니다.'); history.back();</script>");
        }
    }
%>
</body>
</html>
