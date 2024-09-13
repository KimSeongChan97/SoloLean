package board.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.bean.CommentDTO;

public class CommentDAO {
    // 싱글톤 인스턴스 생성
    private static CommentDAO commentDAO = new CommentDAO();

    // MyBatis에서 SQL 세션을 생성하고 관리하는 SqlSessionFactory 객체
    private SqlSessionFactory sqlSessionFactory;

    // 생성자
    public CommentDAO() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 싱글톤 인스턴스를 반환하는 메소드
    public static CommentDAO getInstance() {
        return commentDAO;
    }

    // 댓글을 추가하는 메소드
    public void addComment(CommentDTO commentDTO) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("commentSQL.addComment", commentDTO);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

 // 댓글 목록 가져오기 (String 배열로 반환)
    public List<String[]> getCommentsByBoardSeq(int boardSeq) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<String[]> result = new ArrayList<>(); // 결과를 저장할 리스트 생성
        try {
            // MyBatis 쿼리 실행, boardSeq에 해당하는 댓글 목록 가져오기
            List<CommentDTO> comments = sqlSession.selectList("commentSQL.getCommentsByBoardSeq", boardSeq);

            // CommentDTO 리스트를 String[] 리스트로 변환
            for (CommentDTO comment : comments) {
                String[] commentArray = new String[2];
                commentArray[0] = comment.getName();   // 댓글 작성자 이름
                commentArray[1] = comment.getContent(); // 댓글 내용
                result.add(commentArray);               // 변환한 String[]을 리스트에 추가
            }
        } finally {
            sqlSession.close();
        }
        return result; // String[] 리스트 반환
    }



    // 댓글을 수정하는 메소드
    public void updateComment(CommentDTO commentDTO) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.update("commentSQL.updateComment", commentDTO);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    // 댓글을 삭제하는 메소드
    public void deleteComment(int commentSeq) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("commentSQL.deleteComment", commentSeq);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
}
