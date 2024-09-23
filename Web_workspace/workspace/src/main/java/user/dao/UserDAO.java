// FilmNote/src/main/java/user.dao.UserDAO.java
package user.dao;

import user.bean.UserDTO;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import movie.dao.MovieDAO;

public class UserDAO {
	// 싱글톤 인스턴스 생성
	private static MovieDAO instance = new MovieDAO();
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession; // sqlSession 변수 추가

	public static MovieDAO getInstance() {
		return instance;
	}
	
	public UserDAO() { // Driver Loading
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			sqlSession = sqlSessionFactory.openSession(); // sqlSession 초기화
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void insertUser(UserDTO user) {
		sqlSession.insert("mapper.userMapper.insertUser", user);
		sqlSession.commit(); // 변경 사항 커밋
	}
	
	public UserDTO loginUser(String userid, String password) {
		Map<String, String> params = new HashMap<>();
        params.put("userid", userid);
        params.put("password", password);
        UserDTO user = sqlSession.selectOne("mapper.userMapper.loginUser", params);
        sqlSession.commit(); // 변경 사항 커밋
        return user;
	}
}
