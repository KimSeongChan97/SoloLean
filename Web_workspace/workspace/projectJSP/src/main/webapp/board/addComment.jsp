<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>

<%
    // 클라이언트에서 전송된 데이터(댓글 내용)의 인코딩을 UTF-8로 설정
    request.setCharacterEncoding("UTF-8");  // 클라이언트로부터 전송된 데이터를 UTF-8로 인코딩하여 한글 등 특수 문자가 깨지지 않도록 합니다.

    // 폼으로부터 전달된 댓글 내용과 게시글 번호, 그리고 세션에서 로그인된 사용자 이름을 받아옵니다.
    String commentContent = request.getParameter("commentContent");  // 클라이언트가 입력한 댓글 내용을 받아옵니다.
    int boardSeq = Integer.parseInt(request.getParameter("boardSeq"));  // 클라이언트가 댓글을 작성한 게시글 번호를 받아옵니다. 이 값은 게시글과 댓글을 연결하기 위한 참조 값입니다.
    String sessionName = (String) session.getAttribute("memName");  // 로그인된 사용자의 이름을 세션에서 가져옵니다. 세션에 저장된 사용자의 이름은 댓글 작성자 이름으로 사용됩니다.

    // Connection pool을 통한 데이터베이스 연결
    // 데이터베이스와의 연결을 위한 기본 객체들 (Connection, PreparedStatement)을 선언합니다.
    Connection conn = null;  // 데이터베이스와의 연결을 나타내는 객체로, 커넥션 풀에서 가져온 연결을 담습니다.
    PreparedStatement pstmt = null;  // SQL 쿼리를 실행하기 위한 객체로, SQL을 실행할 때 사용됩니다.

    try {
        // InitialContext를 통해 context.xml에서 설정한 DataSource 가져오기
        // context.xml에 정의된 데이터베이스 연결 풀(DataSource)을 가져옵니다.
        InitialContext ic = new InitialContext();  // JNDI를 통해 리소스(데이터베이스 연결)를 검색하는 데 사용되는 객체입니다.
        DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/oracle");  // "java:comp/env/jdbc/oracle"로 정의된 데이터 소스를 찾아서 데이터베이스 연결 풀을 가져옵니다.

        // Connection Pool에서 Connection 얻기
        conn = ds.getConnection();  // 데이터베이스 연결 풀에서 사용 가능한 커넥션을 얻습니다. 이 커넥션을 통해 데이터베이스와 통신할 수 있습니다.

        // 댓글을 데이터베이스에 저장하는 SQL 문 (comment_id는 시퀀스를 통해 자동 생성)
        // 댓글 데이터를 comments 테이블에 삽입하는 SQL 문을 준비합니다.
        // 시퀀스를 사용해 comment_id를 자동으로 생성하고, boardSeq, name(작성자), content(댓글 내용), logtime(작성 시간)을 삽입합니다.
        String sql = "INSERT INTO comments (comment_id, boardSeq, name, content, logtime) VALUES (seq_comments.NEXTVAL, ?, ?, ?, SYSDATE)";
        pstmt = conn.prepareStatement(sql);  // SQL 쿼리를 준비하고, PreparedStatement 객체에 설정합니다.
        pstmt.setInt(1, boardSeq);  // 첫 번째 매개변수로 게시글 번호를 설정합니다. 게시글 번호는 댓글이 어떤 게시글에 달린 것인지를 나타냅니다.
        pstmt.setString(2, sessionName);  // 두 번째 매개변수로 댓글 작성자 이름을 설정합니다. 세션에서 가져온 로그인된 사용자의 이름을 사용합니다.
        pstmt.setString(3, commentContent);  // 세 번째 매개변수로 댓글 내용을 설정합니다. 클라이언트가 입력한 댓글 내용을 전달합니다.
        pstmt.executeUpdate();  // 준비된 SQL 쿼리를 실행하여 데이터베이스에 댓글을 저장합니다.

    } catch (Exception e) {
        // 예외가 발생한 경우 예외 메시지를 출력합니다. 
        // 예외는 데이터베이스 연결 문제, SQL 실행 오류 등이 있을 수 있습니다.
        e.printStackTrace();  // 예외 발생 시 오류 내용을 콘솔에 출력하여 디버깅에 도움을 줍니다.
    } finally {
        // 자원 반환: 사용이 끝난 PreparedStatement와 Connection 객체를 닫아줍니다.
        // 데이터베이스와의 연결을 종료하고 자원을 반납하는 것이 매우 중요합니다.
        if (pstmt != null) pstmt.close();  // PreparedStatement 객체를 닫아 자원을 해제합니다.
        if (conn != null) conn.close();  // Connection 객체를 닫아 커넥션 풀로 반납합니다.
    }

    // 댓글 작성 후 다시 게시글 보기 페이지로 리다이렉트
    // 댓글 작성이 완료되면 다시 해당 게시글 페이지로 이동하여 갱신된 댓글 목록을 볼 수 있게 합니다.
    response.sendRedirect("boardView.jsp?seq=" + boardSeq);  // 댓글이 작성된 게시글의 번호(seq)를 포함하여 게시글 보기 페이지로 리다이렉트합니다.
%>
