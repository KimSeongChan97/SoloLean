// FilmNote/src/main/java/user/service/UserWithdrawService.java
package user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import user.bean.UserDTO;

public class UserWithdrawService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
		UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");

		// 현재 로그인된 사용자 정보가 없는 경우 로그인 페이지로 이동
		if (userDTO == null) {
			return "/user/userSignIn.jsp"; // 로그인이 되어있지 않으면 로그인 페이지로 이동
		}
		
		// 로그인된 사용자가 탈퇴 페이지로 이동할 경우, 탈퇴 페이지로 포워딩
		return "/user/userWithdraw.jsp"; // 로그인된 사용자는 탈퇴 페이지로 이동
	}
}
