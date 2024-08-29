<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%
    // 데이터베이스 연결 정보
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String user = "HR";
    String password = "hr";

    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
        // 데이터베이스 연결
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(url, user, password);

        // 폼에서 전송된 데이터 받아오기
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String author = "test@naver.com";  // 실제 구현에서는 세션에서 가져와야 합니다.

        // SQL 쿼리 작성
        String sql = "INSERT INTO POSTS (POST_ID, TITLE, CONTENT, AUTHOR, CREATED_AT, VIEWS) VALUES (POSTS_SEQ.NEXTVAL, ?, ?, ?, SYSDATE, 0)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, title);
        pstmt.setString(2, content);
        pstmt.setString(3, author);

        // 쿼리 실행
        pstmt.executeUpdate();

        // 성공적으로 저장된 후 board.html로 리다이렉트
        response.sendRedirect("board.html");

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // 리소스 해제
        try { if (pstmt != null) pstmt.close(); } catch (SQLException e) { }
        try { if (conn != null) conn.close(); } catch (SQLException e) { }
    }
%>