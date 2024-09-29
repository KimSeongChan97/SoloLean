<%-- FilmNote/src/main/webapp/admin/movieList.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<link rel="icon" href="../image/film_favicon.png" type="image/png">
<link rel="stylesheet" href="../css/movieList.css">
<title>영화 목록</title>
</head>
<body>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/adminMenu.jsp" />

<c:if test="${sessionScope.adminDTO.aid == 'admin'}">
<input type="hidden" id="adminId" value="${sessionScope.adminDTO.aid }" />  
<input type="hidden" id="pg" value="${requestScope.pg }" /> 

<div class="card">
	<div id="card-title">영화 삭제 & 검색</div>
	<div id="card-content">
		<button type="submit" id="deleteBtn" class="cardBtn">선택 삭제</button>
		
		<div id="search-div">
			<select class="search-opt">
			    <optgroup label="검색 항목">
			        <option value="movie-code">영화 코드</option>
			        <option value="movie-title" selected="selected">영화 제목</option>
			        <option value="movie-director">영화 감독</option>
			    </optgroup>
			</select>
			<input id="title-box" class="input-box"/>
			<button id="searchBtn" class="cardBtn">검색</button>
		</div>
	</div>
</div>

<table>
	<tr>
		<th width="20%">
			<input type="checkbox" id="all_check" class="check-size" /> 영화 코드
		</th>
		<th width="30%">영화 제목</th>
		<th width="30%">영화 감독</th>
		<th width="20%">영화 관람가</th>
	</tr>
	
	<tbody id="movieTableBody">
		<c:if test="${requestScope.list != null }"> 
			<c:forEach var="movieDTO" items="${list }">
				<tr>
					<td align="center">
						<input type="checkbox" name="mcode" class="board-list-check" value="${movieDTO.mcode}" /> 
						${movieDTO.mcode }
						<input type="hidden" id="mcode" value="${movieDTO.mcode }" />
					</td>      
					<td align="left">
						<a href="#" class="subject-a">${movieDTO.title }</a>
					</td>
					<td align="center">
						${movieDTO.director }
					</td>
					<td align="center">
						<c:if test="${movieDTO.rating == 0}">전체</c:if>
						<c:if test="${movieDTO.rating != 0}">${movieDTO.rating }세</c:if>
					</td>
				</tr> 	    
	 	    </c:forEach>
		</c:if> 
	</tbody>
</table>		       
<div id="list-page-block" class="page-block">${moviePaging.pagingHTML }</div>
<div id="select-page-block" class="page-block" style="display:none;"></div>
</c:if>

<c:if test="${sessionScope.adminDTO.aid != 'admin'}">
    <script>
        alert("관리자로 로그인하세요");
        location.href = "${pageContext.request.contextPath}/admin/adminSignIn.do";
    </script>
</c:if>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
    var context = '${pageContext.request.contextPath}';
</script>
<script type="text/javascript" src="../js/movieList.js"></script>
</body>
</html>