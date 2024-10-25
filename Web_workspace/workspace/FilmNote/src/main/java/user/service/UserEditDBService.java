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

        // 1. UserDTO 객체 생성
        // 클라이언트로부터 전달된 사용자의 입력 데이터를 받아 UserDTO 객체에 저장
        UserDTO userDTO = new UserDTO();

        // 2. 클라이언트로부터 전달된 파라미터 값들을 UserDTO 객체에 설정
        // 클라이언트로부터 폼 데이터를 받아서 UserDTO 객체의 필드에 값을 설정합니다.
        userDTO.setUname(request.getParameter("uname"));  // 사용자 이름
        userDTO.setUid(request.getParameter("uid"));      // 사용자 ID
        userDTO.setUpwd(request.getParameter("upwd"));    // 사용자 비밀번호
        userDTO.setGender(request.getParameter("gender")); // 성별
        userDTO.setBirth1(request.getParameter("birth1")); // 생년월일 (년)
        userDTO.setBirth2(request.getParameter("birth2")); // 생년월일 (월)
        userDTO.setBirth3(request.getParameter("birth3")); // 생년월일 (일)
        userDTO.setEmail1(request.getParameter("email1")); // 이메일 앞부분
        userDTO.setEmail2(request.getParameter("email2")); // 이메일 뒷부분 (도메인)
        userDTO.setTel1(request.getParameter("tel1"));     // 전화번호 앞부분
        userDTO.setTel2(request.getParameter("tel2"));     // 전화번호 중간부분
        userDTO.setTel3(request.getParameter("tel3"));     // 전화번호 뒷부분

        // 3. 필수 값 체크: 사용자 ID가 존재하지 않거나 비어있으면 에러 페이지로 리다이렉트
        // 사용자의 ID는 필수 입력값이므로, 이 값이 없으면 에러 페이지로 이동합니다.
        if (userDTO.getUid() == null || userDTO.getUid().isEmpty()) {
            return "FilmNote.error.jsp"; // 필수값 검증 실패 시 에러 페이지로 이동
        }

        // 4. UserDAO 객체를 통해 사용자 정보를 업데이트
        // DB와 연결하여 사용자의 정보를 수정합니다. 이때 UserDTO 객체를 전달합니다.
        UserDAO userDAO = UserDAO.getInstance();
        userDAO.userEdit(userDTO);  // DB 업데이트 수행
        
        // 5. 세션 업데이트
        // 세션에 저장된 사용자 정보를 갱신된 정보로 업데이트하여 유지합니다.
        HttpSession session = request.getSession();
        session.setAttribute("userDTO", userDTO);  // 세션에 업데이트된 사용자 정보 저장

        // 6. 메인 페이지로 리다이렉트
        // 수정 완료 후 메인 페이지로 이동하여 결과를 반영합니다.
        return "/index.do";  // 수정 후 메인 페이지로 리다이렉트

    }
}
