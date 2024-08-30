<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*, java.io.*" %>
<%
    request.setCharacterEncoding("UTF-8");

    String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
    String dbUser = "hr"; 
    String dbPass = "hr";

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String memberEmail = (String) session.getAttribute("email");

        if(memberEmail == null || memberEmail.trim().isEmpty()) {
            out.println("Error: Invalid EMAIL.");
            return;
        }

        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

        // EMAIL로 MEMBER_ID를 조회
        String memberId = null;
        String userName = null;
        String userPassword = null;

        String memberCheckSQL = "SELECT MEMBER_ID, NAME, PASSWORD FROM MEMBER WHERE EMAIL = ?";
        pstmt = conn.prepareStatement(memberCheckSQL);
        pstmt.setString(1, memberEmail);
        rs = pstmt.executeQuery();

        if(rs.next()) {
            memberId = rs.getString("MEMBER_ID");
            userName = rs.getString("NAME");
            userPassword = rs.getString("PASSWORD");

            // 세션 및 sessionStorage에 사용자 정보 저장
            session.setAttribute("memberId", memberId);
            session.setAttribute("userName", userName);
            session.setAttribute("userEmail", memberEmail);
            session.setAttribute("userPassword", userPassword);

            out.println("<script>");
            out.println("sessionStorage.setItem('memberId', '" + memberId + "');");
            out.println("sessionStorage.setItem('userName', '" + userName + "');");
            out.println("sessionStorage.setItem('userEmail', '" + memberEmail + "');");
            out.println("sessionStorage.setItem('userPassword', '" + userPassword + "');");
            out.println("</script>");

            // 게시글 삽입
            String sql = "INSERT INTO BOARD (SEQ, MEMBER_ID, SUBJECT, CONTENT, LOGTIME) VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memberId);
            pstmt.setString(2, title);
            pstmt.setString(3, content);
            int result = pstmt.executeUpdate();

            if(result > 0) {
                response.sendRedirect("board.html");
            } else {
                out.println("Error: Failed to save the post.");
            }
        } else {
            out.println("Error: Invalid EMAIL.");
        }
    } catch (Exception e) {
        out.println("Error: " + e.getMessage());
        e.printStackTrace();
    } finally {
        try { if (rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
        try { if (pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
        try { if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
    }
%>
