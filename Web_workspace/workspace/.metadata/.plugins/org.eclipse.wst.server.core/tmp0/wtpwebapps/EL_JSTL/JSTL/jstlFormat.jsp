<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- 
    JSTL에서 `fmt` 태그는 주로 숫자와 날짜 등의 형식을 지정하는 데 사용됩니다.
    이 코드는 `fmt:formatNumber`와 `fmt:formatDate` 태그를 사용하여 숫자 및 날짜 형식을 지정하는 방법을 보여줍니다.
    JSTL의 format 태그는 출력 시 숫자와 날짜를 원하는 형식으로 변환할 수 있어, 데이터를 직관적으로 표현할 수 있게 해줍니다.
 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Format 에 대하여</title>
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

<!-- 숫자 형식 지정 -->
<fmt:formatNumber type="number" value="123456789" /><br>
<!-- 
    기본 숫자 형식으로 출력합니다. 천 단위 구분 기호가 포함됩니다.
    출력 결과: 123,456,789
    type 속성의 값이 "number"이면 숫자를 기본적으로 천 단위 구분 기호를 포함하여 출력합니다.
 -->

<fmt:formatNumber type="number" value="123456789.88" /><br>
<!-- 
    소수점이 포함된 숫자를 기본 형식으로 출력합니다. 소수점 이하 값도 표시됩니다.
    출력 결과: 123,456,789.88
    숫자에 소수점이 있으면 소수점 이하 부분도 포함하여 출력됩니다.
 -->

<fmt:formatNumber type="number" value="123456789.88" maxFractionDigits="1" /><br>
<!-- 
    소수점 이하 자릿수를 최대 1자리까지만 표시하도록 설정합니다.
    출력 결과: 123,456,789.9 (소수점 이하 자리는 반올림됩니다.)
    maxFractionDigits 속성은 소수점 이하 표시할 최대 자릿수를 설정합니다. 여기서는 소수점 이하 1자리만 표시되며, 반올림 처리됩니다.
 -->
<br/>

<!-- 숫자 형식 커스터마이징 -->
<fmt:formatNumber type="number" value="123456.78" pattern="#,###"/><br>
<!-- 
    패턴을 통해 천 단위 구분 기호만 표시하고, 소수점 이하 자리는 출력하지 않도록 설정합니다.
    출력 결과: 123,457 (소수점 이하는 반올림됩니다.)
    pattern 속성으로 원하는 숫자 형식을 지정할 수 있습니다. 여기서는 소수점 없이 천 단위만 표시되도록 설정했습니다.
 -->

<fmt:formatNumber type="number" value="123456.789" pattern=".##" /><br>
<!-- 
    소수점 이하 두 자리만 표시하고 정수 부분은 생략합니다. 
    출력 결과: .79
    정수 부분을 생략하고 소수점만 표시하고 싶을 때는 패턴에서 정수 부분을 제외하고 ".##"처럼 작성할 수 있습니다.
 -->

<fmt:formatNumber type="number" value="123456.789" pattern="#,###.##" /><br>
<!-- 
    천 단위 구분 기호와 함께 소수점 이하 두 자리를 표시합니다.
    출력 결과: 123,456.79
    패턴에 따라 천 단위 구분 기호와 소수점 이하 두 자리를 모두 표시합니다.
 -->
<br/>

<!-- 0 값 처리 -->
<fmt:formatNumber type="number" value="0000.00" pattern="#,###.##" /><br>
<!-- 
    0값은 특별히 처리하지 않으며, 빈 값으로 출력됩니다.
    출력 결과: (빈 값)
    패턴에 의해 0은 표시되지 않습니다. 만약 0을 표시하고 싶다면 패턴에서 0을 강제로 표시해야 합니다.
 -->

<fmt:formatNumber type="number" value="0000.00" pattern="0,000.00" /><br> 
<!-- 강제로 0을 표시 -->
<!-- 
    패턴에서 0을 명시하면 0도 강제로 표시됩니다.
    출력 결과: 0,000.00
    "0"을 사용하면 숫자가 0일 때도 해당 위치에 0을 표시합니다.
 -->

