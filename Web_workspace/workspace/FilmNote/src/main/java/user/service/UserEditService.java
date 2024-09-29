package user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserEditService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		HttpSession session = request.getSession();
		UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");

		if (userDTO == null) {
			return "/user/userSignIn.jsp";
		}

		// 클라이언트로부터 사용자 정보를 받을 필요 없음
		return "/user/userEdit.jsp"; // 사용자 정보 수정 페이지
	}

}
