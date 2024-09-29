package user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class UserLogOutService implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        // 세션 무효화
        // 현재 사용자의 세션을 무효화시켜 로그아웃을 처리합니다.
        // 세션이 무효화되면 세션에 저장된 모든 정보(로그인 정보 등)가 제거됩니다.
        request.getSession().invalidate();
        
        // 로그아웃 후 index.do로 리다이렉트
        // 로그아웃이 완료된 후, 사용자를 웹 애플리케이션의 메인 페이지인 index.do로 리다이렉트합니다.
        response.sendRedirect(request.getContextPath() + "/index.do");
        
        // 리턴 값을 "none"으로 설정
        // sendRedirect가 이미 응답을 처리했기 때문에 추가적인 화면 이동이나 뷰 처리 과정은 필요하지 않습니다.
        return "none";
    }

}
