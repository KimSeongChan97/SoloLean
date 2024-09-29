package user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.control.CommandProcess;

import user.dao.UserDAO;

public class UserPwdCheckService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		String nowupwd = request.getParameter("nowupwd");
		String uid = request.getParameter("uid");
		UserDAO userDAO = UserDAO.getInstance();

		String pwdCheck = userDAO.pwdCheck(uid);
		JSONObject jsonResoponse = new JSONObject();

		
		if (pwdCheck != null && pwdCheck.equals(nowupwd)) {
			jsonResoponse.put("valid", true);
		} else {
			jsonResoponse.put("valid", false);
		}
		
		response.setContentType("application/json");
		response.getWriter().write(jsonResoponse.toString());

		

		return "none";
	}

}
