<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Start</title>
<style type="text/css">

body {
	background-color: #f2f2f2;
	text-align: center;
	margin-top: 110px;
}

</style>
</head>
<body>

<font color="red" >
    <b>
        start.jsp - sendProc.jsp - sendResult.jsp 페이지 이동합니다 <br>
        sendRedirect 로 이동하므로 데이터는 공유하지 않습니다. <br>
        주소는 sendResult.jsp가 보인다. <br>
    </b>
</font>
<br>
<%--
    여기서는 sendRedirect를 통해 `start.jsp`에서 `sendProc.jsp`를 거쳐 
    `sendResult.jsp`로 이동하는 흐름을 설명하고 있습니다.
    - sendRedirect: 클라이언트 측에서 새로운 요청을 보내어 페이지를 이동하는 방식입니다. 
    새로운 HTTP 요청이 발생하며, 서버는 이전 요청과는 다른 새로운 응답을 보냅니다. 
    이전 페이지에서 전송된 데이터는 더 이상 사용할 수 없으며, 데이터는 공유되지 않습니다.
    - 주소 표시줄에는 최종 목적지인 `sendResult.jsp`의 주소가 보입니다.
    즉, `sendProc.jsp`로 이동한 후 `sendResult.jsp`로 최종적으로 리다이렉트됩니다.
 --%>

<font color="blue" >
    <b>
        start.jsp - forwardProc.jsp - forwardResult.jsp 페이지 이동합니다 <br>
        forward 로 이동하므로 데이터는 공유됩니다. <br>
        주소는 forwardProc.jsp으로 보이지만 결과는 forwardResult.jsp 가 나온다. <br>
    </b>
</font>
<br>
<%--
    여기서는 forward를 통해 `start.jsp`에서 `forwardProc.jsp`를 거쳐 
    `forwardResult.jsp`로 이동하는 흐름을 설명하고 있습니다.
    - forward: 서버 측에서 클라이언트 요청을 다른 JSP나 서블릿으로 전달하는 방식입니다.
     클라이언트는 이를 알지 못하고 서버 내에서 처리됩니다.
    forward는 이전 요청과 데이터를 유지하며, 같은 요청 안에서 처리가 이루어집니다.
    즉, `start.jsp`에서 받은 요청이 서버 내부에서 `forwardProc.jsp`를 거쳐
     `forwardResult.jsp`로 전달되며, 이전 요청에 담긴 데이터(예: 파라미터, 세션 데이터 등)를 공유할 수 있습니다.
    - 주소 표시줄에는 여전히 `forwardProc.jsp`의 주소가 보이지만, 실제로는 `forwardResult.jsp`의 결과가 출력됩니다.
    이는 클라이언트가 직접 `forwardResult.jsp`로 이동한 것이 아닌, 서버 내부에서 해당 페이지로 처리가 위임된 것입니다.
 --%>

<input type="button" value="sendRedirect" onclick="location.href='sendProc.jsp'">
<%--
    이 버튼은 HTML `<input>` 요소로, 클릭 시 `sendProc.jsp`로 이동합니다.
    이 버튼을 클릭하면 자바스크립트의 `location.href` 속성을 통해 페이지가 리다이렉트됩니다.
    sendRedirect 방식은 새로운 HTTP 요청을 발생시키고, 서버는 이전 요청과 관련이 없는 새로운 응답을 보냅니다.
    최종적으로 `sendProc.jsp`에서 `sendResult.jsp`로 다시 리다이렉트됩니다.
 --%>

<input type="button" value="forward" onclick="location.href='forwardProc.jsp'">
<%--
    이 버튼 역시 HTML `<input>` 요소로, 클릭 시 `forwardProc.jsp`로 이동합니다.
    `location.href`는 자바스크립트를 사용하여 클라이언트 측에서 페이지 이동을 제어하는 기능입니다.
    forward 방식은 서버 내부에서 요청을 다른 페이지로 전달하는 방식입니다. 
    이 버튼을 클릭하면 `forwardProc.jsp`로 이동하며, 서버에서 처리된 후 forward가 수행됩니다.
    forward는 데이터가 공유되며, 최종적으로 `forwardResult.jsp`의 결과가 출력되지만
     주소창에는 `forwardProc.jsp`가 유지됩니다.
 --%>

	 
</body>
</html>

<%-- 
페이지 루트 : page < request < session < application

1. page scope (페이지 범위)
   - 해당 JSP 페이지 내에서만 유효한 범위입니다.
   - 현재 JSP 페이지가 처리되는 동안에만 속성이 유지되며, 다른 페이지나 서블릿으로 전달되지 않습니다.
   - 주로 페이지 내에서만 필요한 임시 데이터를 저장할 때 사용됩니다.
   - 예: `<% pageContext.setAttribute("name", "홍길동"); %>`처럼 페이지 내에서 데이터를 설정하고, 페이지 안에서만 접근할 수 있습니다.
   - 유효 범위: 현재 JSP 페이지 내.

2. request scope (요청 범위)
   - **하나의 요청(Request)** 내에서 유효한 범위입니다.
   - 동일한 요청 내에서 여러 JSP 페이지나 서블릿이 포함될 수 있으며, 그들 사이에서 데이터를 공유할 수 있습니다.
   - 주로 한 번의 요청 동안 처리되는 데이터를 저장할 때 사용됩니다.
   - 예: `<% request.setAttribute("user", "홍길동"); %>`를 통해 요청이 끝날 때까지 속성을 유지합니다.
   - 유효 범위: 요청 시작부터 응답이 완료될 때까지.

3. session scope (세션 범위)
   - **사용자 세션** 동안 유효한 범위입니다.
   - 한 사용자가 웹 애플리케이션에 접속한 이후부터 브라우저를 종료하거나 세션이 만료될 때까지 속성이 유지됩니다.
   - 주로 로그인 정보나 사용자 데이터를 유지하기 위해 사용됩니다.
   - 예: `<% session.setAttribute("userId", "hong123"); %>`처럼 세션에 데이터를 저장하고, 동일한 사용자 세션 동안 값을 유지합니다.
   - 유효 범위: 세션이 시작된 후 세션이 만료될 때까지.

4. application scope (애플리케이션 범위)
   - **애플리케이션 전체**에서 유효한 범위입니다.
   - 웹 애플리케이션이 실행되는 동안 모든 사용자와 모든 세션에서 공유되는 데이터를 저장할 수 있습니다.
   - 주로 모든 사용자에게 공통적으로 적용되는 설정 정보 등을 저장할 때 사용됩니다.
   - 예: `<% application.setAttribute("appName", "MyApp"); %>`를 사용해 애플리케이션 전체에서 속성을 사용할 수 있습니다.
   - 유효 범위: 애플리케이션이 시작된 후 애플리케이션이 종료될 때까지.
 --%>
