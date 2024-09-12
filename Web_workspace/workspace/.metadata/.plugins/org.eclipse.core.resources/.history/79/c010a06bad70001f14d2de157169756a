<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 테스트 페이지1</title>
</head>
<body>
	
	<!-- 
		표 형식으로 EL(Expression Language)의 다양한 표현식과 그 결과를 출력하는 페이지.
		EL은 JSP에서 자바 코드 없이 표현식으로 간단히 데이터를 처리하는 방식.
		이 표는 EL 표현식과 그 결과 값을 비교해서 보여주기 위한 예시임.
	-->
	<table border="1" width="50%" >
		<tr>
			<th width="50%">표현식</th> <!-- EL 표현식 자체를 보여주는 열 -->
			<th>값</th> <!-- EL 표현식의 결과값을 보여주는 열 -->
		</tr>
		
		<!-- 아래부터 EL을 사용하여 연산 및 비교의 결과를 출력하는 부분 -->
		<tr align="center">
			<td>\${ 25+3 }</td> <!-- 덧셈 연산: 25 + 3 = 28 -->
			<td>${ 25+3 }</td> <!-- EL을 사용하여 25+3의 값을 실제로 출력. 결과는 28 -->
		</tr>
		<tr align="center">
			<td>\${ 25 / 3 }</td> <!-- 나눗셈 연산: 25 / 3 = 8.3333... -->
			<td>${ 25 / 3 }</td> <!-- EL을 사용하여 25 / 3의 결과를 출력. 결과는 8.3333... -->
		</tr>
		<tr align="center">
			<td>\${ 25 div 3 }</td> <!-- "div"는 나눗셈을 나타내는 EL 연산자. 같은 연산: 25 / 3 -->
			<td>${ 25 div 3 }</td> <!-- "div"를 사용한 나눗셈 결과를 출력. 결과는 8 -->
		</tr>
		<tr align="center">
			<td>\${ 25 % 3 }</td> <!-- 나머지 연산: 25 % 3 = 1 -->
			<td>${ 25 % 3 }</td> <!-- EL을 사용하여 25 % 3의 나머지를 출력. 결과는 1 -->
		</tr>
		<tr align="center">
			<td>\${ 25 mod 3 }</td> <!-- "mod"는 나머지 연산을 나타내는 EL 연산자. 같은 연산: 25 % 3 -->
			<td>${ 25 mod 3 }</td> <!-- "mod"를 사용한 나머지 연산 결과를 출력. 결과는 1 -->
		</tr>
		<tr align="center">
			<td>\${ 25 < 3 }</td> <!-- 비교 연산: 25가 3보다 작은지 비교. 결과는 false -->
			<td>${ 25 < 3 }</td> <!-- EL을 사용하여 25 < 3의 결과를 출력. 결과는 false -->
		</tr>
		
		<!-- 
			EL에서는 비교 연산을 할 때 다양한 연산자를 사용할 수 있음.
			기본적으로 >, <, >=, <=, ==, != 같은 연산자 외에도,
			'gt', 'lt', 'ge', 'le', 'eq', 'ne'와 같은 키워드도 사용 가능.
		-->
		<tr align="center">
			<td>\${ 25 != 3 }</td> <!-- 25가 3과 다른지 비교. 결과는 true -->
			<td>${ 25 != 3 }</td> <!-- EL을 사용하여 25 != 3의 결과를 출력. 결과는 true -->
		</tr>
		<tr align="center">
			<td>\${ 25 ne 3 }</td> <!-- "ne"는 "!="와 동일한 의미로, 25가 3과 다른지 비교. 결과는 true -->
			<td>${ 25 ne 3 }</td> <!-- EL을 사용하여 25 ne 3의 결과를 출력. 결과는 true -->
		</tr>
		
		<!-- 
			EL을 사용하여 request 헤더에서 특정 값을 가져오는 방식.
			header는 HTTP 요청의 헤더 값을 나타내며, [] 안에 헤더 이름을 넣어서 접근 가능.
			"host"는 요청이 온 호스트 정보를 나타냄.
		-->
		<tr align="center">
			<td>\${ header['host'] }</td> <!-- header 객체에서 'host' 값을 가져옴 -->
			<td>${ header['host'] }</td> <!-- EL을 사용하여 요청 헤더의 'host' 값 출력 -->
		</tr>
		<tr align="center">
			<td>\${ header.host }</td> <!-- 위와 동일하지만, 점(.)을 사용하여 접근 -->
			<td>${ header.host }</td> <!-- EL을 사용하여 요청 헤더의 'host' 값 출력 -->
		</tr>
		
		<tr align="center">
			<td></td> 
			<td></td> 
		</tr>
		<tr align="center">
			<td></td>
			<td></td>
		</tr>
		
	</table>
</body>
</html>


<%-- 

EL / JSTL -> <% %> <%= %> 사용하면 안된다.
		  -> 자바와 웹 분리	

--%>

