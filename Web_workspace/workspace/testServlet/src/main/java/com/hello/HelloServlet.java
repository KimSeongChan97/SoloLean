package com.hello;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 이 서블릿 클래스는 javax.servlet.http.HttpServlet 클래스를 상속받아 만들어졌습니다.
// HttpServlet 클래스는 HTTP 요청과 응답을 처리하는 서블릿의 기본적인 동작을 제공하는 추상 클래스입니다.
// 서블릿은 서버 측에서 실행되는 작은 Java 프로그램으로, 웹 브라우저와 같은 클라이언트로부터 요청을 받고,
// 그에 대한 응답을 생성하는 역할을 합니다.

@WebServlet("/HelloServlet")
// @WebServlet 어노테이션은 이 서블릿이 특정 URL 패턴과 매핑되도록 합니다.
// 여기서는 "/HelloServlet" 경로로 들어오는 요청이 이 서블릿에 의해 처리됩니다.
// 이를 통해 web.xml 파일에 서블릿을 명시적으로 등록하지 않아도 됩니다.

public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // serialVersionUID는 Java의 직렬화(Serialization)에서 클래스의 버전을 식별하기 위한 고유한 값입니다.
    // 이 값은 직렬화된 객체를 복원할 때 클래스의 버전이 일치하는지를 확인하는 데 사용됩니다.
    // 서블릿 클래스는 HttpServlet을 상속받고 있으며, HttpServlet은 Serializable 인터페이스를 구현하고 있기 때문에,
    // serialVersionUID를 명시적으로 선언함으로써 클래스의 버전 관리에 도움을 줄 수 있습니다.

    public void init(ServletConfig config) throws ServletException {
        // init() 메서드는 서블릿이 초기화될 때 호출됩니다.
        // 서블릿이 처음으로 생성되고, 서버에서 실행될 때 이 메서드가 호출됩니다.
        // init() 메서드는 주로 서블릿이 실행되기 전에 필요한 자원(예: 데이터베이스 연결)을 초기화하거나 설정 작업을 수행하는 데 사용됩니다.
        // ServletConfig 객체는 서블릿의 초기화 파라미터와 서블릿 컨텍스트와 같은 설정 정보를 제공합니다.
        System.out.println("init...");
        // 이 출력문은 서블릿이 초기화될 때 콘솔에 "init..."이라는 메시지를 출력합니다.
        // 이 메시지를 통해 서블릿이 초기화된 시점을 확인할 수 있습니다.
    }

    public void destroy() {
        // destroy() 메서드는 서블릿이 제거될 때 호출됩니다.
        // 서블릿이 더 이상 필요하지 않거나, 서버가 종료될 때 이 메서드가 호출되어 서블릿이 사용한 자원을 정리할 수 있습니다.
        // 예를 들어, 데이터베이스 연결을 닫거나 파일을 닫는 작업이 이곳에서 이루어질 수 있습니다.
        System.out.println("destroy...");
        // 이 출력문은 서블릿이 제거될 때 콘솔에 "destroy..."라는 메시지를 출력합니다.
        // 이 메시지를 통해 서블릿이 언제 종료되는지를 확인할 수 있습니다.
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // doGet() 메서드는 클라이언트로부터 GET 요청이 들어왔을 때 호출됩니다.
        // 클라이언트는 브라우저를 통해 URL을 입력하거나 링크를 클릭할 때 GET 요청을 서버로 보냅니다.
        // 이 메서드는 HttpServletRequest 객체를 통해 클라이언트의 요청 정보를 받고,
        // HttpServletResponse 객체를 통해 서버의 응답을 클라이언트에 전송합니다.
        System.out.println("doGet...");
        // 이 출력문은 클라이언트가 GET 요청을 보냈을 때 콘솔에 "doGet..."이라는 메시지를 출력합니다.
        // 이 메시지를 통해 클라이언트의 GET 요청이 처리된 시점을 확인할 수 있습니다.
        // doGet() 메서드는 일반적으로 클라이언트의 요청에 따라 HTML 페이지를 생성하거나,
        // 클라이언트에게 필요한 데이터를 조회하여 응답하는 데 사용됩니다.
        
        // 응답의 콘텐츠 타입을 설정합니다. 여기서는 HTML 문서를 UTF-8 인코딩으로 클라이언트에게 전송함을 명시합니다.
        // 이 설정을 통해 클라이언트는 응답이 HTML 형식임을 알 수 있으며, UTF-8 인코딩을 통해 다국어 문자를 올바르게 표시할 수 있습니다.
        response.setContentType("text/html; charset=UTF-8");
        
        // PrintWriter 객체를 사용하여 클라이언트에 응답 데이터를 전송합니다.
        // 이 객체는 출력 스트림을 통해 텍스트 데이터를 클라이언트로 전송하는 데 사용됩니다.
        // 예를 들어, HTML 콘텐츠를 생성하여 클라이언트에게 전송할 때 사용됩니다.
		/*
		 1. 콘솔
		  System.out.println("<html>");
		 2. 파일
		  PrintWriter out = new PrintWriter(new FileWrite("result.txt"));
		  out.println("<html>");
		 3. 네트워크
		  OutputStreamWriter out = new OutputStreamWriter(소켓.getOutputStream());
		  out.println("<html>");
		 */    
         PrintWriter out = response.getWriter(); // 웹
         // getWriter() 메서드는 응답 객체에서 출력 스트림을 가져와 클라이언트에 데이터를 전송할 수 있는 PrintWriter 객체를 반환합니다.
         // 이 메서드를 통해 HTML 콘텐츠를 작성하여 클라이언트에게 전송할 수 있습니다.

         out.println("<html>");
         out.println("<body>");
         // 위 두 줄의 코드로 HTML 문서의 기본 구조를 생성합니다.
         // 클라이언트에게 전송될 HTML 문서의 시작 태그들을 생성하는 부분입니다.

         out.println("Hello Servlet !!<br/>");
         out.println("안녕하쇼 서블릿 !!");
         // 클라이언트에게 표시될 실제 콘텐츠입니다. 여기서는 "Hello Servlet !!"과 "안녕하쇼 서블릿 !!"이라는 두 줄의 텍스트를 전송합니다.
         // <br/> 태그는 HTML에서 줄바꿈을 의미하며, 두 문장이 각각 새로운 줄에 표시되도록 합니다.

         out.println("</body>");
         out.println("</html>");
         // HTML 문서의 끝을 표시하는 태그들입니다.
         // 클라이언트에게 전송할 모든 콘텐츠를 완료한 후, HTML 문서를 마무리합니다.
    }

}

//http://localhost:8080/Context명(Project명)/파일

// http://localhost:8080/testServlet/com.hello.HelloServlet.class -- X
// http://localhost:8080/testServlet/HelloServlet
// 자바 코드를 수정하면 -> 컴파일 ( 톰캣은 모른다 ) -> 반드시 톰캣을 껏다가 켜야 한다.
// 

// 위의 주석들은 서블릿이 웹 애플리케이션에서 어떻게 접근되고 실행되는지를 설명합니다.
// URL을 통해 서블릿에 접근할 때의 경로와, 코드를 수정한 후 톰캣 서버를 재시작해야 하는 이유를 설명하고 있습니다.
// 서블릿의 URL 패턴을 잘 설정하고, 수정된 자바 코드를 반영하려면 톰캣 서버를 재시작해야 하는 점을 강조합니다.
