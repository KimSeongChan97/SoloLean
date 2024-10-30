package member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import member.service.MemberService;

//@CrossOrigin

@RestController
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
		
		@GetMapping("checkLoginStatus")
		public ResponseEntity<Map<String, Boolean>> checkLoginStatus(HttpSession session) {
		    Map<String, Boolean> response = new HashMap<>();
		    response.put("isLoggedIn", session.getAttribute("user") != null);
		    return ResponseEntity.ok(response);
		}
		
		@PostMapping("logout")
	    public ResponseEntity<Void> logout(HttpSession session) {
	        session.invalidate();
	        return ResponseEntity.ok().build();
	    }

		
}
