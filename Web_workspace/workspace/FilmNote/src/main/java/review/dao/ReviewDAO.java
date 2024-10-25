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

public class ReviewDAO {
	// 싱글톤 패턴 적용 - DAO 객체의 단일 인스턴스만 생성하여 공유
	private static ReviewDAO instance = new ReviewDAO();
	private SqlSessionFactory sqlSessionFactory;
	private String reviewMapper = "reviewSQL"; // MyBatis 매퍼 네임스페이스와 연동
    
	// ReviewDAO 인스턴스를 외부에서 호출할 때 사용되는 메서드 (싱글톤)
	public static ReviewDAO getInstance() {
		return instance;
	}
	
	// DAO 생성자 - mybatis-config.xml 설정 파일을 읽어 SqlSessionFactory 객체 생성
	public ReviewDAO() { 
		try {
			// MyBatis 설정 파일을 읽어들임
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			// SqlSessionFactory 객체를 빌드하여 초기화
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 리뷰 추가 메서드: 사용자가 작성한 리뷰를 DB에 추가
	public void insertReviewDTO(ReviewDTO reviewDTO) {
		System.out.println("insertReviewDTO() 호출");
		// SqlSession 객체 열기
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// MyBatis 매퍼 파일에서 리뷰 추가하는 쿼리 호출
		sqlSession.insert(reviewMapper + ".insertReviewDTO", reviewDTO);
		// 트랜잭션 커밋
		sqlSession.commit();
		// SqlSession 닫기
		sqlSession.close();
	}
	
	// 특정 영화(mcode)에 대한 리뷰 리스트 가져오기
	public List<ReviewDTO> getReviewList(int mcode, int pg, int pgSize) {
		System.out.println("getReviewList(" + mcode + "," + pg +"," + pgSize + ") 호출");
		// 페이징 처리 및 영화 코드 설정을 위한 맵 객체 생성
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("mcode", mcode); // 영화 코드
		map.put("pg", (pg-1)*pgSize); // 페이지 계산 (MySQL LIMIT와 연동)
		map.put("pgSize", pgSize); // 한 페이지에 보여줄 리뷰 수
		
		System.out.println("map<pg>: " + map.get("pg"));
		// SqlSession 객체 열기
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// MyBatis 매퍼에서 리뷰 리스트를 가져오는 쿼리 호출
		List<ReviewDTO> reviewDTOList = sqlSession.selectList(reviewMapper + ".getReviewList", map);
		// SqlSession 닫기
		sqlSession.close();
		
		// 리뷰 리스트 반환
		return reviewDTOList;
	}
	
	// 특정 영화(mcode)에 대한 총 리뷰 개수 가져오기
	public int getTotalA(int mcode) {
		System.out.println("getTotalA(" + mcode + ") 호출");
		// SqlSession 객체 열기
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int totalA = 0;      
		// MyBatis 매퍼에서 총 리뷰 개수를 가져오는 쿼리 호출
		totalA = sqlSession.selectOne(reviewMapper + ".getTotalA", mcode);        
		// SqlSession 닫기
		sqlSession.close(); 
		
		// 총 리뷰 개수 반환
		return totalA;
	}

	// 리뷰 수정 메서드: 사용자가 작성한 리뷰를 수정
	public void updateReviewDTO(ReviewDTO reviewDTO) {
		System.out.println("updateReviewDTO() 호출");
		// SqlSession 객체 열기
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// MyBatis 매퍼에서 리뷰 수정하는 쿼리 호출
		sqlSession.update(reviewMapper + ".updateReviewDTO", reviewDTO);
		// 트랜잭션 커밋
		sqlSession.commit();
		// SqlSession 닫기
		sqlSession.close();
	}
	
	// 리뷰 삭제 메서드: 특정 rcode에 해당하는 리뷰 삭제
	public void deleteReviedDTO(int rcode) {
		System.out.println("deleteReviedDTO(" + rcode + ") 호출");
		// SqlSession 객체 열기
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// MyBatis 매퍼에서 리뷰 삭제하는 쿼리 호출
		sqlSession.delete(reviewMapper + ".deleteReviedDTO", rcode);
		// 트랜잭션 커밋
		sqlSession.commit();
		// SqlSession 닫기
		sqlSession.close();
	}
}
