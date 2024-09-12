<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 
    이 페이지는 JSP 표준 태그 라이브러리(JSTL)를 사용하기 위해 c 태그를 선언하고 있습니다.
    JSTL은 반복문, 조건문 등의 제어 구문을 JSP에서 간단하게 사용할 수 있도록 도와줍니다.
    이 경우, `c:forEach` 태그를 사용하여 반복문을 구현할 예정입니다.
    JSP에서 자바 코드를 최소화하고, 비즈니스 로직과 표현 로직을 분리할 수 있게 도와줍니다.
 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forwardStart를 거쳐 End 로</title>
<style type="text/css">

body {
	background-color: #0d0d0d;
	color: #00ffcc;
	text-align: center;
	margin-top: 60px;
}

</style>
</head>
<body>

    forward로 보내면 데이터는 공유한다. <br>
    주소는 forwardStart.jsp가 보이지만, 화면은 forwardEnd.jsp가 보인다. <br><br>
    <!-- 
        forward는 서버 내부에서 요청을 다른 페이지로 전달하기 때문에 클라이언트는 forwardEnd.jsp로 이동했는지 알지 못합니다.
        따라서 브라우저의 주소창에는 여전히 forwardStart.jsp가 표시되지만, 실제로는 forwardEnd.jsp에서 처리된 결과가 화면에 나타납니다.
        이는 forward 방식의 특징으로, 서버 내부에서 처리되기 때문에 클라이언트가 요청의 흐름을 알 수 없습니다.
        클라이언트는 forward 과정이 일어났다는 것을 인지하지 못하며, 마치 하나의 요청처럼 보입니다.
        forward는 서버 내부에서 발생하므로, 클라이언트가 새로운 요청을 했다고 생각하지 않습니다.
    -->

<!-- request 로 정보를 담아오므로 -->
결과는 = ${requestScope.list }
<!-- 
    request scope의 데이터를 EL(Expression Language)를 사용하여 출력합니다.
    forward는 request scope의 데이터를 공유하므로, forwardStart.jsp에서 설정된 'list' 객체가 forwardEnd.jsp에서도 사용될 수 있습니다.
    여기서는 request scope에 저장된 'list' 객체를 출력하여, '호랑이', '사자' 등의 동물 목록을 화면에 출력할 수 있습니다.
    EL을 사용하면 request 객체에 저장된 값을 쉽게 표현할 수 있으며, 별도의 자바 코드를 작성할 필요가 없습니다.
 -->

<%--
<%
    // 자바로 받는다면
    request.getAttribute("list");
    // request 객체에서 데이터를 가져오는 자바 코드입니다. 
    forward 방식은 request 객체를 유지하기 때문에 이 데이터를 정상적으로 가져올 수 있습니다.
    만약 sendRedirect 방식을 사용했다면 이 데이터는 null이 되었을 것입니다.
    sendRedirect는 새로운 요청을 발생시키므로 request scope에 있는 데이터는 전달되지 않습니다.
%>
--%>

<br><br>

3번 째 항목 = ${requestScope.list[2] }
<!-- 
    request scope에 저장된 list의 세 번째 항목을 출력합니다.
    EL(Expression Language)을 사용하여 'list' 객체의 0번째부터 시작하는 인덱스 중 2번째 항목인 "기린"이 출력됩니다.
    이는 배열이나 리스트의 특정 인덱스 값에 접근하는 방식입니다.
    JSP의 EL은 배열이나 리스트의 인덱스에 접근할 수 있는 간단한 방법을 제공합니다.
 -->

<br><br>

<!-- for 문을 통해 본다면 -->
<%-- 자바로 한다면, for(String data : requestScope.list) --%>
<c:forEach var="data" items="${list}">
    ${data }<br>
</c:forEach>
<!-- 
    `c:forEach`는 JSTL의 반복문 태그입니다.
    'items' 속성은 반복할 객체(여기서는 'list' 객체)를 지정하며, 'var' 속성은 각 반복 주기마다 값을 담을 변수를 지정합니다.
    즉, 여기서 `var="data"`는 'list'의 각 항목을 'data'라는 변수에 담아 한 번씩 반복합니다.
    각 반복 주기마다 'list'의 항목들이 하나씩 출력됩니다. 예를 들어, "호랑이", "사자", "기린" 등이 차례로 출력됩니다.
    자바의 for-each 구문과 유사한 기능을 제공합니다.
    JSP의 JSTL 태그는 자바 코드의 반복문 대신 사용할 수 있어 코드 가독성을 높입니다.
 -->

