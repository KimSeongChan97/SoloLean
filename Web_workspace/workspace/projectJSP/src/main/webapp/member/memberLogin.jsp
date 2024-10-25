<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder"%> <!-- URL 인코딩을 위한 클래스 임포트 -->
<%@ page import="member.dao.MemberDAO" %> <!-- MemberDAO 클래스 임포트 -->
<%@ page import="member.bean.MemberDTO" %> <!-- MemberDTO 클래스 임포트 -->
<%@ page import="javax.servlet.http.Cookie" %> <!-- 쿠키 사용을 위한 클래스 임포트 -->

<%
    // 데이터
    // 클라이언트에서 전송된 'id'와 'pwd'라는 이름의 파라미터를 가져옵니다.
    // request.getParameter() 메서드를 사용하여 클라이언트가 입력한 아이디(id)와 비밀번호(pwd)를 문자열로 받습니다.
    // 클라이언트에서 전송된 값은 HTML 폼의 input 필드에서 전송된 값입니다.
    String id = request.getParameter("id");  // 클라이언트로부터 전송된 id 값을 받아 저장
    String pwd = request.getParameter("pwd");  // 클라이언트로부터 전송된 비밀번호 값을 받아 저장
	
    
    // DB
    // MemberDAO 인스턴스를 싱글톤 패턴으로 가져옵니다.
    // MemberDAO는 DB와의 연결을 처리하는 클래스이며, 이 인스턴스를 통해 DB 쿼리 및 데이터를 가져옵니다.
    // getInstance() 메서드를 통해 DAO의 단일 인스턴스를 가져옵니다.
    // 싱글톤 패턴을 사용함으로써 메모리 효율성을 높이고, 여러 객체가 동시에 같은 DB 자원에 접근할 때의 문제를 방지합니다.
    MemberDAO memberDAO = MemberDAO.getInstance();

    // 로그인 로직
    // memberLogin() 메서드를 호출하여, 데이터베이스에서 입력된 아이디와 비밀번호로 로그인 여부를 확인합니다.
    // 메서드의 결과로 이름(name)이 반환됩니다. 만약 로그인 실패 시 name은 null 값을 반환하게 됩니다.
    // 이 메서드는 사용자가 입력한 id와 pwd를 매개변수로 받아 DB에 조회하고, 로그인 성공 시 해당 사용자의 이름을 반환합니다.
    //String name = memberDAO.memberLogin(id, pwd);
    
    // 로그인 로직 (배열로 반환된 값을 각각 처리)
    //MemberDTO memberDTO = memberDAO.memberLogin(id, pwd);
    
    String[] loginInfo = memberDAO.memberLogin(id, pwd);  // [0] = name, [1] = email1, [2] = email2
    String name = loginInfo[0];
    String email1 = loginInfo[1];
    String email2 = loginInfo[2];
    
 	// 디버깅용 로그
    System.out.println("디버깅 로그 - 로그인 시도");
    System.out.println("입력된 ID: " + id);
    System.out.println("입력된 비밀번호: " + pwd);
    System.out.println("로그인 결과 회원 이름: " + name);
    System.out.println("로그인 결과 이메일 앞부분: " + email1);
    System.out.println("로그인 결과 이메일 뒷부분: " + email2);
   
%>

<% if(name == null) { 
    // 로그인 실패 시 처리
    // 사용자가 입력한 id 또는 pwd가 일치하지 않으면, loginFail.jsp로 리다이렉트합니다.
    // 사용자가 실패 페이지로 이동하여 다시 로그인 시도를 할 수 있게 합니다.
    response.sendRedirect("loginFail.jsp");
            
 } else { 
    // 로그인 성공 시 처리
    
    /*
    // 기존에는 URL 파라미터로 데이터를 전송했으나, 중요한 데이터를 URL에 노출시키지 않기 위해 쿠키를 사용합니다.   
    // 쿠키 생성 및 저장 (name)
    // Cookie 객체를 사용하여 쿠키를 생성합니다. 쿠키는 key-value 형식으로 저장되며, 여기서 key는 "memName", value는 로그인한 사용자의 이름입니다.
    Cookie cookie = new Cookie("memName", name);  // "memName"이라는 이름의 쿠키 생성 (value: 사용자의 이름)
    cookie.setMaxAge(3*10*60);  // 쿠키의 유효 기간을 30분으로 설정 (3 * 10 * 60 = 1800초)
    
    response.addCookie(cookie);  // 쿠키를 클라이언트의 웹 브라우저에 저장합니다.
    
    // 쿠키 생성 및 저장 (id)
    // 마찬가지로 아이디(id)도 쿠키로 생성하여 저장합니다. 여기서 key는 "memId", value는 사용자의 아이디입니다.
    Cookie cookie2 = new Cookie("memId", id);  // "memId"라는 이름의 쿠키 생성 (value: 사용자의 아이디)
    cookie2.setMaxAge(3*10*60);  // 쿠키의 유효 기간을 30분으로 설정
    
    response.addCookie(cookie2);  // 쿠키를 클라이언트의 웹 브라우저에 저장합니다.
    // --------------------------------------------------------------------
    */
    
    // 세션 처리
    // 세션을 사용하여 사용자의 상태를 서버에서 유지할 수 있습니다. 세션은 브라우저를 종료해도 일정 시간 유지됩니다.
    // HttpSession session = request.getSession(); // 세션 생성은 이미 내장 객체이므로 안해도 됨 
    session.setAttribute("memName", name);  // 로그인한 사용자의 이름을 세션에 저장
    session.setAttribute("memId", id);  // 로그인한 사용자의 아이디를 세션에 저장
    session.setAttribute("memEmail1", email1);  // DAO에서 가져온 값 사용
    session.setAttribute("memEmail2", email2);  // DAO에서 가져온 값 사용
	
    // session.setAttribute("memName", memberDTO.getName());
 	// session.setAttribute("memName", id);
 	// session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2());
    // session.setAttribute("memberDTO", memberDTO);
    
    
    // 로그인 성공 후 페이지 이동
    // 로그인 성공 시, 로그인 성공 페이지인 loginOk.jsp로 리다이렉트합니다.
    response.sendRedirect("loginOk.jsp");
} %>