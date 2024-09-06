package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.bean.BoardDTO;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
    private static BoardDAO instance = new BoardDAO();
    private DataSource ds;

    // 생성자에서 DataSource 설정
    private BoardDAO() {
        try {
            Context init = new InitialContext();
            ds = (DataSource) init.lookup("java:comp/env/jdbc/oracle");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Singleton 패턴을 통해 객체를 한 번만 생성하여 사용
    public static BoardDAO getInstance() {
        return instance;
    }

    // 시퀀스 값 얻어오기 - 게시글 번호를 자동으로 증가시킴
    public int getNextSeq() {
        int seq = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT seq_board.NEXTVAL FROM dual";

        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                seq = rs.getInt(1); // 시퀀스 값을 얻어온다
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt, rs);
        }

        return seq;
    }

    // 게시글 저장 메서드 - 새로운 게시글을 데이터베이스에 저장
    public void insertBoard(BoardDTO boardDTO) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "INSERT INTO board (seq, id, name, email, subject, content, ref, lev, step, pseq, reply, hit, logtime) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, 0, 0, 0, 0, 0, SYSDATE)"; // 조회수(hit)는 기본값 0으로 설정됨

        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boardDTO.getSeq()); // 시퀀스 값 설정
            pstmt.setString(2, boardDTO.getId()); // 작성자 ID
            pstmt.setString(3, boardDTO.getName()); // 작성자 이름
            pstmt.setString(4, boardDTO.getEmail()); // 작성자 이메일
            pstmt.setString(5, boardDTO.getSubject()); // 제목
            pstmt.setString(6, boardDTO.getContent()); // 내용
            pstmt.setInt(7, boardDTO.getRef()); // 그룹번호 설정

            pstmt.executeUpdate(); // SQL 실행
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt);
        }
    }

    // 게시글 목록을 가져오는 메서드 - 모든 게시글을 가져와 목록으로 반환
    public List<BoardDTO> getBoardList() {
        List<BoardDTO> boardList = new ArrayList<BoardDTO>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM board ORDER BY seq DESC"; // 게시글을 최신순으로 정렬

        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                BoardDTO boardDTO = new BoardDTO();
                boardDTO.setSeq(rs.getInt("seq"));
                boardDTO.setId(rs.getString("id"));
                boardDTO.setName(rs.getString("name"));
                boardDTO.setEmail(rs.getString("email"));
                boardDTO.setSubject(rs.getString("subject"));
                boardDTO.setContent(rs.getString("content"));
                boardDTO.setRef(rs.getInt("ref"));
                boardDTO.setLev(rs.getInt("lev"));
                boardDTO.setStep(rs.getInt("step"));
                boardDTO.setPseq(rs.getInt("pseq"));
                boardDTO.setReply(rs.getInt("reply"));
                boardDTO.setHit(rs.getInt("hit")); // 조회수 포함
                boardDTO.setLogtime(rs.getString("logtime"));

                boardList.add(boardDTO); // 목록에 추가
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt, rs);
        }

        return boardList;
    }

    // 특정 게시글을 가져오는 메서드 - 게시글 번호(seq)로 게시글을 조회
    public BoardDTO getBoard(int seq) {
        BoardDTO boardDTO = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM board WHERE seq = ?";

        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, seq);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                boardDTO = new BoardDTO();
                boardDTO.setSeq(rs.getInt("seq"));
                boardDTO.setId(rs.getString("id"));
                boardDTO.setName(rs.getString("name"));
                boardDTO.setEmail(rs.getString("email"));
                boardDTO.setSubject(rs.getString("subject"));
                boardDTO.setContent(rs.getString("content"));
                boardDTO.setRef(rs.getInt("ref"));
                boardDTO.setLev(rs.getInt("lev"));
                boardDTO.setStep(rs.getInt("step"));
                boardDTO.setPseq(rs.getInt("pseq"));
                boardDTO.setReply(rs.getInt("reply"));
                boardDTO.setHit(rs.getInt("hit")); // 조회수 포함
                boardDTO.setLogtime(rs.getString("logtime"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt, rs);
        }

        return boardDTO;
    }

    // 조회수를 증가시키는 메서드 - 특정 게시글의 조회수를 1 증가시킴
    public void increaseHit(int seq) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "UPDATE board SET hit = hit + 1 WHERE seq = ?"; // 조회수를 1 증가시키는 SQL

        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, seq); // 해당 게시글 번호를 입력
            pstmt.executeUpdate(); // SQL 실행
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt);
        }
    }

    // 리소스 반환 메서드
    private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void close(Connection conn, PreparedStatement pstmt) {
        try {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
