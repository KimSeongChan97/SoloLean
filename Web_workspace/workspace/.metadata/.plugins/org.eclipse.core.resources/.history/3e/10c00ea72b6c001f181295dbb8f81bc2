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

    public static BoardDAO getInstance() {
        return instance;
    }

    // 시퀀스 값 얻어오기
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
                seq = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt, rs);
        }

        return seq;
    }

    // 게시글 저장
    public void insertBoard(BoardDTO boardDTO) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "INSERT INTO board (seq, id, name, email, subject, content, ref, lev, step, pseq, reply, hit, logtime) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, 0, 0, 0, 0, 0, SYSDATE)";

        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boardDTO.getSeq());
            pstmt.setString(2, boardDTO.getId());
            pstmt.setString(3, boardDTO.getName());
            pstmt.setString(4, boardDTO.getEmail());
            pstmt.setString(5, boardDTO.getSubject());
            pstmt.setString(6, boardDTO.getContent());
            pstmt.setInt(7, boardDTO.getRef());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt);
        }
    }

    // 게시글 목록 가져오기
    public List<BoardDTO> getBoardList() {
        List<BoardDTO> boardList = new ArrayList<BoardDTO>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM board ORDER BY seq DESC";

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
                boardDTO.setHit(rs.getInt("hit"));
                boardDTO.setLogtime(rs.getString("logtime"));

                boardList.add(boardDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt, rs);
        }

        return boardList;
    }
    
 // 특정 게시글을 가져오는 메서드
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
                boardDTO.setHit(rs.getInt("hit"));
                boardDTO.setLogtime(rs.getString("logtime"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt, rs);
        }

        return boardDTO;
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
