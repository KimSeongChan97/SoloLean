package com.controller.SpringProject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Spring MVC에서 이 클래스를 컨트롤러로 사용함을 선언합니다.
public class MainController {

	@RequestMapping(value="/") // "/" 경로로 들어오는 GET 요청을 처리합니다.
	public String index() {
		return "/index"; // "/index.jsp" 파일을 반환하여 메인 화면으로 연결됩니다.
	}
}

