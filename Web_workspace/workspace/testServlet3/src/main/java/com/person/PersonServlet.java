package com.person;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PersonServlet")
// @WebServlet 어노테이션을 통해 이 서블릿이 "/PersonServlet" 경로에 매핑되도록 설정합니다.
// 이 설정으로 인해 "/PersonServlet" URL로의 GET 요청이 이 서블릿에 의해 처리됩니다.
// @WebServlet 어노테이션은 서블릿을 특정 URL 패턴에 매핑하기 위해 사용됩니다.
// 이 경우 "/PersonServlet" 경로로 오는 모든 요청이 이 서블릿으로 처리됩니다.
public class PersonServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;   
    // 서블릿 클래스는 Serializable 인터페이스를 구현해야 하며, serialVersionUID는 클래스의 버전을 관리하는데 사용됩니다.
    // Serializable 인터페이스는 객체를 직렬화하기 위해 필요합니다. 직렬화는 객체를 바이트 스트림으로 변환하여 파일이나 네트워크를 통해 전송할 수 있도록 합니다.
    // serialVersionUID는 직렬화된 객체의 버전을 관리하는 고유 ID입니다. 만약 클래스가 수정되어도 이 ID가 같다면, 이전에 직렬화된 객체를 불러올 수 있습니다.

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // 클라이언트가 GET 요청을 보냈을 때 이 메서드가 호출됩니다.
        // HttpServletRequest는 클라이언트의 요청 정보를 담고 있고,
        // HttpServletResponse는 서버의 응답 정보를 담고 있습니다.
        // doGet 메서드는 HTTP GET 요청이 들어왔을 때 호출됩니다.
        // HttpServletRequest 객체는 요청과 관련된 모든 정보를 가지고 있습니다. 예를 들어, 폼 데이터, 헤더 정보 등을 가져올 수 있습니다.
        // HttpServletResponse 객체는 서버에서 클라이언트로 보낼 응답을 다룹니다. 이 객체를 사용해 상태 코드 설정, 응답 내용 작성 등을 할 수 있습니다.

        // 데이터 가져오기
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String color = request.getParameter("color");
        String[] hobby = request.getParameterValues("hobby");
        String[] subject = request.getParameterValues("subject");
        // request.getParameter()와 request.getParameterValues() 메서드를 사용하여 클라이언트가 보낸 폼 데이터를 가져옵니다.
        // getParameter()는 단일 값을 반환하며, getParameterValues()는 배열 형태로 여러 값을 반환합니다.
        // 예를 들어, 폼에서 이름, 성별, 색상은 단일 값을 가지지만, 취미와 과목은 여러 값을 가질 수 있으므로 배열로 처리됩니다.
        // 이렇게 가져온 데이터는 서블릿에서 처리되어 클라이언트에게 응답할 때 사용됩니다.

        // 클라이언트로의 응답 준비
        response.setContentType("text/html; charset=UTF-8");
        // 클라이언트에게 보낼 응답의 콘텐츠 타입을 설정합니다. 여기서는 HTML 문서와 UTF-8 문자 인코딩을 사용합니다.
        // setContentType 메서드는 서버에서 클라이언트로 보내는 응답의 콘텐츠 타입을 설정합니다.
        // "text/html"은 클라이언트에게 HTML 문서를 보낸다는 것을 의미하며, "charset=UTF-8"은 UTF-8 인코딩을 사용하여 텍스트를 전송함을 의미합니다.
        PrintWriter out = response.getWriter();
        // PrintWriter 객체를 통해 클라이언트에게 응답 데이터를 전송할 수 있습니다.
        // PrintWriter는 서버가 클라이언트로 데이터를 출력(보내기)할 때 사용하는 객체입니다.
        // getWriter() 메서드를 통해 HttpServletResponse 객체에서 PrintWriter 객체를 가져오며, 이 객체를 사용하여 HTML 콘텐츠를 작성합니다.

        // HTML 응답 작성
        out.println("<html>");
        out.println("<body>");
        out.println("<ul style='color: " + color + ";'>");
        out.println("<hr/>");
        out.println("<li><p><strong>이름</strong>: <span style='color:" + color + "'>" + name + "</span></p></li>");
        out.println("<li><p><strong>성별</strong>: <span style='color:" + color + "'>" + gender + "</span></p></li>");
        out.println("<li><p><strong>색깔</strong>: <span style='color:" + color + "'>" + color + "</span></p></li>");
        out.println("<li><p><strong>취미</strong>: <span style='color:" + color + "'>" + String.join(", ", hobby) + "</span></p></li>");
		/*
		 * out.println("<li>취미 : "); if (hobby != null) { for (int i=0; i<hobby.length;
		 * i++) { out.println(hobby[i] + "&nbsp;"); } }else {
		 * out.println("선택한 취미가 없습니다."); }
		 */
        /*
         * 과목 정보를 출력하는 부분입니다.
         * 선택한 과목이 있다면 쉼표로 구분하여 출력하고, 그렇지 않다면 "선택한 과목이 없습니다."라는 메시지를 출력합니다.
         */
        out.println("<li><p><strong>과목</strong>: <span style='color:" + color + "'>" + String.join(", ", subject) + "</span></p></li>");
        /*
        out.println("<li>과목 : ");
        if (subject != null) {
            for (int i = 0; i < subject.length; i++) {
                out.println(subject[i] + "&nbsp;");
            }
        } else {
            out.println("선택한 과목이 없습니다.");
        }
        out.println("</li>");
        */
        out.println("</ul>");
        out.println("<br><br>");
        out.println("<input type='button' value='뒤로가기' onclick='history.go(-1)'>");
        out.println("</body>");
        out.println("</html>");
        // HTML 문서의 끝을 표시합니다.
    }
}

