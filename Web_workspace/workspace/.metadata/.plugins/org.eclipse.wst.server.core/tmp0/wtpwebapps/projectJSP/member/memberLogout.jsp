<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    // 로그인 상태 확인 변수
    boolean isLoggedIn = false;


	/*
    // 쿠키 가져오기
    Cookie[] ar = request.getCookies();

    // 쿠키가 있을 경우
    if(ar != null){
        for(int i=0; i<ar.length; i++){
            // 쿠키가 memId일 경우 로그인 상태로 간주
            if(ar[i].getName().equals("memId")){
                isLoggedIn = true;
                // 쿠키 삭제
                ar[i].setMaxAge(0); // 0초로 설정하여 쿠키 삭제
                response.addCookie(ar[i]); // 클라이언트에 저장
            }
            // 쿠키가 memName일 경우 삭제
            if(ar[i].getName().equals("memName")){
                ar[i].setMaxAge(0); // 0초로 설정하여 쿠키 삭제
                response.addCookie(ar[i]); // 클라이언트에 저장
            }
        } // for문 종료
    } // if문 종료 (쿠키가 존재할 때만 실행)
    */
    
    // 세션
    session.removeAttribute("memName");
    session.removeAttribute("memId");
    
    // session.invalidate(); -> 전체 세션 제거
    
%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>로그아웃</title>
</head>
<link rel="stylesheet" type="text/css" href="/projectJSP/css/indexcss.css">
<body>

 <script type="text/javascript">
        window.onload = function(){
        	alert("로그아웃 되었습니다 !");
        	location.href = "/projectJSP/index.jsp"
        };
        
        
    </script> 
    
</body>
</html>
