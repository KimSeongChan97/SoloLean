package member.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandProcess {
    // 서블릿이 호출하는 추상메소드(HttpServletRequest request, HttpServletResponse response);
    // 서블릿에서 호출하는 메소드를 정의하는 인터페이스입니다. 
    // 인터페이스는 메소드의 선언만 있고, 실제 구현은 이 인터페이스를 구현하는 클래스에서 처리합니다.
    
    // public String 으로 문자열을 보내줘야 함
    // 이 메소드는 문자열(String)을 반환합니다. 반환된 문자열은 주로 View의 이름(예: JSP 파일의 경로)입니다.
    // requestPro 메소드는 서블릿이 클라이언트의 요청을 처리할 때 호출됩니다. 
    
    public String requestPro(HttpServletRequest request, HttpServletResponse response)
        // HttpServletRequest와 HttpServletResponse 객체를 파라미터로 받습니다.
        // HttpServletRequest는 클라이언트(브라우저)로부터 전송된 요청 정보를 담고 있습니다.
        // HttpServletResponse는 서버에서 클라이언트로 보내는 응답을 처리하는 데 사용됩니다.
        throws Throwable;
        // 이 메소드는 'Throwable'을 던질 수 있습니다. 즉, 이 메소드는 예외(Exception) 또는 에러(Error)가 발생할 수 있음을 의미합니다.
        // 여기서 'Throwable'은 예외의 상위 클래스이며, 메소드에서 다양한 예외 상황을 처리할 수 있도록 설계되었습니다.
    
}
