<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#boardDeleteForm {
	display: flex;
	flex-direction: column;
	align-items: center;
	margin: 30px auto;
	text-align: left;
	background-color: #1a1a1a; /* 어두운 배경을 사용하여 눈에 덜 피로한 스타일 적용 */
	padding: 20px;
	border-radius: 10px; /* 테두리에 둥근 모서리 적용 */
	box-shadow: 0 0 10px #00ffcc; /* 네온 스타일의 그림자 효과 적용 */
}

#boardDeleteForm div {
    color: #ff00ff; /* 네온 스타일 색상으로 강조 */
    font-size: 10pt;
    font-weight: bold;
}

input[type="text"], textarea {
    background-color: #333333; /* 어두운 색상으로 입력 필드 배경 설정 */
    color: #00ffcc; /* 네온 스타일 텍스트 색상 */
    border: 1px solid #00ffcc; /* 네온 스타일 테두리 */
    padding: 10px;
    width: 100%;
    box-sizing: border-box; /* 요소 크기를 내용물 크기까지 포함하도록 설정 */
}

input[type="button"], input[type="reset"] {
    background-color: #00ffcc; /* 네온 스타일 배경 */
    color: #0d0d0d; /* 어두운 텍스트 색상 */
    border: none;
    padding: 10px 20px;
    cursor: pointer;
    margin: 10px;
    transition: background-color 0.3s; /* 배경색 변화에 부드러운 애니메이션 적용 */
    border-radius: 25px;    
}

input[type="button"]:hover, input[type="reset"]:hover {
    background-color: #00ffcc;
    box-shadow: 0 0 10px cyan, 0 0 20px cyan, 0 0 30px cyan, 0 0 40px cyan; /* 네온 효과 강조 */
    transition: box-shadow 1.5s ease; /* 그림자가 천천히 변하는 효과 */
    border-radius: 25px;
}

.table-buttons {
    text-align: center;
    padding-top: 20px; /* 버튼들을 테이블 하단에 위치시키기 위한 여백 */
}
</style>
</head>
<body>
<script type="text/javascript">
    // 삭제 확인 메시지를 띄우고, 확인 시 삭제 처리
    function deleteConfirm(seq) {
        if (confirm("정말로 이 게시글을 삭제하시겠습니까?")) {
            // 삭제 요청을 보내는 폼 제출
            document.location.href = '/projectMVC/board/boardDeleteForm.do?seq=' + seq;
        }
    }
    
</script>
 <h2>게시글 삭제</h2>
    <p>정말로 삭제하시겠습니까?</p>
    
    <input type="button" value="삭제" onclick="deleteConfirm(${param.seq})">
    <input type="button" value="취소" onclick="history.back();">

</body>
</html>