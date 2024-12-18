package user.dao;

import java.io.IOException; // IOException 처리를 위해 import
import java.io.Reader; // 파일이나 리소스를 읽기 위한 Reader 클래스 import
import java.util.HashMap;
import java.util.List; // 여러 UserDTO 객체를 저장할 수 있는 List를 사용하기 위해 import
import java.util.Map;

import org.apache.ibatis.io.Resources; // MyBatis에서 자원을 로드할 때 사용하는 클래스 import
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory; // MyBatis에서 SQL 세션을 생성하기 위한 SqlSessionFactory 클래스 import
import org.apache.ibatis.session.SqlSessionFactoryBuilder; // SqlSessionFactory를 생성하는 빌더 클래스 import

import user.bean.UserDTO;

public class UserDAO {
	
	private static UserDAO userDAO = new UserDAO(); // UserDAO 클래스의 싱글톤 인스턴스 생성
	// UserDAO 객체는 static으로 선언되어 클래스 로딩 시에 딱 한 번 생성됨
	// 싱글톤 패턴을 사용하여 객체의 중복 생성을 막고 하나의 인스턴스만 사용하도록 보장함
	// 이는 애플리케이션 전반에서 동일한 UserDAO 인스턴스를 공유함으로써, 자원 낭비를 줄이고 일관성을 유지할 수 있음.
	// 싱글톤 패턴이란 하나의 인스턴스만 생성하여 사용할 수 있도록 하는 디자인 패턴으로, 여러 번 객체를 생성하지 않고 같은 인스턴스를 공유하도록 합니다.
	
	private SqlSessionFactory sqlSessionFactory; // SQL 세션을 관리하는 SqlSessionFactory 객체 선언 (초기화는 나중에 수행)
	// sqlSessionFactory는 SQL 작업을 수행할 때 MyBatis와 상호작용하는 세션을 생성하는 객체!
	// SqlSession은 SQL 실행과 결과 처리, 트랜잭션 관리를 담당함.
	// 이 factory는 매번 새로운 SqlSession을 생성하여 DB 작업을 수행할 수 있도록 해주는 역할을 함.
	// MyBatis는 SQL 세션 관리를 통해 DB 연결과 SQL 실행을 효과적으로 관리할 수 있도록 도와줌.
	// SqlSessionFactory는 MyBatis의 중심 객체로, 이를 통해 DB 연결을 열고 닫고 SQL을 실행하는 SqlSession 객체를 생성합니다.
	
	// 싱글톤 패턴을 적용하기 위한 메소드
	public static UserDAO getInstance() {
		// 외부에서 UserDAO 객체를 생성하지 않고, getInstance() 메소드를 통해 유일한 인스턴스를 반환
		// 이 메서드는 처음 호출될 때 이미 만들어진 UserDAO 객체를 반환함
		return userDAO; // 미리 생성된 인스턴스를 반환
		// UserDAO 객체는 미리 생성된 객체(userDAO)를 반환하여 여러 번 생성되지 않도록 제어됨
		// 이렇게 함으로써 자원을 절약하고, 여러 곳에서 동일한 DB 접근 로직을 사용할 수 있게 함.
		// 싱글톤 패턴은 전역적인 접근을 보장하며, 시스템 자원의 낭비를 줄이는 중요한 패턴입니다.
	} // class UserDAO
	
