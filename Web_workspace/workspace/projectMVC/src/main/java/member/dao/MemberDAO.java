
package member.dao;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.bean.MemberDTO;

public class MemberDAO {

    // 싱글톤 패턴 적용
    private static MemberDAO memberDAO = new MemberDAO();
    private SqlSessionFactory sqlSessionFactory;

    public static MemberDAO getInstance() {
        return memberDAO;
    }

    // MyBatis 세션 팩토리 생성
    private MemberDAO() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 아이디 존재 여부 확인 메서드
    public boolean isExistId(String id) {
        SqlSession session = sqlSessionFactory.openSession();
        boolean result = (Integer) session.selectOne("memberSQL.isExistId", id) != null;
        session.close();
        return result;
    }

    // 로그인 처리 메서드
    public MemberDTO login(String id, String password) {
        SqlSession session = sqlSessionFactory.openSession();
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(id);
        memberDTO.setPassword(password);
        MemberDTO result = session.selectOne("memberSQL.login", memberDTO);
        session.close();
        return result;
    }

    // 회원 정보 업데이트 메서드
    public void update(MemberDTO member) {
        SqlSession session = sqlSessionFactory.openSession(true); // Auto-commit mode
        session.update("memberSQL.update", member);
        session.close();
    }

    // 회원 등록 메서드
    public void write(MemberDTO member) {
        SqlSession session = sqlSessionFactory.openSession(true);
        session.insert("memberSQL.write", member);
        session.close();
    }

    // 회원 정보 조회 메서드 (getMember)
    public MemberDTO getMember(String id) {
        SqlSession session = sqlSessionFactory.openSession();
        MemberDTO memberDTO = session.selectOne("memberSQL.getMember", id);
        session.close();
        return memberDTO;
    }

    // 비밀번호 설정 메서드 (setPassword)
    public void setPassword(String id, String newPassword) {
        SqlSession session = sqlSessionFactory.openSession(true);
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(id);
        memberDTO.setPassword(newPassword);
        session.update("memberSQL.setPassword", memberDTO);
        session.close();
    }
}
