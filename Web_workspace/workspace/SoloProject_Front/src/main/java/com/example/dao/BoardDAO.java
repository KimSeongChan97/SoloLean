package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.dto.BoardDTO;

public class BoardDAO {
    private Connection conn;

    // BoardDAO 생성자: 데이터베이스 연결을 설정하는 부분
    public BoardDAO() {
        try {
            // 데이터베이스 연결 설정
            String dbURL = "jdbc:oracle:thin:@localhost:1521:xe"; // Oracle XE 버전 기준
            String dbID = "hr"; // 데이터베이스 사용자 이름
            String dbPassword = "hr"; // 데이터베이스 비밀번호
            // Oracle JDBC 드라이버를 로드합니다. 이 클래스는 Oracle 데이터베이스와의 연결을 가능하게 합니다.
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // DriverManager를 통해 데이터베이스 연결을 가져옵니다.
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
        } catch (Exception e) {
            // 연결 과정에서 예외가 발생하면, 예외의 세부 사항을 출력합니다.
            e.printStackTrace();
        }
    }

    // 게시글을 등록하는 메소드
    public int write(BoardDTO board) {
        // SQL 쿼리문: BOARD 테이블에 새로운 행을 삽입하는 쿼리입니다.
        // SEQ는 BOARD_SEQ 시퀀스를 사용하여 자동으로 증가되는 값입니다.
        // LOGTIME은 현재 시간을 기록합니다.
        String SQL = "INSERT INTO BOARD (SEQ, MEMBER_ID, SUBJECT, CONTENT, LOGTIME) VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
        try {
            // SQL 쿼리를 실행하기 위해 PreparedStatement 객체를 생성합니다.
            // PreparedStatement는 SQL 쿼리에 값을 동적으로 바인딩할 수 있게 해줍니다.
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            // 첫 번째 ? 자리에 board 객체의 memberId 값을 바인딩합니다.
            pstmt.setString(1, board.getMemberId());
            // 두 번째 ? 자리에 board 객체의 subject 값을 바인딩합니다.
            pstmt.setString(2, board.getSubject());
            // 세 번째 ? 자리에 board 객체의 content 값을 바인딩합니다.
            pstmt.setString(3, board.getContent());
            // 쿼리를 실행하고, 영향받은 행의 수를 반환합니다.
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            // SQL 실행 과정에서 예외가 발생하면, 예외의 세부 사항을 출력합니다.
            e.printStackTrace();
        }
        return -1; // 데이터베이스 오류 발생 시 -1을 반환합니다.
    }
}
