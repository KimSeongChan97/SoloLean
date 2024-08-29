package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.example.dto.MemberDTO;

public class MemberDAO {
    private Connection conn;

    public MemberDAO() {
        try {
            // 데이터베이스 연결 설정
            String dbURL = "jdbc:oracle:thin:@localhost:1521:xe"; // Oracle XE 버전 기준
            String dbID = "hr";  // SQL Developer에서 사용 중인 ID
            String dbPassword = "hr"; // SQL Developer에서 사용 중인 비밀번호
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int register(MemberDTO member) {
        String SQL = "INSERT INTO MEMBER (USERNAME, EMAIL, PASSWORD) VALUES (?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, member.getUsername());
            pstmt.setString(2, member.getEmail());
            pstmt.setString(3, member.getPassword());
            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // 오류 발생 시 -1 반환
        }
    }
}
