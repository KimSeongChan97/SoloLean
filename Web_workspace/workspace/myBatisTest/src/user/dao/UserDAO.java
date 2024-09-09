package user.dao;

import java.io.IOException; // IOException 처리를 위해 import
import java.io.Reader; // 파일이나 리소스를 읽기 위한 Reader 클래스 import

import org.apache.ibatis.io.Resources; // MyBatis에서 자원을 로드할 때 사용하는 클래스 import
import org.apache.ibatis.session.SqlSessionFactory; // MyBatis에서 SQL 세션을 생성하기 위한 SqlSessionFactory 클래스 import
import org.apache.ibatis.session.SqlSessionFactoryBuilder; // SqlSessionFactory를 생성하는 빌더 클래스 import

public class UserDAO {
	
	private static UserDAO userDAO = new UserDAO(); // UserDAO 클래스의 싱글톤 인스턴스 생성
	private SqlSessionFactory sqlSessionFactory; // SQL 세션을 관리하는 SqlSessionFactory 객체 선언 (초기화는 나중에 수행)
	
	// 싱글톤 패턴을 적용하기 위한 메소드
	public static UserDAO getInstance() {
		// 외부에서 UserDAO 객체를 생성하지 않고, getInstance() 메소드를 통해 유일한 인스턴스를 반환
		return userDAO; // 미리 생성된 인스턴스를 반환
	}
	
	// UserDAO 생성자 (private이 아닌 이유는 테스트나 다른 클래스에서 직접 호출할 수 있도록 하기 위함)
	public UserDAO() {
		try {
						
			// mybatis-config.xml 설정 파일을 읽어와서 MyBatis 설정을 로드하는 부분
			 Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			// Resources.getResourceAsReader()는 mybatis-config.xml 파일을 클래스패스에서 읽어오는 역할을 함
			// 이 파일은 MyBatis가 DB에 접근할 때 필요한 설정을 담고 있음
			
			// InputStream inputStream = Resources.getResourceAsReader("mybatis-config.xml");
			// byte	 
			 
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			// inputStream = new SqlSessionFactoryBuilder().build(reader);
			// SqlSessionFactory는 MyBatis가 SQL 세션을 관리하고 DB와 상호작용하기 위한 객체로, 
            // SqlSession을 생성하는 데 사용됩니다.
			
			
		} catch (IOException e) {
			// IOException이 발생할 경우의 예외 처리
			e.printStackTrace(); // 예외 발생 시 스택 트레이스를 출력하여 어디서 오류가 발생했는지 디버깅 가능
		}
	}	
	
}
