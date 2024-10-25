<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Spring Hotel Q&A 상세내역</title>
    <link rel="stylesheet" href="/SpringHotel/resources/css/inquiryCSS.css">
    <link rel="stylesheet" href="/SpringHotel/resources/css/adminCSS.css">
	<link rel="stylesheet" href="/SpringHotel/resources/css/headerCSS.css">
	<link rel="stylesheet" href="/SpringHotel/resources/css/bootstrapCSS.css">
    <style>
        #btn {
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
            width: 100%;
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
    <br/><br />
	<div id="reserveTitle"><font size="20">Q&A</font></div>
    <div id="detailcomment">
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
                    <input type="button" id="btn" value="목록" onclick="location.href='/SpringHotel/admin/inquiryList'" />
                </td>
            </tr>
        </table>
    </form>
	
	<c:forEach items="${comments}" var="answerDTO">
	    <div id="comment">
	        <strong>${answerDTO.adminId}</strong> | ${answerDTO.logdate}<br/>
	        <div id="showContent${answerDTO.answerId}" style="white-space: pre;">
	            <c:out value="${answerDTO.comment}"></c:out><br />
	        </div>
	        <div id="hideContent${answerDTO.answerId}" style="display: none;">
	            <textarea rows="6" cols="100" name="comment" required="required">${answerDTO.comment}</textarea><br />
	            <input type="hidden" name="answerId" value="${answerDTO.answerId}" />
	            <input type="hidden" name="questionId" value="${questionsDTO.questionsId}" />
	            <input type="button" value="수정 완료" class="commentBtn" id="updateCommentBtn2" data-answerid="${answerDTO.answerId}" />
	            <input type="button" value="취소" class="commentBtn" onclick="showDesc(${answerDTO.answerId})" />
	        </div>
	        <div>
	            <c:if test="${answerDTO.adminId == adminId}">
	                <input type="button" class="updateCommentBtn" data-answerid="${answerDTO.answerId}" value="수정" />
	                <input type="button" class="deleteCommentBtn" data-answerid="${answerDTO.answerId}" value="삭제" />
	            </c:if>
	        </div>
	    </div>
	</c:forEach>

	<div id="commentWrite2">
	    <form id="commentForm2" style="text-align: center; width: 100%;">
	        <textarea rows="6" cols="100" name="comment2" id="comment22" required="required" placeholder="댓글을 작성해주시길 바랍니다."></textarea><br>
	        <input type="hidden" name="questionsId" value="${questionsDTO.questionsId}">
	        <input type="hidden" name="userName" value="${userName}">
	        <div style="text-align: center; margin-top: 10px; margin-bottom: 10px;">
	            <input type="button" value="댓글 작성" id="commentWriteBtn" style="text-align: center; align-content: center; align-items: center; margin: 0 auto;"/>
	        </div>
	    </form>
	</div>

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="/SpringHotel/resources/js/bootstrap.js"></script>
<script src="/SpringHotel/resources/js/header.js"></script>
<script src="/SpringHotel/resources/js/admin.js"></script>
	
</body>
</html>
