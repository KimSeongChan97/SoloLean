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
                
                <%
                    // 세션에서 'user'라는 이름으로 저장된 값을 가져옵니다.
                    // 사용자가 로그인한 상태라면 user 변수에 값이 저장되어 있을 것입니다.
                    String user = (String) session.getAttribute("user");
                    if (user != null) { // 로그인한 사용자가 있는 경우
                %>
                    <!-- 'MyPage'로 이동하는 링크, 로그인된 사용자만 볼 수 있습니다. -->
                    <li class="nav-item">
                        <a class="nav-link" href="mypage.html">MyPage</a>
                    </li>
                    
                    <!-- 'Logout' 링크, 로그인된 사용자만 볼 수 있습니다. -->
                    <li class="nav-item">
                        <a class="nav-link" href="logout.jsp">Logout</a>
                    </li>
                <%
                    } else { // 로그인한 사용자가 없는 경우
                %>
                    <!-- '회원가입' 페이지로 이동하는 링크, 로그인되지 않은 사용자에게만 표시됩니다. -->
                    <li class="nav-item">
                        <a class="nav-link" href="register.html">회원가입</a>
                    </li>
                    
                    <!-- 'Login' 페이지로 이동하는 링크, 로그인되지 않은 사용자에게만 표시됩니다. -->
                    <li class="nav-item">
                        <a class="nav-link" href="login.html">Login</a>
                    </li>
                <%
                    }
                %>
            </ul>
        </div>
    </div>
</nav>
