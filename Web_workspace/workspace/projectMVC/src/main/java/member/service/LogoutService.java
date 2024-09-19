package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.control.CommandProcess;

public class LogoutService implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 기존 세션을 가져옴
        // getSession() 메서드는 현재 사용자의 세션을 반환함.
        // 만약 세션이 없으면 새로 생성하는 것이 아니라 기존 세션을 반환함.
        HttpSession session = request.getSession();
        
        // 세션에서 특정 속성 제거
        // 세션에 저장된 "memName" 속성을 제거 (사용자의 이름 정보)
        session.removeAttribute("memName");
        // 세션에 저장된 "memId" 속성을 제거 (사용자의 아이디 정보)
        session.removeAttribute("memId");

        // 세션 무효화
        // invalidate() 메서드는 현재 세션을 완전히 무효화하여 세션에 저장된 모든 데이터를 삭제하고 세션을 종료함.
        // 이 작업을 통해 로그아웃 상태를 유지하게 됨.
        session.invalidate();  // 세션 무효화
        
        // 로그아웃 후 페이지 이동
        // 사용자를 로그아웃 처리 후 로그아웃 완료 이동함.
        return "none";
    }
}
