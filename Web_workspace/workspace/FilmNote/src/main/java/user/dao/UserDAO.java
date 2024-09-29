// FilmNote/src/main/java/user.dao.UserDAO.java
package user.dao;

import user.bean.UserDTO;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UserDAO {
    // 싱글톤 인스턴스 생성
    // 한 번만 생성된 인스턴스를 여러 곳에서 사용하기 위해 싱글톤 패턴을 적용합니다.
    private static UserDAO instance = new UserDAO();
    private SqlSessionFactory sqlSessionFactory;

    // 외부에서 인스턴스를 얻을 수 있도록 getInstance() 메서드 제공
    public static UserDAO getInstance() {
        return instance;
    }

    // 생성자: MyBatis 설정 파일(mybatis-config.xml)을 읽어와 SqlSessionFactory를 초기화
    public UserDAO() { // Driver Loading
        try {
            // MyBatis 설정 파일을 읽어 SqlSessionFactory를 생성
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 사용자 로그인 메서드
    public UserDTO loginUser(String uid, String upwd) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            // 아이디와 비밀번호를 Map에 담아 SQL에 전달
            Map<String, String> params = new HashMap<>();
            params.put("uid", uid);
            params.put("upwd", upwd);
            // MyBatis를 사용하여 'userSQL.loginUser' 쿼리 실행 및 결과 리턴
            return sqlSession.selectOne("userSQL.loginUser", params);
        } finally {
            sqlSession.close(); // SqlSession 종료
        }
    }

    // 사용자 등록 메서드
    public void insertUser(UserDTO user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            // MyBatis를 사용하여 'userSQL.insertUser' 쿼리 실행
            sqlSession.insert("userSQL.insertUser", user);
            sqlSession.commit(); // 변경 사항을 DB에 반영
        } finally {
            sqlSession.close(); // SqlSession 종료
        }
    }

    // 사용자 정보 수정 메서드
    public void userEdit(UserDTO user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 'userSQL.userEdit' 쿼리를 사용하여 사용자의 정보 업데이트
        sqlSession.update("userSQL.userEdit", user);
        sqlSession.commit(); // 변경 사항을 DB에 반영
        sqlSession.close(); // SqlSession 종료
    }

    // 회원정보 조회 메서드
    public UserDTO getMember(String id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // MyBatis를 사용하여 'userSQL.getMember' 쿼리 실행 및 결과 리턴
        UserDTO userDTO = sqlSession.selectOne("userSQL.getMember", id);
        sqlSession.close(); // SqlSession 종료
        return userDTO; // 조회한 회원 정보 리턴
    }

    // 아이디 중복 체크 메서드
    public boolean checkIdExists(String uid) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            // 'userSQL.checkIdExists' 쿼리를 실행하여 해당 아이디가 존재하는지 확인
            int count = sqlSession.selectOne("userSQL.checkIdExists", uid);
            return count > 0; // 존재하면 true, 그렇지 않으면 false 리턴
        } finally {
            sqlSession.close(); // SqlSession 종료
        }
    }

    // 비밀번호 확인 메서드
    public boolean pwdCheck(String id, String nowpwd) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            // 데이터베이스에서 저장된 비밀번호를 조회
            String pwdCheck = sqlSession.selectOne("userSQL.pwdCheck", id);

            // 조회한 비밀번호가 입력된 비밀번호와 일치하는지 확인
            if (pwdCheck != null && pwdCheck.equals(nowpwd)) {
                return true; // 비밀번호가 일치하면 true 리턴
            } else {
                return false; // 비밀번호가 일치하지 않으면 false 리턴
            }
        } finally {
            sqlSession.close(); // SqlSession 종료
        }
    }

    // 회원탈퇴 메서드
    
	public int userWithdraw(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int result = sqlSession.delete("userSQL.userWithdraw", id);
		sqlSession.commit();
		sqlSession.close();		
		return result;
	}
}

