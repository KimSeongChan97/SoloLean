<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
    String title = request.getParameter("title");
    String content = request.getParameter("content");
    String author = (String) session.getAttribute("user");

    if (author == null) {
        response.sendRedirect("login.html");
    } else {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Oracle JDBC 드라이버 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            // 데이터베이스 연결
            String dbURL = "jdbc:oracle:thin:@localhost:1521:XE";
            String dbUser = "hr";
            String dbPass = "hr";
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

            // SQL 쿼리 실행
            String sql = "INSERT INTO posts (title, content, author) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setString(3, author);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                response.sendRedirect("board.html");
            } else {
                out.println("글 등록에 실패했습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("오류가 발생했습니다: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
%>
