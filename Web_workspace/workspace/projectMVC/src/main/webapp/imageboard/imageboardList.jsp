<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    </div>
    
    <div id="container">
        <jsp:include page="../main/imageboardMenu.jsp" />
        <div id="section" value="${requestScope.pg }">
            <input type="hidden" id="memId" value="${memId }" />
            <input type="hidden" id="pg" value="${pg }" />
            
            <form id="deleteForm" > <!-- method="post" action="/projectMVC/imageboard/imageboardDelete.do"  -->
                <table border="1" frame="hsides" rules="rows">
                    <tr>
                        <th width="150">
                        	<input type="checkbox" id="selectAll"> 번호
                        </th>
                        <th width="300">이미지</th>
                        <th width="150">상품명</th>
                        <th width="150">단가</th>
                        <th width="100">개수</th>
                        <th width="200">합계</th>
                    </tr>
                    
                    <c:if test="${requestScope.list != null }">
                        <c:forEach var="imageboardDTO" items="${list }">
                            <tr>
                                <td align="center">
                                	<input type="checkbox" class="itemCheckbox" name="selectedSeq" value="${imageboardDTO.seq }">${totalA - ((pg-1) * 3 + status.index)}
                                </td>
                                <td style="text-align: center; vertical-align: middle;">
                                    <img src="${imageboardDTO.image1}?t=${System.currentTimeMillis()}" alt="${imageboardDTO.imageName}" width="70" height="70" style="cursor: pointer;" onclick="showLargeImage('${imageboardDTO.image1}')" /> 
                                </td>
                                <td align="center">${imageboardDTO.imageName }</td>
                                <td align="center">
                                    <fmt:formatNumber pattern="#,###" value="${imageboardDTO.imagePrice }"/>
                                </td>
                                <td align="center">
                                    <fmt:formatNumber pattern="#,###" value="${imageboardDTO.imageQty }"/>
                                </td>
                                <td align="center">
                                    <fmt:formatNumber pattern="#,###" value="${imageboardDTO.imagePrice * imageboardDTO.imageQty }"/>
                                </td>
                                <td align="center">
                                	<form id="updateForm_${imageboardDTO.seq}" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/imageboard/updateFile.do">
                                		<input type="file" name="image1" id="newFile_${imageboardDTO.seq}">
                                		<input type="hidden" name="pg" value="${param.pg}">
                                		<input type="hidden" name="seq" value="${imageboardDTO.seq}">
                                		<input type="hidden" name="imageId" value="${imageboardDTO.imageId}">
                                		<input type="hidden" name="imageName" value="${imageboardDTO.imageName}">
                                		<input type="hidden" name="imagePrice" value="${imageboardDTO.imagePrice}">
                                		<input type="hidden" name="imageQty" value="${imageboardDTO.imageQty}">
                                		<input type="hidden" name="imageContent" value="${imageboardDTO.imageContent}">
                                		<button type="submit">수정</button>
                                		<button type="button" onclick="deleteImage(${imageboardDTO.seq})">삭제</button>
                                	</form>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </table>
                <div style="width: 700px;">
                	<div style="float: left; margin-top: 5px;"><input type="button" value="선택삭제" id="deleteButton" /> </div>
                	<div style="float: left; text-align: center; width: 600px; margin-top: 19px;">
                        ${imageboardPaging.pagingHTML }
                    </div>
                </div>
            </form> 
        </div>
    </div>
</div>

<script src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/boardList.js"></script>

<script>
function updateImage(seq) {
    // 이미지 수정 페이지로 이동
    location.href = '${pageContext.request.contextPath}/imageboard/updateFile.do?seq=' + seq;
}

function deleteImage(seq) {
    if(confirm('정말로 삭제하시겠습니까?')) {
        $.ajax({
            url: '${pageContext.request.contextPath}/imageboard/imageboardDelete.do',
            type: 'POST',
            data: { selectedSeq: seq },
            success: function(response) {
                if(response.success) {
                    alert('이미지가 삭제되었습니다.');
                    location.reload();
                } else {
                    alert('이미지 삭제에 실패했습니다.');
                }
            },
            error: function(xhr, status, error) {
                alert('이미지 삭제에 실패했습니다.');
            }
        });
    }
}

function imageboardPaging(pg) {
    location.href = '${pageContext.request.contextPath}/imageboard/imageboardList.do?pg=' + pg;
}

function showLargeImage(imageUrl) {
    window.open(imageUrl, '_blank', 'width=800,height=600');
}
</script>

</body>
</html>
