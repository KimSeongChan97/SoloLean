<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.io.*" %>
<%
    // 요청(request)에서 전달된 데이터의 인코딩을 UTF-8로 설정합니다.
    request.setCharacterEncoding("UTF-8");
    // 응답(response)의 콘텐츠 타입과 인코딩을 UTF-8로 설정하여 HTML 페이지를 올바르게 표시합니다.
    response.setContentType("text/html; charset=UTF-8");

    // 데이터베이스 연결 정보를 설정합니다.
    String dbURL = "jdbc:oracle:thin:@localhost:1521:xe"; // Oracle 데이터베이스 URL
    String dbUser = "hr";  // 데이터베이스 사용자 이름
    String dbPass = "hr";  // 데이터베이스 사용자 비밀번호
    
    Connection conn = null; // 데이터베이스 연결 객체를 위한 변수 선언
    PreparedStatement pstmt = null; // SQL 쿼리 실행을 위한 PreparedStatement 객체를 위한 변수 선언
    
    // 사용자가 입력한 게시글 ID와 댓글 내용을 요청(request) 객체에서 가져옵니다.
    String postId = request.getParameter("postId");  // 게시글 ID
    String content = request.getParameter("content");  // 댓글 내용
    // 세션에서 로그인된 사용자 ID를 가져옵니다.
    String memberId = (String)session.getAttribute("memberId");  // 세션에서 로그인한 사용자 ID 가져오기

    // 만약 memberId가 null이면(즉, 사용자가 로그인하지 않았다면) 로그인 페이지로 리다이렉트합니다.
    if(memberId == null) {
        response.sendRedirect("login.html"); // 로그인되지 않은 경우 로그인 페이지로 이동
        return; // 이후 코드를 실행하지 않도록 return으로 메서드를 종료합니다.
    }

    try {
        // Oracle JDBC 드라이버를 로드합니다.
        Class.forName("oracle.jdbc.driver.OracleDriver");
        // 데이터베이스에 연결합니다.
        conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

        // 댓글을 데이터베이스에 저장하기 위한 SQL 쿼리문을 작성합니다.
        String sql = "INSERT INTO COMMENTS (COMMENT_ID, POST_ID, MEMBER_ID, CONTENT, LOGTIME) VALUES (COMMENTS_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
        pstmt = conn.prepareStatement(sql); // SQL 쿼리를 준비합니다.
        // 첫 번째 ? 자리에 postId(게시글 ID)를 바인딩합니다.
        pstmt.setString(1, postId);
        // 두 번째 ? 자리에 memberId(사용자 ID)를 바인딩합니다.
        pstmt.setString(2, memberId);
        // 세 번째 ? 자리에 content(댓글 내용)를 바인딩합니다.
        pstmt.setString(3, content);
        // SQL 쿼리를 실행하고, 실행 결과로 영향을 받은 행의 수를 반환받습니다.
        int result = pstmt.executeUpdate();

        // 만약 댓글 삽입이 성공적으로 이루어졌다면, 해당 게시글 페이지로 리다이렉트합니다.
        if(result > 0) {
            response.sendRedirect("view_post.jsp?seq=" + postId);  // 성공 시 해당 게시글로 리다이렉트
        } else {
            // 삽입에 실패한 경우, 에러 메시지를 출력합니다.
            out.println("Error: Failed to add the comment.");
        }
    } catch (Exception e) {
        // 예외 발생 시, 예외 내용을 출력합니다.
        e.printStackTrace();
    } finally {
        // 리소스를 해제합니다. (PreparedStatement와 Connection 객체를 닫음)
        try { if (pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
        try { if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
    }
%>
