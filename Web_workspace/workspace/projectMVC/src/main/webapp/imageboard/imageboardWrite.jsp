<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <script type="text/javascript">
        window.onload=function(){
            alert("이미지 등록 완료");
            location.href="/projectMVC/imageboard/imageboardList.do?pg=1";
        }
     </script> 
</body>
</html>