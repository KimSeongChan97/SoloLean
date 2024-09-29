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

		if (userDTO == null) {
			return "/user/userSignIn.jsp";
		}
		return "/user/userWithdraw.jsp";
	}
}