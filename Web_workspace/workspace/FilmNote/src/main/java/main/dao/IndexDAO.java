// FlimNote/src/main/java/main/dao/IndexDAO.java
package main.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import movie.bean.MovieDTO;

public class IndexDAO {
	private static IndexDAO instance = new IndexDAO();
	private SqlSessionFactory sqlSessionFactory;
	private String indexMapper = "indexSQL";
    
	public IndexDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static IndexDAO getInstance() {
		return instance;
	}
	
	// 영화 목록
	public List<MovieDTO> getMovieBoardList() {
		System.out.println("getMovieBoardList() 호출");
		List<MovieDTO> movieDTOList = null;
		
		SqlSession session = sqlSessionFactory.openSession();
		movieDTOList = session.selectList(indexMapper+".getMovieBoardList");
		session.close();
		
		return movieDTOList;
	}
	
	// 영화 API Data 추가
	public MovieDTO insertMovieAPIData(MovieDTO movieDTO) {
		System.out.println("insertMovieAPIData() 호출");
		
		SqlSession session = sqlSessionFactory.openSession();
		session.insert(indexMapper+".insertMovieAPIData", movieDTO);
		session.commit();
		session.close();
		
		return movieDTO;
	}
	
	
}
