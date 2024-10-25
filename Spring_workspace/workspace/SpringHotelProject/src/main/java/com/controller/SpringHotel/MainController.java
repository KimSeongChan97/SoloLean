package com.controller.SpringHotel;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller  // 이 클래스는 Spring MVC에서 컨트롤러로 사용됨을 나타냄. HTTP 요청을 처리하고 적절한 뷰로 응답
public class MainController {

    // "/" 경로로 GET 요청이 들어왔을 때 index() 메서드를 호출하여 처리
	@RequestMapping(value = "/", method = RequestMethod.GET)  
	public String index(HttpSession session) {  
        // HttpSession 객체를 매개변수로 받아 세션 정보를 사용할 수 있음
        // 예를 들어, 로그인 정보를 저장하거나 가져오는 데 사용할 수 있음
        
		return "index";  
        // "index"라는 이름의 뷰를 반환 (보통 index.jsp 또는 index.html로 매핑됨)
        // 이 메서드는 홈 페이지로 이동할 때 사용됨
	}
}
