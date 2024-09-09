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
    // 이 생성자는 웹 애플리케이션에서 미리 설정된 데이터베이스 연결 풀(DataSource)에서 커넥션을 가져오도록 설정합니다.
    // 이렇게 하면 매번 데이터베이스 연결을 새로 만드는 대신, 이미 생성된 커넥션 풀을 재사용할 수 있어 성능이 향상됩니다.
    private BoardDAO() {
        try {
            Context init = new InitialContext();
            // 'java:comp/env/jdbc/oracle'로 설정된 데이터베이스 리소스를 찾습니다.
            // 이는 Tomcat 서버나 다른 애플리케이션 서버에서 설정된 자원입니다.
            ds = (DataSource) init.lookup("java:comp/env/jdbc/oracle");
        } catch (Exception e) {
            // 예외가 발생하면 그 스택 추적 정보를 출력합니다.
            e.printStackTrace();
        }
    }

    // Singleton 패턴을 통해 객체를 한 번만 생성하여 사용
    // Singleton 패턴은 하나의 클래스에 대해 인스턴스가 오직 하나만 생성되도록 보장합니다.
    // 여기서는 BoardDAO 인스턴스를 하나만 만들어서 이를 여러 곳에서 공유해 사용할 수 있게 됩니다.
    public static BoardDAO getInstance() {
        return instance;
    }

    // 시퀀스 값 얻어오기 - 게시글 번호를 자동으로 증가시킴
    // 데이터베이스에서 게시글 번호는 자동으로 증가하는 시퀀스 값입니다.
    // 이 메서드는 새 게시글을 추가할 때 사용할 시퀀스 값을 미리 가져옵니다.
    public int getNextSeq() {
        int seq = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT seq_board.NEXTVAL FROM dual"; // 'dual'은 Oracle에서 기본 제공하는 더미 테이블로, 여기서 시퀀스를 얻어옵니다.

        try {
            conn = ds.getConnection(); // 커넥션 풀에서 연결을 가져옵니다.
            pstmt = conn.prepareStatement(sql); // SQL 쿼리를 준비합니다.
            rs = pstmt.executeQuery(); // 쿼리를 실행하고 결과를 가져옵니다.
            if (rs.next()) {
                seq = rs.getInt(1); // 첫 번째 컬럼(시퀀스 값)을 int로 가져옵니다.
            }
        } catch (SQLException e) {
            e.printStackTrace(); // SQL 오류가 발생하면 출력
        } finally {
            // 커넥션과 관련된 리소스들을 닫습니다. 리소스를 닫지 않으면 메모리 누수가 발생할 수 있습니다.
            close(conn, pstmt, rs);
        }

        return seq; // 가져온 시퀀스 값을 반환합니다.
    }

    // 게시글 저장 메서드 - 새로운 게시글을 데이터베이스에 저장
    // 이 메서드는 새로운 게시글을 데이터베이스에 삽입하는 역할을 합니다.
    public void insertBoard(BoardDTO boardDTO) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        // SQL 문을 정의합니다. SYSDATE는 게시글이 저장되는 현재 시간을 자동으로 입력해줍니다.
        String sql = "INSERT INTO board (seq, id, name, email, subject, content, ref, lev, step, pseq, reply, hit, logtime) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, 0, 0, 0, 0, 0, SYSDATE)"; // 조회수(hit)는 기본값 0으로 설정됨

        try {
            conn = ds.getConnection(); // 커넥션 풀에서 연결을 가져옵니다.
            pstmt = conn.prepareStatement(sql); // SQL 쿼리를 준비합니다.
            // 각각의 ? 자리에 BoardDTO에서 가져온 데이터를 설정합니다.
            pstmt.setInt(1, boardDTO.getSeq()); // 시퀀스 값 설정
            pstmt.setString(2, boardDTO.getId()); // 작성자 ID
            pstmt.setString(3, boardDTO.getName()); // 작성자 이름
            pstmt.setString(4, boardDTO.getEmail()); // 작성자 이메일
            pstmt.setString(5, boardDTO.getSubject()); // 제목
            pstmt.setString(6, boardDTO.getContent()); // 내용
            pstmt.setInt(7, boardDTO.getRef()); // 그룹번호 설정 (댓글 같은 경우를 위한 번호)

            pstmt.executeUpdate(); // 쿼리를 실행하여 데이터를 삽입합니다.
        } catch (SQLException e) {
            e.printStackTrace(); // SQL 오류가 발생하면 출력
        } finally {
            close(conn, pstmt); // 리소스를 닫습니다.
        }
    }

    // 게시글 목록을 가져오는 메서드 - 모든 게시글을 가져와 목록으로 반환
    // 이 메서드는 데이터베이스에서 모든 게시글을 최신 순서로 가져와서 반환하는 역할을 합니다.
    public List<BoardDTO> getBoardList() {
        List<BoardDTO> boardList = new ArrayList<BoardDTO>(); // 게시글 목록을 담을 리스트 생성
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM board ORDER BY seq DESC"; // 게시글을 최신순으로 정렬

        try {
            conn = ds.getConnection(); // 커넥션 풀에서 연결을 가져옵니다.
            pstmt = conn.prepareStatement(sql); // SQL 쿼리를 준비합니다.
            rs = pstmt.executeQuery(); // 쿼리를 실행하고 결과를 가져옵니다.

            while (rs.next()) {
                BoardDTO boardDTO = new BoardDTO(); // 각 행의 데이터를 저장할 DTO 객체 생성
                // ResultSet에서 각각의 컬럼 값을 가져와 BoardDTO에 설정합니다.
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
                boardDTO.setLogtime(rs.getString("logtime"));  // String으로 변환하여 처리

                boardList.add(boardDTO); // 리스트에 DTO 객체 추가
            }
        } catch (SQLException e) {
            e.printStackTrace(); // SQL 오류가 발생하면 출력
        } finally {
            close(conn, pstmt, rs); // 리소스를 닫습니다.
        }

        return boardList; // 게시글 목록을 반환합니다.
    }

    // 특정 게시글을 가져오는 메서드 - 게시글 번호(seq)로 게시글을 조회
    // 이 메서드는 특정 게시글 번호를 기반으로 해당 게시글의 정보를 가져옵니다.
    public BoardDTO getBoard(int seq) {
        BoardDTO boardDTO = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM board WHERE seq = ?"; // 게시글 번호로 해당 게시글을 조회하는 쿼리

        try {
            conn = ds.getConnection(); // 커넥션 풀에서 연결을 가져옵니다.
            pstmt = conn.prepareStatement(sql); // SQL 쿼리를 준비합니다.
            pstmt.setInt(1, seq); // 쿼리의 첫 번째 ? 자리에 게시글 번호를 설정
            rs = pstmt.executeQuery(); // 쿼리를 실행하고 결과를 가져옵니다.

            if (rs.next()) {
                boardDTO = new BoardDTO(); // DTO 객체를 생성하여 결과를 담습니다.
                // ResultSet에서 데이터를 가져와 DTO에 설정
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
                boardDTO.setLogtime(rs.getString("logtime"));  // String으로 변환하여 처리
            }
        } catch (SQLException e) {
            e.printStackTrace(); // SQL 오류가 발생하면 출력
        } finally {
            close(conn, pstmt, rs); // 리소스를 닫습니다.
        }

        return boardDTO; // 게시글 정보를 담은 DTO 객체를 반환
    }

    // 조회수를 증가시키는 메서드 - 특정 게시글의 조회수를 1 증가시킴
    // 이 메서드는 특정 게시글을 조회할 때, 조회수를 1 증가시킵니다.
    public void increaseHit(int seq) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "UPDATE board SET hit = hit + 1 WHERE seq = ?"; // 조회수를 1 증가시키는 SQL

        try {
            conn = ds.getConnection(); // 커넥션 풀에서 연결을 가져옵니다.
            pstmt = conn.prepareStatement(sql); // SQL 쿼리를 준비합니다.
            pstmt.setInt(1, seq); // 쿼리의 첫 번째 ? 자리에 게시글 번호를 설정
            pstmt.executeUpdate(); // 쿼리를 실행합니다.
        } catch (SQLException e) {
            e.printStackTrace(); // SQL 오류가 발생하면 출력
        } finally {
            close(conn, pstmt); // 리소스를 닫습니다.
        }
    }

    // 게시글 총 개수 가져오기
    // 이 메서드는 데이터베이스에서 현재 등록된 게시글의 총 개수를 가져옵니다.
    public int getTotalPosts() {
        int totalPosts = 0; // 총 게시글 수를 저장할 변수
        String sql = "SELECT COUNT(*) FROM board"; // 게시글 총 개수를 세는 SQL

        try (Connection conn = ds.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                totalPosts = rs.getInt(1); // 첫 번째 컬럼의 값을 가져와 총 게시글 수를 설정
            }
        } catch (SQLException e) {
            e.printStackTrace(); // SQL 오류가 발생하면 출력
        }
        return totalPosts; // 총 게시글 수 반환
    }

    // 페이징 처리된 게시글 목록 가져오기
    // 이 메서드는 특정 페이지에 해당하는 게시글만을 가져오기 위한 페이징 처리된 목록을 반환합니다.
    public List<BoardDTO> getBoardListByPage(int currentPage, int postsPerPage) {
        List<BoardDTO> boardList = new ArrayList<>();
        // 서브쿼리를 이용하여 rownum을 기반으로 특정 범위의 게시글만 가져오는 쿼리
        String sql = "SELECT * FROM ( " +
                     "  SELECT rownum AS rnum, a.* FROM ( " +
                     "    SELECT * FROM board ORDER BY seq DESC " +
                     "  ) a WHERE rownum <= ? " +
                     ") WHERE rnum >= ?";

        int startRow = (currentPage - 1) * postsPerPage + 1; // 현재 페이지의 첫 번째 글 번호
        int endRow = currentPage * postsPerPage; // 현재 페이지의 마지막 글 번호

        try (Connection conn = ds.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, endRow); // ? 자리에 마지막 글 번호 설정
            pstmt.setInt(2, startRow); // ? 자리에 첫 번째 글 번호 설정
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    BoardDTO board = new BoardDTO(); // DTO 객체를 생성하여 데이터를 담음
                    board.setSeq(rs.getInt("seq"));
                    board.setSubject(rs.getString("subject"));
                    board.setName(rs.getString("name"));
                    board.setLogtime(rs.getString("logtime"));  // String으로 변환하여 처리
                    board.setHit(rs.getInt("hit"));
                    boardList.add(board); // 리스트에 DTO 객체 추가
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // SQL 오류가 발생하면 출력
        }
        return boardList; // 페이징 처리된 게시글 목록 반환
    }

    // 리소스 반환 메서드
    // 데이터베이스와의 연결을 닫는 역할을 합니다. 연결을 닫지 않으면 메모리 누수나 커넥션 풀 고갈 문제가 발생할 수 있습니다.
    private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) rs.close(); // ResultSet이 존재하면 닫습니다.
            if (pstmt != null) pstmt.close(); // PreparedStatement가 존재하면 닫습니다.
            if (conn != null) conn.close(); // Connection이 존재하면 닫습니다.
        } catch (SQLException e) {
            e.printStackTrace(); // SQL 오류가 발생하면 출력
        }
    }

    // PreparedStatement와 Connection만을 닫는 메서드 (ResultSet이 필요하지 않을 때 사용)
    private void close(Connection conn, PreparedStatement pstmt) {
        try {
            if (pstmt != null) pstmt.close(); // PreparedStatement가 존재하면 닫습니다.
            if (conn != null) conn.close(); // Connection이 존재하면 닫습니다.
        } catch (SQLException e) {
            e.printStackTrace(); // SQL 오류가 발생하면 출력
        }
    }
}
