package member.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandProcess {
    // 서블릿이 호출하는 추상 메소드
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
