<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.io.*" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");

    String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
    String dbUser = "hr";
    String dbPass = "hr";
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    
    String postId = request.getParameter("postId");  // 게시글 ID
    String content = request.getParameter("content");  // 댓글 내용
    String memberId = (String)session.getAttribute("memberId");  // 세션에서 로그인한 사용자 ID 가져오기

    if(memberId == null) {
        response.sendRedirect("login.html"); // 로그인되지 않은 경우 로그인 페이지로 이동
        return;
    }

    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

        // 댓글 데이터베이스에 저장
        String sql = "INSERT INTO COMMENTS (COMMENT_ID, POST_ID, MEMBER_ID, CONTENT, LOGTIME) VALUES (COMMENTS_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, postId);
        pstmt.setString(2, memberId);
        pstmt.setString(3, content);
        int result = pstmt.executeUpdate();

        if(result > 0) {
            response.sendRedirect("view_post.jsp?seq=" + postId);  // 성공 시 해당 게시글로 리다이렉트
        } else {
            out.println("Error: Failed to add the comment.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try { if (pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
        try { if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
    }
%>