package admin.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import admin.bean.AdminDTO;

public class AdminDAO {
	// 싱글톤 인스턴스 생성
		private static AdminDAO instance = new AdminDAO();
		private SqlSessionFactory sqlSessionFactory;
	    
		public static AdminDAO getInstance() {
			return instance;
		}
		
		public AdminDAO() { // Driver Loading
			try {
				Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public SqlSessionFactory getSqlSessionFactory() {
			return sqlSessionFactory;
		}
		
		public AdminDTO loginAdmin(String aid, String apwd) {
		    SqlSession sqlSession = sqlSessionFactory.openSession();
		    try {
		        Map<String, String> params = new HashMap<>();
		        params.put("aid", aid);
		        params.put("apwd", apwd);
		        return sqlSession.selectOne("adminSQL.loginAdmin", params);
		    } finally {
		        sqlSession.close();
		    }
		}

}
