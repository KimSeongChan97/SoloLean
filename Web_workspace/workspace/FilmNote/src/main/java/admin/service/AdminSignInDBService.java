package admin.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.control.CommandProcess;
import admin.bean.AdminDTO;
import admin.dao.AdminDAO;

public class AdminSignInDBService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
	    String aid = request.getParameter("aid");
	    String apwd = request.getParameter("apwd");

	    System.out.println("Attempting login for admin: " + aid);

	    AdminDAO adminDAO = AdminDAO.getInstance();
	    AdminDTO adminDTO = null;
	    try {
	        adminDTO = adminDAO.loginAdmin(aid, apwd);
	    } catch (Exception e) {
	        System.out.println("Error during admin login: " + e.getMessage());
	        e.printStackTrace();
	    }

	    if (adminDTO != null) {
	        System.out.println("Login successful for admin: " + aid);
	        request.getSession().setAttribute("adminDTO", adminDTO);
	        response.sendRedirect(request.getContextPath() + "/index.do");
	        return "none";
	    } else {
	        System.out.println("Login failed for admin: " + aid);
	        request.setAttribute("loginError", "아이디 또는 비밀번호가 올바르지 않습니다.");
	        return "/admin/adminSignIn.jsp";
	    }
	}

}
