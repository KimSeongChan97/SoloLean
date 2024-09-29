package user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.control.CommandProcess;
import user.dao.UserDAO;

public class CheckIdService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String uid = request.getParameter("uid");
		
		UserDAO userDAO = UserDAO.getInstance();
		boolean exists = userDAO.checkIdExists(uid);
		
		// JSON 응답 생성
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("exists", exists);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(jsonResponse.toString());

		return "none"; // AJAX 요청이므로 뷰 페이지로 이동하지 않음
	}

}
