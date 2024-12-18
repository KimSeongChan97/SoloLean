<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %> <%-- XML 태그 시작 전의 공백 제거 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    JSP 페이지 설정 부분입니다.
    첫 번째 page 디렉티브는 JSP 페이지가 XML 형식으로 응답을 생성하도록 설정합니다. contentType 속성을 통해 응답이 'text/xml' 타입임을 정의하며, UTF-8 인코딩을 사용하여 문자를 처리합니다.
    두 번째 page 디렉티브에서는 trimDirectiveWhitespaces="true"를 설정하여 JSP가 HTML이나 XML을 출력하기 전에 불필요한 공백을 제거하도록 지정합니다.
    세 번째 디렉티브는 JSTL 코어 라이브러리를 사용하기 위해 추가된 것으로, 'c'라는 접두사를 사용하여 JSTL 코어 태그를 사용할 수 있게 합니다.
--%>

<%-- <c:if test="조건"></c:if> --%>
<%-- 
    JSTL의 <c:if> 태그를 사용하여 조건문을 처리합니다. 이 태그는 자바의 if 문과 유사하게 동작하며, 조건이 참일 경우에만 내부의 코드를 실행합니다.
    여기서 사용되는 test 속성에는 조건식이 들어갑니다. JSP에서는 일반적으로 EL(Expression Language)로 조건을 작성합니다.
--%>

<c:set var="result" value="false" />
<%-- 
    JSTL의 <c:set> 태그를 사용하여 변수를 설정합니다. var 속성은 변수를 정의하고, value 속성은 그 변수에 설정할 값을 지정합니다.
    여기서는 result 변수를 false로 초기화하여, 기본적으로 아이디가 "hong"이 아닌 경우를 처리할 준비를 합니다.
    이 변수를 이용해 이후 조건문에서 아이디가 "hong"일 때 true로 변경됩니다.
--%>

<c:if  test="${param.user_id == 'hong' }">
	<c:set var="result" value="true" />
</c:if>
<%-- 
    JSTL의 <c:if> 태그를 사용하여 조건에 따라 실행될 코드를 작성합니다. 
    test 속성에는 조건식을 작성하는데, 여기서는 사용자가 입력한 user_id가 "hong"과 같은지를 검사합니다.
    조건이 참이면 내부에 있는 <c:set> 태그가 실행되어 result 변수를 true로 설정합니다.
    param.user_id는 클라이언트로부터 전달된 요청 파라미터 user_id의 값을 가져옵니다. EL을 사용하여 JSP에서 이 값을 간단하게 참조할 수 있습니다.
    이렇게 설정된 result 변수는 이후에 XML 응답에서 사용될 수 있습니다.
--%>

<%-- 
    JSTL과 EL을 사용하여 코드를 더욱 간결하고 유지보수하기 쉽게 작성하였습니다.
    JSTL은 JSP 코드에서 자바 로직을 줄이고, 태그를 사용해 선언적 방식으로 표현할 수 있도록 도와줍니다.
    이를 통해 코드의 가독성이 높아지고, 비즈니스 로직과 프레젠테이션 로직이 명확히 구분됩니다.
    EL(Expression Language)은 JSP에서 자바 코드를 최소화하고, 간단한 표현식을 통해 데이터를 처리할 수 있도록 지원합니다.
--%>

<%-- XML 보내기 --%>
<?xml version="1.0" encoding="UTF-8"?>
<check_id>
	<result>${result }</result>
</check_id>