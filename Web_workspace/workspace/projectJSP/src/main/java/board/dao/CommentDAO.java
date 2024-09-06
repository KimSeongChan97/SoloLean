package board.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CommentDAO {

    private static CommentDAO instance;  // CommentDAO 클래스의 단일 인스턴스를 저장하기 위한 변수입니다.
    private DataSource ds;  // 데이터베이스 연결을 위한 DataSource 객체를 저장하는 변수입니다. DataSource는 커넥션 풀을 통해 효율적으로 DB 연결을 관리합니다.

    // CommentDAO 생성자, 외부에서 직접 호출할 수 없도록 private으로 설정되어 있습니다.
    private CommentDAO() {
        try {
            // InitialContext는 JNDI(Java Naming and Directory Interface)를 사용하여 리소스를 검색하는 데 사용됩니다.
            InitialContext ic = new InitialContext();  // 리소스 검색을 위한 JNDI 초기화 객체입니다.
            ds = (DataSource) ic.lookup("java:comp/env/jdbc/oracle");  // context.xml에 설정된 jdbc/oracle 리소스를 검색하여 DataSource 객체를 가져옵니다.
        } catch (Exception e) {
            e.printStackTrace();  // 예외 발생 시 오류 메시지를 출력합니다.
        }
    }

    // CommentDAO의 단일 인스턴스를 가져오는 메서드입니다.
    public static CommentDAO getInstance() {
        if (instance == null) {  // 인스턴스가 아직 생성되지 않았으면 새로 생성합니다.
            instance = new CommentDAO();  // 클래스의 단일 인스턴스를 생성하여 반환합니다.
        }
        return instance;  // 이미 생성된 인스턴스가 있으면 그것을 반환합니다.
    }

    // 댓글 목록 가져오기
    public List<String[]> getCommentsByBoardSeq(int boardSeq) {
        // 댓글 데이터를 저장할 리스트를 생성합니다. 각 댓글은 작성자 이름(name)과 내용(content)을 문자열 배열로 저장합니다.
        List<String[]> comments = new ArrayList<>();
        
        // SQL 쿼리: 특정 게시글 번호(boardSeq)에 해당하는 댓글을 가져옵니다. 댓글은 comment_id 기준으로 오름차순으로 정렬됩니다.
        String sql = "SELECT name, content FROM comments WHERE boardSeq = ? ORDER BY comment_id ASC";

        // try-with-resources 구문을 사용하여 자원(Connection, PreparedStatement, ResultSet)을 자동으로 해제합니다.
        try (Connection conn = ds.getConnection();  // 커넥션 풀에서 데이터베이스 연결 객체를 가져옵니다.
             PreparedStatement pstmt = conn.prepareStatement(sql)) {  // SQL 쿼리를 준비하고, PreparedStatement 객체를 생성합니다.
            
            pstmt.setInt(1, boardSeq);  // SQL 쿼리의 첫 번째 매개변수로 게시글 번호(boardSeq)를 설정합니다.
            
            // ResultSet을 통해 SQL 쿼리 결과를 가져옵니다.
            try (ResultSet rs = pstmt.executeQuery()) {
                // 쿼리 결과(ResultSet)의 각 행을 순회하면서 댓글 작성자 이름과 댓글 내용을 리스트에 추가합니다.
                while (rs.next()) {
                    String name = rs.getString("name");  // 현재 행에서 댓글 작성자의 이름을 가져옵니다.
                    String content = rs.getString("content");  // 현재 행에서 댓글 내용을 가져옵니다.
                    comments.add(new String[] { name, content });  // 이름과 내용을 배열로 묶어서 리스트에 추가합니다.
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();  // 예외 발생 시 SQLException 메시지를 출력합니다.
        }

        return comments;  // 댓글 목록을 반환합니다.
    }
}
