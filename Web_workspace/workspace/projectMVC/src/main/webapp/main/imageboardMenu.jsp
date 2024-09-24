<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
#nav {
    width: 200px;
    padding: 20px;
    background-color: #f0f0f0;
    border-radius: 5px;
    margin-right: 20px; /* 오른쪽 여백 추가 */
    float: left; /* 왼쪽으로 부유하게 하여 다른 콘텐츠와 나란히 배치 */
}

#nav h3 {
    margin-top: 0;
    margin-bottom: 15px;
    color: #333;
}

#nav ul {
    list-style-type: none;
    padding: 0;
}

#nav li {
    margin-bottom: 10px;
}

#nav a {
    display: block;
    padding: 10px;
    text-decoration: none;
    color: #fff;
    background-color: #4CAF50;
    border-radius: 3px;
    transition: background-color 0.3s;
}

#nav a:hover {
    background-color: #45a049;
}
</style>

<div id="nav">
    <h3>이미지 보드 메뉴</h3>
    <ul>
        <li>
            <a href="${pageContext.request.contextPath}/imageboard/imageboardWriteForm.do">이미지 등록</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/imageboard/imageboardWriteAjaxForm.do">이미지 등록 (Ajax)</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/imageboard/imageboardList.do">이미지 목록</a>
        </li>
    </ul>
</div>