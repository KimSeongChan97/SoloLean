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
    private SqlSessionFactory sqlSessionFactory;
    private static BoardDAO instance = new BoardDAO();
    
    // getInstance() 메서드는 싱글톤 패턴을 적용하기 위해 사용된다.
    // BoardDAO 객체는 애플리케이션 내에서 단 하나만 생성되어야 하므로, 이 메서드를 통해서만 인스턴스를 얻을 수 있다.
    public static BoardDAO getInstance() {
        return instance;
    }
    
    // 생성자에서 MyBatis의 설정 파일을 읽고 SqlSessionFactory 객체를 생성한다.
    // mybatis-config.xml 파일을 읽어서 MyBatis 환경을 설정하고, 이 설정을 기반으로 SqlSessionFactory를 생성한다.
    // SqlSessionFactory는 데이터베이스와의 연결을 관리하고, 이를 통해 MyBatis의 기능을 사용할 수 있게 한다.
    public BoardDAO() {
        try {
            // Resources.getResourceAsReader()는 MyBatis 설정 파일을 읽기 위한 Reader 객체를 반환한다.
            // "mybatis-config.xml"은 MyBatis 설정 파일 경로를 나타낸다.
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            // SqlSessionFactoryBuilder는 설정 파일을 기반으로 SqlSessionFactory 객체를 생성하는 역할을 한다.
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            // 예외가 발생하면 스택 트레이스를 출력하여 어디서 문제가 발생했는지 확인할 수 있도록 한다.
            e.printStackTrace();
        }
    }
    
    // boardWrite() 메서드는 게시글을 데이터베이스에 삽입하는 역할을 한다.
    // 파라미터로 전달된 Map 객체는 게시글의 정보(id, name, email, subject 등)를 담고 있다.
    // SqlSession을 사용하여 MyBatis 매퍼 파일(boardSQL.xml)에서 정의한 boardWrite 쿼리를 호출하여 데이터를 삽입한다.
    // 쿼리가 실행된 후에는 데이터베이스에 변경된 사항을 반영하기 위해 commit() 메서드를 호출하고, 연결을 닫는다.
    public void boardWrite(Map<String, String> map) {
        // openSession()은 데이터베이스와의 연결을 생성하고 SqlSession 객체를 반환한다.
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // insert() 메서드는 매퍼 파일의 boardWrite 쿼리를 실행하여 데이터베이스에 데이터를 삽입한다.
        // 첫 번째 인자는 매퍼 파일 내의 쿼리 id("boardSQL.boardWrite")를, 두 번째 인자는 삽입할 데이터를 담고 있는 map 객체를 전달한다.
        sqlSession.insert("boardSQL.boardWrite", map);
        // commit() 메서드는 데이터베이스에 변경 사항을 영구적으로 반영한다.
        sqlSession.commit();
        // close() 메서드는 SqlSession을 닫고 데이터베이스 연결을 종료한다.
        sqlSession.close();
    }
    
    // getTotalA() 메서드는 게시판에 저장된 총 게시글 수를 반환하는 역할을 한다.
    // SqlSession을 사용하여 MyBatis 매퍼 파일에서 정의한 getTotalA 쿼리를 호출하고, 그 결과로 총 게시글 수를 가져온다.
    public int getTotalA() {
        int totalA = 0;
        // openSession()을 통해 데이터베이스와의 연결을 생성한다.
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // selectOne() 메서드는 하나의 결과를 반환하는 쿼리를 실행할 때 사용된다.
        // 여기서는 총 게시글 수를 조회하는 쿼리("boardSQL.getTotalA")를 실행한다.
        sqlSession.selectOne("boardSQL.getTotalA");
        // SqlSession을 닫고 데이터베이스 연결을 종료한다.
        sqlSession.close();
        // totalA는 현재 초기화되지 않았고, 실제로는 selectOne()의 반환값을 할당해야 하지만 여기선 코드에 해당 내용이 없다.
        // 이를 수정하려면 selectOne()의 결과를 totalA에 할당해야 한다. (예: totalA = sqlSession.selectOne("boardSQL.getTotalA");)
        return totalA;
    }
    
    // boardList() 메서드는 지정된 범위(startNum, endNum)에 해당하는 게시글 목록을 반환한다.
    // 게시글을 페이징 처리하여 일정 범위의 게시글만 가져올 수 있도록 한다.
    public List<BoardDTO> boardList(int startNum, int endNum) {
        // 페이징 처리를 위한 startNum(시작 번호)과 endNum(끝 번호)을 Map에 저장한다.
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("startNum", startNum);
        map.put("endNum", endNum);
        
        // openSession()을 통해 데이터베이스와의 연결을 생성한다.
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // selectList() 메서드는 여러 개의 결과를 반환하는 쿼리를 실행할 때 사용된다.
        // 여기서는 페이징 처리를 위해 startNum과 endNum을 전달하여 해당 범위에 속하는 게시글 목록을 가져온다.
        List<BoardDTO> list = sqlSession.selectList("boardSQL.boardList", map);
        // SqlSession을 닫고 데이터베이스 연결을 종료한다.
        sqlSession.close();
        
        // 게시글 목록(list)을 반환한다.
        return list;
    }
    
}
