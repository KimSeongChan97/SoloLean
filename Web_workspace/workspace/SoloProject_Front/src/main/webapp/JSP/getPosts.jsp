<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.io.*" %>
<%
    String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
    String dbUser = "hr";
    String dbPass = "hr";

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

        // 게시글 목록을 가져오는 SQL 쿼리에서 작성자의 이름과 조회수를 가져오도록 수정
        String sql = "SELECT B.SEQ, B.SUBJECT, M.NAME AS WRITER, B.LOGTIME, B.VIEWS FROM BOARD B JOIN MEMBER M ON B.MEMBER_ID = M.MEMBER_ID ORDER BY B.SEQ DESC";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();

        while (rs.next()) {
            int seq = rs.getInt("SEQ");
            String subject = rs.getString("SUBJECT");
            String writer = rs.getString("WRITER"); // 작성자 이름을 가져옴
            String logtime = rs.getString("LOGTIME");
            int views = rs.getInt("VIEWS");  // 조회수를 가져옴

            out.println("<tr>");
            out.println("<td>" + seq + "</td>");
            out.println("<td>" + subject + "</td>");
            out.println("<td>" + writer + "</td>"); // 작성자 이름 출력
            out.println("<td>" + logtime + "</td>");
            out.println("<td>" + views + "</td>"); // 조회수 출력
            out.println("<td><a href='JSP/view_post.jsp?seq=" + seq + "'>View</a></td>");
            out.println("</tr>");
        }
    } catch (Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);  // 예외 정보를 StringWriter에 출력
        out.println("<pre>" + sw.toString() + "</pre>");  // 예외 정보를 브라우저에 출력
    } finally {
        try { if (rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
        try { if (pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
        try { if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
    }
%>
