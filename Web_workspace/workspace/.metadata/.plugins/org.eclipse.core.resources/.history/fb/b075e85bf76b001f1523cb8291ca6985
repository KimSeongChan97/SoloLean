<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="member.bean.MemberDTO" %>
<%@ page import="member.dao.MemberDAO" %>

<%
    // 데이터
	// 요청의 인코딩을 UTF-8로 설정하여 한글이 깨지지 않도록 합니다.
    // request.setCharacterEncoding("UTF-8")는 클라이언트에서 보낸 데이터를 서버에서 UTF-8로 처리하도록 인코딩 방식을 지정하는 코드입니다.
    request.setCharacterEncoding("UTF-8");

    // 요청 파라미터를 가져옵니다.
    // 사용자가 회원가입 폼에 입력한 데이터를 서버에서 받기 위한 코드입니다. 
    // request.getParameter() 메서드를 통해 클라이언트(사용자)가 입력한 값을 각각의 변수에 저장합니다.
    String id = request.getParameter("id"); // 사용자가 입력한 ID를 가져옵니다.
    String pwd = request.getParameter("pwd"); // 사용자가 입력한 비밀번호를 가져옵니다.
    String repwd = request.getParameter("repwd"); // 비밀번호 재확인 입력 값을 가져옵니다.
    String name = request.getParameter("name"); // 사용자가 입력한 이름을 가져옵니다.
    String gender = request.getParameter("gender"); // 성별 선택 값을 가져옵니다.
    String email1 = request.getParameter("email1"); // 이메일 앞 부분 (예: user) 값을 가져옵니다.
    String email2 = request.getParameter("email2"); // 이메일 도메인 부분 (예: naver.com)을 가져옵니다.
    String tel1 = request.getParameter("tel1"); // 전화번호 첫 부분 (예: 010)을 가져옵니다.
    String tel2 = request.getParameter("tel2"); // 전화번호 중간 부분 (예: 1234)을 가져옵니다.
    String tel3 = request.getParameter("tel3"); // 전화번호 마지막 부분 (예: 5678)을 가져옵니다.
    String zipcode = request.getParameter("zipcode"); // 사용자가 입력한 우편번호를 가져옵니다.
    String addr1 = request.getParameter("addr1"); // 사용자가 입력한 기본 주소를 가져옵니다.
    String addr2 = request.getParameter("addr2"); // 사용자가 입력한 상세 주소를 가져옵니다.
	
    // MemberDTO 객체를 생성하여 회원 정보를 저장합니다.
    // MemberDTO는 회원 정보를 담는 자바 클래스입니다. 해당 객체를 통해 사용자 정보를 한 곳에서 관리할 수 있습니다.
    MemberDTO memberDTO = new MemberDTO();
    memberDTO.setName(name); // DTO 객체에 이름을 설정합니다.
    memberDTO.setId(id); // DTO 객체에 ID를 설정합니다.
    memberDTO.setPwd(pwd); // DTO 객체에 비밀번호를 설정합니다.
    memberDTO.setGender(gender); // DTO 객체에 성별 정보를 설정합니다.
    memberDTO.setEmail1(email1); // DTO 객체에 이메일 앞 부분을 설정합니다.
    memberDTO.setEmail2(email2); // DTO 객체에 이메일 도메인 부분을 설정합니다.
    memberDTO.setTel1(tel1); // DTO 객체에 전화번호 첫 부분을 설정합니다.
    memberDTO.setTel2(tel2); // DTO 객체에 전화번호 중간 부분을 설정합니다.
    memberDTO.setTel3(tel3); // DTO 객체에 전화번호 마지막 부분을 설정합니다.
    memberDTO.setZipcode(zipcode); // DTO 객체에 우편번호를 설정합니다.
    memberDTO.setAddr1(addr1); // DTO 객체에 기본 주소를 설정합니다.
    memberDTO.setAddr2(addr2); // DTO 객체에 상세 주소를 설정합니다.
    // DTO 객체에 정보를 설정하는 과정은, 이후에 DAO로 데이터를 전달할 때 필요한 형태로 데이터를 준비하는 작업입니다.
    	
    // DB
    // 데이터베이스에 회원 정보를 저장하기 위해 DAO(Data Access Object) 객체를 생성합니다.
    // MemberDAO는 데이터베이스와 연결하여 실제로 데이터를 저장하는 클래스입니다.
    MemberDAO memberDAO = MemberDAO.getInstance(); 
    // 데이터베이스에 회원 정보를 저장하는 메서드를 호출합니다.
    // memberWrite 메서드는 DTO에 담긴 회원 정보를 데이터베이스에 삽입하는 역할을 합니다.
    memberDAO.memberWrite(memberDTO);
    
%>


<html>
<head>
    <title>회원가입 완료</title> <!-- 페이지 제목을 '회원가입 완료'로 설정합니다. -->
</head>
<body>

<!-- 회원가입 완료 메시지를 가운데 정렬하여 출력합니다. -->
<h3 align="center">회원가입을 완료하였습니다.</h3>
<script type="text/javascript">
window.onload = function() {
	// 페이지가 로드되면, 회원가입이 완료되었음을 알리는 알림 창을 띄웁니다.
	alert("회원가입을 축하합니다.");
	// 사용자가 알림창을 확인한 후, 메인 페이지로 이동시킵니다.
	location.href = "../index.jsp"; // 메인 페이지로 이동합니다.
};
</script>

</body>
</html>
