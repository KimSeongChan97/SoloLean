<%-- FilmNote/src/main/webapp/index.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="./image/film_favicon.png" type="image/png">
<link rel="stylesheet" href="./css/index.css">
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css"> --%>
<title>FilmNote</title>
<style type="text/css">

/** 글삭제 & 검색 */ 
/** 검색과 관련된 레이아웃을 설정하는 부분입니다. 각 요소는 영화 검색 UI와 관련된 내용을 나타냅니다. **/
div.card {
	margin: 40px 60px;
	/** 카드 컨테이너는 상하로 40px, 좌우로 60px의 여백을 줍니다. **/
}

.card #card-title {
	font-size: 15px;
	/** 타이틀의 글자 크기를 15px로 설정합니다. **/
	margin-bottom: 8px;
	/** 타이틀과 아래 내용 사이에 8px의 여백을 추가합니다. **/
}

.card #card-content {
	height: 50px;
	/** 검색 영역의 높이를 50px로 고정합니다. **/
	border-top: 1px solid #5A5A5A;
	border-bottom : 1px solid #5A5A5A;
	/** 상단과 하단에 1px 두께의 회색(#5A5A5A) 테두리를 추가합니다. **/
	display: flex;
	/** Flexbox를 이용해 내부 요소를 정렬합니다. **/
	justify-content: center;
	/** 내부 요소들이 수평 가운데로 정렬되도록 설정합니다. **/
	align-items: center;
	/** 내부 요소들이 수직 가운데로 정렬되도록 설정합니다. **/
	padding: 0 20px;
    gap: 10px;
	/** 내부 요소 간 간격을 10px로 설정합니다. **/
}

#card-content .search-opt, #card-content .input-box {
    height: 30px;
    /** 검색 옵션과 입력 박스의 높이를 30px로 설정합니다. **/
    border: 1px solid #5A5A5A;
    /** 테두리 색상을 회색(#5A5A5A)으로 설정합니다. **/
    border-radius: 3px;
    /** 모서리를 3px 둥글게 처리합니다. **/
    font-size: 15px;
    /** 글자 크기를 15px로 설정합니다. **/
    padding: 0 5px;
    /** 텍스트와 테두리 사이의 여백을 좌우로 5px 줍니다. **/
}

#card-content .search-opt {
    letter-spacing: 3px;
    /** 글자 간격을 3px로 설정합니다. **/
    width: 180px;
    /** 검색 옵션 선택 박스의 너비를 180px로 설정합니다. **/
}

#card-content .input-box {
    width: 550px;
    /** 검색 입력 창의 너비를 550px로 설정합니다. **/
}

#searchBtn {
	padding: 0;
	/** 버튼의 기본 패딩을 제거합니다. **/
	display: flex;
    align-items: center;
    justify-content: center;
	/** 버튼 내부의 내용이 가운데에 위치하도록 설정합니다. **/
	width: 150px;
    height: 30px;
    /** 버튼의 크기를 150x30px로 설정합니다. **/
    line-height: 27px;
    /** 텍스트가 버튼 높이에 맞게 수직으로 가운데 정렬되도록 설정합니다. **/
    border-radius: 3px;
    /** 버튼의 모서리를 3px 둥글게 처리합니다. **/
    font-style: normal;
    font-weight: 400;
    font-size: 16px;
    text-align: center;
    background: #457ABF;
	/** 배경 색상을 파란색(#457ABF)으로 설정합니다. **/
	color: white;
	/** 텍스트 색상을 흰색으로 설정합니다. **/
	border: 1px solid #457ABF;	
	/** 테두리 색상도 배경색과 동일하게 설정합니다. **/
}

#searchBtn:hover {
    transition: background-color 0.3s ease; 
	/** 배경색 변화에 0.3초의 전환 효과를 줍니다. **/
	background-color: #3d3d3d;
	/** 마우스를 올렸을 때 배경 색상을 어두운 회색으로 변경합니다. **/
	color: #FFFFFF;
	/** 텍스트 색상을 흰색으로 설정합니다. **/
	border: 1px solid #3d3d3d;	
	/** 테두리 색상도 동일하게 변경합니다. **/
	cursor: pointer;
	/** 커서를 포인터로 변경하여 클릭 가능함을 나타냅니다. **/
}

table {
	border-collapse: collapse;
	/** 테이블의 테두리를 합쳐서 중복되지 않도록 설정합니다. **/
	margin: 20px auto;
	/** 테이블에 상하로 20px의 여백을 주고, 가운데 정렬합니다. **/
}

td {
   width: 250px;
   /** 각 셀의 너비를 250px로 설정합니다. **/
   padding: 10px;
   /** 셀 내부에 10px의 여백을 줍니다. **/
}

