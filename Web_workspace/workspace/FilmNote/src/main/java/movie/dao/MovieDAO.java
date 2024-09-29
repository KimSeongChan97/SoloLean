// FilmNote/src/main/java/movie.dao.MovieDAO.java
package movie.dao;

import movie.bean.MovieDTO;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
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
	// 영화 등록
	public void writeMovie(MovieDTO movieDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("movieSQL.writeMovie", movieDTO);
        sqlSession.commit();
        sqlSession.close();		
	}

	
	/** movieList.jsp */
	// 영화 개수
	public int getTotalA() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int totalA = 0;      
		totalA = sqlSession.selectOne("movieSQL.getTotalA");        
		sqlSession.close();    
		
		return totalA;
	}
	
	// 영화 목록
	public List<MovieDTO> movieList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);

		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<MovieDTO> list = sqlSession.selectList("movieSQL.movieList", map);
		sqlSession.close();

		return list;
		
	}	
	
	
    // 검색된 총 영화 개수 반환
    public int getSelectTotal(String value, String type) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        HashMap<String, String> data = new HashMap<>();
        data.put("type", type);
        data.put("value", value);
        
        int selectTotal = sqlSession.selectOne("movieSQL.getSelectTotal", data);
        sqlSession.close();
        
        return selectTotal;
    }
	
	// 영화 검색 목록
	public List<MovieDTO> selectMovie(String value, String type, int startNum, int endNum) {
	    SqlSession sqlSession = sqlSessionFactory.openSession();
	    Map<String, Object> map = new HashMap<>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);	    
	    map.put("type",type);
	    map.put("value",value);
	    
	    List<MovieDTO> list = sqlSession.selectList("movieSQL.selectMovie", map);
	    sqlSession.close();
	    return list;		
	}	
	
	/** movieView.jsp */
	// 영화 조회
	public MovieDTO getMovie(int mcode) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MovieDTO movieDTO = sqlSession.selectOne("movieSQL.getMovie", mcode);
		sqlSession.close();
		return movieDTO;
	}

	// 영화 평점 업데이트: 리뷰 추가 및 수정 시 호출
	public void updateMovieScore(int mcode) {
		System.out.println("updateMovieScore(" + mcode + ") 호출");
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("movieSQL.updateMovieScore", mcode);
		sqlSession.commit();
		sqlSession.close();
	}

	// 영화 삭제 - 1개 이상 삭제 (1개도 가능)
    public void deleteMovies(String[] mcodes) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            Map<String, Object> mcodeMap = new HashMap<>();
            mcodeMap.put("mcodes", mcodes);
            sqlSession.delete("movieSQL.deleteMovies", mcodeMap);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback(); // 오류 발생 시 롤백
        } finally {
            sqlSession.close();
        }
    }

    /** movieEdit.jsp */
	// 영화 수정
	public void updateMovie(MovieDTO movieDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("movieSQL.updateMovie", movieDTO);
        sqlSession.commit();
        sqlSession.close();		
	}
    
	// MovieDAO.java
	/** index.jsp */
	// 영화 검색
	public List<MovieDTO> indexSelectMovie(String value, String type) {
	    SqlSession sqlSession = sqlSessionFactory.openSession();
	    Map<String, Object> map = new HashMap<>();
	    map.put("type",type);
	    map.put("value",value);		
		
	    List<MovieDTO> list = sqlSession.selectList("movieSQL.indexSelectMovie", map);
	    sqlSession.close();
	    return list;
	}    
	
	
}