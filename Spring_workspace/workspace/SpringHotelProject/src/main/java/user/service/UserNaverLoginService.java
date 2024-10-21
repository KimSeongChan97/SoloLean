package user.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import spring.conf.NaverLoginConfiguration;
import user.bean.UserDTO;

public interface UserNaverLoginService {

    // 네이버 로그인을 처리하는 메서드
    public String naverLogin(HttpSession session);
    // 네이버 로그인 요청을 처리하고, 네이버 로그인 API에 접속할 수 있는 URL을 생성하여 반환
    // session을 통해 사용자 세션 정보를 관리함

    // 네이버 로그인 콜백을 처리하여 사용자 정보를 가져오는 메서드
    public UserDTO loginNaver(Map<String, String> map, HttpSession session);
    // 네이버 로그인 인증 후, 사용자 정보를 가져오는 메서드
    // map에는 네이버 인증 과정에서 얻은 정보들이 담겨 있고, 이를 이용해 사용자 정보를 조회한 뒤
    // UserDTO 객체로 반환함
    // session을 통해 로그인된 사용자 정보를 저장 및 관리
}
