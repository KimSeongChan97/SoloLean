<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.dao.BoardDAO" %>
<%@ page import="board.bean.BoardDTO" %>
<%@ page import="java.sql.*" %>

<%
    // UTF-8 인코딩 설정
	request.setCharacterEncoding("UTF-8");

    // 세션에서 사용자 정보 가져오기
    String id = (String) session.getAttribute("memId");
    String name = (String) session.getAttribute("memName");
    String email = (String) session.getAttribute("memEmail");

    // 글쓰기 폼에서 입력된 값 가져오기
    String subject = request.getParameter("subject");
    String content = request.getParameter("content");

    // 유효성 검사 (서버 측)
    if (subject == null || subject.trim().equals("") || content == null || content.trim().equals("")) {
        out.println("<script>alert('제목과 내용을 입력하세요.'); history.back();</script>");
        return;
    }

    // DAO를 통해 데이터베이스에 저장
    BoardDTO boardDTO = new BoardDTO();
    boardDTO.setId(id); // 세션에서 가져온 id
    boardDTO.setName(name); // 세션에서 가져온 이름
    boardDTO.setEmail(email); // 세션에서 가져온 이메일
    boardDTO.setSubject(subject);
    boardDTO.setContent(content);

    // 시퀀스와 ref 값 처리
    BoardDAO boardDAO = BoardDAO.getInstance();
    int seq = boardDAO.getNextSeq(); // 시퀀스를 통해 seq 값 얻어오기
    boardDTO.setSeq(seq);
    boardDTO.setRef(seq); // 처음 글의 ref는 seq와 동일하게 설정

    boardDAO.insertBoard(boardDTO); // 데이터베이스에 저장

    // 글 목록으로 리다이렉트
    response.sendRedirect("boardList.jsp");
    
%>
