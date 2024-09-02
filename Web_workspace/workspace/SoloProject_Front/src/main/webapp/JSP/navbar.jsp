<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!-- navbar.jsp -->
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <!-- 네비게이션 바의 브랜드 로고, '메뉴'라는 텍스트로 홈 페이지(index.html)로 연결됨 -->
        <a class="navbar-brand" href="index.html">메뉴</a>
        
        <!-- 화면 크기가 작아질 때 네비게이션 바의 항목들을 감추고 토글 버튼을 통해 열 수 있게 하는 설정 -->
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span> <!-- 햄버거 메뉴 아이콘 -->
        </button>
        
        <!-- 네비게이션 바의 항목들 -->
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <!-- 'Home' 페이지로 이동하는 링크, 기본적으로 활성화(active) 상태로 표시됨 -->
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="index.html">Home</a>
                </li>
                
                <!-- '게시판' 페이지로 이동하는 링크 -->
                <li class="nav-item">
                    <a class="nav-link" href="board.html">게시판</a>
                </li>
                
                <!-- 'MyPage'로 이동하는 링크 -->
                <!-- MyPage.html 파일의 경로를 올바르게 수정 -->
                <li class="nav-item">
                    <a class="nav-link" href="/SoloProject_Front/MyPage.html">MyPage</a>
                </li>
                
                <!-- 'Logout' 링크 -->
                <li class="nav-item">
                    <a class="nav-link" href="logout.jsp">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
