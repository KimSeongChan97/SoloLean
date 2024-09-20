package board.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.bean.BoardDTO;

public class BoardDAO {
   private SqlSessionFactory sqlSessionFactory; // MyBatis의 SqlSessionFactory를 통해 세션을 열어 데이터베이스와 상호작용함
   // **추가 설명**: SqlSessionFactory는 MyBatis에서 SQL 쿼리 실행과 트랜잭션 관리를 처리할 수 있는 세션(SqlSession)을 생성하는 공장 역할을 합니다.
   // 이 객체는 애플리케이션이 시작할 때 한 번만 생성되고, 필요할 때마다 재사용되어 성능을 최적화합니다.

   public static BoardDAO instance = new BoardDAO(); // 싱글톤 패턴으로 DAO 인스턴스를 하나만 생성하여 재사용
   // **추가 설명**: 싱글톤 패턴을 사용하여 DAO 객체를 하나만 생성하고, 여러 곳에서 재사용할 수 있도록 보장합니다. 
   // 이는 메모리 낭비를 줄이고, 객체가 여러 번 생성되는 것을 방지합니다. 인스턴스는 클래스 로드 시 한 번만 생성됩니다.

   public static BoardDAO getInstance() {
      return instance; // 외부에서 BoardDAO 인스턴스를 가져갈 수 있도록 getInstance() 메서드를 제공
      // **추가 설명**: 이 메서드는 외부 클래스가 싱글톤 객체를 가져갈 수 있도록 접근을 제공합니다. 
      // 프로그램 내에서 어디서든 `BoardDAO.getInstance()`를 호출해 동일한 인스턴스를 사용할 수 있습니다.
   }
   