<fmt:formatNumber type="number" value="12.3" pattern="000.00" /><br>
<!-- 
    자릿수를 맞추기 위해 0을 추가해 숫자를 출력합니다.
    출력 결과: 012.30
    패턴에서 0을 사용하면 자릿수를 맞추기 위해 숫자 앞에 0을 추가하여 출력할 수 있습니다.
 -->
<br/>

<!-- 날짜 형식 -->

<c:set var="now" value="<%=new java.util.Date()%>"/>
<!-- 
    현재 날짜와 시간을 자바 코드를 통해 생성하고, 이 값을 'now' 변수에 저장합니다.
    c:set 태그는 자바 코드와 EL을 연결할 때 자주 사용됩니다.
    여기서는 자바의 `new Date()`로 현재 시간을 생성한 후, JSP에서 사용할 수 있도록 `now` 변수에 저장합니다.
 -->

<c:out value="${now}"/><br>
<!-- 
    EL을 사용하여 'now'에 저장된 현재 날짜와 시간을 출력합니다.
    자바의 Date 객체의 기본 형식으로 출력됩니다.
    출력 결과 예시: Thu Sep 12 12:34:56 KST 2024 (Date 객체의 기본 형식)
 -->

<!-- fmt:formatDate 태그를 사용한 날짜 형식 지정 -->
date : <fmt:formatDate value="${now }" type="date"/><br>
<!-- 
    날짜만 출력합니다.
    출력 결과 예시: 2024. 9. 12.
    type="date"로 설정하면 날짜만 출력됩니다.
 -->

time : <fmt:formatDate value="${now }" type="time"/><br>
<!-- 
    시간만 출력합니다.
    출력 결과 예시: 12:34:56
    type="time"으로 설정하면 시간만 출력됩니다.
 -->

both : <fmt:formatDate value="${now }" type="both"/><br>
<!-- 
    날짜와 시간 모두 출력합니다.
    출력 결과 예시: 2024. 9. 12. 오후 12:34:56
    type="both"로 설정하면 날짜와 시간 모두 출력됩니다.
 -->
<br><br>

<!-- 날짜 형식 패턴 지정 -->
<fmt:formatDate value="${now }" pattern="yyyy-MM-dd hh:mm" type="both" /><br>
<!-- 
    'yyyy-MM-dd hh:mm' 패턴에 따라 날짜와 시간을 지정된 형식으로 출력합니다.
    출력 결과 예시: 2024-09-12 12:34
    pattern 속성을 사용하면 원하는 날짜 및 시간 형식으로 출력할 수 있습니다.
 -->

<fmt:formatDate value="${now }" pattern="yyyy-MM-dd hh:mm" type="date" /><br>
<!-- 
    같은 패턴을 사용하되, type을 'date'로 설정하여 시간 없이 날짜만 출력합니다.
    출력 결과 예시: 2024-09-12
    pattern 속성은 동일하지만, type이 "date"이므로 시간은 출력되지 않습니다.
 -->

<fmt:formatDate value="${now }" pattern="yy-MM-dd E요일 a" type="date" /><br>
<!-- 
    'E요일'과 'a' 패턴을 사용하여 요일과 오전/오후를 표시합니다.
    출력 결과 예시: 24-09-12 목요일 오후
    'E'는 요일, 'a'는 오전/오후를 의미합니다. 이 패턴을 사용해 요일과 오전/오후를 함께 출력할 수 있습니다.
 -->

<fmt:formatDate value="${now }" pattern="HH:mm:ss" type="time" /><br>
<!-- 
    24시간 형식으로 시간만 출력합니다.
    출력 결과 예시: 12:34:56
    24시간 형식은 'HH'를 사용하여 설정할 수 있습니다. 여기서는 시간을 초까지 출력합니다.
 -->

</body>
</html>
