package user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.control.CommandProcess;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserEditDBService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		UserDTO userDTO = new UserDTO();

		userDTO.setUname(request.getParameter("uname"));
		userDTO.setUid(request.getParameter("uid"));
		userDTO.setUpwd(request.getParameter("upwd"));
		userDTO.setGender(request.getParameter("gender"));
		userDTO.setBirth1(request.getParameter("birth1"));
		userDTO.setBirth2(request.getParameter("birth2"));
		userDTO.setBirth3(request.getParameter("birth3"));
		userDTO.setEmail1(request.getParameter("email1"));
		userDTO.setEmail2(request.getParameter("email2"));
		userDTO.setTel1(request.getParameter("tel1"));
		userDTO.setTel2(request.getParameter("tel2"));
		userDTO.setTel3(request.getParameter("tel3"));

	
		
		if (userDTO.getUid() == null || userDTO.getUid().isEmpty()) {
			return "FilmNote.error.jsp"; // 리다이렉트
		}

		UserDAO userDAO = UserDAO.getInstance();
		userDAO.userEdit(userDTO);
				
		HttpSession session = request.getSession();
		session.setAttribute("userDTO", userDTO);

		return "/index.do";

	}
}