	// UserDAO 생성자 (private이 아닌 이유는 테스트나 다른 클래스에서 직접 호출할 수 있도록 하기 위함)
	public UserDAO() {
		try {
			// MyBatis 설정 파일을 읽어와서 MyBatis 설정을 로드하는 부분
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			// Resources.getResourceAsReader()는 mybatis-config.xml 파일을 클래스패스에서 읽어오는 역할을 함
			// 이 파일은 MyBatis가 DB에 접근할 때 필요한 설정을 담고 있음
			// mybatis-config.xml은 DB 연결 정보, 매퍼 위치, 트랜잭션 관리 등의 설정을 정의한 파일
			// 리더를 통해 설정 파일의 내용을 읽고 이를 기반으로 SqlSessionFactory 객체를 생성하게 됨.
			// MyBatis 설정 파일은 데이터베이스 연결 설정 및 매퍼 파일의 위치를 정의하며, 애플리케이션이 시작될 때 필요한 설정 정보를 제공합니다.
			
			// InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			// byte 단위로 파일을 읽어들이는 InputStream을 사용하여 자원을 로드할 수도 있음. 
			// 그러나 여기서는 Reader를 사용하여 문자열 기반의 자원 로드를 수행함.
			// 두 방식의 차이는 Reader는 문자 데이터를 처리하는 데 사용되고, InputStream은 바이트 데이터를 처리할 때 사용됨.
			// 여기서 Reader를 선택한 이유는 설정 파일이 XML로 되어 있어서, 문자 데이터를 처리하는 것이 더 적합하기 때문임.
			// InputStream은 바이트 기반 데이터를 처리하는 반면, Reader는 문자 데이터를 처리하는 데 더 적합하므로 여기서는 Reader를 사용합니다.

			// SqlSessionFactoryBuilder를 사용하여 SqlSessionFactory 객체를 생성
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			// sqlSessionFactory는 MyBatis에서 SQL 세션을 관리하고 DB와 상호작용하는 데 필요한 객체로
			// 이 factory를 통해 나중에 SqlSession을 생성하여 DB와의 상호작용을 처리하게 됨
			// build() 메소드는 설정 파일을 바탕으로 SqlSessionFactory를 생성함
			// 이 객체는 애플리케이션 전체에서 공유하며, 각 요청마다 SqlSession 객체를 제공하게 됨.
			// SqlSessionFactoryBuilder는 설정 파일을 읽어 SqlSessionFactory 객체를 생성하는 빌더 클래스입니다.
			
		} catch (IOException e) {
			// IOException이 발생할 경우의 예외 처리
			e.printStackTrace(); // 예외 발생 시 스택 트레이스를 출력하여 어디서 오류가 발생했는지 디버깅 가능
			// 설정 파일이 잘못되었거나 경로에 문제가 있을 경우, IOException이 발생할 수 있음.
			// 파일 경로 오류, 파일 권한 문제 등으로 인해 설정 파일을 읽지 못할 경우 IOException이 발생합니다.
		}
	} // public UserDAO

	// 사용자 정보를 저장하는 메소드
	public int write(UserDTO userDTO) {
		int su = 0;
		// SQL 작업의 결과로 반환된 값을 담을 변수 'su' 선언
		// insert 작업의 결과로 영향을 받은 레코드 수가 반환됨 (즉, 몇 개의 레코드가 삽입되었는지를 나타냄)
		// insert 쿼리에서 데이터를 성공적으로 삽입하면 해당 작업이 영향을 준 행의 수를 반환함. 
		// 여기서 su는 삽입된 행의 수를 나타내며, 작업 성공 여부를 확인하는 데 사용됩니다.
		
		SqlSession sqlSession = sqlSessionFactory.openSession(); // SQL 세션 생성
		// sqlSessionFactory를 통해 DB와 상호작용할 수 있는 SqlSession 객체를 생성함
		// SqlSession은 실제 SQL을 실행하고, 트랜잭션을 관리하며, 결과를 반환하는 역할을 함.
		// SqlSession은 DB와의 연결을 관리하며, 사용이 끝나면 반드시 close()로 닫아줘야 함.
		// openSession()은 DB와 연결하고 SQL을 실행할 수 있는 세션을 반환함.
		// SqlSession은 SQL을 실행하고 결과를 가져오는 역할을 합니다. openSession()은 트랜잭션을 관리하는 세션을 엽니다.
		
		// sqlSession.insert("이름", userDTO); -> userMapper.xml 에서의 insert namespace.id(중복X)
		su = sqlSession.insert("userSQL.write", userDTO); 
		// userMapper.xml 파일에 정의된 "userSQL.write" SQL 쿼리를 실행
		// userSQL은 매퍼 파일에서 정의한 네임스페이스이고, write는 매퍼 파일 내의 SQL ID임
		// MyBatis가 userDTO 객체의 필드 값을 #{name}, #{id}, #{pwd}와 매핑하여 SQL 쿼리를 실행함
		// 이때 userDTO의 필드 값이 SQL의 파라미터로 자동 매핑되어 데이터베이스에 삽입됨.
		// 여기서 MyBatis는 userDTO 객체의 필드를 SQL 쿼리에 매핑하여 안전하게 삽입 작업을 처리합니다.

		sqlSession.commit();
		// SQL 실행 후 변경사항을 확정하는 commit() 호출. 
		// insert, update, delete 같은 DML 작업을 수행할 때는 트랜잭션의 일관성을 유지하기 위해 commit이 필요함
		// commit을 호출하지 않으면, 데이터베이스에 반영되지 않음.
		// DML 작업 후 commit을 호출함으로써 DB에 확정적으로 반영되며, 이를 호출하지 않으면 트랜잭션이 롤백될 수 있음.
		// commit()은 데이터베이스에서 변경된 사항을 확정하는 역할을 합니다. 이 작업을 하지 않으면 데이터가 저장되지 않습니다.
		
		sqlSession.close();	
		// SqlSession을 사용한 후 반드시 close()로 자원을 해제해야 함.
		// 세션을 닫지 않으면 메모리 누수나 연결 유지 문제를 일으킬 수 있음.
		// 세션을 사용한 후 닫지 않으면 DB 리소스를 계속 점유하게 되어 성능 저하를 초래할 수 있음.
		// close()는 열린 자원을 해제하는 중요한 작업으로, 세션을 안전하게 닫아 메모리 누수를 방지합니다.
			
		return su;
		// insert 작업의 결과로 몇 개의 레코드가 삽입되었는지 반환
		// su는 삽입된 행의 개수를 반환함. 이를 통해 삽입 성공 여부를 알 수 있음.
	} // write

