// FilmNote/src/main/java/user/service/UserSignUpDBService.java
package user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.control.CommandProcess;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSignUpDBService implements CommandProcess {
        
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        // 폼 데이터 받아오기
        String uname = request.getParameter("uname");
        String uid = request.getParameter("uid");
        String upwd = request.getParameter("upwd");
        String gender = request.getParameter("gender");
        String birth1 = request.getParameter("birth1");
        String birth2 = request.getParameter("birth2");
        String birth3 = request.getParameter("birth3");
        String email1 = request.getParameter("email1");
        String email2 = request.getParameter("email2");
        String tel1 = request.getParameter("tel1");
        String tel2 = request.getParameter("tel2");
        String tel3 = request.getParameter("tel3");
        
        // UserDTO 생성
        UserDTO userDTO = new UserDTO();
        userDTO.setUid(uid);
        userDTO.setUpwd(upwd);
        userDTO.setUname(uname);
        userDTO.setGender(gender);
        userDTO.setBirth1(birth1);
        userDTO.setBirth2(birth2);
        userDTO.setBirth3(birth3);
        userDTO.setEmail1(email1);
        userDTO.setEmail2(email2);
        userDTO.setTel1(tel1);
        userDTO.setTel2(tel2);
        userDTO.setTel3(tel3);
        
        // UserDAO를 통해 DB에 사용자 정보 저장
        UserDAO userDAO = UserDAO.getInstance();
        userDAO.insertUser(userDTO);
        
        // JSON 응답 생성
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("status", "success");
        jsonResponse.put("message", "회원가입을 축하드립니다.");

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse.toString());

        return "none"; // AJAX 요청이므로 뷰 페이지로 이동하지 않음
    }
}
