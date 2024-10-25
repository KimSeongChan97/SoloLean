// FilmNote/src/main/java/user/service/UserSignUpService.java
package user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class UserSignUpService implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        // 회원가입 요청에 대한 처리를 담당하는 서비스
        // 회원가입 페이지로 이동하기 위해 "/user/userSignUp.jsp"를 반환합니다.
        // 반환된 경로를 통해 사용자는 회원가입 화면을 볼 수 있게 됩니다.

        return "/user/userSignUp.jsp"; // 회원가입 페이지로 포워딩
    }
}

