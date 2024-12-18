package user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import user.bean.UserDTO;
import user.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping(value = "user")
public class UserController {

	
	
	private UserService userService;

	// 생성자 Injection, Autowired 를 대신하여 사용
	public UserController(UserService userService) {
		this.userService = userService;
	}


	@GetMapping(value = "writeForm")
	public String writeForm() {
		return "user/writeForm";
	};

	@PostMapping("getExistId")
	@ResponseBody
	public String getExistId(@RequestParam("id") String id) {

		return userService.getExistId(id);
	};
	
	@PostMapping("write")
    @ResponseBody
    public void write(@ModelAttribute UserDTO userDTO) {
         userService.write(userDTO);
    };
    
    
	@PostMapping("write2")
    public String write2(@ModelAttribute UserDTO userDTO) {
        System.out.println(userDTO); 
		userService.write(userDTO);
       
		return "user/write"; // user 안 write.html 로        
    };
	
    @GetMapping(value="list")
    public String list(Model model){
    	System.out.println("list");
    	
    	List<UserDTO> list = userService.list();
    	
    	model.addAttribute("list", list);
    	
    	return "user/list";
    };
    
    @GetMapping(value="userDetail/{id}")
    public String userDetail(@PathVariable("id") String id, Model model) {
        UserDTO userDTO = userService.getUser(id);
        model.addAttribute("userDTO", userDTO);
        return "user/userDetail"; // Thymeleaf template name
    };
    
    @PostMapping(value = "update")
    public String update(@ModelAttribute UserDTO userDTO) {
        userService.update(userDTO);
        return "redirect:/user/list"; 
    }

    @PostMapping(value = "delete")
    public String delete(@RequestParam("id") String id) {
        userService.delete(id);
        return "redirect:/user/list"; 
    }
    


}
