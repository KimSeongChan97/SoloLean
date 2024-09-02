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

public class PersonServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;   
    // 서블릿 클래스는 Serializable 인터페이스를 구현해야 하며, serialVersionUID는 클래스의 버전을 관리하는데 사용됩니다.

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // 클라이언트가 GET 요청을 보냈을 때 이 메서드가 호출됩니다.
        // HttpServletRequest는 클라이언트의 요청 정보를 담고 있고,
        // HttpServletResponse는 서버의 응답 정보를 담고 있습니다.

        // 데이터 가져오기
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String color = request.getParameter("color");
        String[] hobbies = request.getParameterValues("hobby");
        String[] subjects = request.getParameterValues("subject");

        // 클라이언트로의 응답 준비
        response.setContentType("text/html; charset=UTF-8");
        // 클라이언트에게 보낼 응답의 콘텐츠 타입을 설정합니다. 여기서는 HTML 문서와 UTF-8 문자 인코딩을 사용합니다.
        PrintWriter out = response.getWriter();
        // PrintWriter 객체를 통해 클라이언트에게 응답 데이터를 전송할 수 있습니다.

        // HTML 응답 작성
        out.println("<html>");
        out.println("<body>");
        out.println("<h2>선택한 정보:</h2>");
        out.println("<p><strong>이름</strong>: " + name + "</p>");
        out.println("<p><strong>성별</strong>: " + (gender.equals("남자") ? "남" : "여") + "</p>");
        out.println("<p><strong>색깔</strong>: <font color='" + color.toLowerCase() + "'>" + color + "</font></p>");
        out.println("<p><strong>취미</strong>: " + String.join(", ", hobbies) + "</p>");
        out.println("<p><strong>과목</strong>: " + String.join(", ", subjects) + "</p>");
        out.println("<br><br>");
        out.println("""
                <input type='button' value='뒤로가기' onclick='history.go(-1)'>
                """);
        // 사용자가 "뒤로가기" 버튼을 클릭하면 이전 페이지로 돌아가도록 합니다.
        out.println("</body>");
        out.println("</html>");
    }
}
