package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;  // Timestamp를 import합니다.
import board.bean.BoardDTO;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
    // Singleton 패턴을 사용하여 인스턴스를 한 번만 생성
    private static BoardDAO instance = new BoardDAO();
    private DataSource ds; // 커넥션 풀을 통해 데이터베이스 연결을 관리하는 DataSource 객체

    // 생성자에서 DataSource 설정
    // BoardDAO 생성자는 JNDI를 통해 DataSource를 찾아 데이터베이스 연결을 관리합니다.
    private BoardDAO() {
        try {
            Context init = new InitialContext();  // JNDI 초기화
            ds = (DataSource) init.lookup("java:comp/env/jdbc/oracle");  // "java:comp/env/jdbc/oracle"이라는 이름의 DataSource를 찾아서 설정
        } catch (Exception e) {
            e.printStackTrace();  // 예외 발생 시 스택 트레이스 출력
        }
    }

    // Singleton 패턴으로 인스턴스를 반환하는 메서드
    public static BoardDAO getInstance() {
        return instance;
    }

    // 시퀀스 값 얻어오기 - 게시글 번호를 자동으로 증가시킴
    // 시퀀스는 데이터베이스에서 게시글 번호를 자동으로 증가시키는 데 사용됩니다.
    public int getNextSeq() {
        int seq = 0;  // 시퀀스 값을 저장할 변수
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT seq_board.NEXTVAL FROM dual";  // 시퀀스를 가져오는 SQL 쿼리

        try {
            conn = ds.getConnection();  // 커넥션 풀에서 커넥션을 가져옵니다.
            pstmt = conn.prepareStatement(sql);  // SQL 쿼리를 준비
            rs = pstmt.executeQuery();  // 쿼리를 실행하여 결과를 가져옵니다.
            if (rs.next()) {
                seq = rs.getInt(1);  // 결과값을 seq 변수에 저장
            }
        } catch (SQLException e) {
            e.printStackTrace();  // SQL 예외 발생 시 출력
        } finally {
            close(conn, pstmt, rs);  // 사용한 리소스들을 닫음
        }

        return seq;  // 시퀀스 값을 반환
    }

    // 게시글 저장 메서드 - 새로운 게시글을 데이터베이스에 저장
    // 이 메서드는 BoardDTO 객체에 담긴 데이터를 이용해 새로운 게시글을 데이터베이스에 삽입합니다.
    public void insertBoard(BoardDTO boardDTO) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        // 게시글을 삽입하는 SQL 쿼리
        String sql = "INSERT INTO board (seq, id, name, email, subject, content, ref, lev, step, pseq, reply, hit, logtime) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, 0, 0, 0, 0, 0, SYSDATE)";  // 조회수(hit), 답글수(reply) 등의 기본값은 0으로 설정

        try {
            conn = ds.getConnection();  // 커넥션 풀에서 커넥션을 가져옴
            pstmt = conn.prepareStatement(sql);  // SQL 쿼리 준비
            pstmt.setInt(1, boardDTO.getSeq());  // 시퀀스 값 설정
            pstmt.setString(2, boardDTO.getId());  // 작성자 ID
            pstmt.setString(3, boardDTO.getName());  // 작성자 이름
            pstmt.setString(4, boardDTO.getEmail());  // 작성자 이메일
            pstmt.setString(5, boardDTO.getSubject());  // 게시글 제목
            pstmt.setString(6, boardDTO.getContent());  // 게시글 내용
            pstmt.setInt(7, boardDTO.getRef());  // 그룹번호 (답글 등 같은 그룹으로 묶일 게시글의 그룹 번호)

            pstmt.executeUpdate();  // SQL 실행하여 데이터베이스에 삽입
        } catch (SQLException e) {
            e.printStackTrace();  // SQL 예외 발생 시 출력
        } finally {
            close(conn, pstmt);  // 리소스 닫기
        }
    }

    // 게시글 목록을 가져오는 메서드 - 모든 게시글을 가져와 목록으로 반환
    // 이 메서드는 게시글을 최신순으로 정렬하여 데이터베이스에서 가져옵니다.
    public List<BoardDTO> getBoardList() {
        List<BoardDTO> boardList = new ArrayList<>();  // 게시글 목록을 저장할 리스트
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM board ORDER BY seq DESC";  // 게시글을 최신순으로 정렬하여 가져오는 SQL

        try {
            conn = ds.getConnection();  // 커넥션 풀에서 커넥션을 가져옴
            pstmt = conn.prepareStatement(sql);  // SQL 쿼리 준비
            rs = pstmt.executeQuery();  // SQL 쿼리 실행 후 결과를 ResultSet으로 받아옴

            while (rs.next()) {  // 결과 집합을 순회
                BoardDTO boardDTO = new BoardDTO();  // 새로운 BoardDTO 객체 생성
                boardDTO.setSeq(rs.getInt("seq"));  // 시퀀스 값 설정
                boardDTO.setId(rs.getString("id"));  // 작성자 ID 설정
                boardDTO.setName(rs.getString("name"));  // 작성자 이름 설정
                boardDTO.setEmail(rs.getString("email"));  // 작성자 이메일 설정
                boardDTO.setSubject(rs.getString("subject"));  // 게시글 제목 설정
                boardDTO.setContent(rs.getString("content"));  // 게시글 내용 설정
                boardDTO.setRef(rs.getInt("ref"));  // 그룹번호 설정
                boardDTO.setLev(rs.getInt("lev"));  // 답글 단계 설정
                boardDTO.setStep(rs.getInt("step"));  // 글 순서 설정
                boardDTO.setPseq(rs.getInt("pseq"));  // 원글 번호 설정
                boardDTO.setReply(rs.getInt("reply"));  // 답글 수 설정
                boardDTO.setHit(rs.getInt("hit"));  // 조회수 설정
                // logtime을 Timestamp로 받아 Date로 변환하여 설정
                Timestamp timestamp = rs.getTimestamp("logtime");
                if (timestamp != null) {
                    boardDTO.setLogtime(new java.util.Date(timestamp.getTime()));  // Timestamp를 Date로 변환하여 설정
                }

                boardList.add(boardDTO);  // 리스트에 추가
            }
        } catch (SQLException e) {
            e.printStackTrace();  // SQL 예외 발생 시 출력
        } finally {
            close(conn, pstmt, rs);  // 리소스 닫기
        }

        return boardList;  // 게시글 목록 반환
    }

    // 특정 게시글을 가져오는 메서드 - 게시글 번호(seq)로 게시글을 조회
    // 이 메서드는 특정 시퀀스 번호를 통해 해당 게시글을 조회하여 반환합니다.
    public BoardDTO getBoard(int seq) {
        BoardDTO boardDTO = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM board WHERE seq = ?";  // 특정 시퀀스 번호에 해당하는 게시글을 가져오는 SQL

        try {
            conn = ds.getConnection();  // 커넥션 풀에서 커넥션을 가져옴
            pstmt = conn.prepareStatement(sql);  // SQL 쿼리 준비
            pstmt.setInt(1, seq);  // 게시글 번호 설정
            rs = pstmt.executeQuery();  // SQL 쿼리 실행 후 결과를 ResultSet으로 받아옴

            if (rs.next()) {  // 결과가 있을 경우
                boardDTO = new BoardDTO();  // 새로운 BoardDTO 객체 생성
                boardDTO.setSeq(rs.getInt("seq"));  // 시퀀스 값 설정
                boardDTO.setId(rs.getString("id"));  // 작성자 ID 설정
                boardDTO.setName(rs.getString("name"));  // 작성자 이름 설정
                boardDTO.setEmail(rs.getString("email"));  // 작성자 이메일 설정
                boardDTO.setSubject(rs.getString("subject"));  // 게시글 제목 설정
                boardDTO.setContent(rs.getString("content"));  // 게시글 내용 설정
                boardDTO.setRef(rs.getInt("ref"));  // 그룹번호 설정
                boardDTO.setLev(rs.getInt("lev"));  // 답글 단계 설정
                boardDTO.setStep(rs.getInt("step"));  // 글 순서 설정
                boardDTO.setPseq(rs.getInt("pseq"));  // 원글 번호 설정
                boardDTO.setReply(rs.getInt("reply"));  // 답글 수 설정
                boardDTO.setHit(rs.getInt("hit"));  // 조회수 설정
                // logtime을 Timestamp로 받아 Date로 변환하여 설정
                Timestamp timestamp = rs.getTimestamp("logtime");
                if (timestamp != null) {
                    boardDTO.setLogtime(new java.util.Date(timestamp.getTime()));  // Timestamp를 Date로 변환하여 설정
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();  // SQL 예외 발생 시 출력
        } finally {
            close(conn, pstmt, rs);  // 리소스 닫기
        }

        return boardDTO;  // 특정 게시글 반환
    }

    // 조회수 증가 메서드 - 특정 게시글의 조회수를 1 증가시킴
    // 이 메서드는 게시글을 조회할 때 조회수를 증가시키는 역할을 합니다.
    public void increaseHit(int seq) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "UPDATE board SET hit = hit + 1 WHERE seq = ?";  // 조회수를 1 증가시키는 SQL

        try {
            conn = ds.getConnection();  // 커넥션 풀에서 커넥션을 가져옴
            pstmt = conn.prepareStatement(sql);  // SQL 쿼리 준비
            pstmt.setInt(1, seq);  // 조회수를 증가시킬 게시글 번호 설정
            pstmt.executeUpdate();  // 쿼리 실행
        } catch (SQLException e) {
            e.printStackTrace();  // SQL 예외 발생 시 출력
        } finally {
            close(conn, pstmt);  // 리소스 닫기
        }
    }

    // 게시글 총 개수 가져오기
    // 이 메서드는 데이터베이스에 저장된 총 게시글 수를 반환합니다.
    public int getTotalPosts() {
        int totalPosts = 0;
        String sql = "SELECT COUNT(*) FROM board";  // 게시글 총 개수를 가져오는 SQL

        try (Connection conn = ds.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                totalPosts = rs.getInt(1);  // 결과값을 totalPosts에 저장
            }
        } catch (SQLException e) {
            e.printStackTrace();  // SQL 예외 발생 시 출력
        }
        return totalPosts;  // 총 게시글 수 반환
    }

    // 페이징 처리된 게시글 목록 가져오기
    // 이 메서드는 특정 페이지에 해당하는 게시글만을 가져오기 위해 페이징 처리를 합니다.
    public List<BoardDTO> getBoardListByPage(int currentPage, int postsPerPage) {
        List<BoardDTO> boardList = new ArrayList<>();  // 게시글 목록을 저장할 리스트
        String sql = "SELECT * FROM ( " +
                     "  SELECT rownum AS rnum, a.* FROM ( " +
                     "    SELECT * FROM board ORDER BY seq DESC " +
                     "  ) a WHERE rownum <= ? " +
                     ") WHERE rnum >= ?";  // rownum을 사용하여 페이징 처리

        int startRow = (currentPage - 1) * postsPerPage + 1;  // 시작 글 번호 계산
        int endRow = currentPage * postsPerPage;  // 마지막 글 번호 계산

        try (Connection conn = ds.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, endRow);  // 마지막 글 번호 설정
            pstmt.setInt(2, startRow);  // 시작 글 번호 설정
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    BoardDTO board = new BoardDTO();  // 새로운 BoardDTO 객체 생성
                    board.setSeq(rs.getInt("seq"));  // 시퀀스 값 설정
                    board.setSubject(rs.getString("subject"));  // 게시글 제목 설정
                    board.setName(rs.getString("name"));  // 작성자 이름 설정
                    // logtime을 Timestamp로 받아 Date로 변환하여 설정
                    Timestamp timestamp = rs.getTimestamp("logtime");
                    if (timestamp != null) {
                        board.setLogtime(new java.util.Date(timestamp.getTime()));  // Timestamp를 Date로 변환하여 설정
                    }
                    board.setHit(rs.getInt("hit"));  // 조회수 설정
                    boardList.add(board);  // 리스트에 추가
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();  // SQL 예외 발생 시 출력
        }
        return boardList;  // 페이징 처리된 게시글 목록 반환
    }

    // 리소스 반환 메서드
    // 이 메서드는 사용한 커넥션, PreparedStatement, ResultSet을 닫는 역할을 합니다.
    private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();  // ResultSet 닫기
            if (pstmt != null) pstmt.close();  // PreparedStatement 닫기
            if (conn != null) conn.close();  // Connection 닫기
        } catch (SQLException e) {
            e.printStackTrace();  // SQL 예외 발생 시 출력
        }
    }

    // PreparedStatement와 Connection만을 닫는 메서드 (ResultSet이 필요하지 않을 때 사용)
    private void close(Connection conn, PreparedStatement pstmt) {
        try {
            if (pstmt != null) pstmt.close();  // PreparedStatement 닫기
            if (conn != null) conn.close();  // Connection 닫기
        } catch (SQLException e) {
            e.printStackTrace();  // SQL 예외 발생 시 출력
        }
    }
}
