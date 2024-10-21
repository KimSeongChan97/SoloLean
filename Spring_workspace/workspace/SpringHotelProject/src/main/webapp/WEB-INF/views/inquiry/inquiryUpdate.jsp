<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="java.io.PrintWriter" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>호텔 C&S - Q&A 게시글 수정</title>
	<meta name="viewport" content="width=device-width", initial-scale="1">
	<link rel="stylesheet" href="/SpringHotel/resources/css/bootstrap.css">
   <link rel="stylesheet" href="/SpringHotel/resources/css/inquiryCSS.css">
   <style>
      .btn{
         margin-top: 15px;
         margin-bottom: 15px;
         background-color: #382f24;
         width: 120px;
         height: 50px;
         border: none;
         font-size: medium;
         color: #f1ebd5;
      }
      
      #updateBtn{
         margin-top: 15px;
         margin-bottom: 15px;
         background-color: #382f24;
         width: 120px;
         height: 50px;
         border: none;
         font-size: medium;
         color: #f1ebd5;
      }
   </style>
</head>
<body>
   <nav class="navbar navbar-default">
      <div class="navbar-header">
         <button type="button" class="navbar-toggle collapsed"
                 data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                 aria-expanded="false">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
         </button>
         <a class="navbar-brand" href="main.jsp">HOTEL C&S</a>
      </div>
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
         <ul class="nav navbar-nav">
            <li><a href="main.jsp">HOME</a></li>
            <li><a href="Standard.jsp">객실 정보</a></li>
            <li><a href="reservation1.jsp">예약</a></li>
            <li><a href="check.jsp">예약내역</a></li>
            <li class="active"><a href="inquiryList.jsp">Q&A</a></li>
         </ul>
         <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
               <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                  접속하기 <span class="caret"></span>
               </a>
               <ul class="dropdown-menu">
                  <li class="active"><a href="login.jsp">로그인</a></li>
                  <li><a href="join.jsp">회원가입</a></li>
               </ul>
            </li>
         </ul>
      </div>
   </nav>

   <br/><br />
   <div id="detailcomment">
      호텔 C&S는 언제나 고객님의 목소리에 귀기울이고 있습니다.<br />
      고객님들의 소중한 충고와 격려, 또는 제안의 말씀을 주시면 더 나은 서비스로 보답하겠습니다.
   </div>

	<!-- 수정 폼 -->
   <form method="post" id="inquiryUpdateForm">
      <table align="center" class="inquiryDetail">
         <tr>
            <td id="detail" style="background-color: #EEEEEE;">TITLE</td>
            <td>
               <select name="typename" id="qtypesId" required="required">
                  <option value="1" <c:if test="${typename == '문의'}">selected</c:if>>문의</option>
                  <option value="2" <c:if test="${typename == '신청'}">selected</c:if>>신청</option>
                  <option value="3" <c:if test="${typename == '불만'}">selected</c:if>>불만</option>
                  <option value="4" <c:if test="${typename == '건의'}">selected</c:if>>건의</option>
                  <option value="5" <c:if test="${typename == '기타'}">selected</c:if>>기타</option>
               </select>
            </td>
         </tr>
         <tr>
            <td id="detail" style="background-color: #EEEEEE;">CONTENT</td>
            <td><textarea name="content" rows="20" cols="100" id="content" required="required">${content}</textarea></td>
         </tr>
         <tr align="center">
            <td colspan="2">
            
              <input type="hidden" name="questionsId" value="${questionsId}">
               <input type="button" class="btn" value="목록" onclick="location.href='/SpringHotel/inquiryList2.jsp'"/>
               <input type="button" id="updateBtn" value="수정완료"/>
               <input type="button" class="btn" value="취소" onclick="history.back();" />
            </td>
         </tr>
      </table>
   </form>


   <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
   <script src="/SpringHotel/resources/js/bootstrap.js"></script>
   <script src="/SpringHotel/resources/js/admin.js"></script>
   <%@ include file="../common/footer.jsp" %>
</body>
</html>
