<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%
    // 자바 역할
    List<String> list = new ArrayList<String>();
    // ArrayList 객체를 생성하고, List 타입으로 참조합니다.
    // ArrayList는 동적으로 크기가 변할 수 있는 배열 구조를 가진 자료구조입니다.

    list.add("호랑이");
    list.add("사자");
    list.add("기린");
    list.add("코끼리");
    list.add("타조");
    list.add("코알라");
    list.add("여우");    
    // List에 동물 이름들을 추가합니다. 이 리스트는 '호랑이', '사자' 등 동물 이름을 포함하는 문자열 목록입니다.
    
    // submit, button를 통해서는 절대로 객체를 넘길 수 없다.
    // 넘어가는 데이터는 문자열(String)만 가능하다. 
    // -> 넘길려면 Session 객체인데, Session은 너무 많이 사용하면 안된다.
    // JSP에서는 request나 response 객체를 통해 데이터를 넘길 수 있습니다.
    // 그러나 request 객체로 넘길 수 있는 데이터는 문자열 형식이어야 하며, 복잡한 객체는 넘길 수 없습니다.
    // 여기서 `request.setAttribute`를 통해 객체를 넘기는 대신, 세션을 사용할 수도 있지만 세션의 과도한 사용은 성능에 부담이 됩니다.

    request.setAttribute("list", list);
    // request scope에 list 객체를 저장합니다. 이 데이터는 같은 요청 내에서만 유지되며, 다른 페이지로 forward할 때는 유효하지만,
    // sendRedirect와 같은 경우에는 새로운 요청을 발생시키기 때문에 데이터는 전달되지 않습니다.

    // 페이지 이동 - 데이터 공유X , 그저 이동?
    response.sendRedirect("sendRedirectEnd.jsp");
    // sendRedirect는 클라이언트 측에서 새로운 HTTP 요청을 발생시키며, 페이지 이동을 처리합니다.
    // 이 방식은 request scope의 데이터를 공유하지 않습니다.
    // 결과적으로 'sendRedirectEnd.jsp' 페이지로 이동하게 되지만, 'list'에 저장된 데이터는 넘어가지 않습니다.
%>    