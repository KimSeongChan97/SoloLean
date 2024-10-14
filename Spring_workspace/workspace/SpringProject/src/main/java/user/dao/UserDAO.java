package user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import user.bean.UserDTO;

@Mapper // MyBatis와 연결을 담당하는 인터페이스임을 표시. MyBatis가 SQL을 매핑하여 처리
public interface UserDAO {

    public UserDTO getExistId(String id); // 아이디 중복 확인

    public void write(UserDTO userDTO); // 회원 정보 삽입
    
    public List<UserDTO> list(Map<String, Integer> map); // 사용자 리스트 조회
    
    public int getTotalA(); // 전체 사용자 수 조회
    
    public UserDTO getUser(String id); // ID로 사용자 정보 조회
    
    public void update(Map<String, String> map); // 사용자 정보 수정

	public UserDTO getExistPwd(String id);
    
	public void delete(String id);
	
}
