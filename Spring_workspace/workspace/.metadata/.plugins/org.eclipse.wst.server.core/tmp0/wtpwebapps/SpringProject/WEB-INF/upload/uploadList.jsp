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

<div class="table-container">
    <table border="1" frame="hsides" rules="rows">
        <tr>
            <th><input type="checkbox" id="selectAll" /></th>
            <th width="100">
                <i class="fa-solid fa-list-ol"></i> 번호
                <input type="button" value="삭제" id="deleteButton" />
            </th>
            <th width="200">
                <i class="fa-solid fa-image"></i> 이미지
            </th>
            <th width="100">
                <i class="fa-solid fa-tag"></i> 상품명
            </th>
        </tr>

        <c:forEach var="userUploadDTO" items="${list}">
            <tr>
                <td align="center"><input type="checkbox" class="selectItem" /></td>
                <td align="center">${userUploadDTO.seq}</td>
                <td align="center">
                    <a href="/spring/user/uploadView?seq=${userUploadDTO.seq}"> 
                        <img src="http://kr.object.ncloudstorage.com/bitcamp-9th-bucket-65/storage/${userUploadDTO.imageFileName}" 
                             alt="${userUploadDTO.imageName}" width="100" height="100">     
                    </a>       
                </td>
                <td>${userUploadDTO.imageName}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script> 
<script type="text/javascript" src="../js/uploadDelete.js"></script>
</body>
</html>
