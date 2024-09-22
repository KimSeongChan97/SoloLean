// FilmNote/src/main/java/movie.dao.MovieDAO.java
package movie.dao;

import movie.bean.MovieDTO;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MovieDAO {

	// 싱글톤 인스턴스 생성
	private static MovieDAO instance = new MovieDAO();
	private SqlSessionFactory sqlSessionFactory;
    
	public static MovieDAO getInstance() {
		return instance;
	}
	
	public MovieDAO() { // Driver Loading
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
    /** movieWrite.jsp */
	// 영화 추가
	
	
	
	
	/** movieBoard.jsp */
	// 영화 목록
	
	// 영화 개수
	public int getTotalA() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int totalA = 0;      
		totalA = sqlSession.selectOne("boardSQL.getTotalA");        
		sqlSession.close();       
		return totalA;
	}
	
	
	
	/** movieView.jsp */
	// 영화 조회
	public MovieDTO getBoard(int seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MovieDTO boardDTO = sqlSession.selectOne("boardSQL.getBoard", seq);
		sqlSession.close();
		return boardDTO;
	}
	
	
	
	
}
