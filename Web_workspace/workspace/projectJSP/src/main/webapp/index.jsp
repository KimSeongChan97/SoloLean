<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 메뉴 페이지</title>
<!-- CSS 파일 링크 수정 -->
<link rel="stylesheet" type="text/css" href="/projectJSP/css/indexcss.css" />
</head>
<body>

    <!-- 여기서 nav.jsp를 동적으로 불러올 부분 -->
    <div id="navbar"></div>
    
    
    
    <div id="link">
        <h3><a href="/projectJSP/mainpage.html">메인 홈페이지</a></h3>
        <h3><a href="/projectJSP/member/memberWriteForm.jsp">회원가입</a></h3>
        <h3><a href="/projectJSP/member/memberLoginForm.jsp">로그인</a></h3>
        <h3><a href="/projectJSP/member/memberLogout.jsp">로그아웃</a></h3>
        <h3><a href="">글쓰기</a></h3>
        <h3><a href="">글목록</a></h3>
        <h3><a href="">회원정보 수정</a></h3>
    </div>
    
    <br/>
    
    <h2 align="center"> 다른 메뉴들은 구현예정</h2>
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- jQuery로 JSP 파일을 불러오는 코드 -->
    <script>
        // jQuery의 load() 메서드를 사용하여 JSP 파일을 불러옴
        $('#navbar').load('/projectJSP/jsp/nav.jsp');
    </script>
</body>
</html>
