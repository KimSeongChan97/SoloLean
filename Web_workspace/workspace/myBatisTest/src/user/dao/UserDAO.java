package user.dao;

import java.io.IOException; // IOException 처리를 위해 import
import java.io.Reader; // 파일이나 리소스를 읽기 위한 Reader 클래스 import

import org.apache.ibatis.io.Resources; // MyBatis에서 자원을 로드할 때 사용하는 클래스 import
import org.apache.ibatis.session.SqlSessionFactory; // MyBatis에서 SQL 세션을 생성하기 위한 SqlSessionFactory 클래스 import
import org.apache.ibatis.session.SqlSessionFactoryBuilder; // SqlSessionFactory를 생성하는 빌더 클래스 import

public class UserDAO {
	
	private static UserDAO userDAO = new UserDAO(); // UserDAO 클래스의 싱글톤 인스턴스 생성
	// UserDAO 객체는 static으로 선언되어 클래스 로딩 시에 딱 한 번 생성됨
	private SqlSessionFactory sqlSessionFactory; // SQL 세션을 관리하는 SqlSessionFactory 객체 선언 (초기화는 나중에 수행)
	// sqlSessionFactory는 SQL 작업을 수행할 때 MyBatis와 상호작용하는 세션을 생성하는 객체

	// 싱글톤 패턴을 적용하기 위한 메소드
	public static UserDAO getInstance() {
		// 외부에서 UserDAO 객체를 생성하지 않고, getInstance() 메소드를 통해 유일한 인스턴스를 반환
		return userDAO; // 미리 생성된 인스턴스를 반환
		// UserDAO 객체는 미리 생성된 객체(userDAO)를 반환하여 여러 번 생성되지 않도록 제어됨
	}
	
	// UserDAO 생성자 (private이 아닌 이유는 테스트나 다른 클래스에서 직접 호출할 수 있도록 하기 위함)
	public UserDAO() {
		try {
						
			// mybatis-config.xml 설정 파일을 읽어와서 MyBatis 설정을 로드하는 부분
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			// Resources.getResourceAsReader()는 mybatis-config.xml 파일을 클래스패스에서 읽어오는 역할을 함
			// 이 파일은 MyBatis가 DB에 접근할 때 필요한 설정을 담고 있음
			// mybatis-config.xml은 DB 연결 정보, 매퍼 위치, 트랜잭션 관리 등의 설정을 정의한 파일
			
			// InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			// byte 단위로 파일을 읽어들이는 InputStream을 사용하여 자원을 로드할 수도 있음. 
			// 그러나 여기서는 Reader를 사용하여 문자열 기반의 자원 로드를 수행함.
			// 두 방식의 차이는 Reader는 문자 데이터를 처리하는 데 사용되고, InputStream은 바이트 데이터를 처리할 때 사용됨.
			
			// SqlSessionFactoryBuilder를 사용하여 SqlSessionFactory 객체를 생성
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			// sqlSessionFactory는 MyBatis에서 SQL 세션을 관리하고 DB와 상호작용하는 데 필요한 객체로
			// 이 factory를 통해 나중에 SqlSession을 생성하여 DB와의 상호작용을 처리하게 됨
			// build() 메소드는 설정 파일을 바탕으로 SqlSessionFactory를 생성함
			
		} catch (IOException e) {
			// IOException이 발생할 경우의 예외 처리
			e.printStackTrace(); // 예외 발생 시 스택 트레이스를 출력하여 어디서 오류가 발생했는지 디버깅 가능
		}
	}	
	
}
