package user.controller;

import java.util.Map;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import user.bean.UserDTO;
import user.service.UserService;

@Controller  // 이 클래스가 Spring의 컨트롤러임을 나타냄
@RequestMapping("user")  // "/user" 경로에 해당하는 요청을 처리
public class UserController {
    @Autowired  // UserService 객체를 자동으로 주입받음
    private UserService userService;

    /*
     * 1. 회원가입 
     * 2. 로그인 - SH, Naver
     * 3. 마이페이지
     * 4. 회원정보 수정
     * 5. id 중복 체크
     */
    
    @RequestMapping(value = "/join")
    public String join(HttpSession session) {
        // 회원가입 페이지로 이동
        System.out.println("/join");
        return "user/join";  // user/join.jsp로 이동
    }
    
    @RequestMapping(value = "/join/submit", method = RequestMethod.POST)
    @ResponseBody
    public void joinSubmit(@ModelAttribute UserDTO userDTO) {
        // 회원가입 요청을 처리
        System.out.println("/join/submit");
        System.out.println(userDTO.toString());  // 디버깅용: 회원가입 정보 출력
        userService.joinSubmit(userDTO);  // UserService를 통해 회원가입 처리
    }
    
    // 로그인 화면 출력
    @RequestMapping(value = "/login")
    public String login(HttpSession session, ModelMap map) {
        // 로그인 페이지로 이동하며, 네이버 API URL을 가져옴
        String apiURL = userService.login(session);  // 네이버 로그인 API URL 가져오기
        map.addAttribute("apiURL", apiURL);  // 네이버 로그인 URL을 모델에 추가
        return "user/login";  // user/login.jsp로 이동
    }
    
    // SH 로그인 처리
    @RequestMapping(value = "/login/sh")
    @ResponseBody
    public Boolean loginSH(@RequestParam Map<String, String> map, HttpSession session) {
        // SH(자체) 로그인 처리
        Boolean isLogin = false;
        isLogin = userService.loginSH(map, session);  // SH 로그인 서비스 호출
        return isLogin;  // 로그인 성공 여부 반환
    }
    
    // Naver 로그인 처리
    @RequestMapping(value = "/login/naver")
    public String loginNaver(@RequestParam Map<String, String> map, HttpSession session, ModelMap mMap) {
        // 네이버 로그인 처리
        UserDTO userDTO = userService.loginNaver(map, session);  // 네이버 로그인 서비스 호출
        mMap.addAttribute("userDTO", userDTO);  // 로그인된 사용자 정보를 모델에 추가
        
        // 신규 사용자 또는 기존 사용자에 따라 다른 페이지로 이동
        if(userDTO == null) {  // 기존 사용자
            return "index";  // 메인 페이지로 이동
        } else {  // 신규 사용자
            return "user/join";  // 회원가입 페이지로 이동
        }
    }
    
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        // 로그아웃 처리: 세션 무효화
        session.invalidate();  // 세션을 삭제하여 로그아웃 처리
        return "index";  // 로그아웃 후 메인 페이지로 이동
    }
    
    @RequestMapping(value = "/checkUserId")
    @ResponseBody
    public boolean checkUserId(@RequestParam String userId) {
        // 사용자 ID 중복 여부 확인
        boolean isUseUserId = userService.checkUserId(userId);  // ID 중복 체크 서비스 호출
        return isUseUserId;  // 중복 여부 반환
    }
    
    @Autowired
    JavaMailSenderImpl mailSender;  // JavaMailSenderImpl을 통해 이메일 전송 처리
    
    // 이메일 인증
    @PostMapping("/EmailAuth")
    @ResponseBody
    public int emailAuth(String email) {
        // 이메일 인증 요청을 처리
        System.out.println("전달 받은 이메일 주소 : " + email);  // 디버깅용

        // 111111 ~ 999999 사이의 6자리 난수 생성
        Random random = new Random();
        int checkNum = random.nextInt(888888) + 111111;
        
        // 이메일 전송을 위한 양식 설정
        String setFrom = "springhotel@naver.com";  // 발신 이메일 주소
        String toMail = email;  // 수신 이메일 주소
        String title = "SpringHotel 회원가입 인증 이메일입니다.";  // 이메일 제목
        String content = "안녕하세요! Spring Hotel입니다.<br>" +
                         "귀하의 요청에 따라 인증 코드를 전송해 드립니다. <br>" +
                         "인증 코드는 다음과 같습니다: <strong>" + checkNum + "</strong>입니다.<br>" +
                         "해당 인증 코드를 인증 코드 확인란에 입력해 주시면, 서비스 이용이 가능해집니다.<br>" +
                         "감사합니다!";  // 이메일 내용
        
        // 이메일 전송 처리
        try {
            MimeMessage message = mailSender.createMimeMessage();  // 이메일 메시지 생성
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");  // MIME 형식 지원
            helper.setFrom(setFrom);  // 발신자 설정
            helper.setTo(toMail);  // 수신자 설정
            helper.setSubject(title);  // 제목 설정
            helper.setText(content, true);  // 본문 설정 (HTML 형식)
            mailSender.send(message);  // 이메일 전송
        } catch (Exception e) {
            e.printStackTrace();  // 예외 발생 시 스택 트레이스 출력
        }
        
        System.out.println("랜덤숫자 : " + checkNum);  // 디버깅용: 인증 번호 출력
        return checkNum;  // 인증 번호 반환
    }
}
