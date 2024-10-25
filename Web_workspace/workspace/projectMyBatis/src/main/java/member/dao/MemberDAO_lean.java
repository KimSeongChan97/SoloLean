package member.dao;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import member.bean.MemberDTO;

public class MemberDAO_lean {

    // 1. 싱글톤 인스턴스 생성 (MyBatis와 연동된 인스턴스를 사용)
    private static MemberDAO_lean memberDAO = new MemberDAO_lean();
    
    // MyBatis에서 SQL 세션을 생성하고 관리하는 SqlSessionFactory 객체
    private SqlSessionFactory sqlSessionFactory;

    // 2. 생성자
    // MyBatis 설정 파일인 'mybatis-config.xml'을 읽어 SqlSessionFactory를 초기화
    public MemberDAO_lean() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 3. 싱글톤 인스턴스를 반환하는 메소드
    public static MemberDAO_lean getInstance() {
        return memberDAO;
    }

    // 4. ID 중복 확인 메소드 (MyBatis의 selectOne 메소드 사용)
    public boolean isExistId(String id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        boolean exist = false;
        try {
            Integer count = sqlSession.selectOne("memberSQL_lean.idExistId", id);
            if (count != null && count > 0) {
                exist = true;
            }
        } finally {
            sqlSession.close();
        }
        return exist;
    }

    // 5. 회원 정보를 DB에 저장하는 메소드 (MyBatis의 insert 메소드 사용)
    public void memberWrite(MemberDTO memberDTO) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("memberSQL_lean.insertMemberlean", memberDTO);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    // 6. 로그인 메소드 (MyBatis의 selectOne 메소드 사용)
    public String[] memberLogin(String id, String pwd) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        String[] loginInfo = new String[3];
        try {
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setId(id);
            memberDTO.setPwd(pwd);

            MemberDTO resultDTO = sqlSession.selectOne("memberSQL_lean.memberLogin", memberDTO);
            if (resultDTO != null) {
                loginInfo[0] = resultDTO.getName();
                loginInfo[1] = resultDTO.getEmail1();
                loginInfo[2] = resultDTO.getEmail2();
            }
        } finally {
            sqlSession.close();
        }
        return loginInfo;
    }

    // 7. 회원 정보를 가져오는 메소드 (MyBatis의 selectOne 메소드 사용)
    public MemberDTO getMember(String id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        MemberDTO memberDTO;
        try {
            memberDTO = sqlSession.selectOne("memberSQL_lean.getMember", id);
        } finally {
            sqlSession.close();
        }
        return memberDTO;
    }

    // 8. 회원 정보를 수정하는 메소드 (MyBatis의 update 메소드 사용)
    public void updateMember(MemberDTO memberDTO) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.update("memberSQL_lean.updateMember", memberDTO);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
}
