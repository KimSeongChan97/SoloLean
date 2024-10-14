<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업로드 이미지 리스트</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/uploadList.css">
</head>
<body>

<div class="home-container">
    <a href="/spring/"><i class="fa-solid fa-house"></i> HOME</a>
</div>

<!-- 테이블 컨테이너 -->
<div class="table-container">
    <!-- 테이블을 정의하는 부분입니다.
         테이블은 border 속성을 사용하여 경계선을 설정하였고, frame="hsides"는 테이블의 수평 경계선을 나타냅니다.
         rules="rows"는 테이블 행 사이에만 경계선을 추가하도록 설정합니다. -->
    <table border="1" frame="hsides" rules="rows">
        <tr>
            <!-- 테이블의 첫 번째 행으로, 각 열의 제목을 나타냅니다. -->
            <th width="100">번호</th>
            <th width="200">이미지</th>
            <th width="100">상품명</th>
        </tr>

        <!-- JSP에서 c:forEach 태그를 사용하여 서버에서 전달된 리스트 데이터를 반복 처리합니다.
             var="userUploadDTO"는 각 반복에서 사용할 변수 이름이고, 
             items="${list}"는 서버에서 전달된 'list' 객체로부터 데이터를 가져옵니다.
             이때 list는 Controller에서 ModelAndView를 통해 전달된 데이터입니다. -->
        <c:forEach var="userUploadDTO" items="${list}">
            <tr>
                <!-- seq 필드를 통해 업로드된 파일의 고유 번호를 표시합니다. 
                     align="center"로 데이터를 중앙 정렬합니다. -->
                <td align="center">${userUploadDTO.seq}</td>
                <td align="center">
				<%-- <img src="http://localhost:8080/spring/storage/${userUploadDTO.imageOriginalFileName}" 
                         alt="${userUploadDTO.imageName}" width="50" height="50"> --%>
                
                <!-- Object Stroage -->         
                    <img src="http://kr.object.ncloudstorage.com/bitcamp-9th-bucket-65/storage/${userUploadDTO.imageFileName}" 
                         alt="${userUploadDTO.imageName}" width="50" height="50">     
                         
                </td>
                <!-- 이미지 이름을 출력하는 부분입니다. -->
                <td>${userUploadDTO.imageName}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>