package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {

    // 1. 싱글톤 인스턴스 생성 (static으로 유일한 인스턴스를 유지)
    private static MemberDAO memberDAO = new MemberDAO();

    // 2. DB 연결에 필요한 정보 설정 (Oracle용)
    private final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe"; // Oracle DB URL (예시)
    private final String DB_USER = "C##JAVA"; // DB 사용자명
    private final String DB_PASSWORD = "1234"; // DB 비밀번호

    // 3. 생성자를 private으로 정의해서 외부에서 인스턴스 생성 차단
    private MemberDAO() {
        try {
            // Oracle JDBC 드라이버 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 4. 싱글톤 인스턴스를 반환하는 메서드
    public static MemberDAO getInstance() {
        return memberDAO;
    }

    // 5. DB 연결 메서드
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    // 6. ID 중복 확인 메서드 (idExistId)
    public boolean idExistId(String id) {
        boolean exist = false;

        // Oracle용 SQL 쿼리문 (회원 테이블에서 id 중복 확인)
        String sql = "SELECT * FROM member WHERE id = ?";

        // try-with-resources를 사용하여 자원 자동 해제
        try (Connection con = getConnection();  // DB 연결
             PreparedStatement pstmt = con.prepareStatement(sql)) {  // SQL 준비

            // SQL 쿼리에 id 값 바인딩
            pstmt.setString(1, id);

            // SQL 실행 및 결과 처리
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    exist = true; // 중복된 ID가 존재함
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exist; // true: 중복, false: 사용 가능
    }

    // 7. 회원 정보를 DB에 저장하는 메서드 (insertMember)
    public void insertMember(String id, String pwd, String name, String gender, String email1, String email2, String tel1, String tel2, String tel3, String zipcode, String addr1, String addr2) {
        // 모든 필드를 포함한 SQL 쿼리
        String sql = "INSERT INTO member (ID, PWD, NAME, GENDER, EMAIL1, EMAIL2, TEL1, TEL2, TEL3, ZIPCODE, ADDR1, ADDR2) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            // 각 필드를 SQL 쿼리에 바인딩
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            pstmt.setString(3, name);
            pstmt.setString(4, gender);
            pstmt.setString(5, email1);
            pstmt.setString(6, email2);
            pstmt.setString(7, tel1);
            pstmt.setString(8, tel2);
            pstmt.setString(9, tel3);
            pstmt.setString(10, zipcode);
            pstmt.setString(11, addr1);
            pstmt.setString(12, addr2);
             
            // SQL 실행
            pstmt.executeUpdate(); // INSERT 쿼리 실행

        } catch (SQLException e) {
            e.printStackTrace(); // 예외 발생 시 오류 메시지 출력
        }
    }
}
