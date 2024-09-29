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
    private static AdminDAO instance = new AdminDAO(); // AdminDAO의 싱글톤 인스턴스
    private SqlSessionFactory sqlSessionFactory; // MyBatis의 SqlSessionFactory 객체를 통해 DB 연결
    
    // 싱글톤 패턴을 사용하여 인스턴스를 반환하는 메서드
    public static AdminDAO getInstance() {
        return instance;
    }
    
    // 기본 생성자: MyBatis 설정 파일(mybatis-config.xml)을 읽어 SqlSessionFactory 객체 생성
    public AdminDAO() { // Driver Loading
        try {
            // MyBatis 설정 파일을 읽어와 SqlSessionFactoryBuilder를 통해 SqlSessionFactory를 생성
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace(); // 설정 파일을 불러오는 도중 예외 발생 시 오류 출력
        }
    }
    
    // SqlSessionFactory 객체를 반환하는 메서드
    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
    
    // 관리자 로그인 메서드: 관리자 아이디(aid)와 비밀번호(apwd)를 기반으로 DB에서 관리자 정보를 확인
    public AdminDTO loginAdmin(String aid, String apwd) {
        SqlSession sqlSession = sqlSessionFactory.openSession(); // SqlSession 객체를 통해 SQL 실행
        try {
            // aid와 apwd를 Map에 담아 MyBatis에 전달할 파라미터로 사용
            Map<String, String> params = new HashMap<>();
            params.put("aid", aid); // 관리자 아이디 추가
            params.put("apwd", apwd); // 관리자 비밀번호 추가

            // "adminSQL.loginAdmin" 쿼리를 실행하여 로그인 검증
            // adminSQL에 해당하는 MyBatis Mapper 파일에 작성된 SQL을 실행
            return sqlSession.selectOne("adminSQL.loginAdmin", params); 
        } finally {
            sqlSession.close(); // 작업이 완료된 후 SqlSession을 닫아 DB 자원을 반환
        }
    }
}
