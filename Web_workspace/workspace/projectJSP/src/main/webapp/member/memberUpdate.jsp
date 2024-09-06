<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="member.dao.MemberDAO" %>    
<%@page import="member.bean.MemberDTO" %>   

<%
	
	request.setCharacterEncoding("UTF-8");
    // POST 요청으로 넘어온 데이터 처리
    String id = request.getParameter("id");
    String name = request.getParameter("name");
    String pwd = request.getParameter("pwd");
    String gender = request.getParameter("gender");
    String email1 = request.getParameter("email1");
    String email2 = request.getParameter("email2");
    String tel1 = request.getParameter("tel1");
    String tel2 = request.getParameter("tel2");
    String tel3 = request.getParameter("tel3");
    String zipcode = request.getParameter("zipcode");
    String addr1 = request.getParameter("addr1");
    String addr2 = request.getParameter("addr2");

    // MemberDTO 객체에 폼 데이터 담기
    MemberDTO memberDTO = new MemberDTO();
    memberDTO.setId(id);
    memberDTO.setName(name);
    memberDTO.setPwd(pwd);
    memberDTO.setGender(gender);
    memberDTO.setEmail1(email1);
    memberDTO.setEmail2(email2);
    memberDTO.setTel1(tel1);
    memberDTO.setTel2(tel2);
    memberDTO.setTel3(tel3);
    memberDTO.setZipcode(zipcode);
    memberDTO.setAddr1(addr1);
    memberDTO.setAddr2(addr2);

    // 데이터베이스 업데이트
    MemberDAO memberDAO = MemberDAO.getInstance();
    MemberDTO updatedMember = memberDAO.updateMember(memberDTO);

    if (updatedMember != null) {  // 업데이트 성공 시
        // 로그아웃 처리: 세션을 만료시키고, index.jsp로 이동
        session.invalidate(); // 세션 만료

        // JavaScript로 성공 메시지 및 리다이렉트 처리
%>
        <script>
            alert("회원정보 수정이 완료되었습니다. 다시 로그인 해주세요.");
            location.href = "/projectJSP/index.jsp"; // index.jsp로 이동
        </script>
<%
    } else {  // 업데이트 실패 시
%>
        <script>
            alert("회원정보 수정에 실패하였습니다. 다시 시도해주세요.");
            history.back(); // 이전 페이지로 돌아가기
        </script>
<%
    }
%>
