package user.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import user.bean.UserDTO;

public interface UserService {

    // 네이버 로그인 API 호출을 위한 URL 생성
    public String login(HttpSession session);
    // 네이버 로그인 API URL을 생성하여 반환하는 메서드
    // session 객체를 사용하여 로그인 요청과 관련된 사용자 세션 정보를 관리

    // 네이버 로그인 처리 후 사용자 정보를 가져오는 메서드
    public UserDTO loginNaver(Map<String, String> map, HttpSession session);
    // 네이버 로그인 성공 후 네이버에서 제공된 데이터를 기반으로 사용자 정보를 가져옴
    // map에는 네이버 인증과정에서 획득한 데이터가 들어 있으며, 이를 사용하여 사용자 정보를 조회
    // 조회된 사용자 정보는 UserDTO 객체로 반환
    // session을 통해 로그인된 사용자 정보를 세션에 저장 및 관리

    // 자체(SH) 로그인 처리 메서드
    public Boolean loginSH(Map<String, String> map, HttpSession session);
    // SH(자체 로그인) 시스템을 통해 사용자의 ID와 비밀번호를 확인하고 로그인 처리
    // map에는 ID와 비밀번호 정보가 들어있으며, 로그인 성공 여부를 Boolean 값으로 반환
    // 성공 시 세션에 사용자 정보를 저장

    // 사용자 ID 중복 확인 메서드
    public boolean checkUserId(String userid);
    // 사용자 ID 중복 여부를 확인하는 메서드
    // 데이터베이스에서 해당 ID가 존재하는지 확인하고, 중복 여부를 반환

    // 회원가입 처리 메서드
    public void joinSubmit(UserDTO userDTO);
    // 회원가입 요청을 처리하는 메서드
    // userDTO 객체에 사용자의 회원가입 정보(ID, 비밀번호, 이름 등)를 담아 데이터베이스에 저장
}
