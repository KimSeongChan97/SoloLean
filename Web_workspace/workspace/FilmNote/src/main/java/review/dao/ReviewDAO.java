// FilmNote/src/main/java/review.dao.ReviewDAO.java
package review.dao;

import review.bean.ReviewDTO;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import movie.bean.MovieDTO;

public class ReviewDAO {
	// 싱글톤 인스턴스 생성
	private static ReviewDAO instance = new ReviewDAO();
	private SqlSessionFactory sqlSessionFactory;
	private String reviewMapper = "reviewSQL";
    
	public static ReviewDAO getInstance() {
		return instance;
	}
	
	public ReviewDAO() { // Driver Loading
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 리뷰 추가
	public void insertReviewDTO(ReviewDTO reviewDTO) {
		System.out.println("insertReviewDTO() 호출");
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert(reviewMapper + ".insertReviewDTO", reviewDTO);
		sqlSession.commit();
		sqlSession.close();
	}
	
	// mcode에 대한 리뷰 리스트
	public List<ReviewDTO> getReviewList(int mcode, int pg, int pgSize) {
		System.out.println("getReviewList(" + mcode + "," + pg +"," + pgSize + ") 호출");
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("mcode", mcode);
		map.put("pg", (pg-1)*pgSize);
		map.put("pgSize", pgSize);
		
		System.out.println("map<pg>: " + map.get("pg"));
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ReviewDTO> reviewDTOList = sqlSession.selectList(reviewMapper + ".getReviewList", map);
		sqlSession.close();
		
		return reviewDTOList;
	}
	
	// mcode에 대한 리뷰 개수
	public int getTotalA(int mcode) {
		System.out.println("getTotalA(" + mcode + ") 호출");
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int totalA = 0;      
		totalA = sqlSession.selectOne(reviewMapper + ".getTotalA", mcode);        
		sqlSession.close(); 
		
		return totalA;
	}

	// 리뷰 수정
	public void updateReviewDTO(ReviewDTO reviewDTO) {
		System.out.println("updateReviewDTO() 호출");
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update(reviewMapper + ".updateReviewDTO", reviewDTO);
		sqlSession.commit();
		sqlSession.close();
	}
	
	// 리뷰 삭제
	public void deleteReviedDTO(int rcode) {
		System.out.println("deleteReviedDTO(" + rcode + ") 호출");
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete(reviewMapper + ".deleteReviedDTO", rcode);
		sqlSession.commit();
		sqlSession.close();
	}
	
}
