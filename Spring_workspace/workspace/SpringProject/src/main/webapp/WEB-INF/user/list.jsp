<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css">
<!-- list.css 파일을 외부에서 가져와 페이지의 스타일을 지정합니다 -->
<link rel="stylesheet" 
    href="${pageContext.request.contextPath}/css/list.css">
<!-- Font Awesome 라이브러리를 불러와 아이콘을 사용합니다 -->
<link rel="stylesheet" 
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link rel="icon" href="${pageContext.request.contextPath}/static/favicon.ico" type="image/x-icon">
    
</head>
<body>
<div id="header">
    <!-- spring 경로로 이동하는 홈 버튼 -->
    <a href="/spring/"> 
        <!-- 로고 이미지가 화면에 표시됩니다 -->
        <img src="${pageContext.request.contextPath}/image/Logo.png" alt="Logo" width="50" height="50" />
        HOME
    </a>
</div>

<!-- 유저 리스트를 출력하는 테이블 구조입니다 -->
<table>
    <thead>
        <tr>
            <!-- Font Awesome의 아이콘과 함께 테이블의 각 열 제목을 표시합니다 -->
            <th><i class="fas fa-user"></i> 이름</th>
            <th><i class="fas fa-id-badge"></i> 아이디</th>
            <th><i class="fas fa-lock"></i> 비밀번호</th>
        </tr>
    </thead>
    <tbody>
        <!-- JSTL 태그를 사용해 map2.list에 있는 유저 정보를 반복하면서 테이블에 표시합니다 -->
        <!-- var="userDTO"는 현재 반복 중인 요소를 나타냅니다 -->
        <c:forEach var="userDTO" items="${map2.list}">
            <tr>
                <!-- 유저의 이름을 출력합니다 -->
                <td>${userDTO.name}</td>
                <td>
                    <!-- 유저의 ID를 클릭할 수 있는 링크로 만들어, 해당 유저의 수정 폼으로 이동합니다 -->
                    <!-- updateForm으로 이동할 때, ID와 현재 페이지(pg) 정보도 함께 전송합니다 -->
                    <a href="/spring/user/updateForm?id=${userDTO.id}&pg=${map2.pg}">
                        ${userDTO.id} <!-- 유저의 ID를 출력합니다 -->
                    </a>
                </td>
                <!-- 유저의 비밀번호를 출력합니다 (보안상 해시된 값이거나 일부만 출력되는 것이 일반적입니다) -->
                <td>${userDTO.pwd}</td>
            </tr>
        </c:forEach>
    </tbody>
    <tfoot>
        <!-- 테이블 하단에는 추가적으로 넣을 내용이 있을 수 있지만, 현재는 비어 있습니다 -->
    </tfoot>
</table>

<!-- 페이징 처리를 위한 HTML을 출력합니다 -->
<div id="pagingDiv">
    ${map2.userPaging.pagingHTML}
</div>

<!-- 자바스크립트로 페이지 이동을 처리하는 함수입니다 -->
<script type="text/javascript">
    function userPaging(pg){
        // 사용자가 클릭한 페이지 번호에 맞춰서 list 페이지로 이동합니다.
        // 예: /spring/user/list?pg=2 (pg는 페이지 번호를 나타냅니다)
        location.href='/spring/user/list?pg=' + pg;
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
