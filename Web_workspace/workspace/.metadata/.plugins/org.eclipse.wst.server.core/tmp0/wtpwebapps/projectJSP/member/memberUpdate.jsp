<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="member.bean.MemberDTO" %>
<%@page import="member.dao.MemberDAO" %>    

<%
	// 한글 인코딩
	// 클라이언트로부터 전송된 데이터를 UTF-8로 인코딩하여 한글 처리를 올바르게 하기 위한 설정입니다.
	request.setCharacterEncoding("UTF-8");
	
    // POST 요청으로 넘어온 데이터 처리
    // 폼에서 사용자가 입력한 데이터를 받아오는 부분입니다. 각 필드는 사용자로부터 전달된 데이터를 의미합니다.
    String name = request.getParameter("name"); // 사용자가 입력한 이름을 가져옵니다.
    String id = request.getParameter("id"); // 사용자가 입력한 ID를 가져옵니다.
    String pwd = request.getParameter("pwd"); // 사용자가 입력한 비밀번호를 가져옵니다. 
    String gender = request.getParameter("gender"); // 성별 선택 값을 가져옵니다.
    String email1 = request.getParameter("email1"); // 이메일 앞 부분 (예: user) 값을 가져옵니다.
    String email2 = request.getParameter("email2"); // 이메일 도메인 부분 (예: naver.com)을 가져옵니다.
    String tel1 = request.getParameter("tel1"); // 전화번호 첫 부분 (예: 010)을 가져옵니다.
    String tel2 = request.getParameter("tel2"); // 전화번호 중간 부분 (예: 1234)을 가져옵니다.
    String tel3 = request.getParameter("tel3"); // 전화번호 마지막 부분 (예: 5678)을 가져옵니다.
    String zipcode = request.getParameter("zipcode"); // 사용자가 입력한 우편번호를 가져옵니다.
    String addr1 = request.getParameter("addr1"); // 사용자가 입력한 기본 주소를 가져옵니다.
    String addr2 = request.getParameter("addr2"); // 사용자가 입력한 상세 주소를 가져옵니다.

    // MemberDTO 객체에 폼 데이터 담기
    // 추가 주석: DTO(Data Transfer Object)는 데이터를 운반하기 위한 객체입니다. 
    // MemberDTO는 회원 정보를 저장하는 객체로, 사용자로부터 입력받은 데이터를 담아 전달하는 역할을 합니다.
    MemberDTO memberDTO = new MemberDTO();
    memberDTO.setName(name); // 입력받은 이름을 memberDTO 객체에 저장
    memberDTO.setId(id); // 입력받은 ID를 memberDTO 객체에 저장
    memberDTO.setPwd(pwd); // 입력받은 비밀번호를 memberDTO 객체에 저장
    memberDTO.setGender(gender); // 선택된 성별을 memberDTO 객체에 저장
    memberDTO.setEmail1(email1); // 이메일 앞 부분을 memberDTO 객체에 저장
    memberDTO.setEmail2(email2); // 이메일 도메인 부분을 memberDTO 객체에 저장
    memberDTO.setTel1(tel1); // 전화번호 첫 번째 부분을 memberDTO 객체에 저장
    memberDTO.setTel2(tel2); // 전화번호 두 번째 부분을 memberDTO 객체에 저장
    memberDTO.setTel3(tel3); // 전화번호 세 번째 부분을 memberDTO 객체에 저장
    memberDTO.setZipcode(zipcode); // 우편번호를 memberDTO 객체에 저장
    memberDTO.setAddr1(addr1); // 기본 주소를 memberDTO 객체에 저장
    memberDTO.setAddr2(addr2); // 상세 주소를 memberDTO 객체에 저장

    // 데이터베이스 업데이트
    // 추가 주석: DAO(Data Access Object)는 데이터베이스와의 상호작용을 처리하는 객체입니다. 
    // MemberDAO는 회원 정보를 DB에 업데이트하는 작업을 담당하며, 이를 통해 데이터가 실제로 DB에 저장됩니다.
    // getInstance() 메서드를 통해 싱글톤 패턴으로 생성된 DAO 인스턴스를 가져옵니다.
    MemberDAO memberDAO = MemberDAO.getInstance();
    memberDAO.updateMember(memberDTO); // MemberDTO에 담긴 데이터를 DB에 업데이트합니다.
%>
