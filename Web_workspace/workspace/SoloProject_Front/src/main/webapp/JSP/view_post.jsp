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
    <!-- 네비게이션 바를 인라인으로 작성 -->
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <a class="navbar-brand" href="../index.html">
                <img src="../images/home.png" alt="Home" style="width:30px; height:30px;">
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="../index.html">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../board.html">게시판</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../register.html">회원가입</a>
                    </li>
                    <li class="nav-item">
                        <a id="loginLink" class="nav-link" href="../login.html">Login</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <main>
        <section class="container mt-5">
        <%
            String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
            String dbUser = "hr";
            String dbPass = "hr";

            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;

            String postId = request.getParameter("seq");  // 게시글 ID
            String memberId = (String)session.getAttribute("memberId"); // 세션에서 로그인한 사용자 ID 가져오기

            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

                // 게시글 내용 가져오기
                String postSQL = "SELECT B.SEQ, B.SUBJECT, B.CONTENT, M.NAME AS WRITER, B.LOGTIME, B.VIEWS FROM BOARD B JOIN MEMBER M ON B.MEMBER_ID = M.MEMBER_ID WHERE B.SEQ = ?";
                pstmt = conn.prepareStatement(postSQL);
                pstmt.setString(1, postId);
                rs = pstmt.executeQuery();

                // 조회수 증가시키기
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

                // 댓글 목록 가져오기
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

                // 댓글 작성 폼
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

    <!-- 네비게이션 바 스크립트 -->
    <script>
        document.addEventListener("DOMContentLoaded", function() {
            const userEmail = sessionStorage.getItem("userEmail");
            if (userEmail) {
                const loginButton = document.getElementById("loginLink");
                loginButton.textContent = "MyPage";
                loginButton.href = "MyPage.html";
            }
        });
    </script>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
