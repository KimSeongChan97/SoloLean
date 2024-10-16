package com.person;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// PersonServlet 클래스는 javax.servlet.http.HttpServlet 클래스를 상속받아 작성된 서블릿입니다.
// 이 서블릿은 클라이언트로부터의 요청을 받아 처리하고, 그 결과를 클라이언트에게 HTML 형태로 응답합니다.

public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // serialVersionUID는 직렬화된 객체의 클래스 버전을 식별하기 위한 고유한 값입니다.
    // 서블릿 클래스는 직렬화 가능(serializable)해야 하며, 이 값은 직렬화된 객체가 로드될 때
    // 클래스의 호환성을 확인하는 데 사용됩니다. 여기서는 명시적으로 serialVersionUID를 선언하여
    // 클래스의 버전 관리를 쉽게 할 수 있습니다.
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// doGet 메서드는 클라이언트로부터의 GET 요청을 처리합니다.
        // 이 메서드는 HttpServletRequest와 HttpServletResponse 객체를 사용하여
        // 요청의 정보를 읽고, 응답을 작성하여 클라이언트에게 전송합니다.
			
		// 데이터
		String name = request.getParameter("name");
        // request.getParameter("name") 메서드를 사용하여 클라이언트가 요청에 포함시킨
        // "name" 파라미터 값을 가져옵니다. 이 값은 문자열로 반환되며, 사용자가 폼에 입력한 이름이 될 것입니다.
		
		int age = Integer.parseInt(request.getParameter("age"));
        // request.getParameter("age") 메서드를 사용하여 "age" 파라미터 값을 문자열로 가져온 후,
        // Integer.parseInt() 메서드를 사용하여 해당 문자열을 정수(int)로 변환합니다.
        // 이 과정에서 클라이언트가 유효한 숫자를 입력했다고 가정하며, 입력이 잘못된 경우 예외가 발생할 수 있습니다.
        // 예외가 발생할 경우 서블릿은 기본적으로 500 내부 서버 오류를 클라이언트에 반환합니다.
		
		// 응답
		response.setContentType("text/html; charset=UTF-8");
        // 응답의 콘텐츠 타입을 설정합니다. 여기서는 응답이 HTML 형식이며,
        // UTF-8 인코딩을 사용하여 텍스트가 인코딩될 것임을 클라이언트에게 알립니다.
        // 이 설정은 브라우저가 응답을 적절하게 렌더링하는 데 중요한 역할을 합니다.
		
		PrintWriter out = response.getWriter();
        // response.getWriter() 메서드는 응답 객체로부터 PrintWriter 객체를 가져와
        // 클라이언트에게 데이터를 전송할 수 있게 합니다. 이 객체를 사용하여
        // HTML 코드를 클라이언트에게 전송할 수 있습니다.
        // PrintWriter 객체는 서버에서 클라이언트로 텍스트 데이터를 출력하는 데 사용됩니다.

		out.println("<html>");
		out.println("<body>");
        // HTML 문서의 시작 태그를 전송합니다. 클라이언트 브라우저는 이 태그들을 사용하여
        // 문서의 구조를 이해하고 렌더링합니다.

		out.println(name + " 님의 나이는 " + age + " 세 이므로, ");
        // 사용자가 입력한 이름과 나이를 HTML 문서의 본문에 표시합니다.
        // 이 줄에서는 사용자가 입력한 이름과 나이를 출력하고,
        // 뒤이어 나이가 성인인지 미성년자인지를 판단하여 출력합니다.

		if(age >= 19) 
			out.println("<font color='red'>성인</font> 입니다.");
        // 사용자의 나이가 19세 이상이면 "성인 입니다."라는 메시지를 출력합니다.
        // 여기서 <font color='red'> 태그를 사용하여 "성인"이라는 단어를 빨간색으로 표시합니다.
        // 이 조건문은 사용자가 성인인지 여부를 판단하는 데 사용됩니다.
		else
			out.println("<font color='blue'>미성년자</font> 입니다.");
        // 사용자의 나이가 19세 미만이면 "미성년자 입니다."라는 메시지를 출력합니다.
        // 여기서 <font color='blue'> 태그를 사용하여 "미성년자"라는 단어를 파란색으로 표시합니다.
		
		out.println("<br><br>");
		// <br> 태그는 HTML에서 줄바꿈을 의미합니다.
        // 두 개의 줄바꿈을 삽입하여 가독성을 높입니다.

		// out.println("<input type='button' value='뒤로가기' onclick='history.go(-1)'>");
        // 주석 처리된 이 줄은 버튼을 생성하여 사용자가 이전 페이지로 돌아갈 수 있게 합니다.
        // history.go(-1)은 사용자의 브라우저 내역에서 한 페이지 뒤로 이동하는 자바스크립트 함수입니다.
		
		out.println("""
				<input type='button' value='뒤로가기' onclick='history.go(-1)'>
				""");
        // 위의 주석 처리된 코드와 동일한 기능을 수행하는 또 다른 표현 방식입니다.
        // 멀티라인 문자열 리터럴을 사용하여 여러 줄에 걸쳐 HTML 코드를 정의합니다.
        // 이 버튼을 클릭하면 사용자는 이전 페이지로 돌아갑니다.

		out.println("</body>");
		out.println("</html>");
        // HTML 문서를 닫는 태그들을 전송하여 응답을 마무리합니다.
        // 클라이언트 브라우저는 이 태그들을 통해 문서의 끝을 인식합니다.
	}

}
