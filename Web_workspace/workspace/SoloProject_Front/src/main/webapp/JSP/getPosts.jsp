<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.io.*" %>
<%
    // 데이터베이스 연결을 위한 URL, 사용자 이름, 비밀번호를 설정합니다.
    String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
    String dbUser = "hr";
    String dbPass = "hr";

    Connection conn = null;  // 데이터베이스 연결 객체
    PreparedStatement pstmt = null;  // SQL 쿼리 실행 객체
    ResultSet rs = null;  // 쿼리 실행 결과를 저장하는 객체

    try {
        // Oracle JDBC 드라이버를 메모리에 로드합니다.
        Class.forName("oracle.jdbc.driver.OracleDriver");
        // 설정된 URL, 사용자 이름, 비밀번호로 데이터베이스에 연결합니다.
        conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

        // 게시글 목록을 가져오는 SQL 쿼리에서 작성자의 이름과 조회수를 가져오도록 수정
        // BOARD 테이블과 MEMBER 테이블을 JOIN하여 게시글 정보와 작성자 이름을 함께 가져옵니다.
        String sql = "SELECT B.SEQ, B.SUBJECT, M.NAME AS WRITER, B.LOGTIME, B.VIEWS FROM BOARD B JOIN MEMBER M ON B.MEMBER_ID = M.MEMBER_ID ORDER BY B.SEQ DESC";
        pstmt = conn.prepareStatement(sql);  // SQL 쿼리를 준비합니다.
        rs = pstmt.executeQuery();  // 쿼리를 실행하고 결과를 ResultSet 객체에 저장합니다.

        // ResultSet을 순회하며 각 게시글의 정보를 가져와 출력합니다.
        while (rs.next()) {
            int seq = rs.getInt("SEQ");  // 게시글 번호를 가져옵니다.
            String subject = rs.getString("SUBJECT");  // 게시글 제목을 가져옵니다.
            String writer = rs.getString("WRITER"); // 작성자 이름을 가져옵니다.
            String logtime = rs.getString("LOGTIME");  // 게시글 작성 시간을 가져옵니다.
            int views = rs.getInt("VIEWS");  // 조회수를 가져옵니다.

            // HTML 테이블의 각 행에 게시글 정보를 출력합니다.
            out.println("<tr>");
            out.println("<td>" + seq + "</td>");  // 게시글 번호 출력
            out.println("<td>" + subject + "</td>");  // 게시글 제목 출력
            out.println("<td>" + writer + "</td>"); // 작성자 이름 출력
            out.println("<td>" + logtime + "</td>");  // 게시글 작성 시간 출력
            out.println("<td>" + views + "</td>"); // 조회수 출력
            out.println("<td><a href='JSP/view_post.jsp?seq=" + seq + "'>View</a></td>");  // 게시글 보기 링크 출력
            out.println("</tr>");
        }
    } catch (Exception e) {
        // 예외가 발생한 경우, 예외 정보를 StringWriter와 PrintWriter를 사용하여 문자열로 변환 후 출력합니다.
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);  // 예외 정보를 StringWriter에 출력
        out.println("<pre>" + sw.toString() + "</pre>");  // 예외 정보를 브라우저에 출력
    } finally {
        // 리소스 해제: ResultSet, PreparedStatement, Connection 객체를 닫아줍니다.
        try { if (rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
        try { if (pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
        try { if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
    }
%>
