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

    // 싱글톤 인스턴스를 생성하여 DAO를 전역적으로 사용하도록 설정
    private static MovieDAO instance = new MovieDAO();
    private SqlSessionFactory sqlSessionFactory;
    
    // 싱글톤 인스턴스를 가져오는 메서드
    public static MovieDAO getInstance() {
        return instance;
    }
    
    // MovieDAO 생성자: mybatis-config.xml 파일을 로드하여 SQL 세션 팩토리 생성
    public MovieDAO() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** movieWrite.jsp에서 사용: 영화 등록 메서드 */
    public void writeMovie(MovieDTO movieDTO) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("movieSQL.writeMovie", movieDTO);
        sqlSession.commit(); // 데이터베이스에 변경 사항 커밋
        sqlSession.close();  // 세션 닫기
    }

    /** movieList.jsp에서 사용: 전체 영화 개수 가져오는 메서드 */
    public int getTotalA() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int totalA = sqlSession.selectOne("movieSQL.getTotalA");
        sqlSession.close();
        return totalA; // 총 영화 수 반환
    }

    /** movieList.jsp에서 사용: 영화 목록 가져오는 메서드 */
    public List<MovieDTO> movieList(int startNum, int endNum) {
        Map<String, Integer> map = new HashMap<>();
        map.put("startNum", startNum);
        map.put("endNum", endNum);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<MovieDTO> list = sqlSession.selectList("movieSQL.movieList", map);
        sqlSession.close();
        return list; // 영화 리스트 반환
    }

    /** 검색된 총 영화 개수를 반환하는 메서드 */
    public int getSelectTotal(String value, String type) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Map<String, String> data = new HashMap<>();
        data.put("type", type);
        data.put("value", value);
        
        int selectTotal = sqlSession.selectOne("movieSQL.getSelectTotal", data);
        sqlSession.close();
        return selectTotal; // 검색된 영화 총 개수 반환
    }

    /** 검색된 영화 목록을 가져오는 메서드 */
    public List<MovieDTO> selectMovie(String value, String type, int startNum, int endNum) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Map<String, Object> map = new HashMap<>();
        map.put("startNum", startNum);
        map.put("endNum", endNum);
        map.put("type", type);
        map.put("value", value);

        List<MovieDTO> list = sqlSession.selectList("movieSQL.selectMovie", map);
        sqlSession.close();
        return list; // 검색된 영화 리스트 반환
    }

    /** movieView.jsp에서 사용: 영화 정보를 가져오는 메서드 */
    public MovieDTO getMovie(int mcode) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        MovieDTO movieDTO = sqlSession.selectOne("movieSQL.getMovie", mcode);
        sqlSession.close();
        return movieDTO; // 영화 정보 반환
    }

    /** 영화 평점을 업데이트하는 메서드: 리뷰가 추가되거나 수정될 때 호출 */
    public void updateMovieScore(int mcode) {
        System.out.println("updateMovieScore(" + mcode + ") 호출");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("movieSQL.updateMovieScore", mcode);
        sqlSession.commit(); // 데이터베이스에 변경 사항 커밋
        sqlSession.close();
    }

    /** 여러 개의 영화를 삭제하는 메서드 (하나 또는 여러 개 삭제 가능) */
    public void deleteMovies(String[] mcodes) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            Map<String, Object> mcodeMap = new HashMap<>();
            mcodeMap.put("mcodes", mcodes);
            sqlSession.delete("movieSQL.deleteMovies", mcodeMap);
            sqlSession.commit(); // 삭제된 내용을 커밋
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback(); // 오류 발생 시 롤백 처리
        } finally {
            sqlSession.close(); // 세션 닫기
        }
    }

    /** movieEdit.jsp에서 사용: 영화 정보를 수정하는 메서드 */
    public void updateMovie(MovieDTO movieDTO) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("movieSQL.updateMovie", movieDTO);
        sqlSession.commit();
        sqlSession.close();
    }

    /** index.jsp에서 사용: 메인 페이지에서 영화 검색을 위한 메서드 */
    public List<MovieDTO> indexSelectMovie(String value, String type) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Map<String, Object> map = new HashMap<>();
        map.put("type", type);
        map.put("value", value);

        List<MovieDTO> list = sqlSession.selectList("movieSQL.indexSelectMovie", map);
        sqlSession.close();
        return list; // 검색된 영화 리스트 반환
    }

}
