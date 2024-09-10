package board.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.bean.BoardDTO;

public class BoardDAO {
    private static BoardDAO boardDAO = new BoardDAO();
    private SqlSessionFactory sqlSessionFactory;

    // 생성자에서 MyBatis 설정 파일을 읽고 SqlSessionFactory를 초기화합니다.
    public BoardDAO() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 싱글톤 패턴을 이용한 getInstance 메서드
    public static BoardDAO getInstance() {
        return boardDAO;
    }

    // 전체 게시글 수 가져오기
    public int getTotalPosts() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int totalPosts = 0;
        try {
            totalPosts = sqlSession.selectOne("boardSQL.getTotalPosts");
        } finally {
            sqlSession.close();
        }
        return totalPosts;
    }

    // 페이징 처리된 게시글 목록 가져오기
    public List<BoardDTO> getBoardListByPage(int startNum, int endNum) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<BoardDTO> list = null;
        try {
            Map<String, Integer> map = Map.of("startNum", startNum, "endNum", endNum);
            list = sqlSession.selectList("boardSQL.getBoardListByPage", map);
        } finally {
            sqlSession.close();
        }
        return list;
    }

    // 특정 게시글 조회하기
    public BoardDTO getBoard(int seq) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BoardDTO boardDTO = null;
        try {
            boardDTO = sqlSession.selectOne("boardSQL.getBoard", seq);
        } finally {
            sqlSession.close();
        }
        return boardDTO;
    }

    // 조회수 증가 메서드
    public void increaseHit(int seq) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.update("boardSQL.increaseHit", seq);  // 조회수를 1 증가시키는 쿼리 실행
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    // 게시글 저장 (작성)
    public void insertBoard(BoardDTO boardDTO) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("boardSQL.insertBoard", boardDTO);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    // 게시글 수정
    public void updateBoard(BoardDTO boardDTO) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.update("boardSQL.updateBoard", boardDTO);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    // 게시글 삭제
    public void deleteBoard(int seq) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("boardSQL.deleteBoard", seq);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    // 시퀀스를 통해 다음 글 번호 가져오기
    public int getNextSeq() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int seq = 0;
        try {
            seq = sqlSession.selectOne("boardSQL.getNextSeq");
        } finally {
            sqlSession.close();
        }
        return seq;
    }
}
