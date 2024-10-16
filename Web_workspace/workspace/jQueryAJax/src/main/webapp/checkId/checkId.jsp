<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %> <%-- XML 태그 시작 전의 공백 제거 --%>
<%-- 
    첫 번째 page 디렉티브는 JSP 페이지가 XML 형식으로 응답을 생성하도록 설정합니다. 
    contentType 속성을 통해 응답이 'text/xml' 타입임을 정의하며, UTF-8 인코딩을 사용하여 문자를 처리합니다. 
    이는 XML 데이터를 반환할 때 적절한 문자 인코딩을 보장하기 위함입니다. 

    두 번째 page 디렉티브에서는 trimDirectiveWhitespaces="true"를 설정하여 JSP가 HTML을 출력하기 전에 불필요한 공백을 제거하도록 지정합니다. 
    이는 XML의 시작 태그 전에 불필요한 공백이 포함되지 않도록 하여 XML 파서 오류를 방지하는 데 유용합니다.
    공백이 잘못 포함되면 XML 파서가 이를 잘못 해석할 수 있으므로, 이러한 설정은 매우 중요합니다.
--%>

<%
// Java 구역
String user_id = request.getParameter("user_id");
//String user_id = "hong";

// <%-- 사용자의 입력을 서버로부터 받기 위해 request 객체의 getParameter 메서드를 사용하여 "user_id"라는 이름의 파라미터 값을 가져옵니다. 
// <%-- 이 값은 사용자가 폼을 통해 제출한 값일 수 있으며, 주어진 키 "user_id"에 해당하는 값을 가져옵니다. 
// <%-- "user_id" 파라미터는 클라이언트가 서버에 요청할 때 포함하는 값으로, 이를 통해 특정 사용자의 아이디를 확인하거나 처리할 수 있습니다. 
// <%-- 코멘트 처리된 String user_id = "hong"; 부분은 테스트를 위한 코드로, 특정 사용자 ID로 가정하여 동작을 확인할 때 사용될 수 있습니다. 
// <%-- 이 부분의 주석을 해제하면 실제 요청된 user_id 대신 "hong"이라는 고정된 값을 사용하게 되므로, 중복 체크 등의 기능을 테스트할 때 유용합니다. 

// DB 연동 구역
// 예를 들어, 만약에 "hong" 이라면 DB에 이미 저장된 id로 한다면. => hong이 아니면 사용 불가능
boolean result = false;
// <%-- 초기값으로 result를 false로 설정하여 기본적으로 아이디가 "hong"이 아니면 사용 불가능하도록 합니다. 
// <%-- 이 변수는 최종적으로 XML 응답의 <result> 태그에 출력되며, 클라이언트는 이 값을 통해 아이디의 사용 가능 여부를 확인합니다. 

if(user_id.equals("hong")) result = true;
// <%-- user_id 값이 "hong"과 일치하는지 확인합니다. 
// <%-- 만약 user_id가 null이거나 "hong"과 다를 경우, NullPointerException이 발생할 수 있으므로, 
// <%-- 실제 환경에서는 user_id가 null인지 먼저 확인하는 것이 좋습니다. 
// <%-- 여기서는 간단히 설명하기 위해 null 체크를 생략했지만, 실제 코드에서는 이 점을 주의해야 합니다. 
// <%-- user_id가 "hong"과 일치하면 result 값을 true로 설정하여, 사용 중인 아이디임을 나타냅니다. 
// <%-- 이 예제에서는 간단히 문자열 비교로 처리하지만, 실제로는 데이터베이스와 연동하여 중복 여부를 확인하는 것이 일반적입니다. 

%>    

<%-- XML 보내기 --%>
<?xml version="1.0" encoding="UTF-8"?>
<%-- 
    XML 문서의 선언부로, XML 문서의 버전과 인코딩을 지정합니다. 
    여기서는 XML 버전 1.0과 UTF-8 인코딩을 사용하고 있습니다.
    이 선언부는 XML 문서의 최상단에 위치해야 하며, 클라이언트가 XML 문서를 올바르게 해석할 수 있도록 도와줍니다.
--%>

<check_id>
	<result><%=result %></result>
</check_id>

<%-- 
    <check_id> 루트 엘리먼트 안에 <result> 태그를 포함하고 있습니다. 
    <result> 태그 안에는 JSP의 스크립틀릿을 사용하여 result 변수를 출력합니다.
    이 때 result 변수의 값이 true 또는 false로 출력되며, 이는 사용자가 입력한 user_id가 유효한지 여부를 나타냅니다.
    JSP의 결과 구문 <%= %>은 변수나 표현식의 결과를 HTML 또는 XML의 일부로 삽입할 때 사용됩니다. 
    이렇게 생성된 XML 문서는 클라이언트로 전송되어 결과를 확인할 수 있게 됩니다.
    클라이언트는 이 XML 문서를 받아 결과 값에 따라 적절한 동작(예: 경고 메시지 표시, 사용자 등록 완료 등)을 수행할 수 있습니다.
--%>

<%-- 
    trimDirectiveWhitespaces 속성
    JSP에서 서블릿이나 EL을 이용할 경우, 로딩된 페이지에서 소스 보기를 해 보면 공백이 표기될 수 있습니다.
    trimDirectiveWhitespaces 속성을 true로 설정할 경우, JSP가 생성하는 HTML이나 XML 문서에서 불필요한 공백을 모두 제거해 줍니다.
    이는 XML과 같은 구조화된 데이터 형식을 출력할 때 매우 유용하며, 공백으로 인해 발생할 수 있는 파싱 오류를 방지하는 데 도움이 됩니다.
--%>

<%-- 
    JSP (Java Server Pages)
    JSP는 Java와 HTML이 섞여 있는 형태로, 서버 측에서 동적으로 웹 페이지를 생성하는 데 사용됩니다.
    스크립틀릿(Scriptlet) <%= %>은 JSP 코드 내에서 Java 코드를 삽입할 때 사용됩니다.
    JSP에서 Java 코드를 점차 없애고, 표현 언어(EL)와 JSP 표준 태그 라이브러리(JSTL)로 대체하는 것이 권장됩니다.
    이는 코드의 가독성을 높이고 유지 보수를 용이하게 하기 위함입니다.
--%>

<%-- 
    EL (Expression Language) 및 JSTL (JSP Standard Tag Library)
    EL과 JSTL을 사용하면 JSP에서 Java 코드를 줄이고, 더 선언적인 방식으로 웹 페이지를 작성할 수 있습니다.
    예를 들어, ${} 구문을 사용하여 JSP 페이지에서 Java 객체의 속성에 접근할 수 있습니다.
    JSTL을 사용하려면 추가 라이브러리가 필요합니다.
    예를 들어, mvnrepository.org에서 JSTL 1.2 버전의 jar 파일을 다운로드하고, 이를 웹 애플리케이션의 WEB-INF/lib 폴더에 복사하여 사용해야 합니다.
    이는 JSP에서 조건문, 반복문, 포맷팅 등을 보다 간결하고 직관적으로 처리할 수 있게 합니다.
--%>

