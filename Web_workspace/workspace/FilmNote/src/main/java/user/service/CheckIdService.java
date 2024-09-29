package user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.control.CommandProcess;
import user.dao.UserDAO;

public class CheckIdService implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        // 1. 클라이언트로부터 전달된 ID를 받음
        // 클라이언트가 입력한 uid 값을 request 객체에서 받아옵니다.
        String uid = request.getParameter("uid");
        
        // 2. UserDAO의 checkIdExists 메소드를 호출하여 ID 중복 여부 확인
        // UserDAO 인스턴스를 통해 데이터베이스에서 해당 uid가 이미 존재하는지 확인합니다.
        UserDAO userDAO = UserDAO.getInstance();
        boolean exists = userDAO.checkIdExists(uid); // ID 중복 여부를 확인하는 로직
        
        // 3. JSON 객체로 응답 생성
        // AJAX 요청에 대한 응답을 JSON 형태로 생성합니다. exists 값에 따라 true 또는 false 값을 보냅니다.
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("exists", exists); // exists: ID가 존재하는지 여부
        
        // 4. 클라이언트에게 JSON 응답 전송
        // 응답의 콘텐츠 타입을 JSON으로 설정하고, 인코딩 방식을 UTF-8로 지정한 후, 생성한 JSON 응답을 클라이언트로 전송합니다.
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse.toString()); // JSON 데이터를 응답으로 보냄

        // 5. AJAX 요청이므로 뷰 페이지로 이동하지 않음
        // AJAX 요청이므로, 페이지 이동이 필요 없고 "none"을 리턴하여 뷰 처리를 하지 않도록 함.
        return "none"; 
    }

}
