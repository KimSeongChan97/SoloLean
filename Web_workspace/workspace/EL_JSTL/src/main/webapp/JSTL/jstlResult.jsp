<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Result</title>
<style type="text/css">

body {
	background-color: #0d0d0d;
	color: #00ffcc;
}

</style>
</head>
<body>
	
	<fmt:requestEncoding value="UTF-8"/>
	<%-- 한글 인코딩 --%>
	<%-- 
		- fmt:requestEncoding 태그는 폼으로 전송된 데이터의 인코딩을 설정합니다.
		- value="UTF-8"로 설정함으로써 한글 데이터가 깨지지 않도록 합니다.
		
		* 추가 설명:
		- JSP 페이지가 UTF-8로 설정되어 있지만, 클라이언트(브라우저)에서 전송된 데이터는 다른 인코딩 방식일 수 있습니다.
		- requestEncoding 태그를 통해 명시적으로 UTF-8 인코딩을 지정해 데이터 손실을 방지합니다.
	--%>
	<ul>
		<li> 이름 : ${param.name } </li> <br/>
		<%-- 
			- param.name은 이전 페이지의 폼에서 입력된 'name' 값(이름)을 출력합니다.
			- ${param.name}은 JSP의 EL(Expression Language)을 사용하여 요청 파라미터 'name'의 값을 가져옵니다.
			
			* 추가 설명:
			- ${param.name}은 클라이언트에서 전송된 데이터를 EL로 쉽게 출력하는 방법입니다.
			- param은 클라이언트로부터 넘어온 데이터(요청 파라미터)를 나타내며, name은 폼 필드의 name 속성입니다.
		--%>
		
		<li> 나이 : ${param.age } 세 
			<%-- 
				- param.age는 폼에서 입력된 'age' 값(나이)을 출력합니다.
				- ${param.age}로 사용자가 입력한 나이를 출력하고, 이후 <c:if>를 사용해 조건에 따라 성인 또는 청소년을 출력합니다.
			--%>
			<c:if test="${param.age >= 19 }">성인</c:if>
			<%-- 
				- param.age 값이 19 이상이면 '성인'을 출력합니다.
				- c:if는 조건문으로, test 속성에 지정된 조건이 true일 때만 실행됩니다.
			--%>
			<c:if test="${param.age < 19 }">청소년</c:if>
			<%-- 
				- param.age 값이 19 미만이면 '청소년'을 출력합니다.
				- 나이에 따라 '성인'과 '청소년'을 구분해서 출력합니다.
			--%>
		</li> <br/>
		
		<li> 색깔 : 
			<c:if test="${param.color == 'red'}">빨강</c:if>
			<c:if test="${param.color == 'green'}">초록</c:if>
			<c:if test="${param.color == 'blue'}">파랑</c:if>
			<c:if test="${param.color eq 'magenta'}">보라</c:if>
			<c:if test="${param.color eq 'cyan'}">하늘</c:if>
			<%-- 
				- c:if 태그를 사용해 color 값에 따라 다른 색깔을 출력합니다.
				- 'param.color'는 폼에서 전송된 색깔 선택값을 가리키며, 각각의 색상에 대해 조건을 검사합니다.
				- '==' 연산자는 값을 비교하며, 'eq'는 EL에서 사용하는 비교 연산자입니다. 두 방식 모두 가능하지만, JSP에서는 'eq'를 권장합니다.
			--%>
				색, 또는 <br>
			
			<c:choose>
				<c:when test="${param.color == 'red'}">빨강</c:when>
				<c:when test="${param.color eq 'green'}">초록</c:when>
				<c:when test="${param.color == 'blue'}">파랑</c:when>
				<c:when test="${param.color eq 'magenta'}">보라</c:when>
				<c:otherwise>하늘</c:otherwise>		
			</c:choose>
			<%-- 
				- c:choose는 if-else 구조와 유사하며, 여러 조건을 검사할 때 사용됩니다.
				- c:when은 각각의 조건을 검사하며, c:otherwise는 모든 조건이 false일 때 실행됩니다.
				- color 값에 따라 해당하는 색을 출력하며, 이 값이 지정되지 않으면 '하늘'을 출력합니다.
			--%>
				색을 선택.					
		</li><br/>
		 
		<li>
		  	취미 : ([''][]) 	
		 	${paramValues['hobby'][0] }
		 	${paramValues['hobby'][1] }
		 	${paramValues['hobby'][2] }
		 	${paramValues['hobby'][3] }
		 	${paramValues['hobby'][4] }
		 	<%-- 
				- paramValues는 폼에서 전송된 여러 값들을 배열로 처리할 때 사용됩니다.
				- 취미는 여러 개의 체크박스를 통해 선택되었을 수 있으며, 그 값들이 배열 형태로 전달됩니다.
				- paramValues['hobby']는 체크박스에서 선택된 값들을 배열로 참조하며, [0], [1] 등의 인덱스를 통해 각 값을 출력합니다.
				- 배열로 출력된 취미 값을 개별적으로 하나씩 출력하는 방식입니다.
			--%>
		 		를 선택. <br/>
		 				 	
		 	취미 : (.hobby)
		 	${paramValues.hobby[0] }		 	
		 	${paramValues.hobby[1] }
		 	${paramValues.hobby[2] }
		 	${paramValues.hobby[3] }
		 	${paramValues.hobby[4] }
		 	<%-- 
				- paramValues.hobby는 EL에서 배열처럼 취미 값들을 처리합니다.
				- 체크박스를 통해 전송된 hobby 값들이 배열로 저장되어 있고, 각각의 인덱스를 통해 값을 출력합니다.
				- 이 방식은 paramValues['hobby']와 동일한 결과를 출력하지만, 점(.) 표기법을 사용하여 접근합니다.
			--%>
		 		를 선택하였다.
		 	<br/>
		 	
		 	취미 : (forEach사용)<br/>
		 	<c:forEach var="data" items="${paramValues.hobby }" >
		 		${data }
		 	</c:forEach>
		 	<%-- 
				- c:forEach는 반복문으로, paramValues.hobby 배열의 각 값을 data 변수에 담아 순차적으로 출력합니다.
				- items 속성은 반복할 데이터를 지정하고, var는 반복 중에 사용할 변수를 정의합니다.
				- 이 방식으로 hobby 값들을 하나씩 순회하며 출력합니다.
				
				* 추가 설명:
				- paramValues.hobby는 여러 개의 값이 배열로 전달되었으므로, 이를 하나씩 출력하려면 반복문을 사용해야 합니다.
				- c:forEach는 JSP에서 가장 많이 사용되는 반복문으로, 배열, 리스트 등의 데이터를 처리할 때 유용합니다.
			--%>
		 		를 선택한다.	
		 </li><br/>	
			
	</ul>

	<a href="jstlInput.jsp">뒤로가기</a>
	<%-- 
		- a 태그는 링크를 생성하며, "jstlInput.jsp"로 이동할 수 있습니다.
		- 사용자가 입력 페이지로 돌아갈 수 있도록 뒤로가기 버튼 역할을 합니다.
	--%>

</body>
</html>
