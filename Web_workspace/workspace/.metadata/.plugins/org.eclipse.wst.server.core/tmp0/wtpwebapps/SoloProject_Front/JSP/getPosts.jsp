<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%
    // 데이터베이스 연결 정보
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String user = "HR";
    String password = "hr";

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        // 데이터베이스 연결
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(url, user, password);

        // SQL 쿼리 작성
        String sql = "SELECT POST_ID, TITLE, AUTHOR, TO_CHAR(CREATED_AT, 'YYYY-MM-DD') AS CREATED_AT, VIEWS FROM POSTS ORDER BY POST_ID DESC";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);

        // 결과를 HTML로 출력
        while (rs.next()) {
            int postId = rs.getInt("POST_ID");
            String title = rs.getString("TITLE");
            String author = rs.getString("AUTHOR");
            String createdAt = rs.getString("CREATED_AT");
            int views = rs.getInt("VIEWS");

            out.println("<tr>");
            out.println("<th scope='row'>" + postId + "</th>");
            out.println("<td>" + title + "</td>");
            out.println("<td>" + author + "</td>");
            out.println("<td>" + createdAt + "</td>");
            out.println("<td>" + views + "</td>");
            out.println("<td><a href='edit_post.jsp?postId=" + postId + "' class='btn btn-sm btn-warning'>수정</a> <a href='delete_post.jsp?postId=" + postId + "' class='btn btn-sm btn-danger'>삭제</a></td>");
            out.println("</tr>");
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // 리소스 해제
        try { if (rs != null) rs.close(); } catch (SQLException e) { }
        try { if (stmt != null) stmt.close(); } catch (SQLException e) { }
        try { if (conn != null) conn.close(); } catch (SQLException e) { }
    }
%>