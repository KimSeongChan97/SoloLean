<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="angel" uri="tld" %>
<%@ taglib prefix="devil" uri="tld2" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL Result_java</title>
</head>

<body>


	<h3> Java Class 의 메소드를 이용 </h3>

	<%-- 
    <p> 계산 결과 : ${param['x'] } + ${param['y'] } = ${ sum(param['x'], param['y']) }</p>
    <br/>
    - 이 부분은 주석 처리된 코드로, EL을 사용해 계산 결과를 출력하려고 했습니다.
    - 그러나 사용자 정의 함수 호출이 아니라 단순한 EL 표현식을 사용하려고 했습니다.
    - sum 함수는 별도로 정의된 것이 아니라, 메서드를 호출하려면 사용자 정의 함수로 등록된 sum을 사용해야 합니다.
    - 이에 따라 이 부분은 주석 처리된 상태로 남겨졌습니다.
	 --%>
	 
	<p> 계산 결과 : ${param['x'] } + ${param['y'] } = ${ angel:sum(param['x'], param['y']) }</p>
	<%-- 
	    - 이 부분은 EL(Expression Language)을 사용해 Java 메서드를 호출하는 방식입니다.
        - ${param['x']}는 사용자로부터 입력된 x 값을 나타내고, ${param['y']}는 y 값을 나타냅니다.
        - `angel`은 태그 라이브러리를 참조하는 prefix입니다. 여기서는 `tld` 파일에서 정의된 사용자 정의 함수인 `sum`을 호출합니다.
        - ${angel:sum(param['x'], param['y'])}는 `param['x']`와 `param['y']`를 `sum` 메서드에 전달하여 그 결과를 계산합니다.
        - 이 결과는 두 입력 값의 합계를 계산하여 화면에 출력합니다.
        - `sum` 함수는 TLD 파일에 정의된 대로, `com.el.Compute` 클래스의 메서드를 호출합니다.
        - `param['x']`와 `param['y']`는 각각 사용자 입력 폼에서 GET 방식으로 전송된 파라미터로, 이 값을 이용해 계산을 진행합니다.
	 --%>
	<br/>
	
	<p> 계산 결과 : ${param['x'] } - ${param['y'] } = ${ angel:sub(param['x'], param['y']) }</p> <br>
	<p> 계산 결과 : ${param['x'] } * ${param['y'] } = ${ devil:mul(param['x'], param['y']) }</p> <br> 


    <a href="elInput_java.jsp"> 다시 입력하기 </a>


</body>
</html>


