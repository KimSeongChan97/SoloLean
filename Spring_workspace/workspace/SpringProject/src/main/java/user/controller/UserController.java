package user.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import user.bean.UserDTO;
import user.service.UserService;

@Controller
@RequestMapping(value="user") // "/user"로 시작하는 모든 요청을 이 컨트롤러에서 처리하도록 매핑합니다.
// 이 클래스는 사용자의 요청을 처리하는 컨트롤러 클래스입니다. "/user"로 시작하는 URL 요청을 받아 처리합니다.
public class UserController {
    
    @Autowired // 의존성 주입을 통해 UserService를 자동으로 주입받습니다.
    // Spring의 의존성 주입을 사용하여 UserService 객체를 자동으로 생성하여 사용합니다. UserService는 비즈니스 로직을 처리하는 서비스 계층입니다.
    private UserService userService; // 서비스 계층과 연결되는 객체
    
    @RequestMapping(value="/writeForm", method = RequestMethod.GET)
    // GET 방식으로 회원가입 폼을 요청할 때 이 메서드를 호출합니다.
    public String writeForm() {
        return "/user/writeForm"; // 회원가입 폼을 반환. JSP 파일 경로로 연결됨
        // "user/writeForm.jsp" 페이지를 반환하여 회원가입 폼을 사용자에게 보여줍니다.
    }
    
    @RequestMapping(value="/getExistId", method = RequestMethod.POST)
    @ResponseBody // JSON 또는 단순 문자열을 반환할 때 사용
    // 클라이언트가 아이디 중복 체크 요청을 POST 방식으로 보내면 이 메서드를 실행합니다.
    public String getExistId(String id) {
        // 서비스로 아이디 중복 체크 요청
        // 전달받은 아이디가 이미 존재하는지 확인하는 로직을 UserService를 통해 수행합니다.
        return userService.getExistId(id);
        // 아이디 중복 여부에 따라 'exist' 또는 'non_exist'를 반환하여 클라이언트 측에서 중복 여부를 알 수 있습니다.
    }

    @RequestMapping(value="/write", method = RequestMethod.POST)
    @ResponseBody
    // 회원가입 요청을 POST 방식으로 처리합니다. 사용자가 회원가입 폼에 입력한 정보를 받아 DB에 저장합니다.
    public void write(@ModelAttribute UserDTO userDTO) {
        // 회원 정보를 받아 서비스로 전달하여 DB에 저장
        // 전달받은 회원 정보를 UserDTO 객체로 매핑하여 UserService를 통해 DB에 저장합니다.
        userService.write(userDTO);
    }

    @RequestMapping(value="/list", method = RequestMethod.GET)
    // 회원 리스트를 조회할 때 호출되는 메서드입니다. 사용자가 특정 페이지를 요청할 수 있습니다.
    public String list(@RequestParam(required = false, defaultValue = "1") String pg, Model model) {
        // 리스트 페이지 요청 시, pg 값이 없으면 기본으로 1페이지를 불러옴
        // 사용자가 페이지 번호를 지정하지 않으면 기본값으로 1페이지가 설정됩니다. pg는 페이지 번호를 의미합니다.
        Map<String, Object> map2 = userService.list(pg); // 서비스에서 데이터 조회
        // 지정한 페이지에 해당하는 회원 리스트 데이터를 서비스에서 가져옵니다.
        map2.put("pg", pg); // 현재 페이지 정보 추가
        // 현재 페이지 정보를 map에 추가하여 나중에 뷰에 전달할 수 있도록 합니다.
        model.addAttribute("map2", map2); // 모델에 map2를 추가하여 뷰에 데이터 전달
        // 뷰에서 사용할 데이터를 Model 객체에 추가합니다. 이를 통해 JSP에서 데이터를 사용할 수 있습니다.
        return "/user/list"; // user/list.jsp 파일로 이동
        // 회원 리스트를 보여주는 JSP 파일로 이동하여 결과를 출력합니다.
    }

