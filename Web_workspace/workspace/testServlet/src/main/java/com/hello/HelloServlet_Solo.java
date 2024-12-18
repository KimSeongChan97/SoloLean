package com.hello;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// HelloServlet_Solo 클래스는 HttpServlet 클래스를 상속받아 서블릿 기능을 수행합니다.
// 서블릿(Servlet)은 서버에서 동작하며 클라이언트의 요청을 처리하고 그 결과를 반환하는 Java 프로그램입니다.
// HttpServlet은 HTTP 프로토콜을 통해 클라이언트 요청을 처리하는 서블릿의 기본 클래스입니다.

public class HelloServlet_Solo extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // serialVersionUID는 직렬화된 객체의 버전을 나타내며, 클래스를 변경하더라도
    // 이전 버전의 객체와 호환되도록 유지하기 위해 사용됩니다.
    // 이는 기본적으로 서블릿 클래스가 Serializable 인터페이스를 구현하고 있음을 나타냅니다.

    public void init(ServletConfig config) throws ServletException {
        // init() 메서드는 서블릿이 초기화될 때 호출됩니다.
        // ServletConfig 객체는 서블릿의 초기화 파라미터나 서블릿 컨텍스트와 같은 설정 정보를 제공합니다.
        // 이 메서드는 서블릿이 처음 생성될 때 한 번만 호출되며,
        // 서블릿이 사용할 자원을 초기화하거나 필요한 설정을 읽는 데 사용됩니다.
        System.out.println("init...");
        // 이 코드는 서블릿이 초기화될 때 "init..." 메시지를 콘솔에 출력합니다.
    }

    public void destroy() {
        // destroy() 메서드는 서블릿이 제거될 때 호출됩니다.
        // 서블릿이 더 이상 필요하지 않게 되면 이 메서드가 호출되어
        // 서블릿이 사용했던 자원을 해제하거나 정리하는 데 사용됩니다.
        System.out.println("destroy...");
        // 이 코드는 서블릿이 제거될 때 "destroy..." 메시지를 콘솔에 출력합니다.
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // doGet() 메서드는 GET 요청을 처리합니다.
        // 클라이언트가 URL을 통해 서버에 GET 요청을 보내면, 이 메서드가 호출됩니다.
        // HttpServletRequest 객체는 클라이언트의 요청 정보를 담고 있으며,
        // HttpServletResponse 객체는 서버가 클라이언트에 보낼 응답 정보를 담고 있습니다.
        System.out.println("doGet...");
        // 이 코드는 클라이언트의 GET 요청이 처리될 때 "doGet..." 메시지를 콘솔에 출력합니다.
        // 이 메서드는 일반적으로 클라이언트로부터의 요청을 받아 처리하고,
        // 필요한 데이터를 생성하거나 조회한 후, 클라이언트에 응답을 보낼 때 사용됩니다.
    }
}

// http://localhost:8080/Context명(Project명)/파일
//http://localhost:8080/testServlet/com.hello.HelloServlet.class -- X
//http://localhost:8080/testServlet/HelloServlet
//자바 코드를 수정하면 -> 컴파일 ( 톰캣은 모른다 ) -> 반드시 톰캣을 껏다가 켜야 한다.
