package user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.control.CommandProcess;

import user.dao.UserDAO;

public class UserPwdCheckService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		// 현재 비밀번호와 사용자 ID를 클라이언트에서 전달받아 저장
		String nowupwd = request.getParameter("nowupwd"); // 현재 입력한 비밀번호
		String uid = request.getParameter("uid"); // 사용자 ID
		
		// UserDAO 인스턴스 가져오기
		UserDAO userDAO = UserDAO.getInstance();

		// 데이터베이스에서 비밀번호 확인
		boolean pwdCheck = userDAO.pwdCheck(uid, nowupwd); // true: 비밀번호 일치, false: 불일치
		System.out.println("uid: " + uid + ", nowupwd: " + nowupwd + ", pwdCheck: " + pwdCheck);

		// JSON 응답 객체 생성
		JSONObject jsonResponse = new JSONObject();

		// 비밀번호 확인 결과에 따른 응답 처리
		jsonResponse.put("pwdCheck", pwdCheck); // 비밀번호 확인 결과 (true/false)
		if (!pwdCheck) {
			// 비밀번호가 맞지 않으면 오류 메시지 추가
			jsonResponse.put("error", "비밀번호가 맞지 않습니다.");
		}
		
		response.setContentType("application/json");
		response.getWriter().write(jsonResponse.toString()); // JSON 데이터를 클라이언트로 전송


		return "none"; // AJAX 요청이므로 뷰 페이지 이동 없이 JSON 응답만 전송
	}

}
