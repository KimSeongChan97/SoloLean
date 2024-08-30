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
            <!-- 홈 페이지로 이동하는 로고 -->
            <a class="navbar-brand" href="../index.html">
                <img src="../images/home.png" alt="Home" style="width:30px; height:30px;">
            </a>
            <!-- 모바일 화면에서 메뉴를 열고 닫는 버튼 -->
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <!-- 네비게이션 바의 메뉴 항목들 -->
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <!-- 'Home' 페이지로 이동하는 링크 -->
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="../index.html">Home</a>
                    </li>
                    <!-- '게시판' 페이지로 이동하는 링크 -->
                    <li class="nav-item">
                        <a class="nav-link" href="../board.html">게시판</a>
                    </li>
                    <!-- '회원가입' 페이지로 이동하는 링크 -->
                    <li class="nav-item">
                        <a class="nav-link" href="../register.html">회원가입</a>
                    </li>
                    <!-- 'Login' 페이지로 이동하는 링크 -->
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
            // 데이터베이스 연결을 위한 URL, 사용자 이름, 비밀번호 설정
            String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
            String dbUser = "hr";
            String dbPass = "hr";

            Connection conn = null; // 데이터베이스 연결을 위한 Connection 객체 선언
            PreparedStatement pstmt = null; // SQL 쿼리 실행을 위한 PreparedStatement 객체 선언
            ResultSet rs = null; // 쿼리 실행 결과를 저장하기 위한 ResultSet 객체 선언

            // 클라이언트로부터 전달받은 게시글 ID와 세션에서 로그인한 사용자 ID 가져오기
            String postId = request.getParameter("seq");  // 게시글 ID
            String memberId = (String)session.getAttribute("memberId"); // 세션에서 로그인한 사용자 ID 가져오기

            try {
                // Oracle JDBC 드라이버를 메모리에 로드
                Class.forName("oracle.jdbc.driver.OracleDriver");
                // 데이터베이스에 연결
                conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

                // 게시글 내용 가져오기
                // 게시글의 ID(seq)로 해당 게시글의 제목, 내용, 작성자, 작성일, 조회수 등을 가져오는 SQL 쿼리
                String postSQL = "SELECT B.SEQ, B.SUBJECT, B.CONTENT, M.NAME AS WRITER, B.LOGTIME, B.VIEWS FROM BOARD B JOIN MEMBER M ON B.MEMBER_ID = M.MEMBER_ID WHERE B.SEQ = ?";
                pstmt = conn.prepareStatement(postSQL);
                pstmt.setString(1, postId);
                rs = pstmt.executeQuery();

                // 게시글 조회수 증가시키기
                // 해당 게시글의 조회수를 1 증가시키는 SQL 쿼리
                String updateViewsSQL = "UPDATE BOARD SET VIEWS = VIEWS + 1 WHERE SEQ = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updateViewsSQL);
                updateStmt.setString(1, postId);
                updateStmt.executeUpdate();

                // 게시글이 존재할 경우, 그 내용을 화면에 출력
                if(rs.next()) {
                    String subject = rs.getString("SUBJECT"); // 게시글 제목
                    String content = rs.getString("CONTENT"); // 게시글 내용
                    String writer = rs.getString("WRITER"); // 작성자 이름
                    String logtime = rs.getString("LOGTIME"); // 작성일
                    int views = rs.getInt("VIEWS"); // 조회수

                    // HTML 태그를 사용하여 게시글 정보 출력
                    out.println("<h2>" + subject + "</h2>");
                    out.println("<p><strong>작성자:</strong> " + writer + "</p>");
                    out.println("<p><strong>작성일:</strong> " + logtime + "</p>");
                    out.println("<p><strong>조회수:</strong> " + views + "</p>");
                    out.println("<hr>");
                    out.println("<p>" + content + "</p>");
                }

                // 댓글 목록 가져오기
                // 게시글 ID에 해당하는 댓글들을 작성 순서대로 가져오는 SQL 쿼리
                String commentSQL = "SELECT C.COMMENT_ID, C.CONTENT, M.NAME AS WRITER, C.LOGTIME FROM COMMENTS C JOIN MEMBER M ON C.MEMBER_ID = M.MEMBER_ID WHERE C.POST_ID = ? ORDER BY C.COMMENT_ID ASC";
                pstmt = conn.prepareStatement(commentSQL);
                pstmt.setString(1, postId);
                rs = pstmt.executeQuery();

                // 댓글 목록 출력
                out.println("<hr><h3>댓글</h3>");
                while(rs.next()) {
                    String commentContent = rs.getString("CONTENT"); // 댓글 내용
                    String commentWriter = rs.getString("WRITER"); // 댓글 작성자
                    String commentLogtime = rs.getString("LOGTIME"); // 댓글 작성 시간

                    // HTML 태그를 사용하여 댓글 정보 출력
                    out.println("<div><strong>" + commentWriter + ":</strong> " + commentContent + " <em>(" + commentLogtime + ")</em></div>");
                }

                // 로그인한 사용자가 있을 경우 댓글 작성 폼을 출력
                if(memberId != null) {
                    out.println("<hr><h4>댓글 작성</h4>");
                    out.println("<form action='add_comment.jsp' method='post'>");
                    out.println("<input type='hidden' name='postId' value='" + postId + "'>");
                    out.println("<textarea name='content' class='form-control' rows='4' required></textarea><br>");
                    out.println("<div class='text-end'><button type='submit' class='btn btn-primary'>댓글 달기</button></div>");
                    out.println("</form>");
                } else {
                    // 로그인하지 않은 경우, 로그인 페이지로 이동하라는 메시지 출력
                    out.println("<p><a href='../login.html'>로그인</a> 후 댓글을 작성할 수 있습니다.</p>");
                }
            } catch (Exception e) {
                // 예외 발생 시 예외 정보를 출력
                e.printStackTrace();
            } finally {
                // 사용된 리소스들을 해제
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
                // 사용자가 로그인한 경우 MyPage로 이동하도록 링크 변경
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
