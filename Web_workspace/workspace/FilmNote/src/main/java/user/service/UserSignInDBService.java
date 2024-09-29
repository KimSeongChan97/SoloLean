package user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.control.CommandProcess;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSignInDBService implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String uid = request.getParameter("uid");
        String upwd = request.getParameter("upwd");

        System.out.println("Attempting login for user: " + uid);

        UserDAO userDAO = UserDAO.getInstance();
        UserDTO userDTO = null;
        String errorMessage = "";

        JSONObject jsonResponse = new JSONObject();

        try {
            userDTO = userDAO.loginUser(uid, upwd);
        } catch (Exception e) {
            System.out.println("Error during login: " + e.getMessage());
            e.printStackTrace();
        }

        if (userDTO != null) {
            System.out.println("Login successful for user: " + uid);
            request.getSession().setAttribute("userDTO", userDTO); // 세션에 userDTO 저장
            jsonResponse.put("status", "success");
            jsonResponse.put("message", "로그인 성공");
            jsonResponse.put("redirectUrl", request.getContextPath() + "/index.do");
        } else {
            // 로그인 실패 처리
            if (!userDAO.checkIdExists(uid)) {
                errorMessage = "아이디가 일치하지 않습니다.";
            } else {
                errorMessage = "비밀번호가 일치하지 않습니다.";
            }

            System.out.println("Login failed for user: " + uid);
            jsonResponse.put("status", "fail");
            jsonResponse.put("message", errorMessage);
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse.toString());

        return null; // 페이지를 포워딩하지 않고 JSON 응답 반환
    }
}
