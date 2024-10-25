<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.io.*, java.text.SimpleDateFormat, java.util.*" %>
<%
    // 클라이언트로부터 전달받은 데이터의 인코딩을 UTF-8로 설정합니다.
    request.setCharacterEncoding("UTF-8");

    // 데이터베이스 연결 정보를 설정합니다.
    String dbURL = "jdbc:oracle:thin:@localhost:1521:xe"; // Oracle 데이터베이스 연결 URL
    String dbUser = "hr";  // 데이터베이스 사용자 이름
    String dbPass = "hr";  // 데이터베이스 사용자 비밀번호

    Connection conn = null;  // 데이터베이스 연결을 위한 Connection 객체
    PreparedStatement pstmt = null;  // SQL 쿼리 실행을 위한 PreparedStatement 객체

    try {
        // 클라이언트로부터 전달받은 게시글 제목, 내용, 그리고 세션에서 로그인한 사용자의 ID를 가져옵니다.
        String title = request.getParameter("title"); // 게시글 제목
        String content = request.getParameter("content"); // 게시글 내용
        String memberId = (String)session.getAttribute("memberId"); // 세션에서 로그인한 사용자 ID 가져오기

        // 사용자가 로그인하지 않은 경우 로그인 페이지로 리다이렉트
        if(memberId == null) {
            response.sendRedirect("login.html"); // 로그인되지 않은 경우 로그인 페이지로 이동
            return; // 이후 코드를 실행하지 않고 종료
        }

        // 데이터베이스 연결
        // JDBC 드라이버를 로드하고 데이터베이스에 연결합니다.
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

        // BOARD 테이블에 게시글 정보 삽입
        // 게시글 데이터를 BOARD 테이블에 삽입하는 SQL 쿼리를 작성합니다.
        String sql = "INSERT INTO BOARD (SEQ, MEMBER_ID, SUBJECT, CONTENT, LOGTIME) VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
        pstmt = conn.prepareStatement(sql); // SQL 쿼리를 실행할 PreparedStatement 객체를 생성
        pstmt.setString(1, memberId); // MEMBER_ID를 첫 번째 ?에 바인딩
        pstmt.setString(2, title); // 제목을 두 번째 ?에 바인딩
        pstmt.setString(3, content); // 내용을 세 번째 ?에 바인딩
        int result = pstmt.executeUpdate(); // SQL 쿼리를 실행하고 영향받은 행의 수를 반환

        if(result > 0) {
            // 성공적으로 게시글이 저장된 경우

            // 현재 날짜를 포맷팅하여 세션 스토리지에 새 글 정보 저장
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // 날짜 포맷 설정
            String date = sdf.format(new java.util.Date()); // 현재 날짜와 시간을 포맷팅하여 문자열로 변환

            // 새 게시글 정보를 JSON 형식으로 생성
            String newPost = "{ \"title\": \"" + title + "\", \"teacher\": \"" + memberId + "\", \"date\": \"" + date + "\" }";
            out.println("<script>");
            // 세션 스토리지에 새로운 게시글 정보 저장
            out.println("sessionStorage.setItem('newPost', '" + newPost + "');");
            // 게시글 목록 페이지로 이동
            out.println("location.href='board.html';");
            out.println("</script>");
        } else {
            // 게시글 저장에 실패한 경우 오류 메시지 출력
            out.println("Error: Failed to save the post.");
        }
    } catch (Exception e) {
        // 예외 발생 시 예외 정보를 출력
        out.println("Error: " + e.getMessage());
        e.printStackTrace();
    } finally {
        // 리소스 해제: 사용한 PreparedStatement와 Connection 객체를 닫습니다.
        try { if (pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
        try { if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
    }
%>
