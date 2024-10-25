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
        // 1. 클라이언트로부터 입력받은 uid와 upwd 값을 받습니다.
        // 로그인 시 사용자가 입력한 아이디(uid)와 비밀번호(upwd)를 request 객체에서 가져옵니다.
        String uid = request.getParameter("uid");
        String upwd = request.getParameter("upwd");

        System.out.println("Attempting login for user: " + uid); // 디버깅용으로 사용자 ID 출력

        // 2. UserDAO 인스턴스를 이용하여 DB에서 사용자 정보를 확인합니다.
        // 로그인 로직을 처리하기 위해 UserDAO의 메서드를 호출해 사용자를 조회합니다.
        UserDAO userDAO = UserDAO.getInstance();
        UserDTO userDTO = null; // 사용자 정보를 담을 UserDTO 객체
        String errorMessage = ""; // 오류 메시지를 저장할 변수

        JSONObject jsonResponse = new JSONObject(); // JSON 응답을 만들기 위한 객체 생성

        try {
            // 3. 아이디와 비밀번호가 맞는지 확인
            userDTO = userDAO.loginUser(uid, upwd); // DB에서 아이디와 비밀번호로 사용자 조회
        } catch (Exception e) {
            System.out.println("Error during login: " + e.getMessage()); // 에러 발생 시 콘솔에 출력
            e.printStackTrace(); // 에러 스택 트레이스 출력
        }

        // 4. 로그인 성공 여부에 따라 처리
        if (userDTO != null) {
            // 로그인 성공 시 처리
            System.out.println("Login successful for user: " + uid);
            request.getSession().setAttribute("userDTO", userDTO); // 세션에 사용자 정보 저장
            jsonResponse.put("status", "success"); // 성공 상태
            jsonResponse.put("message", "로그인 성공"); // 성공 메시지
            jsonResponse.put("redirectUrl", request.getContextPath() + "/index.do"); // 리다이렉트 URL 설정
        } else {
            // 로그인 실패 시 처리
            // 아이디가 존재하지 않는 경우와 비밀번호가 틀린 경우를 구분하여 오류 메시지를 설정
            if (!userDAO.checkIdExists(uid)) {
                errorMessage = "아이디가 일치하지 않습니다.";
            } else {
                errorMessage = "비밀번호가 일치하지 않습니다.";
            }

            System.out.println("Login failed for user: " + uid); // 실패 시 콘솔에 출력
            jsonResponse.put("status", "fail"); // 실패 상태
            jsonResponse.put("message", errorMessage); // 실패 메시지
        }

        // 5. JSON 응답을 클라이언트에게 전송
        // 응답의 콘텐츠 타입을 JSON으로 설정하고 UTF-8로 인코딩합니다. 생성된 JSON 객체를 클라이언트로 전송합니다.
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse.toString()); // JSON 데이터를 응답으로 보냄

        // 6. 페이지 포워딩 없이 JSON 응답만 반환
        // 이 서비스는 AJAX 요청을 처리하는 것으로, 페이지 이동 없이 JSON 응답만 반환합니다.
        return null; 
    }
}
