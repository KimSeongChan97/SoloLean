<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.io.*, java.util.*" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 보기</title>
    <link rel="stylesheet" href="../css/style.css">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <!-- 네비게이션 바를 동적으로 로드할 위치 -->
    <div id="navbar-placeholder"></div>
    <script>
        // 네비게이션 바를 외부 파일에서 동적으로 로드
        fetch('/SoloProject_Front/navbar.html')
            .then(response => response.text())
            .then(data => {
                document.getElementById('navbar-placeholder').innerHTML = data;
            });
    </script>

    <main>
        <section class="container mt-5">
        <%
            String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
            String dbUser = "hr";
            String dbPass = "hr";

            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;

            String postId = request.getParameter("seq");  
            String memberId = (String)session.getAttribute("memberId");

            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

                String postSQL = "SELECT B.SEQ, B.SUBJECT, B.CONTENT, M.NAME AS WRITER, B.LOGTIME, B.VIEWS FROM BOARD B JOIN MEMBER M ON B.MEMBER_ID = M.MEMBER_ID WHERE B.SEQ = ?";
                pstmt = conn.prepareStatement(postSQL);
                pstmt.setString(1, postId);
                rs = pstmt.executeQuery();

                String updateViewsSQL = "UPDATE BOARD SET VIEWS = VIEWS + 1 WHERE SEQ = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updateViewsSQL);
                updateStmt.setString(1, postId);
                updateStmt.executeUpdate();

                if(rs.next()) {
                    String subject = rs.getString("SUBJECT");
                    String content = rs.getString("CONTENT");
                    String writer = rs.getString("WRITER");
                    String logtime = rs.getString("LOGTIME");
                    int views = rs.getInt("VIEWS");

                    out.println("<h2>" + subject + "</h2>");
                    out.println("<p><strong>작성자:</strong> " + writer + "</p>");
                    out.println("<p><strong>작성일:</strong> " + logtime + "</p>");
                    out.println("<p><strong>조회수:</strong> " + views + "</p>");
                    out.println("<hr>");
                    out.println("<p>" + content + "</p>");
                }

                String commentSQL = "SELECT C.COMMENT_ID, C.CONTENT, M.NAME AS WRITER, C.LOGTIME FROM COMMENTS C JOIN MEMBER M ON C.MEMBER_ID = M.MEMBER_ID WHERE C.POST_ID = ? ORDER BY C.COMMENT_ID ASC";
                pstmt = conn.prepareStatement(commentSQL);
                pstmt.setString(1, postId);
                rs = pstmt.executeQuery();

                out.println("<hr><h3>댓글</h3>");
                while(rs.next()) {
                    String commentContent = rs.getString("CONTENT");
                    String commentWriter = rs.getString("WRITER");
                    String commentLogtime = rs.getString("LOGTIME");

                    out.println("<div><strong>" + commentWriter + ":</strong> " + commentContent + " <em>(" + commentLogtime + ")</em></div>");
                }

                if(memberId != null) {
                    out.println("<hr><h4>댓글 작성</h4>");
                    out.println("<form action='add_comment.jsp' method='post'>");
                    out.println("<input type='hidden' name='postId' value='" + postId + "'>");
                    out.println("<textarea name='content' class='form-control' rows='4' required></textarea><br>");
                    out.println("<div class='text-end'><button type='submit' class='btn btn-primary'>댓글 달기</button></div>");
                    out.println("</form>");
                } else {
                    out.println("<p><a href='../login.html'>로그인</a> 후 댓글을 작성할 수 있습니다.</p>");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try { if (rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
                try { if (pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
                try { if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
            }
        %>
        </section>
    </main>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