    @RequestMapping(value="/updateForm", method = RequestMethod.GET)
    // 회원정보 수정 폼을 요청할 때 호출되는 메서드입니다.
    public String updateForm(@RequestParam("id") String id, @RequestParam("pg") int pg, Model model) {
        // 수정할 사용자 정보를 가져와 뷰로 전달
        // 요청된 회원 ID를 사용하여 해당 회원의 정보를 조회합니다.
        UserDTO userDTO = userService.getUser(id);
        model.addAttribute("userDTO", userDTO); // 수정할 유저 정보 전달
        // 조회된 사용자 정보를 JSP 페이지에 전달합니다.
        model.addAttribute("pg", pg); // 현재 페이지 정보 전달
        // 수정 폼을 띄울 때 현재 페이지 정보를 함께 전달하여 수정 후에 해당 페이지로 돌아갈 수 있게 합니다.
        return "/user/updateForm"; // user/updateForm.jsp 파일로 이동
        // 수정 폼 JSP로 이동하여 사용자 정보를 수정할 수 있도록 합니다.
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    // POST 방식으로 회원 정보를 수정하는 요청을 처리하는 메서드입니다.
    public String update(@ModelAttribute UserDTO userDTO) {
        // 서비스로 수정된 회원 정보 전달
        // 전달받은 수정된 회원 정보를 UserService를 통해 DB에 저장합니다.
        userService.update(userDTO);
        return "/user/list"; // 업데이트 후 리스트 페이지로 이동
        // 회원 정보 수정 후 회원 리스트 페이지로 이동하여 변경 사항을 확인할 수 있도록 합니다.
    }
    
    @RequestMapping(value="/loginForm", method = RequestMethod.GET)
    // GET 방식으로 로그인 폼을 요청할 때 이 메서드를 실행합니다.
    public String loginForm() {
        return "/user/loginForm"; // 로그인 폼으로 이동
        // 로그인 폼 JSP 페이지로 이동하여 사용자가 로그인할 수 있도록 합니다.
    }
    
    @RequestMapping(value="/login", method = RequestMethod.POST)
    // POST 방식으로 로그인 요청을 처리하는 메서드입니다.
    public String login(String id, String pwd, HttpSession session) {
        // 로그인 요청을 처리. 세션에 로그인 정보 저장
        // 로그인 요청을 처리하며, 세션에 로그인한 사용자 정보를 저장합니다.
        UserDTO userDTO = userService.login(id, pwd); // 로그인 검증
        // 로그인 검증을 위해 입력한 ID와 비밀번호를 전달하여 로그인 처리 로직을 수행합니다.
        
        if (userDTO != null) {
            session.setAttribute("loginUser", userDTO); // 로그인 성공 시 세션에 유저 정보 저장
            // 로그인에 성공하면 사용자 정보를 세션에 저장하여 로그인이 유지되도록 합니다.
            return "redirect:/"; // 메인 페이지로 리다이렉트
            // 로그인 후 메인 페이지로 이동합니다.
        } else {
            return "redirect:/user/loginForm?error=true"; // 로그인 실패 시 로그인 폼으로 다시 이동
            // 로그인 실패 시 로그인 폼으로 다시 이동하고, URL에 error=true를 추가하여 실패를 알립니다.
        }
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    // GET 방식으로 로그아웃 요청을 처리하는 메서드입니다.
    public String logout(HttpSession session) {
        // 로그아웃 처리. 세션 무효화
        // 세션을 무효화하여 로그인 정보를 제거하고 로그아웃을 처리합니다.
        session.invalidate(); // 세션을 무효화하여 로그아웃 처리
        return "redirect:/"; // 메인 페이지로 리다이렉트
        // 로그아웃 후 메인 페이지로 이동합니다.
    }
    
    @RequestMapping(value="/deleteForm", method = RequestMethod.GET)
    // GET 방식으로 회원 탈퇴 폼을 요청하는 메서드입니다.
    public ModelAndView deleteForm(@RequestParam String id, @RequestParam(required = false, defaultValue = "1") int pg) {
        ModelAndView mav = new ModelAndView();
        UserDTO userDTO = userService.getUser(id); // 사용자 정보 조회
        // 전달된 ID로 해당 사용자의 정보를 조회합니다.
        mav.addObject("userDTO", userDTO); // 유저 정보 전달
        // 조회한 사용자 정보를 탈퇴 폼에 전달합니다.
        mav.addObject("pg", pg); // 페이지 정보 전달
        // 탈퇴 후에 돌아갈 페이지 정보를 전달합니다.
        mav.setViewName("/user/deleteForm"); // 탈퇴 폼으로 이동
        // 탈퇴 폼 JSP로 이동하여 사용자 정보를 확인 후 탈퇴할 수 있도록 합니다.
        return mav;
    }

    @RequestMapping(value="getExistPwd", method = RequestMethod.POST)
    @ResponseBody // ResponsBody 덕분에 UserDTO 를 가지고 text 가 아닌 json 으로 반환
    public UserDTO getExistPwd(@RequestParam String id, Model model) {
        // Spring 은 객체를 자동으로 JSON 변경해줌(JSONObject)
        // Spring에서는 객체를 자동으로 JSON 형식으로 변환하여 클라이언트에 반환합니다.
    	System.out.println("id=" + id);
    	
    	return userService.getExistPwd(id);
        // 전달받은 ID를 사용하여 해당 사용자의 비밀번호를 확인합니다.
    }
    
    // POST 방식으로 회원 탈퇴 요청을 처리하는 메서드입니다.
    @RequestMapping(value="delete", method = RequestMethod.POST)
    @ResponseBody
    public void delete(@RequestParam String id) {
    	userService.delete(id);
        // 전달받은 ID에 해당하는 사용자를 DB에서 삭제합니다.
    }

}
