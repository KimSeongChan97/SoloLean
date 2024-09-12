<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.jstl.PersonDTO"%>

<%
    // 자바 역할
    List<String> list = new ArrayList<String>();
    // ArrayList 객체를 생성하고, List 인터페이스 타입으로 참조합니다.
    // ArrayList는 크기가 동적으로 변하며, 여러 요소를 저장할 수 있는 자료구조입니다.
    // ArrayList는 배열과 달리 크기가 고정되어 있지 않고, 필요한 만큼 요소를 추가할 수 있습니다.
    // List는 인터페이스이고, ArrayList는 그 구현체입니다. 따라서 List로 선언하고 ArrayList를 할당하여
    // List의 메서드와 특징들을 사용합니다. ArrayList의 세부 기능에 의존하지 않도록 하는 것이 좋은 설계입니다.

    list.add("호랑이");
    list.add("사자");
    list.add("기린");
    list.add("코끼리");
    list.add("타조");
    list.add("코알라");
    list.add("여우");    
    // List에 동물 이름을 추가합니다. 이 리스트는 '호랑이', '사자' 등의 동물 이름을 포함하는 문자열 목록입니다.
    // add() 메서드는 리스트의 끝에 요소를 추가합니다. 리스트는 동적으로 크기가 변하며, 언제든지 요소를 추가하거나 제거할 수 있습니다.

    PersonDTO aa = new PersonDTO("홍길동",25);
    PersonDTO bb = new PersonDTO("라이언",23);
    PersonDTO cc = new PersonDTO("프로도",30);
    // PersonDTO 객체를 생성합니다. 각 객체는 이름과 나이를 매개변수로 받아 생성됩니다.
    // 생성된 객체 aa, bb, cc는 각각 "홍길동", "라이언", "프로도"의 이름과 해당하는 나이를 갖습니다.
    // PersonDTO는 Lombok을 통해 자동 생성된 생성자(@AllArgsConstructor 등)를 이용해 필드 값들을 설정합니다.

    // list2 에는 PersonDTO@주소 가 담긴다. (data는 아직 포함되어 있지 않다.)
    List<PersonDTO> list2 = new ArrayList<PersonDTO>();
    list2.add(aa);
    list2.add(bb);
    list2.add(cc);
    // PersonDTO 객체들을 ArrayList에 추가합니다.
    // list2는 PersonDTO 객체들의 주소(참조)를 저장하는 리스트입니다.
    // 이 객체들은 실제 데이터(name, age)를 포함하고 있으며, list2에 추가됨으로써 JSP에서 해당 객체의 정보를 사용할 수 있습니다.
        
    // submit, button을 통해서는 절대로 객체를 넘길 수 없다.
    // 넘어가는 데이터는 문자열(String)만 가능하다. 
    // -> 넘기려면 Session 객체인데, Session은 너무 많이 사용하면 안된다.
    // JSP에서는 request나 response 객체를 통해 데이터를 넘길 수 있습니다.
    // request 객체에 저장할 수 있는 데이터는 주로 문자열이지만, 객체도 넘길 수 있습니다.
    // 그러나 submit이나 버튼을 통해서는 직접적으로 객체를 전달할 수 없습니다.
    // 데이터를 넘길 때는 세션을 사용할 수도 있지만, 세션은 과도하게 사용하면 성능에 부정적인 영향을 미칠 수 있습니다.
    // form에서 데이터를 전송할 때는 문자열만 전송 가능하며, 객체와 같은 데이터는 세션 또는 서버 내부 로직에서 처리되어야 합니다.
    // 객체를 넘기고 싶다면 세션(session)에 저장하거나 데이터베이스, 서버 메모리 등에서 유지해야 합니다.

    request.setAttribute("list", list);
    // request scope에 'list'라는 이름으로 list 객체를 저장합니다. 
    // 이 데이터는 forward로 다른 JSP 페이지로 이동할 때도 공유됩니다.
    // JSP 페이지 간에 데이터를 공유할 때 request 객체를 사용하며, 여기서는 list라는 이름으로 저장하여 다른 페이지로 전달됩니다.
    request.setAttribute("list2", list2);
    // list2 의 데이터를 객체 저장한다.
    // list2 역시 request 객체에 저장되어 다른 페이지로 전달됩니다. 이 방식은 request 범위 안에서만 데이터를 유지하고,
    // 페이지가 바뀌어도 데이터가 계속 전달됩니다.

    // forward로 페이지 이동
    // forward는 서버 내부에서 요청을 전달하며, request와 response 객체를 유지합니다.
    // 따라서 'list'에 저장된 데이터는 forwardEnd.jsp에서도 사용할 수 있습니다.
    // forward는 클라이언트가 인식하지 못한 채 서버 내부에서 페이지를 이동합니다. 요청(request)과 응답(response) 객체가 그대로 전달되므로
    // forwardEnd.jsp에서 이 데이터를 사용할 수 있습니다.
    
    // 페이지 이동
    // forward 와 같은 의미
    RequestDispatcher dispathcer = request.getRequestDispatcher("forwardEnd.jsp"); // 상대번지
    // RequestDispatcher 객체를 통해 요청을 다른 페이지로 전달합니다. 여기서는 forwardEnd.jsp 페이지로 요청을 넘기게 됩니다.
    // 페이지를 이동할 때 상대 경로를 사용하여 이동하며, 서버 내부에서 요청이 처리됩니다.

    // 제어권 넘기기
    dispathcer.forward(request, response);
    // forward 메서드를 사용하여 forwardEnd.jsp 페이지로 제어권을 넘깁니다.
    // 이때 request와 response 객체는 그대로 전달되며, 이전 페이지에서 설정된 데이터도 유지됩니다.
    
%> 

 <%--   
<jsp:forward page="forwardEnd.jsp" />
<!-- 
    forward를 사용하여 'forwardEnd.jsp' 페이지로 요청을 전달합니다.
    클라이언트는 forward 과정을 알지 못하며, 요청은 서버 내부에서 처리됩니다.
    forward는 request 객체에 저장된 데이터를 유지한 채 다른 페이지로 전달하므로, forwardEnd.jsp에서 해당 데이터를 사용할 수 있습니다.
 -->
  --%>
