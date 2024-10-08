<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 결과 페이지</title>
<link rel="stylesheet" href="../css/sungJukresult.css">
</head>
<body>
<div class="result-text">
    <!-- 'result-text'라는 CSS 클래스를 사용한 div 요소로, 성적 정보를 출력하는 영역을 정의함. CSS에서 이 클래스의 스타일을 정의함으로써, 
    이 부분의 글자 크기, 색상, 정렬 등을 쉽게 설정할 수 있음. -->
    *** ${sungJukDTO.name } 성적 ***
    <!-- ${sungJukDTO.name} 는 JSP의 EL(Expression Language)을 사용하여, 
         'sungJukDTO' 객체의 'name' 속성 값을 출력함. 여기서 'sungJukDTO'는 Java에서 전달된 데이터 객체로, 'name'은 학생의 이름을 나타냄. -->
    총점: ${sungJukDTO.tot}
    <!-- ${sungJukDTO.tot}는 EL을 사용해 'sungJukDTO' 객체의 'tot' 속성, 즉 총점을 출력함. -->
    평균: <fmt:formatNumber pattern="#.##" value="${sungJukDTO.avg}" />
    <!-- JSTL의 fmt 태그를 사용하여 'sungJukDTO' 객체의 'avg' 속성 값을 출력함.
         pattern="#.##"는 소수점 두 자리까지만 표시되도록 설정하는 것으로, 평균 점수를 소수점 두 자리까지 깔끔하게 표현함.
         'value' 속성은 format할 실제 값을 지정하는 곳으로, 여기서는 'sungJukDTO.avg' 값이 사용됨. -->
</div>

<form action="input.do" method="post">   
    <input type="submit" value="Back" />
</form>

</body>
</html>