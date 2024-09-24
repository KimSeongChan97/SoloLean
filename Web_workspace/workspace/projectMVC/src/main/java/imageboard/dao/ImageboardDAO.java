package imageboard.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import imageboard.bean.ImageboardDTO;

public class ImageboardDAO {
	private SqlSessionFactory sqlSessionFactory; 
	// **추가 설명**: MyBatis에서 데이터베이스와의 연결을 관리하는 SqlSessionFactory 객체를 생성하여 사용합니다. 이 객체는 세션(SqlSession)을 생성하는 역할을 합니다.
	// 한 번 생성된 SqlSessionFactory는 여러 개의 SqlSession을 생성할 수 있어 재사용이 가능합니다. 

	private static ImageboardDAO instance = new ImageboardDAO();
	// **추가 설명**: ImageboardDAO 클래스의 인스턴스를 싱글톤(Singleton) 패턴으로 관리합니다.
	// 싱글톤 패턴은 애플리케이션 전체에서 하나의 객체만 생성되도록 보장합니다. 이를 통해 메모리 효율성을 높이고, 동일한 자원을 여러 곳에서 사용할 수 있습니다.

	public static ImageboardDAO getInstance() {
		return instance; 
		// **추가 설명**: 싱글톤 패턴을 사용하여 인스턴스를 반환하는 메서드입니다. 외부에서 이 메서드를 호출하여 DAO 인스턴스에 접근합니다.
	}
	
	public ImageboardDAO() {
		try {
			// MyBatis의 설정 파일(mybatis-config.xml)을 읽어들여 SqlSessionFactory를 생성
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			// **추가 설명**: MyBatis 설정 파일을 읽기 위한 Reader 객체를 생성합니다. 이 설정 파일에는 데이터베이스 연결 정보와 매퍼(mapper) 경로가 정의되어 있습니다.
			// Resources.getResourceAsReader() 메서드는 파일 경로에 있는 자원을 읽어오는 역할을 합니다. 여기서는 'mybatis-config.xml' 파일을 읽어옵니다.

			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			// **추가 설명**: SqlSessionFactoryBuilder는 SqlSessionFactory를 생성하는 빌더 클래스입니다. Reader로 읽어온 설정 파일을 기반으로 SqlSessionFactory를 빌드하여 생성합니다.
			// SqlSessionFactory는 데이터베이스 연결과 SQL 실행에 필요한 SqlSession을 생성할 때 사용됩니다.
		} catch (IOException e) {
			e.printStackTrace();
			// **추가 설명**: 설정 파일을 읽는 과정에서 IOException이 발생할 수 있으므로, 예외 처리가 필요합니다. 예외가 발생하면 로그에 오류를 출력하고, 시스템이 정상적으로 작동하지 않을 수 있습니다.
		}
	}

	public void imageboardWrite(ImageboardDTO imageboardDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// **추가 설명**: sqlSessionFactory에서 SqlSession 객체를 생성합니다. SqlSession은 MyBatis에서 SQL 실행, 트랜잭션 관리 등을 담당하는 객체입니다.
		// openSession()은 새로운 세션을 열어 데이터베이스 작업을 수행할 수 있도록 합니다.

		sqlSession.insert("imageboardSQL.imageboardWrite", imageboardDTO);
		// **추가 설명**: SQL 매퍼 파일(imageboardSQL.xml)에서 "imageboardWrite"라는 ID를 가진 SQL 구문을 실행하여 이미지 데이터를 삽입합니다.
		// 여기서 imageboardDTO 객체에 저장된 데이터를 바탕으로 SQL 쿼리가 실행됩니다.

		sqlSession.commit();
		// **추가 설명**: 데이터베이스에 변경 사항을 적용하기 위해 commit()을 호출합니다. MyBatis에서는 기본적으로 수동 커밋 방식을 사용하므로, 명시적으로 커밋을 해줘야 데이터베이스에 반영됩니다.

		sqlSession.close();
		// **추가 설명**: 데이터베이스 작업이 완료되면 반드시 sqlSession을 닫아줘야 합니다. 이를 통해 자원 누수를 방지하고, 세션 풀에 반환됩니다.
	}

	public List<ImageboardDTO> imageboardList(Map<String, Integer> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// **추가 설명**: 새로운 SqlSession을 생성하여 데이터베이스와 연결을 시작합니다. 이 세션은 SQL 쿼리를 실행하고 결과를 처리하는 데 사용됩니다.

		List<ImageboardDTO> list = sqlSession.selectList("imageboardSQL.imageboardList", map);
		// **추가 설명**: SQL 매퍼에서 "imageboardList"라는 ID를 가진 쿼리를 실행하여 결과 목록을 반환합니다.
		// selectList() 메서드는 여러 개의 결과를 반환할 때 사용되며, 여기서는 Map 객체를 파라미터로 넘겨 쿼리에서 필요한 값을 사용합니다.
		// 결과는 ImageboardDTO 객체의 리스트 형태로 반환됩니다.

		sqlSession.close();
		// **추가 설명**: 쿼리 실행이 완료된 후에는 세션을 닫아 자원을 해제합니다.
		return list;
		// **추가 설명**: 쿼리 결과로 반환된 ImageboardDTO 객체들의 리스트를 반환합니다.
	}

	public int getTotalA() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// **추가 설명**: 새로운 SqlSession을 열어 데이터베이스에 연결합니다.

		int totalA = sqlSession.selectOne("imageboardSQL.getTotalA");
		// **추가 설명**: SQL 매퍼에서 "getTotalA"라는 ID를 가진 쿼리를 실행하여 하나의 결과값을 반환받습니다. 
		// selectOne() 메서드는 하나의 결과만을 기대할 때 사용되며, 반환값은 총 데이터의 개수를 나타내는 정수입니다.

		sqlSession.close();
		// **추가 설명**: 작업이 끝난 후 세션을 닫아 자원을 반환합니다.
		return totalA;
		// **추가 설명**: 쿼리 결과로 얻은 총 데이터의 개수를 반환합니다.
	}
	
	public void deleteSelected(List<Integer> seqList) {
	    SqlSession sqlSession = sqlSessionFactory.openSession();
	    sqlSession.delete("imageboardSQL.deleteSelected", seqList);
	    sqlSession.commit();
	    sqlSession.close();
	}

	
	
	
}
