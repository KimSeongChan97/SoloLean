package admin.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.control.CommandProcess;

public class AdminLogOutService implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        request.getSession().invalidate(); // 세션 무효화
        
        // 로그아웃 후 index.do로 리다이렉트
	    response.sendRedirect(request.getContextPath() + "/index.do");
	    return "none";
    }
}