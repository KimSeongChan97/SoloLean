package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.control.CommandProcess;

public class LoginFormService implements CommandProcess {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        // 로그인 폼으로 이동하는 로직
        return "/member/loginForm.jsp";  // 로그인을 위한 JSP 경로를 반환
    }
}
