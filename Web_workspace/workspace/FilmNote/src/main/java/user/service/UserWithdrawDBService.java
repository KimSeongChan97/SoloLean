// FilmNote/src/main/java/user/service/UserWithdrawDBService.java
package user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserWithdrawDBService implements CommandProcess {
    
	@Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        HttpSession session = request.getSession();
       
        UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");
        if (userDTO == null) {
            response.getWriter().write("userDTO=null");
            return null;
        }
        
        String uid =userDTO.getUid();
        
        UserDAO userDAO = UserDAO.getInstance();
        
        int result = userDAO.userWithdraw(uid);
        
        if (result > 0) {
            session.invalidate(); // 세션 삭제
            response.getWriter().write("success"); // 회원 탈퇴 성공
        } else {
            response.getWriter().write("result=null"); // 회원 탈퇴 실패
        }
        
        return null; // 뷰 페이지 반환이 필요하지 않음   
    }
}