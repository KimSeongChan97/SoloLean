<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="java.util.UUID, java.sql.*, java.io.*" %>
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
        // UUID를 사용하여 MEMBER_ID 생성
        // UUID(Universally Unique Identifier)는 고유한 식별자를 생성하기 위한 표준입니다.
        // 이를 사용하여 데이터베이스 내에서 중복되지 않는 고유한 MEMBER_ID를 생성할 수 있습니다.
        // 데이터베이스의 기본 키로 사용되는 식별자는 중복되지 않아야 하므로, UUID를 사용하여
        // 회원의 고유 ID를 생성합니다. UUID는 128비트 숫자를 사용하여 전 세계적으로
        // 중복되지 않는 값을 생성할 수 있기 때문에, 대규모 시스템에서도 안전하게 사용할 수 있습니다.
        String memberId = UUID.randomUUID().toString(); // MEMBER_ID를 UUID로 자동 생성

        // 사용자로부터 입력받은 데이터를 변수에 저장합니다.
        String name = request.getParameter("name"); // 사용자로부터 이름을 받아옵니다.
        String email = request.getParameter("email"); // 사용자로부터 이메일을 받아옵니다.
        String password = request.getParameter("password"); // 사용자로부터 비밀번호를 받아옵니다.

        // 이름이 NULL이거나 비어있는지 확인
        if(name == null || name.trim().isEmpty()) {
            out.println("Error: Name cannot be null or empty."); // 이름이 비어있다면 에러 메시지를 출력하고 종료
            return;
        }

        // 이메일 형식 유효성 검사 추가
        // 이메일이 올바른 형식인지 정규 표현식을 사용하여 검증합니다.
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!email.matches(emailPattern)) {
            out.println("Error: Invalid EMAIL."); // 이메일이 올바르지 않으면 에러 메시지를 출력하고 종료
            return;
        }

        // 데이터베이스 연결
        // JDBC 드라이버를 로드하고 데이터베이스에 연결합니다.
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

        // MEMBER 테이블에 사용자 정보 삽입
        // 사용자 정보를 데이터베이스의 MEMBER 테이블에 저장하는 SQL 쿼리를 실행합니다.
        String sql = "INSERT INTO MEMBER (MEMBER_ID, NAME, EMAIL, PASSWORD) VALUES (?, ?, ?, ?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, memberId); // 자동 생성된 MEMBER_ID를 설정
        pstmt.setString(2, name); // 사용자 이름을 설정
        pstmt.setString(3, email); // 사용자 이메일을 설정
        pstmt.setString(4, password); // 사용자 비밀번호를 설정
        int result = pstmt.executeUpdate(); // SQL 쿼리를 실행하고 영향 받은 행 수를 반환받습니다.

        if(result > 0) {
            // 데이터 삽입에 성공하면 로그인 페이지로 리다이렉트합니다.
            response.sendRedirect("login.html"); // 성공 시 로그인 페이지로 이동
        } else {
            out.println("Error: Failed to register."); // 데이터 삽입에 실패하면 에러 메시지를 출력합니다.
        }
    } catch (Exception e) {
        // 예외가 발생하면 스택 트레이스를 출력하고 에러 메시지를 출력합니다.
        e.printStackTrace();
        out.println("Error: Database connection or SQL error.");
    } finally {
        // 리소스 해제: 사용한 PreparedStatement와 Connection 객체를 닫습니다.
        if(pstmt != null) try { pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
        if(conn != null) try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
    }
%>