	// 모든 사용자 정보를 가져오는 메소드
	public List<UserDTO> getAllList() {
		SqlSession sqlSession = sqlSessionFactory.openSession(); // SQL 세션 생성
		// SQL 실행을 위한 SqlSession 객체를 생성함.
		// 여러 명의 사용자 정보를 조회해야 하므로, selectList() 메소드를 통해 리스트 형태로 결과를 받음.
		// selectList()는 여러 행을 반환하는 쿼리에 사용되며, 결과는 리스트로 반환됩니다.
		
		List<UserDTO> list = sqlSession.selectList("userSQL.getAllList"); 
		// userMapper.xml 파일에 정의된 "userSQL.getAllList" 쿼리를 실행하여, 결과 리스트를 가져옴.
		// selectList() 메소드는 여러 개의 결과를 리스트로 반환하며, 이때 반환 타입은 List<UserDTO>임.
		// getAllList 쿼리는 DB에 저장된 모든 사용자의 정보를 가져오는 역할을 함.
		// MyBatis는 SQL 쿼리 결과를 자동으로 UserDTO 객체로 매핑하여 리스트로 반환함.
		// selectList()는 여러 개의 결과를 리스트 형태로 반환하며, 결과는 UserDTO 객체로 자동 매핑됩니다.

		sqlSession.close(); 
		// DB와의 세션이 끝났으므로 반드시 close()를 호출하여 자원을 해제함.
		// 세션을 닫지 않으면 메모리 누수 문제가 발생할 수 있음.
		// 세션이 열려 있으면 데이터베이스 자원을 계속 점유하게 되므로, 사용 후 반드시 닫아야 합니다.
		
		return list;
		// 가져온 사용자 리스트를 반환함.
		// 조회한 모든 사용자의 정보가 담긴 리스트를 반환하여, 이를 호출한 곳에서 활용할 수 있음.
		// 반환된 리스트는 호출한 곳에서 사용자 정보를 사용할 수 있도록 전달됩니다.
	} // getAllList

	// 특정 ID로 사용자의 정보를 가져오는 메소드
	public UserDTO getUser(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); // SQL 세션 생성
		// SQL 세션을 열어 데이터베이스와 상호작용할 준비를 함.
		// SQL 세션을 생성하여 특정 사용자 정보를 조회할 준비를 합니다.
		
		UserDTO userDTO = sqlSession.selectOne("userSQL.getUser", id); 
		// userMapper.xml 파일에 정의된 "userSQL.getUser" 쿼리를 실행하여 특정 ID의 사용자 정보를 가져옴
		// selectOne() 메소드는 하나의 결과만 반환하는 쿼리를 실행할 때 사용되며, 결과는 UserDTO 객체로 반환됨.
		// 전달된 id에 해당하는 사용자의 정보를 데이터베이스에서 조회하여 UserDTO 객체로 반환함.
		// selectOne()은 하나의 레코드만 반환하는 쿼리에서 사용되며, 결과는 UserDTO로 매핑됩니다.

