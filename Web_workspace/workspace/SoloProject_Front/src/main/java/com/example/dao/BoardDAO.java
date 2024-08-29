package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.dto.BoardDTO;

public class BoardDAO {
    private Connection conn;

    public BoardDAO() {
        try {
            // 데이터베이스 연결 설정
            String dbURL = "jdbc:oracle:thin:@localhost:1521:xe"; // Oracle XE 버전 기준
            String dbID = "hr";
            String dbPassword = "hr";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 게시글을 등록하는 메소드
    public int write(BoardDTO board) {
        String SQL = "INSERT INTO BOARD (SEQ, MEMBER_ID, SUBJECT, CONTENT, LOGTIME) VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, board.getMemberId());
            pstmt.setString(2, board.getSubject());
            pstmt.setString(3, board.getContent());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // 데이터베이스 오류
    }
}
