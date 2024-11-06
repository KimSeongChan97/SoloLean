<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Spring Hotel Q&A 상세내역</title>
    <meta name="viewport" content="width=device-width", initial-scale="1">
	<link rel="stylesheet" href="/SpringHotel/resources/css/bootstrap.css">
    <link rel="stylesheet" href="/SpringHotel/resources/css/inquiryCSS.css">
    <style>
        .btn {
            margin-top: 15px;
            margin-bottom: 15px;
            background-color: #382f24;
            width: 120px;
            height: 50px;
            border: none;
            font-size: medium;
            color: #f1ebd5;
        }
        #comment {
            margin-bottom: 15px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            width: 70%;
            margin: 0 auto;
        }
        #comment2 {
            margin-bottom: 15px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            width: 100%;
            margin: 0 auto;
        }
    </style>
</head>

<body>
	<%@ include file="../common/header.jsp" %>
	<div id="reserveTitle"><font size="20">Q&A</font></div>
    <div id="detailcomment" data-view="inquiryList">
        Spring Hotel은 언제나 고객님의 목소리에 귀기울이고 있습니다.<br />
        고객님들의 소중한 충고와 격려, 또는 제안의 말씀을 주시면 더 나은 서비스로 보답하겠습니다.
    </div>

    <form>
        <table align="center" class="inquiryDetail">
            <tr>
                <td id="detail">제목</td>
                <td>${typename}</td>
                <td id="detail">번호</td>
                <td>${questionsDTO.questionsId}</td>
            </tr>
            <tr>
                <td id="detail">작성자</td>
                <td>${userName}</td>
                <td id="detail">작성일</td>
                <td>${questionsDTO.logtime}</td>
            </tr>
            <tr>
                <td id="detailcontent">내용</td>
                <td colspan="3">
                    <textarea rows="5" cols="40" id="detailtextarea" readonly="readonly" name="b_content">${questionsDTO.content}</textarea>
                </td>
            </tr>
            <tr align="center">
                <td colspan="4">
                   	<input type="hidden" name="questionsId" value="${questionsDTO.questionsId}">
                    <input type="button" class="btn" value="목록" onclick="location.href='/SpringHotel/admin/inquiryList2'" />
 					<!-- 현재 로그인한 사용자가 작성자인지 확인하여 수정, 삭제 버튼 표시 -->
                    <c:if test="${sessionScope.userSeq == seq}">
                        <input type="button" class="btn" id="Updatebtn" value="수정" onclick="location.href='/SpringHotel/admin/inquiryUpdate?questionsId=${questionsDTO.questionsId}&typename=${typename}&content=${questionsDTO.content}'" />
                        <input type="button" class="btn" id="Deletebtn" value="삭제" data-id="${questionsDTO.questionsId}" onclick="deleteItem()"/>
                    </c:if>
                </td>
            </tr>
        </table>
    </form>
	
	<c:forEach items="${comments}" var="answerDTO">
	    <div id="comment" style="margin-bottom: 10px;">
	        <strong>${answerDTO.adminId}</strong> | ${answerDTO.logdate}<br/>
	        <div id="showContent${answerDTO.answerId}" style="white-space: pre;">
	            <c:out value="${answerDTO.comment}"></c:out><br />
	        </div>
	    </div>
	</c:forEach>

   <jsp:include page="../common/footer.jsp" />
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="/SpringHotel/resources/js/bootstrap.js"></script>
<script src="/SpringHotel/resources/js/header.js"></script>
<script src="/SpringHotel/resources/js/admin.js"></script>
<script type="text/javascript">
function deleteItem() {
	$.ajax({
	    type: 'get', // HTTP GET 방식 사용
	    url: '/SpringHotel/inquiry/delete?questionsId=' + $('#Deletebtn').data('id'), // 서버의 아이디 체크 URL에 현재 아이디 값을 전달
	    dataType: 'text', // 서버 응답 데이터 타입을 텍스트로 지정
	    success: function(data) { // 서버로부터 응답이 성공적으로 오면 실행
	        console.log(data.trim()); // 서버로부터 받은 데이터를 콘솔에 출력 (공백 제거)
	        location.href = '/SpringHotel/admin/inquiryList2' // 예약 화면으로 이동
	    }
	})	
}
</script>
</body>
</html>
