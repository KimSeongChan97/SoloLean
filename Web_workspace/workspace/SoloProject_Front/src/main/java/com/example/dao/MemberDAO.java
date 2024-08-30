package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.example.dto.MemberDTO;

public class MemberDAO {
    private Connection conn;

    // MemberDAO 생성자: 데이터베이스와의 연결을 설정합니다.
    public MemberDAO() {
        try {
            // 데이터베이스 연결 설정
            String dbURL = "jdbc:oracle:thin:@localhost:1521:xe"; // Oracle XE 버전 기준
            String dbID = "hr";  // SQL Developer에서 사용 중인 ID
            String dbPassword = "hr"; // SQL Developer에서 사용 중인 비밀번호
            // JDBC 드라이버 로드: Oracle 데이터베이스에 연결하기 위해 OracleDriver 클래스를 로드합니다.
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // DriverManager를 통해 데이터베이스 연결을 설정합니다.
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
        } catch (Exception e) {
            // 예외가 발생하면, 그 내용을 출력합니다.
            e.printStackTrace();
        }
    }

    // 회원가입을 처리하는 메소드: MemberDTO 객체를 받아 데이터베이스에 새로운 회원 정보를 저장합니다.
    public int register(MemberDTO member) {
        // SQL 쿼리문: MEMBER 테이블에 새로운 사용자 정보를 삽입합니다.
        // USERNAME, EMAIL, PASSWORD 필드에 각각의 값이 들어갑니다.
        String SQL = "INSERT INTO MEMBER (USERNAME, EMAIL, PASSWORD) VALUES (?, ?, ?)";
        try {
            // PreparedStatement 객체 생성: SQL 쿼리문을 데이터베이스에 전송하기 위해 사용합니다.
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            // 첫 번째 ? 자리에 member 객체의 username 값을 바인딩합니다.
            pstmt.setString(1, member.getUsername());
            // 두 번째 ? 자리에 member 객체의 email 값을 바인딩합니다.
            pstmt.setString(2, member.getEmail());
            // 세 번째 ? 자리에 member 객체의 password 값을 바인딩합니다.
            pstmt.setString(3, member.getPassword());
            // 쿼리를 실행하고, 데이터베이스에 영향을 미친 행의 수를 반환합니다.
            return pstmt.executeUpdate();
        } catch (Exception e) {
            // 예외가 발생하면, 그 내용을 출력하고 -1을 반환합니다.
            e.printStackTrace();
            return -1; // 오류 발생 시 -1 반환
        }
    }
}
