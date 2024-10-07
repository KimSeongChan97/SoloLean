package user.dao.impl;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import user.bean.UserDTO;
import user.dao.UserDAO;

@Repository
@Transactional  // 클래스 레벨에서 트랜잭션을 전체적으로 적용
public class UserMybatisDAO implements UserDAO {

    @Autowired
    private SqlSession sqlSession;  // MyBatis의 SqlSession 주입

    // 사용자 정보 저장 (insert 기능)
    @Override
    public void write(UserDTO userDTO) {
        sqlSession.insert("userSQL.write", userDTO);  
    }

    // 모든 사용자 목록 가져오기
    @Override
    public List<UserDTO> getUserList() {
        return sqlSession.selectList("userSQL.getUserList");  
    }

    // 특정 ID의 사용자 존재 여부 확인
    @Override
    public UserDTO getExistId(String id) {
        return sqlSession.selectOne("userSQL.getExistId", id); 
    }

    // 사용자 정보 업데이트
    @Override
    public void update(Map<String, String> map) {
        sqlSession.update("userSQL.update", map); 
    }

    // 사용자 정보 삭제
    @Override
    public void delete(String id) {
        sqlSession.delete("userSQL.delete", id); 
    }
}
