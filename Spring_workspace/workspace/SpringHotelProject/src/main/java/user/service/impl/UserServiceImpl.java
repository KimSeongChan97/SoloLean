package user.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.conf.NaverLoginConfiguration;
import user.bean.UserDTO;
import user.dao.UserDAO;
import user.service.UserNaverLoginService;
import user.service.UserService;

@Service  // 이 클래스가 Spring의 서비스 계층으로 동작하며, 비즈니스 로직을 처리
public class UserServiceImpl implements UserService {
    @Autowired
    private UserNaverLoginService naverLoginService;  // 네이버 로그인 관련 로직을 처리하는 서비스 주입
    @Autowired
    private UserDAO userDAO;  // 사용자 관련 데이터베이스 접근을 위한 DAO 객체 주입

    @Override
    public String login(HttpSession session) {
        // 네이버 로그인을 위한 API URL 생성
        String apiURL = naverLoginService.naverLogin(session);  // 네이버 로그인 서비스 호출
        return apiURL;  // 생성된 네이버 로그인 API URL 반환
    }

    @Override
    public UserDTO loginNaver(Map<String, String> map, HttpSession session) {
        // 1. 네이버 로그인 정보를 추출하여 UserDTO에 저장
        UserDTO userDTO = naverLoginService.loginNaver(map, session);
        String userId = userDTO.getUserId();  // 네이버 로그인으로 받은 사용자 ID 가져오기
        
        // 2. 데이터베이스에서 사용자 정보가 있는지 확인하여 신규 사용자 여부를 확인
        UserDTO resultDTO = userDAO.checkNaverLoginId(userId);
        if (resultDTO == null) {
            // 2-1. 신규 사용자일 경우 회원가입 처리
            userDAO.joinUser(userDTO);  // UserDTO 정보를 이용하여 데이터베이스에 사용자 정보 저장
            userDTO = userDAO.checkNaverLoginId(userId);  // 다시 사용자 정보 조회
        }
        
        // 3. 로그인 성공 시 사용자 정보를 세션에 저장 (로그인 유지 처리)
        session.setAttribute("userSeq", userDTO.getSeq());  // 사용자 시퀀스 저장
        session.setAttribute("userName", userDTO.getName());  // 사용자 이름 저장
        
        return null;  // 로그인 완료 후 결과 반환 (추후 필요 시 수정 가능)
    }

    @Override
    public Boolean loginSH(Map<String, String> map, HttpSession session) {
        // 1. 자체(SH) 로그인 정보 확인
        UserDTO userDTO = userDAO.loginSH(map);  // ID와 비밀번호를 통해 사용자 정보 조회
        System.out.println("loginSH(): " + map.toString());  // 디버깅용: 로그인 정보 출력
        System.out.println("userDTO: " + userDTO);  // 디버깅용: 로그인된 사용자 정보 출력
        
        // 2. 로그인 성공 여부 확인
        if (userDTO != null) {
            // 로그인 성공 시 사용자 정보를 세션에 저장
            session.setAttribute("userSeq", userDTO.getSeq());  // 사용자 시퀀스 저장
            session.setAttribute("userName", userDTO.getName());  // 사용자 이름 저장
            return true;  // 로그인 성공 시 true 반환
        } else {
            return false;  // 로그인 실패 시 false 반환
        }
    }

    @Override
    public boolean checkUserId(String userId) {
        // 사용자 ID 중복 확인
        int result = userDAO.checkUserId(userId);  // 사용자 ID가 이미 존재하는지 확인
        
        if (result == 1) return false;  // 중복된 ID가 있을 경우 false 반환
        else return true;  // 중복된 ID가 없을 경우 true 반환
    }

    @Override
    public void joinSubmit(UserDTO userDTO) {
        // 회원가입 처리: 사용자 정보를 데이터베이스에 저장
        userDAO.joinUser(userDTO);  // 회원가입 정보를 데이터베이스에 저장
    }
}
