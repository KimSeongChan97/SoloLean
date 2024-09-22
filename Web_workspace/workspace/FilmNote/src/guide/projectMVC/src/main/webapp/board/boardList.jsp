<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
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
           
            MVC를 활용한 미니프로젝트
            
        </h1>
        <hr style="border-color: #483D8B; border-width: 3px;" />
        <!-- 스타일이 적용된 수평선을 추가합니다. border-color는 선의 색상을 지정하며, border-width는 선의 굵기를 지정합니다. -->
    </div>
    
    <div id="container">
        <jsp:include page="../main/boardMenu.jsp" />
        <!-- 다른 JSP 파일인 boardMenu.jsp 파일을 현재 위치에 포함시킵니다. 이 코드는 주로 메뉴바 같은 공통 요소를 삽입할 때 사용됩니다. -->
        
        <div id="section" class="boardListDiv">
        	
        	<input type="hidden" id="memId" value="${memId }" />
        	<input type="hidden" id="pg" value="${pg }" />	
        	
            <table border="1" frame="hsides" rules="rows">
                <!-- 테이블을 생성합니다. border="1"은 테두리를 설정하며, frame="hsides"는 테이블 상하단의 테두리를 표시하고, rules="rows"는 가로줄만 표시하는 속성입니다. -->
                <tr>
                    <th width="100">글번호</th>
                    <th width="400">제목</th>
                    <th width="150">작성자</th>
                    <th width="150">작성일</th>
                    <th width="100">조회수</th>
                    <!-- 테이블 헤더를 설정합니다. 글번호, 제목, 작성자, 작성일, 조회수라는 칼럼을 생성합니다. -->
                </tr>
                
                <c:if test="${requestScope.list != null }">
                    <!-- requestScope에 있는 list 객체가 null이 아닌지 확인하는 조건문입니다. null이 아니면 게시글 목록이 존재한다는 뜻입니다. -->
                    <c:forEach var="boardDTO" items="${list }">
                        <!-- list 객체에 있는 각각의 항목을 순환하면서 boardDTO 변수에 담습니다. 이 변수는 게시글의 데이터 전송 객체(Data Transfer Object)로, 게시글 정보를 포함하고 있습니다. -->
                        <tr>
                            <td align="center">${boardDTO.seq }</td>
                            <!-- 글번호를 표시합니다. ${boardDTO.seq}는 게시글의 고유 번호를 의미하며, 중앙 정렬을 적용합니다. -->
                            
                            <td><a href="#" class="subjectA">${boardDTO.subject }</a></td>
                            <!-- 게시글 제목을 링크 형태로 표시합니다. ${boardDTO.subject}는 제목을 의미하며, class="subjectA"로 스타일을 지정할 수 있습니다. -->
                            
                            
                            <td align="center">${boardDTO.id }</td>
                            <!-- 작성자의 아이디를 표시합니다. ${boardDTO.id}는 작성자의 ID를 의미하며, 중앙 정렬됩니다. -->
                            <td align="center">
                                <fmt:formatDate pattern="yyyy.MM.dd" value="${boardDTO.logtime }"/>
                                <!-- 작성일을 표시합니다. 작성일은 ${boardDTO.logtime} 속성에서 가져오며, fmt:formatDate 태그를 사용해 'yyyy.MM.dd' 형식으로 날짜를 출력합니다. -->
                            </td>
                            <td align="center">${boardDTO.hit }</td>
                            <!-- 조회수를 표시합니다. ${boardDTO.hit}는 해당 게시글이 조회된 횟수를 의미하며, 중앙 정렬됩니다. -->
                        </tr>
                    </c:forEach>
                </c:if>
                <!-- 게시글 목록이 있을 경우에만 테이블이 생성되도록 if문으로 감싸져 있습니다. -->
            </table>
            
            <div style="text-align: center; width: 700px; margin-top: 15px;">
                ${boardPaging.pagingHTML }
                <!-- 페이지 네비게이션을 출력합니다. ${boardPaging.pagingHTML}은 페이징 처리된 HTML 코드를 출력하는데 사용됩니다. -->
            </div>
        </div> <!-- id="section" -->
    </div> <!-- id="container" -->
</div>    <!-- id="wrap" -->
<script type="text/javascript">
function boardPaging(pg){
	location.href = "/projectMVC/board/boardList.do?pg=" + pg;
}
<%-- JavaScript 함수 boardPaging는 페이지 번호(pg)를 인자로 받아, 특정 페이지로 이동하는 역할을 합니다. 
     "/projectMVC/board/boardList.do?pg=" 뒤에 선택한 페이지 번호를 추가하여 해당 페이지로 리다이렉트합니다. --%>  
</script>

<script src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/boardList.js"></script>

</body>
</html>