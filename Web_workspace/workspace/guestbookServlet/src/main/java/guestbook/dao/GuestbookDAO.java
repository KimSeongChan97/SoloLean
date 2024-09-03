package guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import guestbook.bean.GuestbookDTO;

public class GuestbookDAO {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // 데이터베이스 URL
    private static final String USER = "C##JAVA";  // DB 사용자명
    private static final String PASSWORD = "1234";  // DB 비밀번호
    
    public GuestbookDAO() {
        try {
            // JDBC 드라이버를 로드합니다.
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    // 방명록 항목을 데이터베이스에 삽입하는 메서드
    public void guestbookWrite(GuestbookDTO dto) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 데이터베이스 연결을 설정합니다.
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // 삽입 쿼리를 준비합니다.
            String sql = "INSERT INTO guestbook(seq, name, email, homepage, subject, content, logtime) " +
                         "VALUES(seq_guestbook.NEXTVAL, ?, ?, ?, ?, ?, SYSDATE)";
            pstmt = conn.prepareStatement(sql);

            // DTO 객체로부터 데이터를 가져와 PreparedStatement에 설정합니다.
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getEmail());
            pstmt.setString(3, dto.getHomepage());
            pstmt.setString(4, dto.getSubject());
            pstmt.setString(5, dto.getContent());

            // 쿼리를 실행하여 데이터를 삽입합니다.
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

//1. driver loading
//2. Connection
//3. PreparedStatement