.hover-info {
    position: relative;
    display: block;
    /** hover-info 요소는 블록 레벨 요소로 처리됩니다. **/
}

.hover-info::after {
    content: '';
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.6); 
    /** 마우스를 올리면 반투명한 검은색 배경이 나타납니다. **/
    opacity: 0; 
    /** 기본 상태에서는 투명하게 설정합니다. **/
    transition: opacity 0.3s ease-in-out;
    /** 마우스 오버 시 투명도 변화를 부드럽게 처리합니다. **/
    z-index: 1;
	/** 배경 이미지보다 위에 나타나도록 설정합니다. **/
}

.hover-info:hover::after {
    opacity: 1; 
    /** 마우스를 올렸을 때 반투명 배경을 표시합니다. **/
}

.hover-info img {
    display: block;
    width: 100%; 
    /** 이미지의 크기를 hover-info 컨테이너의 너비에 맞춥니다. **/
}

.over {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
	/** 텍스트를 중앙에 위치시키기 위해 x, y축 모두 50%로 이동 후 보정합니다. **/
    color: white;
    z-index: 2;
	/** 반투명 배경 위에 나타나도록 설정합니다. **/
    text-align: center;
    display: none; 
    /** 기본적으로는 텍스트를 보이지 않게 설정합니다. **/
    width: 80%;
}

.hover-info:hover .over {
    display: block; 
    /** 마우스를 올렸을 때만 텍스트를 표시합니다. **/
}

#footer {
   margin: 20px 50px;
   /** 하단의 푸터 영역에 상하 20px, 좌우 50px의 여백을 줍니다. **/
}

#github {
   width: 180px;
   display: flex;
   justify-content: start;
   align-items: center;
   gap: 10px;
   /** GitHub 정보는 좌측에 정렬하고 아이콘과 텍스트 사이 간격을 10px로 설정합니다. **/
}

#footer-a {
   display: block;
   width: 180px;
   /** GitHub 링크는 블록 레벨 요소로 처리하며, 너비를 180px로 설정합니다. **/
}
#footer-p {
   margin-bottom: 10px;
   /** 푸터 텍스트 아래에 10px의 여백을 추가합니다. **/
}

#gitlink {
   line-height: 35px;
   height: 35px;
   /** GitHub 링크의 텍스트 높이와 줄 높이를 동일하게 맞춰서 수직 가운데 정렬합니다. **/
}
</style>
</head>

<body>
<jsp:include page="./common/header.jsp" />
<%-- header.jsp 파일을 포함하여 페이지의 상단 영역을 구성합니다. header에는 로고, 네비게이션 바 등이 있을 수 있습니다. --%>
<div class="card">
	<div id="card-title">영화 검색</div>
	<%-- "영화 검색"이라는 타이틀을 표시합니다. --%>
	<div id="card-content">
		<select class="search-opt">
		    <optgroup label="검색 항목">
		        <option value="movie-title" selected="selected">영화 제목</option>
		        <option value="movie-director">영화 감독</option>
		    </optgroup>
		</select>
		<%-- 검색 조건으로 영화 제목 또는 영화 감독을 선택할 수 있는 드롭다운 메뉴입니다. 기본값은 영화 제목으로 설정되어 있습니다. --%>
		<input id="title-box" class="input-box"/>
		<%-- 검색어를 입력하는 텍스트 박스입니다. 사용자가 검색할 영화 제목 또는 감독을 여기에 입력합니다. --%>
		<button id="searchBtn" class="cardBtn">검색</button>
		<%-- 사용자가 검색 버튼을 눌러 검색을 실행할 수 있습니다. --%>
	</div>
</div>

<div id="poster">
	<table>
		<tbody id="movieTableBody">
	 		<c:if test="${movieDTOList.size() != 0}">
				<%-- 영화 목록이 존재할 때만 테이블을 출력합니다. movieDTOList가 비어 있지 않은 경우에만 실행됩니다. --%>
				<c:forEach var="row" begin="0" end="${movieDTOList.size()}" step="${movieInRowCount}">
		    		<tr>
		        	<c:forEach var="i" begin="${row}" end="${row + movieInRowCount - 1}" step="1">
		            	<c:if test="${i < movieDTOList.size()}">
			                <td>
			                    <a href="${pageContext.request.contextPath}/review/reviewView.do?mcode=${movieDTOList[i].getMcode()}&pg=1">
	                           <div class="hover-info">
	                              <%-- 영화 포스터 이미지가 표시됩니다. 포스터는 영화에 대한 시각적 정보를 제공하며, hover 시 더 많은 정보를 표시합니다. --%>

	                              <img width="230px" height="330px" src="${movieDTOList[i].getPoster() }" alt="" class="thumb"/>
	                              
	                              <!-- 오버시 나오는 정보 -->
	                              <div class="over">
	                                 <span class="title">${movieDTOList[i].getTitle() }</span><br>
	                                 <span class="open_date">개봉일 : ${movieDTOList[i].getRelease_date()}</span><br>
	                                 <span class="director">감독 : ${movieDTOList[i].getDirector()}</span><br>
	                                 <span class="score">평점 : <fmt:formatNumber pattern="0.00점" value="${movieDTOList[i].getScore()}"/></span><br>
	                              <!-- //오버시 나오는 정보 -->
	                              </div>
	                           </div>
	                        </a>
			                </td>
			            </c:if>
		        	</c:forEach>
	    			</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