<!-- pageScope 와 requestScope 둘다 list 가 있다면 축약을 사용할 수 없다.
    var="data" 의 이유는 각 반복문마다의 데이터를 담기 위한 변수입니다.
    JSP는 여러 범위(scope)를 가지고 있으며, 각각의 scope에서 동일한 이름의 변수를 사용할 수 있습니다.
    하지만 pageScope와 requestScope 모두에 같은 이름의 변수가 있다면, EL에서 축약하여 호출할 수 없기 때문에 명시적으로 범위를 지정해야 합니다.
    예를 들어, requestScope의 list를 사용하려면 `${requestScope.list}`로 명시하고,
    pageScope의 list를 사용하려면 `${pageScope.list}`로 명시해야 합니다.
    이를 통해 동일한 이름의 변수가 여러 범위에 존재할 때, 어느 범위의 변수를 사용할지 명확하게 지정할 수 있습니다.
    scope는 데이터의 유효 범위를 결정하며, JSP에서는 다양한 범위를 명시적으로 관리할 수 있습니다.
 -->
 
 <br><br>
 
 <%-- 자바로 한다면, for(PersonDTO personDTO : list) --%>
<c:forEach var="personDTO" items="${list2 }">
	${personDTO }<br>
</c:forEach>
<!-- 자료형이 없기 때문에 personDTO 의 이름만 받아오면 된다. -->
<!-- 
    `c:forEach` 태그를 사용하여 'list2'에 있는 PersonDTO 객체를 반복 출력합니다.
    이때 ${personDTO}는 객체 자체를 출력하며, 해당 객체의 `toString()` 메서드가 호출되어 문자열 형태로 출력됩니다.
    JSP에서는 자료형에 관계없이 객체를 다룰 수 있으며, EL을 사용하여 간단하게 표현할 수 있습니다.
 -->
 <br><br>

<c:forEach var="personDTO" items="${list2 }">
	${personDTO.getName() } &emsp;&emsp; ${personDTO.getAge() }<br>
	
	<%-- JSTL 에서는 메서드의 이름을 변수명처럼 사용한다. -> personDTO.getName() 에서 get과 () 를 제거한다는 의미. --%>
	${personDTO.name } &emsp;&emsp; ${personDTO.age }<br>
</c:forEach>
<!-- 
    위의 반복문에서 PersonDTO 객체의 특정 필드 값을 출력하고 있습니다.
    ${personDTO.getName()}과 ${personDTO.getAge()}는 getter 메서드를 호출하여 name과 age 필드를 출력합니다.
    EL에서는 getter 메서드를 자동으로 호출하므로, 필드 이름을 그대로 사용해도 동일하게 출력됩니다.
    예를 들어, ${personDTO.name}과 같이 사용하면, 실제로는 getName() 메서드가 호출되는 것입니다.
 -->

</body>
</html>

<%--
pageScope → requestScope → sessionScope → applicationScope 순으로 호출
<!-- 
    JSP에서 데이터를 저장하고 접근할 수 있는 네 가지 범위(scope)가 있습니다:
    1. **pageScope**: 현재 JSP 페이지 내에서만 유효한 범위입니다. 다른 페이지로 이동할 경우 데이터는 사용할 수 없습니다.
    2. **requestScope**: 동일한 요청 내에서 유효한 범위입니다. forward를 사용하면 데이터가 유지되지만, sendRedirect를 사용하면 데이터는 유지되지 않습니다.
    3. **sessionScope**: 특정 사용자의 세션 동안 유효한 범위로, 브라우저가 종료되거나 세션이 만료될 때까지 데이터가 유지됩니다.
    4. **applicationScope**: 애플리케이션 전체에서 유효한 범위로, 모든 사용자와 세션에서 데이터를 공유할 수 있습니다. 애플리케이션이 종료될 때까지 데이터가 유지됩니다.
    이 범위들은 각기 다른 목적으로 사용되며, 데이터를 저장할 범위에 따라 유효 기간이 달라집니다.
    scope는 데이터의 생명 주기와 범위를 관리하며, JSP에서 이를 명확하게 지정하는 것이 중요합니다.
 -->
 --%>
