<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*, java.io.*" %>
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
        String memberId = (String) session.getAttribute("memberId"); // 로그인한 사용자의 ID

        // 디버깅 출력: 서버 측에서 데이터를 확인하기 위해 출력합니다.
        out.println("Title: " + title); // 제목 출력
        out.println("Content: " + content); // 내용 출력
        out.println("Member ID: " + memberId); // 회원 ID 출력

        // 회원 ID가 없거나 유효하지 않은 경우 처리
        if(memberId == null || memberId.trim().isEmpty()) {
            out.println("Error: Invalid Member ID."); // 오류 메시지 출력
            return; // 이후 코드를 실행하지 않고 종료
        }

        // 데이터베이스 연결
        // JDBC 드라이버를 로드하고 데이터베이스에 연결합니다.
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

        // 포스트 삽입 SQL 작성 및 실행 (BOARD 테이블 사용)
        // 게시글 데이터를 BOARD 테이블에 삽입하는 SQL 쿼리를 작성합니다.
        String sql = "INSERT INTO BOARD (SEQ, MEMBER_ID, SUBJECT, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?)";
        pstmt = conn.prepareStatement(sql); // SQL 쿼리를 실행할 PreparedStatement 객체를 생성
        pstmt.setString(1, memberId); // MEMBER_ID를 첫 번째 ?에 바인딩
        pstmt.setString(2, title); // 제목을 두 번째 ?에 바인딩
        pstmt.setString(3, content); // 내용을 세 번째 ?에 바인딩
        int result = pstmt.executeUpdate(); // SQL 쿼리를 실행하고 영향받은 행의 수를 반환

        if(result > 0) {
            // 데이터 삽입에 성공한 경우 게시글 목록 페이지로 리다이렉트합니다.
            response.sendRedirect("board.html"); // 성공 시 게시글 목록 페이지로 이동
        } else {
            // 데이터 삽입에 실패한 경우 오류 메시지를 출력합니다.
            out.println("Error: Failed to save post.");
        }
    } catch (Exception e) {
        // 예외 발생 시 예외 정보를 출력합니다.
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        out.println("<pre>" + sw.toString() + "</pre>"); // 예외 스택 트레이스를 출력
        out.println("Error: Database connection or SQL error."); // 오류 메시지 출력
    } finally {
        // 리소스 해제: 사용한 PreparedStatement와 Connection 객체를 닫습니다.
        if(pstmt != null) try { pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
        if(conn != null) try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
    }
%>
