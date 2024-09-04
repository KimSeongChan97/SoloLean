<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 네비게이션 바 HTML 구조 -->
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <!-- home.png 이미지를 클릭하면 index.jsp로 이동 -->
        <a class="navbar-brand" href="index.jsp">
            <img src="./image/home.png" alt="Home" width="30" height="30"/>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-link active" aria-current="page" href="index.jsp">메뉴 페이지</a>
                <a class="nav-link" href="#">회원가입</a>
                <a class="nav-link" href="#">로그인</a>
                <a class="nav-link" href="#">로그아웃</a>
                <a class="nav-link" href="#">글쓰기</a>
                <a class="nav-link" href="#">글목록</a>
            </div>
        </div>
    </div>
</nav>
