package member.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.bean.MemberDTO;

public class MemberDAO {

    // **1. 싱글톤 인스턴스 생성 (MyBatis와 연동된 인스턴스를 사용)**
    // **싱글톤 패턴으로 MemberDAO 인스턴스를 생성합니다. 이를 통해 DAO 객체가 애플리케이션 내에서 단 하나만 생성되어 사용됩니다.**
    // **MyBatis를 사용해 DB 연동을 처리합니다. MyBatis는 SQL 쿼리와 Java 객체를 쉽게 연결하는 프레임워크입니다.**
    // 싱글톤 패턴은 객체의 생성을 한 번만 하여 시스템 전체에서 동일한 인스턴스를 공유할 수 있게 해줍니다. 
    // DB 연결을 반복적으로 새로 만들지 않기 때문에 자원을 효율적으로 사용할 수 있습니다.
    private static MemberDAO memberDAO = new MemberDAO();
    
    // **MyBatis에서 SQL 세션을 생성하고 관리하는 SqlSessionFactory 객체**
    // **SqlSessionFactory는 SQL 실행을 위한 SqlSession 객체를 생성해주는 역할을 합니다.** 
    // **이 SqlSession 객체는 실제로 SQL 쿼리를 실행하고 DB와 상호작용하는 중요한 역할을 합니다.**
    // SqlSessionFactory는 MyBatis의 설정 파일을 기반으로 DB와의 연결 정보를 저장하고 필요할 때마다 SQL 실행을 담당하는 SqlSession 객체를 만들어줍니다.
    private SqlSessionFactory sqlSessionFactory;

