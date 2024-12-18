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
    <% if(session.getAttribute("memId") == null) { %>
        
        <h3><a href="/projectJSP/member/memberWriteForm.jsp">J o i n</a></h3>
        <h3><a href="/projectJSP/member/memberLoginForm.jsp">L o g i n</a></h3>
    <%}else{ %>    
        <h3><a href="/projectJSP/member/memberLogout.jsp">L o g O u t</a></h3>
        <h3><a href="/projectJSP/member/memberUpdateForm.jsp">Edit Profile</a></h3>
        <h3><a href="/projectJSP/board/boardWriteForm.jsp">P o s t</a></h3>
        <h3><a href="/projectJSP/board/boardList.jsp?pg=1">N o t e</a></h3>
        
                               
    <%} %>     
    
    	<h3><a href="/projectJSP/board/boardList.jsp?pg=1">외부목록</a></h3>
    </div>
    
    <br/>
    
        
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- jQuery로 JSP 파일을 불러오는 코드 -->
    <script>
        // jQuery의 load() 메서드를 사용하여 JSP 파일을 불러옴
        $('#navbar').load('/projectJSP/jsp/nav.jsp');
		
    </script>
</body>
</html>
