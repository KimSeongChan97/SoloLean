package user.service;

import java.util.Map;

import user.bean.UserDTO;

public interface UserService {
    
    public String getExistId(String id); // 아이디 중복 확인
    
    public void write(UserDTO userDTO); // 회원 정보 저장

    public Map<String, Object> list(String pg); // 사용자 리스트 조회
    
    public void update(UserDTO userDTO); // 사용자 정보 수정
    
    public UserDTO getUser(String id); // 사용자 정보 조회

    public UserDTO login(String id, String pwd); // 로그인 처리
    
    public UserDTO getExistPwd(String id); // 회원정보삭제 전에 비밀번호확인

	public void delete(String id); // 회원정보 삭제

	
}