    // **2. 생성자**
    // **MyBatis 설정 파일인 'mybatis-config.xml'을 읽어 SqlSessionFactory를 초기화합니다.**
    // **'mybatis-config.xml' 파일에는 MyBatis 설정 정보(예: DB 연결 설정, 매퍼 파일 경로)가 포함되어 있습니다.**
    // **Resources.getResourceAsReader() 메서드를 통해 클래스 경로에서 mybatis-config.xml 파일을 읽어옵니다.**
    // **SqlSessionFactoryBuilder는 설정 파일을 기반으로 SqlSessionFactory를 생성합니다.**
    // mybatis-config.xml 파일은 MyBatis의 핵심 설정 파일로, 데이터베이스 연결 설정과 SQL 매퍼 파일 위치를 지정하는 역할을 합니다.
    public MemberDAO() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml"); 
            // Resources.getResourceAsReader는 MyBatis에서 제공하는 유틸리티 메서드로, 클래스패스 내에서 파일을 읽어옵니다.
            // 설정 파일의 위치는 'src/main/resources'와 같은 클래스패스 내에 있어야 하며, 정확한 파일 경로가 맞는지 확인이 필요합니다.
            
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader); 
            // SqlSessionFactoryBuilder는 Reader 객체로부터 SqlSessionFactory를 생성합니다.
            // 이 객체는 SQL 세션을 생성하여 데이터베이스에 대한 쿼리를 실행할 수 있게 해줍니다.
        } catch (IOException e) {
            e.printStackTrace(); // **파일을 읽어오는 도중에 문제가 발생하면 예외를 처리합니다.**
            // 파일 경로가 잘못되었거나 파일이 존재하지 않으면 IOException이 발생합니다. 이 경우 로그에 오류를 남깁니다.
        }
    }

    // **3. 싱글톤 인스턴스를 반환하는 메소드**
    // **getInstance() 메서드를 통해 전역에서 동일한 MemberDAO 인스턴스를 공유하여 사용할 수 있습니다.**
    // **이 메서드는 MemberDAO의 유일한 인스턴스를 반환하여 여러 곳에서 사용할 수 있게 합니다.**
    // 싱글톤 패턴에서 getInstance 메서드는 객체의 유일한 인스턴스를 반환해줍니다. 객체가 이미 존재하면 기존 인스턴스를 반환하고, 없다면 새로 생성합니다.
    public static MemberDAO getInstance() {
        return memberDAO;
    }

    // **4. ID 중복 확인 메소드 (MyBatis의 selectOne 메소드 사용)**
    // **사용자가 입력한 ID가 DB에 존재하는지 확인하는 메서드입니다.**
    // **중복된 ID가 있는 경우, true를 반환하고 그렇지 않으면 false를 반환합니다.**
    // **MyBatis의 selectOne 메서드를 사용하여 SQL 쿼리를 실행하고, 결과가 1개일 때 이를 반환합니다.**
    // 사용자가 입력한 ID가 DB에 이미 존재하는지 확인하는 것은 회원가입 시 중요한 과정입니다. 
    // SQL 쿼리에서 COUNT 함수를 사용해 해당 ID의 개수를 확인한 후, 그 값에 따라 중복 여부를 반환합니다.
    public boolean idExistId(String id) {
        SqlSession sqlSession = sqlSessionFactory.openSession(); 
        // **SqlSession 객체를 사용하여 DB와의 연결을 열고 SQL을 실행할 준비를 합니다.**
        // SqlSession은 MyBatis에서 DB와 상호작용하는 주요 인터페이스로, SQL 쿼리를 실행하고 결과를 반환합니다.
        boolean exist = false; 
        // **기본값으로 중복되지 않았음을 의미하는 false를 설정합니다.**
        // ID가 중복되지 않으면 기본값인 false를 반환합니다.
        try {
            Integer count = sqlSession.selectOne("memberSQL.idExistId", id); 
            // **MyBatis 매퍼 파일에서 "memberSQL.idExistId"에 정의된 SQL 쿼리를 실행합니다.**
            // "memberSQL.idExistId"는 MyBatis 매퍼 파일에서 정의된 SQL ID로, 주어진 id 값이 member 테이블에 존재하는지 확인합니다.
            
            if (count != null && count > 0) { 
                // **count 값이 null이 아니고, 0보다 큰 경우 ID가 중복되었음을 의미합니다.**
                // SQL 쿼리 결과가 0보다 크면 해당 ID가 DB에 존재하므로 중복입니다.
                exist = true; // **ID 중복이 확인되면 true로 설정합니다.**
            }
        } finally {
            sqlSession.close(); 
            // **자원을 해제하기 위해 사용한 SqlSession을 반드시 닫아줍니다.**
            // SQL 실행이 끝나면 반드시 세션을 닫아 자원 누수를 방지합니다.
        }
        return exist; // **ID 중복 여부를 반환합니다.**
    }

    // **5. 회원 정보를 DB에 저장하는 메소드 (MyBatis의 insert 메소드 사용)**
    // **회원가입 시 사용자가 입력한 회원 정보를 DB에 저장하는 메서드입니다.**
    // **MemberDTO 객체를 받아와 DB에 삽입하는 역할을 합니다.**
    // MyBatis의 insert 메서드는 SQL의 INSERT INTO 문을 실행하여 데이터를 DB에 삽입하는 역할을 합니다.
    public void memberWrite(MemberDTO memberDTO) {
        SqlSession sqlSession = sqlSessionFactory.openSession(); 
        // **SqlSession을 통해 SQL 실행을 위한 DB 연결을 엽니다.**
        try {
            sqlSession.insert("memberSQL.insertMember", memberDTO); 
            // **MyBatis의 insert 메서드를 사용하여 memberSQL.insertMember 쿼리를 실행하고, MemberDTO 객체의 데이터를 삽입합니다.**
            // SQL 매퍼 파일에서 "memberSQL.insertMember"에 정의된 SQL 구문이 실행되어 DB에 데이터를 삽입합니다.
            sqlSession.commit(); 
            // **데이터베이스 트랜잭션을 커밋하여 실제로 데이터를 저장합니다.**
            // DB의 트랜잭션 처리 방식으로, commit을 호출해야만 데이터가 실제로 저장됩니다.
        } finally {
            sqlSession.close(); 
            // **SqlSession을 닫아 DB 자원을 해제합니다.**
        }
    }

    // **6. 로그인 메소드 (MyBatis의 selectOne 메소드 사용)**
    // **사용자가 입력한 ID와 비밀번호를 확인하여 로그인 여부를 판단하는 메서드입니다.**
    // **입력받은 ID와 비밀번호가 일치하면 사용자의 이름, 이메일 정보를 반환하고, 일치하지 않으면 null을 반환합니다.**
    // 로그인 시에는 사용자가 입력한 ID와 비밀번호가 DB에 저장된 정보와 일치하는지 확인하는 것이 중요합니다.
    public String[] memberLogin(String id, String pwd) {
        SqlSession sqlSession = sqlSessionFactory.openSession(); 
        // **SqlSession을 열어 SQL 쿼리 실행 준비를 합니다.**
        String[] loginInfo = new String[3]; 
        // **로그인 정보(이름, 이메일1, 이메일2)를 저장할 배열을 생성합니다.**
        // 로그인 성공 시 반환할 회원 정보를 저장할 배열입니다.
        try {
            MemberDTO memberDTO = new MemberDTO(); 
            // **MemberDTO 객체를 생성하여 사용자로부터 입력받은 ID와 비밀번호를 설정합니다.**
            // 회원 정보를 담고 있는 DTO(Data Transfer Object)로, MyBatis가 자동으로 매핑합니다.
            memberDTO.setId(id);
            memberDTO.setPwd(pwd);

            MemberDTO resultDTO = sqlSession.selectOne("memberSQL.memberLogin", memberDTO); 
            // **memberMapper.xml에 정의된 "memberSQL.memberLogin" 쿼리를 실행하여, 입력받은 ID와 비밀번호에 해당하는 회원 정보를 조회합니다.**
            // selectOne은 쿼리 결과가 하나일 때 사용하는 메서드로, 로그인 시에는 ID와 비밀번호가 일치하는 한 사람의 정보만을 가져와야 합니다.
            
            if (resultDTO != null) { 
                // **결과가 null이 아니라면, 즉 로그인 성공 시 회원 정보를 배열에 저장합니다.**
                loginInfo[0] = resultDTO.getName(); // **이름 저장**
                loginInfo[1] = resultDTO.getEmail1(); // **이메일 앞부분 저장**
                loginInfo[2] = resultDTO.getEmail2(); // **이메일 뒷부분 저장**
            }
        } finally {
            sqlSession.close(); 
            // **SqlSession을 닫아 DB 자원을 해제합니다.**
        }
        return loginInfo; // **로그인 결과를 반환합니다. 성공하면 회원 정보가 저장된 배열, 실패하면 null 값이 포함된 배열이 반환됩니다.**
    }


    // **7. 회원 정보를 가져오는 메소드 (MyBatis의 selectOne 메소드 사용)**
    // **사용자의 ID를 통해 회원 정보를 조회하는 메서드입니다.**
    // **getMember 메서드는 DB에서 주어진 ID에 해당하는 회원 정보를 가져옵니다.**
    // 사용자가 로그인 후 회원 정보를 수정하거나 조회할 때, 해당 ID에 대한 정보를 가져옵니다.
    public MemberDTO getMember(String id) {
        SqlSession sqlSession = sqlSessionFactory.openSession(); 
        // **SqlSession을 열어 SQL 쿼리 실행 준비를 합니다.**
        MemberDTO memberDTO; 
        // **결과를 저장할 MemberDTO 객체를 선언합니다.**
        // DB로부터 조회한 회원 정보를 담을 DTO 객체입니다.
        try {
            memberDTO = sqlSession.selectOne("memberSQL.getMember", id); 
            // **"memberSQL.getMember"에 정의된 쿼리를 실행하여 주어진 ID에 해당하는 회원 정보를 조회합니다.**
            // 회원의 ID를 기반으로 DB에서 해당 회원의 상세 정보를 조회합니다.
        } finally {
            sqlSession.close(); 
            // **SqlSession을 닫아 자원을 해제합니다.**
        }
        return memberDTO; // **조회된 회원 정보를 반환합니다.**
    }

    // **8. 회원 정보를 수정하는 메소드 (MyBatis의 update 메소드 사용)**
    // **회원 정보를 수정하는 메서드입니다.**
    // **사용자가 입력한 회원 정보를 MemberDTO로 받아와, DB에서 해당 ID의 회원 정보를 수정합니다.**
    // 사용자가 자신의 정보를 수정할 때, 해당 변경 사항을 DB에 반영합니다.
    public void updateMember(MemberDTO memberDTO) {
        SqlSession sqlSession = sqlSessionFactory.openSession(); 
        // **SqlSession을 열어 SQL 쿼리 실행 준비를 합니다.**
        try {
            sqlSession.update("memberSQL.updateMember", memberDTO); 
            // **"memberSQL.updateMember"에 정의된 쿼리를 사용하여 해당 회원의 정보를 업데이트합니다.**
            // MyBatis의 update 메서드는 DB에 저장된 데이터를 변경합니다. 이때 매퍼 파일에 정의된 SQL 문이 실행됩니다.
            sqlSession.commit(); 
            // **트랜잭션을 커밋하여 수정된 데이터를 DB에 반영합니다.**
        } finally {
            sqlSession.close(); 
            // **SqlSession을 닫아 DB 자원을 해제합니다.**
        }
    }
}
