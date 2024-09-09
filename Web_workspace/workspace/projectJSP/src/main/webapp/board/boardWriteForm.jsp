<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!-- JSP 페이지에서 사용할 언어와 컨텐츠 타입을 설정, 페이지 인코딩은 UTF-8로 지정하여 한글 등 다국어 지원 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> <!-- HTML5 문서의 문자 인코딩을 UTF-8로 설정 -->
<title>글쓰기 폼</title> <!-- 페이지 제목 설정 -->
<link rel="stylesheet" type="text/css" href="/projectJSP/css/boardWrite.css"> <!-- 외부 CSS 파일을 링크하여 스타일 적용 -->
</head>
<body>

<!-- 네비게이션 바를 포함하여 상단 메뉴를 표시 -->
<jsp:include page="/jsp/nav.jsp" /> 

<!-- 제목을 중앙에 정렬하고, 클릭 시 메인 페이지(index.jsp)로 이동하게 설정 -->
<h2 align="center" style="font-family: 'Comic Sans MS';" style="cursor: pointer;" 
	 onclick="location.href='../index.jsp'" > P o s t </h2>
	 
<!-- 게시글 작성 폼 -->
<!-- 폼의 action 속성은 'boardWrite.jsp'로 설정되어 있으며, 사용자가 입력한 데이터를 POST 방식으로 전송 -->
<!-- onsubmit 이벤트는 폼 제출 시 validateForm 함수를 호출하여 유효성 검사를 수행 -->
<form action="boardWrite.jsp" method="post" onsubmit="return validateForm();">

    <label for="subject">제목:</label> <!-- 제목 입력 필드를 위한 레이블 -->
    <input type="text" id="subject" name="subject"> <!-- 제목 입력 필드 -->
    <br><br>
    <div id="subjectDiv"></div> <!-- 유효성 검사 결과가 출력될 div (제목 유효성 검사 결과) -->
	
    <label for="content">내용:</label> <!-- 내용 입력 필드를 위한 레이블 -->
    <textarea id="content" name="content" rows="10" cols="40"></textarea> <!-- 내용 입력 필드 -->
    <br><br>
    <div id="contentDiv"></div> <!-- 유효성 검사 결과가 출력될 div (내용 유효성 검사 결과) -->
	
    <input type="submit" value="글쓰기"> <!-- 글쓰기 버튼, 클릭 시 폼이 제출됨 -->
    <input type="reset" value="다시작성"> <!-- 다시작성 버튼, 클릭 시 폼의 입력값이 초기화됨 -->
</form>

<!-- jQuery 라이브러리를 외부 URL로 포함하여 사용 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-3.7.1.min.js"></script>

<!-- 폼 유효성 검사를 위한 자바스크립트 코드 -->
<script type="text/javascript">
    // 유효성 검사 함수
    // 이 함수는 폼이 제출되기 전에 제목과 내용 필드가 비어 있는지 확인하여, 비어 있을 경우 폼을 제출하지 않고 경고 메시지를 출력합니다.
    function validateForm() {
        // 각 입력 필드의 값 가져오기
        var subject = document.getElementById("subject").value; // 제목 입력 필드의 값 가져오기
        var content = document.getElementById("content").value; // 내용 입력 필드의 값 가져오기

        // 메시지를 출력할 div 요소 가져오기
        var subjectDiv = document.getElementById("subjectDiv"); // 제목 유효성 검사 메시지가 출력될 div 요소
        var contentDiv = document.getElementById("contentDiv"); // 내용 유효성 검사 메시지가 출력될 div 요소

        // 기존 메시지 초기화
        subjectDiv.innerHTML = ""; // 제목 검증 결과 메시지 초기화
        contentDiv.innerHTML = ""; // 내용 검증 결과 메시지 초기화

        // 제목이 없을 경우 메시지 출력
        if (subject == null || subject.trim() == "") { // 제목 필드가 비어 있거나 공백으로만 이루어져 있는지 확인
            subjectDiv.innerHTML = "제목을 입력하세요."; // 제목이 없을 경우 경고 메시지 출력
            return false; // 폼 제출을 막기 위해 false 반환
        }

        // 내용이 없을 경우 메시지 출력
        if (content == null || content.trim() == "") { // 내용 필드가 비어 있거나 공백으로만 이루어져 있는지 확인
            contentDiv.innerHTML = "내용을 입력하세요."; // 내용이 없을 경우 경고 메시지 출력
            return false; // 폼 제출을 막기 위해 false 반환
        }

        return true; // 유효성 검사를 통과한 경우 폼 제출을 허용
    }
</script>

</body>
</html>
