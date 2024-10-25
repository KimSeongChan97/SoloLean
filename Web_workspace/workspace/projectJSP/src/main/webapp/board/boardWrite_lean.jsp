<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="board.dao.BoardDAO_lean"%>    
<%@page import="java.util.HashMap"%>    
<%@page import="java.util.Map" %>   

<%
    // 한글 인코딩
    request.setCharacterEncoding("UTF-8");
    // **기존 주석**: 클라이언트가 보낸 데이터를 UTF-8로 인코딩하여 한글이 깨지지 않도록 처리합니다.
    // **추가 주석**: 웹 페이지에서 한글 데이터를 주고받을 때 인코딩 처리를 해주지 않으면, 서버에서 한글이 깨져서 처리될 수 있습니다. 
    // `setCharacterEncoding("UTF-8")`은 UTF-8로 모든 데이터를 인코딩해주는 역할을 합니다.
    
    // 데이터
    // 클라이언트가 form을 통해 보낸 데이터를 서버에서 받습니다.
    // 'subject'와 'content'는 form에서 전달된 파라미터를 통해 얻어옵니다.
    String subject = request.getParameter("subject");
    String content = request.getParameter("content");	
    // **기존 주석**: form에서 전송된 'subject'와 'content' 파라미터의 값을 가져옵니다.
    // **추가 주석**: `request.getParameter()`는 클라이언트가 전송한 폼 데이터에서 특정 필드의 값을 읽어옵니다. 
    // 이 경우 사용자가 게시판에서 입력한 제목과 내용을 가져오게 됩니다. 예를 들어 사용자가 제목 필드에 'Hello'라고 입력했다면, 
    // `subject` 변수에는 'Hello'가 저장됩니다.
    
    // 세션에서 로그인한 사용자의 정보를 가져옵니다.
    // 세션은 서버에 저장된 사용자별 데이터를 유지하는 공간입니다.
    // 'memId', 'memName', 'memEmail'은 사용자가 로그인할 때 세션에 저장된 정보입니다.
    // 이를 통해 로그인한 사용자의 ID, 이름, 이메일 정보를 가져옵니다.
    String id = (String)session.getAttribute("memId");
    String name = (String)session.getAttribute("memName");
    String email = (String)session.getAttribute("memEmail");
    // **기존 주석**: 로그인한 사용자의 ID, 이름, 이메일 정보를 세션에서 가져옵니다.
    // **추가 주석**: 세션은 사용자별로 데이터를 유지할 수 있는 공간입니다. 서버는 사용자가 웹 사이트에 접속해 로그인하면, 그 세션에 로그인 정보를 저장하게 됩니다. 
    // 이 정보를 이용해 페이지를 이동하더라도 로그인 상태를 유지할 수 있습니다. 
    // `session.getAttribute("key")`는 세션에서 특정 데이터를 가져오는 메서드로, 여기에선 'memId', 'memName', 'memEmail'이라는 세션 데이터를 불러옵니다.
    
    // 데이터를 맵(Map) 객체에 저장합니다.
    // Map은 key와 value로 데이터를 저장하는 자료구조로, 여기서는 'id', 'name', 'email', 'subject', 'content' 같은 key를 사용하여
    // 각각의 데이터를 대응시키고 있습니다. 이를 통해 데이터를 한꺼번에 쉽게 관리할 수 있습니다.
    // 예를 들어, map.put("id", id);는 'id'라는 key에 로그인한 사용자의 ID 값을 저장하는 역할을 합니다.
    Map<String, String> map = new HashMap<>();
    map.put("id", id);
    map.put("name", name);
    map.put("email", email);
    map.put("subject", subject);
    map.put("content", content);
    // **기존 주석**: 사용자의 ID, 이름, 이메일, 제목, 내용을 맵(Map)에 저장합니다.
    // **추가 주석**: `Map`은 key-value 쌍으로 데이터를 저장하는 자료구조입니다. 여기서 key는 "id", "name", "email", "subject", "content"이며, 
    // 이 키에 해당하는 값은 각각 로그인한 사용자의 정보와 게시글 작성 데이터를 의미합니다. 
    // 예를 들어 `map.put("id", id)`는 'id'라는 키에 로그인한 사용자의 ID를 저장해, 이후 DB에 저장하거나 다른 처리를 할 때 유용하게 사용할 수 있습니다.
    
    //DB
    BoardDAO_lean boardDAO_lean = BoardDAO_lean.getInstance();
    boardDAO_lean.boardWrite(map);
    // **기존 주석**: 싱글톤 패턴으로 설계된 BoardDAO_lean 객체를 가져와 글쓰기를 처리합니다.
    // **추가 주석**: `BoardDAO_lean.getInstance()`는 싱글톤 패턴을 사용해 객체를 한 번만 생성하여 시스템 전역에서 재사용할 수 있게 합니다. 
    // 이로 인해 불필요한 객체 생성을 방지하고, DB 작업을 효율적으로 처리할 수 있습니다.
    // `boardWrite(map)` 메서드를 호출하여 맵(Map)에 저장된 데이터를 데이터베이스에 저장하는 작업을 수행합니다.
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
