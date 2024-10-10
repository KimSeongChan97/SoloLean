<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/list.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
<div id="header">
				<a href="/spring/"> <img
					src="${pageContext.request.contextPath}/image/Logo.png" alt="Logo"
					alt="logo" width="50" height="50" /> HOME
				</a>
</div>
<table>
    <thead>
        <tr>
            <th><i class="fas fa-user"></i> 이름</th>
            <th><i class="fas fa-id-badge"></i> 아이디</th>
            <th><i class="fas fa-lock"></i> 비밀번호</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="userDTO" items="${map2.list}">
            <tr>
                <td>${userDTO.name}</td>
                <td>
                	<a href="/spring/user/updateForm?id=${userDTO.id}&pg=${map2.pg}">
                		${userDTO.id}
                	</a>
                </td>
                <td>${userDTO.pwd}</td>
            </tr>
        </c:forEach>
    </tbody>
    <tfoot>

    </tfoot>
</table>
		<div id="pagingDiv">
		${map2.userPaging.pagingHTML }
		</div>
<script type="text/javascript">
function userPaging(pg){
	location.href='/spring/user/list?pg=' + pg;
}
</script>		
		
		
</body>
</html>