<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%!
 	// Java 구역(전역변수 영역으로 서버가 실행될 때 한번 실행된다.)
 	// Servlet 의 init 구역
 	// 이 영역은 JSP가 처음 실행될 때 한 번만 실행됩니다. 즉, 서버가 시작되고 해당 JSP 페이지가 처음 요청될 때
 	// 이 부분의 코드가 실행됩니다. 이를 통해 초기화 작업 등을 처리할 수 있습니다.
 	// 전역 변수로 설정한 name과 age는 JSP가 종료되기 전까지 동일한 값을 유지합니다.
 	
 	String name = "홍길동"; // 이름을 저장하는 전역변수
 	int age = 25; // 나이를 저장하는 전역변수
 	
 %> 
 
 <%
 	// Java 구역(지역변수 영역으로 클라이언트 요청시 마다 실행한다.)
 	// Servlet 의 service() 구역
 	// 이 영역은 JSP가 클라이언트의 요청을 받을 때마다 실행됩니다. 즉, 매번 요청할 때마다 이 코드가 실행되어
 	// age 변수의 값이 증가하게 됩니다.
 	
 	age++; // 나이를 1씩 증가시키는 로직. 클라이언트가 요청할 때마다 age 값이 1씩 증가합니다.
 %>
 
 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
</head>
<body>
	<h1 align="center">JSP의 지역,전역변수와 함께 Servlet 과 JSP 연습</h1>
	
<!-- Hello JSP!! <br/> -->

<%-- 안녕하세요 JSP !! <br/> --%>

<!-- 
    위 주석은 HTML 주석과 JSP 주석의 차이를 설명하기 위해 남겨둔 것입니다.
    JSP 주석은 서버에서만 해석되고, 클라이언트가 보는 소스코드에서는 보이지 않습니다.
    반면 HTML 주석은 클라이언트의 브라우저에서도 확인할 수 있습니다.
-->

<hr/>
나의 이름은 <%=name %> 입니다. <br/>
<!-- JSP 표현식입니다. 해당 표현식은 name 변수의 값을 HTML 페이지에 출력합니다.
     JSP 표현식은 코드블록과는 다르게 바로 변수를 출력하는 용도로 사용됩니다. -->

<% out.println("나의 이름은 " + name + " 입니다."); %> <br/>
<!-- out.println()은 JSP의 out 객체를 통해 직접 HTML로 출력하는 방식입니다.
     하지만 JSP에서는 이 방식이 비효율적입니다. JSP 표현식을 사용하는 것이 메모리 관리 측면에서 더 낫습니다.
     out.println()을 사용하면 JSP가 서블릿으로 변환될 때 더 많은 메모리를 사용하게 됩니다. -->

<hr/>
나의 나이는 <%=age %> 살 입니다. <br/>
<!-- JSP 표현식으로 age 변수의 값을 HTML로 출력합니다.
     페이지가 로드될 때마다 age 값이 증가하므로, 방문할 때마다 나이가 1씩 증가하는 것을 확인할 수 있습니다. -->

<% out.println("나의 나이는 " + age + " 살 입니다."); %> <br/>
<!-- 마찬가지로 out.println()을 통해 age 변수를 출력하는 방법입니다.
     JSP 표현식을 사용하지 않고 직접 출력을 원할 때 사용되지만, 메모리 효율은 떨어집니다. -->
     
   
   <!-- 나의 나이는 <%=age %> 살 입니다. <br/> --!>  
   <%-- <% out.println("나의 나이는 " + age + " 살 입니다."); %> --%>

</body>
</html>


<!-- 

HTML 주석과 JSP 주석의 차이
소스보기(F12) 에서 보이는 것의 차이이다.
=> HTML 주석은 클라이언트(브라우저)에서 페이지의 소스코드를 볼 때 보이지만,
   JSP 주석은 서버 측에서만 해석되고 클라이언트에게는 전송되지 않는다.

JSP의 내장객체
1. request : javax.servlet.http.HttpServletReqeuest 
   - 클라이언트의 요청 정보를 담고 있는 객체. 클라이언트로부터 전달된 데이터(파라미터, 쿠키, 헤더 등)를 받을 때 사용합니다.
   
2. response : javax.servlet.http.HttpServletResponse
   - 서버가 클라이언트로 보내는 응답을 처리하는 객체. 클라이언트에게 데이터를 전송할 때 사용합니다.

3. out : javax.servlet.jsp.JspWriter
   - 클라이언트에게 텍스트 데이터를 출력할 때 사용하는 객체. JSP에서 HTML을 출력할 때 주로 사용됩니다.

4. session : javax.servlet.http.HttpSession
   - 클라이언트와 서버 간의 세션을 관리하는 객체. 사용자 정보를 저장하거나 상태를 유지할 때 사용됩니다.

5. application : javax.servlet.ServletContext
   - 애플리케이션 전체에서 공유할 수 있는 데이터를 저장하거나 가져오는 데 사용하는 객체. 모든 클라이언트가 접근할 수 있는 전역 공간입니다.

6. pageContext : javax.servlet.jsp.PageContext
   - JSP 페이지에 대한 정보를 담고 있는 객체. 해당 JSP 페이지에만 유효한 데이터를 저장할 수 있습니다.

7. page : javax.servlet.jsp.HttpJspPage
   - JSP 페이지 자체를 가리키는 객체. 현재 페이지에 대한 정보를 관리합니다.

8. config : javax.servlet.ServletConfig
   - JSP 페이지를 서블릿으로 동작하게 할 때 초기화 파라미터 등을 관리하는 객체입니다.

9. exception : java.lang.Throwable
   - 예외 처리 시 발생한 에러를 다룰 때 사용하는 객체. JSP에서 예외 페이지를 지정해 처리할 수 있습니다.

Java 파일은 컴파일 과 *.class 를 거쳐야 한다.
jsp 를 만들게 되면 eclipse 내부적으로 소스가 바뀔때 만 컴파일한다. 
(hello.jsp -> hello_jsp.java(서블릿) -> hello_jsp.class)
해당 경로
D:\Web\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\testJSP\org\apache\jsp\exam

이는 많은 메모리를 차지하므로 jsp 보다 다른 걸 선호하게 된다.
=> JSP는 동적으로 자바 코드를 삽입할 수 있지만, 내부적으로 서블릿으로 변환되어 실행되기 때문에
   일반적으로 서블릿보다 메모리를 더 많이 사용하게 됩니다. 특히 대규모 트래픽의 웹사이트에서는 JSP보다 서블릿이나 다른 기술이 선호됩니다.

Java파일은
컴파일 -> 톰캣 을 껏다 켜야한다 -> 맨 위부터 실행.
=> Java 파일은 수정될 때마다 수동으로 컴파일해야 하며, 서버를 재시작하여 반영해야 합니다. 반면 JSP는 변경 시 자동으로 컴파일됩니다.
 -->

