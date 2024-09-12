<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    request.setAttribute("apple", "사과");
    // request scope에 "apple"이라는 속성 이름으로 "사과" 값을 저장합니다.
    // request scope는 동일한 요청 내에서 데이터를 유지하며, 다른 페이지로 forward될 때도 데이터가 유지됩니다.
    // 여기서 "사과"는 문자열로 설정되어 이후 JSP 페이지에서 접근 가능합니다.
    
    // 페이지 이동
    RequestDispatcher dispatcher = request.getRequestDispatcher("forwardResult.jsp");
    // 절대경로가 아닌 상대경로로 해야한다.
    // RequestDispatcher는 서버 내부에서 다른 페이지로 요청을 전달할 때 사용하는 객체입니다.
    // 여기서 "forwardResult.jsp"는 상대 경로로 지정되었으며, 이 경로를 통해 forward할 페이지를 지정합니다.
    // 절대경로(`/`)를 사용할 경우, 애플리케이션의 루트에서부터 경로를 계산하게 되므로, 상대경로를 사용하는 것이 일반적입니다.

    dispatcher.forward(request, response);
    // 제어권을 넘겨줘서 실행하게 한다.
    // forward 메소드는 서버 내부에서 다른 페이지로 요청을 넘기며, 클라이언트는 이 과정에서 페이지 전환이 일어났는지 알 수 없습니다.
    // forward는 클라이언트가 보낸 원래의 request와 response 객체를 다른 페이지로 전달하며, 그 결과를 최종적으로 클라이언트에게 전송합니다.
    // 즉, 클라이언트는 처음 요청한 페이지(`forwardProc.jsp`)로부터 전환된 것을 모른 채, 최종적으로 `forwardResult.jsp`의 결과를 받게 됩니다.
%>    

<%-- <jsp:forward page="forwardResult.jsp"/> --%>
<!-- 
    forward를 사용하여 "forwardResult.jsp" 페이지로 요청을 전달합니다.
    forward는 서버 내부에서 처리되는 방식으로, 클라이언트는 이를 알지 못합니다.
    request scope에 설정된 데이터가 forward된 페이지에서도 유지됩니다.
    -- JSP 표준 액션 태그를 사용한 forward 방식 대신, Java 코드로 forward를 처리하는 방식으로 변경되었습니다.
    -- 이 방식에서는 `RequestDispatcher` 객체를 사용해 좀 더 명시적이고 유연한 방식으로 페이지를 이동시킬 수 있습니다.
    -- JSP 액션 태그와의 차이점은 보다 명확한 흐름 제어가 가능하다는 점입니다.
 -->

 