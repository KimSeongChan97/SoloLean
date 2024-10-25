package admin.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.control.CommandProcess;
import admin.bean.AdminDTO;
import admin.dao.AdminDAO;

public class AdminSignInDBService implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        // 관리자가 입력한 아이디와 비밀번호를 request 객체에서 가져옴
        String aid = request.getParameter("aid"); // 관리자의 아이디
        String apwd = request.getParameter("apwd"); // 관리자의 비밀번호

        // 관리자의 로그인 시도를 로그로 출력
        System.out.println("Attempting login for admin: " + aid);

        // AdminDAO 싱글톤 인스턴스 생성 및 AdminDTO 객체 초기화
        AdminDAO adminDAO = AdminDAO.getInstance();
        AdminDTO adminDTO = null; // 관리자 정보 객체를 담을 변수

        try {
            // AdminDAO의 loginAdmin 메서드를 호출하여 로그인 검증
            adminDTO = adminDAO.loginAdmin(aid, apwd);
        } catch (Exception e) {
            // 로그인 중 오류가 발생했을 경우 로그에 에러 메시지를 출력하고 스택 트레이스를 출력
            System.out.println("Error during admin login: " + e.getMessage());
            e.printStackTrace();
        }

        // 로그인 성공 여부에 따라 처리 분기
        if (adminDTO != null) {
            // 로그인 성공 시 세션에 관리자 정보 저장
            System.out.println("Login successful for admin: " + aid); // 성공 로그 출력
            request.getSession().setAttribute("adminDTO", adminDTO); // 세션에 관리자 정보를 저장
            // 로그인 성공 후 index 페이지로 리다이렉트
            response.sendRedirect(request.getContextPath() + "/index.do");
            return "none"; // 리다이렉트 처리를 위해 뷰 반환하지 않음
        } else {
            // 로그인 실패 시 에러 메시지와 함께 로그인 페이지로 돌아감
            System.out.println("Login failed for admin: " + aid); // 실패 로그 출력
            request.setAttribute("loginError", "아이디 또는 비밀번호가 올바르지 않습니다."); // 에러 메시지를 request에 저장
            return "/admin/adminSignIn.jsp"; // 로그인 페이지로 포워딩
        }
    }
}
