package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import board.bean.BoardDTO;

public class BoardDAO {
    
    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String user = "C##java";
    private String pwd = "1234";
    
    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;
    
    // BoardDAO 생성자
    public BoardDAO() {
        try {
            // Oracle JDBC 드라이버 로드
            Class.forName(driver);
            // 데이터베이스 연결
            con = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스를 출력
        }
    }

 // 글 작성 메서드
    public void write(BoardDTO boardDTO) {
        // SQL 문을 여러 줄로 나누어 가독성을 높임
        String sql = "INSERT INTO board_java (seq, id, name, subject, content, logtime) " +
                     "VALUES (board_java_seq.NEXTVAL, ?, ?, ?, ?, SYSDATE)";
         try {
            pstmt = con.prepareStatement(sql);
            // PreparedStatement에 값 설정
            pstmt.setString(1, boardDTO.getId()); // 아이디 설정
            pstmt.setString(2, boardDTO.getName()); // 이름 설정
            pstmt.setString(3, boardDTO.getSubject()); // 제목 설정
            pstmt.setString(4, boardDTO.getContent()); // 내용 설정
            pstmt.executeUpdate(); // SQL 문 실행
        } catch (SQLException e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스를 출력
        } finally {
            // PreparedStatement 닫기
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace(); // 예외 발생 시 스택 트레이스를 출력
            }
        }
    }

    // 글 목록 가져오기 메서드
    public List<BoardDTO> list() {
        List<BoardDTO> list = new ArrayList<>(); // 결과를 저장할 리스트
        String sql = "SELECT * FROM board_java ORDER BY seq DESC";
         try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery(); // SQL 문 실행 및 결과 받기
            while (rs.next()) { // 결과 집합을 순회
                BoardDTO boardDTO = new BoardDTO();
                // 결과 집합에서 값 추출 및 DTO에 설정
                boardDTO.setSeq(rs.getInt("seq")); // 글번호 설정
                boardDTO.setId(rs.getString("id")); // 아이디 설정
                boardDTO.setName(rs.getString("name")); // 이름 설정
                boardDTO.setSubject(rs.getString("subject")); // 제목 설정
                boardDTO.setContent(rs.getString("content")); // 내용 설정
                boardDTO.setLogtime(rs.getDate("logtime")); // 날짜 설정
                list.add(boardDTO); // 리스트에 DTO 추가
            }
        } catch (SQLException e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스를 출력
        } finally {
            // ResultSet 닫기
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace(); // 예외 발생 시 스택 트레이스를 출력
            }
            // PreparedStatement 닫기
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace(); // 예외 발생 시 스택 트레이스를 출력
            }
        }
        return list; // 결과 리스트 반환
    }

    // 특정 글 내용 가져오기 메서드
    public BoardDTO view(int seq) {
        BoardDTO boardDTO = null; // 결과를 저장할 DTO
        String sql = "SELECT * FROM board_java WHERE seq = ?";
         try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, seq); // 글번호 설정
            rs = pstmt.executeQuery(); // SQL 문 실행 및 결과 받기
            if (rs.next()) { // 결과가 있는 경우
                boardDTO = new BoardDTO();
                // 결과 집합에서 값 추출 및 DTO에 설정
                boardDTO.setSeq(rs.getInt("seq")); // 글번호 설정
                boardDTO.setId(rs.getString("id")); // 아이디 설정
                boardDTO.setName(rs.getString("name")); // 이름 설정
                boardDTO.setSubject(rs.getString("subject")); // 제목 설정
                boardDTO.setContent(rs.getString("content")); // 내용 설정
                boardDTO.setLogtime(rs.getDate("logtime")); // 날짜 설정
            }
        } catch (SQLException e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스를 출력
        } finally {
            // ResultSet 닫기
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace(); // 예외 발생 시 스택 트레이스를 출력
            }
            // PreparedStatement 닫기
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace(); // 예외 발생 시 스택 트레이스를 출력
            }
        }
        return boardDTO; // 결과 DTO 반환
    }
}

