<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*, java.io.*" %>
<%
    request.setCharacterEncoding("UTF-8");

    String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
    String dbUser = "hr"; 
    String dbPass = "hr";

    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String memberId = (String) session.getAttribute("memberId");

        // 디버깅 출력
        out.println("Title: " + title);
        out.println("Content: " + content);
        out.println("Member ID: " + memberId);

        if(memberId == null || memberId.trim().isEmpty()) {
            out.println("Error: Invalid Member ID.");
            return;
        }

        // 데이터베이스 연결
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

        // 포스트 삽입 SQL 작성 및 실행 (BOARD 테이블 사용)
        String sql = "INSERT INTO BOARD (SEQ, MEMBER_ID, SUBJECT, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, memberId);
        pstmt.setString(2, title);
        pstmt.setString(3, content);
        int result = pstmt.executeUpdate();

        if(result > 0) {
            response.sendRedirect("board.html"); // 성공 시 게시글 목록 페이지로 이동
        } else {
            out.println("Error: Failed to save post.");
        }
    } catch (Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        out.println("<pre>" + sw.toString() + "</pre>");
        out.println("Error: Database connection or SQL error.");
    } finally {
        if(pstmt != null) try { pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
        if(conn != null) try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
    }
%>
