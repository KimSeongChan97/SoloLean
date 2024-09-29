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
        // 응답 데이터의 인코딩을 설정 (UTF-8)
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 세션에서 현재 로그인된 사용자 정보를 가져옴
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");

        // 로그인된 사용자가 없으면 userDTO=null을 응답하고 종료
        if (userDTO == null) {
            response.getWriter().write("userDTO=null");
            return null;
        }

        // 세션에서 uid를 가져오고, 클라이언트가 입력한 현재 비밀번호(nowpwd)를 받음
        String uid = userDTO.getUid();
        String nowpwd = request.getParameter("nowpwd");
        
        // DAO 객체를 사용하여 비밀번호 확인
        UserDAO userDAO = UserDAO.getInstance();
        boolean ispwd = userDAO.pwdCheck(uid, nowpwd); // 입력된 비밀번호와 DB의 비밀번호가 맞는지 확인
        
        // 비밀번호가 일치하지 않으면 에러 메시지를 응답하고 종료
        if (!ispwd) {
            response.getWriter().write("비밀번호가 맞지 않습니다");
            return null;
        }

        // 비밀번호가 맞으면 해당 사용자에 대한 회원 탈퇴 처리 (DB에서 사용자 정보 삭제)
        int result = userDAO.userWithdraw(uid);

        // 탈퇴 성공 시 세션 무효화 및 "success" 응답, 실패 시 "fail" 응답
        if (result > 0) {
            session.invalidate(); // 세션 무효화
            response.getWriter().write("success");
        } else {
            response.getWriter().write("fail");
        }

        return null; // 뷰 페이지 반환 없이 처리 완료 (AJAX 요청에 대한 응답이므로 뷰 이동 불필요)
    }
}
