<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%
    // 클라이언트로부터 전달받은 이메일과 비밀번호를 request 객체에서 가져옵니다.
    String email = request.getParameter("email"); // 사용자가 입력한 이메일 주소
    String password = request.getParameter("password"); // 사용자가 입력한 비밀번호

    // 사용자 검증 로직
    // 하드코딩된 이메일과 비밀번호를 사용하여 사용자를 검증합니다.
    // 실제 애플리케이션에서는 데이터베이스나 다른 인증 시스템을 통해 사용자 정보를 확인해야 합니다.
    if (email.equals("test@example.com") && password.equals("password")) {
        // 입력된 이메일과 비밀번호가 일치하는 경우, 세션에 사용자 정보를 저장합니다.
        session.setAttribute("user", email); // 세션에 이메일 정보를 user라는 이름으로 저장
        // 로그인이 성공하면 마이페잊.html 페이지로 리다이렉트합니다.
        response.sendRedirect("MyPage.html");
    } else {
        // 입력된 이메일이나 비밀번호가 일치하지 않는 경우, 로그인 실패 메시지를 출력합니다.
        out.println("로그인 실패"); // 브라우저에 "로그인 실패" 메시지 출력
    }
%>
