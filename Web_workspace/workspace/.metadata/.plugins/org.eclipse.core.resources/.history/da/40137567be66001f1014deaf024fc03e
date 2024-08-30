<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.io.*, java.util.*" %>
<%
    String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
    String dbUser = "hr";
    String dbPass = "hr";

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String email = request.getParameter("email");
    String password = request.getParameter("password");

    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

        String sql = "SELECT MEMBER_ID, NAME FROM MEMBER WHERE EMAIL = ? AND PASSWORD = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, email);
        pstmt.setString(2, password);
        rs = pstmt.executeQuery();

        if (rs.next()) {
            String memberId = rs.getString("MEMBER_ID");
            String userName = rs.getString("NAME");

            // 세션에 사용자 정보 저장
            session.setAttribute("memberId", memberId);
            session.setAttribute("userName", userName);
            session.setAttribute("userEmail", email);

            // 자바스크립트를 이용해 세션 정보를 sessionStorage에 저장
            out.println("<script>");
            out.println("sessionStorage.setItem('memberId', '" + memberId + "');");
            out.println("sessionStorage.setItem('userName', '" + userName + "');");
            out.println("sessionStorage.setItem('userEmail', '" + email + "');");
            out.println("location.href='index.html';"); // 로그인 후 이동할 페이지
            out.println("</script>");
        } else {
            out.println("<script>");
            out.println("alert('로그인 실패: 이메일 또는 비밀번호를 확인하세요.');");
            out.println("location.href='login.html';");
            out.println("</script>");
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try { if (rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
        try { if (pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
        try { if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
    }
%>
