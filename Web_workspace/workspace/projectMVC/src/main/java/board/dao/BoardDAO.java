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
   public static BoardDAO instance = new BoardDAO(); // 싱글톤 패턴으로 DAO 인스턴스를 하나만 생성하여 재사용
   
   public static BoardDAO getInstance() {
      return instance; // 외부에서 BoardDAO 인스턴스를 가져갈 수 있도록 getInstance() 메서드를 제공
   }
   
   public BoardDAO() {
      try {
         // MyBatis의 설정 파일(mybatis-config.xml)을 읽어들여 SqlSessionFactory를 생성
         Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
         // **추가 설명**: MyBatis의 SqlSessionFactory는 SQL 실행, 트랜잭션 관리 등의 작업을 수행할 수 있도록 세션을 생성하는 팩토리 역할을 함.
         // 'mybatis-config.xml' 파일에는 데이터베이스 연결 정보 및 맵퍼 설정 정보가 포함되어 있음.
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   // 게시글을 작성하는 메서드
   public void boardWrite(Map<String, String> map) {
      SqlSession sqlSession = sqlSessionFactory.openSession(); // 데이터베이스와의 연결을 열기 위해 SqlSession 객체를 생성
      sqlSession.insert("boardSQL.boardWrite", map); // 게시글을 삽입하는 SQL 문을 실행. 매개변수로 게시글 데이터를 담은 map을 전달
      sqlSession.commit(); // 삽입된 데이터를 커밋하여 데이터베이스에 반영
      sqlSession.close(); // SqlSession을 닫아 자원을 해제
      // **추가 설명**: SqlSession을 열면 그 세션을 통해 SQL 명령을 실행할 수 있으며, 여기서는 'boardWrite'라는 ID로 정의된 SQL 구문을 실행함.
      // 'commit()'을 호출하지 않으면 데이터가 실제로 DB에 반영되지 않음. 이는 트랜잭션을 처리할 때 중요한 부분임.
   }
   
   // 특정 범위의 게시글 목록을 가져오는 메서드 (페이징 처리)
   public List<BoardDTO> boardList(int startNum, int endNum) {
      Map<String, Integer> map = new HashMap<String, Integer>(); // 파라미터로 받은 시작번호와 끝번호를 Map에 저장
      map.put("startNum", startNum); // 시작 번호
      map.put("endNum", endNum); // 끝 번호
      
      SqlSession sqlSession = sqlSessionFactory.openSession(); // SqlSession을 열어 DB 작업을 시작
      List<BoardDTO> list = sqlSession.selectList("boardSQL.boardList", map); // 특정 범위의 게시글 목록을 가져오는 SQL을 실행하고 결과를 List로 반환
      sqlSession.close(); // SqlSession을 닫아 자원을 해제
      return list; // 결과 리스트 반환
      // **추가 설명**: 페이징 처리를 위해 'startNum'과 'endNum'을 설정하여 해당 범위의 게시글 목록만을 가져옴. 
      // 이때 'selectList()'는 여러 개의 결과를 가져오므로 List로 반환되며, 그 결과는 BoardDTO 객체들의 리스트가 됨.
   }
   
   // 게시글의 총 개수를 가져오는 메서드
   public int getTotalA() {
      int totalA = 0; // 게시글 총 개수를 저장할 변수
      SqlSession sqlSession = sqlSessionFactory.openSession(); // SqlSession을 열어 DB 작업을 시작
      totalA = sqlSession.selectOne("boardSQL.getTotalA"); // 게시글 총 개수를 가져오는 SQL 실행, 결과는 정수로 반환됨
      sqlSession.close(); // SqlSession을 닫아 자원을 해제
      return totalA; // 게시글 총 개수 반환
      // **추가 설명**: 'selectOne()' 메서드는 SQL 결과가 하나의 값(단일 결과)일 때 사용하며, 여기서는 총 게시글 수를 반환함.
      // 페이징 처리를 하거나 전체 게시글 수를 보여줄 때 이 메서드를 사용함.
   }
}
