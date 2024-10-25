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


@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
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
		System.out.println("/join");
		
		return "user/join";
	}
	
	@RequestMapping(value = "/join/submit", method = RequestMethod.POST)
	@ResponseBody
	public void joinSubmit(@ModelAttribute UserDTO userDTO) {
		System.out.println("/join/submit");
		System.out.println(userDTO.toString());
		userService.joinSubmit(userDTO);
	}
	
	// 로그인 화면 출력
	@RequestMapping(value = "/login")
	public String login(HttpSession session, ModelMap map) {
		String apiURL = userService.login(session);
		map.addAttribute("apiURL", apiURL);
		
		return "user/login";
	}
	
	// SH 로그인 처리
	@RequestMapping(value = "/login/sh")
	@ResponseBody
	public Boolean loginSH(@RequestParam Map<String, String> map, HttpSession session) {
		Boolean isLogin = false;
		isLogin = userService.loginSH(map, session);
		
		return isLogin;
	}
	
	// Naver 로그인 처리
	@RequestMapping(value = "/login/naver")
	public String loginNaver(@RequestParam Map<String, String> map, HttpSession session, ModelMap mMap) {
		// 1. 콜백 처리
		UserDTO userDTO = userService.loginNaver(map, session);
		mMap.addAttribute("userDTO", userDTO);
		
		// 2. 신규 or 기존 사용자
		if(userDTO == null) { // 기존 사용자
			return "index";
		}else { // 신규 사용자
			return "user/join";
		}
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "index";
	}
	
	@RequestMapping(value = "/checkUserId")
	@ResponseBody
	public boolean checkUserId(@RequestParam String userId) {
		boolean isUseUserId = userService.checkUserId(userId);
		return isUseUserId;
	}
	   @Autowired
	   JavaMailSenderImpl mailSender;
	   
	//이메일 인증
	   @PostMapping("/EmailAuth")
	   @ResponseBody
	   public int emailAuth(String email) {
	      
	      System.out.println("전달 받은 이메일 주소 : " + email);
	      
	      //난수의 범위 111111 ~ 999999 (6자리 난수)
	      Random random = new Random();
	      int checkNum = random.nextInt(888888)+111111;
	      
	      //이메일 보낼 양식
	      String setFrom = "springhotel@naver.com"; //2단계 인증 x, 메일 설정에서 POP/IMAP 사용 설정에서 POP/SMTP 사용함으로 설정o
	      String toMail = email;
	      String title = "SpringHotel 회원가입 인증 이메일입니다.";
	      String content = "안녕하세요! Spring Hotel입니다.<br>" +
	                 "귀하의 요청에 따라 인증 코드를 전송해 드립니다. <br>" +
	                 "인증 코드는 다음과 같습니다: <strong>" + checkNum + "</strong>입니다.<br>" +
	                 "해당 인증 코드를 인증 코드 확인란에 입력해 주시면, 서비스 이용이 가능해집니다.<br>" +
	                 "감사합니다!";

	      
	      try {
	         MimeMessage message = mailSender.createMimeMessage(); //Spring에서 제공하는 mail API
	            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
	            helper.setFrom(setFrom);
	            helper.setTo(toMail);
	            helper.setSubject(title);
	            helper.setText(content, true);
	            mailSender.send(message);
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      
	      System.out.println("랜덤숫자 : " + checkNum);
	      return checkNum;
	   }
}
