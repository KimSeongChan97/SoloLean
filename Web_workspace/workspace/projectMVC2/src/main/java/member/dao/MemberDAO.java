package member.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.bean.MemberDTO;

public class MemberDAO {
	private SqlSessionFactory sqlSessionFactory; // MyBatis의 SqlSessionFactory 객체로, DB 연결을 관리하고 SQL 실행에 사용.
	private static MemberDAO instance = new MemberDAO(); // 싱글톤 패턴으로 MemberDAO 인스턴스 하나만을 생성.
	
	// 싱글톤 패턴에서 사용되는 getInstance() 메서드. 이 메서드를 통해 외부에서 MemberDAO 인스턴스를 얻는다.
	public static MemberDAO getInstance() {
		return instance;
	}
	
	// MemberDAO 생성자. MyBatis 설정 파일(mybatis-config.xml)을 읽고 SqlSessionFactory를 생성하는 역할.
	public MemberDAO() {
		try {
			// MyBatis 설정 파일을 읽어 Reader 객체를 생성. 설정 파일의 경로는 "mybatis-config.xml"이다.
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			// SqlSessionFactoryBuilder를 사용하여 SqlSessionFactory를 생성.
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// 설정 파일을 읽는 과정에서 예외가 발생할 경우 예외 메시지를 출력.
			e.printStackTrace();
		}
	}
	
	// 아이디 중복 체크를 위한 메서드. 
	// 파라미터로 전달된 id가 데이터베이스에 이미 존재하는지 확인하고, 존재하면 true를 반환.
	// selectOne 메서드를 통해 DB에서 해당 id의 데이터를 조회하고, null이 아니면 존재한다고 판단.
	public boolean isExistId(String id){
		boolean exist = false; // 기본적으로 존재하지 않는 것으로 설정.
		// SqlSession 객체를 통해 데이터베이스와 연결하고 SQL 쿼리를 실행.
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// MyBatis 매퍼 파일의 'isExistId' 쿼리를 실행하여 해당 id가 존재하는지 확인.
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.isExistId", id);
		// id가 존재하면 exist를 true로 설정.
		if(memberDTO != null) exist = true; // id가 존재하면 사용 불가 상태로 설정.
		sqlSession.close(); // 사용한 SqlSession을 닫는다.
		return exist; // 결과를 반환.
	}
	
	// 회원가입을 위한 메서드.
	// 파라미터로 전달된 MemberDTO 객체를 사용하여 회원 정보를 데이터베이스에 삽입.
	public void write(MemberDTO memberDTO) {		
		SqlSession sqlSession = sqlSessionFactory.openSession(); // SqlSession을 열어 DB와 연결.
		// 매퍼 파일의 'write' 쿼리를 실행하여 회원 정보를 DB에 삽입.
		sqlSession.insert("memberSQL.write", memberDTO);
		sqlSession.commit(); // 데이터베이스에 삽입된 내용을 확정(commit)한다.
		sqlSession.close(); // 연결을 닫는다.
	}
	
	// 로그인 처리를 위한 메서드.
	// 파라미터로 전달된 id와 pwd를 사용하여 데이터베이스에서 해당 회원 정보를 조회.
	public MemberDTO login(String id, String pwd){
		// 파라미터로 전달된 id와 pwd를 Map에 담아 SQL 쿼리에 전달.
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pwd", pwd);
		
		SqlSession sqlSession = sqlSessionFactory.openSession(); // SqlSession을 열어 DB와 연결.
		// 매퍼 파일의 'login' 쿼리를 실행하여 id와 pwd가 일치하는 회원 정보를 조회.
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.login", map);
		sqlSession.close(); // 연결을 닫는다.
		return memberDTO; // 조회된 회원 정보를 반환.
	}
	
	// 특정 id에 해당하는 회원 정보를 조회하는 메서드.
	// 회원의 id를 파라미터로 받아서 그에 해당하는 정보를 데이터베이스에서 조회하여 반환.
	public MemberDTO getMember(String id){
		SqlSession sqlSession = sqlSessionFactory.openSession(); // SqlSession을 열어 DB와 연결.
		// 매퍼 파일의 'getMember' 쿼리를 실행하여 특정 id에 해당하는 회원 정보를 조회.
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.getMember", id);
		sqlSession.close(); // 연결을 닫는다.
		return memberDTO; // 조회된 회원 정보를 반환.
	}
	
	// 회원 정보 수정을 위한 메서드.
	// 수정된 회원 정보를 파라미터로 받아서 해당 회원 정보를 데이터베이스에 업데이트.
	public void update(MemberDTO memberDTO){
		SqlSession sqlSession = sqlSessionFactory.openSession(); // SqlSession을 열어 DB와 연결.
		// 매퍼 파일의 'update' 쿼리를 실행하여 특정 id의 회원 정보를 업데이트.
		sqlSession.update("memberSQL.update", memberDTO);
		sqlSession.commit(); // 업데이트된 내용을 데이터베이스에 반영.
		sqlSession.close(); // 연결을 닫는다.
	}
}