/*
 * 주석 내용:
 * 
 * 1. HTML 구조 작성:
 * - <html> 태그와 <body> 태그를 사용하여 HTML 문서의 기본 구조를 생성합니다.
 * - <h2> 태그를 사용해 "선택한 정보"라는 제목을 표시합니다.
 * 
 * 2. 클라이언트 입력 데이터 표시:
 * - <p> 태그를 사용해 클라이언트가 입력한 이름, 성별, 색상, 취미, 과목 정보를 각각 표시합니다.
 * - <span> 태그와 inline CSS 스타일을 사용해 텍스트의 색상을 클라이언트가 선택한 색상으로 설정합니다.
 * 
 * 3. "뒤로가기" 버튼:
 * - <input> 태그를 사용해 "뒤로가기" 버튼을 생성합니다. 이 버튼을 클릭하면 history.go(-1) 자바스크립트 함수를 호출하여 이전 페이지로 이동합니다.
 * 
 * 4. String.join():
 * - String.join() 메서드를 사용해 배열 형태의 취미와 과목 데이터를 쉼표(", ")로 구분하여 문자열로 변환하고 출력합니다.
 * 
 * 5. Text Block 사용:
 * - Java 13부터 도입된 Text Block 기능을 사용하여 여러 줄에 걸친 HTML 코드를 깔끔하게 작성합니다.
 * - Text Block은 코드 가독성을 높이고, 다중 줄의 문자열을 쉽게 작성할 수 있도록 도와줍니다.
 * - Text Block은 큰따옴표 세 개(`"""`)로 시작하고 끝나며, 내부에서는 줄바꿈과 들여쓰기가 자유롭습니다.
 * - 문자열 안에 변수를 삽입할 때는 큰따옴표(`"`)와 더하기(`+`) 연산자를 사용하여 변수 값을 포함시킵니다.
 * 
 * 추가내용
 *  클래스 상속 구조:
 * 1. PersonServlet -> HttpServlet:
 *    - `PersonServlet` 클래스는 `HttpServlet` 클래스를 상속받아 웹 요청을 처리합니다.
 *    - `HttpServlet`은 HTTP 요청(예: GET, POST)을 처리하기 위한 서블릿의 기본 클래스를 제공합니다.
 *    - 이 클래스는 주로 `doGet`, `doPost` 등의 메서드를 오버라이드하여 요청에 대한 응답을 정의합니다.
 * 
 * 2. HttpServlet -> GenericServlet:
 *    - `HttpServlet`은 `GenericServlet` 클래스를 상속받습니다.
 *    - `GenericServlet`은 서블릿의 일반적인 동작을 정의하는 추상 클래스입니다.
 *    - 서블릿의 생명주기 관리 메서드인 `init`, `service`, `destroy`를 제공하며, 특정 프로토콜에 종속되지 않는 서블릿을 구현할 수 있습니다.
 *    - `GenericServlet` 클래스는 프로토콜 독립적인 서블릿을 만들기 위한 기반 클래스로 사용됩니다.
 * 
 * 3. GenericServlet -> Servlet (인터페이스):
 *    - `GenericServlet`은 `Servlet` 인터페이스를 구현합니다.
 *    - `Servlet` 인터페이스는 서블릿이 반드시 구현해야 하는 기본 메서드들을 정의합니다.
 *    - 서블릿이 가져야 할 주요 메서드들(예: `init`, `service`, `destroy`, `getServletConfig`, `getServletInfo`)을 규정합니다.
 *    - 서블릿이 웹 컨테이너에서 동작하기 위해 구현해야 하는 최소한의 요구사항을 제공합니다.
 * 
 */

