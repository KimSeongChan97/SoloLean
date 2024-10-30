package member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import member.service.MemberService;

//@CrossOrigin
@CrossOrigin(origins = "http://localhost:3000/", allowCredentials = "true")
@Controller
@RequestMapping("member")
public class MemberController {
    	
		@Autowired
		private MemberService memberService;
			
		@GetMapping("login")
	    @ResponseBody    
	    public String login(@RequestParam("id")String id,@RequestParam("pwd")String pwd) {
	        System.out.println("id = " + id + " / pwd = " + pwd);
	        return memberService.login(id, pwd);
	        
	    }
		

		
}
