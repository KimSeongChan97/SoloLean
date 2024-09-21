<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
/* .mainnav 클래스 스타일 정의 */
.mainnav{
    background-color: #483D8B;
    /* .mainnav 클래스를 적용한 요소의 배경색을 설정합니다. 이 색상은 짙은 파란색(#483D8B)입니다. */
    list-style: none;
    /* 리스트 아이템의 기본 스타일(점, 숫자 등)을 제거합니다. 이는 ul 요소의 기본 리스트 아이콘을 없애기 위한 설정입니다. */
    color: #ffffff;
    /* 텍스트 색상을 흰색으로 설정합니다. 이 설정은 ul 안의 텍스트 색상에 적용됩니다. */
}

/* .mainnav 요소 뒤에 가상 요소 생성 */
.mainnav:after{ 
    content: '';
    /* .mainnav 요소 뒤에 빈 콘텐츠를 추가합니다. 이 콘텐츠는 화면에 표시되지 않으며, 순전히 레이아웃을 위해 사용됩니다. 
       가상 요소를 이용해 부모 요소의 높이를 자식 요소에 맞춰 조정할 수 있도록 합니다. */
    display: block;
    /* 이 가상 요소를 블록 요소로 만듭니다. 블록 요소는 자동으로 줄 바꿈되고, 부모의 너비를 모두 차지합니다. */
    clear: both;
    /* float 속성을 적용한 요소들이 .mainnav 내부에 있을 때, 이 요소가 흐름을 정리(clear)하게 만들어줍니다. 
       이를 통해 부모 요소가 자식 요소들을 완전히 감싸게 하고, 레이아웃이 붕괴되는 것을 방지합니다. */
}

/* .mainnav 내 li 요소 스타일 설정 */
.mainnav li{
    display: inline-block;
    /* 리스트 항목을 가로로 배치합니다. 즉, li 요소들이 한 줄로 정렬됩니다. 
       기본적으로 li 요소는 블록 요소이므로 세로로 나열되지만, inline-block을 사용하여 가로로 배치됩니다. */
    justify-content: space-between;
    /* flexbox 레이아웃에서 요소 간의 간격을 균등하게 분배하는 속성이지만, 이 경우 inline-block에서는 적용되지 않음. 
       이 코드는 현재 상황에서는 불필요한 속성입니다. flexbox가 사용되지 않기 때문입니다. */
}

/* .mainnav li a 태그의 기본 스타일 설정 */
.mainnav li a {
    display: block;
    /* 링크 요소를 블록 요소로 만듭니다. 이를 통해 클릭 가능한 영역이 요소 전체로 확장됩니다. 
       a 요소가 li 요소의 전체 크기를 차지하도록 설정함으로써 클릭 가능한 영역이 넓어집니다. */
    padding: 0 13px; 
    /* 링크의 내부 여백을 위아래는 0, 좌우는 13px로 설정합니다. 
       링크 텍스트가 양쪽으로 적당한 여백을 가지고 배치되게 만듭니다. */
    background-color: #483D8B;
    /* 링크의 배경색을 .mainnav와 동일한 짙은 파란색(#483D8B)으로 설정합니다. */
    color: #ffffff;
    /* 링크 텍스트의 색상을 흰색(#ffffff)으로 설정합니다. */
    font: bold 16px/40px 'Nanum Gothic', sans-serif; 
    /* 폰트 설정입니다. 텍스트의 굵기는 bold, 글자 크기는 16px, 줄 간격(line-height)은 40px로 설정합니다. 
       글꼴은 'Nanum Gothic'을 사용하고, 만약 'Nanum Gothic'이 없을 경우에는 기본 sans-serif 글꼴을 사용합니다. */
    text-transform: uppercase;
    /* 텍스트를 모두 대문자로 변환합니다. 이를 통해 링크 텍스트가 일관된 대문자 스타일을 유지합니다. */
    text-decoration: none;
    /* 링크의 기본 밑줄을 제거합니다. 이를 통해 텍스트가 밑줄 없이 깔끔하게 표시됩니다. */
}

/* .mainnav li a:hover 상태 스타일 */
.mainnav li a:hover {
    color: #660000;
    /* 마우스가 링크 위에 있을 때 텍스트 색상을 짙은 붉은색(#660000)으로 변경합니다. */
    background-color: #00ffcc;
    /* 마우스가 링크 위에 있을 때 배경색을 밝은 청록색(#00ffcc)으로 변경합니다. 
       사용자 인터랙션(hover) 시 시각적 변화를 주어 링크의 강조 효과를 만듭니다. */
}
</style>

<!-- 메뉴를 나타내는 ul 요소 -->
<ul class="mainnav">
    <!-- 세션에 memId 값이 있을 때(사용자가 로그인 상태일 때) 링크를 표시 -->
    <c:if test="${sessionScope.memId != null }">
        <li><a href="${ pageContext.request.contextPath }/board/boardWriteForm.do">글쓰기</a></li>
        
    </c:if>   
    <li><a href="${ pageContext.request.contextPath }/board/boardList.do?pg=1">목록</a></li>
    
</ul>

<!-- 설명: 위의 코드는 ul 요소를 사용해 네비게이션 메뉴를 구성합니다.
     세션에 memId 값이 있으면 '글쓰기' 메뉴가 표시되고, '목록' 메뉴는 항상 표시됩니다. -->