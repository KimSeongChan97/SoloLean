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
            <!-- **추가 설명**: 클릭 시 메인 페이지로 이동하도록 설정된 이미지 버튼입니다.
                 alt 속성은 이미지 대체 텍스트로, 이미지가 표시되지 않을 때 표시됩니다.
                 width와 height로 이미지 크기를 지정하고, 클릭 가능하도록 cursor: pointer 스타일을 설정했습니다. -->
            MVC를 활용한 미니프로젝트
            <!-- **추가 설명**: 페이지 제목을 나타내며, h1 태그를 사용해 가장 큰 제목으로 설정했습니다. -->
        </h1>
        <hr style="border-color: #483D8B; border-width: 3px;" />
        <!-- **추가 설명**: 페이지 제목 아래에 구분선을 삽입하여 시각적으로 구분하고, 색상과 두께를 설정했습니다. -->
    </div>
    
    <div id="container">
        <jsp:include page="../main/imageboardMenu.jsp" />
        <!-- **추가 설명**: 외부 JSP 파일(imageboardMenu.jsp)을 포함하여 이미지 게시판 메뉴를 동적으로 삽입합니다. 
             이를 통해 코드의 재사용성과 유지보수성을 높일 수 있습니다. -->

        <div type="hidden" id="section" value="${requestScope.pg }">
        	<!-- **추가 설명**: 현재 페이지 번호를 저장하기 위한 hidden 타입의 입력 필드로, 이후 페이징 처리에 사용됩니다. -->
        	
        	<input type="hidden" id="memId" value="${memId }" />
        	<input type="hidden" id="pg" value="${pg }" />
        	<!-- **추가 설명**: memId(회원 ID)와 pg(페이지 번호)를 히든 필드에 저장하여 나중에 처리할 때 활용됩니다. -->

            <form id="deleteForm" method="post" action="/projectMVC/imageboard/imageboardDelete.do">
            <table border="1" frame="hsides" rules="rows">
                <tr>
                    <th width="150">
                    	<input type="checkbox" id="selectAll"> 번호
                    	<!-- **추가 설명**: 첫 번째 열의 헤더로, 체크박스를 삽입하여 번호 열의 항목들을 선택할 수 있게 합니다. -->
                    </th>
                    <th width="300">이미지</th>
                    <th width="150">상품명</th>
                    <th width="150">단가</th>
                    <th width="100">개수</th>
                    <th width="200">합계</th>
                    <!-- **추가 설명**: 테이블의 헤더 행으로, 각 열의 제목을 설정합니다. 이미지, 상품명, 단가, 개수, 합계에 대한 정보를 표시합니다. -->
                </tr>
                
                <c:if test="${requestScope.list != null }">
                    <!-- **추가 설명**: 조건문을 사용하여 리스트가 null이 아닐 때만 데이터가 출력되도록 합니다. -->
                    <c:forEach var="imageboardDTO" items="${list }">
                        <!-- **추가 설명**: list에서 각 imageboardDTO 항목을 반복해서 출력하는 루프입니다. 
                             JSP에서 리스트를 순회하며 각 행을 생성합니다. -->
                        <tr>
                            <td align="center">
                            	<input type="checkbox" class="itemCheckbox" name="selectedSeq" value="${imageboardDTO.seq }">${imageboardDTO.seq }
                            	<!-- **추가 설명**: 각 항목의 체크박스와 함께 시퀀스 번호를 출력하여 선택 기능을 추가합니다. -->
                            </td>
                            
                            <td style="text-align: center; vertical-align: middle;">
                            	<a href="#" style="display: flex; justify-content: center; align-items: center;">
                                <!-- src="가상폴더의 위치" -->
                                <img src="https://kr.object.ncloudstorage.com/bitcamp-9th-bucket-65/storage/${imageboardDTO.image1 }" 
                                alt="${imageboardDTO.imageName }"
                                width="70" height="70"
                                style="cursor: pointer;" /> 
                                <!-- **추가 설명**: 각 이미지 항목을 클릭 가능하게 설정했습니다. 이미지의 크기는 70x70 픽셀로 고정되어 있습니다. -->
                                </a>
                            </td>
                            <td align="center">${imageboardDTO.imageName }</td>
                            <!-- **추가 설명**: 상품명을 출력하며, 가운데 정렬로 설정했습니다. -->
                            <td align="center">
                                <fmt:formatNumber pattern="#,###" value="${imageboardDTO.imagePrice }"/>
                                <!-- **추가 설명**: 가격을 포맷팅하여 1,000 단위로 콤마를 삽입하여 표시합니다. -->
                            </td>
                            <td align="center">
                                <fmt:formatNumber pattern="#,###" value="${imageboardDTO.imageQty }"/>
                                <!-- **추가 설명**: 개수를 포맷팅하여 1,000 단위로 콤마를 삽입하여 표시합니다. -->
                            </td>
                            <td align="center">
                                <fmt:formatNumber pattern="#,###" 
                                value="${imageboardDTO.imagePrice * imageboardDTO.imageQty }"/>
                                <!-- **추가 설명**: 단가와 개수를 곱하여 총 합계를 계산하고, 이를 포맷팅하여 출력합니다. -->
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
            </table>
            
            <div style="width: 700px;">
	            	<div style="float: left; margin-top: 5px;"><input type="submit" value="선택삭제" /> </div>
	            	<!-- **추가 설명**: '선택삭제' 버튼을 추가하여 사용자가 선택한 항목을 삭제할 수 있도록 합니다. 버튼은 왼쪽에 배치됩니다. -->
	            	
	            <div style="float: left; text-align: center; width: 600px; margin-top: 19px;">
	                ${imageboardPaging.pagingHTML }
	                <!-- **추가 설명**: 페이징을 중앙에 배치하고, 상단에 여백을 추가합니다. JSP에서 페이징 처리된 HTML을 삽입합니다. -->
	            </div>
            </div>
            </form> <!-- id="deleteForm" -->
        </div> <!-- id="section" -->
    </div> <!-- id="container" -->
</div> <!-- id="wrap" -->


<script type="text/javascript">
function imageboardPaging(pg){
	location.href = "/projectMVC/imageboard/imageboardList.do?pg=" + pg;
	/* **추가 설명**: 페이징을 클릭했을 때 해당 페이지 번호로 이동하도록 하는 JavaScript 함수입니다. 
	   새로운 페이지를 로드할 때 pg(페이지 번호)를 URL 파라미터로 전달하여 서버에 요청합니다. */
}
</script>

<script src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/boardList.js"></script>
<!-- **추가 설명**: jQuery 라이브러리와 사용자 정의 스크립트(boardList.js)를 불러옵니다. 이를 통해 페이지의 인터랙션을 처리합니다. -->

<script>
document.addEventListener('DOMContentLoaded', function() {
    const selectAllCheckbox = document.getElementById('selectAll');
    const itemCheckboxes = document.querySelectorAll('.itemCheckbox');

    // 전체 선택/해제 기능
    selectAllCheckbox.addEventListener('change', function() {
        itemCheckboxes.forEach(checkbox => {
            checkbox.checked = this.checked;
        });
    });

    // 개별 체크박스 변경 시 전체 선택 체크박스 상태 업데이트
    itemCheckboxes.forEach(checkbox => {
        checkbox.addEventListener('change', function() {
            const allChecked = Array.from(itemCheckboxes).every(cb => cb.checked);
            selectAllCheckbox.checked = allChecked;
        });
    });
});
</script>

</body>
</html>
