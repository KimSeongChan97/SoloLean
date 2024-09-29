// FilmNote/src/main/java/user/service/UserSignInService.java
package user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class UserSignInService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		// 로그인 페이지로 이동하는 단순 서비스 로직
		// 클라이언트 요청을 받아서 "/user/userSignIn.jsp" 페이지로 포워딩합니다.
		// 사용자가 로그인 페이지로 이동할 때 필요한 추가적인 처리나 데이터는 없고, 단순히 JSP 페이지를 반환합니다.
		// CommandProcess 인터페이스를 구현한 서비스 클래스이므로 requestPro 메서드에서 로직을 처리하고 JSP로 이동합니다.

		return "/user/userSignIn.jsp"; // 로그인 화면 JSP로 이동 (뷰 포워딩)
	}

}
