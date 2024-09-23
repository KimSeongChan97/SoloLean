<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 삭제</title>
<!-- 새롭게 만든 CSS 파일을 링크 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/boardDelete.css">
<script type="text/javascript">
    // 삭제 확인 메시지를 띄우고, 확인 시 삭제 처리
    function deleteConfirm(seq) {
        if (confirm("정말로 이 게시글을 삭제하시겠습니까?")) {
            // 삭제 요청을 보내는 폼 제출
            document.location.href = '/projectMVC/board/boardDeleteForm.do?seq=' + seq;
        }
    }
</script>
</head>
<body>
    <div id="boardDeleteForm">
        <h2>게시글 삭제</h2>
        <div>정말로 삭제하시겠습니까?</div>

        <!-- 삭제 및 취소 버튼 -->
        <div class="table-buttons">
            <input type="button" value="삭제" onclick="deleteConfirm(${param.seq})">
            <input type="button" value="취소" onclick="history.back();">
        </div>
    </div>
</body>
</html>
