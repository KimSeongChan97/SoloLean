<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP를 활용한 구구단 만들기</title>
<style type="text/css">

td {
    padding: 5px; /* 테이블 셀 내부의 패딩을 지정하여, 셀 안의 내용이 여유 공간을 가질 수 있도록 합니다. */
    width: 120px; /* 각 테이블 셀의 너비를 120px로 고정하여, 모든 셀이 동일한 너비를 가지도록 합니다. */
}

</style>
</head>
<body>
    <h1 align="center">JSP를 활용한 구구단 만들기</h1>
    <hr/>
    
    <table>
<% 
    // i는 1부터 9까지 반복하며, 구구단의 곱해지는 수를 나타냅니다.
    // 이 외부 루프는 구구단에서 각 곱해지는 수에 대해 하나의 행을 생성합니다.
    for(int i=1; i<=9; i++) { 
%>
    <tr>
    <% 
        // j는 2부터 9까지 반복하며, 구구단의 각 단(2단부터 9단까지)을 나타냅니다.
        // 내부 루프를 통해 각 단에 대해 하나의 열(td)를 생성하여 해당 단의 결과를 출력합니다.
        for(int j=2; j<=9; j++) { 
    %>
    
        <!-- j와 i를 곱한 결과를 출력 -->
        <!-- j(단)와 i(곱해지는 수)를 곱한 결과를 테이블 셀(td)에 출력합니다. -->
        <td><%= j %> * <%= i %> = <%= j * i %></td>
        <!-- 여기서 <%= %> 표현식은 j와 i의 값을 각각 HTML에 출력하며, 두 값을 곱한 결과(j * i)도 출력합니다. -->

    <% } // for j %>
    <!-- 내부 루프가 종료되면 하나의 행이 완성됩니다. -->
    </tr>
<% } // for i %>
<!-- 외부 루프가 종료되면 모든 구구단 결과가 테이블에 출력됩니다. -->
        
</table>

</body>
</html>
