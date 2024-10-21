package user.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import user.bean.UserDTO;

@Mapper  // MyBatis의 매퍼 인터페이스임을 나타내며, SQL 매핑을 처리
public interface UserDAO {

    // 사용자 ID 중복 확인 메서드
    public int checkUserId(String userId);
    // 데이터베이스에서 userId가 이미 존재하는지 확인하여 결과를 반환
    // 반환 값: 중복된 경우 1, 중복되지 않은 경우 0

    // 새로운 사용자 회원가입 처리 메서드
    public void joinUser(UserDTO userDTO);
    // 회원가입 정보를 UserDTO 객체로 전달받아 데이터베이스에 삽입
    // UserDTO는 사용자 ID, 비밀번호, 이름 등의 정보를 포함

    // SH(자체 서비스) 로그인 처리 메서드
    public UserDTO loginSH(Map<String, String> map);
    // SH 로그인 정보를 담은 map(사용자 ID, 비밀번호 등)을 통해 사용자 정보를 조회
    // 조회된 사용자 정보를 UserDTO 객체로 반환 (로그인 성공 시)

    // 네이버 로그인 ID 확인 메서드
    public UserDTO checkNaverLoginId(String userId);
    // 네이버 로그인 시, 해당 userId가 기존 사용자 데이터베이스에 존재하는지 확인
    // 네이버 로그인 ID가 있는 경우 UserDTO 객체를 반환, 없는 경우 null 반환
}
