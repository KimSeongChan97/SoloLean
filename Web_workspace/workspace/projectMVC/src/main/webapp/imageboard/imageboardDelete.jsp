<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 삭제</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/boardlist.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/index.css">
</head>
<body>
<div id="wrap">
    <div id="header">
        <h1>
            <img alt="사과" src="${ pageContext.request.contextPath }/image/apple.png" 
                 width="50" height="50"
                 onclick="location.href='${ pageContext.request.contextPath }/index.do'"
                 style="cursor: pointer;">
            이미지 삭제
        </h1>
        <hr style="border-color: #483D8B; border-width: 3px;" />
    </div>
    
    <div id="container">
        <h2>선택한 이미지를 삭제하시겠습니까?</h2>
        
        <form action="${ pageContext.request.contextPath }/imageboard/imageboardDelete.do" method="post">
            <!-- 선택된 이미지 시퀀스 -->
            <input type="hidden" name="selectedSeq" value="${param.selectedSeq}">
            
            <p>선택된 이미지: ${param.selectedSeq} 번</p>

            <div>
                <input type="submit" value="삭제 확인">
                <input type="button" value="취소" onclick="location.href='${ pageContext.request.contextPath }/imageboard/imageboardList.do?pg=1'">
            </div>
        </form>
    </div>
</div>

</body>
</html>