		sqlSession.close(); 
		// 세션이 끝났으므로 반드시 close() 호출하여 자원을 해제함.
		return userDTO;
		// 조회한 사용자의 정보를 반환함.
		// 이 메소드 호출자는 반환된 UserDTO 객체를 통해 사용자의 정보를 활용할 수 있음.
		// 호출자는 반환된 UserDTO 객체를 통해 조회한 사용자 정보를 사용할 수 있습니다.
	}

	// 사용자 정보를 업데이트하는 메소드
	public int updateUser(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); // SQL 세션 생성
		// SQL 세션을 열어 데이터베이스와 상호작용할 준비를 함.
		
		int result = sqlSession.update("userSQL.updateUser", userDTO); 
		// userMapper.xml 파일에 정의된 "userSQL.updateUser" 쿼리를 실행하여 사용자 정보를 업데이트함
		// update() 메소드는 SQL update 쿼리를 실행하며, 영향받은 레코드 수를 반환함.
		// 이때 userDTO의 필드 값이 SQL 파라미터로 사용되어 사용자의 정보가 업데이트됨.
		// update() 메소드는 SQL 쿼리로 업데이트된 레코드 수를 반환합니다. 반환된 값은 업데이트된 레코드 수입니다.

		sqlSession.commit(); 
		// 트랜잭션을 커밋하여 변경사항을 DB에 반영함.
		// 업데이트 작업이 완료된 후 DB에 영구적으로 적용되도록 commit을 호출해야 함.
		// commit()을 호출해야만 트랜잭션이 완료되며, 업데이트된 내용이 데이터베이스에 반영됩니다.
		
		sqlSession.close(); 
		// 세션 종료 후 자원을 해제함.
		return result;
		// 업데이트된 행의 개수를 반환하여 몇 개의 사용자가 수정되었는지 확인할 수 있음.
	}

	// 특정 ID로 사용자를 삭제하는 메소드
	public int deleteUser(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); // SQL 세션 생성
		// SQL 세션을 열어 데이터베이스와 상호작용할 준비를 함.
		
		int result = sqlSession.delete("userSQL.deleteUser", id); 
		// userMapper.xml 파일에 정의된 "userSQL.deleteUser" 쿼리를 실행하여 사용자 정보를 삭제함.
		// delete() 메소드는 삭제 작업을 수행하며, 삭제된 행의 수를 반환함.
		// delete() 메소드는 주어진 조건에 따라 삭제된 레코드 수를 반환합니다.

		sqlSession.commit(); 
		// 삭제 작업이 완료된 후 DB에 반영되도록 commit을 호출함.
		// commit을 호출해야만 삭제가 데이터베이스에 반영됩니다.
		
		sqlSession.close();
		// 세션 종료 후 자원을 해제함.
		
		return result;
		// 삭제된 행의 수를 반환하여 삭제 작업이 제대로 이루어졌는지 확인할 수 있음.
	}
	
	// 검색 메소드 추가
	public List<UserDTO> search(Map<String, String> map) {
	    SqlSession sqlSession = sqlSessionFactory.openSession(); // SQL 세션 생성
	    // SQL 세션을 생성하여 검색 작업을 수행할 준비를 함.
	    // SqlSession은 데이터베이스와의 연결을 관리하며, SQL 쿼리 실행, 트랜잭션 관리 등을 담당합니다.
	    // openSession() 메소드는 새로운 세션을 열어줍니다. 이 세션을 통해 SQL 명령을 실행할 수 있습니다.

	    List<UserDTO> list = sqlSession.selectList("userSQL.search", map);
	    // 매퍼 파일에 정의된 "userSQL.search" SQL 쿼리를 실행하여 검색 조건에 맞는 사용자 목록을 조회
	    // selectList() 메소드는 여러 개의 결과를 리스트로 반환하며, 결과를 List<UserDTO>로 반환

	    sqlSession.close(); // 세션을 닫아 자원을 해제함.
	    // 세션을 사용한 후 반드시 close()를 호출하여 세션을 닫고 자원을 해제해야 합니다.
	    // 세션을 닫지 않으면 데이터베이스 연결이 계속 유지되어 자원 낭비가 발생할 수 있습니다.
	    // 자원 관리는 시스템 성능에 중요한 역할을 하므로, 모든 세션 작업이 끝난 후 세션을 적절히 닫는 것이 중요합니다.

	    return list;
	    // 검색 결과인 사용자 리스트를 반환합니다.
	    // 반환된 List<UserDTO>는 호출한 메소드에서 검색 결과를 사용할 수 있도록 전달됩니다.
	    // 여기서 반환된 리스트에는 검색된 모든 사용자 정보가 UserDTO 객체 형태로 저장되어 있습니다.
	    // 검색 결과가 없으면 빈 리스트가 반환되며, 검색된 데이터가 있을 경우 그 데이터를 포함한 리스트가 반환됩니다.
	}


	
} // UserDAO 클래스 종료
