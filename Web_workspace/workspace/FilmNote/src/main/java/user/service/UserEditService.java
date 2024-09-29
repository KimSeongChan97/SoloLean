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

        // 세션에서 사용자 정보를 가져옴
        // 세션에서 저장된 userDTO 객체를 가져옵니다. 이 정보는 사용자가 로그인할 때 세션에 저장된 사용자 정보입니다.
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");

        // 만약 세션에 userDTO가 없으면 (로그인하지 않은 상태), 로그인 페이지로 이동
        // 로그인이 되어 있지 않으면 사용자 정보 수정 페이지에 접근할 수 없기 때문에, 로그인 페이지로 리다이렉트합니다.
        if (userDTO == null) {
            return "/user/userSignIn.jsp";
        }

        // 클라이언트로부터 사용자 정보를 받을 필요 없음
        // 이미 세션에 저장된 사용자 정보를 이용할 것이므로, 별도의 데이터 처리는 필요 없습니다.
        
        // 사용자가 로그인을 한 상태라면, 사용자 정보 수정 페이지로 이동
        // 로그인 상태가 확인되면 사용자 정보 수정 페이지(userEdit.jsp)로 이동하여 수정할 수 있도록 합니다.
        return "/user/userEdit.jsp"; // 사용자 정보 수정 페이지로 이동
    }

}
