<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.io.*, java.util.*" %>
<%
    // 데이터베이스 연결 설정
    String dbURL = "jdbc:oracle:thin:@localhost:1521:xe"; // Oracle 데이터베이스 URL
    String dbUser = "hr";  // 데이터베이스 사용자 이름
    String dbPass = "hr";  // 데이터베이스 사용자 비밀번호

    Connection conn = null;  // 데이터베이스 연결 객체
    PreparedStatement pstmt = null;  // SQL 쿼리 실행을 위한 PreparedStatement 객체
    ResultSet rs = null;  // 쿼리 실행 결과를 저장하기 위한 ResultSet 객체

    // 클라이언트로부터 전달받은 이메일과 비밀번호를 request 객체에서 가져옵니다.
    String email = request.getParameter("email"); // 사용자가 입력한 이메일 주소
    String password = request.getParameter("password"); // 사용자가 입력한 비밀번호

    try {
        // Oracle JDBC 드라이버를 메모리에 로드합니다.
        Class.forName("oracle.jdbc.driver.OracleDriver");
        // 설정된 URL, 사용자 이름, 비밀번호로 데이터베이스에 연결합니다.
        conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

        // SQL 쿼리를 작성하여 이메일과 비밀번호가 일치하는 사용자를 조회합니다.
        String sql = "SELECT MEMBER_ID, NAME, PASSWORD FROM MEMBER WHERE EMAIL = ? AND PASSWORD = ?";
        pstmt = conn.prepareStatement(sql); // SQL 쿼리를 실행할 PreparedStatement 객체를 생성합니다.
        pstmt.setString(1, email); // 첫 번째 ? 자리에 사용자가 입력한 이메일을 바인딩합니다.
        pstmt.setString(2, password); // 두 번째 ? 자리에 사용자가 입력한 비밀번호를 바인딩합니다.
        rs = pstmt.executeQuery(); // 쿼리를 실행하고 결과를 ResultSet 객체에 저장합니다.

        // 쿼리 결과가 존재하면(즉, 이메일과 비밀번호가 일치하는 사용자가 있으면)
        if (rs.next()) {
            // 데이터베이스에서 가져온 회원 ID, 이름, 비밀번호를 변수에 저장합니다.
            String memberId = rs.getString("MEMBER_ID"); // 회원 ID
            String userName = rs.getString("NAME"); // 사용자 이름
            String userPassword = rs.getString("PASSWORD"); // 사용자 비밀번호

            // 세션에 사용자 정보를 저장하여 로그인 상태를 유지합니다.
            session.setAttribute("memberId", memberId); // 세션에 회원 ID 저장
            session.setAttribute("userName", userName); // 세션에 사용자 이름 저장
            session.setAttribute("userEmail", email); // 세션에 사용자 이메일 저장
            session.setAttribute("userPassword", userPassword); // 세션에 사용자 비밀번호 저장

            // 자바스크립트를 사용하여 세션 정보를 sessionStorage에 저장합니다.
            out.println("<script>");
            out.println("sessionStorage.setItem('memberId', '" + memberId + "');");
            out.println("sessionStorage.setItem('userName', '" + userName + "');");
            out.println("sessionStorage.setItem('userEmail', '" + email + "');");
            out.println("sessionStorage.setItem('userPassword', '" + userPassword + "');");
            // 로그인 성공 후 메인 페이지로 리다이렉트합니다.
            out.println("location.href='index.html';"); // 로그인 후 이동할 페이지
            out.println("</script>");
        } else {
            // 로그인 실패 시 경고 메시지를 출력하고 로그인 페이지로 이동합니다.
            out.println("<script>");
            out.println("alert('로그인 실패: 이메일 또는 비밀번호를 확인하세요.');");
            out.println("location.href='login.html';"); // 로그인 페이지로 리다이렉트
            out.println("</script>");
        }
    } catch (Exception e) {
        // 예외 발생 시 예외 정보를 출력합니다.
        e.printStackTrace();
    } finally {
        // 사용한 리소스들을 해제합니다.
        try { if (rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
        try { if (pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
        try { if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
    }
%>
