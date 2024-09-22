package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

public class LogoutService implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        HttpSession session = request.getSession(); // 세션 생성
        // 현재 사용자의 세션을 가져옵니다. 이 세션은 사용자가 로그인하면서 생성된 세션입니다.

        session.removeAttribute("memName");
        // 세션에서 사용자 이름("memName") 속성을 제거합니다. 
        // 사용자가 로그아웃할 때, 로그인 세션에 저장된 사용자 이름 정보를 제거합니다.

        session.removeAttribute("memId");
        // 세션에서 사용자 ID("memId") 속성을 제거합니다.
        // 로그아웃 시 사용자 ID 정보를 세션에서 삭제합니다.

        session.invalidate();
        // 세션을 무효화하여 모든 세션 데이터를 삭제하고, 세션을 완전히 종료합니다.
        // invalidate()를 호출하면 현재 세션과 그 안의 모든 속성이 제거됩니다.
        // 이를 통해 사용자가 로그아웃되며, 더 이상 이 세션으로 로그인 상태를 유지할 수 없게 됩니다.

        return "none";
        // 로그아웃 후 특별히 이동할 페이지가 없을 때는 "none"을 반환합니다.
        // "none"은 화면 전환 없이 로그아웃만 처리하는 의미로 사용됩니다.
    }

}