</div>

<div id="footer">
	<p id="footer-p">
		Film Note / 서울 강남구 강남대로94길 20 삼오빌딩 6층 602호 / 대표전화 : 0507-1414-9601 / 팀장 : 박채연
	</p>
	<a id="footer-a" href="https://github.com/bitcamp-aiaas-9/FilmNote" target="_blank">
		<div id="github">
			<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 496 512" width="32" height="35">
	  			<path d="M165.9 397.4c0 2-2.3 3.6-5.2 3.6-3.3 .3-5.6-1.3-5.6-3.6 0-2 2.3-3.6 5.2-3.6 3-.3 5.6 1.3 5.6 3.6zm-31.1-4.5c-.7 2 1.3 4.3 4.3 4.9 2.6 1 5.6 0 6.2-2s-1.3-4.3-4.3-5.2c-2.6-.7-5.5 .3-6.2 2.3zm44.2-1.7c-2.9 .7-4.9 2.6-4.6 4.9 .3 2 2.9 3.3 5.9 2.6 2.9-.7 4.9-2.6 4.6-4.6-.3-1.9-3-3.2-5.9-2.9zM244.8 8C106.1 8 0 113.3 0 252c0 110.9 69.8 205.8 169.5 239.2 12.8 2.3 17.3-5.6 17.3-12.1 0-6.2-.3-40.4-.3-61.4 0 0-70 15-84.7-29.8 0 0-11.4-29.1-27.8-36.6 0 0-22.9-15.7 1.6-15.4 0 0 24.9 2 38.6 25.8 21.9 38.6 58.6 27.5 72.9 20.9 2.3-16 8.8-27.1 16-33.7-55.9-6.2-112.3-14.3-112.3-110.5 0-27.5 7.6-41.3 23.6-58.9-2.6-6.5-11.1-33.3 2.6-67.9 20.9-6.5 69 27 69 27 20-5.6 41.5-8.5 62.8-8.5s42.8 2.9 62.8 8.5c0 0 48.1-33.6 69-27 13.7 34.7 5.2 61.4 2.6 67.9 16 17.7 25.8 31.5 25.8 58.9 0 96.5-58.9 104.2-114.8 110.5 9.2 7.9 17 22.9 17 46.4 0 33.7-.3 75.4-.3 83.6 0 6.5 4.6 14.4 17.3 12.1C428.2 457.8 496 362.9 496 252 496 113.3 383.5 8 244.8 8zM97.2 352.9c-1.3 1-1 3.3 .7 5.2 1.6 1.6 3.9 2.3 5.2 1 1.3-1 1-3.3-.7-5.2-1.6-1.6-3.9-2.3-5.2-1zm-10.8-8.1c-.7 1.3 .3 2.9 2.3 3.9 1.6 1 3.6 .7 4.3-.7 .7-1.3-.3-2.9-2.3-3.9-2-.6-3.6-.3-4.3 .7zm32.4 35.6c-1.6 1.3-1 4.3 1.3 6.2 2.3 2.3 5.2 2.6 6.5 1 1.3-1.3 .7-4.3-1.3-6.2-2.2-2.3-5.2-2.6-6.5-1zm-11.4-14.7c-1.6 1-1.6 3.6 0 5.9 1.6 2.3 4.3 3.3 5.6 2.3 1.6-1.3 1.6-3.9 0-6.2-1.4-2.3-4-3.3-5.6-2z"/>
			</svg>
			<span id="gitlink">Github : FilmNote</span>
		</div>
	</a>
</div> 

<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js" target="_blank"></script>
<script>
    var context = '${pageContext.request.contextPath}';
	<%-- context 변수를 JSP에서 사용할 수 있게 선언합니다. 주로 경로를 설정하는 데 사용됩니다. --%>
</script>
<script type="text/javascript" src="./js/index.js"></script>

</body>
</html>
