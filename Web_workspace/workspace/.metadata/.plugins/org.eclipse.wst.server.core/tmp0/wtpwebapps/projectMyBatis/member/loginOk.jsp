<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
    
	// 쿠키에서 로그인된 사용자의 이름(name)과 아이디(id)를 가져오기 위한 코드입니다.
    // 처음에 name과 id 변수를 null로 초기화합니다. 쿠키에서 값을 가져오기 전에 기본값을 설정하는 과정입니다.
    String name = null; // 쿠키에서 사용자 이름을 가져올 변수
    String id = null;   // 쿠키에서 사용자 아이디를 가져올 변수
	
    /*
    // 클라이언트(사용자의 브라우저)로부터 모든 쿠키를 가져옵니다.
    // request.getCookies()는 클라이언트가 보낸 모든 쿠키를 Cookie[] 배열로 반환합니다.
    Cookie[] ar = request.getCookies(); 

    // 가져온 쿠키 배열이 null인지 체크합니다. null일 경우에는 쿠키가 전혀 없다는 의미입니다.
    // 만약 쿠키가 하나라도 있으면, 그 배열을 반복하며 필요한 쿠키(memName, memId)를 찾아 값을 사용합니다.
    if(ar != null) {  // 쿠키가 null이 아닐 때만 아래의 코드가 실행됩니다.
        // 쿠키 배열의 길이만큼 반복하여 각 쿠키를 확인합니다.
        for(int i=0; i<ar.length; i++){
            // 각 쿠키의 이름과 값을 가져옵니다.
            String cookieName = ar[i].getName();   // 현재 쿠키의 이름을 가져옵니다.
            String cookieValue = ar[i].getValue(); // 현재 쿠키의 값을 가져옵니다.

            // 서버의 콘솔에 현재 쿠키의 이름과 값을 출력합니다. 개발 중 디버깅을 위한 코드입니다.
            // 콘솔에 출력되는 값은 서버 측에서만 확인할 수 있으며, 사용자가 직접 볼 수는 없습니다.
            System.out.println("쿠키명 = " + cookieName);   // 콘솔에 쿠키 이름 출력
            System.out.println("쿠키값 = " + cookieValue); // 콘솔에 쿠키 값 출력
            System.out.println();  // 빈 줄 추가로 가독성 향상

            // 쿠키의 이름이 "memName"이라면 해당 쿠키 값을 name 변수에 저장합니다.
            if (cookieName.equals("memName")) name = ar[i].getValue();  // name 변수에 쿠키에서 가져온 값을 저장
            
            // 쿠키의 이름이 "memId"라면 해당 쿠키 값을 id 변수에 저장합니다.
            if (cookieName.equals("memId")) id = ar[i].getValue();  // id 변수에 쿠키에서 가져온 값을 저장
            
        } // for 루프 종료
    } // if 조건문 종료
    */
    
    // 세션
    name = (String)session.getAttribute("memName"); // 자식(String) = (자식)부모 로 캐스팅 해야함
    id = (String)session.getAttribute("memId");
    
%>

<%= name %>

