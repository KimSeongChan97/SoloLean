<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="java.util.UUID, java.sql.*, java.io.*" %>
<%
    request.setCharacterEncoding("UTF-8");

    String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
    String dbUser = "hr"; 
    String dbPass = "hr";

    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
        // UUID를 사용하여 MEMBER_ID 생성
        String memberId = UUID.randomUUID().toString(); // MEMBER_ID를 UUID로 자동 생성
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // 이름이 NULL이거나 비어있는지 확인
        if(name == null || name.trim().isEmpty()) {
            out.println("Error: Name cannot be null or empty.");
            return;
        }

        // 이메일 형식 유효성 검사 추가
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!email.matches(emailPattern)) {
            out.println("Error: Invalid EMAIL.");
            return;
        }

        // 데이터베이스 연결
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

        // MEMBER 테이블에 사용자 정보 삽입
        String sql = "INSERT INTO MEMBER (MEMBER_ID, NAME, EMAIL, PASSWORD) VALUES (?, ?, ?, ?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, memberId);
        pstmt.setString(2, name);
        pstmt.setString(3, email);
        pstmt.setString(4, password);
        int result = pstmt.executeUpdate();

        if(result > 0) {
            response.sendRedirect("login.html"); // 성공 시 로그인 페이지로 이동
        } else {
            out.println("Error: Failed to register.");
        }
    } catch (Exception e) {
        e.printStackTrace();
        out.println("Error: Database connection or SQL error.");
    } finally {
        if(pstmt != null) try { pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
        if(conn != null) try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
    }
%>
