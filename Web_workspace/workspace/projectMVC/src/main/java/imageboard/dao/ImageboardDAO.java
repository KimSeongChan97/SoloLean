package imageboard.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import imageboard.bean.ImageboardDTO;


public class ImageboardDAO {
		private SqlSessionFactory sqlSessionFactory; 

	   private static ImageboardDAO instance = new ImageboardDAO();

	   public static ImageboardDAO getInstance() {
	      return instance; 
	   }
	   
	   
	   public ImageboardDAO() {
		      try {
		         // MyBatis의 설정 파일(mybatis-config.xml)을 읽어들여 SqlSessionFactory를 생성
		         Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		         sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		         // **추가 설명**: MyBatis는 설정 파일을 통해 데이터베이스와의 연결 정보를 설정합니다. 
		         // 'mybatis-config.xml' 파일에는 데이터베이스 연결 정보 및 맵퍼 파일 경로가 포함되어 있습니다. 이 파일을 읽어서 SqlSessionFactory 객체가 생성됩니다.
		      } catch (IOException e) {
		         e.printStackTrace();
		         // **추가 설명**: 설정 파일을 읽는 과정에서 IOException이 발생할 수 있으므로, 예외 처리가 필요합니다. 예외가 발생하면 로그에 오류를 출력하고, 시스템이 정상적으로 작동하지 않을 수 있습니다.
		      }
		   }


	public void imageboardWrite(ImageboardDTO imageboardDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("imageboardSQL.imageboardWrite", imageboardDTO);
		sqlSession.commit();
		sqlSession.close();
	}
	   
}
