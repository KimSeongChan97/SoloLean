<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.dao.BoardDAO" %>
<%@ page import="board.dao.CommentDAO" %>
<%@ page import="board.bean.BoardDTO" %>
<%@ page session="true" %>
<%@ page import="java.util.List" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 보기</title>
    <link rel="stylesheet" type="text/css" href="/projectJSP/css/boardView.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <!-- 페이지 상단에 네비게이션 바를 포함합니다. nav.jsp 파일의 내용을 불러옵니다. -->
    <jsp:include page="/jsp/nav.jsp" />

    <!-- 게시글 제목을 출력하는 부분입니다. 클릭 시 메인 페이지로 이동합니다. -->
    <h2 align="center" style="font-family: 'Comic Sans MS';" onclick="location.href='../index.jsp'"> N o t e _ V i e w </h2>

    <%
        // 게시글 번호를 요청 파라미터에서 받아옵니다.
        int seq = Integer.parseInt(request.getParameter("seq")); // 게시글의 고유 번호를 받아서 처리합니다.

        // BoardDAO와 CommentDAO 객체를 인스턴스화합니다. 각각 게시글과 댓글 데이터를 처리합니다.
        BoardDAO boardDAO = BoardDAO.getInstance(); // 싱글톤 패턴으로 설계된 BoardDAO 인스턴스를 가져옵니다.
        CommentDAO commentDAO = CommentDAO.getInstance(); // 싱글톤 패턴으로 설계된 CommentDAO 인스턴스를 가져옵니다.

        // 조회수 증가 및 게시글 조회
        boardDAO.increaseHit(seq); // 해당 게시글의 조회수를 1 증가시킵니다.
        BoardDTO board = boardDAO.getBoard(seq); // 해당 게시글의 정보를 데이터베이스에서 조회해 BoardDTO 객체에 저장합니다.

        // 댓글 목록 조회
        List<String[]> comments = commentDAO.getCommentsByBoardSeq(seq); // 특정 게시글 번호에 해당하는 댓글 목록을 가져옵니다.
    %>

    <div class="container">
        <!-- 왼쪽 섹션: 게시글 정보 및 댓글을 보여주는 영역입니다. -->
        <div class="left-section">
            <!-- 게시글의 제목을 출력합니다. -->
            <label for="subject">제목:</label>
            <div id="subject"><%= board.getSubject() %></div><br> <!-- BoardDTO 객체에서 제목(subject)을 가져와 출력합니다. -->

            <!-- 게시글의 내용을 출력합니다. -->
            <label for="content">내용:</label>
            <div id="content"><%= board.getContent() %></div><br> <!-- BoardDTO 객체에서 내용(content)을 가져와 출력합니다. -->

            <!-- 댓글 목록 출력 -->
            <label for="comment">댓글:</label>
            <div id="comment" class="comment-section">
                <!-- 댓글 리스트를 출력합니다. -->
                <ul class="comment-list">
                    <%
                        // 댓글 리스트를 순회하면서 각 댓글의 작성자 이름과 내용을 출력합니다.
                        for (String[] comment : comments) {
                    %>
                        <li><strong><%= comment[0] %></strong>: <%= comment[1] %></li> <!-- comment[0]: 작성자 이름, comment[1]: 댓글 내용 -->
                    <%
                        }
                    %>
                </ul>
            </div>
			
			<!-- 세션에 저장된 회원 이름 확인 -->
			<%
			    // 로그인한 사용자의 이름을 세션에서 가져옵니다.
			    String sessionName = (String) session.getAttribute("memName"); // 세션에 저장된 로그인된 사용자 이름을 가져옵니다.
			    if (sessionName != null) { // 만약 세션에 사용자 이름이 존재하면 출력합니다.
			%>	
			    <p>로그인된 사용자: <%= sessionName %></p> <!-- 세션에서 가져온 사용자의 이름을 출력합니다. -->
			<%
			    } else { // 세션에 사용자 이름이 없으면 아래 메시지를 출력합니다.
			%>
			    <p>로그인된 사용자 정보가 없습니다.</p> <!-- 로그인되지 않은 사용자에게 보여줄 메시지입니다. -->
			<%
			    }
			%>
						
            <!-- 댓글 작성 버튼을 로그인된 사용자에게만 표시 -->
            <%
                // 로그인된 사용자에게만 댓글 작성 버튼을 보여줍니다.
                if (session.getAttribute("memName") != null) { // 세션에 저장된 사용자 이름이 있으면 댓글 작성 버튼을 활성화합니다.
            %>
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#commentModal">
                    댓글 작성 <!-- 댓글 작성 버튼을 출력하며, 클릭 시 모달이 열립니다. -->
                </button>
            <%
                } else { // 로그인이 되어 있지 않은 사용자는 댓글 작성 버튼을 누를 수 없고, 대신 로그인 안내 메시지를 표시합니다.
            %>
                <p style="color: red;">로그인 후 댓글을 작성할 수 있습니다.</p> <!-- 로그인되지 않은 경우 댓글 작성 불가 메시지를 표시합니다. -->
            <%
                }
            %>
        </div>

        <!-- 오른쪽 섹션: 게시글 작성자 정보 및 기타 정보를 보여주는 영역입니다. -->
        <div class="right-section">
            <!-- 작성자의 이름을 출력합니다. -->
            <label for="name">작성자:</label>
            <div id="name"><%= board.getName() %></div><br> <!-- BoardDTO 객체에서 작성자의 이름(name)을 가져와 출력합니다. -->

            <!-- 작성자의 이메일을 출력합니다. -->
            <label for="email">작성자 email:</label>
            <div id="email"><%= board.getEmail() %></div><br> <!-- BoardDTO 객체에서 이메일(email)을 가져와 출력합니다. -->

            <!-- 작성일을 포맷팅하여 출력합니다. -->
            <%
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");
                String formattedLogtime = sdf.format(board.getLogtime()); // Date를 String으로 변환
            %>
            <label for="logtime">작성일:</label>
            <div id="logtime"><%= formattedLogtime %></div><br> <!-- 변환된 날짜 문자열을 출력 -->

            <!-- 게시글 조회수를 출력합니다. -->
            <label for="hit">조회수:</label>
            <div id="hit"><%= board.getHit() %></div><br> <!-- BoardDTO 객체에서 조회수(hit)를 가져와 출력합니다. -->

            <!-- 목록으로 돌아가는 버튼 -->
            <input type="button" value="목록으로" onclick="location.href='boardList.jsp'"> <!-- 게시글 목록 페이지로 돌아가는 버튼입니다. -->
        </div>
    </div>  

    <!-- 댓글 작성 모달: 로그인된 사용자가 댓글을 작성할 수 있도록 폼을 제공합니다. -->
    <div class="modal fade" id="commentModal" tabindex="-1" aria-labelledby="commentModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="commentModalLabel">댓글 작성</h5> <!-- 모달의 제목을 표시합니다. -->
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button> <!-- 모달을 닫는 버튼입니다. -->
          </div>
          <div class="modal-body">
            <!-- 댓글 작성 폼 -->
            <form id="commentForm" action="addComment.jsp" method="post">
              <!-- 댓글 내용을 입력하는 텍스트 영역 -->
              <div class="mb-3">
                <label for="commentContent" class="form-label">댓글 내용</label>
                <textarea class="form-control" id="commentContent" name="commentContent" rows="3"></textarea> <!-- 댓글 내용을 입력받는 텍스트 박스입니다. -->
              </div>
              <!-- 게시글 번호를 숨겨서 폼에 포함시킵니다. -->
              <input type="hidden" name="boardSeq" value="<%= seq %>"> <!-- 게시글 번호를 댓글과 함께 전송하기 위한 숨겨진 필드입니다. -->
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button> <!-- 모달을 닫는 버튼입니다. -->
            <button type="submit" form="commentForm" class="btn btn-primary">댓글 저장</button> <!-- 폼을 제출하는 버튼으로, 댓글을 저장하는 역할을 합니다. -->
          </div>
        </div>
      </div>
    </div>

    <!-- jQuery 라이브러리를 포함합니다. -->
    <script type="text/javascript" src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
</body>
</html>