   public BoardDAO() {
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
   
   // 게시글을 작성하는 메서드
   public void boardWrite(Map<String, String> map) {
      SqlSession sqlSession = sqlSessionFactory.openSession(); // 데이터베이스와의 연결을 열기 위해 SqlSession 객체를 생성
      // **추가 설명**: SqlSession은 MyBatis에서 SQL을 실행하고 트랜잭션을 관리하는 핵심 객체입니다. 
      // SQL 실행, 트랜잭션 관리 등을 위한 데이터베이스 연결을 담당하며, 세션이 열리면 SQL 작업을 수행할 수 있습니다.

      sqlSession.insert("boardSQL.boardWrite", map); // 게시글을 삽입하는 SQL 문을 실행. 매개변수로 게시글 데이터를 담은 map을 전달
      // **추가 설명**: MyBatis는 XML에 정의된 "boardSQL.boardWrite"라는 ID를 가진 SQL 쿼리를 실행합니다. 
      // `map`은 게시글의 제목, 내용 등의 데이터를 포함하고 있으며, 이를 SQL에 전달하여 게시글을 삽입합니다.

      sqlSession.commit(); // 삽입된 데이터를 커밋하여 데이터베이스에 반영
      // **추가 설명**: MyBatis는 자동 커밋 기능을 제공하지 않으므로, 명시적으로 `commit()` 메서드를 호출하여 데이터베이스에 변경사항을 반영해야 합니다. 
      // 트랜잭션이 완료되었음을 명시적으로 알려주는 역할을 하며, 이를 호출하지 않으면 변경사항이 반영되지 않고 롤백될 수 있습니다.

      sqlSession.close(); // SqlSession을 닫아 자원을 해제
      // **추가 설명**: 데이터베이스와의 연결이 끝나면 세션을 반드시 닫아야 합니다. 자원을 해제하고, 연결을 반환함으로써 메모리 누수를 방지합니다.
   }
   
   // 특정 범위의 게시글 목록을 가져오는 메서드 (페이징 처리)
   public List<BoardDTO> boardList(int startNum, int endNum) {
      Map<String, Integer> map = new HashMap<String, Integer>(); // 파라미터로 받은 시작번호와 끝번호를 Map에 저장
      map.put("startNum", startNum); // 시작 번호
      map.put("endNum", endNum); // 끝 번호
      // **추가 설명**: Map은 SQL 쿼리에 여러 파라미터를 전달하기 위한 자료구조로 사용됩니다. 
      // 여기서는 `startNum`과 `endNum`을 담아 특정 범위의 게시글 목록을 가져오기 위해 사용됩니다.

      SqlSession sqlSession = sqlSessionFactory.openSession(); // SqlSession을 열어 DB 작업을 시작
      // **추가 설명**: 데이터베이스 작업을 수행하기 위해 SqlSession을 엽니다. 이 세션을 통해 SQL 쿼리를 실행할 수 있습니다.

      List<BoardDTO> list = sqlSession.selectList("boardSQL.boardList", map); // 특정 범위의 게시글 목록을 가져오는 SQL을 실행하고 결과를 List로 반환
      // **추가 설명**: `selectList()` 메서드는 여러 개의 결과를 반환할 때 사용합니다. 
      // 여기서 SQL 쿼리를 실행하여 `startNum`부터 `endNum`까지의 게시글 목록을 가져오며, 결과는 `BoardDTO` 객체의 리스트로 반환됩니다.

      sqlSession.close(); // SqlSession을 닫아 자원을 해제
      // **추가 설명**: 데이터베이스 작업이 끝난 후에는 세션을 닫아야 자원을 효율적으로 사용할 수 있습니다.

      return list; // 결과 리스트 반환
      // **추가 설명**: 결과로 반환된 `List<BoardDTO>` 객체는 호출한 메서드로 반환됩니다. 이 리스트는 해당 페이지에 보여줄 게시글 목록을 담고 있습니다.
   }
   
   // 게시글의 총 개수를 가져오는 메서드
   public int getTotalA() {
      int totalA = 0; // 게시글 총 개수를 저장할 변수
      SqlSession sqlSession = sqlSessionFactory.openSession(); // SqlSession을 열어 DB 작업을 시작
      // **추가 설명**: SQL 쿼리를 실행하기 위해 새로운 세션을 열고, 데이터베이스와의 연결을 엽니다.

      totalA = sqlSession.selectOne("boardSQL.getTotalA"); // 게시글 총 개수를 가져오는 SQL 실행, 결과는 정수로 반환됨
      // **추가 설명**: `selectOne()` 메서드는 단일 결과를 반환할 때 사용됩니다. 
      // 여기서는 게시글의 총 개수를 가져오는 SQL 쿼리를 실행하고, 그 결과를 정수로 반환받습니다. 이 값은 페이징 처리 시 전체 페이지 수를 계산하는 데 사용됩니다.

      sqlSession.close(); // SqlSession을 닫아 자원을 해제
      // **추가 설명**: 작업이 끝나면 반드시 세션을 닫아 자원을 효율적으로 사용해야 합니다.

      return totalA; // 게시글 총 개수 반환
      // **추가 설명**: 결과로 반환된 게시글의 총 개수는 호출한 메서드에서 페이징 계산이나 화면 표시 등에 사용됩니다.
   }

   // 특정 게시글을 가져오는 메서드
   public BoardDTO getBoard(int seq) {
      SqlSession sqlSession = sqlSessionFactory.openSession(); // 데이터베이스와 연결하여 세션을 시작
      // **추가 설명**: 특정 게시글을 가져오기 위해 `SqlSession`을 열어 데이터베이스와 연결을 엽니다.
      try {
      sqlSession.update("hitUpdate", seq);
      BoardDTO boardDTO = sqlSession.selectOne("getBoard", seq); // 'getBoard' SQL 문을 실행하고 결과를 BoardDTO로 반환
      // **추가 설명**: `selectOne()`은 SQL 실행 결과가 하나일 때 사용되며, 이 경우 `seq` 값에 해당하는 게시글 하나를 가져옵니다. 
      // "getBoard"는 MyBatis XML 매퍼 파일에 정의된 SQL 구문이며, `seq` 파라미터로 전달받은 게시글 번호에 해당하는 데이터를 조회합니다.
      sqlSession.commit();      
      return boardDTO; // 결과로 반환된 BoardDTO 객체를 호출한 메서드로 반환
      // **추가 설명**: `boardDTO`는 데이터베이스에서 조회한 게시글의 상세 정보가 담긴 객체입니다. 이 객체는 게시글의 제목, 내용, 작성자 등의 정보를 담고 있으며, 호출한 메서드로 반환됩니다.
   } finally {
	   sqlSession.close(); // 세션을 닫아 자원을 해제
	      // **추가 설명**: 세션을 닫음으로써 연결된 리소스를 반환하고, 메모리 누수를 방지할 수 있습니다.
   }
  } 
   
	// 게시글 수정
	public void updateBoard(Map<String, String> map) {
	    SqlSession sqlSession = sqlSessionFactory.openSession();
	    try {
	        sqlSession.update("boardSQL.updateBoard", map); // update 쿼리를 실행
	        sqlSession.commit(); // 커밋하여 변경사항 반영
	    } finally {
	        sqlSession.close(); // 세션 닫기
	    }
	}

   // 게시글 삭제
   public void deleteBoard(int seq) {
	    SqlSession sqlSession = sqlSessionFactory.openSession();
	    sqlSession.delete("boardSQL.deleteBoard", seq);
	    sqlSession.commit();
	    sqlSession.close();
	}
   
   
}
