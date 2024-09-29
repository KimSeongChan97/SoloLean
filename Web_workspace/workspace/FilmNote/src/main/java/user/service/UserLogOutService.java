package user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class UserLogOutService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 세션 무효화
	    request.getSession().invalidate();
	    
	    // 로그아웃 후 index.do로 리다이렉트
	    response.sendRedirect(request.getContextPath() + "/index.do");
	    return "none";
	}

}
