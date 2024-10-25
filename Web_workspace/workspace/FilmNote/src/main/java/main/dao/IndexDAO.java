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
	private static IndexDAO instance = new IndexDAO(); // IndexDAO 클래스의 싱글톤 패턴 인스턴스 생성
	private SqlSessionFactory sqlSessionFactory; // MyBatis의 SqlSessionFactory를 통해 SQL 세션을 관리
	private String indexMapper = "indexSQL"; // 매퍼 파일에서 사용할 네임스페이스 정의
    
	// IndexDAO 생성자: MyBatis 설정 파일(mybatis-config.xml)을 읽어서 SqlSessionFactory를 초기화
	public IndexDAO() {
		try {
			// MyBatis 설정 파일을 읽어 SqlSessionFactory를 초기화
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace(); // 파일 읽기 중 오류가 발생하면 스택 트레이스 출력
		}
	}
	
	// IndexDAO의 싱글톤 인스턴스를 반환하는 메서드
	public static IndexDAO getInstance() {
		return instance; // 싱글톤 패턴으로 IndexDAO의 하나의 인스턴스를 공유
	}
	
	/**
	 * 영화 목록을 가져오는 메서드
	 * MyBatis를 사용하여 indexMapper의 getMovieBoardList 쿼리 실행
	 * @return 영화 목록을 담은 MovieDTO 객체 리스트
	 */
	public List<MovieDTO> getMovieBoardList() {
		System.out.println("getMovieBoardList() 호출"); // 디버깅용 출력
		List<MovieDTO> movieDTOList = null; // 반환할 영화 목록을 저장할 리스트
		
		// MyBatis의 SqlSession을 열고, SQL 실행
		SqlSession session = sqlSessionFactory.openSession();
		// Mapper에서 "indexSQL.getMovieBoardList"에 해당하는 쿼리를 실행하여 결과를 리스트로 반환
		movieDTOList = session.selectList(indexMapper + ".getMovieBoardList");
		// 작업이 끝난 후 SqlSession을 닫음
		session.close();
		
		return movieDTOList; // 결과로 영화 목록 리스트를 반환
	}
	
	/**
	 * 영화 API 데이터를 추가하는 메서드
	 * 외부에서 받은 MovieDTO 객체를 MyBatis로 DB에 삽입
	 * @param movieDTO - DB에 추가할 영화 데이터를 담고 있는 MovieDTO 객체
	 * @return DB에 삽입된 MovieDTO 객체 반환
	 */
	public MovieDTO insertMovieAPIData(MovieDTO movieDTO) {
		System.out.println("insertMovieAPIData() 호출"); // 디버깅용 출력
		
		// MyBatis의 SqlSession을 열고, SQL 실행
		SqlSession session = sqlSessionFactory.openSession();
		// Mapper에서 "indexSQL.insertMovieAPIData"에 해당하는 쿼리를 실행하여 영화 데이터를 삽입
		session.insert(indexMapper + ".insertMovieAPIData", movieDTO);
		// 트랜잭션을 커밋하여 DB에 변경 사항을 반영
		session.commit();
		// 작업이 끝난 후 SqlSession을 닫음
		session.close();
		
		return movieDTO; // 삽입된 MovieDTO 객체를 반환
	}
}
